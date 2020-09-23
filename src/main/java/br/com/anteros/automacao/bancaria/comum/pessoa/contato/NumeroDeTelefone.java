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
package br.com.anteros.automacao.bancaria.comum.pessoa.contato;

/**
 * 
 * <p>
 * Representação telefone
 * </p>
 * 
 */
public class NumeroDeTelefone{

	private int ddi;

	private int ddd;

	private int prefixo;

	private int sufixo;
	
	private String telefone;

	public NumeroDeTelefone() {}
	
	public int getDDI() {
		return ddi;
	}

	public void setDDI(int ddi) {
		this.ddi = ddi;
	}

	public int getDDD() {
		return ddd;
	}

	public void setDDD(int ddd) {
		this.ddd = ddd;
	}

	public int getPrefixo() {
		return prefixo;
	}

	public void setPrefixo(int prefixo) {
		this.prefixo = prefixo;
	}

	public int getSufixo() {
		return sufixo;
	}

	public void setSufixo(int sufixo) {
		this.sufixo = sufixo;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "NumeroDeTelefone [ddi=" + ddi + ", ddd=" + ddd + ", prefixo=" + prefixo + ", sufixo=" + sufixo
				+ ", telefone=" + telefone + "]";
	}

}
