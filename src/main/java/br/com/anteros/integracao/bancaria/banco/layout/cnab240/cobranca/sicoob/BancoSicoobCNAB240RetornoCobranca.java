package br.com.anteros.integracao.bancaria.banco.layout.cnab240.cobranca.sicoob;

import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBException;

import br.com.anteros.flatfile.FlatFileManager;
import br.com.anteros.flatfile.FlatFileManagerException;
import br.com.anteros.flatfile.annotation.FlatFile;
import br.com.anteros.flatfile.annotation.InnerRecord;
import br.com.anteros.flatfile.annotation.Record;
import br.com.anteros.integracao.bancaria.banco.layout.CNABException;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.RetornoCobranca;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.CNAB240Cobranca;

@FlatFile(name = "Arquivo CNAB240 - Banco Sicoob", description = "Arquivo de retorno COBRANÇA CNAB240", version = "1.0")
public class BancoSicoobCNAB240RetornoCobranca implements CNAB240Cobranca {
	
	@Record(name = HEADER, description = "Protocolo de comunicação", order = 1, groups = { RETORNO_COBRANCA })
	protected HeaderArquivo headerArquivo;

	@Record(name = HEADER_COBRANCA, description = "Cabeçalho lote de cobrança", order = 2, groups = { RETORNO_COBRANCA })
	protected HeaderCobranca headerCobranca;
	
	@Record(name = COBRANCA_SEGMENTO_T, description = "Segmento T Retorno dos titulos cobrança", order = 3, repeatable = true, groups = {RETORNO_COBRANCA })
	protected CobrancaSegmentoT segmentoT;
	
	@InnerRecord(name = COBRANCA_SEGMENTO_U, description = "Segmento U Retorno dos titulos cobrança", recordOwner = COBRANCA_SEGMENTO_T, order = 4, repeatable = true, groups = {RETORNO_COBRANCA })
	protected CobrancaSegmentoU segmentoU;
	
	@Record(name = TRAILLER_COBRANCA, description = "Resumo lote de cobrança", order = 5, groups = { RETORNO_COBRANCA })
	protected TraillerCobranca traillerCobranca;

	@Record(name = TRAILLER, order = 6, groups = { RETORNO_COBRANCA })
	protected TraillerArquivo traillerArquivo;
	
	private ContaBancaria contaBancaria;

	protected BancoSicoobCNAB240RetornoCobranca(ContaBancaria contaBancaria, Date dataHoraGeracao, Date dataGravacao) {
		this.contaBancaria = contaBancaria;
		headerArquivo = HeaderArquivo.of(contaBancaria, dataHoraGeracao);
		headerCobranca = HeaderCobranca.of(contaBancaria, dataGravacao);
		segmentoT = CobrancaSegmentoT.of(contaBancaria);
		segmentoU = CobrancaSegmentoU.of(contaBancaria);
		traillerCobranca = TraillerCobranca.of(contaBancaria);
		traillerArquivo = TraillerArquivo.of(contaBancaria);
	}
	
	@Override
	public byte[] generate() throws FlatFileManagerException, JAXBException, IllegalArgumentException,
			IllegalAccessException, IOException {
		return generate(new String[] { GLOBAL });
	}

	@Override
	public byte[] generate(String[] groups) throws FlatFileManagerException, JAXBException, IllegalArgumentException,
			IllegalAccessException, IOException {
		FlatFileManager manager = new FlatFileManager();
		return manager.generate(this, groups);
	}
	
	public static BancoSicoobCNAB240RetornoCobranca of(ContaBancaria contaBancaria, Date dataHoraGeracao, Date dataGravacao) {
		return new BancoSicoobCNAB240RetornoCobranca(contaBancaria, dataHoraGeracao, dataGravacao);
	}

	@Override
	public byte[] getXMLSchema() throws FlatFileManagerException, JAXBException {
		return new FlatFileManager().getXMLSchema(this);
	}

	@Override
	public List<RetornoCobranca> read(File file, String[] groups) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException {
		return read(new FileInputStream(file), groups);
	}

	@Override
	public List<RetornoCobranca> read(File file) throws IOException, IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException {
		return read(new FileInputStream(file), new String[] { GLOBAL });
	}

	@Override
	public List<RetornoCobranca> read(InputStream dataInputStream) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException {
		return read(dataInputStream, new String[] { GLOBAL });
	}

	@Override
	public List<RetornoCobranca> read(byte[] data) throws IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException, IOException {
		return read(new ByteArrayInputStream(data), new String[] { GLOBAL });
	}

	@Override
	public List<RetornoCobranca> read(InputStream dataInputStream, String[] groups) throws IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException, IOException {
		FlatFileManager manager = new FlatFileManager();
		br.com.anteros.flatfile.FlatFile<br.com.anteros.flatfile.Record> flatFile = manager.read(this, dataInputStream, groups);
		List<RetornoCobranca> result = new ArrayList<RetornoCobranca>();

		headerArquivo.set(flatFile.getRecord(HEADER));
		headerCobranca.set(flatFile.getRecord(HEADER_COBRANCA));

		Iterator<br.com.anteros.flatfile.Record> iteratorT = flatFile.getRecords(COBRANCA_SEGMENTO_T).iterator();
		while (iteratorT.hasNext()) {
			br.com.anteros.flatfile.Record recordT = iteratorT.next();
			segmentoT.set(recordT);
			
			if (recordT.getInnerRecords().size() != 1)
				throw new CNABException("Número de registros filhos para o Registro T incorreto.");
			
			segmentoU.set(recordT.getInnerRecords().iterator().next());
			
			result.add(RetornoCobranca.of(contaBancaria, segmentoT, segmentoU));
		}

		traillerCobranca.set(flatFile.getRecord(TRAILLER_COBRANCA));
		traillerArquivo.set(flatFile.getRecord(TRAILLER));

		return result;
	}

	@Override
	public List<RetornoCobranca> read(byte[] data, String[] groups) throws IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException, IOException {
		return read(new ByteArrayInputStream(data), groups);
	}

}
