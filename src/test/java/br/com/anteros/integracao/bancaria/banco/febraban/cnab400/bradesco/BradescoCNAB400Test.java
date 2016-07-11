package br.com.anteros.integracao.bancaria.banco.febraban.cnab400.bradesco;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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

public class BradescoCNAB400Test {

	private static final String REMESSA = "REMESSA";
	private List<RemessaCobranca> remessas;
	private CNAB400 layoutCNAB400;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Before
	public void beforeExecuteTests() {
		remessas = CNAB240Helper.gerarTitulosParaRemessaCobranca(BancosSuportados.BANCO_BRADESCO.create(), CNAB240Helper.criarCarteira(1));

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
		File file = ResourceUtils.getFile("src/main/resources/layouts/Layout-CNAB400-Bradesco.xml");
		
		String schema = StringUtils.removeCRLF(new String(layoutCNAB400.getXMLSchema(), "UTF-8"));
		
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(schema.getBytes());
		fos.flush();
		fos.close();

		String fileSchema = StringUtils.removeCRLF(IOUtils.readFileToString(file, "UTF-8"));		

		Assert.assertEquals("Bradesco: Arquivo XML gerado diferente do modelo.", fileSchema, schema);
	}

	@Test
	public void deveGerarArquivoRemessaIgualAoModelo() throws IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException, IOException {

		byte[] byteArray = layoutCNAB400.generate(REMESSA );

		File file = ResourceUtils.getFile("src/main/resources/arquivos-remessa/REM_CNAB400_Bradesco.REM");
		
//		FileOutputStream fos = new FileOutputStream(file);
//		fos.write(byteArray);
//		fos.flush();
//		fos.close();
		
		String fileData = StringUtils.removeCRLF(IOUtils.readFileToString(file, "UTF-8"));
		String data = StringUtils.removeCRLF(new String(byteArray, "UTF-8"));

		Assert.assertEquals("Bradesco: Arquivo de REMESSA gerado diferente do modelo.", fileData, data);
	}

	@Test
	public void deveLerArquivoRetornoEValidarValores() throws IllegalArgumentException, IllegalAccessException,
			IOException, FlatFileManagerException, JAXBException {

		File file = new File("src/main/resources/arquivos-retorno/RET_CNAB400_Bradesco.RET");
		List<RetornoCobranca> retornos = layoutCNAB400.read(file, "RETORNO");

		int titulosEncontrados = 0;

		for (RetornoCobranca retorno : retornos) {
			String detalheTitulo = retorno.getTitulo().getNumeroDocumento() + " Nosso número: "
					+ retorno.getTitulo().getNossoNumero();

			if (retorno.getNumeroSequencial().equals(2)) {
				titulosEncontrados++;
				Calendar dtVencimento = Calendar.getInstance();
				dtVencimento.set(2016, Calendar.APRIL, 01, 0, 0, 0);

				Assert.assertEquals("Banco do Brasil: Tipo de moeda lido incorreto. Titulo " + detalheTitulo,
						retorno.getTitulo().getTipoMoeda(), TipoMoeda.REAL);

				Assert.assertEquals("Número do documento do título incorreto. Titulo " + detalheTitulo, "1716259-1",
						retorno.getTitulo().getNumeroDocumento());

				Assert.assertEquals("Nosso número do título incorreto. Titulo " + detalheTitulo, "35098570622",
						retorno.getTitulo().getNossoNumero());

				Assert.assertEquals("Vencimento do título incorreto. Titulo " + detalheTitulo,
						sdf.format(dtVencimento.getTime()), sdf.format(retorno.getTitulo().getDataVencimento()));

				Assert.assertEquals("Valor nominal do titulo lido incorreto. Titulo " + detalheTitulo,
						new BigDecimal("3941.80"), retorno.getTitulo().getValorTitulo());

				Assert.assertEquals("Valor creditado do titulo lido incorreto. Titulo " + detalheTitulo,
						new BigDecimal("0.00"), retorno.getValorLiquidoCreditado());

				Assert.assertEquals("Valor tarifas/custas do titulo lido incorreto. Titulo " + detalheTitulo,
						new BigDecimal("0.00"), retorno.getValorTarifasCustas());
			}

			if (retorno.getNumeroSequencial().equals(18)) {
				titulosEncontrados++;
				Calendar dtVencimento = Calendar.getInstance();
				dtVencimento.set(2016, Calendar.MARCH, 31, 0, 0, 0);

				Assert.assertEquals("Banco do Brasil: Tipo de moeda lido incorreto. Titulo " + detalheTitulo,
						retorno.getTitulo().getTipoMoeda(), TipoMoeda.REAL);

				Assert.assertEquals("Número do documento do título incorreto. Titulo " + detalheTitulo, "1699028-4",
						retorno.getTitulo().getNumeroDocumento());

				Assert.assertEquals("Nosso número do título incorreto. Titulo " + detalheTitulo, "35098551209",
						retorno.getTitulo().getNossoNumero());

				Assert.assertEquals("Vencimento do título incorreto. Titulo " + detalheTitulo,
						sdf.format(dtVencimento.getTime()), sdf.format(retorno.getTitulo().getDataVencimento()));

				Assert.assertEquals("Valor nominal do titulo lido incorreto. Titulo " + detalheTitulo,
						new BigDecimal("1375.69"), retorno.getTitulo().getValorTitulo());

				Assert.assertEquals("Valor creditado do titulo lido incorreto. Titulo " + detalheTitulo,
						new BigDecimal("1375.69"), retorno.getValorLiquidoCreditado());

				Assert.assertEquals("Valor juros do titulo lido incorreto. Titulo " + detalheTitulo,
						new BigDecimal("0.00"), retorno.getTitulo().getValorJuros());
			}

		}

		Assert.assertEquals(2, titulosEncontrados);
	}

}
