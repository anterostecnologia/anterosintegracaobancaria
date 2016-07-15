package br.com.anteros.integracao.bancaria.banco.layout.cnab240.strategy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.bind.JAXBException;

import br.com.anteros.flatfile.FlatFileManagerException;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.CNAB240Context;

public interface CNAB240Strategy<T> {

	public List<T> read(CNAB240Context<T> context, File file) throws IOException, IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException;

	public List<T> read(CNAB240Context<T> context,InputStream dataInputStream) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException;

	public List<T> read(CNAB240Context<T> context,byte[] data) throws IOException, IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException;

	public List<T> read(CNAB240Context<T> context,File file, String[] groups) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException;

	public List<T> read(CNAB240Context<T> context,InputStream dataInputStream, String[] groups) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException;

	public List<T> read(CNAB240Context<T> context,byte[] data, String[] groups) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException;

}
