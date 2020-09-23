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


package br.com.anteros.automacao.bancaria.comum.pessoa.id;

import java.util.Date;

import br.com.anteros.integracao.bancaria.banco.PessoaFisica;



/**
 * 
 * <p>
 * Representação básica de um Registro Geral (<em>RG</em>).
 * </p>
 * 
 */
public class RG{

	private long numero;
	
	private String orgaoExpedidor;
	
	private String filiacaoPai;
	
	private String filiacaoMae;
	
	private Date dataNascimento;
	
	private PessoaFisica pessoa;

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public String getOrgaoExpedidor() {
		return orgaoExpedidor;
	}

	public void setOrgaoExpedidor(String orgaoExpedidor) {
		this.orgaoExpedidor = orgaoExpedidor;
	}

	public String getFiliacaoPai() {
		return filiacaoPai;
	}

	public void setFiliacaoPai(String filiacaoPai) {
		this.filiacaoPai = filiacaoPai;
	}

	public String getFiliacaoMae() {
		return filiacaoMae;
	}
	
	public void setFiliacaoMae(String filiacaoMae) {
		this.filiacaoMae = filiacaoMae;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public PessoaFisica getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaFisica pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "RG [numero=" + numero + ", orgaoExpedidor=" + orgaoExpedidor + ", filiacaoPai=" + filiacaoPai
				+ ", filiacaoMae=" + filiacaoMae + ", dataNascimento=" + dataNascimento + ", pessoa=" + pessoa + "]";
	}
	
	
}
