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
package br.com.anteros.automacao.bancaria.comum.pessoa.id.cprf;

/**
 * Interface comum entre Cadastro de Pessoa na Receita Federal de pessoas
 * Físicas ou Jurídicas.
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 */
public interface CPRF extends Comparable<Object>{

	public boolean isFisica();

	public boolean isJuridica();

	public Long getCodigo();

	public String getCodigoComZeros();
	
	public String getCodigoFormatado();
	
	public Long getRaiz();

	public String getRaizComZeros();
	
	public String getRaizFormatada();
	
	public Integer getDv();

	public String getDvComZeros();
}
