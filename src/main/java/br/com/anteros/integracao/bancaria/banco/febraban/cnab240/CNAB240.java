package br.com.anteros.integracao.bancaria.banco.febraban.cnab240;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.bind.JAXBException;

import br.com.anteros.flatfile.FlatFileManagerException;
import br.com.anteros.integracao.bancaria.banco.febraban.RetornoCobranca;

public interface CNAB240 {

	public static final int VERSAO_LAYOUT_ARQUIVO_FEBRABAN = 84;

	public static final int VERSAO_LAYOUT_LOTE_FEBRABAN = 45;

	public static final int PRIMEIRA_REMESSA = 0;

	public byte[] generate() throws FlatFileManagerException, JAXBException, IllegalArgumentException,
			IllegalAccessException, IOException;
	
	public byte[] getXMLSchema() throws FlatFileManagerException, JAXBException;

	public byte[] generate(String[] groups) throws FlatFileManagerException, JAXBException,
			IllegalArgumentException, IllegalAccessException, IOException;

	public List<RetornoCobranca> read(File file) throws IOException, IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException;

	public List<RetornoCobranca> read(InputStream dataInputStream) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException;

	public List<RetornoCobranca> read(byte[] data) throws IOException, IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException;

	public List<RetornoCobranca> read(File file, String[] groups) throws IOException, IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException;

	public List<RetornoCobranca> read(InputStream dataInputStream, String[] groups) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException;

	public List<RetornoCobranca> read(byte[] data, String[] groups) throws IOException, IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException;

}
