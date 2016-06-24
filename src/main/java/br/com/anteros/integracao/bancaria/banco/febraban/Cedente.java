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

import br.com.anteros.automacao.bancaria.comum.pessoa.id.cprf.CPRF;

/**
 * <p>
 * Representa um Cedente no modelo de negócio financeiro, que é 
 * aquele que realiza a cobrança do título.
 * </p>
 * <p>
 * Cliente que entrega os títulos ao Banco para serem cobrados.
 * </p>
 * 
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public class Cedente extends EntidadeDeCobranca {

	public Cedente(String nome) {
		super(nome);
	}
	
	public Cedente(String nome, String cadastroDePessoa) {
		super(nome, cadastroDePessoa);
	}
	
	public Cedente(String nome, CPRF cadastroDePessoa) {
		super(nome, cadastroDePessoa);
	}
}
