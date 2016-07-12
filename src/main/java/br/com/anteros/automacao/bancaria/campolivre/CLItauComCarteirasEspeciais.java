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

import br.com.anteros.flatfile.type.component.Fillers;
import br.com.anteros.flatfile.type.component.FixedField;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.Titulo;

/**
 * Campo livre padrão do Banco Itaú
 * 
 * <p>
 * Constrói o campo livre no caso especial, ou seja, quando a carteira for:
 * 106, 107, 122, 142, 143, 195, 196 ou 198.
 * </p>
 * 
 * <p>
 * <h2>Layout do Banco Itaú para o campo livre ESPECIAL</h2>
 * <pre>
 * <table border="1" cellpadding="0" cellspacing="0" style="border-collapse:
 * collapse" bordercolor="#111111" id="campolivre">
 * <thead>
 * <tr>
 * <th>Posição</th>
 * <th>Tamanho</th>
 * <th>Picture</th>
 * <th>Conteúdo</th>
 * </tr>
 * </thead>
 * <tbody>
 * <tr>
 * <td >20 a 22</td>
 * <td >3</td>
 * <td >9(03)</td>
 * <td >Carteira</td>
 * </tr>
 * <tr>
 * <td >23 a 30</td>
 * <td >8</td>
 * <td >9(08)</td>
 * <td >Nosso número</td>
 * </tr>
 * <tr>
 * <td >31 a 37</td>
 * <td >7</td>
 * <td >9(07)</td>
 * <td >Seu Número (Número do Documento)</td>
 * </tr>
 * <tr>
 * <td >38 a 42</td>
 * <td >5</td>
 * <td >9(05)</td>
 * <td >Código do Cliente (fornecido pelo Banco)</td>
 * </tr>
 * <tr>
 * <td >43 a 43</td>
 * <td >1</td>
 * <td >9(01)</td>
 * <td >DAC dos campos acima (posições 20 a 42 veja anexo 3)</td>
 * </tr>
 * <tr>
 * <tr>
 * <td >44 a 44</td>
 * <td >1</td>
 * <td >9(01)</td>
 * <td >Zero</td>
 * </tr>
 * </tbody>
 * </table>
 * <pre>
 * </p>
 * 
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
class CLItauComCarteirasEspeciais extends AbstractCLItau {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1532454262023154419L;
	
	/**
	 * Tamanho do campo livre para carteiras especiais.
	 */
	private static final Integer FIELDS_LENGTH = 6;
	
	/**
	 * Dado um título, cria o campo livre do Banco Itaú para carteiras
	 * especiais.
	 * 
	 * @param titulo
	 *            título com as informações para geração do campo livre
	 */
	public CLItauComCarteirasEspeciais(Titulo titulo) {
		super(FIELDS_LENGTH);
		
		ContaBancaria conta = titulo.getContaBancaria();
		
		this.add(new FixedField<Integer>(titulo.getCarteira().getCodigo(), 3, Fillers.ZERO_LEFT));
		this.add(new FixedField<String>(titulo.getNossoNumero(), 8, Fillers.ZERO_LEFT));
		this.add(new FixedField<String>(titulo.getNumeroDocumento(), 7, Fillers.ZERO_LEFT));
		
		//Aqui é o código do cedente, simbolizado pelo código da conta bancária.
		this.add(new FixedField<Integer>(conta.getNumeroDaConta().getCodigoDaConta(), 5, Fillers.ZERO_LEFT));
		
		this.add(new FixedField<Integer>(calculeDigitoDoCampoLivreEspecial(
											titulo.getCarteira().getCodigo(), 
											titulo.getNossoNumero(),
											titulo.getNumeroDocumento(),
											conta.getNumeroDaConta().getCodigoDaConta()), 1));
		this.add(new FixedField<Integer>(0, 1));
	}
	
	/**
	 * Calcula o dígito verificador para o campo livre especial a partir do
	 * código da carteira, do nosso número, do número do documento e do código
	 * da conta.
	 * 
	 * @param codigoDaCarteira
	 * @param nossoNumero
	 * @param numeroDoDocumento
	 * @param codigoDaConta
	 * @return Integer digito
	 * 
	 * @since 0.2
	 */
	private Integer calculeDigitoDoCampoLivreEspecial(Integer codigoDaCarteira,
			String nossoNumero, String numeroDoDocumento, Integer codigoDaConta) {

		StringBuilder campo = new StringBuilder();
		
		campo.append(Fillers.ZERO_LEFT.fill(codigoDaCarteira.intValue(), 3));
		campo.append(Fillers.ZERO_LEFT.fill(nossoNumero, 8));
		campo.append(Fillers.ZERO_LEFT.fill(numeroDoDocumento, 7));
		campo.append(Fillers.ZERO_LEFT.fill(codigoDaConta, 5));
		
		return calculeDigitoVerificador(campo.toString());
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
