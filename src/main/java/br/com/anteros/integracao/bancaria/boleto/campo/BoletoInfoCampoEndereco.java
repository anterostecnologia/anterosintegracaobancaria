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

import br.com.anteros.automacao.bancaria.comum.pessoa.endereco.Endereco;
import br.com.anteros.core.utils.ObjectUtils;
import br.com.anteros.core.utils.StringUtils;
import br.com.anteros.integracao.bancaria.banco.layout.EntidadeDeCobranca;

/**
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 */
public class BoletoInfoCampoEndereco {
	
	public static String getTextoEnderecoLinha1(EntidadeDeCobranca pessoa){
		if (ObjectUtils.isNotNull(pessoa)) {
			return getTextoEnderecoLinha1(pessoa.getNextEndereco());
		}
		return StringUtils.EMPTY;
	}
	
	public static String getTextoEnderecoLinha1(Endereco endereco){
		
		final StringBuilder texto = new StringBuilder(StringUtils.EMPTY);
		
		if (ObjectUtils.isNotNull(endereco)) {
			
			boolean temBairro = false;
			boolean temLocalidade = false;
			
			if (StringUtils.isNotBlank(endereco.getBairro())) {
				temBairro = true;
				texto.append(endereco.getBairro());
			}
			
			if (StringUtils.isNotBlank(endereco.getLocalidade())) {
				temLocalidade = true;
				if(temBairro){
					texto.append(" - ");
				}
				texto.append(endereco.getLocalidade());
			}
			
			if (ObjectUtils.isNotNull(endereco.getUF())) {
				if(temBairro || temLocalidade){
					texto.append(" / ");
				}
				texto.append(endereco.getUF().getSigla());
			}
		}
		
		return texto.toString();
	}
	
	public static String getTextoEnderecoLinha2(EntidadeDeCobranca pessoa){
		if (ObjectUtils.isNotNull(pessoa)) {
			return getTextoEnderecoLinha2(pessoa.getNextEndereco());
		}
		return StringUtils.EMPTY;
	}

	public static String getTextoEnderecoLinha2(Endereco endereco){

		final StringBuilder texto = new StringBuilder(StringUtils.EMPTY);
		
		if (ObjectUtils.isNotNull(endereco)) {
			
			if (StringUtils.isNotBlank(endereco.getLogradouro())) {
				texto.append(endereco.getLogradouro());
			}

			if (StringUtils.isNotBlank(endereco.getNumero())) {
				texto.append(", n°: ")
				.append(endereco.getNumero());
			}
			
			if (StringUtils.isNotBlank(endereco.getComplemento())) {
				texto.append(" / ")
				.append(endereco.getComplemento());
			}

			if (ObjectUtils.isNotNull(endereco.getCEP()) && StringUtils.isNotBlank(endereco.getCEP().getCep())) {
				texto.append(" - ")
				.append("CEP: ")
				.append(endereco.getCEP().getCep());
			}

		}
		
		return texto.toString();
	}

}
