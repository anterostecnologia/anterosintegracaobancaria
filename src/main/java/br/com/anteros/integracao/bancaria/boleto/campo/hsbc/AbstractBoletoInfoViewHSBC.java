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
package br.com.anteros.integracao.bancaria.boleto.campo.hsbc;



import br.com.anteros.core.utils.StringUtils;
import br.com.anteros.integracao.bancaria.boleto.Boleto;
import br.com.anteros.integracao.bancaria.boleto.ResourceBundle;
import br.com.anteros.integracao.bancaria.boleto.campo.AbstractBoletoInfoCampoView;
import br.com.anteros.integracao.bancaria.boleto.campo.BoletoInfoCampoView;

/**
 * Define campos iguais para as cobranças registrada e não registrada.
 * @author Rômulo Augusto
 */
public class AbstractBoletoInfoViewHSBC extends AbstractBoletoInfoCampoView {
	
	public static BoletoInfoCampoView create(ResourceBundle resourceBundle, Boleto boleto) {
		if (boleto.getTitulo().getCarteira().isComRegistro()) {
			return new BoletoInfoViewHSBCRegistrada(resourceBundle, boleto);
		}
		return new BoletoInfoViewHSBCNaoRegistrada(resourceBundle, boleto);
	}

	public AbstractBoletoInfoViewHSBC(ResourceBundle resourceBundle, Boleto boleto) {
		super(resourceBundle, boleto);
	}
	
	@Override
	public String getTextoFcLocalPagamento() {
		String textoFcLocalPagamento = super.getTextoFcLocalPagamento();
		return StringUtils.isBlank(textoFcLocalPagamento) ? "PAGAR PREFERENCIALMENTE EM AGÊNCIA DO HSBC" : textoFcLocalPagamento;
	}
	
	@Override
	public String getTextoFcAgenciaCodigoCedente() {
		return StringUtils.leftPad(getBoleto().getTitulo().getContaBancaria().getNumeroDaConta().getCodigoDaConta().toString(), 7, "0");
	}
	
	@Override
	public String getTextoFcNossoNumero() {
		return getBoleto().getTitulo().getNossoNumero() + getBoleto().getTitulo().getDigitoNossoNumero();
	}
	
	@Override
	public String getTextoRsNossoNumero() {
		return getTextoFcNossoNumero();
	}
}
