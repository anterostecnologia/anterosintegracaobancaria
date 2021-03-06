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

import br.com.anteros.integracao.bancaria.banco.layout.Titulo;

/**
 * <p>
 * Interface comum para todos os campos livres do Banco do Brasil que venham a existir.
 * </p>
 * 
 */
abstract class AbstractCLBancoDoBrasil extends AbstractCampoLivre {
	
	/**
	 *
	 */
	private static final long serialVersionUID = -7324315662526104153L;

	/**
	 * <p>Cria um campo livre com um determinado número de campos</p>
	 * 
	 * @see AbstractCampoLivre
	 * 
	 * @param fieldsLength - Número de campos
	 */
	protected AbstractCLBancoDoBrasil(Integer fieldsLength) {
		
		super(fieldsLength);
	}

	protected static CampoLivre create(Titulo titulo) throws NotSupportedCampoLivreException{

		checkNossoNumero(titulo);
		checkNumeroDaContaNotNull(titulo);
		checkCodigoDoNumeroDaConta(titulo);
		
		switch(titulo.getNossoNumero().length()){
		case NN10:
			return new CLBancoDoBrasilNN10(titulo);
		case NN11:
			return new CLBancoDoBrasilNN11(titulo);
		case NN17:
			if(titulo.getContaBancaria().getNumeroDaConta().getCodigoDaConta() < 1000000){
				return new CLBancoDoBrasilNN17Convenio6(titulo);
			}else{
				return new CLBancoDoBrasilNN17Convenio7().build(titulo);
			}
		default:
			throw new NotSupportedCampoLivreException(
					"Campo livre diponível somente para títulos com nosso número " +
					"composto por 10 posições(convênio com 7), 11 posições ou " +
					"17 posições(convênio com 6)."
				);
		}
	}
}
