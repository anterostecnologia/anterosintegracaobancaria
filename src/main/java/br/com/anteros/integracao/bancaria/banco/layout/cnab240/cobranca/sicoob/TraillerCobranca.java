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
package br.com.anteros.integracao.bancaria.banco.layout.cnab240.cobranca.sicoob;

import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.BRANCOS_1;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.BRANCOS_2;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CD_BANCO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.LT_SERVICO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NR_AVISO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.QT_REGISTRO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.QT_TITULOS_COBRANCA_CAUCIONADA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.QT_TITULOS_COBRANCA_DESCONTADA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.QT_TITULOS_COBRANCA_SIMPLES;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.QT_TITULOS_COBRANCA_VINCULADA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.TIPO_REGISTRO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.VL_TOTAL_TITULO_CARTEIRA_CAUCIONADA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.VL_TOTAL_TITULO_CARTEIRA_DESCONTADA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.VL_TOTAL_TITULO_CARTEIRA_SIMPLES;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.VL_TOTAL_TITULO_CARTEIRA_VINCULADA;

import java.math.BigDecimal;
import java.util.List;

import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.Formats;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.annotation.RecordData;
import br.com.anteros.flatfile.language.EnumTypes;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.RemessaCobranca;

public class TraillerCobranca implements RecordData {

	@IdType(name = TIPO_REGISTRO, length = 1, positionField = 3, value = "5")
	private String tipoRegistro;

	@Field(name = CD_BANCO, length = 3, type = EnumTypes.INTEGER, value = "756", padding = Paddings.ZERO_LEFT)
	private Integer codigoBanco;

	@Field(name = LT_SERVICO, length = 4, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer loteServico;

	@Field(name = BRANCOS_1, length = 9, value = " ", padding = Paddings.WHITE_SPACE_LEFT)
	private String brancos1;

	@Field(name = QT_REGISTRO, length = 6, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer quantidadeRegistros;

	@Field(name = QT_TITULOS_COBRANCA_SIMPLES, length = 6, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer quantidadeTituloCobrancaSimples;

	@Field(name = VL_TOTAL_TITULO_CARTEIRA_SIMPLES, length = 17, type = EnumTypes.BIGDECIMAL, padding = Paddings.ZERO_LEFT, format = Formats.DECIMAL_DD)
	private BigDecimal valorTotalTituloCarteiraSimples;

	@Field(name = QT_TITULOS_COBRANCA_VINCULADA, length = 6, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer quantidadeTituloCobrancaVinculada;

	@Field(name = VL_TOTAL_TITULO_CARTEIRA_VINCULADA, length = 17, type = EnumTypes.BIGDECIMAL, padding = Paddings.ZERO_LEFT, format = Formats.DECIMAL_DD)
	private BigDecimal valorTotalTituloCarteiraVinculada;

	@Field(name = QT_TITULOS_COBRANCA_CAUCIONADA, length = 6, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer quantidadeTituloCobrancaCaucionada;

	@Field(name = VL_TOTAL_TITULO_CARTEIRA_CAUCIONADA, length = 17, type = EnumTypes.BIGDECIMAL, padding = Paddings.ZERO_LEFT, format = Formats.DECIMAL_DD)
	private BigDecimal valorTotalTituloCarteiraCaucionada;

	@Field(name = QT_TITULOS_COBRANCA_DESCONTADA, length = 6, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer quantidadeTituloCobrancaDescontada;

	@Field(name = VL_TOTAL_TITULO_CARTEIRA_DESCONTADA, length = 17, type = EnumTypes.BIGDECIMAL, padding = Paddings.ZERO_LEFT, format = Formats.DECIMAL_DD)
	private BigDecimal valorTotalTituloCarteiraDescontada;

	@Field(name = NR_AVISO, length = 8, padding = Paddings.WHITE_SPACE_RIGHT, value=" ")
	private String nrAviso;

	@Field(name = BRANCOS_2, length = 117, value = " ", padding = Paddings.WHITE_SPACE_LEFT)
	private String brancos2;

	private ContaBancaria contaBancaria;

	public TraillerCobranca(ContaBancaria contaBancaria, List<RemessaCobranca> remessas) {
		this.codigoBanco = contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo(); // G001
		this.loteServico = 1;// G002
		this.quantidadeTituloCobrancaSimples = remessas.size();
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

	public Integer getQuantidadeTituloCobrancaSimples() {
		return quantidadeTituloCobrancaSimples;
	}

	public void setQuantidadeTituloCobrancaSimples(Integer quantidadeTituloCobrancaSimples) {
		this.quantidadeTituloCobrancaSimples = quantidadeTituloCobrancaSimples;
	}

	public BigDecimal getValorTotalTituloCarteiraSimples() {
		return valorTotalTituloCarteiraSimples;
	}

	public void setValorTotalTituloCarteiraSimples(BigDecimal valorTotalTituloCarteiraSimples) {
		this.valorTotalTituloCarteiraSimples = valorTotalTituloCarteiraSimples;
	}

	public Integer getQuantidadeTituloCobrancaVinculada() {
		return quantidadeTituloCobrancaVinculada;
	}

	public void setQuantidadeTituloCobrancaVinculada(Integer quantidadeTituloCobrancaVinculada) {
		this.quantidadeTituloCobrancaVinculada = quantidadeTituloCobrancaVinculada;
	}

	public BigDecimal getValorTotalTituloCarteiraVinculada() {
		return valorTotalTituloCarteiraVinculada;
	}

	public void setValorTotalTituloCarteiraVinculada(BigDecimal valorTotalTituloCarteiraVinculada) {
		this.valorTotalTituloCarteiraVinculada = valorTotalTituloCarteiraVinculada;
	}

	public Integer getQuantidadeTituloCobrancaCaucionada() {
		return quantidadeTituloCobrancaCaucionada;
	}

	public void setQuantidadeTituloCobrancaCaucionada(Integer quantidadeTituloCobrancaCaucionada) {
		this.quantidadeTituloCobrancaCaucionada = quantidadeTituloCobrancaCaucionada;
	}

	public BigDecimal getValorTotalTituloCarteiraCaucionada() {
		return valorTotalTituloCarteiraCaucionada;
	}

	public void setValorTotalTituloCarteiraCaucionada(BigDecimal valorTotalTituloCarteiraCaucionada) {
		this.valorTotalTituloCarteiraCaucionada = valorTotalTituloCarteiraCaucionada;
	}

	public Integer getQuantidadeTituloCobrancaDescontada() {
		return quantidadeTituloCobrancaDescontada;
	}

	public void setQuantidadeTituloCobrancaDescontada(Integer quantidadeTituloCobrancaDescontada) {
		this.quantidadeTituloCobrancaDescontada = quantidadeTituloCobrancaDescontada;
	}

	public BigDecimal getValorTotalTituloCarteiraDescontada() {
		return valorTotalTituloCarteiraDescontada;
	}

	public void setValorTotalTituloCarteiraDescontada(BigDecimal valorTotalTituloCarteiraDescontada) {
		this.valorTotalTituloCarteiraDescontada = valorTotalTituloCarteiraDescontada;
	}

	public String getNrAviso() {
		return nrAviso;
	}

	public void setNrAviso(String nrAviso) {
		this.nrAviso = nrAviso;
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

	@Override
	public int getNumberOfRecords() {
		return 0;
	}

	@Override
	public void readRowData(int row, int sequence) {
		this.quantidadeRegistros = sequence-1;
	}

}
