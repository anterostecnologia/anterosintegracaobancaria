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

import java.util.Objects;

import br.com.anteros.core.utils.Assert;
import br.com.anteros.core.utils.StringUtils;
import br.com.anteros.flatfile.type.component.Fillers;
import br.com.anteros.flatfile.type.component.FixedField;
import br.com.anteros.integracao.bancaria.banco.layout.Titulo;


/**
 * <p>
 * Esta classe tem como finalidade encapsular toda a lógica de criação de um
 * campo livre e de fornecer para o pacote
 * <code>org.jrimum.bopepo.campolivre</code> 
 * um único ponto de acesso ao mesmo.
 * </p>
 * 
 */
public final class CampoLivreFactory {

	/**
	 * <p>
	 * Devolve um <code>CampoLivre</code> de acordo com o Banco contido na conta bancária do título.
	 * </p> 
	 * <p>
	 * Caso exista implementação para o banco o retorno terá uma referência não nula.
	 * </p>
	 * 
	 * @param titulo
	 * 
	 * @return Uma referência para um CampoLivre.
	 * @throws NotSupportedBancoException 
	 * @throws NotSupportedCampoLivreException 
	 */
	public static CampoLivre create(Titulo titulo) throws NotSupportedBancoException, NotSupportedCampoLivreException {

		return AbstractCampoLivre.create(titulo);
	}
	
	/**
	 * Devolve um CampoLivre a partir de uma String.
	 * 
	 * @param strCampoLivre
	 * 
	 * @return Referência para uma instância anônima de CampoLivre.
	 * 
	 * @throws NullPointerException
	 * @throws IllegalArgumentException
	 */
	public static CampoLivre create(String strCampoLivre) {
		Assert.notNull(strCampoLivre);
		
		strCampoLivre = StringUtils.strip(strCampoLivre);
		
		Assert.notNull(strCampoLivre, "O Campo Livre não deve ser vazio!");
		 
		Assert.checkArgument(strCampoLivre.length() == CampoLivre.STRING_LENGTH, "O tamanho do Campo Livre [ " + strCampoLivre + " ] deve ser igual a 25 e não ["+strCampoLivre.length()+"]!");
		Assert.checkArgument(!StringUtils.containsAny(strCampoLivre, " "), "O Campo Livre [ " + strCampoLivre + " ] não deve conter espaços em branco!");
		Assert.checkArgument(StringUtils.isNumber(strCampoLivre),"O Campo Livre [ " + strCampoLivre + " ] deve ser uma String numérica!");

		return valueOf(strCampoLivre);
	}

	private static CampoLivre valueOf(String strCampoLivre) {
		 CampoLivre campoLivre = new CampoLivre() {
			private static final long serialVersionUID = -7592488081807235080L;

			FixedField<String> campo = new FixedField<String>(StringUtils.EMPTY,
					STRING_LENGTH, Fillers.ZERO_LEFT);

			public void read(String str) {
				campo.read(str);
			}

			public String write() {
				return campo.write();
			}
		};
		campoLivre.read(strCampoLivre);
		return campoLivre;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return Objects.toString(this);
	}
	
}
