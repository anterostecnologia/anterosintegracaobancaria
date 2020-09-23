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


/**
 * 
 * <p>
 * Identifica uma conta bancária e assume os sinônimos:
 * <ul>
 * <li>Código do cedente</li>
 * <li>Convênio</li>
 * </ul>
 * </p>
 * 
 */
public class NumeroDaConta {

	private Long codigoDaConta = 0L;

	private String digitoDaConta = "";
	
	public NumeroDaConta() {}
	
	public NumeroDaConta(Long codigoDaConta) {
		
		this.codigoDaConta = codigoDaConta;
	}
	
	public NumeroDaConta(Long codigoDaConta, String digitoDaConta) {
		
		this.codigoDaConta = codigoDaConta;
		this.digitoDaConta = digitoDaConta;
	}

	public Long getCodigoDaConta() {
		return codigoDaConta;
	}

	public void setCodigoDaConta(Long codigoDaConta) {
		this.codigoDaConta = codigoDaConta;
	}

	public String getDigitoDaConta() {
		return digitoDaConta;
	}

	public void setDigitoDaConta(String digitoDaConta) {
		this.digitoDaConta = digitoDaConta;
	}

	@Override
	public String toString() {
		return "NumeroDaConta [codigoDaConta=" + codigoDaConta + ", digitoDaConta=" + digitoDaConta + "]";
	}
	
}
