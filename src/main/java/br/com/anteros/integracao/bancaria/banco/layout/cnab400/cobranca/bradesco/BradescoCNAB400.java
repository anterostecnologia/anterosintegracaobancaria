package br.com.anteros.integracao.bancaria.banco.layout.cnab400.cobranca.bradesco;

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
import br.com.anteros.flatfile.annotation.FlatFile;
import br.com.anteros.flatfile.annotation.Record;
import br.com.anteros.integracao.bancaria.banco.layout.CNABException;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.RemessaCobranca;
import br.com.anteros.integracao.bancaria.banco.layout.RetornoCobranca;
import br.com.anteros.integracao.bancaria.banco.layout.cnab400.cobranca.CNAB400;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.*;

@FlatFile(name = "Arquivo CNAB400 - Bradesco", description = "Arquivo de remessa/retorno CNAB400", version = "1.0")
public class BradescoCNAB400 implements CNAB400 {

	public static final String HEADER_REMESSA = "HeaderRemessa";
	public static final String TITULO_COBRANCA_DETALHE_REMESSA = "TituloCobrancaDetalheRemessa";
	public static final String TRAILLER_REMESSA = "TraillerRemessa";

	public static final String HEADER_RETORNO = "HeaderRetorno";
	public static final String TITULO_COBRANCA_DETALHE_RETORNO = "TituloCobrancaDetalheRetorno";
	public static final String TRAILLER_RETORNO = "TraillerRetorno";

	/**
	 * REMESSA
	 */

	@Record(name = HEADER_REMESSA, description = "Protocolo de comunicação", order = 1, groups = { REMESSA_COBRANCA })
	private HeaderArquivoRemessa headerArquivoRemessa;

	@Record(name = TITULO_COBRANCA_DETALHE_REMESSA, description = "Detalhe Remessa dos titulos cobrança", order = 2, repeatable = true, groups = {
			REMESSA_COBRANCA })
	private TitulosCobrancaDetalheRemessa detalheRemessa;

	@Record(name = TRAILLER_REMESSA, description = "Protocolo de comunicação", order = 4, groups = { REMESSA_COBRANCA })
	private TraillerArquivoRemessa traillerArquivoRemessa;

	/**
	 * RETORNO
	 */

	@Record(name = HEADER_RETORNO, description = "Protocolo de comunicação", order = 5, groups = { RETORNO_COBRANCA })
	private HeaderArquivoRetorno headerArquivoRetorno;

	@Record(name = TITULO_COBRANCA_DETALHE_RETORNO, description = "Detalhe Retorno dos titulos cobrança", order = 6, repeatable = true, groups = {
			RETORNO_COBRANCA })
	private TitulosCobrancaDetalheRetorno detalheRetorno;

	@Record(name = TRAILLER_RETORNO, description = "Resumo do arquivo de Retorno", order = 7, groups = { RETORNO_COBRANCA })
	private TraillerArquivoRetorno traillerArquivoRetorno;

	private List<RemessaCobranca> remessas;
	private ContaBancaria contaBancaria;

	public BradescoCNAB400(ContaBancaria contaBancaria, List<RemessaCobranca> remessas, Date dataHoraGeracao,
			Date dataGravacao) {
		Assert.notNull(remessas, "Informe as remessas para geração do arquivo.");
		if (remessas.size() == 0) {
			throw new CNABException("Informe as remessas para geração do arquivo.");
		}
		this.remessas = remessas;
		this.contaBancaria = contaBancaria;
		headerArquivoRemessa = HeaderArquivoRemessa.of(contaBancaria,
				remessas.get(PRIMEIRA_REMESSA).getTitulo().getCarteira(),
				remessas.get(PRIMEIRA_REMESSA).getTitulo().getCedente(), dataHoraGeracao, dataGravacao);
		detalheRemessa = TitulosCobrancaDetalheRemessa.of(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
		traillerArquivoRemessa = TraillerArquivoRemessa.of(contaBancaria, remessas, dataHoraGeracao, dataGravacao);

		headerArquivoRetorno = HeaderArquivoRetorno.of(contaBancaria);
		detalheRetorno = TitulosCobrancaDetalheRetorno.of(contaBancaria);
		traillerArquivoRetorno = TraillerArquivoRetorno.of(contaBancaria);
	}

	public BradescoCNAB400(ContaBancaria contaBancaria, Date dataHoraGeracao, Date dataGravacao) {
		headerArquivoRetorno = HeaderArquivoRetorno.of(contaBancaria);
		detalheRetorno = TitulosCobrancaDetalheRetorno.of(contaBancaria);
		traillerArquivoRetorno = TraillerArquivoRetorno.of(contaBancaria);
	}

	public byte[] generate() throws FlatFileManagerException, JAXBException, IllegalArgumentException,
			IllegalAccessException, IOException {
		return generate(GLOBAL);
	}

	public byte[] generate(String group) throws FlatFileManagerException, JAXBException, IllegalArgumentException,
			IllegalAccessException, IOException {
		Assert.notNull(remessas, "Informe as remessas para geração do arquivo.");
		if (remessas.size() == 0) {
			throw new CNABException("Informe as remessas para geração do arquivo.");
		}
		FlatFileManager manager = new FlatFileManager();
		return manager.generate(this, new String[] { group });
	}

	public List<RetornoCobranca> read(File file) throws IOException, IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException {
		return read(new FileInputStream(file), GLOBAL);
	}

	public List<RetornoCobranca> read(InputStream dataInputStream) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException {
		return read(dataInputStream, GLOBAL);
	}

	public List<RetornoCobranca> read(byte[] data) throws IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException, IOException {
		return read(new ByteArrayInputStream(data), GLOBAL);
	}

	public List<RetornoCobranca> read(File file, String group) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException {
		return read(new FileInputStream(file), group);
	}

	public List<RetornoCobranca> read(InputStream dataInputStream, String group) throws IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException, IOException {

		FlatFileManager manager = new FlatFileManager();
		br.com.anteros.flatfile.FlatFile<br.com.anteros.flatfile.Record> flatFile = manager.read(this,
				new String[] { group }, dataInputStream);

		headerArquivoRetorno.set(flatFile.getRecord(HEADER_RETORNO));
		traillerArquivoRetorno.set(flatFile.getRecord(TRAILLER_RETORNO));

		List<RetornoCobranca> result = new ArrayList<RetornoCobranca>();

		Iterator<br.com.anteros.flatfile.Record> iteratorT = flatFile.getRecords(TITULO_COBRANCA_DETALHE_RETORNO)
				.iterator();
		while (iteratorT.hasNext()) {
			br.com.anteros.flatfile.Record record = iteratorT.next();
			detalheRetorno.set(record);
			result.add(RetornoCobranca.of(contaBancaria, detalheRetorno));
		}

		return result;
	}

	public List<RetornoCobranca> read(byte[] data, String group) throws IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException, IOException {
		return read(new ByteArrayInputStream(data), group);
	}

	public static CNAB400 of(ContaBancaria contaBancaria, List<RemessaCobranca> remessas, Date dataHoraGeracao,
			Date dataGravacao) {
		return new BradescoCNAB400(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
	}

	public static CNAB400 of(ContaBancaria contaBancaria, List<RemessaCobranca> remessas) {
		return new BradescoCNAB400(contaBancaria, remessas, new Date(), new Date());
	}

	public static CNAB400 of(ContaBancaria contaBancaria, Date dataHoraGeracao, Date dataGravacao) {
		return new BradescoCNAB400(contaBancaria, dataHoraGeracao, dataGravacao);
	}

	public byte[] getXMLSchema() throws FlatFileManagerException, JAXBException {
		return new FlatFileManager().getXMLSchema(this);
	}

}
