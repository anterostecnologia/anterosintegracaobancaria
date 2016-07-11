package br.com.anteros.integracao.bancaria.banco.febraban.cnab240.bancobrasil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
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
import br.com.anteros.integracao.bancaria.banco.febraban.RemessaCobranca;
import br.com.anteros.integracao.bancaria.banco.febraban.RetornoCobranca;
import br.com.anteros.integracao.bancaria.banco.febraban.TipoMoeda;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.CNAB240;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.CNAB240Factory;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.builder.CNAB240Helper;
import br.com.anteros.integracao.bancaria.boleto.BancosSuportados;

public class BancoBrasilCNAB240Test {

	private static final String REMESSA = "REMESSA";
	private List<RemessaCobranca> remessas;
	private CNAB240 layoutCNAB240;

	@Before
	public void beforeExecuteTests() {
		remessas = CNAB240Helper.gerarTitulosParaRemessaCobranca(BancosSuportados.BANCO_DO_BRASIL.create(), CNAB240Helper.criarCarteira(1));

		Calendar calendar = Calendar.getInstance();
		calendar.set(2016, Calendar.JULY, 1, 17, 15, 43);

		layoutCNAB240 = CNAB240Factory.create(remessas, calendar.getTime(), calendar.getTime());
	}

	@After
	public void afterExecuteTests() {

	}

	@Test
	public void deveGerarlSchemaXMLDoLayoutIgualAoModelo() throws IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException, IOException {
		File file = ResourceUtils.getFile("src/main/resources/layouts/Layout-CNAB240-BancoBrasil.xml");

		String schema = StringUtils.removeCRLF(new String(layoutCNAB240.getXMLSchema(), "UTF-8"));
		
//		FileOutputStream fos = new FileOutputStream(file);
//		fos.write(schema.getBytes());
//		fos.flush();
//		fos.close();
		
		String fileSchema = StringUtils.removeCRLF(IOUtils.readFileToString(file, "UTF-8"));
		

		Assert.assertEquals("Banco do Brasil: Arquivo XML gerado diferente do modelo.", fileSchema, schema);
	}

	@Test
	public void deveGerarArquivoRemessaIgualAoModelo() throws IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException, IOException {

		byte[] byteArray = layoutCNAB240.generate(new String[] { REMESSA });

		File file = ResourceUtils.getFile("src/main/resources/arquivos-remessa/REM_CNAB240_BancoBrasil.REM");
		
//		FileOutputStream fos = new FileOutputStream(file);
//		fos.write(byteArray);
//		fos.flush();
//		fos.close();
		
		String fileData = StringUtils.removeCRLF(IOUtils.readFileToString(file, "UTF-8"));
		String data = StringUtils.removeCRLF(new String(byteArray, "UTF-8"));

		Assert.assertEquals("Banco do Brasil: Arquivo de REMESSA gerado diferente do modelo.", fileData, data);
	}

	@Test
	public void deveLerArquivoRetornoEValidarValores() throws IllegalArgumentException, IllegalAccessException,
			IOException, FlatFileManagerException, JAXBException {

		File file = new File("src/main/resources/arquivos-retorno/RET_CNAB240_BancoBrasil.RET");
		List<RetornoCobranca> retornos = layoutCNAB240.read(file, new String[] { "RETORNO" });

		Assert.assertEquals("Banco do Brasil: Número de retornos lido incorreto.", retornos.size(), 4);
		Assert.assertEquals("Banco do Brasil: Tipo de moeda lido incorreto.",
				retornos.get(0).getTitulo().getTipoMoeda(), TipoMoeda.REAL);
		Assert.assertEquals("Valor nominal do titulo lido incorreto.", new BigDecimal("563.14"), retornos.get(0).getTitulo().getValorTitulo());
		Assert.assertEquals("Valor creditado do titulo lido incorreto.", new BigDecimal("560.64"), retornos.get(0).getValorLiquidoCreditado());
	}

}
