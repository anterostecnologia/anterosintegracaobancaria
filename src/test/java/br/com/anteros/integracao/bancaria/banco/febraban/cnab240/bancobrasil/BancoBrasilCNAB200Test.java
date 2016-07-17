package br.com.anteros.integracao.bancaria.banco.febraban.cnab240.bancobrasil;

import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.RETORNO_CONCILIACAO_BANCARIA;

import java.io.File;
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
import br.com.anteros.integracao.bancaria.banco.Banco;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.builder.CNAB240Helper;
import br.com.anteros.integracao.bancaria.banco.layout.ConciliacaoBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.cnab200.extrato.CNAB200;
import br.com.anteros.integracao.bancaria.banco.layout.cnab200.extrato.bancobrasil.BancoBrasilCNAB200;
import br.com.anteros.integracao.bancaria.boleto.BancosSuportados;

public class BancoBrasilCNAB200Test {


	private CNAB200 layoutExtratoCNAB200;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Before
	public void beforeExecuteTests() {
		Banco banco = BancosSuportados.BANCO_DO_BRASIL.create();
		ContaBancaria contaBancaria = CNAB240Helper.criarContaBancaria(banco);
		Calendar calendar = Calendar.getInstance();
		calendar.set(2016, Calendar.JULY, 1, 17, 15, 43);

		layoutExtratoCNAB200 = BancoBrasilCNAB200.of(contaBancaria);
	}

	@After
	public void afterExecuteTests() {

	}

	@Test
	public void deveGerarlSchemaXMLDoLayoutIgualAoModelo() throws IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException, IOException {
		File file = ResourceUtils.getFile("src/main/resources/layouts/Layout-CNAB200-BancoBrasil.xml");

		String schema = StringUtils.removeCRLF(new String(layoutExtratoCNAB200.getXMLSchema(), "UTF-8"));
//
//		 FileOutputStream fos = new FileOutputStream(file);
//		 fos.write(schema.getBytes());
//		 fos.flush();
//		 fos.close();

		String fileSchema = StringUtils.removeCRLF(IOUtils.readFileToString(file, "UTF-8"));

		Assert.assertEquals("Banco do Brasil: Arquivo XML gerado diferente do modelo.", fileSchema, schema);
	}

	
	@Test
	public void deveLerArquivoRetornoConciliacaoBancariaEValidarValores() throws IllegalArgumentException, IllegalAccessException, IOException, FlatFileManagerException, JAXBException{
		File file = new File("src/main/resources/arquivos-retorno/EXT_CNAB200_BancoBrasil.RET");
		List<ConciliacaoBancaria> conciliacaoBancaria = layoutExtratoCNAB200.read(file, new String[] { RETORNO_CONCILIACAO_BANCARIA });
		Calendar dtLancamento = Calendar.getInstance();
		dtLancamento.set(2011, Calendar.APRIL, 11,0,0,0);
		
		Assert.assertTrue(conciliacaoBancaria!=null);
		Assert.assertEquals("Banco do Brasil: Número de retornos lido incorreto.", conciliacaoBancaria.size(), 1);
		Assert.assertEquals("Banco do Brasil: Saldo anterior incorreto: ",conciliacaoBancaria.get(0).getSaldoAnterior().getValorSaldoAnterior(),new BigDecimal("238497.11"));
		Assert.assertTrue("Banco do Brasil: Número de lançamentos lido incorreto.",conciliacaoBancaria.get(0).getLancamentos().size()==241);
		Assert.assertEquals("Banco do Brasil: Data lançamento incorreto: ",sdf.format(conciliacaoBancaria.get(0).getLancamentos().get(0).getDataLancamento()),sdf.format(dtLancamento.getTime()));
		Assert.assertEquals("Banco do Brasil: Tipo débito/crédito incorreto: ",conciliacaoBancaria.get(0).getLancamentos().get(0).getDebitoCredito(),"C");
		Assert.assertEquals("Banco do Brasil: Valor do lançamento incorreto: ",conciliacaoBancaria.get(0).getLancamentos().get(0).getValorLancamento(),new BigDecimal("700.00"));
		Assert.assertEquals("Banco do Brasil: Histórico do lançamento incorreto: ",conciliacaoBancaria.get(0).getLancamentos().get(0).getHistoricoLancamento(),"LIB DEP BLQ 1D");
		Assert.assertEquals("Banco do Brasil: Número do documento: ",conciliacaoBancaria.get(0).getLancamentos().get(0).getNumeroDocumento(),"453920");
		Assert.assertEquals("Banco do Brasil: Agência de origem incorreta: ",conciliacaoBancaria.get(0).getLancamentos().get(0).getAgenciaOrigemLancamento().intValue(),3464);
		Assert.assertEquals("Banco do Brasil: Saldo atual incorreto: ",conciliacaoBancaria.get(0).getSaldoAtual().getValorSaldoAtual(),new BigDecimal("246751.93"));
	}
}
