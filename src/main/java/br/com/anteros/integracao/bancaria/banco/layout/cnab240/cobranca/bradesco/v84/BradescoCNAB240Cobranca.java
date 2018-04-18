package br.com.anteros.integracao.bancaria.banco.layout.cnab240.cobranca.bradesco.v84;

import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.COBRANCA_SEGMENTO_P;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.COBRANCA_SEGMENTO_Q;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.COBRANCA_SEGMENTO_T;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.COBRANCA_SEGMENTO_U;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.GLOBAL;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.HEADER;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.HEADER_COBRANCA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.PRIMEIRA_REMESSA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.REMESSA_COBRANCA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.RETORNO_COBRANCA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.TRAILLER;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.TRAILLER_COBRANCA;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBException;

import br.com.anteros.core.utils.Assert;
import br.com.anteros.flatfile.FlatFileManager;
import br.com.anteros.flatfile.FlatFileManagerException;
import br.com.anteros.flatfile.annotation.FlatFile;
import br.com.anteros.flatfile.annotation.InnerRecord;
import br.com.anteros.flatfile.annotation.Record;
import br.com.anteros.integracao.bancaria.banco.layout.CNABException;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.RemessaCobranca;
import br.com.anteros.integracao.bancaria.banco.layout.RetornoCobranca;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.CNAB240Cobranca;

@FlatFile(name = "Arquivo CNAB240 - Bradesco", description = "Arquivo de remessa/retorno COBRANÇA CNAB240", version = "1.0")
public class BradescoCNAB240Cobranca implements CNAB240Cobranca {

	private static final int VERSAO_LAYOUT_ARQUIVO_BRADESCO = 84;
	private static final int VERSAO_LAYOUT_LOTE_BRADESCO = 42;

	@Record(name = HEADER, description = "Protocolo de comunicação", order = 1, groups = { REMESSA_COBRANCA,
			RETORNO_COBRANCA })
	protected HeaderArquivo headerArquivo;

	/**
	 * COBRANÇA
	 */

	@Record(name = HEADER_COBRANCA, description = "Cabeçalho lote de cobrança", order = 2, groups = { REMESSA_COBRANCA,
			RETORNO_COBRANCA })
	protected HeaderCobranca headerCobranca;

	@Record(name = COBRANCA_SEGMENTO_P, description = "Segmento P Remessa dos titulos cobrança", order = 3, repeatable = true, groups = {
			REMESSA_COBRANCA })
	protected CobrancaSegmentoP segmentoP;

	@InnerRecord(name = COBRANCA_SEGMENTO_Q, description = "Segmento Q Remessa dos titulos cobrança", recordOwner = COBRANCA_SEGMENTO_P, order = 4, repeatable = true, groups = {
			REMESSA_COBRANCA })
	protected CobrancaSegmentoQ segmentoQ;

	@Record(name = COBRANCA_SEGMENTO_T, description = "Segmento T Retorno dos titulos cobrança", order = 5, repeatable = true, groups = {
			RETORNO_COBRANCA })
	protected CobrancaSegmentoT segmentoT;

	@InnerRecord(name = COBRANCA_SEGMENTO_U, description = "Segmento U Retorno dos titulos cobrança", order = 6, repeatable = true, groups = {
			RETORNO_COBRANCA }, recordOwner = COBRANCA_SEGMENTO_T)
	protected CobrancaSegmentoU segmentoU;

	@Record(name = TRAILLER_COBRANCA, description = "Resumo lote de cobrança", order = 7, groups = { REMESSA_COBRANCA,
			RETORNO_COBRANCA })
	protected TraillerCobranca traillerCobranca;

	@Record(name = TRAILLER, order = 11, groups = { REMESSA_COBRANCA, RETORNO_COBRANCA })
	protected TraillerArquivo traillerArquivo;

	private ContaBancaria contaBancaria;

	protected BradescoCNAB240Cobranca(ContaBancaria contaBancaria, List<RemessaCobranca> remessas, Date dataHoraGeracao,
			Date dataGravacao) {
		Assert.notNull(remessas, "Informe as remessas para geração do arquivo.");
		if (remessas.size() == 0) {
			throw new CNABException("Informe as remessas para geração do arquivo.");
		}

		this.contaBancaria = contaBancaria;

		headerArquivo = HeaderArquivo.of(contaBancaria, remessas.get(PRIMEIRA_REMESSA).getTitulo().getCarteira(),
				remessas.get(PRIMEIRA_REMESSA).getTitulo().getCedente(), getVersaoLayoutArquivo(), dataHoraGeracao);
		headerCobranca = HeaderCobranca.of(contaBancaria, remessas.get(PRIMEIRA_REMESSA).getTitulo().getCarteira(),
				remessas.get(PRIMEIRA_REMESSA).getTitulo().getCedente(), getVersaoLayoutLote(), dataGravacao);
		segmentoP = CobrancaSegmentoP.of(contaBancaria, remessas);
		segmentoQ = CobrancaSegmentoQ.of(contaBancaria, remessas);
		segmentoT = CobrancaSegmentoT.of(contaBancaria);
		segmentoU = CobrancaSegmentoU.of(contaBancaria);
		traillerCobranca = TraillerCobranca.of(contaBancaria, remessas);
		traillerArquivo = TraillerArquivo.of(contaBancaria);
	}

	protected BradescoCNAB240Cobranca(ContaBancaria contaBancaria, Date dataHoraGeracao, Date dataGravacao) {
		this.contaBancaria = contaBancaria;
		headerArquivo = HeaderArquivo.of(contaBancaria, dataHoraGeracao);
		headerCobranca = HeaderCobranca.of(contaBancaria, dataGravacao);
		segmentoT = CobrancaSegmentoT.of(contaBancaria);
		segmentoU = CobrancaSegmentoU.of(contaBancaria);
		traillerCobranca = TraillerCobranca.of(contaBancaria);
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

	public byte[] getXMLSchema() throws FlatFileManagerException, JAXBException {
		return new FlatFileManager().getXMLSchema(this);
	}

	public static BradescoCNAB240Cobranca of(ContaBancaria contaBancaria, List<RemessaCobranca> remessas,
			Date dataHoraGeracao, Date dataGravacao) {
		return new BradescoCNAB240Cobranca(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
	}

	public static BradescoCNAB240Cobranca of(ContaBancaria contaBancaria, Date dataHoraGeracao, Date dataGravacao) {
		return new BradescoCNAB240Cobranca(contaBancaria, dataHoraGeracao, dataGravacao);
	}

	public static BradescoCNAB240Cobranca of(ContaBancaria contaBancaria, List<RemessaCobranca> remessas) {
		return new BradescoCNAB240Cobranca(contaBancaria, remessas, Calendar.getInstance().getTime(),
				Calendar.getInstance().getTime());
	}

	public static BradescoCNAB240Cobranca of(ContaBancaria contaBancaria) {
		return new BradescoCNAB240Cobranca(contaBancaria, Calendar.getInstance().getTime(),
				Calendar.getInstance().getTime());
	}

	public int getVersaoLayoutArquivo() {
		return VERSAO_LAYOUT_ARQUIVO_BRADESCO;
	}

	public int getVersaoLayoutLote() {
		return VERSAO_LAYOUT_LOTE_BRADESCO;
	}

	@Override
	public List<RetornoCobranca> read(File file) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException {
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
	public List<RetornoCobranca> read(File file, String[] groups) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException {
		return read(new FileInputStream(file), groups);
	}

    @Override
	public List<RetornoCobranca> read(InputStream dataInputStream, String[] groups)
			throws IllegalArgumentException, IllegalAccessException, FlatFileManagerException, JAXBException,
			IOException {

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
			//result.add(RetornoCobranca.of(contaBancaria, segmentoT, segmentoU));
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
