package br.com.anteros.integracao.bancaria.banco.layout.cnab240.extrato.bancobrasil.v87;

import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CONCILIACAO_BANCARIA_SEGMENTO_E;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.GLOBAL;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.HEADER;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.HEADER_CONCILIACAO_BANCARIA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.RETORNO_CONCILIACAO_BANCARIA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.TRAILLER;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.TRAILLER_CONCILIACAO_BANCARIA;

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
import br.com.anteros.flatfile.annotation.Record;
import br.com.anteros.integracao.bancaria.banco.layout.ConciliacaoBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.CNAB240Extrato;

@FlatFile(name = "Arquivo CNAB240 - Banco do Brasil", description = "Arquivo de retorno CONCILIAÇÃO BANCÁRIA CNAB240", version = "1.0")
public class BancoBrasilCNAB240Extrato implements CNAB240Extrato {

	@Record(name = HEADER, description = "Protocolo de comunicação", order = 1, groups = {
			RETORNO_CONCILIACAO_BANCARIA })
	protected HeaderArquivo headerArquivo;

	/**
	 * CONCILIAÇÃO BANCÁRIA
	 */
	@Record(name = HEADER_CONCILIACAO_BANCARIA, description = "Cabeçalho conciliação bancária", order = 8, groups = {
			RETORNO_CONCILIACAO_BANCARIA })
	protected HeaderConciliacaoBancaria headerConciliacaoBancaria;

	@Record(name = CONCILIACAO_BANCARIA_SEGMENTO_E, description = "Segmento E Conciliação bancária", order = 9, repeatable = true, groups = {
			RETORNO_CONCILIACAO_BANCARIA })
	protected ConciliacaoBancariaSegmentoE segmentoE;

	@Record(name = TRAILLER_CONCILIACAO_BANCARIA, description = "Resumo lote de cobrança", order = 10, groups = {
			RETORNO_CONCILIACAO_BANCARIA })
	protected TraillerConciliacaoBancaria traillerConciliacaoBancaria;

	@Record(name = TRAILLER, order = 11, groups = { RETORNO_CONCILIACAO_BANCARIA })
	protected TraillerArquivo traillerArquivo;

	private ContaBancaria contaBancaria;
	
	protected BancoBrasilCNAB240Extrato(ContaBancaria contaBancaria, Date dataHoraGeracao) {
		this.contaBancaria = contaBancaria;
		headerArquivo = HeaderArquivo.of(contaBancaria, dataHoraGeracao);
		headerConciliacaoBancaria = HeaderConciliacaoBancaria.of(contaBancaria);
		segmentoE = ConciliacaoBancariaSegmentoE.of(contaBancaria);
		traillerConciliacaoBancaria = TraillerConciliacaoBancaria.of(contaBancaria);
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

	@Override
	public byte[] getXMLSchema() throws FlatFileManagerException, JAXBException {
		return new FlatFileManager().getXMLSchema(this);
	}

	@Override
	public List<ConciliacaoBancaria> read(File file) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException {
		return read(new FileInputStream(file), new String[] { GLOBAL });
	}

	@Override
	public List<ConciliacaoBancaria> read(InputStream dataInputStream) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException {
		return read(dataInputStream, new String[] { GLOBAL });
	}

	@Override
	public List<ConciliacaoBancaria> read(byte[] data) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException {
		return read(new ByteArrayInputStream(data), new String[] { GLOBAL });
	}

	@Override
	public List<ConciliacaoBancaria> read(File file, String[] groups) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException {
		return read(new FileInputStream(file), groups);
	}

	@Override
	public List<ConciliacaoBancaria> read(InputStream dataInputStream, String[] groups) throws IOException,
			IllegalArgumentException, IllegalAccessException, FlatFileManagerException, JAXBException {
		FlatFileManager manager = new FlatFileManager();
		br.com.anteros.flatfile.FlatFile<br.com.anteros.flatfile.Record> flatFile = manager.read(groups,
				dataInputStream);
		List<ConciliacaoBancaria> result = new ArrayList<ConciliacaoBancaria>();

		ConciliacaoBancaria conciliacaoBancaria = ConciliacaoBancaria.of(contaBancaria);
		result.add(conciliacaoBancaria);

		headerArquivo.set(flatFile.getRecord(HEADER));
		headerConciliacaoBancaria.set(flatFile.getRecord(HEADER_CONCILIACAO_BANCARIA));

		conciliacaoBancaria.set(headerConciliacaoBancaria);

		Iterator<br.com.anteros.flatfile.Record> iteratorLancamentos = flatFile
				.getRecords(CONCILIACAO_BANCARIA_SEGMENTO_E).iterator();
		while (iteratorLancamentos.hasNext()) {
			br.com.anteros.flatfile.Record lancamento = iteratorLancamentos.next();
			segmentoE.set(lancamento);
			conciliacaoBancaria.add(segmentoE);
		}

		traillerConciliacaoBancaria.set(flatFile.getRecord(TRAILLER_CONCILIACAO_BANCARIA));
		conciliacaoBancaria.set(traillerConciliacaoBancaria);
		traillerArquivo.set(flatFile.getRecord(TRAILLER));

		return result;
	}

	@Override
	public List<ConciliacaoBancaria> read(byte[] data, String[] groups) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException {
		return read(new ByteArrayInputStream(data), groups);
	}

	public static CNAB240Extrato of(ContaBancaria contaBancaria, Date dataHoraGeracao) {
		return new BancoBrasilCNAB240Extrato(contaBancaria, dataHoraGeracao);
	}

}
