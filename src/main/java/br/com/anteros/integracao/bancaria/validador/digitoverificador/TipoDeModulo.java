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
package br.com.anteros.integracao.bancaria.validador.digitoverificador;

import java.io.Serializable;

/**
 * Enumeração das implementações dos módulos.
 * 
 */
public enum TipoDeModulo implements Serializable {

	
	MODULO10 {

		public int valor() {
			return 10;
		}
	},

	
	MODULO11 {
		
		public int valor() {
			return 11;
		}
	};

	/**
	 * Retorna o valor do módulo.
	 * 
	 * @return 10 ou 11
	 */
	public abstract int valor();
}