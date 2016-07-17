package br.com.anteros.integracao.bancaria.banco.layout.cnab200.extrato.bancobrasil;

import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.RETORNO_CONCILIACAO_BANCARIA;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBException;

import br.com.anteros.flatfile.FlatFileManager;
import br.com.anteros.flatfile.FlatFileManagerException;
import br.com.anteros.flatfile.annotation.FlatFile;
import br.com.anteros.flatfile.annotation.Record;
import br.com.anteros.integracao.bancaria.banco.layout.ConciliacaoBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.cnab200.extrato.CNAB200;


@FlatFile(name = "Arquivo CNAB200", description = "Arquivo de retorno conciliação bancária CNAB200", version = "1.0")
public class BancoBrasilCNAB200 implements CNAB200 {

	public static final String HEADER = "HeaderRetorno";
	public static final String SALDO_ANTERIOR = "SaldoAnteriorRetorno";
	public static final String CONCILIACAO_DETALHE = "ConciliacaoDetalheRetorno";
	public static final String SALDO_ATUAL = "SaldoAtualRetorno";
	public static final String TRAILLER = "TraillerRetorno";

	@Record(name = HEADER, description = "Protocolo de comunicação", order = 1, groups = { RETORNO_CONCILIACAO_BANCARIA })
	private HeaderArquivo headerArquivo;

	@Record(name = SALDO_ANTERIOR, description = "Saldo anterior da conciliação bancária", order = 2, repeatable = false, groups = {
			RETORNO_CONCILIACAO_BANCARIA })
	private SaldoAnteriorRetorno saldoAnteriorRetorno;

	@Record(name = CONCILIACAO_DETALHE, description = "Detalhe da conciliação bancária", order = 3, repeatable = true, groups = {
			RETORNO_CONCILIACAO_BANCARIA })
	private ConciliacaoDetalheRetorno detalheRetorno;

	@Record(name = SALDO_ATUAL, description = "Saldo atual da conciliação bancária", order = 4, repeatable = false, groups = {
			RETORNO_CONCILIACAO_BANCARIA })
	private SaldoAtualRetorno saldoAtualRetorno;

	@Record(name = TRAILLER, description = "Resumo do arquivo de Retorno", order = 5, groups = { RETORNO_CONCILIACAO_BANCARIA })
	private TraillerArquivo trailler;

	private ContaBancaria contaBancaria;

	private BancoBrasilCNAB200(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
		headerArquivo = HeaderArquivo.of(contaBancaria);
		saldoAnteriorRetorno = SaldoAnteriorRetorno.of(contaBancaria);
		detalheRetorno = ConciliacaoDetalheRetorno.of(contaBancaria);
		saldoAtualRetorno = SaldoAtualRetorno.of(contaBancaria);
		trailler = TraillerArquivo.of(contaBancaria);
	}

	public List<ConciliacaoBancaria> read(File file) throws IOException, IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException {
		return read(new FileInputStream(file), new String[] { GLOBAL });
	}

	public List<ConciliacaoBancaria> read(InputStream dataInputStream) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException {
		return read(dataInputStream, new String[] { GLOBAL });
	}

	public List<ConciliacaoBancaria> read(byte[] data) throws IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException, IOException {
		return read(new ByteArrayInputStream(data), new String[] { GLOBAL });
	}

	public List<ConciliacaoBancaria> read(File file, String[] groups) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException {
		return read(new FileInputStream(file), groups);
	}

	public List<ConciliacaoBancaria> read(InputStream dataInputStream, String[] groups) throws IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException, IOException {

		FlatFileManager manager = new FlatFileManager();
		br.com.anteros.flatfile.FlatFile<br.com.anteros.flatfile.Record> flatFile = manager.read(this, groups,
				dataInputStream);
		List<ConciliacaoBancaria> result = new ArrayList<ConciliacaoBancaria>();
		
		ConciliacaoBancaria conciliacaoBancaria = ConciliacaoBancaria.of(contaBancaria);
		result.add(conciliacaoBancaria);

		headerArquivo.set(flatFile.getRecord(HEADER));
		saldoAnteriorRetorno.set(flatFile.getRecord(SALDO_ANTERIOR));
		
		conciliacaoBancaria.set(saldoAnteriorRetorno);

		Iterator<br.com.anteros.flatfile.Record> iteratorLancamentos = flatFile.getRecords(CONCILIACAO_DETALHE).iterator();
		while (iteratorLancamentos.hasNext()) {
			br.com.anteros.flatfile.Record lancamento = iteratorLancamentos.next();
			detalheRetorno.set(lancamento);
			conciliacaoBancaria.add(detalheRetorno);
		}

		saldoAtualRetorno.set(flatFile.getRecord(SALDO_ATUAL));
		conciliacaoBancaria.set(saldoAtualRetorno);
		trailler.set(flatFile.getRecord(TRAILLER));

		return result;
	}

	public List<ConciliacaoBancaria> read(byte[] data, String[] groups) throws IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException, IOException {
		return read(new ByteArrayInputStream(data), groups);
	}

	public byte[] getXMLSchema() throws FlatFileManagerException, JAXBException {
		return new FlatFileManager().getXMLSchema(this);
	}

	public static CNAB200 of(ContaBancaria contaBancaria) {
		return new BancoBrasilCNAB200(contaBancaria);
	}

}
