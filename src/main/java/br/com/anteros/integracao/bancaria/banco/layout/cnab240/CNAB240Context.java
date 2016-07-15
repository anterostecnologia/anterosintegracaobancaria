package br.com.anteros.integracao.bancaria.banco.layout.cnab240;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;

import br.com.anteros.flatfile.FlatFileManagerException;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.strategy.CNAB240Strategy;

public interface CNAB240Context<T> {

	public byte[] generate() throws FlatFileManagerException, JAXBException, IllegalArgumentException,
			IllegalAccessException, IOException;

	public byte[] getXMLSchema() throws FlatFileManagerException, JAXBException;

	public byte[] generate(String[] groups) throws FlatFileManagerException, JAXBException, IllegalArgumentException,
			IllegalAccessException, IOException;
	
	public ContaBancaria getContaBancaria();

	public HeaderArquivo getHeaderArquivo();

	public HeaderConciliacaoBancaria getHeaderConciliacaoBancaria();

	public HeaderCobranca getHeaderCobranca();

	public ConciliacaoBancariaSegmentoE getConciliacaoBancariaSegmentoE();

	public CobrancaSegmentoP getCobrancaSegmentoP();

	public CobrancaSegmentoQ getCobrancaSegmentoQ();

	public CobrancaSegmentoT getCobrancaSegmentoT();

	public CobrancaSegmentoU getCobrancaSegmentoU();

	public TraillerArquivo getTraillerArquivo();

	public TraillerConciliacaoBancaria geTraillerConciliacaoBancaria();

	public TraillerCobranca geTraillerCobranca();

	public int getVersaoLayoutArquivo();

	public int getVersaoLayoutLote();
	
	public List<T> read(CNAB240Strategy<T> strategy, File file, String[] groups) throws IOException, IllegalArgumentException, IllegalAccessException,
	FlatFileManagerException, JAXBException;

}
