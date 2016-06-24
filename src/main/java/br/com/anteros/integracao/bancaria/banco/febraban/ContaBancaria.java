package br.com.anteros.integracao.bancaria.banco.febraban;

import java.util.Collection;


import br.com.anteros.integracao.bancaria.banco.Banco;
import br.com.anteros.integracao.bancaria.banco.Pessoa;


/**
 * 
 * <p>
 * É um vínculo entre uma Pessoa e um Banco que agrega a agência, o número da conta
 * ou o código do cedente e a carteira.
 * </p>
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 * 
 * @see br.com.anteros.automacao.bancaria.comum.pessoa.Pessoa
 * @see Banco
 */
public class ContaBancaria {

	/**
	 * @see Banco
	 */
	private Banco banco;

	/**
	 * @see Agencia
	 */
	private Agencia agencia;
	
	/**
	 * @see NumeroDaConta
	 */
	private NumeroDaConta numeroDaConta;
	
	/**
	 * @see Modalidade
	 */
	private Modalidade modalidade;
	
	
	public ContaBancaria() {}
	
	public ContaBancaria(Banco banco) {
		
		this.banco = banco;
	}
	

	/**
	 * @see Banco
	 */
	public Banco getBanco() {
		return banco;
	}
	
	/**
	 * @see Banco
	 */
	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	

	/**
	 * @see Agencia
	 */
	public Agencia getAgencia() {
		return agencia;
	}

	/**
	 * @see Agencia
	 */
	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	/**
	 * @see NumeroDaConta
	 */
	public NumeroDaConta getNumeroDaConta() {
		return numeroDaConta;
	}

	/**
	 * @see NumeroDaConta
	 */
	public void setNumeroDaConta(NumeroDaConta numeroDaConta) {
		this.numeroDaConta = numeroDaConta;
	}

	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

	@Override
	public String toString() {
		return "ContaBancaria [banco=" + banco + ", agencia=" + agencia + ", numeroDaConta=" + numeroDaConta
				+ ", modalidade="
				+ modalidade + "]";
	}

}
