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

public enum TipoDeDistribuicaoBoleto {


	BANCO_DISTRIBUI("1"),
	CLIENTE_DISTRIBUI("2");
	
	private String tipo;
	
	private TipoDeDistribuicaoBoleto(String tipo){
		this.tipo = tipo;
	}
	
	public String getTipo(){
		return tipo;
	}
	
	public TipoDeDistribuicaoBoleto valueOfTipo(String tipo){
		for(TipoDeDistribuicaoBoleto t : values()){
			if(t.getTipo().equals(tipo)){
				return t;
			}
		}
		throw  new IllegalArgumentException(format("Nenhuma constante enum %s com tipo igual a %s!", TipoDeDistribuicaoBoleto.class, tipo));
	}
}
