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
package br.com.anteros.automacao.bancaria.comum.pessoa;

import java.util.Collection;

import br.com.anteros.automacao.bancaria.comum.pessoa.id.RG;



/**
 * 
 * @see br.com.anteros.integracao.bancaria.banco.PessoaFisica
 * 
 */
public interface PessoaFisica extends Pessoa {
	
	public PessoaFisica getConjuge();

	public void setConjuge(PessoaFisica conjuge);

	public String getEstadoCivil();

	public void setEstadoCivil(String estadoCivil);
	
	public Collection<RG> getRgs();
	
	public void setRgs(Collection<RG> rgs);
}
