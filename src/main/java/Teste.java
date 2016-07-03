/*******************************************************************************
 * Copyright 2016 Anteros Tecnologia
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBException;

import br.com.anteros.automacao.bancaria.comum.pessoa.endereco.CEP;
import br.com.anteros.automacao.bancaria.comum.pessoa.endereco.Endereco;
import br.com.anteros.automacao.bancaria.comum.pessoa.endereco.UnidadeFederativa;
import br.com.anteros.flatfile.FlatFileManagerException;
import br.com.anteros.integracao.bancaria.banco.febraban.Agencia;
import br.com.anteros.integracao.bancaria.banco.febraban.Carteira;
import br.com.anteros.integracao.bancaria.banco.febraban.Cedente;
import br.com.anteros.integracao.bancaria.banco.febraban.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.febraban.NumeroDaConta;
import br.com.anteros.integracao.bancaria.banco.febraban.RemessaCobranca;
import br.com.anteros.integracao.bancaria.banco.febraban.RetornoCobranca;
import br.com.anteros.integracao.bancaria.banco.febraban.Sacado;
import br.com.anteros.integracao.bancaria.banco.febraban.TipoDeBaixaDevolucao;
import br.com.anteros.integracao.bancaria.banco.febraban.TipoDeCobranca;
import br.com.anteros.integracao.bancaria.banco.febraban.TipoDeDesconto;
import br.com.anteros.integracao.bancaria.banco.febraban.TipoDeDistribuicaoBoleto;
import br.com.anteros.integracao.bancaria.banco.febraban.TipoDeEmissaoBoleto;
import br.com.anteros.integracao.bancaria.banco.febraban.TipoDeJurosMora;
import br.com.anteros.integracao.bancaria.banco.febraban.TipoDeMovimentoRemessa;
import br.com.anteros.integracao.bancaria.banco.febraban.TipoDeProtesto;
import br.com.anteros.integracao.bancaria.banco.febraban.TipoDeTitulo;
import br.com.anteros.integracao.bancaria.banco.febraban.Titulo;
import br.com.anteros.integracao.bancaria.banco.febraban.Titulo.Aceite;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.CNAB240;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.CNAB240Factory;
import br.com.anteros.integracao.bancaria.boleto.BancosSuportados;
import br.com.anteros.integracao.bancaria.boleto.Boleto;

import com.lowagie.text.DocumentException;

public class Teste {

	public static void main(String[] args) throws IOException, DocumentException, FlatFileManagerException, JAXBException, IllegalArgumentException, IllegalAccessException {

		
		ContaBancaria contaBancaria = Teste.crieUmaContaBancaria();
		
		List<RemessaCobranca> remessas = new ArrayList<RemessaCobranca>();
		
		remessas.add(criarRemessaBancaria(contaBancaria));
		remessas.add(criarRemessaBancaria(contaBancaria));
		remessas.add(criarRemessaBancaria(contaBancaria));
		remessas.add(criarRemessaBancaria(contaBancaria));
		remessas.add(criarRemessaBancaria(contaBancaria));
		remessas.add(criarRemessaBancaria(contaBancaria));
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(2016, Calendar.JULY, 1, 17, 15, 43);
		
		CNAB240 layoutCNAB240 = CNAB240Factory.create(contaBancaria, calendar.getTime(), calendar.getTime());
//		
//		/*
//		 * Teste para gerar arquivo
//		 */
//		byte[] data = layoutCNAB240.generate(new String[]{"REMESSA"});
//		System.out.println(new String(data));
//		
//
//		 List<RetornoCobranca> result = layoutCNAB240.read(data, new String[]{"RETORNO"});
//		
//		 for (RetornoCobranca retorno : result){
//			 System.out.println(retorno);
//		 }
//		
		/*
		 * Teste para ler arquivo
		 */
	     File file = new File("src/main/java/BANCOBRASIL.ret");
		 List<RetornoCobranca> result = layoutCNAB240.read(file, new String[]{"RETORNO"});
		
		 for (RetornoCobranca retorno : result){
			 System.out.println(retorno);
		 }
		 
		 
		
		
//		
		//FlatFile<Record> createFlatFile = Texgit.createFlatFile("src/main/java/leiaute_remessa_brasil_400.txg.xml");
//		
//		
//
//		BoletoConfiguration configuration = new BoletoConfigurationBuilder().destinationPath("/Users/edson").groupResults().build();
//
//		Boleto boleto1 = new Teste().criarBoleto();
//		Boleto boleto2 = new Teste().criarBoleto();
//		Boleto boleto3 = new Teste().criarBoleto();
//		Boleto boleto4 = new Teste().criarBoleto();
//		Boleto boleto5 = new Teste().criarBoleto();
//		Boleto boleto6 = new Teste().criarBoleto();
//
//		List<File> boletosGerados = BoletoManager.getInstance().generateToFile(configuration, boleto1,
//				boleto2, boleto3, boleto4, boleto5, boleto6);
//
//		for (File file : boletosGerados){
//			System.out.println(file.getName());
//		}
		
		
//		Banco banco = new Banco(new CodigoDeCompensacaoBACEN(1), "Banco do Brasil S/A");
//		Agencia agencia = new Agencia(1465,"6");
//		ContaBancaria contaBancaria = new ContaBancaria(banco);
//		contaBancaria.setAgencia(agencia);
//		contaBancaria.setNumeroDaConta(new NumeroDaConta(2167,"9"));
//		
//		CNAB240 cnab240 = new CNAB240(contaBancaria);
//		System.out.println(cnab240);

	}
	
	
	public static RemessaCobranca criarRemessaBancaria(ContaBancaria contaBancaria){
		Titulo titulo = new Titulo(contaBancaria, criarSacado(), criarCedente(), criarCarteira());
		titulo.setAceite(Aceite.N);
		titulo.setDataDesconto(new Date());
		titulo.setDataDoDocumento(new Date());
		titulo.setDataDoVencimento(new Date());
		titulo.setDataJurosMora(new Date());
		titulo.setDigitoDoNossoNumero("3");
		titulo.setNossoNumero("19060420000953675");
		titulo.setJurosMora(BigDecimal.ZERO);
		titulo.setNrDiasBaixaDevolucao(10);
		titulo.setNrDiasProtesto(5);
		titulo.setNumeroDoDocumento("10000");
		titulo.setPercentualDesconto(new BigDecimal("2.5"));
		titulo.setTipoDeBaixaDevolucao(TipoDeBaixaDevolucao.BAIXAR_DEVOLVER);
		titulo.setTipoDeDesconto(TipoDeDesconto.VALOR_FIXO_ATE_A_DATA);
		titulo.setTipoDeDocumento(TipoDeTitulo.DM_DUPLICATA_MERCANTIL);
		titulo.setTipoDeJurosMora(TipoDeJurosMora.VALOR_POR_DIA);
		titulo.setTipoDeProtesto(TipoDeProtesto.NAO_PROTESTAR);
		titulo.setValor(new BigDecimal("1543.45"));
		titulo.setValorAbatimento(new BigDecimal("100"));
		titulo.setValorAcrecimo(new BigDecimal("200"));
		titulo.setValorCobrado(new BigDecimal("1543.45"));
		titulo.setValorDeducao(new BigDecimal("154"));
		titulo.setValorDesconto(new BigDecimal("15"));
		titulo.setValorIOF(new BigDecimal("10"));
		titulo.setValorJurosMora(new BigDecimal("15"));
		RemessaCobranca remessaCobranca = new RemessaCobranca();
		remessaCobranca.setCodigoMovimentoRemessa(TipoDeMovimentoRemessa.ENTRADA_TITULOS);
		remessaCobranca.setNrLote(100L);
		remessaCobranca.setTitulo(titulo);
		return remessaCobranca;
	}
	

	/**
	 * Cria um boleto, em passos distintos, com os dados necessários para a
	 * visualização.
	 * 
	 * @return boleto com dados
	 */
	public static Boleto criarBoleto() {

		/*
		 * PASSO 1: Você precisa dos dados de uma conta bancária habilitada para
		 * emissão de boletos.
		 */
		ContaBancaria contaBancaria = crieUmaContaBancaria();

		/*
		 * PASSO 2: Informe os dados do cedente.
		 */
		Cedente cedente = criarCedente();

		/*
		 * PASSO 3: Informe os dados do Sacado.
		 */
		Sacado sacado = criarSacado();
		
		Carteira carteira = criarCarteira();

		/*
		 * PASSO 4: Crie um novo título/cobrança e informe os dados.
		 */
		Titulo titulo = criarOsDadosDoNovoTitulo(new Titulo(contaBancaria, sacado, cedente, carteira));

		/*
		 * PASSO 5: Crie o boleto e informe os dados necessários.
		 */
		Boleto boleto = criarOsDadosDoNovoBoleto(new Boleto(titulo));

		return boleto;
	}
	
	public static Carteira criarCarteira(){
		Carteira carteira = new Carteira();
		carteira.setCodigo(1);
		carteira.setNome("COBRANCA SIMPLES");
		carteira.setTipoDeCobranca(TipoDeCobranca.COM_REGISTRO);
		carteira.setTipoDeDistribuicaoBoleto(TipoDeDistribuicaoBoleto.CLIENTE_DISTRIBUI);
		carteira.setTipoDeEmissaoBoleto(TipoDeEmissaoBoleto.CLIENTE_EMITE);
		return carteira;
	}

	/**
	 * Preenche os principais dados do boleto.
	 * 
	 * @param boleto
	 * @return boleto com os dados necssários
	 */
	public static final Boleto criarOsDadosDoNovoBoleto(Boleto boleto) {

		boleto.setLocalPagamento("Pagável preferencialmente na Rede X ou em qualquer Banco até o Vencimento.");
		boleto.setInstrucaoAoSacado(
				"Senhor sacado, sabemos sim que o valor cobrado não é o esperado, aproveite o DESCONTÃO!");
		boleto.setInstrucao1("PARA PAGAMENTO 1 até Hoje não cobrar nada!");
		boleto.setInstrucao2("PARA PAGAMENTO 2 até Amanhã Não cobre!");
		boleto.setInstrucao3("PARA PAGAMENTO 3 até Depois de amanhã, OK, não cobre.");
		boleto.setInstrucao4("PARA PAGAMENTO 4 até 04/xx/xxxx de 4 dias atrás COBRAR O VALOR DE: R$ 01,00");
		boleto.setInstrucao5("PARA PAGAMENTO 5 até 05/xx/xxxx COBRAR O VALOR DE: R$ 02,00");
		boleto.setInstrucao6("PARA PAGAMENTO 6 até 06/xx/xxxx COBRAR O VALOR DE: R$ 03,00");
		boleto.setInstrucao7("PARA PAGAMENTO 7 até xx/xx/xxxx COBRAR O VALOR QUE VOCÊ QUISER!");
		boleto.setInstrucao8("APÓS o Vencimento, Pagável Somente na Rede X.");

		return boleto;
	}

	/**
	 * Preenche os principais dados do título.
	 * 
	 * @param titulo
	 * 
	 * @return título com os dados necssários
	 */
	public static final Titulo criarOsDadosDoNovoTitulo(Titulo titulo) {

		/*
		 * DADOS BÁSICOS.
		 */

		titulo.setNumeroDoDocumento("123456");
		titulo.setNossoNumero("99345678912");
		titulo.setDigitoDoNossoNumero("5");
		titulo.setValor(BigDecimal.valueOf(0.23));

		// Para informar a data de maneira simples você pode utilizar as
		// classes utilitárias do JRimum. Abaixo temos alguns exemplos:
		// (1) titulo.setDataDoVencimento(
		// DateFormat.DDMMYYYY_B.parse("11/03/2011") );
		// (2) titulo.setDataDoVencimento( Dates.parse("11/03/2011",
		// "dd/MM/yyyy") );
		titulo.setDataDoDocumento(new Date());
		titulo.setDataDoVencimento(new Date());

		titulo.setTipoDeDocumento(TipoDeTitulo.DM_DUPLICATA_MERCANTIL);
		titulo.setAceite(Aceite.A);
		titulo.setValorDesconto(new BigDecimal(0.05));
		titulo.setValorDeducao(BigDecimal.ZERO);
		titulo.setValorJurosMora(BigDecimal.ZERO);
		titulo.setValorAcrecimo(BigDecimal.ZERO);
		titulo.setValorCobrado(BigDecimal.ZERO);

		return titulo;
	}

	/**
	 * Cria uma instância de sacado com os principais dados para o boleto.
	 * 
	 * @return sacado com os dados necssários
	 */
	public static final Sacado criarSacado() {

		Sacado sacado = new Sacado("Java One", "222.222.222-22");

		// Informando o endereço do sacado.
		Endereco enderecoSac = new Endereco();
		enderecoSac.setUF(UnidadeFederativa.PR);
		enderecoSac.setLocalidade("Araruna");
		enderecoSac.setCep(new CEP("87260-000"));
		enderecoSac.setBairro("Grande Centro");
		enderecoSac.setLogradouro("Av. Presidente Vargas");
		enderecoSac.setNumero("240");
		sacado.addEndereco(enderecoSac);

		return sacado;
	}

	/**
	 * Cria uma instância de cedente com os principais dados para o boleto.
	 * 
	 * @return cedente com os dados necssários
	 */
	public static final Cedente criarCedente() {

		return new Cedente("Anteros Tecnologia", "00.000.208/0001-00");
	}

	/**
	 * Cria uma instância de conta bancária com os principais dados para o
	 * boleto em questão (Banco Bradesco).
	 * 
	 * @return conta com os dados necssários
	 */
	public static final ContaBancaria crieUmaContaBancaria() {

		ContaBancaria contaBancaria = new ContaBancaria(BancosSuportados.BANCO_DO_BRASIL.create());
		contaBancaria.setNumeroDaConta(new NumeroDaConta(123456, "0"));
		contaBancaria.setAgencia(new Agencia(1234, "1"));

		return contaBancaria;
	}

}
