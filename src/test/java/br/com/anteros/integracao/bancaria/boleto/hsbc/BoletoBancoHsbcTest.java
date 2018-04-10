//package br.com.anteros.integracao.bancaria.boleto.hsbc;
//
//import static br.com.anteros.integracao.bancaria.banco.febraban.cnab240.builder.BoletoHelper.ANTEROS_TECNOLOGIA;
//import static br.com.anteros.integracao.bancaria.banco.febraban.cnab240.builder.BoletoHelper.EDSON_MARTINS;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//
//import java.io.ByteArrayInputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import com.lowagie.text.DocumentException;
//
//import br.com.anteros.core.utils.IOUtils;
//import br.com.anteros.core.utils.ResourceUtils;
//import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.builder.BoletoHelper;
//import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.builder.CNAB240Helper;
//import br.com.anteros.integracao.bancaria.banco.layout.Banco;
//import br.com.anteros.integracao.bancaria.banco.layout.RemessaCobranca;
//import br.com.anteros.integracao.bancaria.boleto.BancosSuportados;
//import br.com.anteros.integracao.bancaria.boleto.Boleto;
//import br.com.anteros.integracao.bancaria.boleto.BoletoConfiguration;
//import br.com.anteros.integracao.bancaria.boleto.BoletoConfigurationBuilder;
//import br.com.anteros.integracao.bancaria.boleto.BoletoManager;
//import br.com.anteros.integracao.bancaria.boleto.ImageType;
//
//public class BoletoBancoHsbcTest {
//
//	public static final String BOLETO_BANCARIO = "BOLETO BANCÁRIO";
//	private Date dhGeracaoBoleto;
//	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
//	private List<Boleto> boletosParaTeste;
//
//	@Before
//	public void antesTestarBoletos() {
//		Calendar calendar = Calendar.getInstance();
//		calendar.set(2016, Calendar.JULY, 04, 10, 15);
//		dhGeracaoBoleto = calendar.getTime();
//
//		Banco banco = BancosSuportados.HSBC.create();
//		List<RemessaCobranca> remessas = CNAB240Helper.gerarTitulosParaRemessaCobranca(banco,CNAB240Helper.criarCarteira(1));
//		boletosParaTeste = BoletoHelper.geraBoletosParaTeste(banco, remessas);
//	}
//
//	@After
//	public void depoisTestarBoletos() {
//
//	}
//
//	@Test
//	public void deveGerarUmPDFPorBoletoComDadosIguaisAsImagensModelo() throws IOException, DocumentException {
//		BoletoConfiguration configuration = new BoletoConfigurationBuilder().author(ANTEROS_TECNOLOGIA)
//				.creationDate(sdf.format(dhGeracaoBoleto)).creator(EDSON_MARTINS).title(BOLETO_BANCARIO).subject(BOLETO_BANCARIO).keywords("BOLETO").fullCompression(true).build();
//	
//		List<byte[]> boletosGerados = BoletoManager.getInstance().generate(configuration, boletosParaTeste);
//		int i = 0;
//		for (byte[] b : boletosGerados) {
//			List<byte[]> boletoImg = BoletoManager.getInstance().converPDFToImage(ImageType.PNG, 130, b); 
//			assertNotNull(boletoImg);
//			assertEquals(boletoImg.size(),1);
//			File modeloOrigem = ResourceUtils
//					.getFile("src/main/resources/pdf/boletos/BOLETO_" + (i+1) + "_" + boletosParaTeste.get(i).getTitulo()
//							.getContaBancaria().getBanco().getCodigoDeCompensacaoBACEN().getCodigoFormatado() + ".png");
//			
////			FileOutputStream fos = new FileOutputStream(modeloOrigem);
////			fos.write(boletoImg.get(0));
////			fos.flush();
////			fos.close();
//					
//			FileInputStream fis = new FileInputStream(modeloOrigem);
//			try {
//				assertTrue("Imagem do boleto "+(i+1)+" não é igual ao modelo. Titulo: "+boletosParaTeste.get(i).getTitulo().getNumeroDocumento(),IOUtils.contentEquals(new ByteArrayInputStream(boletoImg.get(0)), fis));
//			} finally {
//				fis.close();
//			}
//
//			i++;
//		}
//
//	}
//	
//	@Test
//	public void deveGerarSomenteUmPDFComDadosIguaisAsImagensModelo() throws IOException, DocumentException{
//		BoletoConfiguration configuration = new BoletoConfigurationBuilder().author(ANTEROS_TECNOLOGIA)
//				.creationDate(sdf.format(dhGeracaoBoleto)).creator(EDSON_MARTINS).title(BOLETO_BANCARIO).subject(BOLETO_BANCARIO).keywords("BOLETO").fullCompression(true).groupResults().build();
//	
//		List<byte[]> boletosGerados = BoletoManager.getInstance().generate(configuration, boletosParaTeste);
//		assertNotNull(boletosGerados);
//		assertEquals(boletosGerados.size(),1);
//		List<byte[]> boletosImg = BoletoManager.getInstance().converPDFToImage(ImageType.PNG, 130, boletosGerados.get(0));
//		
//		int i = 0;
//		for (byte[] b : boletosImg) {
//			File modeloOrigem = ResourceUtils
//					.getFile("src/main/resources/pdf/boletos/BOLETO_" + (i+1) + "_" + boletosParaTeste.get(i).getTitulo()
//							.getContaBancaria().getBanco().getCodigoDeCompensacaoBACEN().getCodigoFormatado() + ".png");
//			
//			FileOutputStream fos = new FileOutputStream(modeloOrigem);
//			fos.write(b);
//			fos.flush();
//			fos.close();
//			
//			FileInputStream fis = new FileInputStream(modeloOrigem);
//			try {
//				assertTrue("Imagem do boleto "+(i+1)+" não é igual ao modelo. Titulo: "+boletosParaTeste.get(i).getTitulo().getNumeroDocumento(),IOUtils.contentEquals(new ByteArrayInputStream(b), fis));
//			} finally {
//				fis.close();
//			}
//
//			i++;
//		}
//	}
//	
//	@Test
//	public void deveGerarBoletoComLinhaDigitavelValida(){
//		assertNotNull(boletosParaTeste);
//		assertEquals(boletosParaTeste.size(), 4);
//
//		assertEquals(boletosParaTeste.get(0).getLinhaDigitavel().write(), "39995.00949 01448.112126 00232.320010 1 67900001234734");
//		assertEquals(boletosParaTeste.get(1).getLinhaDigitavel().write(), "39995.00949 01449.112125 00232.320010 7 67900005234714");
//		assertEquals(boletosParaTeste.get(2).getLinhaDigitavel().write(), "39995.00949 01440.112124 00232.320010 2 67900006124724");
//		assertEquals(boletosParaTeste.get(3).getLinhaDigitavel().write(), "39995.00949 01447.112127 00232.320010 1 67900000023454");
//	}
//
//}
