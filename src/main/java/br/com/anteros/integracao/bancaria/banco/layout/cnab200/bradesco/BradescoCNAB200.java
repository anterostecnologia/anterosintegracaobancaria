package br.com.anteros.integracao.bancaria.banco.layout.cnab200.bradesco;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.xml.bind.JAXBException;

import br.com.anteros.flatfile.FlatFileManager;
import br.com.anteros.flatfile.FlatFileManagerException;
import br.com.anteros.flatfile.annotation.Record;
import br.com.anteros.integracao.bancaria.banco.layout.ConciliacaoBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.cnab200.CNAB200;
import br.com.anteros.integracao.bancaria.banco.layout.cnab400.bancobrasil.TraillerArquivoRetorno;

public class BradescoCNAB200 implements CNAB200 {

	public static final String HEADER = "HeaderRetorno";
	public static final String CONCILIACAO_DETALHE = "ConciliacaoDetalheRetorno";
	public static final String TRAILLER = "TraillerRetorno";

	@Record(name = HEADER, description = "Protocolo de comunicação", order = 1, groups = { "RETORNO" })
	private HeaderArquivo headerArquivo;

	@Record(name = CONCILIACAO_DETALHE, description = "Detalhe da conciliação bancária", order = 6, repeatable = true, groups = {
			"RETORNO" })
	private ConciliacaoDetalheRetorno detalheRetorno;

	@Record(name = TRAILLER, description = "Resumo do arquivo de Retorno", order = 8, groups = { "RETORNO" })
	private TraillerArquivoRetorno trailler;

	private ContaBancaria contaBancaria;

	private BradescoCNAB200(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}


	public ConciliacaoBancaria read(File file) throws IOException, IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException {
		return read(new FileInputStream(file), new String[] { GLOBAL });
	}

	public ConciliacaoBancaria read(InputStream dataInputStream) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException {
		return read(dataInputStream, new String[] { GLOBAL });
	}

	public ConciliacaoBancaria read(byte[] data) throws IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException, IOException {
		return read(new ByteArrayInputStream(data), new String[] { GLOBAL });
	}

	public ConciliacaoBancaria read(File file, String[] groups) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException {
		return read(new FileInputStream(file), groups);
	}

	public ConciliacaoBancaria read(InputStream dataInputStream, String[] groups) throws IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException, IOException {

		FlatFileManager manager = new FlatFileManager();
		br.com.anteros.flatfile.FlatFile<br.com.anteros.flatfile.Record> flatFile = manager.read(this, groups,
				dataInputStream);
		ConciliacaoBancaria conciliacaoBancaria = ConciliacaoBancaria.of(contaBancaria);

		headerArquivo.set(flatFile.getRecord(HEADER));

		Iterator<br.com.anteros.flatfile.Record> iteratorT = flatFile.getRecords(CONCILIACAO_DETALHE).iterator();
		while (iteratorT.hasNext()) {
			br.com.anteros.flatfile.Record recordT = iteratorT.next();
			detalheRetorno.set(recordT);
			conciliacaoBancaria.add(detalheRetorno);
		}

		trailler.set(flatFile.getRecord(TRAILLER));

		return conciliacaoBancaria;
	}

	public ConciliacaoBancaria read(byte[] data, String[] groups) throws IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException, IOException {
		return read(new ByteArrayInputStream(data), groups);
	}

	public byte[] getXMLSchema() throws FlatFileManagerException, JAXBException {
		return new FlatFileManager().getXMLSchema(this);
	}

	public static CNAB200 of(ContaBancaria contaBancaria) {
		return new BradescoCNAB200(contaBancaria);
	}

}
