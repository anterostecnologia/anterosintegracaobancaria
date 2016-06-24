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


/**
 * 
 * <p>
 * Define o contrato para classes Agencia. Esse contrato é baseado na especificação FEBRABAN:
 * </p>
 * <p>
 * Invariantes:
 * <ul>
 * <li>Código: deve ser um inteiro natural (incluindo zero) entre 1 e 5 dígitos</li>
 * <li>Dígito Verificador: alpha-numérico sendo um inteiro natural (incluindo zero)
 * ou caracter não vazio (' ') com um dígito.</li>
 * </ul>
 * </p>
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a> 
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * 
 * @version 0.2
 */
public interface Agencia<C, D>{

	/**
	 * @return Número da agência
	 */
	C getCodigo();
	
	/**
	 * @return Dígito verificador
	 */
	D getDigitoVerificador();
}
