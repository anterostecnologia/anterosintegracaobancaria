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

/**
 * View para a cobrança registrada do HSBC.
 * 
 * @author Rômulo Augusto
 */
public class BoletoInfoViewHSBCRegistrada extends AbstractBoletoInfoViewHSBC {

	public BoletoInfoViewHSBCRegistrada(ResourceBundle resourceBundle, Boleto boleto) {
		super(resourceBundle, boleto);
	}
	
	@Override
	public String getTextoFcAgenciaCodigoCedente() {
		String agencia = StringUtils.leftPad(getBoleto().getTitulo().getContaBancaria().getAgencia().getCodigo().toString(), 4, "0");
		String conta = StringUtils.leftPad(getBoleto().getTitulo().getContaBancaria().getNumeroDaConta().getCodigoDaConta().toString(), 7, "0");
		return agencia + conta;
	}
	
	@Override
	public String getTextoRsAgenciaCodigoCedente() {
		return getTextoFcAgenciaCodigoCedente();
	}
	
	@Override
	public String getTextoFcEspecieDocumento() {
		return "PD";
	}
	
	@Override
	public String getTextoFcAceite() {
		return "NÃO";
	}
	
	@Override
	public String getTextoFcCarteira() {
		return "CSB";
	}
}
