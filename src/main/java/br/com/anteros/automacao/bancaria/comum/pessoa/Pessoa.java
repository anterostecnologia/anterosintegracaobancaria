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

import br.com.anteros.automacao.bancaria.comum.pessoa.contato.NumeroDeTelefone;
import br.com.anteros.automacao.bancaria.comum.pessoa.endereco.Endereco;
import br.com.anteros.automacao.bancaria.comum.pessoa.id.cprf.CPRF;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;


/**
 * 
 * @see br.com.anteros.integracao.bancaria.banco.Pessoa
 * 
 */
public interface Pessoa{

	public String getNome();

	public void setNome(String nome);

	public CPRF getCPRF();

	public void setCPRF(CPRF cprf);

	public Collection<NumeroDeTelefone> getTelefones();

	public void addTelefone(NumeroDeTelefone telefone);

	public Collection<Endereco> getEnderecos();

	public void addEndereco(Endereco endereco);

	public Collection<ContaBancaria> getContasBancarias();

	public void addContaBancaria(ContaBancaria contaBancaria);

	public boolean isFisica();

	public boolean isJuridica();
	
	public boolean hasContaBancaria();
}
