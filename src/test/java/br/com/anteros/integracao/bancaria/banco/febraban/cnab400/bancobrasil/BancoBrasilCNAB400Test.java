package br.com.anteros.integracao.bancaria.banco.febraban.cnab400.bancobrasil;

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

public class BancoBrasilCNAB400Test {

	private static final String REMESSA = "REMESSA";
	private List<RemessaCobranca> remessas;
	private CNAB400 layoutCNAB400;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Before
	public void beforeExecuteTests() {
		remessas = CNAB240Helper.gerarTitulosParaRemessaCobranca(BancosSuportados.BANCO_DO_BRASIL.create(),
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

		File file = ResourceUtils.getFile("src/main/resources/layouts/Layout-CNAB400-BancoBrasil.xml");
		String schema = StringUtils.removeCRLF(new String(layoutCNAB400.getXMLSchema(), "UTF-8"));

		FileOutputStream fos = new FileOutputStream(file);
		fos.write(schema.getBytes());
		fos.flush();
		fos.close();

		String fileSchema = StringUtils.removeCRLF(IOUtils.readFileToString(file, "UTF-8"));

		Assert.assertEquals("Banco do Brasil: Arquivo XML gerado diferente do modelo.", fileSchema, schema);
	}

	@Test
	public void deveGerarArquivoRemessaIgualAoModelo() throws IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException, IOException {

		byte[] byteArray = layoutCNAB400.generate(REMESSA);

		File file = ResourceUtils.getFile("src/main/resources/arquivos-remessa/REM_CNAB400_BancoBrasil.REM");

		FileOutputStream fos = new FileOutputStream(file);
		fos.write(byteArray);
		fos.flush();
		fos.close();

		String fileData = StringUtils.removeCRLF(IOUtils.readFileToString(file, "UTF-8"));
		String data = StringUtils.removeCRLF(new String(byteArray, "UTF-8"));

		Assert.assertEquals("Banco do Brasil: Arquivo de REMESSA gerado diferente do modelo.", fileData, data);
	}

	@Test
	public void deveLerArquivoRetornoEValidarValores() throws IllegalArgumentException, IllegalAccessException,
			IOException, FlatFileManagerException, JAXBException {

		File file = new File("src/main/resources/arquivos-retorno/RET_CNAB400_BancoBrasil.RET");
		List<RetornoCobranca> retornos = layoutCNAB400.read(file, "RETORNO");

		Assert.assertEquals("Banco do Brasil: Número de retornos lido incorreto.", retornos.size(), 1);

		RetornoCobranca retorno = retornos.get(0);

		Calendar dtVencimento = Calendar.getInstance();
		dtVencimento.set(2016, Calendar.JANUARY, 15, 0, 0, 0);
		String detalheTitulo = retorno.getTitulo().getNumeroDocumento() + " Nosso número: "
				+ retorno.getTitulo().getNossoNumero();

		Assert.assertEquals("Banco do Brasil: Tipo de moeda lido incorreto. Titulo " + detalheTitulo,
				retorno.getTitulo().getTipoMoeda(), TipoMoeda.REAL);

		Assert.assertEquals("Número do documento do título incorreto. Titulo " + detalheTitulo, "250315",
				retorno.getTitulo().getNumeroDocumento());

		Assert.assertEquals("Nosso número do título incorreto. Titulo " + detalheTitulo, "2019029000",
				retorno.getTitulo().getNossoNumero());

		Assert.assertEquals("Vencimento do título incorreto. Titulo " + detalheTitulo,
				sdf.format(dtVencimento.getTime()), sdf.format(retorno.getTitulo().getDataVencimento()));

		Assert.assertEquals("Valor nominal do titulo lido incorreto. Titulo " + detalheTitulo,
				new BigDecimal("100.00"), retorno.getTitulo().getValorTitulo());

		Assert.assertEquals("Valor creditado do titulo lido incorreto. Titulo " + detalheTitulo, new BigDecimal("112.33"),
				retorno.getValorLiquidoCreditado());

		Assert.assertEquals("Valor tarifas/custas do titulo lido incorreto. Titulo " + detalheTitulo,
				new BigDecimal("5.00"), retorno.getValorTarifasCustas());

	}

	@Test
	public void deveLerArquivoRetornoCarteira17EValidarValores() throws IllegalArgumentException,
			IllegalAccessException, IOException, FlatFileManagerException, JAXBException {

		File file = new File("src/main/resources/arquivos-retorno/RET_CNAB400_BancoBrasil_Carteira17.RET");
		List<RetornoCobranca> retornos = layoutCNAB400.read(file, "RETORNO_17");

		int titulosEncontrados = 0;

		for (RetornoCobranca retorno : retornos) {
			String detalheTitulo = retorno.getTitulo().getNumeroDocumento() + " Nosso número: "
					+ retorno.getTitulo().getNossoNumero();

			if (retorno.getNumeroSequencial().equals(2)) {
				titulosEncontrados++;
				Calendar dtVencimento = Calendar.getInstance();
				dtVencimento.set(2016, Calendar.FEBRUARY, 16, 0, 0, 0);

				Assert.assertEquals("Banco do Brasil: Tipo de moeda lido incorreto. Titulo " + detalheTitulo,
						retorno.getTitulo().getTipoMoeda(), TipoMoeda.REAL);

				Assert.assertEquals("Número do documento do título incorreto. Titulo " + detalheTitulo, "1704156-1",
						retorno.getTitulo().getNumeroDocumento());

				Assert.assertEquals("Nosso número do título incorreto. Titulo " + detalheTitulo, "19060420000965061",
						retorno.getTitulo().getNossoNumero());

				Assert.assertEquals("Vencimento do título incorreto. Titulo " + detalheTitulo,
						sdf.format(dtVencimento.getTime()), sdf.format(retorno.getTitulo().getDataVencimento()));

				Assert.assertEquals("Valor nominal do titulo lido incorreto. Titulo " + detalheTitulo,
						new BigDecimal("2158.21"), retorno.getTitulo().getValorTitulo());

				Assert.assertEquals("Valor creditado do titulo lido incorreto. Titulo " + detalheTitulo,
						new BigDecimal("0.00"), retorno.getValorLiquidoCreditado());

				Assert.assertEquals("Valor tarifas/custas do titulo lido incorreto. Titulo " + detalheTitulo,
						new BigDecimal("2.29"), retorno.getValorTarifasCustas());
			}

			if (retorno.getNumeroSequencial().equals(18)) {
				titulosEncontrados++;
				Calendar dtVencimento = Calendar.getInstance();
				dtVencimento.set(2016, Calendar.FEBRUARY, 05, 0, 0, 0);

				Assert.assertEquals("Banco do Brasil: Tipo de moeda lido incorreto. Titulo " + detalheTitulo,
						retorno.getTitulo().getTipoMoeda(), TipoMoeda.REAL);

				Assert.assertEquals("Número do documento do título incorreto. Titulo " + detalheTitulo, "1679522-3",
						retorno.getTitulo().getNumeroDocumento());

				Assert.assertEquals("Nosso número do título incorreto. Titulo " + detalheTitulo, "19060420000949554",
						retorno.getTitulo().getNossoNumero());

				Assert.assertEquals("Vencimento do título incorreto. Titulo " + detalheTitulo,
						sdf.format(dtVencimento.getTime()), sdf.format(retorno.getTitulo().getDataVencimento()));

				Assert.assertEquals("Valor nominal do titulo lido incorreto. Titulo " + detalheTitulo,
						new BigDecimal("1283.86"), retorno.getTitulo().getValorTitulo());

				Assert.assertEquals("Valor creditado do titulo lido incorreto. Titulo " + detalheTitulo,
						new BigDecimal("1305.26"), retorno.getValorLiquidoCreditado());

				Assert.assertEquals("Valor juros do titulo lido incorreto. Titulo " + detalheTitulo,
						new BigDecimal("21.40"), retorno.getTitulo().getValorJuros());
			}

		}

		Assert.assertEquals(2, titulosEncontrados);
	}

}
