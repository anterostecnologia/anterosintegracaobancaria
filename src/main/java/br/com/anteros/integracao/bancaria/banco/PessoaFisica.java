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
package br.com.anteros.integracao.bancaria.banco;


import java.util.Collection;

import br.com.anteros.automacao.bancaria.comum.pessoa.id.RG;
import br.com.anteros.core.utils.ObjectUtils;


/**
 * <p>
 * Representação básica de uma Pessoa Física.
 * </p>
 * 
 * @see Pessoa
 * @see br.com.anteros.automacao.bancaria.comum.pessoa.id.cprf.CPRF
 * @see br.com.anteros.automacao.bancaria.comum.pessoa.id.cprf.CPF
 * 
 */

public class PessoaFisica extends Pessoa implements
		br.com.anteros.automacao.bancaria.comum.pessoa.PessoaFisica {

	private br.com.anteros.automacao.bancaria.comum.pessoa.PessoaFisica conjuge;

	private String estadoCivil;

	private Collection<RG> rgs;

	public PessoaFisica() {
	}

	public br.com.anteros.automacao.bancaria.comum.pessoa.PessoaFisica getConjuge() {

		return conjuge;
	}

	public String getEstadoCivil() {

		return estadoCivil;
	}

	public Collection<RG> getRgs() {

		return rgs;
	}

	public void setConjuge(
			br.com.anteros.automacao.bancaria.comum.pessoa.PessoaFisica conjuge) {

		this.conjuge = conjuge;

		if (ObjectUtils.isNotNull(conjuge) && ObjectUtils.isNull(conjuge.getConjuge()))
			conjuge.setConjuge(this);
	}

	public void setEstadoCivil(String estadoCivil) {

		this.estadoCivil = estadoCivil;
	}

	public void setRgs(Collection<RG> rgs) {

		this.rgs = rgs;
	}

}
