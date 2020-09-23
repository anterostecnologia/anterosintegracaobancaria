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

import static java.lang.String.format;

import br.com.anteros.integracao.bancaria.banco.layout.Titulo;

/**
 *<p>
 * Interface comum para todos os campos livres do Banco Caixa Econômica Federal
 * que venham a existir.
 * </p>
 */
abstract class AbstractCLCaixaEconomicaFederal extends AbstractCampoLivre {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4104858478390595830L;
	
	/**
	 * <p>Cria um campo livre com um determinado número de campos</p>
	 * 
	 * @see AbstractCampoLivre
	 * 
	 * @param fieldsLength - Número de campos
	 */
	protected AbstractCLCaixaEconomicaFederal(Integer fieldsLength) {
		
		super(fieldsLength);
	}

	protected static CampoLivre create(Titulo titulo) throws NotSupportedCampoLivreException{
		
		checkNossoNumero(titulo);
		
		switch(titulo.getNossoNumero().length()){
		case NN10:
			return new CLCaixaEconomicaFederalSICOBNossoNumero10(titulo);
		case NN14:
			return new CLCaixaEconomicaFederalSICOBNossoNumero14().build(titulo);
		case NN15:
			return new CLCaixaEconomicaFederalSIGCB(titulo);
		case NN17:
			return new CLCaixaEconomicaFederalSINCO(titulo);
		default:
			throw new NotSupportedCampoLivreException(
					format("Campo Livre não suportado para o Nosso Número [%s] de tamanho [%s]." 
					+ " Apenas títulos com Nosso Número de tamanho [%s] são suportados (SICOB, SIGCB e SINCO respectivamente)."
					,titulo.getNossoNumero(), titulo.getNossoNumero().length() 
					,NN10 + "," + NN14 + ","+ NN15 + "," + NN17)
					);
		}
	}
}
