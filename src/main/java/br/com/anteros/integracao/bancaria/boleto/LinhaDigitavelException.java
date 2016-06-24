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
 * Qualquer exceção gerada durante a geração da Linha Digitável gera uma <code>LinhaDigitavelException</code>. Centraliza e localiza os problemas relativos a geração de uma linha digitável.
 * </p>
 * 
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * @author <a href="mailto:misaelbarreto@gmail.com">Misael Barreto</a>
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * 
 * @see org.jrimum.bopepo.LinhaDigitavel
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public class LinhaDigitavelException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8206303471509231915L;

	/**
	 * 
	 */
	public LinhaDigitavelException() {
		
	}

	/**
	 * @param message
	 * @param cause
	 */
	public LinhaDigitavelException(String message, Throwable cause) {
		super(message, cause);
		
	}

	/**
	 * @param message
	 */
	public LinhaDigitavelException(String message) {
		super(message);
		
	}

	/**
	 * @param cause
	 */
	public LinhaDigitavelException(Throwable cause) {
		super(cause);
		
	}

}
