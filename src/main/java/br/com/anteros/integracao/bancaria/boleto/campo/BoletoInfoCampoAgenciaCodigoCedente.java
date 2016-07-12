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
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;

/**
 * Formata a agência e o número da conta.
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 */
public class BoletoInfoCampoAgenciaCodigoCedente {

	/**
	 * Retorna a agência e o número da conta no seguinte formato: {@code "1234-1 / 123456-0"}.
	 * 
	 * 
	 * @param conta
	 * @return string formatada para ser exibida no boleto
	 */
	public static String getTextoAgenciaCodigoCedente(ContaBancaria conta){

		StringBuilder texto = new StringBuilder(StringUtils.EMPTY);
		boolean temAgencia = false;
		

		if (ObjectUtils.isNotNull(conta.getAgencia())) {
			
			temAgencia = true;
			
			if (ObjectUtils.isNotNull(conta.getAgencia().getCodigo())){
				texto.append(conta.getAgencia().getCodigo());
			}
	
			if (StringUtils.isNotBlank(conta.getAgencia().getDigitoVerificador().toString())) {
	
				texto.append("-");
				texto.append(conta.getAgencia().getDigitoVerificador());
			}
		}
		
		if(ObjectUtils.isNotNull(conta.getNumeroDaConta())){
		
			if(temAgencia){
				texto.append(" / ");
			}

			if (ObjectUtils.isNotNull(conta.getNumeroDaConta().getCodigoDaConta())) {
	
				texto.append(conta.getNumeroDaConta().getCodigoDaConta());
	
				if (StringUtils.isNotBlank(conta.getNumeroDaConta().getDigitoDaConta())) {
	
					texto.append("-");
					texto.append(conta.getNumeroDaConta().getDigitoDaConta());
				}
			}
		}

		return texto.toString();
	}

}
