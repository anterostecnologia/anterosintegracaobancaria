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
import br.com.anteros.integracao.bancaria.banco.febraban.Titulo;

/**
 * <p>
 * 	O campo livre do HSBC, para cobrança registrada(CSB), deve seguir esta forma:
 * </p>
 * 
 * 	<table border="1" cellpadding="0" cellspacing="0" style="border-collapse:
 * 	collapse" bordercolor="#111111" width="100%" id="campolivre">
 * 		<thead bgcolor="#DEDEDE">
 * 			<tr>
 *				<th>Posição </th>
 * 				<th>Tamanho</th>
 * 				<th>Picture</th>
 * 				<th>Conteúdo (terminologia padrão)</th>
 * 				<th>Conteúdo (terminologia do banco)</th>
 * 			</tr>
 * 		</thead>
 *		<tbody style="text-align:center">
 * 		<tr>
 * 			<td>20-30</td>
 * 			<td>11</td>
 * 			<td>9(11) </td>
 * 			<td style="text-align:left;padding-left:10px">Nosso número com dígito</td>
 * 			<td style="text-align:left;padding-left:10">Número Bancário</td>
 * 		</tr>
 *   	<tr>
 * 			<td>31-34</td>
 * 			<td>4</td>
 * 			<td>9(4) </td>
 * 			<td style="text-align:left;padding-left:10">Código da Agência.</td>
 * 			<td style="text-align:left;padding-left:10">Código da Agência.</td>
 * 		</tr>
 *    	<tr>
 * 			<td>35-41</td>
 * 			<td>7</td>
 * 			<td>9(7) </td>
 * 			<td style="text-align:left;padding-left:10">Conta Corrente.</td>
 * 			<td style="text-align:left;padding-left:10">Conta de cobrança.</td>
 * 		</tr>
 *     	<tr>
 * 			<td>42-43</td>
 * 			<td>2</td>
 * 			<td>9(2) </td>
 * 			<td style="text-align:left;padding-left:10">Código da carteira="00"</td>
 * 			<td style="text-align:left;padding-left:10">Código da carteira="00"</td>
 * 		</tr>
 * 		<tr>
 * 			<td>44-44</td>
 * 			<td>2</td>
 * 			<td>9(2) </td>
 * 			<td style="text-align:left;padding-left:10">Constante="1"</td>
 * 			<td style="text-align:left;padding-left:10">Código do aplicativo da Cobrança (COB) = "1"</td>
 * 		</tr>
 * 		</tbody>
 * </table>
 * 
 * 
 * @see org.jrimum.bopepo.campolivre.AbstractCampoLivre
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
class CLHSBCCobrancaRegistrada extends AbstractCLHSBC{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5052841093486791338L;
	
	private static final Integer FIELDS_LENGTH = 6;

	private static final String CODIGO_DA_CARTEIRA = "00";

	private static final Integer CODIGO_DO_APLICATIVO = Integer.valueOf(1);

	/**
	 * * <p>
	 *   Dado um título, cria um campo livre para cobrança registrada do banco HSBC.
	 * </p>
	 * 
	 * @param titulo - título com as informações para geração do campo livre
	 */
	CLHSBCCobrancaRegistrada(Titulo titulo) {
		
		super(FIELDS_LENGTH);
		
		this.add(new FixedField<String>(titulo.getNossoNumero(), 10, Fillers.ZERO_LEFT));	
		this.add(new FixedField<String>(titulo.getDigitoNossoNumero(), 1));	
		this.add(new FixedField<Integer>(titulo.getContaBancaria().getAgencia().getCodigo(), 4, Fillers.ZERO_LEFT));
		this.add(new FixedField<Integer>(titulo.getContaBancaria().getNumeroDaConta().getCodigoDaConta(), 7, Fillers.ZERO_LEFT));
		this.add(new FixedField<String>(CODIGO_DA_CARTEIRA, 2));
		this.add(new FixedField<Integer>(CODIGO_DO_APLICATIVO, 1));
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
