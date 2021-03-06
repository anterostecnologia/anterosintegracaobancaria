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
package br.com.anteros.automacao.bancaria.comum.pessoa.endereco;

/**
 * <p>
 * Entidade que encapsula dados do endereço de uma pessoa, como também 
 * facilidades na manipulação dos seus atributos.
 * </p>
 *
 */
public class Endereco {

	/**
	 * Nome da rua, avenida, etc.
	 */
	private String logradouro;
	
	/**
	 * Número que identifica o lugar no logradouro (ex: número da casa).
	 */
	private String numero;
	
	/**
	 * Informação adicional para identificar o estabelecimento na rua.
	 */
	private String complemento;
	
	/**
	 * Cada uma das divisões de uma cidade ou povoação.
	 */
	private String bairro;
	
	/**
	 * Cidade, município, etc.
	 */
	private String localidade;
	
	/**
	 * @see CEP
	 */
	private CEP cep;
	
	/**
	 * @see UnidadeFederativa
	 */
	private UnidadeFederativa uf;
	
	private String pais;
		
	public Endereco() {}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @return the localidade
	 */
	public String getLocalidade() {
		return localidade;
	}

	/**
	 * @param localidade the localidade to set
	 */
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public UnidadeFederativa getUF() {
		return uf;
	}

	public void setUF(UnidadeFederativa uf) {
		this.uf = uf;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public CEP getCEP() {
		return cep;
	}

	public void setCep(CEP cep) {
		this.cep = cep;
	}
	
	public void setCep(String cep) {
		setCep(new CEP(cep));
	}

	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Endereco [logradouro=" + logradouro + ", numero=" + numero + ", complemento=" + complemento
				+ ", bairro=" + bairro + ", localidade=" + localidade + ", cep=" + cep + ", uf=" + uf + ", pais=" + pais
				+ "]";
	}
	
	
	
}
