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
package br.com.anteros.automacao.bancaria.campolivre;

import br.com.anteros.flatfile.type.component.Fillers;
import br.com.anteros.flatfile.type.component.FixedField;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.Titulo;

/**
 * 
 * O campo livre do Banco do Brasil com o nosso número de 11 dígitos deve seguir
 * esta forma:
 * 
 * <table border="1" cellpadding="0" cellspacing="0" style="border-collapse:
 * collapse" bordercolor="#111111" width="60%" id="campolivre">
 * <tr> <thead>
 * <th>Posição </th>
 * <th>Tamanho</th>
 * <th>Picture</th>
 * <th>Conteúdo (terminologia padrão)</th>
 * <th>Conteúdo (terminologia do banco)</th>
 * </thead> </tr>
 * <tr>
 * <td>20-30</td>
 * <td>11</td>
 * <td>9(11) </td>
 * <td>Nosso número (sem dígito)</td>
 * <td>Nosso número (sem dígito)</td>
 * </tr>
 * <tr>
 * <td>31-34</td>
 * <td>4</td>
 * <td>9(4) </td>
 * <td>Código da agência (sem dígito)</td>
 * <td>Código da Agência (sem dígito)</td>
 * </tr>
 * <tr>
 * <td>35-42</td>
 * <td>8</td>
 * <td>9(8) </td>
 * <td>Código da conta (sem dígito)</td>
 * <td>Convênio (sem dígito)</td>
 * </tr>
 * <tr>
 * <td >43-44</td>
 * <td >2</td>
 * <td >9(2) </td>
 * <td >Carteira</td>
 * <td >Carteira</td>
 * </tr>
 * </table>
 * 
 * 
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * @author <a href="mailto:misaelbarreto@gmail.com">Misael Barreto</a>
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * @author <a href="http://www.nordestefomento.com.br">Nordeste Fomento
 *         Mercantil</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
class CLBancoDoBrasilNN11 extends AbstractCLBancoDoBrasil {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4859699102593834115L;
	
	/**
	 * 
	 */
	private static final Integer FIELDS_LENGTH = 4;
	
	/**
	 * <p>
	 *   Dado um título, cria um campo livre para o padrão do Banco do Brasil
	 *   que tenha o nosso número de tamanho 11.  
	 * </p>
	 * @param titulo título com as informações para geração do campo livre
	 */
	CLBancoDoBrasilNN11(Titulo titulo) {
		
		super(FIELDS_LENGTH);
		
		ContaBancaria conta = titulo.getContaBancaria();
		String nossoNumero = titulo.getNossoNumero();
		
		this.add(new FixedField<String>(nossoNumero, 11, Fillers.ZERO_LEFT));
		
		this.add(new FixedField<Integer>(conta.getAgencia().getCodigo(), 4, Fillers.ZERO_LEFT));
		this.add(new FixedField<Integer>(conta.getNumeroDaConta().getCodigoDaConta(), 8, Fillers.ZERO_LEFT));
		
		this.add(new FixedField<Integer>(titulo.getCarteira().getCodigo(), 2, Fillers.ZERO_LEFT));
	}
	
	@Override
	protected void addFields(Titulo titulo) {
		// TODO IMPLEMENTAR
		throw new UnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
	}

	@Override
	protected void checkValues(Titulo titulo) {
		// TODO IMPLEMENTAR
		throw new UnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
	}
}
