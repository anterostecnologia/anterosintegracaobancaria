package br.com.anteros.integracao.bancaria.banco.febraban.cnab240.bradesco;

import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.RETORNO_CONCILIACAO_BANCARIA;

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
import br.com.anteros.integracao.bancaria.banco.Banco;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.builder.CNAB240Helper;
import br.com.anteros.integracao.bancaria.banco.layout.ConciliacaoBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.cnab200.extrato.CNAB200;
import br.com.anteros.integracao.bancaria.banco.layout.cnab200.extrato.bradesco.BradescoCNAB200;
import br.com.anteros.integracao.bancaria.boleto.BancosSuportados;

public class BradescoCNAB200Test {


	private CNAB200 layoutExtratoCNAB200;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Before
	public void beforeExecuteTests() {
		Banco banco = BancosSuportados.BANCO_BRADESCO.create();
		ContaBancaria contaBancaria = CNAB240Helper.criarContaBancaria(banco);
		Calendar calendar = Calendar.getInstance();
		calendar.set(2016, Calendar.JULY, 1, 17, 15, 43);

		layoutExtratoCNAB200 = BradescoCNAB200.of(contaBancaria);
	}

	@After
	public void afterExecuteTests() {

	}

	@Test
	public void deveGerarlSchemaXMLDoLayoutIgualAoModelo() throws IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException, IOException {
		File file = ResourceUtils.getFile("src/main/resources/layouts/Layout-CNAB200-Bradesco.xml");

		String schema = StringUtils.removeCRLF(new String(layoutExtratoCNAB200.getXMLSchema(), "UTF-8"));

//		 FileOutputStream fos = new FileOutputStream(file);
//		 fos.write(schema.getBytes());
//		 fos.flush();
//		 fos.close();

		String fileSchema = StringUtils.removeCRLF(IOUtils.readFileToString(file, "UTF-8"));

		Assert.assertEquals("Bradesco: Arquivo XML gerado diferente do modelo.", fileSchema, schema);
	}

	
	@Test
	public void deveLerArquivoRetornoConciliacaoBancariaEValidarValores() throws IllegalArgumentException, IllegalAccessException, IOException, FlatFileManagerException, JAXBException{
		File file = new File("src/main/resources/arquivos-retorno/EXT_CNAB200_Bradesco.RET");
		List<ConciliacaoBancaria> conciliacaoBancaria = layoutExtratoCNAB200.read(file, new String[] { RETORNO_CONCILIACAO_BANCARIA });
		Calendar dtLancamento = Calendar.getInstance();
		dtLancamento.set(2016, Calendar.JULY, 7,0,0,0);
		
		Assert.assertTrue(conciliacaoBancaria!=null);
		Assert.assertEquals("Bradesco: Número de retornos lido incorreto.", conciliacaoBancaria.size(), 1);
		Assert.assertEquals("Bradesco: Saldo anterior incorreto: ",conciliacaoBancaria.get(0).getSaldoAnterior().getValorSaldoAnterior(),new BigDecimal("33406.50"));
		Assert.assertTrue("Bradesco: Número de lançamentos lido incorreto.",conciliacaoBancaria.get(0).getLancamentos().size()==12);
		Assert.assertEquals("Bradesco: Data lançamento incorreto: ",sdf.format(conciliacaoBancaria.get(0).getLancamentos().get(0).getDataLancamento()),sdf.format(dtLancamento.getTime()));
		Assert.assertEquals("Bradesco: Tipo débito/crédito incorreto: ",conciliacaoBancaria.get(0).getLancamentos().get(0).getDebitoCredito(),"C");
		Assert.assertEquals("Bradesco: Valor do lançamento incorreto: ",conciliacaoBancaria.get(0).getLancamentos().get(0).getValorLancamento(),new BigDecimal("6997.30"));
		Assert.assertEquals("Bradesco: Histórico do lançamento incorreto: ",conciliacaoBancaria.get(0).getLancamentos().get(0).getHistoricoLancamento(),"RESGATE MERCADO ABERTO");
		Assert.assertEquals("Bradesco: Número do documento: ",conciliacaoBancaria.get(0).getLancamentos().get(0).getNumeroDocumento(),"685716");
		Assert.assertEquals("Bradesco: Saldo atual incorreto: ",conciliacaoBancaria.get(0).getSaldoAtual().getValorSaldoAtual(),new BigDecimal("22987.46"));

	}
}
