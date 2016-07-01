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

import java.util.Collection;
import java.util.Collections;

import br.com.anteros.automacao.bancaria.comum.pessoa.contato.NumeroDeTelefone;
import br.com.anteros.automacao.bancaria.comum.pessoa.endereco.Endereco;
import br.com.anteros.automacao.bancaria.comum.pessoa.id.cprf.CPRF;
import br.com.anteros.integracao.bancaria.banco.Pessoa;


/**
 * Supertipo para as entidades de cobrança (Sacado, Cedente, SacadorAvalista). Encapsula
 * a composição com o objeto Pessoa deixando apenas as particularidades de cada entidade nos subtipos.
 * 
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 *
 * @since 0.2
 * 
 * @version 0.2
 */
public class EntidadeDeCobranca{

	/**
	 * Utilizado como composição
	 */
	private Pessoa pessoa;
	
	public EntidadeDeCobranca(String nome) {
		pessoa = new Pessoa(nome);
	}
	
	public EntidadeDeCobranca(String nome, String cadastroDePessoa) {
		pessoa = new Pessoa(nome, cadastroDePessoa);
	}
	
	public EntidadeDeCobranca(String nome, CPRF cadastroDePessoa) {
		pessoa = new Pessoa(nome, cadastroDePessoa);
	}
	
	/**
	 * @return Nome da entidade
	 */
	public String getNome() {
		return pessoa.getNome();
	}
	
	public void setNome(String nome) {
		pessoa.setNome(nome);
	}
	
	/**
	 * @see CPRF
	 */
	public CPRF getCPRF() {
		return pessoa.getCPRF();
	}
	
	/**
	 * @see CPRF
	 */
	public void setCPRF(CPRF cprf) {
		pessoa.setCPRF(cprf);
	}
	
	/**
	 * @see ContaBancaria
	 */
	public void addContaBancaria(ContaBancaria contaBancaria) {
		pessoa.addContaBancaria(contaBancaria);
	}
	
	/** 
	 * Verifica se esta pessoa tem alguma conta bancária.
	 * 
	 * @see ContaBancaria
	 */
	public boolean hasContaBancaria(){
		return pessoa.hasContaBancaria();
	}
	
	/**
	 * @return A próxima conta bancária
	 */
	public ContaBancaria getNextContaBancaria(){
		
		return pessoa.getNextContaBancaria();
	}
	
	/**
	 * @see ContaBancaria
	 * @see Collection
	 */
	public Collection<ContaBancaria> getContasBancarias() {
		return pessoa.getContasBancarias();
	}
	
	
	/**
	 * @see Endereco
	 */
	public void addEndereco(Endereco endereco) {
		pessoa.addEndereco(endereco);
	}
	
	/**
	 * @return O próximo endereço da entidade.
	 */
	public Endereco getNextEndereco(){
		
		return pessoa.getNextEndereco(); 
	}
	
	/**
	 * @see Endereco
	 * @see Collection
	 */
	public Collection<Endereco> getEnderecos() {
		return pessoa.getEnderecos();
	}
	

	/**
	 * @see NumeroDeTelefone
	 */
	public void addTelefone(NumeroDeTelefone telefone) {
		pessoa.addTelefone(telefone);
	}

	/**
	 * @return O próximo telefone da entidade.
	 */
	public NumeroDeTelefone getNextTelefone(){
		
		return pessoa.getNextTelefone(); 
	}
	
	/**
	 * @see NumeroDeTelefone
	 * @see Collection
	 */
	public Collection<NumeroDeTelefone> getTelefones() {
		return pessoa.getTelefones();
	}


}
