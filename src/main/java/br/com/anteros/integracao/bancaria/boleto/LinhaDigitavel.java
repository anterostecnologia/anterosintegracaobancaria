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

import br.com.anteros.core.log.Logger;
import br.com.anteros.core.log.LoggerProvider;
import br.com.anteros.core.utils.StringUtils;
import br.com.anteros.flatfile.type.component.BlockOfFields;
import br.com.anteros.flatfile.type.component.FixedField;
import br.com.anteros.integracao.bancaria.validador.digitoverificador.BoletoLinhaDigitavelDV;

/**
 * 
 * Representa a linha digitável do boleto, embora a linha digitável contenha a
 * mesma informação do código de barras, essa informação é disposta de uma forma
 * diferente e são acrescentados 3 dígitos verificadores. <br />
 * <br />
 * Modelo: <br />
 * <br />
 * 
 * <table border="1" cellpadding="0" cellspacing="0" style="border-collapse:
 * collapse" bordercolor="#111111" width="90%" id="linhaDigitável"> <thead>
 * <tr>
 * <th>Posição </th>
 * <th>Tamanho</th>
 * <th>Conteúdo</th>
 * </tr>
 * </thead>
 * <tr>
 * <td>01-03 </td>
 * <td>3 </td>
 * <td>Identificação do banco </td>
 * </tr>
 * <tr>
 * <td>04-04</td>
 * <td>1 </td>
 * <td>Código de moeda (9 – Real) </td>
 * </tr>
 * <tr>
 * <td>05-09 </td>
 * <td>5 </td>
 * <td>Cinco primeiras posições do campo livre (posições 20 a 24 do código de
 * barras)</td>
 * </tr>
 * <tr>
 * <td>10-10 </td>
 * <td>1 </td>
 * <td>Dígito verificador do primeiro campo </td>
 * </tr>
 * <tr>
 * <td>11-20 </td>
 * <td>10 </td>
 * <td>6ª a 15ª posições do campo livre (posições 25 a 34 do código de barras)
 * </td>
 * </tr>
 * <tr>
 * <td>21-21 </td>
 * <td>1 </td>
 * <td>Dígito verificador do segundo campo </td>
 * </tr>
 * <tr>
 * <td>22-31 </td>
 * <td>10 </td>
 * <td>16ª a 25ª posições do campo livre (posições 35 a 44 do código de barras)
 * </td>
 * </tr>
 * <tr>
 * <td>32-32 </td>
 * <td>1 </td>
 * <td>Dígito verificador do terceiro campo </td>
 * </tr>
 * <tr>
 * <td>33-33 </td>
 * <td>1 </td>
 * <td>Dígito verificador geral (posição 5 do código de barras) </td>
 * </tr>
 * <tr>
 * <td>34-37 </td>
 * <td>4 </td>
 * <td>Posições 34 a 37 – fator de vencimento (posições 6 a 9 do código debarras)</td>
 * </tr>
 * <tr>
 * <td>37-47 </td>
 * <td>10 </td>
 * <td>Posições 38 a 47 – valor nominal do título(posições 10 a 19 do código de barras) </td>
 * </tr>
 * </table>
 * 
 * <br />
 * <br />
 * 
 * Observações:
 * 
 * <br />
 * <ul>
 * 
 * <li>Em cada um dos três primeiros campos, após a 5a posição, deve ser
 * inserido um ponto “.”, a fim de facilitar a visualização, para a digitação,
 * quando necessário;</li>
 * <li>Quinto campo:
 * <ul>
 * <br />
 * <li>preenchimento com zeros entre o fator de vencimento e o valor até
 * completar 14 posições;
 * <li>a existência de “0000” no campo “fator de vencimento” da linha digitável
 * do bloqueto de cobrança é indicativo de que o código de barras não contém
 * fator de vencimento. Nesse caso, o banco acolhedor/recebedor estará isento
 * das responsabilidades pelo recebimento após o vencimento, que impede de
 * identificar automaticamente se o bloqueto está ou não vencido;</li>
 * <li>quando se tratar de bloquetos sem discriminação do valor no código de
 * barras, a representação deverá ser com zeros;</li>
 * <li>não deverá conter separação por pontos, vírgulas ou espaços;</li>
 * </ul>
 * <br />
 * </li>
 * <li>Os dígitos verificadores referentes aos 1º, 2º e 3º campos não são
 * representados no código de barras;</li>
 * <li>Os dados da linha digitável não se apresentam na mesma ordem do código
 * de barras.</li>
 * 
 * </ul>
 * 
 * 
 * @see org.jrimum.bopepo.CodigoDeBarras
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * @author <a href="mailto:misaelbarreto@gmail.com">Misael Barreto</a> 
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * @author <a href="http://www.nordestefomento.com.br">Nordeste Fomento Mercantil</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public class LinhaDigitavel extends BlockOfFields {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6089634012523938802L;
	private static Logger log = LoggerProvider.getInstance().getLogger(LinhaDigitavel.class);
	
	/**
	 * 
	 */
	private static final Integer FIELDS_LENGTH = 5;
	
	/**
	 * <p>
	 * Tamanho dos campos mais os espaços entre eles.
	 * </p>
	 */
	private static final Integer STRING_LENGTH = 54;

	/**
	 * 
	 */
	private FixedField<InnerCampo1> innerCampo1;
	
	/**
	 * 
	 */
	private FixedField<InnerCampo2> innerCampo2;
	
	/**
	 * 
	 */
	private FixedField<InnerCampo3> innerCampo3;
	
	/**
	 * <p>
	 * Digito verificador geral.
	 * </p>
	 */
	private FixedField<Integer> campo4;
	
	/**
	 * 
	 */
	private FixedField<InnerCampo5> innerCampo5;


	/**
	 * <p>
	 * Cria uma linha digitável a partir do código de barras passado.
	 * </p>
	 * 
	 * @param codigoDeBarras
	 * 
	 * @see CodigoDeBarras
	 * 
	 * @since 0.2
	 */
	LinhaDigitavel(CodigoDeBarras codigoDeBarras) {
		super();
		setLength(STRING_LENGTH);
		setSize(FIELDS_LENGTH);
		
		if(log.isDebugEnabled())
			log.debug("codigoDeBarra instance : "+codigoDeBarras);
		
		innerCampo1 = new FixedField<InnerCampo1>(new InnerCampo1(4,11),11);
		innerCampo2 = new FixedField<InnerCampo2>(new InnerCampo2(2,12),12);
		innerCampo3 = new FixedField<InnerCampo3>(new InnerCampo3(2,12),12);
		campo4 = new FixedField<Integer>(new Integer(0),1);
		innerCampo5 = new FixedField<InnerCampo5>(new InnerCampo5(2,14),14);
		
		add(innerCampo1);
		add(innerCampo2);
		add(innerCampo3);
		add(campo4);
		add(innerCampo5);
		
		this.innerCampo1.getValue().load(codigoDeBarras);
		this.innerCampo2.getValue().load(codigoDeBarras);
		this.innerCampo3.getValue().load(codigoDeBarras);
		
		this.campo4.setValue(codigoDeBarras.getDigitoVerificadorGeral().getValue());
		
		if(log.isDebugEnabled())
			log.debug("InnerCampo 4 da Linha Digitável : "+this.campo4.getValue());
		
		this.innerCampo5.getValue().load(codigoDeBarras);
		
		if(log.isDebugEnabled())
			log.debug("linhaDigitavel instanciada : "+this.write());
	}

	/**
	 * Escreve a linha digitável foramatada (com espaço entre os campos).
	 * 
	 * @see br.com.anteros.flatfile.type.component.BlockOfFields#write()
	 */
	@Override
	public String write(){
		
		return new StringBuilder(innerCampo1.write()).
		append(" ").
		append(innerCampo2.write()).
		append(" ").
		append(innerCampo3.write()).
		append(" ").
		append(campo4.write()).
		append(" ").
		append(innerCampo5.write()).toString();

	}

	private abstract class InnerCampo extends BlockOfFields {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 6746400538765124943L;
		/**
		 * 
		 */
		protected final BoletoLinhaDigitavelDV calculadorDV = new BoletoLinhaDigitavelDV();
		
		
		protected InnerCampo(Integer fieldsLength, Integer stringLength) {
			super();
			setLength(stringLength);
			setSize(fieldsLength);
		}
		
	}
	
	private abstract class InnerCampoFormatado extends InnerCampo {
		
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 3650450185403697045L;

		protected InnerCampoFormatado(final Integer fieldsLength, final Integer stringLength) {
			super(fieldsLength, stringLength);
		}
		
		/**
		 * <p>
		 * 
		 * Aplicação do seguinte requisito da FEBRABAN: <br />
		 * Em cada um dos três primeiros campos, após a quinta (5) posição, deve ser
		 * inserido um ponto “.”, a fim de facilitar a visualização, para a
		 * digitação, quando necessário.
		 * 
		 * </p>
		 * 
		 * 
		 * @see br.com.anteros.flatfile.type.component.BlockOfFields#write()
		 */
		@Override
		public String write(){
			
			StringBuilder lineOfFields = new StringBuilder(StringUtils.EMPTY);
			
			for(FixedField<?> field : this){
				lineOfFields.append(field.write());
			}
			
			lineOfFields.insert(5, ".");
			
			return lineOfFields.toString();
		}
		
	}
	
	/**
	 * Componhe o campo 1 da linha digitável com os seguintes dados: <br />
	 * <ul>
	 * <li>Identificação do banco</li>
	 * <li>Código de moeda (9 – Real)</li>
	 * <li>Cinco primeiras posições do campo livre (posições 20 a 24 do código
	 * de barras)</li>
	 * <li>Dígito verificador do primeiro campo</li>
	 * </ul>
	 * 
	 * @param titulo
	 * @param codigoDeBarra
	 * @param calculadorDV
	 */
	private class InnerCampo1 extends InnerCampoFormatado{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 2948116051922000890L;

		/**
		 * @param fieldsLength
		 * @param stringLength
		 */
		private InnerCampo1(Integer fieldsLength, Integer stringLength) {
			super(fieldsLength, stringLength);
		}
		
		/**
		 * @param codigoDeBarras
		 */
		private void load(CodigoDeBarras codigoDeBarras){
				
				add(new FixedField<String>(codigoDeBarras.write().substring(0, 3),3));
				add(new FixedField<String>(codigoDeBarras.write().substring(3, 4),1));
				add(new FixedField<String>(codigoDeBarras.write().substring(19, 24),5));
				add(new FixedField<Integer>(calculadorDV.calcule(get(0).write() + get(1).write() + get(2).write()),1));
				
				if(log.isDebugEnabled())
					log.debug("Digito verificador do Field 1 da Linha Digitável : "+get(3).getValue());

				
				if(log.isDebugEnabled())
					log.debug("Field 1 da Linha Digitável composto : "+write());
		}
		
	}
	
	/**
	 * Componhe o campo 2 da linha digitável com os seguintes dados: <br />
	 * <ul>
	 * <li>6ª a 15ª posições do campo livre (posições 25 a 34 do código de
	 * barras)</li>
	 * <li>Dígito verificador do segundo campo</li>
	 * </ul>
	 * 
	 * @param codigoDeBarra
	 * @param calculadorDV
	 */
	private class InnerCampo2 extends InnerCampoFormatado{

		/**
		 * 
		 */
		private static final long serialVersionUID = -2201847536243988819L;

		/**
		 * @param fieldsLength
		 * @param stringLength
		 */
		private InnerCampo2(Integer fieldsLength, Integer stringLength) {
			super(fieldsLength, stringLength);
		}
		
		
		/**
		 * @param codigoDeBarras
		 */
		private void load(CodigoDeBarras codigoDeBarras){
			
			add(new FixedField<String>(codigoDeBarras.write().substring(24, 34),10));				
			add(new FixedField<Integer>(calculadorDV.calcule(get(0).write()),1));
			
			if(log.isDebugEnabled())
				log.debug("Digito verificador do campo 2 da Linha Digitável : "+get(1).getValue());
			
			if(log.isDebugEnabled())
				log.debug("InnerCampo 2 da Linha Digitável composto : "+write());
		}
		
	}
	
	/**
	 * Componhe o campo 3 da linha digitável com os seguintes dados: <br />
	 * <ul>
	 * <li>16ª a 25ª posições do campo livre (posições 35 a 44 do código de
	 * barras)</li>
	 * <li>Dígito verificador do terceiro campo</li>
	 * </ul>
	 * 
	 * @param codigoDeBarra
	 * @param calculadorDV
	 */
	private class InnerCampo3 extends InnerCampoFormatado{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -4248472044788156665L;

		/**
		 * @param fieldsLength
		 * @param stringLength
		 */
		private InnerCampo3(Integer fieldsLength, Integer stringLength) {
			super(fieldsLength, stringLength);
		}
		
		/**
		 * @param codigoDeBarras
		 */
		private void load(CodigoDeBarras codigoDeBarras){
			
			add(new FixedField<String>(codigoDeBarras.write().substring(34, 44),10));				
			add(new FixedField<Integer>(calculadorDV.calcule(get(0).write()),1));
			
			if(log.isDebugEnabled())
				log.debug("Digito verificador do campo 3 da Linha Digitável : "+get(1).getValue());
			
			if(log.isDebugEnabled())
				log.debug("InnerCampo 3 da Linha Digitável composto : "+write());
			
		}
		
	}
	
	/**
	 * Componhe o campo 5 da linha digitável com os seguintes dados: <br />
	 * <ul>
	 * <li>Posições 34 a 37 – fator de vencimento (posições 6 a 9 do código de
	 * barras)</li>
	 * <li>Posições 38 a 47 – valor nominal do título(posições 10 a 19 do
	 * código de barras)</li>
	 * </ul>
	 * 
	 * @param codigoDeBarra
	 */
	private class InnerCampo5 extends InnerCampo{

		/**
		 * 
		 */
		private static final long serialVersionUID = -8040082112684009827L;

		/**
		 * @param fieldsLength
		 * @param stringLength
		 */
		private InnerCampo5(Integer fieldsLength, Integer stringLength) {
			super(fieldsLength, stringLength);
		}
		
		/**
		 * @param codigoDeBarras
		 */
		private void load(CodigoDeBarras codigoDeBarras){
			
			add(new FixedField<String>(codigoDeBarras.write().substring(5, 9),4));
			add(new FixedField<String>(codigoDeBarras.write().substring(9, 19),10));
			
			if(log.isDebugEnabled())
				log.debug("InnerCampo 5 da Linha Digitável composto : "+write());
			
		}
		
	}

	@Override
	public String toString() {
		return "LinhaDigitavel [innerCampo1=" + innerCampo1 + ", innerCampo2=" + innerCampo2 + ", innerCampo3="
				+ innerCampo3 + ", campo4=" + campo4 + ", innerCampo5=" + innerCampo5 + "]";
	}
	
	

}
