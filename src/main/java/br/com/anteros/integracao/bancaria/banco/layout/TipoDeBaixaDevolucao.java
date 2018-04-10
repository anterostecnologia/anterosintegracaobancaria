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
package br.com.anteros.integracao.bancaria.banco.layout;

import static java.lang.String.format;

public enum TipoDeBaixaDevolucao {
	
	BAIXAR_DEVOLVER(1),
	NAO_BAIXAR(2),
	NAO_DEVOLVER(3),
	CANCELAR_PRAZO_PARA_BAIXA_DEVOLUCAO(4);
	
	private Integer tipo;
	
	private TipoDeBaixaDevolucao(Integer tipo){
		this.tipo = tipo;
	}
	
	public Integer getTipo(){
		return tipo;
	}
	
	public static TipoDeBaixaDevolucao valueOf(int codigo){
		for(TipoDeBaixaDevolucao t : values()){
			if(t.getTipo() == codigo){
				return t;
			}
		}
		throw  new IllegalArgumentException(format("Nenhuma constante enum %s com código igual a %s!", TipoDeBaixaDevolucao.class, codigo));
	}

}
