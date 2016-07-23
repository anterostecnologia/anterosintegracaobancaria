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

import br.com.anteros.core.utils.Assert;
import br.com.anteros.flatfile.type.component.Fillers;
import br.com.anteros.flatfile.type.component.FixedField;
import br.com.anteros.integracao.bancaria.banco.layout.Titulo;

/**
 * <p>
 * O campo livre da Caixa para Cobrança Sem Registro SICOB - Nosso Número 16
 * posições, deve seguir esta forma:
 * </p>
 * 
 * <table border="1" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" width="100%" id="campolivre">
 * <thead bgcolor="#DEDEDE">
 * <tr>
 * <th>Posição</th>
 * <th>Tamanho</th>
 * <th>Picture</th>
 * <th>Conteúdo (terminologia padrão)</th>
 * <th>Conteúdo (terminologia do banco)</th>
 * </tr>
 * </thead> <tbody style="text-align:center">
 * <tr>
 * <td >20-24</td>
 * <td >5</td>
 * <td >9(5)</td>
 * <td style="text-align:left;padding-left:10">Código do Cliente(sem dígito
 * verificador)</td>
 * <td style="text-align:left;padding-left:10">Código do Cliente Cedente
 * fornecido pela CAIXA</td>
 * </tr>
 * <tr>
 * <td >25-28</td>
 * <td >4</td>
 * <td >9(4)</td>
 * <td style="text-align:left;padding-left:10">Código da Agência(sem dígito
 * verificador)</td>
 * <td style="text-align:left;padding-left:10">CNPJ da Agência da Conta do
 * Cliente Cedente</td>
 * </tr>
 * <tr>
 * <td >29-29</td>
 * <td >1</td>
 * <td >9(1)</td>
 * <td style="text-align:left;padding-left:10">Código da Carteira = 8</td>
 * <td style="text-align:left;padding-left:10">Código da Carteira = 8</td>
 * </tr>
 * <tr>
 * <td >30-30</td>
 * <td >1</td>
 * <td >9(1)</td>
 * <td style="text-align:left;padding-left:10">Constante = 7</td>
 * <td style="text-align:left;padding-left:10">Constante = 7</td>
 * </tr>
 * <tr>
 * <td >31-44</td>
 * <td >14</td>
 * <td >&nbsp;9(14)</td>
 * <td style="text-align:left;padding-left:10">Nosso Número(sem dígito
 * verificador)</td>
 * <td style="text-align:left;padding-left:10">Nosso Número do Cliente com 14
 * posições</td>
 * </tr>
 * </table>
 * 
 * 
 * @see org.jrimum.bopepo.campolivre.AbstractCampoLivre
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * 
 * @since 0.2
 * 
 * @version 0.2.3
 */
class CLCaixaEconomicaFederalSICOBNossoNumero14 extends AbstractCLCaixaEconomicaFederal {
	 
	/**
	 * {@code serialVersionUID = 4219053358562778591L}
	 */
	private static final long serialVersionUID = 4219053358562778591L;

	/**
	 * Número de campos = 5.
	 */
	private static final Integer FIELDS_LENGTH = Integer.valueOf(5);
	
	/**
	 * Tamanho do campo Conta = 5. 
	 */
	private static final Integer CONTA_LENGTH = Integer.valueOf(5);
	
	/**
	 * Tamanho do campo Agência = 4. 
	 */
	private static final Integer AGENCIA_LENGTH = Integer.valueOf(4);
	
	/**
	 * Tamanho do campo Nosso Número = 14. 
	 */
	protected static final Integer NOSSO_NUMERO_LENGTH = Integer.valueOf(14);
	
	/**
	 * Constante "7".
	 */
	private static final FixedField<Integer> CONSTANT_FIELD = new FixedField<Integer>(7, 1);
	
	/**
	 * Valor constante do campo "Carteira" = 8 - Carteira Sem Registro Eletrônica.
	 */
	private static final Integer CARTEIRA_SEM_REGISTRO = Integer.valueOf(8);
	
	/**
	 * Código da carteira: sempre 8.
	 */
	private static final FixedField<Integer> CARTEIRA_FIELD = new FixedField<Integer>(CARTEIRA_SEM_REGISTRO, 1);
	
	/**
	 * <p>
	 *   Cria um campo livre instanciando o número de fields ({@code FIELDS_LENGTH}) deste campo.
	 * </p>
	 * 
	 * @since 0.2
	 */
	protected CLCaixaEconomicaFederalSICOBNossoNumero14() {
		
		super(FIELDS_LENGTH);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.jrimum.bopepo.campolivre.AbstractCampoLivre#checkValues(org.jrimum.domkee.financeiro.banco.febraban.Titulo)
	 */
	@Override
	protected void checkValues(Titulo titulo){
		
		checkNumeroDaContaNotNull(titulo);
		checkCodigoDoNumeroDaConta(titulo);
		checkCodigoDoNumeroDaContaMenorOuIgualQue(titulo, 99999);
		checkAgenciaNotNull(titulo);
		checkCodigoDaAgencia(titulo);
		checkCodigoDaAgenciaMenorOuIgualQue(titulo, 9999);
		checkCarteiraNotNull(titulo);
		checkCodigoDaCarteira(titulo);
		checkCodigoDaCarteiraMenorOuIgualQue(titulo, 9);
		checkCarteiraSemRegistro(titulo);
		checkNossoNumero(titulo);
		checkTamanhoDoNossoNumero(titulo, NN14);
	}
	
	/**
	 *  {@inheritDoc}
	 *  
	 * @see org.jrimum.bopepo.campolivre.AbstractCampoLivre#addFields(org.jrimum.domkee.financeiro.banco.febraban.Titulo)
	 */
	@Override
	protected void addFields(Titulo titulo) {
		
		this.add(new FixedField<Long>(titulo.getContaBancaria().getNumeroDaConta().getCodigoDaConta(), CONTA_LENGTH, Fillers.ZERO_LEFT));
		this.add(new FixedField<Integer>(titulo.getContaBancaria().getAgencia().getCodigo(), AGENCIA_LENGTH, Fillers.ZERO_LEFT));
		this.add(CARTEIRA_FIELD);
		this.add(CONSTANT_FIELD);
		this.add(new FixedField<String>(titulo.getNossoNumero(), NOSSO_NUMERO_LENGTH, Fillers.ZERO_LEFT));
	}

	/**
	 * Verifica se o código da carteira da conta bancária do título é igual
	 * (carteira simples), caso contrário lança uma {@code
	 * IllegalArgumentException}.
	 * 
	 * <p>
	 * Motivo extraído do manual do banco: <br />
	 * <br />
	 * <i>Carteira Sem Registro Eletrônica com Nosso Número de 16 posições,
	 * sendo que 14 destas posições são para livre uso pelo Cedente. Apenas
	 * Clientes Cedentes com Código do Cedente na operação 870 podem operar com
	 * a Cobrança Sem Registro com 16 posições de Nosso Número.</i>
	 * </p>
	 * 
	 * @param titulo
	 */
	private void checkCarteiraSemRegistro(Titulo titulo) {
		
		Assert.checkArgument(
				titulo.getCarteira().getCodigo().equals(CARTEIRA_SEM_REGISTRO),
				format("Apenas a carteira de código [8] \"Carteira Sem Registro Eletrônica\" é permitida e não o código [%s]!", titulo.getCarteira().getCodigo())
		);
	}

}
