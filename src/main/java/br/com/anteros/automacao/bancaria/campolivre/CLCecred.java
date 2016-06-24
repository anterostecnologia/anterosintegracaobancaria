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

import br.com.anteros.automacao.bancaria.parametro.ParametroCECRED;
import br.com.anteros.flatfile.type.component.Fillers;
import br.com.anteros.flatfile.type.component.FixedField;
import br.com.anteros.integracao.bancaria.banco.febraban.Titulo;

/**
 * <p>
 * O campo livre do CECRED - Cooperativa Central de Crédito Urbano deve seguir esta forma:
 * </p>
 * 
 * TODO tabela com campos
 * 
 * @see org.jrimum.bopepo.campolivre.AbstractCampoLivre
 * 
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * @author <a href="mailto:contato@douglasramiro.com.br">Douglas Ramiro</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public class CLCecred extends AbstractCLBancoDeBrasilia{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7075964070090557563L;
	
	/**
	 * Número de campos = 3.
	 */
	private static final Integer FIELDS_LENGTH = Integer.valueOf(3);

	/**
	 * Tamanho do campo Convênio = 6. 
	 */
	private static final Integer CONVENIO_LENGTH = Integer.valueOf(6);

	/**
	 * Tamanho do campo Nosso Número = 17. 
	 */
	private static final Integer NOSSO_NUMERO_LENGTH = Integer.valueOf(17);

	/**
	 * Tamanho do campo Carteira = 2. 
	 */
	private static final Integer CARTEIRA_LENGTH = Integer.valueOf(2);

	/**
	 * <p>
	 *   Cria um campo livre instanciando o número de fields ({@code FIELDS_LENGTH}) deste campo.
	 * </p>
	 * 
	 * @since 0.2
	 */
	protected CLCecred() {
		super(FIELDS_LENGTH);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.jrimum.bopepo.campolivre.AbstractCampoLivre#checkValues(org.jrimum.domkee.financeiro.banco.febraban.Titulo)
	 * 
	 * @since 0.2
	 */
	@Override
	protected void checkValues(Titulo titulo) {

		checkParametroBancario(titulo, ParametroCECRED.CODIGO_DO_CONVENIO);
		checkParametroBancarioMenorOuIgualQue(titulo, ParametroCECRED.CODIGO_DO_CONVENIO, 999999);
		checkNossoNumero(titulo);
		checkTamanhoDoNossoNumero(titulo, 17);
		checkCarteiraNotNull(titulo);
		checkCodigoDaCarteira(titulo);
		checkCodigoDaCarteiraMenorOuIgualQue(titulo, 99);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.jrimum.bopepo.campolivre.AbstractCampoLivre#addFields(org.jrimum.domkee.financeiro.banco.febraban.Titulo)
	 * 
	 * @since 0.2
	 */
	@Override
	protected void addFields(Titulo titulo) {
		
		this.add(new FixedField<Integer>(titulo.getParametrosBancarios().<Integer>getValor(ParametroCECRED.CODIGO_DO_CONVENIO), CONVENIO_LENGTH, Fillers.ZERO_LEFT));
		this.add(new FixedField<String>(titulo.getNossoNumero(), NOSSO_NUMERO_LENGTH, Fillers.ZERO_LEFT));
		this.add(new FixedField<Integer>(titulo.getCarteira().getCodigo(), CARTEIRA_LENGTH, Fillers.ZERO_LEFT));
	}
	
}
