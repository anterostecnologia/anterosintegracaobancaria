package br.com.anteros.integracao.bancaria.banco.febraban.cnab400.bancobrasil;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.bind.JAXBException;

import br.com.anteros.core.utils.Assert;
import br.com.anteros.flatfile.FlatFileManager;
import br.com.anteros.flatfile.FlatFileManagerException;
import br.com.anteros.flatfile.annotation.Record;
import br.com.anteros.integracao.bancaria.banco.febraban.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.febraban.RemessaCobranca;
import br.com.anteros.integracao.bancaria.banco.febraban.RetornoCobranca;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.CNABException;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab400.CNAB400;


public class BancoBrasilCNAB400 implements CNAB400 {

	public static final String HEADER_REMESSA = "HeaderRemessa";
	public static final String TITULO_COBRANCA_DETALHE_REMESSA = "TituloCobrancaDetalheRemessa";
	public static final String TRAILLER_REMESSA = "TraillerRemessa";

	public static final String HEADER_RETORNO = "HeaderRetorno";
	public static final String TITULO_COBRANCA_DETALHE_RETORNO = "TituloCobrancaDetalheRetorno";
	public static final String TRAILLER_RETORNO = "TraillerRetorno";

	/**
	 * REMESSA
	 */

	@Record(name = HEADER_REMESSA, description = "Protocolo de comunicação", order = 1, groups = { "REMESSA" })
	private HeaderArquivoRemessa headerArquivoRemessa;

	@Record(name = TITULO_COBRANCA_DETALHE_REMESSA, description = "Detalhe Remessa dos titulos cobrança", order = 3, repeatable = true, groups = {
			"REMESSA" })
	private TitulosCobrancaDetalheRemessa detalheRemessa;

	@Record(name = TRAILLER_REMESSA, description = "Protocolo de comunicação", order = 1, groups = { "REMESSA" })
	private TraillerArquivoRemessa traillerArquivoRemessa;

	/**
	 * RETORNO
	 */

	@Record(name = HEADER_RETORNO, description = "Protocolo de comunicação", order = 1, groups = { "RETORNO" })
	private HeaderArquivoRetorno headerArquivoRetorno;

	@Record(name = TITULO_COBRANCA_DETALHE_RETORNO, description = "Detalhe Retorno dos titulos cobrança", order = 3, repeatable = true, groups = {
			"RETORNO" })
	private TitulosCobrancaDetalheRetorno detalheRetorno;

	@Record(name = TRAILLER_RETORNO, description = "Resumo do arquivo de Retorno", order = 1, groups = { "RETORNO" })
	private TraillerArquivoRetorno traillerArquivoRetorno;
	private List<RemessaCobranca> remessas;

	public BancoBrasilCNAB400(ContaBancaria contaBancaria, List<RemessaCobranca> remessas) {
		Assert.notNull(remessas, "Informe as remessas para geração do arquivo.");
		if (remessas.size() == 0) {
			throw new CNABException("Informe as remessas para geração do arquivo.");
		}
		this.remessas = remessas;
		headerArquivoRemessa = HeaderArquivoRemessa.of(contaBancaria,
				remessas.get(CNAB400.PRIMEIRA_REMESSA).getTitulo().getCarteira(),
				remessas.get(CNAB400.PRIMEIRA_REMESSA).getTitulo().getCedente());
		detalheRemessa = TitulosCobrancaDetalheRemessa.of(contaBancaria, remessas);
		traillerArquivoRemessa = TraillerArquivoRemessa.of(contaBancaria, remessas);

		headerArquivoRetorno = HeaderArquivoRetorno.of(contaBancaria);
		detalheRetorno = TitulosCobrancaDetalheRetorno.of(contaBancaria);
		traillerArquivoRetorno = TraillerArquivoRetorno.of(contaBancaria);
	}

	public BancoBrasilCNAB400(ContaBancaria contaBancaria) {
		headerArquivoRetorno = HeaderArquivoRetorno.of(contaBancaria);
		detalheRetorno = TitulosCobrancaDetalheRetorno.of(contaBancaria);
		traillerArquivoRetorno = TraillerArquivoRetorno.of(contaBancaria);
	}

	public byte[] generate() throws FlatFileManagerException, JAXBException, IllegalArgumentException,
			IllegalAccessException, IOException {
		return generate(new String[] { "GLOBAL" });
	}

	public byte[] generate(String[] groups) throws FlatFileManagerException, JAXBException, IllegalArgumentException,
			IllegalAccessException, IOException {
		Assert.notNull(remessas, "Informe as remessas para geração do arquivo.");
		if (remessas.size() == 0) {
			throw new CNABException("Informe as remessas para geração do arquivo.");
		}
		FlatFileManager manager = new FlatFileManager();
		return manager.generate(this, groups);
	}

	public List<RetornoCobranca> read(File file) throws IOException, IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException {
		return read(new FileInputStream(file), new String[] { "GLOBAL" });
	}

	public List<RetornoCobranca> read(InputStream dataInputStream) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException {
		return read(dataInputStream, new String[] { "GLOBAL" });
	}

	public List<RetornoCobranca> read(byte[] data) throws IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException, IOException {
		return read(new ByteArrayInputStream(data), new String[] { "GLOBAL" });
	}

	public List<RetornoCobranca> read(File file, String[] groups) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException {
		return read(new FileInputStream(file), groups);
	}

	public List<RetornoCobranca> read(InputStream dataInputStream, String[] groups) throws IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException, IOException {
		
		FlatFileManager manager = new FlatFileManager();
		br.com.anteros.flatfile.FlatFile<br.com.anteros.flatfile.Record> flatFile = manager.read(this, groups, dataInputStream);

		headerArquivoRetorno.set(flatFile.getRecord(HEADER_RETORNO));
		detalheRetorno.set(flatFile.getRecords(TITULO_COBRANCA_DETALHE_RETORNO));
		traillerArquivoRetorno.set(flatFile.getRecord(TRAILLER_RETORNO));

		return null;
		
		
		
		
	}

	public List<RetornoCobranca> read(byte[] data, String[] groups) throws IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException, IOException {
		return read(new ByteArrayInputStream(data), groups);
	}

}
