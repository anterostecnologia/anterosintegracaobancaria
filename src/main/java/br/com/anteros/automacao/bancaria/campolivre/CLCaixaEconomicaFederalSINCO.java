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
 * <p>
 * O campo livre para o modelo SINCO segue esta forma:
 * </p>
 * <table border="1" cellpadding="0" cellspacing="0" style="border-collapse:
 * collapse" bordercolor="#111111" width="60%" id="campolivre">
 * <thead>
 * <tr>
 * <td>Posição</td>
 * <td>Tamanho</td>
 * <td>Conteúdo</td>
 * </tr>
 * </thead>
 * <tbody>
 * <tr>
 * <td>01</td>
 * <td>1</td>
 * <td>Número "1" (valor fixo)</td>
 * </tr>
 * <tr>
 * <td>02-07</td>
 * <td>6</td>
 * <td>Código do cliente CEDENTE (fornecido pela CAIXA)</td>
 * </tr>
 * <tr>
 * <td>08</td>
 * <td>1</td>
 * <td>Número "9" (valor fixo)</td>
 * </tr>
 * <tr>
 * <td>09-25</td>
 * <td>17</td>
 * <td>Posições livres do "nosso número"</td>
 * </tr>
 * </tbody>
 * </table>
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * @author <a href="mailto:misaelbarreto@gmail.com">Misael Barreto</a> 
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * @author <a href="http://www.nordestefomento.com.br">Nordeste Fomento Mercantil</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
class CLCaixaEconomicaFederalSINCO extends AbstractCLCaixaEconomicaFederal {

	private static final long serialVersionUID = -7642075752245778160L;
	
	/**
	 * Quantidade de campos. Tamanho da lista de campos.
	 */
	private static final Integer FIELDS_LENGTH = 4;

	/**
	 * <p>
	 * Dado um título, cria um campo livre para o padrão do Banco Caixa Econômica
	 * Federal que tenha o serviço SINCO.
	 * </p>
	 * @param titulo Título com as informações para geração do campo livre.
	 */
	CLCaixaEconomicaFederalSINCO(Titulo titulo) {
		super(FIELDS_LENGTH);
		
		ContaBancaria conta = titulo.getContaBancaria();
		
		String nossoNumero = titulo.getNossoNumero();
		
		this.add(new FixedField<Integer>(1, 1));
		
		this.add(new FixedField<Long>(conta.getNumeroDaConta().getCodigoDaConta(), 6, Fillers.ZERO_LEFT));
		
		this.add(new FixedField<Integer>(9, 1));
		this.add(new FixedField<String>(nossoNumero, 17));
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
