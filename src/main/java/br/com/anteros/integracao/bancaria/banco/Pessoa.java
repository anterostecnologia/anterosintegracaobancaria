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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import br.com.anteros.automacao.bancaria.comum.pessoa.contato.NumeroDeTelefone;
import br.com.anteros.automacao.bancaria.comum.pessoa.endereco.Endereco;
import br.com.anteros.automacao.bancaria.comum.pessoa.id.cprf.AbstractCPRF;
import br.com.anteros.automacao.bancaria.comum.pessoa.id.cprf.CPRF;
import br.com.anteros.core.utils.ObjectUtils;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;



/**
 * 
 * <p>
 * Representa uma pessoa no negócio de boletos bancários.
 * Ela pode assumir três papéis diferentes:
 * <ul>
 * <li>Cedente</li>
 * <li>Sacador</li>
 * <li>Sacador Avalista</li>
 * </ul>
 * </p>
 * 
 */
public class Pessoa implements br.com.anteros.automacao.bancaria.comum.pessoa.Pessoa {
	
	private String nome;
	
	/**
	 * @see CPRF
	 */
	private CPRF cprf;
	
	/**
	 * @see NumeroDeTelefone
	 */
	private Collection<NumeroDeTelefone> telefones;
	
	/**
	 * @see Endereco
	 */
	private Collection<Endereco> enderecos;
	
	/**
	 * @see ContaBancaria
	 */
	private Collection<ContaBancaria> contasBancarias;
	
	public Pessoa() {}
	
	public Pessoa(String nome) {
		
		this.nome = nome;
	}

	public Pessoa(String nome, String cadastroDePessoa) {
		
		this.nome = nome;
		this.cprf = AbstractCPRF.create(cadastroDePessoa);
	}
	
	public Pessoa(String nome, CPRF cadastroDePessoa) {
		
		this.nome = nome;
		this.cprf = cadastroDePessoa;
	}

	/**
	 * @see ContaBancaria
	 */
	public void addContaBancaria(ContaBancaria contaBancaria) {
		
		if(ObjectUtils.isNull(contasBancarias)){
			
			contasBancarias = new ArrayList<ContaBancaria>();
		}
		
		contasBancarias.add(contaBancaria);
	}
	
	/** 
	 * Verifica se esta pessoa tem alguma conta bancária.
	 * 
	 * @see ContaBancaria
	 */
	
	public boolean hasContaBancaria(){
		
		return getContasBancarias() !=null && getContasBancarias().size()>0;
	}
	
	/**
	 * @see Endereco
	 */
	public void addEndereco(Endereco endereco) {

		if(ObjectUtils.isNull(enderecos)){
			
			enderecos = new ArrayList<Endereco>();
		}
		
		enderecos.add(endereco);
	}

	/**
	 * @see NumeroDeTelefone
	 */
	public void addTelefone(NumeroDeTelefone telefone) {
		
		if(ObjectUtils.isNull(telefones)){
			
			telefones = new ArrayList<NumeroDeTelefone>();
		}
		
		telefones.add(telefone);
	}

	/**
	 * @see CPRF
	 */
	
	public CPRF getCPRF() {
		
		return cprf;
	}
	
	/**
	 * Retorna o resultado de uma chamada a {@code iterator.next()} de
	 * {@linkplain #getContasBancarias()}, caso exista alguma conta, ou null, caso
	 * não exista {@linkplain #contasBancarias}.
	 * 
	 * @return Chamada a {@code iterator.next()}, caso exista algum endereço ou
	 *         null.
	 */
	public ContaBancaria getNextContaBancaria(){
		
		if(hasContaBancaria()){
		
			return getContasBancarias().iterator().next();
		}
		
		return null; 
	}

	/**
	 * @see ContaBancaria
	 * @see Collection
	 */
	public Collection<ContaBancaria> getContasBancarias() {

		return contasBancarias;
	}
	
	/**
	 * Retorna o resultado de uma chamada a {@code iterator.next()} de
	 * {@linkplain #getEnderecos()}, caso exista algum endereço, ou null, caso
	 * não exista {@linkplain #enderecos}.
	 * 
	 * @return Chamada a {@code iterator.next()}, caso exista algum endereço ou
	 *         null.
	 */
	public Endereco getNextEndereco(){
		
		if(getEnderecos()!=null && getEnderecos().size()>0){		
			return getEnderecos().iterator().next();
		}
		
		return null; 
	}

	/**
	 * @see Endereco
	 * @see Collection
	 */
	public Collection<Endereco> getEnderecos() {
		return Collections.unmodifiableCollection(enderecos);
	}
	
	public String getNome() {

		return nome;
	}
	
	/**
	 * Retorna o resultado de uma chamada a {@code iterator.next()} de
	 * {@linkplain #getTelefones()}, caso exista algum telefone, ou null, caso
	 * não exista {@linkplain #telefones}.
	 * 
	 * @return Chamada a {@code iterator.next()}, caso exista algum endereço ou
	 *         null.
	 */
	public NumeroDeTelefone getNextTelefone(){
		
		if(getTelefones() !=null && getTelefones().size()>0){		
			return getTelefones().iterator().next();
		}
		
		return null; 
	}

	/**
	 * @see NumeroDeTelefone
	 * @see Collection
	 */
	public Collection<NumeroDeTelefone> getTelefones() {
		
		return telefones;
	}

	/**
	 * @see CPRF
	 */
	public void setCPRF(CPRF cprf) {
		
		this.cprf = cprf;
	}


	public void setNome(String nome) {
	
		this.nome = nome;
	}


	/** 
	 * Verifica se esta pessoa é uma instância de <code>PessoaFisica</code>.
	 * 
	 * @see br.com.anteros.automacao.bancaria.comum.pessoa.Pessoa#isFisica()
	 */
	public boolean isFisica() {
		
		return (this instanceof PessoaFisica);
	}

	/** 
	 * Verifica se esta pessoa é uma instância de <code>PessoaJuridica</code>.
	 * 
	 * @see br.com.anteros.automacao.bancaria.comum.pessoa.Pessoa#isJuridica()
	 */
	public boolean isJuridica() {
		
		return (this instanceof PessoaJuridica);
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", cprf=" + cprf + ", telefones=" + telefones + ", enderecos=" + enderecos
				+ ", contasBancarias=" + contasBancarias + "]";
	}
	
}
