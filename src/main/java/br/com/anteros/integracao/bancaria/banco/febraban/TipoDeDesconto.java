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
package br.com.anteros.integracao.bancaria.banco.febraban;

public enum TipoDeDesconto {

	VALOR_FIXO_ATE_A_DATA(1),
	PERCENTUAL_ATE_A_DATA(2),
	VALOR_ANTECIPACAO_DIA_CORRIDO(3),
	VALOR_ANTECIPACAO_DIA_UTIL(4),
	PERCENTUAL_SOBRE_VL_NOMINAL_DIA_CORRIDO(5),
	PERCENTUAL_SOBRE_VL_NOMINAL_DIA_UTIL(6),
	CANCELAMENTO_DESCONTO(7);
	
	private Integer tipo;
	
	private TipoDeDesconto(Integer tipo){
		this.tipo = tipo;
	}
	
	public Integer getTipo(){
		return tipo;
	}
}
