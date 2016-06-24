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

import br.com.anteros.core.utils.StringUtils;
import br.com.anteros.integracao.bancaria.validador.AbstractCPRFValidator;
import br.com.anteros.integracao.bancaria.validador.AbstractCPRFValidator.TipoDeCPRF;

/**
 * <p>
 * Representa o cadastro de pessoa física (CPF), um número identificador de todo
 * contribuinte (pessoas físicas brasileiras ou estrangeiras com negócios no
 * Brasil).
 * </p>
 * <p>
 * O formatador do CPF é "###.###.###-XX", onde XX é o dígito verificador do
 * número.
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
public class CPF extends AbstractCPRF {

	public CPF(Long numCPF) {

		try {

			if (AbstractCPRFValidator.isParametrosValidos(String.valueOf(numCPF),
					TipoDeCPRF.CPF)) {

				this.autenticadorCP = AbstractCPRFValidator.create(StringUtils.padZero(String.valueOf(numCPF), 11));

				if (autenticadorCP.isValido()){					
					initFromNumber(numCPF);					
				}else{					
					throw new IllegalArgumentException("O cadastro de pessoa [ \"" + numCPF+ "\" ] não é válido.");
				}

			}

		} catch (Exception e) {
			if (!(e instanceof CPFException))
				throw new CPFException(e);
		}
	}
	
	public CPF(String strCPF) {

		this.autenticadorCP = AbstractCPRFValidator.create(strCPF);

		if (autenticadorCP.isValido()) {
			
			if(StringUtils.isNumber(strCPF)){				
				initFromNotFormattedString(strCPF);				
			}else{				
				initFromFormattedString(strCPF);				
			}
			
		} else {
			throw new CPFException(new IllegalArgumentException(
					"O cadastro de pessoa [ \"" + strCPF + "\" ] não é válido."));
		}
	}

	private void initFromNumber(Long numCPF) {
		try {
			this.setCodigoFormatado(format(StringUtils.padZero(String.valueOf(numCPF), 11)));
			this.setCodigo(numCPF);
		} catch (Exception e) {
			throw new CPFException(e);
		}
	}
	private void initFromFormattedString(String strCPF) {		
		try {			
			this.setCodigoFormatado(strCPF);
			this.setCodigo(Long.parseLong(removeFormat(strCPF)));			
		} catch (Exception e) {
			throw new CPFException(e);
		}
	}
	
	private void initFromNotFormattedString(String strCPF) {
		
		try {
			
			this.setCodigoFormatado(format(strCPF));
			this.setCodigo(Long.parseLong(strCPF));
			
		} catch (Exception e) {
			throw new CPFException(e);
		}
	}
	
	private String format(String strCPF) {
		
		StringBuilder codigoFormatado = new StringBuilder(strCPF);

		codigoFormatado.insert(3, '.');
		codigoFormatado.insert(7, '.');
		codigoFormatado.insert(11, '-');
		
		return codigoFormatado.toString();
	}
	
	private String removeFormat(String codigo) {

		codigo = codigo.replace(".", "");
		codigo = codigo.replace("-", "");

		return codigo;
	}

}
