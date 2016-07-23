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
package br.com.anteros.integracao.bancaria.banco.layout.cnab240.cobranca.hsbc.v10;

import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.language.EnumTypes;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.*;

public class TraillerArquivo {


	@IdType(name = TIPO_REGISTRO, length = 1, positionField = 3, value = "9")
	private String tipoRegistro;

	@Field(name = CD_BANCO, length = 3, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoBanco;

	@Field(name = LT_SERVICO, length = 4, value = "9999", type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer loteServico;

	@Field(name = "BRANCOS_1", length = 9, value = " ", padding = Paddings.WHITE_SPACE_LEFT)
	private String brancos1;

	@Field(name = QT_LOTE_ARQUIVO, length = 6, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer quantidadeLotesArquivo;

	@Field(name = QT_REGISTRO_ARQUIVO, length = 6, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer quantidadeRegistrosArquivo;

	@Field(name = QT_CONTA_CONCILIACAO, length = 6, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer quantidadeContasConciliacao;

	@Field(name = "BRANCOS_2", length = 205, value = " ", padding = Paddings.WHITE_SPACE_LEFT)
	private String brancos2;

	public TraillerArquivo(ContaBancaria contaBancaria) {
		this.codigoBanco = contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo(); // G001
		this.loteServico = 9999;// G002
		this.quantidadeLotesArquivo = 1;// G049
		this.quantidadeRegistrosArquivo = 1; // G056
	}

	public static TraillerArquivo of(ContaBancaria contaBancaria) {
		return new TraillerArquivo(contaBancaria);
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

	public Integer getQuantidadeLotesArquivo() {
		return quantidadeLotesArquivo;
	}

	public void setQuantidadeLotesArquivo(Integer quantidadeLotesArquivo) {
		this.quantidadeLotesArquivo = quantidadeLotesArquivo;
	}

	public Integer getQuantidadeRegistrosArquivo() {
		return quantidadeRegistrosArquivo;
	}

	public void setQuantidadeRegistrosArquivo(Integer quantidadeRegistrosArquivo) {
		this.quantidadeRegistrosArquivo = quantidadeRegistrosArquivo;
	}

	public Integer getQuantidadeContasConciliacao() {
		return quantidadeContasConciliacao;
	}

	public void setQuantidadeContasConciliacao(Integer quantidadeContasConciliacao) {
		this.quantidadeContasConciliacao = quantidadeContasConciliacao;
	}

	public String getBrancos2() {
		return brancos2;
	}

	public void setBrancos2(String brancos2) {
		this.brancos2 = brancos2;
	}

	public void set(br.com.anteros.flatfile.Record record) {
		setTipoRegistro((String) record.getValue(TIPO_REGISTRO));
		setCodigoBanco((Integer) record.getValue(CD_BANCO));
		setLoteServico((Integer) record.getValue(LT_SERVICO));
		setQuantidadeLotesArquivo((Integer) record.getValue(QT_LOTE_ARQUIVO));
		setQuantidadeRegistrosArquivo((Integer) record.getValue(QT_REGISTRO_ARQUIVO));
		setQuantidadeContasConciliacao((Integer) record.getValue(QT_CONTA_CONCILIACAO));
	}
}
