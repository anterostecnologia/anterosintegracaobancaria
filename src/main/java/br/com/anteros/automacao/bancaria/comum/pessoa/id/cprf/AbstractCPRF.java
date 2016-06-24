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

import br.com.anteros.core.utils.StringUtils;
import br.com.anteros.integracao.bancaria.validador.AbstractCPRFValidator;
import br.com.anteros.integracao.bancaria.validador.AbstractCPRFValidator.TipoDeCPRF;

/**
 * 
 * <p>
 * Classe que representa um <a href="http://www.receita.fazenda.gov.br/Principal/Cadastros.htm">Cadastro de Pessoas na Receita Federal</a>, esse
 * cadastro pode ser o de pessoas físicas ou jurídicas.
 * </p>
 * 
 * <p>
 *  O cadastro tem a finalidade de identificadar cada pessoa no país, seja ela de natureza física
 * ou jurídica. O <a href="http://www.receita.fazenda.gov.br/Aplicacoes/ATCTA/CPF/default.htm">Cadastro de Pessoa Física é o CPF</a>, já o de <a href="http://www.receita.fazenda.gov.br/PessoaJuridica/cnpj/ConsulSitCadastralCnpj.htm">Pessoa Jurídica é o CNPJ</a>.
 * </p>
 * 
 * 
 * @author <a href="http://gilmatryx.googlepages.com">Gilmar P.S.L.</a>
 * @author <a href="mailto:misaelbarreto@gmail.com">Misael Barreto</a>
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
	
public abstract class AbstractCPRF implements CPRF{ 

	/**
	 * 
	 */
	private String codigoFormatado;

	/**
	 * 
	 */
	private Long codigo;

	/**
	 * 
	 */
	protected AbstractCPRFValidator autenticadorCP;

	/**
	 * Cria um {@linkplain CPRF} através de um long e seu
	 * {@linkplain TipoDeCPRF}.
	 * 
	 * @param cadastroDePessoa
	 * @param tipoDeCadastro
	 * @return AbstractCPRF (CPF ou CNPJ)
	 * @throws IllegalArgumentException
	 */
	@SuppressWarnings("unchecked")
	public static <C extends AbstractCPRF> C create(Long cadastroDePessoa, TipoDeCPRF tipoDeCadastro) throws IllegalArgumentException {

		return (C) create(String.valueOf(cadastroDePessoa),tipoDeCadastro);
	}

	/**
	 * Cria um {@linkplain CPRF} através de uma string não formatada e seu
	 * {@linkplain TipoDeCPRF}.
	 * 
	 * @param cadastroDePessoa
	 *            não formatado
	 * @param tipoDeCadastro
	 *            tipo
	 * @return AbstractCPRF (CPF ou CNPJ)
	 * @throws IllegalArgumentException
	 */
	@SuppressWarnings("unchecked")
	public static <C extends AbstractCPRF> C create(String cadastroDePessoa, TipoDeCPRF tipoDeCadastro) throws IllegalArgumentException {
		
		String codigo = null;
		
		if (AbstractCPRFValidator.isParametrosValidos(cadastroDePessoa, tipoDeCadastro)) {

			switch_Cadastro: {

				if (tipoDeCadastro == TipoDeCPRF.CPF) {

					codigo = StringUtils.padZero(cadastroDePessoa, 11);
					break switch_Cadastro;

				}

				if (tipoDeCadastro == TipoDeCPRF.CNPJ) {

					codigo = StringUtils.padZero(cadastroDePessoa, 14);
					break switch_Cadastro;

				}
			}
		}
		
		return (C) create(codigo);
	}
	
	/**
	 * Cria um {@linkplain CPRF} através de uma string formatada ou não.
	 * 
	 * @param cadastroDePessoa
	 *            - identificador do cadastro de pessoa formatado ou não.
	 * @return uma instância de AbstractCPRF.
	 * @throws IllegalArgumentException
	 *             - caso o parâmetro não esteja em um formatador válido de
	 *             cadastro de pessoa.
	 */
	@SuppressWarnings("unchecked")
	public static <C extends AbstractCPRF> C create(String cadastroDePessoa)
			throws IllegalArgumentException {

		AbstractCPRF cp = null;
		AbstractCPRFValidator autenticadorCP = AbstractCPRFValidator.create(cadastroDePessoa);

		if (autenticadorCP.isValido()) {

			if (autenticadorCP.isFisica()) {

				cp = new CPF(autenticadorCP
						.getCodigoDoCadastro());

			} else if (autenticadorCP.isJuridica()) {

				cp = new CNPJ(autenticadorCP
						.getCodigoDoCadastro());
			}

			cp.autenticadorCP = autenticadorCP;

		} else {

			throw new IllegalArgumentException(
					"O cadastro de pessoa [ \""+cadastroDePessoa+"\" ] não é válido.");
		}

		return (C) cp;
	}
	
	/**
	 * @return boolean
	 */
	public boolean isFisica(){
		return autenticadorCP.isFisica();
	}
	
	/**
	 * @return boolean
	 */
	public boolean isJuridica(){
		return autenticadorCP.isJuridica();
	}
	
	protected void setCodigoFormatado(String codigoFormatado) {

		this.codigoFormatado = codigoFormatado;
	}

	protected void setCodigo(Long codigo) {

		this.codigo = codigo;
	}
	public Long getCodigo() {
		return codigo;
	}

	public String getCodigoComZeros() {
		
		if(isFisica()){
			return StringUtils.padZero(String.valueOf(getCodigo()), 11);
		}else{			
			return StringUtils.padZero(String.valueOf(getCodigo()), 14);
		}
	}

	public String getCodigoFormatado() {
		
		return codigoFormatado;
	}
	
	public Long getRaiz(){
		
		if(isFisica()){
			return Long.valueOf(codigoFormatado.split("-")[0].replaceAll("\\.", StringUtils.EMPTY));
		}else{
			return Long.valueOf(codigoFormatado.split("/")[0].replaceAll("\\.", StringUtils.EMPTY));
		}
	}
	
	public String getRaizComZeros(){		
		if(isFisica()){
			return StringUtils.padZero(String.valueOf(getRaiz()), 9);
		}else{			
			return StringUtils.padZero(String.valueOf(getRaiz()), 8);
		}
	}
	
	public String getRaizFormatada(){
		
		if(isFisica()){
			return codigoFormatado.split("-")[0];
		}else{
			return codigoFormatado.split("/")[0];
		}
	}

	public Integer getDv(){		
		return Integer.valueOf(codigoFormatado.split("-")[1]);
	}

	public String getDvComZeros(){
		
		return codigoFormatado.split("-")[1];
	}
	
	/**
	 * Realizado através da ordem natural do {@linkplain #getCodigo()}.
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object other) {

		if(other != null){
			if(other instanceof AbstractCPRF){
				AbstractCPRF cprf = (AbstractCPRF) other;
				if(this.autenticadorCP.getTipoDeCadastro().equals(cprf.autenticadorCP.getTipoDeCadastro())){				
					return this.codigo.compareTo(cprf.codigo);
				}else{
					return this.autenticadorCP.getTipoDeCadastro().compareTo(cprf.autenticadorCP.getTipoDeCadastro());
				}
			}else{
				return -1;
			}
		}else{
			return 1;
		}
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((codigoFormatado == null) ? 0 : codigoFormatado.hashCode());
		return result;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof AbstractCPRF)) {
			return false;
		}
		AbstractCPRF other = (AbstractCPRF) obj;
		if (codigo == null) {
			if (other.codigo != null) {
				return false;
			}
		} else if (!codigo.equals(other.codigo)) {
			return false;
		}
		if (codigoFormatado == null) {
			if (other.codigoFormatado != null) {
				return false;
			}
		} else if (!codigoFormatado.equals(other.codigoFormatado)) {
			return false;
		}
		return true;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return getCodigoFormatado();
	}
	
}
