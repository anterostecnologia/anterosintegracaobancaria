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
import br.com.anteros.integracao.bancaria.validador.digitoverificador.Modulo;

abstract class AbstractCLUnibanco extends AbstractCampoLivre {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6169577742706045367L;

	/**
	 * <p>Cria um campo livre com um determinado número de campos</p>
	 * 
	 * @see AbstractCampoLivre
	 * 
	 * @param fieldsLength - Número de campos
	 */
	protected AbstractCLUnibanco(Integer fieldsLength) {
		
		super(fieldsLength);
	}

	protected static CampoLivre create(Titulo titulo) throws NotSupportedCampoLivreException {

		checkCarteiraNotNull(titulo);
		checkRegistroDaCarteiraNotNull(titulo);

		switch(titulo.getCarteira().getTipoDeCobranca()){
		case SEM_REGISTRO:
			return new CLUnibancoCobrancaNaoRegistrada(titulo);
		case COM_REGISTRO:
			return new CLUnibancoCobrancaRegistrada(titulo);
		default:
			return null;
		}
	}

	/**
	 * <p>
	 * Calcula o dígito verificador para
	 * <em>referência do cliente (cobrança sem registro)</em> e base para
	 * cálculo do <em>super dígito do nosso numero (cobrança com registro)</em>.
	 * </p>
	 * 
	 * @param numero
	 * @return String dígito
	 * 
	 * @since 0.2
	 */
	String calculeDigitoEmModulo11(String numero) {

		String dv = "";

		int soma = Modulo.calculeSomaSequencialMod11(numero, 2, 9);

		soma *= 10;

		final int resto = soma % 11;

		if (resto == 10 || resto == 0)
			dv = "0";
		else
			dv = "" + resto;

		return dv;

	}
}
