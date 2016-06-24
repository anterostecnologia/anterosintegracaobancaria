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

import br.com.anteros.automacao.bancaria.parametro.ParametroBancoRural;
import br.com.anteros.flatfile.type.component.Fillers;
import br.com.anteros.flatfile.type.component.FixedField;
import br.com.anteros.integracao.bancaria.banco.febraban.Titulo;

/**
 * <p>
 * O campo livre do Banco Rural, para cobrança não registrada, deve seguir esta
 * forma:
 * </p>
 * 
 * <table border="1" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" width="100%" id="campolivre">
 * <thead bgcolor="#DEDEDE">
 * <tr>
 * <th>Posição</th>
 * <th>Tamanho</th>
 * <th>Picture</th>
 * <th>Conteúdo (terminologia padrão)</th>
 * <th>Conteúdo (terminologia do banco)</th>
 * </tr>
 * </thead> <tbody style="text-align:center">
 * <tr>
 * <td>20-20</td>
 * <td>1</td>
 * <td>9(1)</td>
 * <td style="text-align:left;padding-left:10">Tipo de Cobrança - 9</td>
 * <td style="text-align:left;padding-left:10">Tipo de Cobrança - 9</td>
 * </tr>
 * <tr>
 * <td>21-23</td>
 * <td>3</td>
 * <td>9(3)</td>
 * <td style="text-align:left;padding-left:10">Código da Agência</td>
 * <td style="text-align:left;padding-left:10">Agência Cedente</td>
 * </tr>
 * <tr>
 * <td>24-26</td>
 * <td>3</td>
 * <td>9(3)</td>
 * <td style="text-align:left;padding-left:10">Código Reduzido do Cliente</td>
 * <td style="text-align:left;padding-left:10">O código reduzido deverá ser
 * solicitado ao gerente da agência.</td>
 * </tr>
 * <tr>
 * <td>27-41</td>
 * <td>15</td>
 * <td>9(15)</td>
 * <td style="text-align:left;padding-left:10">Seu número</td>
 * <td style="text-align:left;padding-left:10">Nosso número</td>
 * </tr>
 * <tr>
 * <td>42-44</td>
 * <td>3</td>
 * <td>9(3)</td>
 * <td style="text-align:left;padding-left:10">Constante "000"</td>
 * <td style="text-align:left;padding-left:10">Zeros</td>
 * </tr>
 * </tbody>
 * </table>
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 */
class CLBancoRuralCobrancaNaoRegistrada extends AbstractCLBancoRural{

	/**
	 * 
	 */
	private static final long serialVersionUID = -837754906530330855L;

	/**
	 * Número de campos.
	 */
	private static final Integer FIELDS_LENGTH = Integer.valueOf(5);
	
	/**
	 * Tipo de Cobrança = 9. 
	 */
	private static final Integer TIPO_COBRANCA = Integer.valueOf(9);
	
	/**
	 * Constante
	 */
	private static final String ZEROS = "000";
	
	/**
	 * <p>
	 * Dado um título, cria um campo livre para cobrança não registrada do Banco
	 * Rural.
	 * </p>
	 * 
	 * @param titulo
	 *            - Título com as informações para geração do campo livre
	 */
	CLBancoRuralCobrancaNaoRegistrada(Titulo titulo) {
		
		super(FIELDS_LENGTH);
		
		this.add( new FixedField<Integer>( TIPO_COBRANCA , 1 ) );
		this.add( new FixedField<Integer>( titulo.getContaBancaria().getAgencia().getCodigo(), 3 , Fillers.ZERO_LEFT ) );
		this.add( new FixedField<Integer>(titulo.getParametrosBancarios().<Integer>getValor(ParametroBancoRural.CODIGO_REDUZIDO), 3, Fillers.ZERO_LEFT ) );
		this.add( new FixedField<String>( titulo.getNossoNumero(), 15 , Fillers.ZERO_LEFT ) );
		this.add( new FixedField<String>( ZEROS, 3));
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
