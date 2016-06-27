/*******************************************************************************
 * Copyright 2016 Anteros Tecnologia
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package br.com.anteros.integracao.bancaria.banco.febraban.cnab240;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBException;

import br.com.anteros.core.utils.Assert;
import br.com.anteros.flatfile.FlatFileManager;
import br.com.anteros.flatfile.FlatFileManagerException;
import br.com.anteros.flatfile.annotation.FlatFile;
import br.com.anteros.flatfile.annotation.InnerRecord;
import br.com.anteros.flatfile.annotation.Record;
import br.com.anteros.integracao.bancaria.banco.febraban.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.febraban.RemessaCobranca;
import br.com.anteros.integracao.bancaria.banco.febraban.RetornoCobranca;

@FlatFile(name = "Arquivo CNAB240", description = "Arquivo de remessa/retorno CNAB240", version = "1.0")
public class CNAB240Febraban implements CNAB240 {

	private static final String TRAILLER = "Trailler";
	public static final String TRAILLER_LOTE_COBRANCA = "TraillerLoteCobranca";
	public static final String TITULO_COBRANCA_SEGMENTO_T = "TituloCobrancaSegmentoT";
	public static final String TITULO_COBRANCA_SEGMENTO_U = "TituloCobrancaSegmentoU";
	public static final String TITULO_COBRANCA_SEGMENTO_Q = "TituloCobrancaSegmentoQ";
	public static final String TITULO_COBRANCA_SEGMENTO_P = "TituloCobrancaSegmentoP";
	public static final String HEADER_LOTE_COBRANCA = "HeaderLoteCobranca";
	public static final String HEADER = "Header";

	@Record(name = HEADER, description = "Protocolo de comunicação", order = 1, groups = { "REMESSA", "RETORNO" })
	private HeaderArquivo headerArquivo;

	@Record(name = HEADER_LOTE_COBRANCA, description = "Cabeçalho lote de titulos cobrança", order = 2, groups = {
			"REMESSA", "RETORNO" })
	private HeaderTitulosCobranca headerTitulosCobranca;

	@Record(name = TITULO_COBRANCA_SEGMENTO_P, description = "Segmento P Remessa dos titulos cobrança", order = 3, repeatable = true, groups = { "REMESSA" })
	private TitulosCobrancaSegmentoP segmentoP;

	@InnerRecord(name = TITULO_COBRANCA_SEGMENTO_Q, description = "Segmento Q Remessa dos titulos cobrança", recordOwner = TITULO_COBRANCA_SEGMENTO_P, order = 4, repeatable = true, groups = { "REMESSA" })
	private TitulosCobrancaSegmentoQ segmentoQ;

	@Record(name = TITULO_COBRANCA_SEGMENTO_T, description = "Segmento T Retorno dos titulos cobrança", order = 5, repeatable = true, groups = { "RETORNO" })
	private TitulosCobrancaSegmentoT segmentoT;

	@InnerRecord(name = TITULO_COBRANCA_SEGMENTO_U, description = "Segmento U Retorno dos titulos cobrança", order = 6, repeatable = true, groups = { "RETORNO" }, recordOwner = TITULO_COBRANCA_SEGMENTO_T)
	private TitulosCobrancaSegmentoU segmentoU;

	@Record(name = TRAILLER_LOTE_COBRANCA, description = "Resumo lote de titulos cobrança", order = 7, groups = {
			"REMESSA", "RETORNO" })
	private TraillerTitulosCobranca traillerTitulosCobranca;

	@Record(name = TRAILLER, order = 8, groups = { "REMESSA", "RETORNO" })
	private TraillerArquivo traillerArquivo;
	private List<RemessaCobranca> remessas;

	public CNAB240Febraban(ContaBancaria contaBancaria, List<RemessaCobranca> remessas) {

		Assert.notNull(remessas, "Informe as remessas para geração do arquivo.");
		if (remessas.size() == 0) {
			throw new CNABException("Informe as remessas para geração do arquivo.");
		}

		this.remessas = remessas;

		headerArquivo = HeaderArquivo.of(contaBancaria,
				remessas.get(CNAB240.PRIMEIRA_REMESSA).getTitulo().getCarteira(),
				remessas.get(CNAB240.PRIMEIRA_REMESSA).getTitulo().getCedente(),
				CNAB240.VERSAO_LAYOUT_ARQUIVO_FEBRABAN);
		headerTitulosCobranca = HeaderTitulosCobranca.of(contaBancaria,
				remessas.get(CNAB240.PRIMEIRA_REMESSA).getTitulo().getCarteira(),
				remessas.get(CNAB240.PRIMEIRA_REMESSA).getTitulo().getCedente(), CNAB240.VERSAO_LAYOUT_LOTE_FEBRABAN);
		segmentoP = TitulosCobrancaSegmentoP.of(contaBancaria, remessas);
		segmentoQ = TitulosCobrancaSegmentoQ.of(contaBancaria, remessas);
		segmentoT = TitulosCobrancaSegmentoT.of(contaBancaria);
		segmentoU = TitulosCobrancaSegmentoU.of(contaBancaria);
		traillerTitulosCobranca = TraillerTitulosCobranca.of(contaBancaria, remessas);
		traillerArquivo = TraillerArquivo.of(contaBancaria);
	}

	public CNAB240Febraban(ContaBancaria contaBancaria) {
		headerArquivo = HeaderArquivo.of(contaBancaria);
		headerTitulosCobranca = HeaderTitulosCobranca.of(contaBancaria);
		segmentoT = TitulosCobrancaSegmentoT.of(contaBancaria);
		segmentoU = TitulosCobrancaSegmentoU.of(contaBancaria);
		traillerTitulosCobranca = TraillerTitulosCobranca.of(contaBancaria);
		traillerArquivo = TraillerArquivo.of(contaBancaria);
	}

	public byte[] generate() throws FlatFileManagerException, JAXBException, IllegalArgumentException,
			IllegalAccessException, IOException {
		return generate(new String[] { "GLOBAL" });
	}

	public byte[] generate(String[] groups) throws FlatFileManagerException, JAXBException,
			IllegalArgumentException, IllegalAccessException, IOException {
		Assert.notNull(remessas, "Informe as remessas para geração do arquivo.");
		if (remessas.size() == 0) {
			throw new CNABException("Informe as remessas para geração do arquivo.");
		}
		FlatFileManager manager = new FlatFileManager();
		return manager.generate(this, groups);
	}

	public List<RetornoCobranca> read(File file) throws IOException, IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException {
		return read(new FileInputStream(file), new String[] { "GLOBAL" });
	}

	public List<RetornoCobranca> read(InputStream dataInputStream) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException {
		return read(dataInputStream, new String[] { "GLOBAL" });
	}

	public List<RetornoCobranca> read(byte[] data) throws IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException, IOException {
		return read(new ByteArrayInputStream(data), new String[] { "GLOBAL" });
	}

	public List<RetornoCobranca> read(File file, String[] groups) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException {
		return read(new FileInputStream(file), groups);
	}

	public List<RetornoCobranca> read(InputStream dataInputStream, String[] groups) throws IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException, IOException {

		FlatFileManager manager = new FlatFileManager();
		br.com.anteros.flatfile.FlatFile<br.com.anteros.flatfile.Record> flatFile = manager.read(this, groups,
				dataInputStream);
		List<RetornoCobranca> result = new ArrayList<RetornoCobranca>();

		headerArquivo.set(flatFile.getRecord(HEADER));
		headerTitulosCobranca.set(flatFile.getRecord(HEADER_LOTE_COBRANCA));
		
		Iterator<br.com.anteros.flatfile.Record> iteratorT = flatFile.getRecords(TITULO_COBRANCA_SEGMENTO_T).iterator();
		Iterator<br.com.anteros.flatfile.Record> iteratorU = flatFile.getRecords(TITULO_COBRANCA_SEGMENTO_U).iterator();
		while (iteratorT.hasNext()) {
			br.com.anteros.flatfile.Record recordT = iteratorT.next();
			br.com.anteros.flatfile.Record recordU = iteratorU.next();
			segmentoT.set(recordT);
			segmentoU.set(recordU);

			result.add(RetornoCobranca.of(segmentoT, segmentoU));
		}

		traillerTitulosCobranca.set(flatFile.getRecord(TRAILLER_LOTE_COBRANCA));
		traillerArquivo.set(flatFile.getRecord(TRAILLER));

		return result;
	}

	public List<RetornoCobranca> read(byte[] data, String[] groups) throws IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException, IOException {
		return read(new ByteArrayInputStream(data), groups);
	}
}
