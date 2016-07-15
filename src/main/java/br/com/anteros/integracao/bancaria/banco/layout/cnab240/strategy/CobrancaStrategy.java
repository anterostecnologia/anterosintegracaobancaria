package br.com.anteros.integracao.bancaria.banco.layout.cnab240.strategy;

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
import br.com.anteros.integracao.bancaria.banco.layout.CNABException;
import br.com.anteros.integracao.bancaria.banco.layout.RetornoCobranca;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.CNAB240Context;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.*;

public class CobrancaStrategy implements CNAB240Strategy<RetornoCobranca> {	
    @Override
	public List<RetornoCobranca> read(CNAB240Context<RetornoCobranca> context,File file) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException {
		return read(context, new FileInputStream(file), new String[] { GLOBAL });
	}

    @Override
	public List<RetornoCobranca> read(CNAB240Context<RetornoCobranca> context,InputStream dataInputStream) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException {
		return read(context, dataInputStream, new String[] { GLOBAL });
	}

    @Override
	public List<RetornoCobranca> read(CNAB240Context<RetornoCobranca> context,byte[] data) throws IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException, IOException {
		return read(context, new ByteArrayInputStream(data), new String[] { GLOBAL });
	}

    @Override
	public List<RetornoCobranca> read(CNAB240Context<RetornoCobranca> context,File file, String[] groups) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException {
		return read(context, new FileInputStream(file), groups);
	}

    @Override
	public List<RetornoCobranca> read(CNAB240Context<RetornoCobranca> context,InputStream dataInputStream, String[] groups)
			throws IllegalArgumentException, IllegalAccessException, FlatFileManagerException, JAXBException,
			IOException {

		FlatFileManager manager = new FlatFileManager();
		br.com.anteros.flatfile.FlatFile<br.com.anteros.flatfile.Record> flatFile = manager.read(context, groups,
				dataInputStream);
		List<RetornoCobranca> result = new ArrayList<RetornoCobranca>();

		context.getHeaderArquivo().set(flatFile.getRecord(HEADER));
		context.getHeaderCobranca().set(flatFile.getRecord(HEADER_COBRANCA));

		Iterator<br.com.anteros.flatfile.Record> iteratorT = flatFile.getRecords(COBRANCA_SEGMENTO_T).iterator();
		while (iteratorT.hasNext()) {
			br.com.anteros.flatfile.Record recordT = iteratorT.next();
			context.getCobrancaSegmentoT().set(recordT);
			if (recordT.getInnerRecords().size() != 1)
				throw new CNABException("Número de registros filhos para o Registro T incorreto.");
			context.getCobrancaSegmentoU().set(recordT.getInnerRecords().iterator().next());
			result.add(RetornoCobranca.of(context.getContaBancaria(), context.getCobrancaSegmentoT(), context.getCobrancaSegmentoU()));
		}

		context.geTraillerCobranca().set(flatFile.getRecord(TRAILLER_COBRANCA));
		context.getTraillerArquivo().set(flatFile.getRecord(TRAILLER));

		return result;
	}

    @Override
	public List<RetornoCobranca> read(CNAB240Context<RetornoCobranca> context,byte[] data, String[] groups) throws IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException, IOException {
		return read(context, new ByteArrayInputStream(data), groups);
	}

}
