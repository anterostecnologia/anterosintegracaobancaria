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
package br.com.anteros.integracao.bancaria.boleto;

/**
 * Enumeração com todos os campos padrão FEBRABAN utilizados no boleto. 
 * 
 */
public enum BoletoCampo {
	
	/*
	 * Campos em ordem alfabetica
	 */
	
	//Ficha de Compensação
	txtFcAceite,
	txtFcAgenciaCodigoCedente,
	txtFcCarteira,
	txtFcCedente,
	txtFcCodBanco,
	txtFcCodigoBarra,
	txtFcDataDocumento,
	txtFcDataProcessamento,
	txtFcDataVencimento,
	txtFcDescontoAbatimento,
	txtFcEspecie,
	txtFcEspecieDocumento,
	txtFcInstrucaoAoCaixa1,
	txtFcInstrucaoAoCaixa2,
	txtFcInstrucaoAoCaixa3,
	txtFcInstrucaoAoCaixa4,
	txtFcInstrucaoAoCaixa5,
	txtFcInstrucaoAoCaixa6,
	txtFcInstrucaoAoCaixa7,
	txtFcInstrucaoAoCaixa8,
	txtFcLinhaDigitavel,
	txtFcLocalPagamento,
	txtFcLogoBanco,
	txtFcMoraMulta,
	txtFcNossoNumero,
	txtFcNumeroDocumento,
	txtFcOutraDeducao,
	txtFcOutroAcrescimo,
	txtFcQuantidade,
	txtFcSacadoL1,
	txtFcSacadoL2,
	txtFcSacadoL3,
	txtFcSacadorAvalistaL1,
	txtFcSacadorAvalistaL2,
	txtFcSacadorAvalistaL3,
	txtFcUsoBanco,
	txtFcValor,
	txtFcValorCobrado,
	txtFcValorDocumento,
	//Recibo do Sacado
	txtRsAgenciaCodigoCedente,
	txtRsCedente,
	txtRsCodBanco,
	txtRsCpfCnpj,
	txtRsDataVencimento,
	txtRsDescontoAbatimento,
	txtRsEspecie,
	txtRsInstrucaoAoSacado,
	txtRsLinhaDigitavel,
	txtRsLogoBanco,
	txtRsMoraMulta,
	txtRsNossoNumero,
	txtRsNumeroDocumento,
	txtRsOutraDeducao,
	txtRsOutroAcrescimo,
	txtRsQuantidade,
	txtRsSacado,
	txtRsValorCobrado,
	txtRsValorDocumento
}
