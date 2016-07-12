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

import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;

/**
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 */
public class BoletoInfoCampoCodigoBanco {

	/**
	 * Retorna o código de compensação do banco fomatado no estilo "001-9".
	 * 
	 * 
	 * @param conta
	 * @return string formatada para ser exibida no boleto
	 */
	public static String getTextoCodigoDoBanco(ContaBancaria conta){
		
		String codigoCompensacao = conta.getBanco().getCodigoDeCompensacaoBACEN().getCodigoFormatado();
		String digitoCompensacao = conta.getBanco().getCodigoDeCompensacaoBACEN().getDigito().toString();
		
		return codigoCompensacao + "-" + digitoCompensacao;
	}
}
