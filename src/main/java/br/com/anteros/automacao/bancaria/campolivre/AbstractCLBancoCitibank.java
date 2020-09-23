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
 * Interface comum para todos os campos livres do CITIBANK
 * 
 */
abstract class AbstractCLBancoCitibank extends AbstractCampoLivre {

	/**
	 * {@code serialVersionUID = 6080749970883991308L}
	 */
	private static final long serialVersionUID = 6080749970883991308L;

	/**
	 * <p>
	 * Cria um campo livre com um determinado nÃºmero de campos
	 * </p>
	 * 
	 * @see AbstractCampoLivre
	 * 
	 * @param fieldsLength
	 *            - NÃºmero de campos
	 */
	protected AbstractCLBancoCitibank(Integer fieldsLength) {

		super(fieldsLength);
	}

	/**
	 * @param titulo
	 * @return um CampoLivre
	 * 
	 */
	 protected static CampoLivre create(Titulo titulo)
     throws NotSupportedCampoLivreException	{
	     checkNossoNumero(titulo);
	     checkNumeroDaContaNotNull(titulo);
	     checkCodigoDoNumeroDaConta(titulo);
	     checkNossoNumero(titulo);
	     checkNumeroDaContaNotNull(titulo);
	     checkCodigoDoNumeroDaConta(titulo);
	     switch(titulo.getNossoNumero().length())
	     {
     case 11: 
         return new CLBancoCitiBankNN11(titulo);
     }
     throw new NotSupportedCampoLivreException("Campo livre diponivel somente para titulos com nosso nmero composto por 10 posicoes(convenio com 7), 11 posicoes ou 17 posicoes(convenio com 6).");
 }


}
