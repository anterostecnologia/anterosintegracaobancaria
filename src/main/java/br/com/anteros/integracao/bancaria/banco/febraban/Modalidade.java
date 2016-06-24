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
package br.com.anteros.integracao.bancaria.banco.febraban;

import br.com.anteros.core.utils.StringUtils;

/**
 * @author <a href="mailto:misaelbarreto@gmail.com">Misael Barreto</a>
 *
 */
public class Modalidade {

	private String codigo;
	
	private String nome;
	
	public Modalidade() {
	}
	
	public Modalidade(String codigo) {
		this.codigo = codigo;	
	}
	
	public Modalidade(Integer codigo) {
		this.codigo = String.valueOf(codigo);	
	}	
	
	public Modalidade(String codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;		
	}

	public Modalidade(Integer codigo, String nome) {
		this.codigo = String.valueOf(codigo);
		this.nome = nome;
	}	
	
	public String getCodigo() {
		return codigo;
	}

	public Integer getCodigoAsInteger() {
		
		if (StringUtils.isNumber(codigo)) {
			return Integer.parseInt(codigo);
			
		} else {
			return null;
		}
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = String.valueOf(codigo);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Modalidade [codigo=" + codigo + ", nome=" + nome + "]";
	}
		
}
