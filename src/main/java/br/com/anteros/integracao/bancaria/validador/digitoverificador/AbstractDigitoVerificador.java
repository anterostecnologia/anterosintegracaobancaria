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
package br.com.anteros.integracao.bancaria.validador.digitoverificador;

/**
 * <p>
 * Define o comportamento de classes que implementam uma lógica de cálculo de 
 * um dígito verificador.
 * </p>
 * 
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * @author <a href="mailto:misaelbarreto@gmail.com">Misael Barreto</a>
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * @author <a href="http://www.nordestefomento.com.br">Nordeste Fomento
 *         Mercantil</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public abstract class AbstractDigitoVerificador {

	/**
	 * <p>
	 * Calcula o dígito verificador de um número de acordo com uma lógica
	 * específica.
	 * </p>
	 * 
	 * @param numero
	 *            - número que será calculado o dígito verificador.
	 * @return dígito verificador.
	 * @throws IllegalArgumentException
	 *             caso a String não esteja em um formato aceitável. (O
	 *             formato é definido nas subclasses implementadoras).
	 * @since 0.2
	 */
	public abstract int calcule(String numero) throws IllegalArgumentException;

	/**
	 * <p>
	 * Calcula o dígito verificador de um número de acordo com uma lógica
	 * específica.
	 * </p>
	 * <p>
	 * Se não sobrescrito o retorno é sempre igual a 0 (zero).
	 * </p>
	 * 
	 * @param numero
	 *            - número que será calculado o dígito verificador.
	 * @return dígito verificador
	 * @since 0.2
	 */
	public int calcule(long numero) {

		return 0;
	}

}
