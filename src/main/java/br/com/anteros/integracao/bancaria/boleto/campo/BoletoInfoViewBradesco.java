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


import br.com.anteros.core.utils.StringUtils;
import br.com.anteros.integracao.bancaria.banco.layout.Agencia;
import br.com.anteros.integracao.bancaria.banco.layout.Carteira;
import br.com.anteros.integracao.bancaria.banco.layout.NumeroDaConta;
import br.com.anteros.integracao.bancaria.boleto.Boleto;
import br.com.anteros.integracao.bancaria.boleto.ResourceBundle;

/**
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 */
public class BoletoInfoViewBradesco extends AbstractBoletoInfoCampoView{

	BoletoInfoViewBradesco(ResourceBundle resourceBundle, Boleto boleto) {
		super(resourceBundle, boleto);
	}

	@Override
	public String getTextoFcLocalPagamento() {
		String textoFcLocalPagamento = super.getTextoFcLocalPagamento();
		return StringUtils.isBlank(textoFcLocalPagamento) ? "Pagável Preferencialmente na rede Bradesco ou no Bradesco expresso" : textoFcLocalPagamento;
	}
	
	@Override
	public String getTextoFcAgenciaCodigoCedente() {
		Agencia agencia = getBoleto().getTitulo().getContaBancaria().getAgencia();
		NumeroDaConta numeroDaConta = getBoleto().getTitulo().getContaBancaria().getNumeroDaConta();
		
		return StringUtils.leftPad(agencia.getCodigo().toString(), 4, "0")
				+ "-" + agencia.getDigitoVerificador()
				+ " / "
				+ StringUtils.leftPad(numeroDaConta.getCodigoDaConta().toString(), 7, "0")
				+ "-" + numeroDaConta.getDigitoDaConta();
	}
	
	@Override
	public String getTextoRsAgenciaCodigoCedente() {
		return getTextoFcAgenciaCodigoCedente();
	}
	
	@Override
	public String getTextoFcNossoNumero() {
		Carteira carteira = getBoleto().getTitulo().getCarteira();
		return StringUtils.leftPad(carteira.getCodigo().toString(), 2, "0") 
				+ "/" 
				+ getBoleto().getTitulo().getNossoNumero() 
				+ "-" + getBoleto().getTitulo().getDigitoNossoNumero();
	}
	
	@Override
	public String getTextoRsNossoNumero() {
		return getTextoFcNossoNumero();
	}
}
