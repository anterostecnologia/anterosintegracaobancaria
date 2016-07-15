package br.com.anteros.integracao.bancaria.banco.layout.cnab240.strategy;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.bind.JAXBException;

import br.com.anteros.flatfile.FlatFileManagerException;
import br.com.anteros.integracao.bancaria.banco.layout.ConciliacaoBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.CNAB240Context;

public class ConciliacaoBancariaStrategy implements CNAB240Strategy<ConciliacaoBancaria> {

	@Override
	public List<ConciliacaoBancaria> read(CNAB240Context context, File file) throws IOException,
			IllegalArgumentException, IllegalAccessException, FlatFileManagerException, JAXBException {
		return null;
	}

	@Override
	public List<ConciliacaoBancaria> read(CNAB240Context context, InputStream dataInputStream) throws IOException,
			IllegalArgumentException, IllegalAccessException, FlatFileManagerException, JAXBException {
		return null;
	}

	@Override
	public List<ConciliacaoBancaria> read(CNAB240Context context, byte[] data) throws IOException,
			IllegalArgumentException, IllegalAccessException, FlatFileManagerException, JAXBException {
		return null;
	}

	@Override
	public List<ConciliacaoBancaria> read(CNAB240Context context, File file, String[] groups) throws IOException,
			IllegalArgumentException, IllegalAccessException, FlatFileManagerException, JAXBException {
		return null;
	}

	@Override
	public List<ConciliacaoBancaria> read(CNAB240Context context, InputStream dataInputStream, String[] groups)
			throws IOException, IllegalArgumentException, IllegalAccessException, FlatFileManagerException,
			JAXBException {
		return null;
	}

	@Override
	public List<ConciliacaoBancaria> read(CNAB240Context context, byte[] data, String[] groups) throws IOException,
			IllegalArgumentException, IllegalAccessException, FlatFileManagerException, JAXBException {
		return null;
	}


}
