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
 * 
 * <p>
 * Representação básica de um CEP.
 * </p>
 * 
 */
public class CEP {

	/**
	 * Primeiros cinco dígitos.
	 * Exemplo: Para o CEP 59.020-300 o prefixo é o 59020.
	 */
	private Integer prefixo;
	
	/**
	 * Últimos dois dígitos.
	 * Exemplo: Para o CEP 59.020-300 o sufixo é o 300.
	 */
	private Integer sufixo;
	
	/**
	 * CEP completo (prefixo+sufixo).
	 * Exemplo: Para o CEP 59.020-300 o cep pode ser:
	 * <ul>
	 * <li>59.020-300<li>
	 * <li>59020300<li>
	 * </ul>
	 */
	private String cep;
	
	public CEP() {}
	
	public CEP(String cep) {
		
		this.cep = cep;
	}

	public Integer getPrefixo() {
		return prefixo;
	}

	public void setPrefixo(Integer prefixo) {
		this.prefixo = prefixo;
	}

	public Integer getSufixo() {
		return sufixo;
	}

	public void setSufixo(Integer sufixo) {
		this.sufixo = sufixo;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public Integer getCodigo(){
		String s = cep.replaceAll("[^0-9.]", "");
		return Integer.valueOf(s);
	}

	@Override
	public String toString() {
		return "CEP [prefixo=" + prefixo + ", sufixo=" + sufixo + ", cep=" + cep + "]";
	}

	
}
