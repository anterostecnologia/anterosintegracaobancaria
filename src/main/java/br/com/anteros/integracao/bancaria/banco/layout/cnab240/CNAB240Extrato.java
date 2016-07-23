package br.com.anteros.integracao.bancaria.banco.layout.cnab240;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.bind.JAXBException;

import br.com.anteros.flatfile.FlatFileManagerException;
import br.com.anteros.integracao.bancaria.banco.layout.ConciliacaoBancaria;

public interface CNAB240Extrato {

	public byte[] generate() throws FlatFileManagerException, JAXBException, IllegalArgumentException,
			IllegalAccessException, IOException;

	public byte[] generate(String[] groups) throws FlatFileManagerException, JAXBException, IllegalArgumentException,
			IllegalAccessException, IOException;

	public byte[] getXMLSchema() throws FlatFileManagerException, JAXBException;

	public List<ConciliacaoBancaria> read(File file, String[] groups) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException;

	public List<ConciliacaoBancaria> read(File file) throws IOException,
			IllegalArgumentException, IllegalAccessException, FlatFileManagerException, JAXBException;

	public List<ConciliacaoBancaria> read(InputStream dataInputStream)
			throws IOException, IllegalArgumentException, IllegalAccessException, FlatFileManagerException,
			JAXBException;

	public List<ConciliacaoBancaria> read(byte[] data)
			throws IllegalArgumentException, IllegalAccessException, FlatFileManagerException, JAXBException,
			IOException;

	public List<ConciliacaoBancaria> read(InputStream dataInputStream,
			String[] groups) throws IllegalArgumentException, IllegalAccessException, FlatFileManagerException,
			JAXBException, IOException;

	public List<ConciliacaoBancaria> read(byte[] data, String[] groups)
			throws IllegalArgumentException, IllegalAccessException, FlatFileManagerException, JAXBException,
			IOException;

}
