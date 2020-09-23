
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
 * Representação dos tipos básicos de cobrança:<br />
 * <ul>
 * <li>Registrada (ou com registro)</li>
 * <li>Não Registrada (ou sem registro)</li>
 * </ul>
 * </p>
 * 
 * 
 */

public enum TipoDeCobranca {
	/**
	 * <p>
	 * Tipo onde os títulos emitidos são sempre registrados no banco antes de seu
	 * vencimento ou pagamento.
	 * </p>
	 */
	COM_REGISTRO(1),
	/**
	 * <p>
	 * Tipo onde os títulos emitidos só são registrados pelo banco quando são pagos.
	 * </p>
	 */
	SEM_REGISTRO(2);

	private int tipo;

	private TipoDeCobranca(int tipo) {
		this.tipo = tipo;
	}

	public int getTipo() {
		return tipo;
	}

	public static String getTipoModalidade(TipoDeCobranca tipo) {
		if (tipo.equals(TipoDeCobranca.COM_REGISTRO))
			return "01";
		else if (tipo.equals(TipoDeCobranca.SEM_REGISTRO))
			return "02";

		return "";
	}
}
