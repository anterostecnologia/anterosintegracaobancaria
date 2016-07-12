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

import java.util.HashSet;
import java.util.Set;

import br.com.anteros.integracao.bancaria.banco.layout.Titulo;
import br.com.anteros.integracao.bancaria.validador.digitoverificador.Modulo;

/**
 *<p>
 * Interface comum para todos os campos livres do Banco Itaú que venham a
 * existir.
 * </p>
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
abstract class AbstractCLItau extends AbstractCampoLivre {
	
	/**
	 *
	 */
	private static final long serialVersionUID = -3082903872777434482L;
	
	/**
	 * <p>
	 * Carteiras especiais sem registro na qual são utilizadas 15 posições numéricas 
	 * para identificação do título liquidado (8 do Nosso Número e 7 do Seu Número).
	 * </p>
	 */
	private static final Set<Integer> CARTEIRAS_ESPECIAIS = new HashSet<Integer>(8);
	
	static{
		
		CARTEIRAS_ESPECIAIS.add(106);
		CARTEIRAS_ESPECIAIS.add(107);
		CARTEIRAS_ESPECIAIS.add(122);
		CARTEIRAS_ESPECIAIS.add(142);
		CARTEIRAS_ESPECIAIS.add(143);
		CARTEIRAS_ESPECIAIS.add(195);
		CARTEIRAS_ESPECIAIS.add(196);
		CARTEIRAS_ESPECIAIS.add(198);
	}

	/**
	 * <p>Cria um campo livre com um determinado número de campos</p>
	 * 
	 * @see AbstractCampoLivre
	 * 
	 * @param fieldsLength - Número de campos
	 */
	protected AbstractCLItau(Integer fieldsLength) {
		
		super(fieldsLength);
	}
	
	protected static CampoLivre create(Titulo titulo){
		
		checkCarteiraNotNull(titulo);
		checkCodigoDaCarteira(titulo);
		
		/*
		 * Se a carteira for especial, a forma de construir o campo livre será diferente.
		 */
		if(CARTEIRAS_ESPECIAIS.contains(titulo.getCarteira().getCodigo())) {
			
			return new CLItauComCarteirasEspeciais(titulo);
			
		}else {
			
			return new CLItauPadrao(titulo);
		}
	}
	
	/**
	 * <p>
	 * Método auxiliar para calcular o dígito verificador dos campos 31 e 41.
	 * O dígito é calculado com base em um campo fornecido pelos métodos que o chamam
	 * (<code>calculeDigitoDaPosicao31</code> e <code>calculeDigitoDaPosicao41</code>)
	 * </p>
	 * <p>
	 * O cálculo é feito através do módulo 10.
	 * </p>
	 * 
	 * @param campo
	 * @return Dígito verificador do campo fornecido.
	 * 
	 * @since 
	 */
	protected Integer calculeDigitoVerificador(String campo) {
				
		int restoDivisao = Modulo.calculeMod10(campo, 1, 2);
		int digito = Modulo.MOD10 - restoDivisao;
		
		if(digito > 9) {
			digito = 0;
		}
		
		return new Integer(digito);
	}

}
