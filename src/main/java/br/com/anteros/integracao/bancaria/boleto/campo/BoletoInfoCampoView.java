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


/**
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 *
 */
public interface BoletoInfoCampoView {
	
	//Recibo do Sacado
	public Image getImagemRsLogoBanco();
	public String getTextoRsLogoBanco();
	public String getTextoRsCodigoBanco();
	public String getTextoRsLinhaDigitavel();
	public String getTextoRsSacado();
	public String getTextoRsNossoNumero();
	public String getTextoRsCedente();
	public String getTextoRsAgenciaCodigoCedente();			
	public String getTextoRsInstrucaoAoSacado();
	public String getTextoRsMoraMulta();
	public String getTextoRsOutroAcrescimo();
	public String getTextoRsOutraDeducao();
	public String getTextoRsDescontoAbatimento();
	public String getTextoRsValorDocumento();
	public String getTextoRsValorCobrado();
	public String getTextoRsDataVencimento();
	public String getTextoRsCpfCnpj();
	public String getTextoRsNumeroDocumento();
	public String getTextoRsEspecie();

	//Ficha de Compensação
	public Image getImagemFcLogoBanco();
	public String getTextoFcLogoBanco();
	public String getTextoFcCodigoBanco();
	public String getTextoFcLinhaDigitavel();
	public String getTextoFcNossoNumero();
	public String getTextoFcAgenciaCodigoCedente();
	public String getTextoFcDataProcessamento();
	public String getTextoFcAceite();
	public String getTextoFcEspecieDocumento();
	public String getTextoFcDataDocumento();
	public String getTextoFcLocalPagamento();
	public String getTextoFcCarteira();
	public String getTextoFcSacadoL1();
	public String getTextoFcSacadoL2();
	public String getTextoFcSacadoL3();
	public String getTextoFcSacadorAvalistaL1();
	public String getTextoFcSacadorAvalistaL2();
	public String getTextoFcSacadorAvalistaL3();
	public String getTextoFcInstrucaoAoCaixa1();
	public String getTextoFcInstrucaoAoCaixa2();
	public String getTextoFcInstrucaoAoCaixa3();
	public String getTextoFcInstrucaoAoCaixa4();
	public String getTextoFcInstrucaoAoCaixa5();
	public String getTextoFcInstrucaoAoCaixa6();
	public String getTextoFcInstrucaoAoCaixa7();
	public String getTextoFcInstrucaoAoCaixa8();
	public String getTextoFcMoraMulta();
	public String getTextoFcOutroAcrescimo();
	public String getTextoFcOutraDeducao();
	public String getTextoFcDescontoAbatimento();
	public String getTextoFcValorDocumento();
	public String getTextoFcValorCobrado();
	public String getTextoFcDataVencimento();
	public String getTextoFcNumeroDocumento();
	public String getTextoFcCedente();
	public String getTextoFcEspecie();
	public Image getImagemFcCodigoBarra();
	
}
