package br.com.anteros.integracao.bancaria.banco.febraban.cnab240.caixa;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.anteros.core.utils.IOUtils;
import br.com.anteros.core.utils.ResourceUtils;
import br.com.anteros.core.utils.StringUtils;
import br.com.anteros.flatfile.FlatFileManagerException;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.builder.CNAB240Helper;
import br.com.anteros.integracao.bancaria.banco.layout.RemessaCobranca;
import br.com.anteros.integracao.bancaria.banco.layout.RetornoCobranca;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.CNAB240Context;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.CNAB240ContextBuilder;
import br.com.anteros.integracao.bancaria.boleto.BancosSuportados;

public class CaixaCNAB240Test {

	public static final String RETORNO_COBRANCA = "RETORNO_COBRANCA";
	public static final String REMESSA_COBRANCA = "REMESSA_COBRANCA";
	private List<RemessaCobranca> remessas;
	private CNAB240Context<RetornoCobranca> layoutCNAB240;

	@Before
	public void beforeExecuteTests() {
		remessas = CNAB240Helper.gerarTitulosParaRemessaCobranca(BancosSuportados.CAIXA_ECONOMICA_FEDERAL.create(),CNAB240Helper.criarCarteira(1));

		Calendar calendar = Calendar.getInstance();
		calendar.set(2016, Calendar.JULY, 1, 17, 15, 43);

		layoutCNAB240 = new CNAB240ContextBuilder<RetornoCobranca>().contaBancaria(remessas.get(0).getTitulo().getContaBancaria())
				.dataGravacao(calendar.getTime()).dataHoraGeracao(calendar.getTime()).remessas(remessas).build();
	}

	@After
	public void afterExecuteTests() {

	}

	@Test
	public void deveGerarlSchemaXMLDoLayoutIgualAoModelo() throws IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException, IOException {
		File file = ResourceUtils.getFile("src/main/resources/layouts/Layout-CNAB240-Caixa.xml");

		String schema = StringUtils.removeCRLF(new String(layoutCNAB240.getXMLSchema(), "UTF-8"));
		
//		FileOutputStream fos = new FileOutputStream(file);
//		fos.write(schema.getBytes());
//		fos.flush();
//		fos.close();
		
		String fileSchema = StringUtils.removeCRLF(IOUtils.readFileToString(file, "UTF-8"));

		Assert.assertEquals("Caixa: Arquivo XML gerado diferente do modelo.", fileSchema, schema);
	}

	@Test
	public void deveGerarArquivoRemessaIgualAoModelo() throws IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException, IOException {

		byte[] byteArray = layoutCNAB240.generate(new String[] { REMESSA_COBRANCA });

		File file = ResourceUtils.getFile("src/main/resources/arquivos-remessa/COB_CNAB240_Caixa.REM");
		
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(byteArray);
		fos.flush();
		fos.close();
		
		String fileData = StringUtils.removeCRLF(IOUtils.readFileToString(file, "UTF-8"));
		String data = StringUtils.removeCRLF(new String(byteArray, "UTF-8"));

		Assert.assertEquals("Caixa: Arquivo de REMESSA gerado diferente do modelo.", fileData, data);
	}
	
	@Test
	public void deveLerArquivoRetornoEValidarValores() throws IllegalArgumentException, IllegalAccessException,
			IOException, FlatFileManagerException, JAXBException {
	}
}