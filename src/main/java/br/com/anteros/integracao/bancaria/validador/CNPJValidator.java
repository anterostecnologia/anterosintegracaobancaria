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

/**
 * Validador especialista para CNPJ.
 * 
 * <p>
 * O cadastro de pessoa jurídica tem as seguintes características:
 * <ul>
 * <li>Contém apenas números.</li>
 * <li>Possui tamanho 14 sem formatação e 18 com formatação.</li>
 * <li>Pode estar no formato ##.###.###/####-XX, onde XX é o dígito verificador.
 * </li>
 * </ul>
 * </p>
 * <p>
 * A validação consiste em verificar essas características e se o dígito
 * verificador é válido.
 * </p>
 * 
 */
class CNPJValidator extends AbstractCPRFValidator {


	@Override
	public boolean isValido() {

		boolean isValido = false;
		int dv = 0;
		int dvCalculado = -1;

		dv = Integer.parseInt(getCodigoDoCadastro().substring(12, 14));

		dvCalculado = digitoVerificador.calcule(getCodigoDoCadastro()
				.substring(0, 12));

		isValido = (dv == dvCalculado);

		return isValido;
	}


	@Override
	protected void removeFormatacao() {

		String codigo = codigoDoCadastro.toString();

		codigo = codigo.replace(".", "");
		codigo = codigo.replace("/", "");
		codigo = codigo.replace("-", "");

		codigoDoCadastro.delete(0, codigoDoCadastro.length());

		codigoDoCadastro.append(codigo);
	}

}
