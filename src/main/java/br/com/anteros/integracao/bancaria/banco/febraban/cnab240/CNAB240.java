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
	
	public static final String GLOBAL = "GLOBAL";
	
	public static final String RETORNO = "RETORNO";
	public static final String REMESSA = "REMESSA";
	public static final String TRAILLER = "Trailler";
	public static final String TRAILLER_LOTE_COBRANCA = "TraillerLoteCobranca";
	public static final String TITULO_COBRANCA_SEGMENTO_T = "TituloCobrancaSegmentoT";
	public static final String TITULO_COBRANCA_SEGMENTO_U = "TituloCobrancaSegmentoU";
	public static final String TITULO_COBRANCA_SEGMENTO_Q = "TituloCobrancaSegmentoQ";
	public static final String TITULO_COBRANCA_SEGMENTO_P = "TituloCobrancaSegmentoP";
	public static final String HEADER_LOTE_COBRANCA = "HeaderLoteCobranca";
	public static final String HEADER = "Header";

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
