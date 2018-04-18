//package br.com.anteros.integracao.bancaria.banco.febraban.cnab240.bancobrasil;
//
//import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.REMESSA_COBRANCA;
//import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.RETORNO_COBRANCA;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.util.Calendar;
//import java.util.List;
//
//import javax.xml.bind.JAXBException;
//
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//import br.com.anteros.core.utils.IOUtils;
//import br.com.anteros.core.utils.ResourceUtils;
//import br.com.anteros.core.utils.StringUtils;
//import br.com.anteros.flatfile.FlatFileManagerException;
//import br.com.anteros.integracao.bancaria.banco.Banco;
//import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.builder.CNAB240Helper;
//import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
//import br.com.anteros.integracao.bancaria.banco.layout.RemessaCobranca;
//import br.com.anteros.integracao.bancaria.banco.layout.RetornoCobranca;
//import br.com.anteros.integracao.bancaria.banco.layout.TipoMoeda;
//import br.com.anteros.integracao.bancaria.banco.layout.cnab240.CNAB240Cobranca;
//import br.com.anteros.integracao.bancaria.banco.layout.cnab240.CNAB240CobrancaBuilder;
//import br.com.anteros.integracao.bancaria.banco.layout.cnab240.CNAB240Extrato;
//import br.com.anteros.integracao.bancaria.banco.layout.cnab240.CNAB240ExtratoBuilder;
//import br.com.anteros.integracao.bancaria.boleto.BancosSuportados;
//
//public class BancoBrasilCNAB240Test {
//
//
//	private List<RemessaCobranca> remessas;
//	private CNAB240Cobranca layoutCobrancaCNAB240;
//	private CNAB240Extrato layoutExtratoCNAB240;
//
//	@Before
//	public void beforeExecuteTests() {
//		Banco banco = BancosSuportados.BANCO_DO_BRASIL.create();
//		ContaBancaria contaBancaria = CNAB240Helper.criarContaBancaria(banco);
//		remessas = CNAB240Helper.gerarTitulosParaRemessaCobranca(banco,
//				CNAB240Helper.criarCarteira(1));
//
//		Calendar calendar = Calendar.getInstance();
//		calendar.set(2016, Calendar.JULY, 1, 17, 15, 43);
//
//		layoutCobrancaCNAB240 = new CNAB240CobrancaBuilder().contaBancaria(remessas.get(0).getTitulo().getContaBancaria())
//				.dataGravacao(calendar.getTime()).dataHoraGeracao(calendar.getTime()).remessas(remessas).build();
//		
//		layoutExtratoCNAB240 = new CNAB240ExtratoBuilder().contaBancaria(contaBancaria)
//				.dataHoraGeracao(calendar.getTime()).build();
//	}
//
//	@After
//	public void afterExecuteTests() {
//
//	}
//
////	@Test
//	public void deveGerarlSchemaXMLDoLayoutIgualAoModelo() throws IllegalArgumentException, IllegalAccessException,
//			FlatFileManagerException, JAXBException, IOException {
//		File file = ResourceUtils.getFile("src/main/resources/layouts/Layout-CNAB240-BancoBrasil.xml");
//
//	//	String schema = StringUtils.removeCRLF(new String(layoutCobrancaCNAB240.getXMLSchema(), "UTF-8"));
//
////		 FileOutputStream fos = new FileOutputStream(file);
////		 fos.write(schema.getBytes());
////		 fos.flush();
////		 fos.close();
//
//	//	String fileSchema = StringUtils.removeCRLF(IOUtils.readFileToString(file, "UTF-8"));
//	
//
////		Assert.assertEquals("Banco do Brasil: Arquivo XML gerado diferente do modelo.", fileSchema, schema);
//	}
//
//	@Test
//	public void deveGerarArquivoRemessaCobrancaIgualAoModelo() throws IllegalArgumentException, IllegalAccessException,
//			FlatFileManagerException, JAXBException, IOException {
//
////		byte[] byteArray = layoutCobrancaCNAB240.generate(new String[] { REMESSA_COBRANCA });
////
////		File file = ResourceUtils.getFile("src/main/resources/arquivos-remessa/COB_CNAB240_BancoBrasil.REM");
//
////		 FileOutputStream fos = new FileOutputStream(file);
////		 fos.write(byteArray);
////		 fos.flush();
////		 fos.close();
//
////		String fileData = StringUtils.removeCRLF(IOUtils.readFileToString(file, "UTF-8"));
////		String data = StringUtils.removeCRLF(new String(byteArray, "UTF-8"));
////
////		System.out.println(data);
//		
////		Assert.assertEquals("Banco do Brasil: Arquivo de REMESSA gerado diferente do modelo.", fileData, data);
//	}
//
//	@Test
//	public void deveLerArquivoRetornoCobrancaEValidarValores() throws IllegalArgumentException, IllegalAccessException,
//			IOException, FlatFileManagerException, JAXBException {
//
//		File file = new File("src/main/resources/arquivos-retorno/COB_CNAB240_BancoBrasil.RET");
//		List<RetornoCobranca> retornos = layoutCobrancaCNAB240.read(file, new String[] { RETORNO_COBRANCA });
//
////		Assert.assertEquals("Banco do Brasil: Número de retornos lido incorreto.", retornos.size(), 4);
////		Assert.assertEquals("Banco do Brasil: Tipo de moeda lido incorreto.",
////				retornos.get(0).getTitulo().getTipoMoeda(), TipoMoeda.REAL);
////		Assert.assertEquals("Valor nominal do titulo lido incorreto.", new BigDecimal("563.14"),
////				retornos.get(0).getTitulo().getValorTitulo());
////		Assert.assertEquals("Valor creditado do titulo lido incorreto.", new BigDecimal("560.64"),
////				retornos.get(0).getValorLiquidoCreditado());
//	}
//	
////	@Test
//	public void deveLerArquivoRetornoConciliacaoBancariaEValidarValores(){
//		
//	}
//
//}
