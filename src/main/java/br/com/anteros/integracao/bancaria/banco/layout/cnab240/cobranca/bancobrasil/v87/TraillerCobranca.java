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
package br.com.anteros.integracao.bancaria.banco.layout.cnab240.cobranca.bancobrasil.v87;

import java.util.List;

import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.language.EnumTypes;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.RemessaCobranca;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.*;

public class TraillerCobranca {

	@IdType(name = TIPO_REGISTRO, length = 1, positionField = 3, value = "5")
	private String tipoRegistro;

	@Field(name = CD_BANCO, length = 3, type = EnumTypes.INTEGER, value = "1", padding = Paddings.ZERO_LEFT)
	private Integer codigoBanco;

	@Field(name = LT_SERVICO, length = 4, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer loteServico;

	@Field(name = "BRANCOS_1", length = 9, value = " ", padding = Paddings.WHITE_SPACE_LEFT)
	private String brancos1;

	@Field(name = QT_REGISTRO, length = 6, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer quantidadeRegistros;

	@Field(name = "BRANCOS_2", length = 217, value = " ", padding = Paddings.WHITE_SPACE_LEFT)
	private String brancos2;

	private ContaBancaria contaBancaria;

	public TraillerCobranca(ContaBancaria contaBancaria, List<RemessaCobranca> remessas) {
		this.codigoBanco = contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo(); // G001
		this.loteServico = 1;// G002
		this.quantidadeRegistros = remessas.size();// G057
	}

	public TraillerCobranca(ContaBancaria contaBancaria) {
		this.codigoBanco = contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo(); // G001
		this.loteServico = 1;// G002
	}

	public static TraillerCobranca of(ContaBancaria contaBancaria, List<RemessaCobranca> remessas) {
		return new TraillerCobranca(contaBancaria, remessas);
	}

	public String getTipoRegistro() {
		return tipoRegistro;
	}

	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public Integer getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(Integer codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public Integer getLoteServico() {
		return loteServico;
	}

	public void setLoteServico(Integer loteServico) {
		this.loteServico = loteServico;
	}

	public String getBrancos1() {
		return brancos1;
	}

	public void setBrancos1(String brancos1) {
		this.brancos1 = brancos1;
	}

	public Integer getQuantidadeRegistros() {
		return quantidadeRegistros;
	}

	public void setQuantidadeRegistros(Integer quantidadeRegistros) {
		this.quantidadeRegistros = quantidadeRegistros;
	}

	public String getBrancos2() {
		return brancos2;
	}

	public void setBrancos2(String brancos2) {
		this.brancos2 = brancos2;
	}

	public ContaBancaria getContaBancaria() {
		return contaBancaria;
	}

	public void setContaBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

	public void set(br.com.anteros.flatfile.Record record) {
		setTipoRegistro((String) record.getValue(TIPO_REGISTRO));
		setCodigoBanco((Integer) record.getValue(CD_BANCO));
		setLoteServico((Integer) record.getValue(LT_SERVICO));
		setQuantidadeRegistros((Integer) record.getValue(QT_REGISTRO));
	}

	public static TraillerCobranca of(ContaBancaria contaBancaria) {
		return new TraillerCobranca(contaBancaria);
	}

}
