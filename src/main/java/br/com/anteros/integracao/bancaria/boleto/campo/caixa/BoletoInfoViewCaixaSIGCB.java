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


import br.com.anteros.core.utils.StringUtils;
import br.com.anteros.integracao.bancaria.boleto.Boleto;
import br.com.anteros.integracao.bancaria.boleto.ResourceBundle;
import br.com.anteros.integracao.bancaria.boleto.campo.AbstractBoletoInfoCampoView;

/**
 * View para o convênio SIGCB da CAIXA.
 * 
 */
public class BoletoInfoViewCaixaSIGCB extends AbstractBoletoInfoCampoView {

	private static final String EMISSAO_BENEFICIARIO = "4";

	BoletoInfoViewCaixaSIGCB(ResourceBundle resourceBundle, Boleto boleto) {
		super(resourceBundle, boleto);
	}
	
	@Override
	public String getTextoFcNossoNumero() {
		return getBoleto().getTitulo().getCarteira().getCodigo() 
				+ EMISSAO_BENEFICIARIO 
				+ super.getTextoFcNossoNumero();
	}
	
	@Override
	public String getTextoFcCarteira() {
		return (getBoleto().getTitulo().getCarteira().isComRegistro()) ? "RG" : "SR";
	}
	
	@Override
	public String getTextoFcLocalPagamento() {
		String textoFcLocalPagamento = super.getTextoFcLocalPagamento();
		return StringUtils.isBlank(textoFcLocalPagamento) ? "PREFERENCIALMENTE NAS CASAS LOTÉRICAS ATÉ O VALOR LIMITE" : textoFcLocalPagamento;
	}
}
