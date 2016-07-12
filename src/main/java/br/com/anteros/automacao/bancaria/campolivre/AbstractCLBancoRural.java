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
 * Interface comum para todos os campos livres do Banco Santander que venham a
 * existir.
 * </p>
 * 
 * @author <a href="mailto:fernandobgi@gmail.com">Fernando Dias</a> -
 *         Colaborador com o campo livre {@code CLBancoRuralCobrancaRegistrada}
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
abstract class AbstractCLBancoRural extends AbstractCampoLivre {

	/**
	 * 
	 */
	private static final long serialVersionUID = -602454445158254612L;

	/**
	 * <p>Cria um campo livre com um determinado número de campos</p>
	 * 
	 * @see AbstractCampoLivre
	 * 
	 * @param fieldsLength - Número de campos
	 */
	protected AbstractCLBancoRural(Integer fieldsLength) {
		
		super(fieldsLength);
	}

	protected static CampoLivre create(Titulo titulo) {
		
		checkCarteiraNotNull(titulo);
		checkRegistroDaCarteiraNotNull(titulo);
		
		switch(titulo.getCarteira().getTipoDeCobranca()){
		case SEM_REGISTRO:
			return campoSemRegistro(titulo);
		case COM_REGISTRO:
			return new CLBancoRuralCobrancaRegistrada(titulo);
		default:
			return null;
		}
	}

	/**
	 * Determina e cria um campo livre de cobrança não registrada.
	 * 
	 * @param titulo
	 *            - título com as informações para geração do campo livre
	 * @return campo livre ou null
	 */
	private static CampoLivre campoSemRegistro(Titulo titulo) {
		
		checkNossoNumero(titulo);
		
		switch(titulo.getNossoNumero().length()){
		case NN10:
			return new CLBancoRuralCobrancaNaoRegistradaSeguradora(titulo);
		case NN15:
			return new CLBancoRuralCobrancaNaoRegistrada(titulo);
		default:
			throw new NotSupportedCampoLivreException(
					"Combrança sem registro com campo livre diponível somente para títulos com nosso número" 
					+ " composto por 10 posições(apólice de seguro com I.O.S.) e 15 posições(padrão)."
				);
		}
	}
}
