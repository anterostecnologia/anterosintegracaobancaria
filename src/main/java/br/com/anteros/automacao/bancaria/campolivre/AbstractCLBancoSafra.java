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
package br.com.anteros.automacao.bancaria.campolivre;

import static java.lang.String.format;

import br.com.anteros.flatfile.type.component.FixedField;
import br.com.anteros.integracao.bancaria.banco.layout.Titulo;

/**
 * <p>
 * Interface comum para todos os campos livres do Banco Safra que venham a
 * existir.
 * </p>
 * 
 */
abstract class AbstractCLBancoSafra extends AbstractCampoLivre {

	/**
	 * {@code serialVersionUID = -555393808447532987L}
	 */
	private static final long serialVersionUID = -555393808447532987L;

	/**
	 * Códigos do "Tipo de Cobrança" utilizados nos boletos do Banco Safra.
	 * 
	 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
	 */
	protected enum TipoDeCobranca {

		/**
		 * 1 = Bloqueto Emitido pelo Banco.
		 */
		BOLETO_EMITIDO_PELO_BANCO,
		/**
		 * 2 = Eletrônica Emitido pelo Cliente.
		 */
		DIRETA_BOLETO_EMITIDO_PELO_CLIENTE,
		/**
		 * 4 = Express Emitido pelo Cliente.
		 */
		EXPRESS_BOLETO_EMITIDO_PELO_CLIENTE;

		public int codigo() {
			switch (this) {
			case BOLETO_EMITIDO_PELO_BANCO:
				return 1;
			case DIRETA_BOLETO_EMITIDO_PELO_CLIENTE:
				return 2;
			case EXPRESS_BOLETO_EMITIDO_PELO_CLIENTE:
				return 4;
			default:
				throw new IllegalStateException(format(
						"Tipo \"%s\" sem código atribuído!", this));
			}
		}
	}

	/**
	 * Tamanho do campo Constante = 1, chamado de "SISTEMA", definido pelo Banco
	 * Safra nos dois campos livres: {@link CLBancoSafraCobrancaNaoRegistrada} e
	 * {@link CLBancoSafraCobrancaRegistrada}.
	 */
	private static final Integer CONSTANT_LENGTH_SISTEMA = Integer.valueOf(1);
	
	/**
	 * Valor do campo Constante = 7, chamado de "SISTEMA", definido pelo Banco
	 * Safra nos dois campos livres: {@link CLBancoSafraCobrancaNaoRegistrada} e
	 * {@link CLBancoSafraCobrancaRegistrada}.
	 */
	private static final Integer CONSTANT_VALUE_SISTEMA = Integer.valueOf(7);
	
	/**
	 * Constante em forma de campo {@link AbstractCLBancoSafra#CONSTANT_VALUE_SISTEMA} e {@link AbstractCLBancoSafra#CONSTANT_LENGTH_SISTEMA}.
	 */
	protected static final FixedField<Integer> SISTEMA_CONSTANT_FIELD = new FixedField<Integer>(CONSTANT_VALUE_SISTEMA, CONSTANT_LENGTH_SISTEMA);
	
	/**
	 * Tamanho do campo = 1, chamado de "TIPO DE COBRANÇA", definido pelo Banco
	 * Safra nos dois campos livres: {@link CLBancoSafraCobrancaNaoRegistrada} e
	 * {@link CLBancoSafraCobrancaRegistrada}.
	 */
	protected static final Integer TIPO_COBRANCA_FIELD_LENGTH = Integer.valueOf(1);

	/**
	 * <p>
	 * Cria um campo livre com um determinado número de campos
	 * </p>
	 * 
	 * @see AbstractCampoLivre
	 * 
	 * @param fieldsLength
	 *            - Número de campos
	 */
	protected AbstractCLBancoSafra(Integer fieldsLength) {

		super(fieldsLength);
	}

	protected static CampoLivre create(Titulo titulo)
			throws NotSupportedCampoLivreException {

		checkCarteiraNotNull(titulo);
		checkRegistroDaCarteiraNotNull(titulo);

		switch (titulo.getCarteira().getTipoDeCobranca()) {
		case COM_REGISTRO:
			return new CLBancoSafraCobrancaRegistrada().build(titulo);
		case SEM_REGISTRO:
			return new CLBancoSafraCobrancaNaoRegistrada().build(titulo);
		default:
			throw new NotSupportedCampoLivreException(
					"Campo livre diponível somente para títulos com carteiras com tipo de cobrança "
							+ "COM_REGISTRO ou SEM_REGISTRO.");
		}
	}
}
