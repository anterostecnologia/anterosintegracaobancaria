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
package br.com.anteros.integracao.bancaria.banco.layout;

public class RemessaCobranca {
	
	private TipoDeMovimentoRemessa codigoMovimentoRemessa;
	
	private Titulo titulo;
	
	private Integer nrLote;	
	
	private RemessaCobranca(TipoDeMovimentoRemessa codigoMovimentoRemessa, Titulo titulo, Integer nrLote) {
		super();
		this.codigoMovimentoRemessa = codigoMovimentoRemessa;
		this.titulo = titulo;
		this.nrLote = nrLote;
	}
	
	public static RemessaCobranca of (TipoDeMovimentoRemessa codigoMovimentoRemessa, Titulo titulo, Integer nrLote) {
		return new RemessaCobranca(codigoMovimentoRemessa, titulo, nrLote);
	}

	public TipoDeMovimentoRemessa getCodigoMovimentoRemessa() {
		return codigoMovimentoRemessa;
	}

	public void setCodigoMovimentoRemessa(TipoDeMovimentoRemessa codigoMovimentoRemessa) {
		this.codigoMovimentoRemessa = codigoMovimentoRemessa;
	}

	public Titulo getTitulo() {
		return titulo;
	}

	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}

	public Integer getNrLote() {
		return nrLote;
	}

	public void setNrLote(Integer nrLote) {
		this.nrLote = nrLote;
	}
	
	

}
