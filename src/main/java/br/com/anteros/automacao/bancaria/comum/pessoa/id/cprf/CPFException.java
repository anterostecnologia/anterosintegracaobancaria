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
package br.com.anteros.automacao.bancaria.comum.pessoa.id.cprf;



/**
 * 
 * <p>
 * Qualquer falha na geração ou operações próprias da classe CPF.
 * </p>
 */

public class CPFException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = -3614884453255335650L;

	/**
	 * 
	 */
	public CPFException() {

	}

	/**
	 * @param message
	 * @param cause
	 */
	public CPFException(String message, Throwable cause) {
		super(message, cause);
		
	}

	/**
	 * @param message
	 */
	public CPFException(String message) {
		super(message);
		
	}

	/**
	 * @param cause
	 */
	public CPFException(Throwable cause) {
		super(cause);
		
	}

}
