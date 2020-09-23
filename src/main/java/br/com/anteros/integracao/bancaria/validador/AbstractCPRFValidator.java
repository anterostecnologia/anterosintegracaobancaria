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
package br.com.anteros.integracao.bancaria.validador;

import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Pattern;

import br.com.anteros.core.utils.ObjectUtils;
import br.com.anteros.core.utils.StringUtils;
import br.com.anteros.integracao.bancaria.validador.digitoverificador.AbstractDigitoVerificador;
import br.com.anteros.integracao.bancaria.validador.digitoverificador.CNPJDV;
import br.com.anteros.integracao.bancaria.validador.digitoverificador.CPFDV;

/**
 * Representa a família de validadores para o cadastro de pessoa na receita
 * federal (CPRF).
 * 
 * 
 */
public abstract class AbstractCPRFValidator {

	/**
	 * Cadastro de pessoa para validação.
	 */
	protected StringBuilder codigoDoCadastro;

	/**
	 * Validador de dígito verificador do cadastro de Pessoa.
	 */
	protected AbstractDigitoVerificador digitoVerificador;

	/**
	 * Expressão regular para validação de CPF: "###.###.###-##" ou
	 * "###########".
	 */
	private static final String REGEX_CPF = "(\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2})|(\\d{11})";

	/**
	 * Expressão regular para validação de CNPJ: "##.###.###/####-##" ou
	 * "##############".
	 */
	private static final String REGEX_CNPJ = "(\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2})|(\\d{14})";

	/**
	 * Expressão regular para validação de um cadastro: "###" ou
	 * "##############".
	 */
	private static final String REGEX_CADASTRO = "\\d{3,14}";

	/**
	 * Representa o tipo de cadastro e fornece o autenticador correto de a cordo
	 * com este tipo.
	 * 
	 */
	public enum TipoDeCPRF implements Serializable {

		CPF, CNPJ;

		public AbstractCPRFValidator getAutenticador() {

			AbstractCPRFValidator validador = null;

			switch (this) {

				case CPF:
	
					validador = new CPFValidator();
					validador.digitoVerificador = new CPFDV();
	
					break;
	
				case CNPJ:
	
					validador = new CNPJValidator();
					validador.digitoVerificador = new CNPJDV();
	
					break;
			}

			return validador;
		}

		/**
		 * @see org.jrimum.utilix.Objects#toString()
		 * @see java.lang.Enum#toString()
		 */
		public String toString() {
			return Objects.toString(this);
		}
	}

	/**
	 * @see org.jrimum.vallia.AbstractCPRFValidator.TipoDeCPRF
	 */
	private TipoDeCPRF tipoDeCadastro;

	/**
	 * Valida o dígito verificador do cadastro de pessoa passado durante a
	 * instanciação do validador.
	 * 
	 * @return verdadeiro se o dígito verificador for válido.
	 */
	public abstract boolean isValido();

	/**
	 * Revome a formatação existente em <code>códigoDoCadastro</code>.
	 */
	protected abstract void removeFormatacao();

	/**
	 * Recupera uma instância de um validador para o cadastro de pessoa a partir
	 * de um identificador.
	 * <p>
	 * Primeiro é feita uma pré-validação que consiste em:
	 * <ul>
	 * <li>Verificar se o parâmetro não é nulo.</li>
	 * <li>Verificar se o parâmetro não é vazio.</li>
	 * <li>Verificar se o parâmetro está em algum formatador válido para
	 * cadastro de pessoa.</li>
	 * </ul>
	 * </p>
	 * 
	 */
	public static final AbstractCPRFValidator create(String codigoDoCadastro)
			throws IllegalArgumentException {

		AbstractCPRFValidator validatorCPRF = null;

		validatorCPRF = create(selectTipoDeCadastro(codigoDoCadastro));

		validatorCPRF.codigoDoCadastro = new StringBuilder(codigoDoCadastro);
		validatorCPRF.removeFormatacao();

		return validatorCPRF;
	}

	/**
	 * Cria um validador a partir do tipo de CPRF.
	 * 
	 * @param tipoDeCadastro
	 * @return um validador
	 * 
	 */
	public static final AbstractCPRFValidator create(TipoDeCPRF tipoDeCadastro) {

		AbstractCPRFValidator validatorCPRF = null;

		if (ObjectUtils.isNotNull(tipoDeCadastro)) {

			validatorCPRF = tipoDeCadastro.getAutenticador();

			validatorCPRF.tipoDeCadastro = tipoDeCadastro;

		} else {
			throw new IllegalArgumentException("Tipo de Cadastro [ \""
					+ tipoDeCadastro + "\" ] nulo !");
		}

		return validatorCPRF;
	}

	/**
	 * Faz a pré-validação e se correto identifica o tipo de cadastro.
	 * 
	 * @param codigoDoCadastro
	 * @return Tipo de CPRF
	 * @throws IllegalArgumentException
	 * 
	 */
	private static TipoDeCPRF selectTipoDeCadastro(String codigoDoCadastro)
			throws IllegalArgumentException {

		TipoDeCPRF tipo = null;

		switch_Tipo: {

			if (StringUtils.isNotBlank(codigoDoCadastro)) {

				/*
				 * FILTRO
				 */

				if (Pattern.matches(REGEX_CPF, codigoDoCadastro)) {

					tipo = TipoDeCPRF.CPF;

					break switch_Tipo;
				}

				if (Pattern.matches(REGEX_CNPJ, codigoDoCadastro)) {

					tipo = TipoDeCPRF.CNPJ;

					break switch_Tipo;
				}

			}

			throw new IllegalArgumentException("O código de cadastro [ \""
					+ codigoDoCadastro
					+ "\" ] não está em um formato válido !");
		}

		return tipo;
	}

	/**
	 * Define se os parâmetros válidos em relação a nulidade e formato de CPRF.
	 * 
	 * @param codigoDoCadastro
	 * @param tipoDeCadastro
	 * @return indicação de aprovação
	 * @throws IllegalArgumentException
	 * 
	 */
	public static final boolean isParametrosValidos(String codigoDoCadastro,
			TipoDeCPRF tipoDeCadastro) throws IllegalArgumentException {

		boolean isValido = false;

		if (ObjectUtils.isNotNull(codigoDoCadastro) && ObjectUtils.isNotNull(tipoDeCadastro)) {

			if (Pattern.matches(REGEX_CADASTRO, codigoDoCadastro)) {

				isValido = true;

			} else {

				throw new IllegalArgumentException(
						"O cadastro está em um tamanho incorreto ou não exsite: [ \""
								+ codigoDoCadastro + "\" ]");
			}
		} else {

			throw new IllegalArgumentException(
					"O tipo de cadastro está incorreto: [ \"" + tipoDeCadastro
							+ "\" ] ou o cadastro não exsite: [ \""
							+ codigoDoCadastro + "\" ]");
		}

		return isValido;
	}

	/**
	 * Recupera o cadastro de pessoa a ser validado. <br />
	 * Obs.: A String retornada não possui formatação, ou seja, possui apenas os
	 * dígitos.
	 * 
	 * @return cadastro de pessoa a ser validado.
	 * 
	 */
	public final String getCodigoDoCadastro() {

		return codigoDoCadastro.toString();
	}

	/**
	 * Indica se o validador é de pessoa física.
	 * 
	 * @return verdadeiro se for de pessoa física.
	 */
	public final boolean isFisica() {

		return this instanceof CPFValidator;
	}

	/**
	 * Indica se o validador é de pessoa jurídica.
	 * 
	 * @return verdadeiro se for de pessoa jurídica.
	 */
	public final boolean isJuridica() {

		return this instanceof CNPJValidator;
	}
	
	/**
	 * @return the tipoDeCadastro
	 */
	public final TipoDeCPRF getTipoDeCadastro() {
		return tipoDeCadastro;
	}
}
