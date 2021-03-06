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


package br.com.anteros.integracao.bancaria.banco;



/**
 * <p>
 *  Representação básica de uma Pessoa Jurídica.
 * </p>
 * 
 * @see Pessoa
 * @see br.com.anteros.automacao.bancaria.comum.pessoa.id.cprf.CPRF
 * @see br.com.anteros.automacao.bancaria.comum.pessoa.id.cprf.CNPJ
 * 
 */
public class PessoaJuridica extends Pessoa implements br.com.anteros.automacao.bancaria.comum.pessoa.PessoaJuridica {

	private Long inscricaoEstadual;
	
	private Long inscricaoMunicipal;
	
	/**
	 *  Título do estabelecimento, diferente do <code>nome</code> (NOME EMPRESARIAL). 
	 */
	private String nomeFantasia;

	
	public Long getInscricaoEstadual() {

		return inscricaoEstadual;
	}

	
	public Long getInscricaoMunicipal() {

		return inscricaoMunicipal;
	}

	
	public String getNomeFantasia() {

		return nomeFantasia;
	}

	
	public void setInscricaoEstadual(Long inscricaoEstadual) {

		this.inscricaoEstadual = inscricaoEstadual;
	}

	
	public void setInscricaoMunicipal(Long inscricaoMunicipal) {

		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	
	public void setNomeFantasia(String nomeFantasia) {

		this.nomeFantasia = nomeFantasia;
	}

}
