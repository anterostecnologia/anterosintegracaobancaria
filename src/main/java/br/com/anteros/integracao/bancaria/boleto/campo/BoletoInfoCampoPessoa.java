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

import br.com.anteros.core.utils.ObjectUtils;
import br.com.anteros.core.utils.StringUtils;
import br.com.anteros.integracao.bancaria.banco.febraban.EntidadeDeCobranca;

/**
 * Formata os dados como CPRF e Nome de uma pessoa que são impressos no boleto.
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 */
public class BoletoInfoCampoPessoa {

	/**
	 * Retorna o texto formatado no estilo {@code "%nome, %tipo_de_cprf: %cprf"}:
	 * 
	 * <ul>
	 * <li>"Fulando Da Silva, CPF: 111.111.111-11"</li>
	 * <li>"Empresa Boa, CNPJ: 00.123.456/0001-78"</li>
	 * </ul>
	 * 
	 * @param pessoa
	 * @return string formatada para ser exibida no boleto
	 */
	public static String getTextoNomeCprfDaPessoa(EntidadeDeCobranca pessoa) {
		StringBuilder sb = new StringBuilder(StringUtils.EMPTY);
		boolean temNome = false;

		if (ObjectUtils.isNotNull(pessoa)) {

			if (ObjectUtils.isNotNull(pessoa.getNome())) {
				temNome = true;
				sb.append(pessoa.getNome());
			}

			if (ObjectUtils.isNotNull(pessoa.getCPRF())) {
				
				if(temNome){
					sb.append(", ");
				}

				if (pessoa.getCPRF().isFisica()) {
					sb.append("CPF: ");

				} else if (pessoa.getCPRF().isJuridica()) {
					sb.append("CNPJ: ");
				}

				sb.append(pessoa.getCPRF().getCodigoFormatado());
			}
		}

		return sb.toString();
	}

}
