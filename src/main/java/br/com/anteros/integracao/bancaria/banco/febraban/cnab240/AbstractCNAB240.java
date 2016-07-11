package br.com.anteros.integracao.bancaria.banco.febraban.cnab240;

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

import br.com.anteros.core.utils.Assert;
import br.com.anteros.flatfile.FlatFileManager;
import br.com.anteros.flatfile.FlatFileManagerException;
import br.com.anteros.flatfile.annotation.InnerRecord;
import br.com.anteros.flatfile.annotation.Record;
import br.com.anteros.integracao.bancaria.banco.febraban.CNABException;
import br.com.anteros.integracao.bancaria.banco.febraban.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.febraban.RemessaCobranca;
import br.com.anteros.integracao.bancaria.banco.febraban.RetornoCobranca;

public abstract class AbstractCNAB240 implements CNAB240 {

	@Record(name = HEADER, description = "Protocolo de comunicação", order = 1, groups = { REMESSA, RETORNO })
	protected HeaderArquivo headerArquivo;

	@Record(name = HEADER_LOTE_COBRANCA, description = "Cabeçalho lote de titulos cobrança", order = 2, groups = {
			REMESSA, RETORNO })
	protected HeaderTitulosCobranca headerTitulosCobranca;

	@Record(name = TITULO_COBRANCA_SEGMENTO_P, description = "Segmento P Remessa dos titulos cobrança", order = 3, repeatable = true, groups = {
			REMESSA })
	protected TitulosCobrancaSegmentoP segmentoP;

	@InnerRecord(name = TITULO_COBRANCA_SEGMENTO_Q, description = "Segmento Q Remessa dos titulos cobrança", recordOwner = TITULO_COBRANCA_SEGMENTO_P, order = 4, repeatable = true, groups = {
			REMESSA })
	protected TitulosCobrancaSegmentoQ segmentoQ;

	@Record(name = TITULO_COBRANCA_SEGMENTO_T, description = "Segmento T Retorno dos titulos cobrança", order = 5, repeatable = true, groups = {
			RETORNO })
	protected TitulosCobrancaSegmentoT segmentoT;

	@InnerRecord(name = TITULO_COBRANCA_SEGMENTO_U, description = "Segmento U Retorno dos titulos cobrança", order = 6, repeatable = true, groups = {
			RETORNO }, recordOwner = TITULO_COBRANCA_SEGMENTO_T)
	protected TitulosCobrancaSegmentoU segmentoU;

	@Record(name = TRAILLER_LOTE_COBRANCA, description = "Resumo lote de titulos cobrança", order = 7, groups = {
			REMESSA, RETORNO })
	protected TraillerTitulosCobranca traillerTitulosCobranca;

	@Record(name = TRAILLER, order = 8, groups = { REMESSA, RETORNO })
	protected TraillerArquivo traillerArquivo;

	private ContaBancaria contaBancaria;
	
	protected AbstractCNAB240(ContaBancaria contaBancaria, List<RemessaCobranca> remessas, Date dataHoraGeracao,
			Date dataGravacao) {
		Assert.notNull(remessas, "Informe as remessas para geração do arquivo.");
		if (remessas.size() == 0) {
			throw new CNABException("Informe as remessas para geração do arquivo.");
		}
		
		this.contaBancaria = contaBancaria;

		headerArquivo = HeaderArquivo.of(contaBancaria,
				remessas.get(CNAB240.PRIMEIRA_REMESSA).getTitulo().getCarteira(),
				remessas.get(CNAB240.PRIMEIRA_REMESSA).getTitulo().getCedente(), getVersaoLayoutArquivo(),
				dataHoraGeracao);
		headerTitulosCobranca = HeaderTitulosCobranca.of(contaBancaria,
				remessas.get(CNAB240.PRIMEIRA_REMESSA).getTitulo().getCarteira(),
				remessas.get(CNAB240.PRIMEIRA_REMESSA).getTitulo().getCedente(), getVersaoLayoutLote(), dataGravacao);
		segmentoP = TitulosCobrancaSegmentoP.of(contaBancaria, remessas);
		segmentoQ = TitulosCobrancaSegmentoQ.of(contaBancaria, remessas);
		segmentoT = TitulosCobrancaSegmentoT.of(contaBancaria);
		segmentoU = TitulosCobrancaSegmentoU.of(contaBancaria);
		traillerTitulosCobranca = TraillerTitulosCobranca.of(contaBancaria, remessas);
		traillerArquivo = TraillerArquivo.of(contaBancaria);
	}

	protected AbstractCNAB240(ContaBancaria contaBancaria, Date dataHoraGeracao, Date dataGravacao) {
		this.contaBancaria = contaBancaria;

		headerArquivo = HeaderArquivo.of(contaBancaria, dataHoraGeracao);
		headerTitulosCobranca = HeaderTitulosCobranca.of(contaBancaria, dataGravacao);
		segmentoT = TitulosCobrancaSegmentoT.of(contaBancaria);
		segmentoU = TitulosCobrancaSegmentoU.of(contaBancaria);
		traillerTitulosCobranca = TraillerTitulosCobranca.of(contaBancaria);
		traillerArquivo = TraillerArquivo.of(contaBancaria);
	}

	public byte[] generate() throws FlatFileManagerException, JAXBException, IllegalArgumentException,
			IllegalAccessException, IOException {
		return generate(new String[] { GLOBAL });
	}

	public byte[] generate(String[] groups) throws FlatFileManagerException, JAXBException, IllegalArgumentException,
			IllegalAccessException, IOException {
		FlatFileManager manager = new FlatFileManager();
		return manager.generate(this, groups);
	}

	public List<RetornoCobranca> read(File file) throws IOException, IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException {
		return read(new FileInputStream(file), new String[] { GLOBAL });
	}

	public List<RetornoCobranca> read(InputStream dataInputStream) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException {
		return read(dataInputStream, new String[] { GLOBAL });
	}

	public List<RetornoCobranca> read(byte[] data) throws IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException, IOException {
		return read(new ByteArrayInputStream(data), new String[] { GLOBAL });
	}

	public List<RetornoCobranca> read(File file, String[] groups) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException {
		return read(new FileInputStream(file), groups);
	}

	public List<RetornoCobranca> read(InputStream dataInputStream, String[] groups) throws IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException, IOException {

		FlatFileManager manager = new FlatFileManager();
		br.com.anteros.flatfile.FlatFile<br.com.anteros.flatfile.Record> flatFile = manager.read(this, groups,
				dataInputStream);
		List<RetornoCobranca> result = new ArrayList<RetornoCobranca>();

		headerArquivo.set(flatFile.getRecord(HEADER));
		headerTitulosCobranca.set(flatFile.getRecord(HEADER_LOTE_COBRANCA));

		Iterator<br.com.anteros.flatfile.Record> iteratorT = flatFile.getRecords(TITULO_COBRANCA_SEGMENTO_T).iterator();
		while (iteratorT.hasNext()) {
			br.com.anteros.flatfile.Record recordT = iteratorT.next();
			segmentoT.set(recordT);
			if (recordT.getInnerRecords().size() != 1)
				throw new CNABException("Número de registros filhos para o Registro T incorreto.");
			segmentoU.set(recordT.getInnerRecords().iterator().next());
			result.add(RetornoCobranca.of(contaBancaria, segmentoT, segmentoU));
		}

		traillerTitulosCobranca.set(flatFile.getRecord(TRAILLER_LOTE_COBRANCA));
		traillerArquivo.set(flatFile.getRecord(TRAILLER));

		return result;
	}

	public List<RetornoCobranca> read(byte[] data, String[] groups) throws IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException, IOException {
		return read(new ByteArrayInputStream(data), groups);
	}

	public byte[] getXMLSchema() throws FlatFileManagerException, JAXBException {
		return new FlatFileManager().getXMLSchema(this);
	}
	
	public abstract int getVersaoLayoutArquivo();
	
	public abstract int getVersaoLayoutLote();

}
