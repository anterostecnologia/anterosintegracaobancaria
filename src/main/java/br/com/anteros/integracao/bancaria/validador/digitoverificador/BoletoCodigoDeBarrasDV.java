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

import br.com.anteros.core.utils.StringUtils;

/**
 * <p>
 * Lógica de cálculo do dígito verificador do código de barras de um boleto.<br />
 * A lógica funciona da seguinte forma:
 * </p>
 * <p>
 * Utilizando-se o módulo 11, considerando-se os 43 dígitos que compõem o código
 * de barras, já excluída a 5ª posição (posição do dígito verificador), segue-se
 * o procedimento abaixo:
 * </p>
 * <p>
 * Calcula-se o dígito verificador através da expressão <code>DV = 11 - R</code>
 * , onde R é o resultado do cálculo do módulo.<br />
 * Observação: O dígito verificador será 1 para os restos (resultado do módulo):
 * 0 , 10 ou 1 (zero, dez, um).
 * </p>
 * <p>
 * Obs.: A rotina de módulo utilizada é o módulo 11.
 * </p>
 * 
 */
public class BoletoCodigoDeBarrasDV extends AbstractDigitoVerificador {

	private static final int TAMANHO_SEM_DV = 43;

	private static final Modulo modulo11 = new Modulo(TipoDeModulo.MODULO11);

	/**
	 * @see org.jrimum.vallia.digitoverificador.AbstractDigitoVerificador#calcule(String)
	 * @since 0.2
	 */
	@Override
	public int calcule(String numero) throws IllegalArgumentException {

		int dv = 0;
		int resto = 0;

		if (StringUtils.isNotBlank(numero) && StringUtils.isNumber(numero)
				&& (numero.length() == TAMANHO_SEM_DV)) {

			// Realizando o cálculo do dígito verificador utilizando módulo 11.
			// Obtendo o resto da divisão por 11.
			resto = modulo11.calcule(numero);

			// Seguindo as especificações da FEBRABAN, caso o resto seja
			// (0), (1) ou (10), será atribuído (1) ao digito verificador.
			if ((resto == 0) || (resto == 1) || (resto == 10)) {
				dv = 1;
			// Caso contrário, dv = 11 - resto.
			} else {
				dv = modulo11.valor() - resto;
			}

		} else {
			throw new IllegalArgumentException("O código de barras " + "[ "
					+ numero + " ] deve conter apenas números e "
					+ TAMANHO_SEM_DV + " dígitos.");
		}

		return dv;
	}

}
