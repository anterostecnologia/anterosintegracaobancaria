package br.com.anteros.integracao.bancaria.banco.layout.cnab240;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.bind.JAXBException;

import br.com.anteros.flatfile.FlatFileManagerException;
import br.com.anteros.integracao.bancaria.banco.layout.RetornoCobranca;

public interface CNAB240Cobranca {

	public byte[] generate() throws FlatFileManagerException, JAXBException, IllegalArgumentException,
			IllegalAccessException, IOException;

	public byte[] generate(String[] groups) throws FlatFileManagerException, JAXBException, IllegalArgumentException,
			IllegalAccessException, IOException;

	public byte[] getXMLSchema() throws FlatFileManagerException, JAXBException;

	public List<RetornoCobranca> read(File file, String[] groups) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException;

	public List<RetornoCobranca> read(File file) throws IOException,
			IllegalArgumentException, IllegalAccessException, FlatFileManagerException, JAXBException;

	public List<RetornoCobranca> read(InputStream dataInputStream)
			throws IOException, IllegalArgumentException, IllegalAccessException, FlatFileManagerException,
			JAXBException;

	public List<RetornoCobranca> read(byte[] data)
			throws IllegalArgumentException, IllegalAccessException, FlatFileManagerException, JAXBException,
			IOException;

	public List<RetornoCobranca> read(InputStream dataInputStream,
			String[] groups) throws IllegalArgumentException, IllegalAccessException, FlatFileManagerException,
			JAXBException, IOException;

	public List<RetornoCobranca> read(byte[] data, String[] groups)
			throws IllegalArgumentException, IllegalAccessException, FlatFileManagerException, JAXBException,
			IOException;

}
