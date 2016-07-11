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

public enum TipoProtesto {
	
	PROTESTAR_DIAS_CORRIDOS(1),
	PROTESTAR_DIAS_UTEIS(2),
	NAO_PROTESTAR(3),
	PROTESTAR_FIM_FALIMENTAR_DIAS_UTEIS(4),
	PROTESTAR_FIM_FALIMENTAR_DIAS_CORRIDAS(5),
	NEGATIVACAO_SEM_PROTESTO(8),
	CANCELAMENTO_PROTESTO_AUTOMATICO(9);
	
	private Integer tipo;
	
	private TipoProtesto(Integer tipo){
		this.tipo = tipo;
	}
	
	public Integer getTipo(){
		return tipo;
	}
	

}
