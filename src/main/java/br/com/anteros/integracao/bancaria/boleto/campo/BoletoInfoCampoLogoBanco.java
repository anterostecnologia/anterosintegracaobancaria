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


import java.awt.Image;

import br.com.anteros.core.utils.ObjectUtils;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.boleto.BancosSuportados;
import br.com.anteros.integracao.bancaria.boleto.ResourceBundle;

/**
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 *
 */
public class BoletoInfoCampoLogoBanco {
	
	public static Image getImagemBanco(ResourceBundle resourceBundle, ContaBancaria conta){
			
		if (ObjectUtils.isNotNull(conta.getBanco().getImgLogo())) {
			return conta.getBanco().getImgLogo();
		} 
		
		if (BancosSuportados.isSuportado(conta.getBanco().getCodigoDeCompensacaoBACEN().getCodigoFormatado())) {
				
			conta.getBanco().setImgLogo(
					resourceBundle
							.getLogotipoDoBanco(conta.getBanco()
									.getCodigoDeCompensacaoBACEN()
									.getCodigoFormatado()));
		} 
		
		return conta.getBanco().getImgLogo();		
	}

}
