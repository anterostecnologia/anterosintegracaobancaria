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
 * Qualquer exceção gerada durante a geração do Código de Barras gera uma <code>CodigoDeBarrasException</code>. Centraliza e localiza os problemas relativos a geração de um código de barras.
 * </p>
 * 
 * 
 */

public class CodigoDeBarrasException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3577770829101964833L;

	/**
	 * 
	 */
	public CodigoDeBarrasException() {
	
	}

	/**
	 * @param message
	 * @param cause
	 */
	public CodigoDeBarrasException(String message, Throwable cause) {
		super(message, cause);
	
	}

	/**
	 * @param message
	 */
	public CodigoDeBarrasException(String message) {
		super(message);
	
	}

	/**
	 * @param cause
	 */
	public CodigoDeBarrasException(Throwable cause) {
		super(cause);
	
	}

}
