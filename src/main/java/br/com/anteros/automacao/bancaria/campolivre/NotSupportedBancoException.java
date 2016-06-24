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


package br.com.anteros.automacao.bancaria.campolivre;


/**
 * <p>
 * Exceção indicadora de não existência de um referido banco ou problemas com dados de um banco.
 * </p>
 * 
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * @author <a href="mailto:misaelbarreto@gmail.com">Misael Barreto</a> 
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public class NotSupportedBancoException extends CampoLivreException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static String msg = "Banco não suportado por não haver " +
								"implementações de Campo Livre para " +
								"o mesmo.";
	
	
	/**
	 * 
	 */
	public NotSupportedBancoException() {
		super(msg);
	}
	
	/**
	 * @param message
	 * @param cause
	 */
	@SuppressWarnings("unused")
	private NotSupportedBancoException(String message, Throwable cause) {
		super(message, cause);
	}
	
	/**
	 * @param message
	 */
	@SuppressWarnings("unused")
	private NotSupportedBancoException(String message) {
		super(message);
	}
	
	/**
	 * @param cause
	 */
	@SuppressWarnings("unused")
	private NotSupportedBancoException(Throwable cause) {
		super(msg, cause);
	}
	
}
