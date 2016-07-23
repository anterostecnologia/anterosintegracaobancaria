package br.com.anteros.integracao.bancaria.banco.febraban.cnab240.caixa;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.anteros.flatfile.FlatFileManagerException;
import br.com.anteros.integracao.bancaria.banco.Banco;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.builder.CNAB240Helper;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.RemessaCobranca;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.CNAB240Cobranca;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.CNAB240CobrancaBuilder;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.CNAB240Extrato;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.CNAB240ExtratoBuilder;
import br.com.anteros.integracao.bancaria.boleto.BancosSuportados;

public class CaixaCNAB240Test {

	private List<RemessaCobranca> remessas;
	private CNAB240Cobranca layoutCobrancaCNAB240;
	private CNAB240Extrato layoutExtratoCNAB240;

	@Before
	public void beforeExecuteTests() {
		
		Banco banco = BancosSuportados.CAIXA_ECONOMICA_FEDERAL.create();
		ContaBancaria contaBancaria = CNAB240Helper.criarContaBancaria(banco);
		
		remessas = CNAB240Helper.gerarTitulosParaRemessaCobranca(banco,CNAB240Helper.criarCarteira(1));

		Calendar calendar = Calendar.getInstance();
		calendar.set(2016, Calendar.JULY, 1, 17, 15, 43);

		layoutCobrancaCNAB240 = new CNAB240CobrancaBuilder().contaBancaria(remessas.get(0).getTitulo().getContaBancaria())
				.dataGravacao(calendar.getTime()).dataHoraGeracao(calendar.getTime()).remessas(remessas).build();
		
		layoutExtratoCNAB240 = new CNAB240ExtratoBuilder().contaBancaria(contaBancaria)
				.dataHoraGeracao(calendar.getTime()).build();
	}

	@After
	public void afterExecuteTests() {

	}

//	@Test
//	public void deveGerarlSchemaXMLDoLayoutIgualAoModelo() throws IllegalArgumentException, IllegalAccessException,
//			FlatFileManagerException, JAXBException, IOException {
//		File file = ResourceUtils.getFile("src/main/resources/layouts/Layout-CNAB240-Caixa.xml");
//
//		String schema = StringUtils.removeCRLF(new String(layoutCobrancaCNAB240.getXMLSchema(), "UTF-8"));
//		
////		FileOutputStream fos = new FileOutputStream(file);
////		fos.write(schema.getBytes());
////		fos.flush();
////		fos.close();
//		
//		String fileSchema = StringUtils.removeCRLF(IOUtils.readFileToString(file, "UTF-8"));
//
//		Assert.assertEquals("Caixa: Arquivo XML gerado diferente do modelo.", fileSchema, schema);
//	}

//	@Test
//	public void deveGerarArquivoRemessaIgualAoModelo() throws IllegalArgumentException, IllegalAccessException,
//			FlatFileManagerException, JAXBException, IOException {
//
//		byte[] byteArray = layoutCobrancaCNAB240.generate(new String[] { REMESSA_COBRANCA });
//
//		File file = ResourceUtils.getFile("src/main/resources/arquivos-remessa/COB_CNAB240_Caixa.REM");
//		
////		FileOutputStream fos = new FileOutputStream(file);
////		fos.write(byteArray);
////		fos.flush();
////		fos.close();
//		
//		String fileData = StringUtils.removeCRLF(IOUtils.readFileToString(file, "UTF-8"));
//		String data = StringUtils.removeCRLF(new String(byteArray, "UTF-8"));
//
//		Assert.assertEquals("Caixa: Arquivo de REMESSA gerado diferente do modelo.", fileData, data);
//	}
	
	@Test
	public void deveLerArquivoRetornoCobrancaEValidarValores() throws IllegalArgumentException, IllegalAccessException,
			IOException, FlatFileManagerException, JAXBException {
	}
	
	@Test
	public void deveLerArquivoRetornoConciliacaoBancariaEValidarValores() throws IllegalArgumentException, IllegalAccessException,
			IOException, FlatFileManagerException, JAXBException {
//		File file = new File("src/main/resources/arquivos-retorno/EXT_CNAB240_Caixa.RET");
//		List<ConciliacaoBancaria> conciliacaoBancaria = layoutExtratoCNAB240.read(file, new String[] { RETORNO_CONCILIACAO_BANCARIA });
//		 
//		Calendar dtLancamento = Calendar.getInstance();
//		dtLancamento.set(2011, Calendar.APRIL, 11,0,0,0);
//		
//		System.out.println(conciliacaoBancaria);
		
	}
}
