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
package br.com.anteros.integracao.bancaria.boleto.campo.caixa;


import br.com.anteros.integracao.bancaria.boleto.Boleto;
import br.com.anteros.integracao.bancaria.boleto.ResourceBundle;
import br.com.anteros.integracao.bancaria.boleto.campo.BoletoInfoCampoView;

/**
 * Factory para determinar qual a implementação da CAIXA será usada de acordo com o convênio (SIGCB, SINCO, SICOB).
 */
public class BoletoInfoViewCaixaFactory {

	private static final int NN10 = 10;
	private static final int NN14 = 14;
	private static final int NN15 = 15;
	private static final int NN17 = 17;

	public static BoletoInfoCampoView create(ResourceBundle resourceBundle, Boleto boleto) {
		String nossoNumero = boleto.getTitulo().getNossoNumero();
		switch (nossoNumero.length()) {
			
			case NN10: return new BoletoInfoViewCaixaSICOB10(resourceBundle, boleto);
			case NN14: return new BoletoInfoViewCaixaSICOB14(resourceBundle, boleto);
			case NN15: return new BoletoInfoViewCaixaSIGCB(resourceBundle, boleto);
			case NN17: return new BoletoInfoViewCaixaSINCO(resourceBundle, boleto);
		}
		
		return null;
	}
}
