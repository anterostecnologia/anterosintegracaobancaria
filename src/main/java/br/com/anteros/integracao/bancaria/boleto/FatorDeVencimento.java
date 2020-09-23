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
package br.com.anteros.integracao.bancaria.boleto;

import static java.lang.String.format;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.joda.time.DateTimeUtils;

import br.com.anteros.core.utils.DateUtil;
import br.com.anteros.core.utils.ObjectUtils;


/**
 * <p>
 * Serviços utilitários do universo bancário, como por exemplo calcular o fator
 * de vencimento de boletos.</code>
 * </p>
 * 
 */
public class FatorDeVencimento{

	/**
	 * <p>
	 * Data base para o cálculo do fator de vencimento fixada em 07/10/1997 pela
	 * FEBRABAN.
	 * </p>
	 */
	private static final Calendar BASE_DO_FATOR_DE_VENCIMENTO = new GregorianCalendar(1997, Calendar.OCTOBER, 7);
	
	/**
	 * <p>
	 * Data base para o cálculo do fator de vencimento fixada em 07/10/1997 pela
	 * FEBRABAN.
	 * </p>
	 */
	private static final Date DATA_BASE_DO_FATOR_DE_VENCIMENTO = BASE_DO_FATOR_DE_VENCIMENTO.getTime();

	/**
	 *<p>
	 * Data máxima alcançada pelo fator de vencimento com base fixada em
	 * 07/10/1997.
	 * </p>
	 */
	private static final Date DATA_LIMITE_DO_FATOR_DE_VENCIMENTO = new GregorianCalendar(2025, Calendar.FEBRUARY, 21).getTime();

	/**
	 * <p>
	 * Calcula o fator de vencimento a partir da subtração entre a DATA DE
	 * VENCIMENTO de um título e a DATA BASE fixada em 07/10/1997.
	 * </p>
	 * 
	 * <p>
	 * O fator de vencimento nada mais é que um referencial numérico de 4
	 * dígitos que representa a quantidade de dias decorridos desde a data base
	 * (07/10/1997) até a data de vencimento do título. Ou seja, a diferença em
	 * dias entre duas datas.
	 * </p>
	 * 
	 * <p>
	 * Exemplos:
	 * </p>
	 * <ul type="circule"> <li>07/10/1997 (Fator = 0);</li> <li>03/07/2000
	 * (Fator = 1000);</li> <li>05/07/2000 (Fator = 1002);</li> <li>01/05/2002
	 * (Fator = 1667);</li> <li>21/02/2025 (Fator = 9999).</li> </ul>
	 * 
	 * <p>
	 * Funcionamento:
	 * </p>
	 * 
	 * <ul type="square"> <li>Caso a data de vencimento seja anterior a data
	 * base (Teoricamente fator negativo), uma exceção do tipo
	 * IllegalArgumentException será lançada.</li> <li>A data limite para o
	 * cálculo do fator de vencimento é 21/02/2025 (Fator de vencimento = 9999).
	 * Caso a data de vencimento seja posterior a data limite, uma exceção do
	 * tipo IllegalArgumentException será lançada.</li> </ul>
	 * 
	 * <p>
	 * <strong>ATENÇÃO</strong>, esse cálculo se refere a títulos em cobrança,
	 * ou melhor: BOLETOS. Desta forma, lembramos que a DATA BASE é uma norma da
	 * FEBRABAN. Essa norma diz que todos os boletos emitidos a partir de 1º de
	 * setembro de 2000 (primeiro dia útil = 03/07/2000 - SEGUNDA) devem seguir
	 * esta regra de cálculo para compor a informação de vencimento no código de
	 * barras. Portanto, boletos no padrão FEBRABAN quando capturados por
	 * sistemas da rede bancária permitem que se possa realizar a operação
	 * inversa, ou seja, adicionar à data base o fator de vencimento capturado.
	 * Obtendo então a data de vencimento deste boleto.
	 * </p>
	 * @param data
	 *            data de vencimento de um título
	 * @return fator de vencimento calculado
	 * @throws IllegalArgumentException
	 * 
	 * @since 0.2
	 */
	public static int toFator(Date data) throws IllegalArgumentException {

		if (ObjectUtils.isNull(data)) {			
			throw new IllegalArgumentException("Impossível realizar o cálculo do fator de vencimento de uma data nula!");			
		} else {
			
			Date dataTruncada = DateUtil.truncate(data, Calendar.DATE);			
			checkIntervalo(dataTruncada);				
			return (int) DateUtil.getIntervalInDays(DATA_BASE_DO_FATOR_DE_VENCIMENTO, dataTruncada);
		}
	}
	
	/**
	 * <p>
	 * Transforma um fator de vencimento em um objeto data da forma inversa
	 * descrita em {@linkplain #toFator(Date)}.
	 * </p>
	 * 
	 * @param fator
	 *            - Número entre o intervalo (incluíndo) 0 e 9999
	 * @return Data do vencimento
	 * @throws IllegalArgumentException
	 *             Caso o {@code fator} < 0 ou {@code fator} > 9999
	 */
	public static Date toDate(int fator) throws IllegalArgumentException {
		
		checkIntervalo(fator);
		
		Calendar date = (Calendar) BASE_DO_FATOR_DE_VENCIMENTO.clone();
		
		date.add(Calendar.DAY_OF_YEAR, fator);
		
		return  DateUtil.truncate(date.getTime(), Calendar.DATE);
	}

	/**
	 * <p>
	 * Lança exceção caso a {@code dataVencimentoTruncada} esteja fora do
	 * intervalo entre a {@linkplain #DATA_BASE_DO_FATOR_DE_VENCIMENTO} e a
	 * {@linkplain #DATA_LIMITE_DO_FATOR_DE_VENCIMENTO}.
	 * </p>
	 * 
	 * @param dataVencimentoTruncada
	 *            data de vencimento truncada com {@code
	 *            DateUtils.truncate(date, Calendar.DATE)}
	 * @throws IllegalArgumentException
	 *             Caso a data esteja {@code dataVencimentoTruncada} esteja fora
	 *             do intervalo entre a
	 *             {@linkplain #DATA_BASE_DO_FATOR_DE_VENCIMENTO} e a
	 *             {@linkplain #DATA_LIMITE_DO_FATOR_DE_VENCIMENTO}
	 */
	private static void checkIntervalo(Date dataVencimentoTruncada) throws IllegalArgumentException {
		
		if(dataVencimentoTruncada.before(DATA_BASE_DO_FATOR_DE_VENCIMENTO)
				|| dataVencimentoTruncada.after(DATA_LIMITE_DO_FATOR_DE_VENCIMENTO)) {
			
			throw new IllegalArgumentException(
					format("Para o cálculo do fator de vencimento se faz necessário informar uma data entre %s e %s.",
					DateUtil.toStringDateDMA(DATA_BASE_DO_FATOR_DE_VENCIMENTO), DateUtil.toStringDateDMA(DATA_LIMITE_DO_FATOR_DE_VENCIMENTO)));
					
		}
	}
	
	/**
	 * <p>Lança exceção caso o {@code fator} estja fora do intervalo.</p> 
	 * 
	 * @param fatorDeVencimento - Número entre o intervalo (incluíndo) 0 e 9999
	 * @throws IllegalArgumentException Caso o {@code fator} < 0 ou {@code fator} > 9999
	 */
	private static void checkIntervalo(int fatorDeVencimento) throws IllegalArgumentException {

		if (fatorDeVencimento < 0 || fatorDeVencimento > 9999) {
			throw new IllegalArgumentException(
					"Impossível transformar em data um fator menor que zero! O fator de vencimento deve ser um número entre 0 e 9999.");
		}
	}
}
