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


import static java.util.regex.Pattern.matches;

import br.com.anteros.core.utils.StringUtils;

/**
 * <p>
 * Segundo o padrão FEBRABAN a linha digitável possui cinco campos, dos quais
 * apenas os três primeiros necessitam de validação com dígito verificador.
 * </p>
 * <p>
 * Para fins de validação é preciso saber o seguinte:
 * <ul>
 * <li>O primerio campo tem tamanho 9 (nove) mais o dígito verificador.</li>
 * <li>O segundo campo tem tamanho 10 (dez) mais o dígito verificador.</li>
 * <li>O terceiro campo tem tamanho 10 (dez) mais o dígito verificador.</li>
 * </ul>
 * </p>
 * <p>
 * Obs1.: Todos os campos listados podem vir com um ponto (.) de separação
 * exatamente após o dígito da 5ª posição. <br />
 * Exemplo de linha digitável:<br />
 * <code>99997.77213 30530.150082 18975.000003 1 10010000035000</code>
 * </p>
 * <p>
 * O cálculo do dígito verificador é descrito através da expressão
 * <code>DV = 11 - R</code>, onde R é o resultado do cálculo do módulo.<br />
 * Obs1.: O dígito verificador será 0 (zero) se o resto (resultado do módulo)
 * for 0 (zero). <br />
 * Obs2.: A rotina de módulo utilizada é a módulo 10.
 * </p>
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
public class BoletoLinhaDigitavelDV extends AbstractDigitoVerificador {

	/**
	 *<p>
	 * Módulo 10 utilizado no cálculo.
	 * </p>
	 */
	private static final Modulo modulo10 = new Modulo(TipoDeModulo.MODULO10);

	/**
	 * <p>
	 * Expressão regular para validação do campo da linha digitável, aceita os
	 * seguintes formatos:
	 * </p>
	 * <ul>
	 * 	<li>#########</li>
	 * 	<li>#####.####</li>
	 * 	<li>##########</li>
	 * 	<li>#####.#####</li>
	 * </ul>
	 */
	private static final String REGEX_CAMPO = "(\\d{9})|(\\d{10})|(\\d{5})\\.(\\d{4})|(\\d{5})\\.(\\d{5})";

	/**
	 * @see org.jrimum.vallia.digitoverificador.AbstractDigitoVerificador#calcule(java.lang.String)
	 * @since 0.2
	 */
	@Override
	public int calcule(long numero) {

		return calcule(StringUtils.padZero(String.valueOf(numero), 10));
	}

	/**
	 * @see org.jrimum.vallia.digitoverificador.AbstractDigitoVerificador#calcule(java.lang.String)
	 * @since 0.2
	 */
	@Override
	public int calcule(String numero) throws IllegalArgumentException {

		int dv = 0;
		int resto = 0;

		if (StringUtils.isNotBlank(numero)
				&& matches(REGEX_CAMPO, numero)) {

			numero = StringUtils.replaceAll(numero, ".", "");

			resto = modulo10.calcule(numero);

			if (resto != 0) {
				dv = modulo10.valor() - resto;
			}
		} else {
			throw  new IllegalArgumentException("O campo [" + numero 
					+ "] da linha digitável deve conter apenas números com 9 ou 10 dígitos " +
							"ou nos formatos [#####.####, #####.#####]");
		}

		return dv;
	}
}
