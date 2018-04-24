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


/**
 * 
 * <p>
 *  Carteira de Cobrança de uma Conta Corrente.
 * </p>
 * 
 * 
 * @author <a href=http://gilmatryx.googlepages.com/>Gilmar P.S.L.</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
	
public class Carteira {

	/**
	 * @see #setNome(String)
	 */
	private String nome;

	/**
	 * 
	 * 
	 */
	private Integer codigo;

	/**
	 * @see #setTipoCobranca(TipoDeCobranca)
	 */
	private TipoDeCobranca tipoDeCobranca;
	
	private TipoDeEmissaoBoleto tipoDeEmissaoBoleto;
	
	private TipoDeDistribuicaoBoleto tipoDeDistribuicaoBoleto;
	
	private TipoFormulario tipoFormulario;
	
	private String codigoConvenio;
	
	private Integer variacaoCarteira=0; 

	/**
	 * 
	 */
	public Carteira() {
		super();
	}	

	/**
	 * @param codigo
	 */
	public Carteira(Integer codigo) {
		super();
		this.codigo = codigo;
	}


	/**
	 * @param codigo
	 * @param cobranca
	 */
	public Carteira(Integer codigo, TipoDeCobranca cobranca) {
		super();
		this.codigo = codigo;
		this.tipoDeCobranca = cobranca;
	}


	/**
	 * @param codigo
	 * @param cobranca
	 * @param nome
	 */
	public Carteira(Integer codigo, TipoDeCobranca cobranca, String nome) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.tipoDeCobranca = cobranca;
	}

	/**
	 * @see #setNome(String)  
	 * 
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * <p>
	 * Nome da modalidade de cobrança (ou serviços) atribuído a carteira.
	 * </p>
	 * 
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @see #setCodigo(Integer)
	 * 
	 * @return the codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}

	/**
	 * <p>
	 * Código adotado pela <a href="http://www.febraban.org.br">FEBRABAN</a>, para identificar a característica dos
	 * títulos dentro das modalidades de cobrança existentes no banco.
	 * </p>
	 * 
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	/**
	 * <p>
	 * Indica se é uma carteira registrada.
	 * </p>
	 * 
	 * @return true se registrada
	 */
	public boolean isComRegistro() {
		return (this.tipoDeCobranca == TipoDeCobranca.COM_REGISTRO);
	}
	
	/**
	 * <p>
	 * Indica se é uma carteira não registrada.
	 * </p>
	 * 
	 * @return true se sem registro
	 */
	public boolean isSemRegistro() {
		return (this.tipoDeCobranca == TipoDeCobranca.SEM_REGISTRO);
	}


	public TipoDeCobranca getTipoDeCobranca() {
		return tipoDeCobranca;
	}

	public void setTipoDeCobranca(TipoDeCobranca tipoDeCobranca) {
		this.tipoDeCobranca = tipoDeCobranca;
	}

	public TipoDeEmissaoBoleto getTipoDeEmissaoBoleto() {
		return tipoDeEmissaoBoleto;
	}

	public void setTipoDeEmissaoBoleto(TipoDeEmissaoBoleto tipoDeEmissaoBoleto) {
		this.tipoDeEmissaoBoleto = tipoDeEmissaoBoleto;
	}

	public TipoDeDistribuicaoBoleto getTipoDeDistribuicaoBoleto() {
		return tipoDeDistribuicaoBoleto;
	}

	public void setTipoDeDistribuicaoBoleto(TipoDeDistribuicaoBoleto tipoDeDistribuicaoBoleto) {
		this.tipoDeDistribuicaoBoleto = tipoDeDistribuicaoBoleto;
	}

	public TipoFormulario getTipoFormulario() {
		return tipoFormulario;
	}

	public void setTipoFormulario(TipoFormulario tipoFormulario) {
		this.tipoFormulario = tipoFormulario;
	}

	public String getCodigoConvenio() {
		return codigoConvenio;
	}

	public void setCodigoConvenio(String codigoConvenio) {
		this.codigoConvenio = codigoConvenio;
	}

	public Integer getVariacaoCarteira() {
		return variacaoCarteira;
	}

	public void setVariacaoCarteira(Integer variacaoCarteira) {
		this.variacaoCarteira = variacaoCarteira;
	}

	@Override
	public String toString() {
		return "Carteira [nome=" + nome + ", codigo=" + codigo + ", tipoDeCobranca=" + tipoDeCobranca
				+ ", tipoDeEmissaoBoleto=" + tipoDeEmissaoBoleto + ", tipoDeDistribuicaoBoleto="
				+ tipoDeDistribuicaoBoleto + ", codigoConvenio=" + codigoConvenio + ", variacaoCarteira="
				+ variacaoCarteira + "]";
	}	

}
