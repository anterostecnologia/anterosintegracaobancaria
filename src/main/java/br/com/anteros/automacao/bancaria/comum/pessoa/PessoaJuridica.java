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


/**
 * 
 * @author <a href="http://gilmatryx.googlepages.com">Gilmar P.S.L.</a>
 * @author <a href="mailto:misaelbarreto@gmail.com">Misael Barreto</a>
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * 
 * @see br.com.anteros.integracao.bancaria.banco.PessoaJuridica
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public interface PessoaJuridica extends Pessoa {

	public String getNomeFantasia();

	public void setNomeFantasia(String nomeFantasia);

	public Long getInscricaoEstadual();

	public void setInscricaoEstadual(Long inscricaoEstadual);

	public Long getInscricaoMunicipal();

	public void setInscricaoMunicipal(Long inscricaoMunicipal);
}
