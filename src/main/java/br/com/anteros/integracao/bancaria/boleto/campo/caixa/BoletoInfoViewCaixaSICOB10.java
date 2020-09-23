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


import br.com.anteros.automacao.bancaria.parametro.ParametroCaixaEconomicaFederal;
import br.com.anteros.core.utils.ObjectUtils;
import br.com.anteros.core.utils.StringUtils;
import br.com.anteros.integracao.bancaria.banco.layout.Carteira;
import br.com.anteros.integracao.bancaria.banco.layout.TipoDeCobranca;
import br.com.anteros.integracao.bancaria.boleto.Boleto;
import br.com.anteros.integracao.bancaria.boleto.ResourceBundle;
import br.com.anteros.integracao.bancaria.boleto.campo.AbstractBoletoInfoCampoView;

/**
 * View para o convênio SICOB, Nosso número com 10 dígitos, da CAIXA.
 */
public class BoletoInfoViewCaixaSICOB10 extends AbstractBoletoInfoCampoView {
	
	public BoletoInfoViewCaixaSICOB10(ResourceBundle resourceBundle, Boleto boleto) {
		super(resourceBundle, boleto);
	}
	
	@Override
	public String getTextoFcCarteira() {
		String textoCarteira = StringUtils.EMPTY;
		Carteira carteira = getBoleto().getTitulo().getCarteira();
		if (ObjectUtils.isNotNull(carteira) && ObjectUtils.isNotNull(carteira.getTipoDeCobranca())) {
			textoCarteira = (carteira.getTipoDeCobranca().equals(TipoDeCobranca.COM_REGISTRO)) ? "CR" : "SR";
		}
		return textoCarteira;
	}
	
	@Override
	public String getTextoFcAgenciaCodigoCedente() {
		Integer agencia = getBoleto().getTitulo().getContaBancaria().getAgencia().getCodigo();
		Integer codigoOperacao = getBoleto().getTitulo().getParametrosBancarios().getValor(ParametroCaixaEconomicaFederal.CODIGO_OPERACAO);
		Long codigoBeneficiario = getBoleto().getTitulo().getContaBancaria().getNumeroDaConta().getCodigoDaConta();
		String digitoDaConta = getBoleto().getTitulo().getContaBancaria().getNumeroDaConta().getDigitoDaConta();
		
		return String.format("%04d.%03d.%08d-%s", agencia, codigoOperacao, codigoBeneficiario, digitoDaConta);
	}
}
