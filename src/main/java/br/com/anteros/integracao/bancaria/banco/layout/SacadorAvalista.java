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

import br.com.anteros.automacao.bancaria.comum.pessoa.id.cprf.CPRF;

/**
 * <p>
 * Representa um Sacador Avalista no modelo de negócio financeiro, que é o co-responsável
 * pelo título emitido pelo avalizado (Sacado), ou seja, caso a dívida não seja liquidada pelo Sacado,
 * cabe ao Sacador Avalista liquidá-la.
 * </p>
 * <p>
 * Cedente original do Título.
 * </p>
 */
public class SacadorAvalista extends EntidadeDeCobranca {

	public SacadorAvalista(String nome) {
		super(nome);
	}
	
	public SacadorAvalista(String nome, String cadastroDePessoa) {
		super(nome, cadastroDePessoa);
	}
	
	public SacadorAvalista(String nome, CPRF cadastroDePessoa) {
		super(nome, cadastroDePessoa);
	}
}
