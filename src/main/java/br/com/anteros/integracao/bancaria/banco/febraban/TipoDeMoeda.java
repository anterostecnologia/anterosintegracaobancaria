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

import br.com.anteros.core.utils.StringUtils;

/**
 * <p>
 * Representa as moedas existentes que fazem parte do universo de um título,
 * segundo a FEBRABAN.
 * </p>
 * 
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * @author <a href="mailto:misaelbarreto@gmail.com">Misael Barreto</a>
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * @author <a href="http://www.nordestefomento.com.br">Nordeste Fomento
 *         Mercantil</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public enum TipoDeMoeda {

	/**
	 * Padrão FEBRABAN
	 */

	DOLAR_AMERICANO_COMERCIAL_VENDA(2), DOLAR_AMERICANO_TURISMO_VENDA(3), ITRD(4), IDTR(5), UFIR_DIARIA(6), UFIR_MENSAL(7), FAJ_TR(8), REAL(9), TR(10), IGPM(11), CDI(12), PERCENTUAL_DO_CDI(13), EURO(14);

	private int codigo;

	/**
	 * @param codigo
	 */
	private TipoDeMoeda(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {

		return this.codigo;
	}

	public String write() {

		String s = StringUtils.EMPTY;

		switch (this) {

		case REAL:
			s = "R$";
			break;

		default:
			s += this.getCodigo();
		}

		return s;
	}

	public static TipoDeMoeda convert(Integer tipoMoeda) {
		switch (tipoMoeda) {
		case 2:
			return TipoDeMoeda.DOLAR_AMERICANO_COMERCIAL_VENDA;
		case 3:
			return TipoDeMoeda.DOLAR_AMERICANO_TURISMO_VENDA;
		case 4:
			return TipoDeMoeda.ITRD;
		case 5:
			return TipoDeMoeda.IDTR;
		case 6:
			return TipoDeMoeda.UFIR_DIARIA;
		case 7:
			return TipoDeMoeda.UFIR_MENSAL;
		case 8:
			return TipoDeMoeda.FAJ_TR;
		case 9:
			return TipoDeMoeda.REAL;
		case 10:
			return TipoDeMoeda.TR;
		case 11:
			return TipoDeMoeda.IGPM;
		case 12:
			return TipoDeMoeda.CDI;
		case 13:
			return TipoDeMoeda.PERCENTUAL_DO_CDI;
		case 14:
			return TipoDeMoeda.EURO;
		default:
			break;
		}
		return TipoDeMoeda.REAL;
	}
}
