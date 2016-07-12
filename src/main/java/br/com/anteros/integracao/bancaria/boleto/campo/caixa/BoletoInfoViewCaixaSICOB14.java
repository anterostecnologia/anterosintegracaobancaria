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
import br.com.anteros.integracao.bancaria.banco.layout.Titulo;
import br.com.anteros.integracao.bancaria.boleto.Boleto;
import br.com.anteros.integracao.bancaria.boleto.ResourceBundle;
import br.com.anteros.integracao.bancaria.boleto.campo.AbstractBoletoInfoCampoView;

/**
 * View para o convênio SICOB, Nosso número com 14 dígitos, da CAIXA.
 * 
 * @author Rômulo Augusto
 */
public class BoletoInfoViewCaixaSICOB14 extends AbstractBoletoInfoCampoView {

	private static final int CODIGO_OPERACAO_PADRAO = 870;

	public BoletoInfoViewCaixaSICOB14(ResourceBundle resourceBundle, Boleto boleto) {
		super(resourceBundle, boleto);
	}
	
	@Override
	public String getTextoFcCarteira() {
		return "SR";
	}
	
	@Override
	public String getTextoFcAgenciaCodigoCedente() {
		Integer agencia = getBoleto().getTitulo().getContaBancaria().getAgencia().getCodigo();
		Integer codigoOperacao = getCodigoOperacao();
		Integer codigoBeneficiario = getBoleto().getTitulo().getContaBancaria().getNumeroDaConta().getCodigoDaConta();
		String digitoDaConta = getBoleto().getTitulo().getContaBancaria().getNumeroDaConta().getDigitoDaConta();
		
		return String.format("%04d.%03d.%08d-%s", agencia, codigoOperacao, codigoBeneficiario, digitoDaConta);
	}

	private Integer getCodigoOperacao() {
		Titulo titulo = getBoleto().getTitulo();
		Integer codigoOperacao = CODIGO_OPERACAO_PADRAO;
		
		if (titulo.hasParametrosBancarios() && ObjectUtils.isNotNull(titulo.getParametrosBancarios().getValor(ParametroCaixaEconomicaFederal.CODIGO_OPERACAO))) {
			codigoOperacao = titulo.getParametrosBancarios().getValor(ParametroCaixaEconomicaFederal.CODIGO_OPERACAO);
		}
		
		return codigoOperacao;
	}
	
	@Override
	public String getTextoFcLocalPagamento() {
		String textoFcLocalPagamento = super.getTextoFcLocalPagamento();
		return StringUtils.isBlank(textoFcLocalPagamento) ? "PREFERENCIALMENTE NAS CASAS LOTÉRICAS ATÉ O VALOR LIMITE" : textoFcLocalPagamento;
	}
}
