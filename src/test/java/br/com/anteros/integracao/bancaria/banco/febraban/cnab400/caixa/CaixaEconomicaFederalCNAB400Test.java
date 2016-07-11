package br.com.anteros.integracao.bancaria.banco.febraban.cnab400.caixa;

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
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.builder.CNAB240Helper;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab400.CNAB400;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab400.CNAB400Factory;
import br.com.anteros.integracao.bancaria.boleto.BancosSuportados;

public class CaixaEconomicaFederalCNAB400Test {

	private static final String REMESSA = "REMESSA";
	private List<RemessaCobranca> remessas;
	private CNAB400 layoutCNAB400;

	@Before
	public void beforeExecuteTests() {
		remessas = CNAB240Helper.gerarTitulosParaRemessaCobranca(BancosSuportados.CAIXA_ECONOMICA_FEDERAL.create(),
				CNAB240Helper.criarCarteira(1));

		Calendar calendar = Calendar.getInstance();
		calendar.set(2016, Calendar.JULY, 1, 17, 15, 43);

		layoutCNAB400 = CNAB400Factory.create(remessas, calendar.getTime(), calendar.getTime());
	}

	@After
	public void afterExecuteTests() {

	}

	@Test
	public void deveGerarlSchemaXMLDoLayoutIgualAoModelo() throws IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException, IOException {
		File file = ResourceUtils.getFile("src/main/resources/layouts/Layout-CNAB400-Caixa.xml");

		String schema = StringUtils.removeCRLF(new String(layoutCNAB400.getXMLSchema(), "UTF-8"));
		
//		FileOutputStream fos = new FileOutputStream(file);
//		fos.write(schema.getBytes());
//		fos.flush();
//		fos.close();
		
		String fileSchema = StringUtils.removeCRLF(IOUtils.readFileToString(file, "UTF-8"));

		Assert.assertEquals("Caixa Econômica Federal: Arquivo XML gerado diferente do modelo.", fileSchema, schema);
	}

	@Test
	public void deveGerarArquivoRemessaIgualAoModelo() throws IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException, IOException {

//		byte[] byteArray = layoutCNAB400.generate(REMESSA);
//
//		File file = ResourceUtils.getFile("src/main/resources/arquivos-remessa/REM_CNAB400_Caixa.REM");

//		 FileOutputStream fos = new FileOutputStream(file);
//		 fos.write(byteArray);
//		 fos.flush();
//		 fos.close();

//		String fileData = StringUtils.removeCRLF(IOUtils.readFileToString(file, "UTF-8"));
//		String data = StringUtils.removeCRLF(new String(byteArray, "UTF-8"));
//
//		Assert.assertEquals("Caixa Econômica Federal: Arquivo de REMESSA gerado diferente do modelo.", fileData, data);
	}

	@Test
	public void deveLerArquivoRetornoEValidarValores() throws IllegalArgumentException, IllegalAccessException,
			IOException, FlatFileManagerException, JAXBException {

//		File file = new File("src/main/resources/arquivos-retorno/RET_CNAB400_Caixa.RET");
//		List<RetornoCobranca> retornos = layoutCNAB400.read(file,  "RETORNO" );
//
//		Assert.assertEquals("Caixa Econômica Federal: Número de retornos lido incorreto.", retornos.size(), 4);
//		Assert.assertEquals("Caixa Econômica Federal: Tipo de moeda lido incorreto.",
//				retornos.get(0).getTitulo().getTipoMoeda(), TipoMoeda.REAL);
//		Assert.assertEquals("Valor nominal do titulo lido incorreto.", retornos.get(0).getTitulo().getValorTitulo(),
//				new BigDecimal("563.14"));
//		Assert.assertEquals("Valor creditado do titulo lido incorreto.", retornos.get(0).getValorLiquidoCreditado(),
//				new BigDecimal("560.64"));
	}

}
