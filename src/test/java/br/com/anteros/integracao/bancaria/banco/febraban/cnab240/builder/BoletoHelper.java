package br.com.anteros.integracao.bancaria.banco.febraban.cnab240.builder;

import java.util.ArrayList;
import java.util.List;

import br.com.anteros.integracao.bancaria.banco.Banco;
import br.com.anteros.integracao.bancaria.banco.febraban.RemessaCobranca;
import br.com.anteros.integracao.bancaria.banco.febraban.Titulo;
import br.com.anteros.integracao.bancaria.boleto.Boleto;

public class BoletoHelper {
	
	public static final String EDSON_MARTINS = "EDSON MARTINS";
	public static final String ANTEROS_TECNOLOGIA = "Anteros Tecnologia";
	
	
	public static List<Boleto> geraBoletosParaTeste(Banco banco, List<RemessaCobranca> remessas){
		List<Boleto> boletos = new ArrayList<Boleto>();
	    for (RemessaCobranca remessa : remessas){
	    	boletos.add(criarBoleto(banco, remessa.getTitulo()));
	    }
		return boletos;
	}
	
	private static Boleto criarBoleto(Banco banco, Titulo titulo) {
		Boleto boleto = criarOsDadosDoNovoBoleto(new Boleto(titulo));

		return boleto;
	}
	
	/**
	 * Preenche os principais dados do boleto.
	 * 
	 * @param boleto
	 * @return boleto com os dados necssários
	 */
	private static final Boleto criarOsDadosDoNovoBoleto(Boleto boleto) {

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
}
