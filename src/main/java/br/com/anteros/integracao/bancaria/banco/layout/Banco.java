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
package br.com.anteros.integracao.bancaria.banco.layout;

import java.awt.Image;
import java.util.Collection;

import br.com.anteros.automacao.bancaria.comum.pessoa.contato.NumeroDeTelefone;
import br.com.anteros.automacao.bancaria.comum.pessoa.endereco.Endereco;
import br.com.anteros.automacao.bancaria.comum.pessoa.id.cprf.CNPJ;
import br.com.anteros.automacao.bancaria.comum.pessoa.id.cprf.CPRF;
import br.com.anteros.core.log.Logger;
import br.com.anteros.core.log.LoggerProvider;
import br.com.anteros.core.utils.StringUtils;
import br.com.anteros.integracao.bancaria.banco.Pessoa;
import br.com.anteros.integracao.bancaria.banco.PessoaJuridica;



/**
 * 
 * <p>
 * Um Banco (instituição financeira) supervisionada pelo <a href="http://www.bcb.gov.br/">BACEN</a>.
 * </p>
 * 
 */
	
public class Banco implements br.com.anteros.integracao.bancaria.banco.Banco {
	
	private static Logger log = LoggerProvider.getInstance().getLogger(Banco.class.getName());

	private CodigoDeCompensacaoBACEN codigoDeCompensacaoBACEN;

	private String segmento;

	private Image imgLogo;
	
	private PessoaJuridica pessoaJuridica;

	/**
	 * 
	 */
	public Banco() {
		super();
	}
	
	
	/**
	 * @param codigoDeCompensacaoBACEN
	 * @param instituicao
	 */
	public Banco(CodigoDeCompensacaoBACEN codigoDeCompensacaoBACEN, String instituicao) {
		super();
		
		this.codigoDeCompensacaoBACEN = codigoDeCompensacaoBACEN;

		pessoaJuridica = new PessoaJuridica();
		pessoaJuridica.setNome(instituicao);
		pessoaJuridica.setNomeFantasia(instituicao);
	}

	/**
	 * @param codigoDeCompensacaoBACEN
	 * @param instituicao
	 * @param cnpj
	 */
	public Banco(CodigoDeCompensacaoBACEN codigoDeCompensacaoBACEN, String instituicao, CNPJ cnpj) {
		super();
		
		this.codigoDeCompensacaoBACEN = codigoDeCompensacaoBACEN;
		
		pessoaJuridica = new PessoaJuridica();
		
		pessoaJuridica.setCPRF(cnpj);
		pessoaJuridica.setNome(instituicao);
		pessoaJuridica.setNomeFantasia(instituicao);
	}

	/**
	 * @param codigoDeCompensacaoBACEN
	 * @param instituicao
	 * @param cnpj
	 * @param segmento
	 */
	public Banco(CodigoDeCompensacaoBACEN codigoDeCompensacaoBACEN, String instituicao, CNPJ cnpj, String segmento) {
		
		super();
		
		this.codigoDeCompensacaoBACEN = codigoDeCompensacaoBACEN;
		this.segmento = segmento;
		
		pessoaJuridica = new PessoaJuridica();
		pessoaJuridica.setCPRF(cnpj);
		pessoaJuridica.setNome(instituicao);
		pessoaJuridica.setNomeFantasia(instituicao);
	}

	/**
	 * @param codigoDeCompensacaoBACEN
	 * @param instituicao
	 * @param cnpj
	 * @param segmento
	 * @param imgLogo
	 */
	public Banco(CodigoDeCompensacaoBACEN codigoDeCompensacaoBACEN, String instituicao, CNPJ cnpj,	String segmento, Image imgLogo) {
		
		super();
		
		this.codigoDeCompensacaoBACEN = codigoDeCompensacaoBACEN;
		this.segmento = segmento;
		this.imgLogo = imgLogo;
		
		pessoaJuridica = new PessoaJuridica();
		pessoaJuridica.setCPRF(cnpj);
	}

	/**
	 * <p>
	 * Verifica se o código passado está ok em relação as regras:
	 * <ol>
	 * <li>Não nulo</li>
	 * <li>Numérico</li>
	 * <li>Com 3 digitos</li>
	 * </ol>
	 * </p>
	 * 
	 * @param codigo - Código de compensação BACEN do banco
	 * 
	 * @return se ok
	 * 
	 * @throws IllegalArgumentException
	 * 
	 * @since 0.2
	 * 
	 */		
	public static boolean isCodigoDeCompensacaoOK(String codigo) {
		
		boolean ok = false;
		
		if (StringUtils.isNotEmpty(codigo)) {
			
			if (StringUtils.isNumber(codigo)) {
				
				if (codigo.length() == 3) {
				
					ok = true;
				
				} else {
					log.warn("O código é de apenas 3 digitos!");
				}
				
			} else {
				log.warn("O código de compensação deve ser numérico!");
			}
		}
		
		return ok;
	}


	/**
	 * @return the codigoDeCompensacaoBACEN
	 */
	public CodigoDeCompensacaoBACEN getCodigoDeCompensacaoBACEN() {
		return codigoDeCompensacaoBACEN;
	}


	/**
	 * @param codigoDeCompensacaoBACEN the codigoDeCompensacaoBACEN to set
	 */
	public void setCodigoDeCompensacaoBACEN(
			CodigoDeCompensacaoBACEN codigoDeCompensacaoBACEN) {
		this.codigoDeCompensacaoBACEN = codigoDeCompensacaoBACEN;
	}


	public CNPJ getCNPJ() {
		return (CNPJ)pessoaJuridica.getCPRF();
	}

	public void setCNPJ(CNPJ cnpj) {
		pessoaJuridica.setCPRF(cnpj);
	}

	public String getSegmento() {
		return segmento;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}

	public Image getImgLogo() {
		return imgLogo;
	}

	public void setImgLogo(Image imgLogo) {
		this.imgLogo = imgLogo;
	}

	/**
	 * @see br.com.anteros.automacao.bancaria.comum.pessoa.Pessoa#addEndereco(br.com.anteros.automacao.bancaria.comum.pessoa.endereco.Endereco)
	 */
	
	public void addEndereco(Endereco endereco) {
		
		pessoaJuridica.addEndereco(endereco);
	}

	/**
	 * @see br.com.anteros.automacao.bancaria.comum.pessoa.Pessoa#addTelefone(br.com.anteros.automacao.bancaria.comum.pessoa.contato.NumeroDeTelefone)
	 */
	
	public void addTelefone(NumeroDeTelefone telefone) {
		
		pessoaJuridica.addTelefone(telefone);
	}

	/**
	 * @see br.com.anteros.automacao.bancaria.comum.pessoa.Pessoa#getCPRF()
	 */
	
	public CPRF getCPRF() {
		
		return pessoaJuridica.getCPRF();
	}

	/**
	 * @see br.com.anteros.automacao.bancaria.comum.pessoa.Pessoa#getEnderecos()
	 */
	public Collection<Endereco> getEnderecos() {
		
		return pessoaJuridica.getEnderecos();
	}

	/**
	 * @see br.com.anteros.automacao.bancaria.comum.pessoa.Pessoa#getNome()
	 */
	
	public String getNome() {
		
		return pessoaJuridica.getNome();
	}

	/**
	 * @see br.com.anteros.automacao.bancaria.comum.pessoa.Pessoa#getTelefones()
	 */
	
	public Collection<NumeroDeTelefone> getTelefones() {
		
		return pessoaJuridica.getTelefones();
	}

	/**
	 * @see br.com.anteros.automacao.bancaria.comum.pessoa.Pessoa#isFisica()
	 */
	
	public boolean isFisica() {
		
		return pessoaJuridica.isFisica();
	}

	/**
	 * @see br.com.anteros.automacao.bancaria.comum.pessoa.Pessoa#isJuridica()
	 */
	
	public boolean isJuridica() {
		
		return pessoaJuridica.isJuridica();
	}

	/**
	 * @see br.com.anteros.automacao.bancaria.comum.pessoa.Pessoa#setCPRF(br.com.anteros.automacao.bancaria.comum.pessoa.id.cprf.CPRF)
	 */
	
	public void setCPRF(CPRF cprf) {
		
		pessoaJuridica.setCPRF(cprf);
	}


	/**
	 * @see br.com.anteros.automacao.bancaria.comum.pessoa.Pessoa#setNome(java.lang.String)
	 */
	
	public void setNome(String nome) {
		
		pessoaJuridica.setNome(nome);
	}


	/**
	 * @see br.com.anteros.automacao.bancaria.comum.pessoa.PessoaJuridica#getInscricaoEstadual()
	 */
	
	public Long getInscricaoEstadual() {
		
		return pessoaJuridica.getInscricaoEstadual();
	}

	/**
	 * @see br.com.anteros.automacao.bancaria.comum.pessoa.PessoaJuridica#getInscricaoMunicipal()
	 */
	
	public Long getInscricaoMunicipal() {
		
		return pessoaJuridica.getInscricaoMunicipal();
	}

	/**
	 * @see br.com.anteros.automacao.bancaria.comum.pessoa.PessoaJuridica#getNomeFantasia()
	 */
	
	public String getNomeFantasia() {
		
		return pessoaJuridica.getNome();
	}

	/**
	 * @see br.com.anteros.automacao.bancaria.comum.pessoa.PessoaJuridica#setInscricaoEstadual(java.lang.Long)
	 */
	
	public void setInscricaoEstadual(Long inscricaoEstadual) {
		
		pessoaJuridica.setInscricaoEstadual(inscricaoEstadual);
	}

	/**
	 * @see br.com.anteros.automacao.bancaria.comum.pessoa.PessoaJuridica#setInscricaoMunicipal(java.lang.Long)
	 */
	
	public void setInscricaoMunicipal(Long inscricaoMunicipal) {
		
		pessoaJuridica.setInscricaoMunicipal(inscricaoMunicipal);
	}

	/**
	 * @see br.com.anteros.automacao.bancaria.comum.pessoa.PessoaJuridica#setNomeFantasia(java.lang.String)
	 */
	
	public void setNomeFantasia(String nomeFantasia) {
		
		pessoaJuridica.setNomeFantasia(nomeFantasia);
	}

	/**
	 * @see Pessoa#addContaBancaria(ContaBancaria)
	 */
	public void addContaBancaria(ContaBancaria contaBancaria) {
		pessoaJuridica.addContaBancaria(contaBancaria);
		
	}


	/**
	 * @see Pessoa#getContasBancarias()
	 */
	
	public Collection<ContaBancaria> getContasBancarias() {
		
		return pessoaJuridica.getContasBancarias();
	}

	/**
	 * @see Pessoa#hasContaBancaria()
	 */
	public boolean hasContaBancaria() {
		
		return pessoaJuridica.hasContaBancaria();
	}
	
	


	@Override
	public String toString() {
		
		StringBuilder tb = new StringBuilder(super.toString());
		tb.append(codigoDeCompensacaoBACEN);
		tb.append(segmento);
		tb.append(pessoaJuridica);
		
		return tb.toString();
	}

}
