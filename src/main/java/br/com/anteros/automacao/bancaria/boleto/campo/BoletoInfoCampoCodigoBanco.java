package br.com.anteros.automacao.bancaria.boleto.campo;

import br.com.anteros.integracao.bancaria.banco.febraban.ContaBancaria;

/**
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 */
public class BoletoInfoCampoCodigoBanco {

	/**
	 * Retorna o código de compensação do banco fomatado no estilo "001-9".
	 * 
	 * 
	 * @param conta
	 * @return string formatada para ser exibida no boleto
	 */
	public static String getTextoCodigoDoBanco(ContaBancaria conta){
		
		String codigoCompensacao = conta.getBanco().getCodigoDeCompensacaoBACEN().getCodigoFormatado();
		String digitoCompensacao = conta.getBanco().getCodigoDeCompensacaoBACEN().getDigito().toString();
		
		return codigoCompensacao + "-" + digitoCompensacao;
	}
}
