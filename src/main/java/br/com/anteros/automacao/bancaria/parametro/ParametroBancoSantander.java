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
package br.com.anteros.automacao.bancaria.parametro;

import br.com.anteros.integracao.bancaria.banco.ParametroBancario;
import br.com.anteros.integracao.bancaria.boleto.BancosSuportados;

/**
 * Parâmetros bancários específicos para o
 * {@link BancosSuportados#BANCO_SANTANDER}.
 * 
 */
public enum ParametroBancoSantander implements ParametroBancario<ParametroBancoSantander>{
	/**
	 * Chave de pesquisa em parâmetros bancários para saber se o boelto deve
	 * usar IOF – Seguradoras: (Se 7% informar 7. Limitado a 9%); Demais
	 * clientes usar 0 (zero).
	 */
	IOF_SEGURADORA;
}
