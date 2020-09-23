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


import br.com.anteros.automacao.bancaria.parametro.ParametroBancoSantander;
import br.com.anteros.core.utils.ObjectUtils;
import br.com.anteros.flatfile.type.component.Fillers;
import br.com.anteros.flatfile.type.component.FixedField;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.Titulo;

/**
 * <p>
 * O campo livre do Banco Santander deve seguir esta forma:
 * </p>
 * 
 * <table border="1" cellpadding="0" cellspacing="0" style="border-collapse: * collapse" bordercolor="#111111" width="60%" id="campolivre">
 * <tr>
 * <thead>
 * <th >Posição</th>
 * <th >Tamanho</th>
 * <th >Picture</th>
 * <th>Conteúdo</th>
 * </thead>
 * </tr>
 * <tr>
 * <td >20-20</td>
 * <td >1</td>
 * <td >9(01)</td>
 * <td >Fixo "9"</td>
 * </tr>
 * <tr>
 * <td >21-27</td>
 * <td >7</td>
 * <td >9(7)</td>
 * <td >Conta do cedente padrão Santander</td>
 * </tr>
 * <tr>
 * <td >28-40</td>
 * <td >13</td>
 * <td >9(13)</td>
 * <td >
 * <p>
 * Nosso Número com zeros a esquerda. <strong>OBS:</strong> Caso o arquivo de
 * registro para os títulos seja de 400 bytes (CNAB)
 * </p>
 * <ul>
 * <li>Banco 353 (Banco Santander) - Utilizar somente 08 posições do Nosso Numero (07 posições +
 * DV), zerando os 05 primeiros dígitos</li>
 * <li>Banco 008 (Meridional do Brasil S/A) - Utilizar somente 09 posições do Nosso Numero (08 posições +
 * DV), zerando os 04 primeiros dígitos</li>
 * </ul>
 * </td>
 * </tr>
 * <tr>
 * <td >41-41</td>
 * <td >1</td>
 * <td >9(1)</td>
 * <td >
 * <p>
 * IOF – Seguradoras (Se 7% informar 7. Limitado a 9%)
 * </p>
 * <p>
 * <strong>Demais clientes usar 0 (zero)</strong>
 * </p>
 * </td>
 * </tr>
 * <tr>
 * <td >42-44</td>
 * <td >3</td>
 * <td >9(3)</td>
 * <td >
 *    <ul>
 *       <li>101-Cobrança Simples Rápida COM Registro</li>
 *       <li>102- Cobrança simples – SEM Registro</li>
 *       <li>201- Penhor Rápida com Registro</li>
 *    </ul>
 * </td>
 * </tr>
 * </table>
 * 
 */
class CLBancoSantander extends AbstractCLSantander implements CampoLivre {

	/**
	 * 
	 */
	private static final long serialVersionUID = -412221524249334574L;

	/**
	 * 
	 */
	private static final Integer FIELDS_LENGTH = 6;

	/**
	 * Constante informada no manual.
	 */
	private static final Integer CONSTANTE = Integer.valueOf(9);

	/**
	 * 101- Cobrança Simples Rápida COM Registro
	 */
	private static final int CARTEIRA_RAPIDA_COM_REGISTRO = 101;

	/**
	 * 201- Penhor Rápida com Registro
	 */
	private static final int CARTEIRA_RAPIDA_SEM_REGISTRO = 201;

	/**
	 * 102- Cobrança simples – SEM Registro
	 */
	private static final int CARTEIRA_SIMPLES_SEM_REGISTRO = 102;

	CLBancoSantander(Titulo titulo) {
		super(FIELDS_LENGTH);

		ContaBancaria conta = titulo.getContaBancaria();
		StringBuilder nossoNumero = new StringBuilder(titulo.getNossoNumero());
		nossoNumero.append(titulo.getDigitoNossoNumero());

		this.add(new FixedField<Integer>(CONSTANTE, 1));
		this.add(new FixedField<Long>(conta.getNumeroDaConta().getCodigoDaConta(), 6, Fillers.ZERO_LEFT));
		this.add(new FixedField<String>(conta.getNumeroDaConta().getDigitoDaConta(), 1));
		
		this.add(new FixedField<String>(nossoNumero.toString(), 13, Fillers.ZERO_LEFT));

		// IOF – Seguradoras

		if (titulo.hasParametrosBancarios()
				&& ObjectUtils.isNotNull(titulo.getParametrosBancarios().getValor(
						ParametroBancoSantander.IOF_SEGURADORA))) {

			this.add(new FixedField<Integer>(titulo
					.getParametrosBancarios().<Integer>getValor(ParametroBancoSantander.IOF_SEGURADORA), 1));

		} else {

			this.add(new FixedField<Integer>(0, 1));
		}

		// Tipo de Modalidade Carteira

		switch (titulo.getCarteira().getCodigo()) {

		case CARTEIRA_RAPIDA_COM_REGISTRO:
		case CARTEIRA_RAPIDA_SEM_REGISTRO:
		case CARTEIRA_SIMPLES_SEM_REGISTRO:

			this.add(new FixedField<Integer>(titulo.getCarteira().getCodigo(), 3,
					Fillers.ZERO_LEFT));

			break;

		default:
			
			throw new IllegalArgumentException(String.format(
					"CARTEIRA [%s] NÃO SUPORTADA!", titulo.getCarteira()
							.getCodigo()));
		}
	}
	
	@Override
	protected void addFields(Titulo titulo) {
		// TODO IMPLEMENTAR
		throw new UnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
	}

	@Override
	protected void checkValues(Titulo titulo) {
		// TODO IMPLEMENTAR
		throw new UnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
	}
}
