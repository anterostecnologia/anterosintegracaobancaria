package br.com.anteros.automacao.bancaria.parametro;

import br.com.anteros.automacao.bancaria.boleto.BancosSuportados;
import br.com.anteros.integracao.bancaria.banco.ParametroBancario;

/**
 * Parâmetros bancários específicos para o
 * {@link BancosSuportados#BANCO_SANTANDER}.
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 * 
 * @version 0.2.3
 * 
 * @since 0.2
 */
public enum ParametroBancoSantander implements ParametroBancario<ParametroBancoSantander>{
	/**
	 * Chave de pesquisa em parâmetros bancários para saber se o boelto deve
	 * usar IOF – Seguradoras: (Se 7% informar 7. Limitado a 9%); Demais
	 * clientes usar 0 (zero).
	 */
	IOF_SEGURADORA;
}
