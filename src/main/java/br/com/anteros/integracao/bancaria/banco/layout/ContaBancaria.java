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
package br.com.anteros.integracao.bancaria.banco.layout;

import br.com.anteros.integracao.bancaria.banco.Banco;

/**
 * 
 * <p>
 * É um vínculo entre uma Pessoa e um Banco que agrega a agência, o número da
 * conta ou o código do cedente e a carteira.
 * </p>
 * 
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

	public ContaBancaria() {
	}

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
		return "ContaBancaria [banco=" + banco.getCodigoDeCompensacaoBACEN().getCodigo() + " " + banco.getNome()
				+ ", agencia=" + agencia.getCodigo() + " " + agencia.getDigitoVerificador() + ", numeroDaConta="
				+ numeroDaConta.getCodigoDaConta() + " " + numeroDaConta.getDigitoDaConta() + ", modalidade="
				+ modalidade + "]";
	}

}
