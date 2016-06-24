package br.com.anteros.automacao.bancaria.parametro;

import br.com.anteros.automacao.bancaria.boleto.BancosSuportados;
import br.com.anteros.integracao.bancaria.banco.ParametroBancario;

/**
 * Parâmetros bancários específicos para o
 * {@link BancosSuportados#BANCO_SICREDI}.
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 * 
 * @version 0.2.3
 * 
 * @since 0.2
 */
public enum ParametroBancoSicredi implements ParametroBancario<ParametroBancoSicredi>{
	/**
	 * Nome do parâmetro bancário contendo o valor do posto da agência SICREDI.
	 */
	POSTO_DA_AGENCIA;
}
