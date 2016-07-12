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
 * Interface comum para todos os campos livres do Banco do Nordeste do 
 * Brasil que venham a existir.
 * </p>
 * 
 * @author <a href="mailto:misaelbarreto@gmail.com">Misael Barreto</a>
 * @author <a href="mailto:pporto@gmail.com">Paulo Porto</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public abstract class AbstractCLBancoDoNordesteDoBrasil extends AbstractCampoLivre {


	/**
	 * 
	 */
	private static final long serialVersionUID = -5036970456320987443L;

	/**
	 * <p>Cria um campo livre com um determinado número de campos</p>
	 * 
	 * @see AbstractCampoLivre
	 * 
	 * @param fieldsLength - Número de campos
	 * 
	 * @since 0.2
	 */
	protected AbstractCLBancoDoNordesteDoBrasil(Integer fieldsLength) {
		
		super(fieldsLength);
	}
	
	/**
	 * @param titulo
	 * @return um CampoLivre
	 * 
	 * @see org.jrimum.bopepo.campolivre.AbstractCLBancoDoNordesteDoBrasil#create(Titulo)
	 */
	protected static CampoLivre create(Titulo titulo){
		return new CLBancoDoNordesteDoBrasil().build(titulo);
	}	
	
}
