package br.com.anteros.integracao.bancaria.banco.layout.cnab200.extrato;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.bind.JAXBException;

import br.com.anteros.flatfile.FlatFileManagerException;
import br.com.anteros.integracao.bancaria.banco.layout.ConciliacaoBancaria;

public interface CNAB200 {

	public static final String GLOBAL = "GLOBAL";
	
	public static final String RETORNO = "RETORNO";
	public static final String HEADER = "Header";
	public static final String DETALHE_CONCILIACAO = "DetalheConciliacao";
	public static final String TRAILLER = "Trailler";
	

	public byte[] getXMLSchema() throws FlatFileManagerException, JAXBException;

	public List<ConciliacaoBancaria> read(File file) throws IOException, IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException;

	public List<ConciliacaoBancaria> read(InputStream dataInputStream) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException;

	public List<ConciliacaoBancaria> read(byte[] data) throws IOException, IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException;

	public List<ConciliacaoBancaria> read(File file, String[] groups) throws IOException, IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException;

	public List<ConciliacaoBancaria> read(InputStream dataInputStream, String[] groups) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException;

	public List<ConciliacaoBancaria> read(byte[] data, String[] groups) throws IOException, IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException;

}
