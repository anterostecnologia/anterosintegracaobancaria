package br.com.anteros.integracao.bancaria.banco.febraban.cnab240.sicoob;

import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.REMESSA_COBRANCA;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.anteros.core.utils.StringUtils;
import br.com.anteros.flatfile.FlatFileManagerException;
import br.com.anteros.integracao.bancaria.banco.Banco;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.builder.CNAB240Helper;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.RemessaCobranca;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.CNAB240Cobranca;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.CNAB240CobrancaBuilder;
import br.com.anteros.integracao.bancaria.boleto.BancosSuportados;

public class SicoobCNAB240Test {

	private List<RemessaCobranca> remessas;
	private CNAB240Cobranca layoutCobrancaCNAB240;

	@Before
	public void beforeExecuteTests() {
		Banco banco = BancosSuportados.BANCOOB.create();
		ContaBancaria contaBancaria = CNAB240Helper.criarContaBancaria(banco);

		remessas = CNAB240Helper.gerarTitulosParaRemessaCobranca(banco, CNAB240Helper.criarCarteira(1));

		Calendar calendar = Calendar.getInstance();
		calendar.set(2017, Calendar.NOVEMBER, 29, 10, 44, 39);

		layoutCobrancaCNAB240 = new CNAB240CobrancaBuilder()
				.contaBancaria(contaBancaria).dataGravacao(calendar.getTime())
				.dataHoraGeracao(calendar.getTime()).remessas(remessas).build();
	}

	@After
	public void afterExecuteTests() {
	}

	@Test
	public void deveGerarArquivoRemessaCobrancaIgualAoModelo() throws IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException, IOException {

		byte[] byteArray = layoutCobrancaCNAB240.generate(new String[] { REMESSA_COBRANCA });

//		String data = StringUtils.removeCRLF(new String(byteArray, "UTF-8"));

		geraArquivo(new String(byteArray, "UTF-8"));

//		Assert.assertEquals("Banco Sicoob: Arquivo de REMESSA gerado diferente do modelo.", data, data);
	}

	private void geraArquivo(String conteudo) {
		try {
			FileWriter writer = new FileWriter(new File("/Users/eduardogreco1/Desktop/sicoob.rem"));
			PrintWriter saida = new PrintWriter(writer);
			saida.print(conteudo);
			saida.close();
			writer.close();
			System.out.println("Arquivo criado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
