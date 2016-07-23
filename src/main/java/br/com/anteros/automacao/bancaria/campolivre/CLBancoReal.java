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


import br.com.anteros.core.utils.StringUtils;
import br.com.anteros.flatfile.type.component.Fillers;
import br.com.anteros.flatfile.type.component.FixedField;
import br.com.anteros.integracao.bancaria.banco.layout.Titulo;
import br.com.anteros.integracao.bancaria.validador.digitoverificador.Modulo;
import br.com.anteros.integracao.bancaria.validador.digitoverificador.TipoDeModulo;

/**
 * <p><strong>*** COBRANÇA SEM REGISTRO ***</strong></p>
 * O campo livre do Banco Real deve seguir esta forma:
 * 
 * <table border="1" cellpadding="0" cellspacing="0" style="border-collapse:
 * collapse" bordercolor="#111111" id="campolivre">
 * <tr> <thead>
 * <th >Posição </th>
 * <th >Tamanho</th>
 * <th >Picture</th>
 * <th>Conteúdo (terminologia padrão)</th>
 * <th>Conteúdo (terminologia do banco)</th>
 * </thead> </tr>
 * <tr>
 * <td>20-23</td>
 * <td>4</td>
 * <td>9(4)</td>
 * <td>Código da agência (sem dígito)</td>
 * <td>Agência - Código da agência do cedente</td>
 * </tr>
 * <tr>
 * <td>24-30</td>
 * <td>7</td>
 * <td>9(7) </td>
 * <td>Código da conta (sem dígito)</td>
 * <td>Conta - Número da conta do cedente</td>
 * </tr>
 * <tr>
 * <td>31-31</td>
 * <td>1</td>
 * <td>9(1) </td>
 * <td>Dígito verificador</td>
 * <td>Digitão - Dígito de cobrança</td>
 * </tr>
 * <tr>
 * <td>32-44</td>
 * <td>13</td>
 * <td>9(13) </td>
 * <td>Número do título(máximo de 13 posições numéricas)</td>
 * <td>Número do banco - Número do título no banco</td>
 * </tr>
 * </table>
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 * @author <a href="mailto:misaelbarreto@gmail.com">Misael Barreto</a>
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
	
class CLBancoReal extends AbstractCLBancoReal {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5294809022535972391L;
	
	private static final Modulo modulo10 = new Modulo(TipoDeModulo.MODULO10);
	
	/**
	 * Tamanho deste campo.
	 */
	private static final Integer FIELDS_LENGTH = 4;
	
	/**
	 * <p>
	 *   Dado um título, cria um campo livre para o padrão do Banco Real.
	 * </p>
	 * @param titulo título com as informações para geração do campo livre
	 */
	CLBancoReal(Titulo titulo) {
		
		super(FIELDS_LENGTH);
		
		this.add(new FixedField<Integer>(titulo.getContaBancaria().getAgencia().getCodigo(), 4, Fillers.ZERO_LEFT));
		this.add(new FixedField<Long>(titulo.getContaBancaria().getNumeroDaConta().getCodigoDaConta(), 7, Fillers.ZERO_LEFT));
		this.add(new FixedField<String>(calculeDigitoDaPosicao31(titulo.getNossoNumero(), titulo.getContaBancaria().getAgencia().getCodigo(), titulo.getContaBancaria().getNumeroDaConta().getCodigoDaConta()), 1, Fillers.ZERO_LEFT));
		this.add(new FixedField<String>(StringUtils.eliminateSymbols(titulo.getNossoNumero()), 13, Fillers.ZERO_LEFT));
	}
	
	/**
	 * <p>
	 * Calcula o Dígito da posição <tt>31</tt> deste campo livre (<code>CLBancoReal</code>).
	 * </p>
	 * 
	 * <p>
	 * No cálculo do dígito da posição 31 são considerados, para a obtenção do
	 * dígito, os dados <em><tt>{[NOSSO NÚMERO],[AGÊNCIA],[CONTA]}</tt></em> calculado pelos
	 * critérios do Módulo 10.
	 * </p>
	 * <h5>Exemplo:</h5>
	 * 
	 * <div align="center"> <table border="1" cellpadding="3" cellspacing="0">
	 * <tr>
	 * <td>Nosso Número</td>
	 * <td>1234567890123</td>
	 * </tr>
	 * <tr>
	 * <td>Agência</td>
	 * <td>4444</td>
	 * </tr>
	 * <tr>
	 * <td>Conta Corrente</td>
	 * <td>7777777</td>
	 * </tr>
	 * </table></div>
	 * 
	 * @param nossoNumero
	 * @param agencia
	 * @param contaCorrente
	 * @return Dígito verficador calculado
	 * 
	 * @see org.jrimum.vallia.digitoverificador.Modulo
	 * 
	 * @since 0.2
	 */	
	private String calculeDigitoDaPosicao31(String nossoNumero,
			Integer agencia, Long contaCorrente) {

		StringBuilder formula = new StringBuilder();
		String dV = null;

		formula.append(Fillers.ZERO_LEFT.fill(nossoNumero, 13));
		formula.append(Fillers.ZERO_LEFT.fill(agencia, 4));
		formula.append(Fillers.ZERO_LEFT.fill(contaCorrente, 7));

		int restoDivisao = modulo10.calcule(formula.toString());

		int restoSubtracao = (10 - restoDivisao);

		if (restoSubtracao == 10) {
			dV = "0";
		} else {

			dV = "" + restoSubtracao;
		}

		return dV;
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
