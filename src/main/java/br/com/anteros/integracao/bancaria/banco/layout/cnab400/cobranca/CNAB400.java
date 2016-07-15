package br.com.anteros.integracao.bancaria.banco.layout.cnab400.cobranca;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.bind.JAXBException;

import br.com.anteros.flatfile.FlatFileManagerException;
import br.com.anteros.integracao.bancaria.banco.layout.RetornoCobranca;

public interface CNAB400 {


	public byte[] generate() throws FlatFileManagerException, JAXBException, IllegalArgumentException,
			IllegalAccessException, IOException;
	
	public byte[] getXMLSchema() throws FlatFileManagerException, JAXBException;

	public byte[] generate(String group) throws FlatFileManagerException, JAXBException, IllegalArgumentException,
			IllegalAccessException, IOException;

	public List<RetornoCobranca> read(File file) throws IOException, IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException;

	public List<RetornoCobranca> read(InputStream dataInputStream) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException;

	public List<RetornoCobranca> read(byte[] data) throws IOException, IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException;

	public List<RetornoCobranca> read(File file, String group) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException;

	public List<RetornoCobranca> read(InputStream dataInputStream, String group) throws IOException,
			IllegalArgumentException, IllegalAccessException, FlatFileManagerException, JAXBException;

	public List<RetornoCobranca> read(byte[] data, String group) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException;

}
