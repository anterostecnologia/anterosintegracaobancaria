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
package br.com.anteros.integracao.bancaria.boleto.campo;

import br.com.anteros.core.utils.StringUtils;
import br.com.anteros.integracao.bancaria.banco.febraban.Titulo;

/**
 * Formata o Nosso Número do Título que é impresso no boleto.
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 */
public class BoletoInfoCampoNossoNumero {

	/**
	 * Retorna o nosso número fomatado no estilo "123456-7".
	 * 
	 * 
	 * @param titulo
	 * @return string formatada para ser exibida no boleto
	 */
	public static String getTextoNossoNumero(Titulo titulo) {

		StringBuilder texto = new StringBuilder(StringUtils.EMPTY);

		if (StringUtils.isNotBlank(titulo.getNossoNumero())) {
			texto.append(titulo.getNossoNumero());

			if (StringUtils.isNotBlank(titulo.getDigitoNossoNumero())) {
				texto.append("-" + titulo.getDigitoNossoNumero());
			}
		}

		return texto.toString();
	}
}
