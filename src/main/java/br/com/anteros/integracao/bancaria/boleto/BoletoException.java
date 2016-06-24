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
package br.com.anteros.integracao.bancaria.boleto;

/**
 * 
 * <p>
 * Qualquer exceção gerada durante a geração de um Boleto gera uma <code>BoletoExceptiton</code>. Centraliza e localiza os problemas relativos a geração de um boleto.
 * </p>
 * 
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 * 
 */

public class BoletoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3874521668322644183L;

	/**
	 * 
	 */
	public BoletoException() {
		
	}

	/**
	 * @param message
	 * @param cause
	 */
	public BoletoException(String message, Throwable cause) {
		super(message, cause);
		
	}

	/**
	 * @param message
	 */
	public BoletoException(String message) {
		super(message);
		
	}

	/**
	 * @param cause
	 */
	public BoletoException(Throwable cause) {
		super(cause);
		
	}

}
