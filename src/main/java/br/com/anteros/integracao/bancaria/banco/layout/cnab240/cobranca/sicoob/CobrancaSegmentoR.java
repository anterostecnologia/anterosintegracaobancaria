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

import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.Formats;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.annotation.RecordData;
import br.com.anteros.flatfile.language.EnumTypes;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.RemessaCobranca;

public class CobrancaSegmentoR implements RecordData {

	@IdType(name = CD_SEGMENTO_REGISTRO, length = 1, positionField = 5, value = "R")
	private String codigoSegmentoRegistro;

	@Field(name = CD_BANCO, length = 3, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT, value = "756")
	private Integer codigoBanco;

	@Field(name = LT_SERVICO, length = 4, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer loteServico;

	@Field(name = TP_REGISTRO, length = 1, value = "3", padding = Paddings.ZERO_LEFT, type = EnumTypes.INTEGER)
	private Integer tipoRegistro;

	@Field(name = NR_SEQUENCIAL_REGISTRO, length = 5, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer numeroSequencialRegistro;

	@Field(name = BRANCOS_1, value = " ", padding = Paddings.WHITE_SPACE_RIGHT, length = 1)
	private String brancos1;

	@Field(name = CD_MOVIMENTO_REMESSA, length = 2, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT, value = "01")
	private Integer codigoMovimentoRemessa;

	@Field(name = CD_DESCONTO1, type = EnumTypes.INTEGER, length = 1, padding = Paddings.ZERO_LEFT)
	private Integer codigoDesconto1;

	@Field(name = DT_DESCONTO1, type = EnumTypes.DATE, length = 8, format = Formats.DATE_DDMMYYYY, padding = Paddings.ZERO_LEFT)
	private Date dtDesconto1;

	@Field(name = VL_DESCONTO1, length = 15, type = EnumTypes.BIGDECIMAL, padding = Paddings.ZERO_LEFT, format = Formats.DECIMAL_DD)
	private BigDecimal vlDesconto1;

	@Field(name = CD_DESCONTO2, type = EnumTypes.INTEGER, length = 1, padding = Paddings.ZERO_LEFT)
	private Integer codigoDesconto2;

	@Field(name = DT_DESCONTO2, type = EnumTypes.DATE, length = 8, format = Formats.DATE_DDMMYYYY, padding = Paddings.ZERO_LEFT)
	private Date dtDesconto2;

	@Field(name = VL_DESCONTO2, length = 15, type = EnumTypes.BIGDECIMAL, padding = Paddings.ZERO_LEFT, format = Formats.DECIMAL_DD)
	private BigDecimal vlDesconto2;

	@Field(name = CD_MULTA, type = EnumTypes.STRING, length = 1)
	private String codigoMulta;

	@Field(name = DT_MULTA, type = EnumTypes.DATE, length = 8, format = Formats.DATE_DDMMYYYY, padding = Paddings.ZERO_LEFT)
	private Date dtMulta;

	@Field(name = VL_MULTA, length = 15, type = EnumTypes.BIGDECIMAL, padding = Paddings.ZERO_LEFT, format = Formats.DECIMAL_DD)
	private BigDecimal vlMulta;

	@Field(name = INFORMACAO_PAGADOR, length = 10, padding = Paddings.WHITE_SPACE_RIGHT)
	private String informacaoAoPagador;

	@Field(name = MENSAGEM_1, length = 40, padding = Paddings.WHITE_SPACE_RIGHT)
	private String mensagem1;

	@Field(name = MENSAGEM_2, length = 40, padding = Paddings.WHITE_SPACE_RIGHT)
	private String mensagem2;

	@Field(name = BRANCOS_2, value = " ", padding = Paddings.WHITE_SPACE_RIGHT, length = 20)
	private String brancos2;

	@Field(name = CD_OCORRENCIA_PAGADOR, type = EnumTypes.INTEGER, length = 8, padding = Paddings.ZERO_LEFT, value="00000000")
	private Integer codigoOcorrenciaPagador;

	@Field(name = BANCO, type = EnumTypes.INTEGER, length = 3, padding = Paddings.ZERO_LEFT, value="000")
	private Integer banco;

	@Field(name = AGENCIA_MANTENEDORA, type = EnumTypes.INTEGER, length = 5, padding = Paddings.ZERO_LEFT, value="00000")
	private Integer agenciaMantenedora;

	@Field(name = DIGITO_VERIFICADOR_AGENCIA, length = 1, padding = Paddings.WHITE_SPACE_RIGHT, value=" ")
	private String digitoVerificadorAgencia;

	@Field(name = NR_CONTACORRENTE, length = 12, type = EnumTypes.LONG, value="000000000000", padding = Paddings.ZERO_LEFT)
	private Long numeroContaCorrente;

	@Field(name = DIGITO_VERIFICADOR_CONTACORRENTE, length = 1, padding = Paddings.WHITE_SPACE_RIGHT, value=" ")
	private String DigitoVerificadorContaCorrente;

	@Field(name = DIGITO_VERFICADOR_AGENCIACONTA, length = 1, padding = Paddings.WHITE_SPACE_RIGHT, value=" ")
	private String digitoVerificadorAgenciaConta;

	@Field(name = EMISSAO_AVISO_DA, type = EnumTypes.INTEGER, length = 1, padding = Paddings.ZERO_LEFT, value="0")
	private Integer emissaoAvisoDebioAutomatico;

	@Field(name = BRANCOS_3, value = " ", padding = Paddings.WHITE_SPACE_RIGHT, length = 9)
	private String brancos3;

	private List<RemessaCobranca> remessas;

	private ContaBancaria contaBancaria;

	public CobrancaSegmentoR(ContaBancaria contaBancaria, List<RemessaCobranca> remessas) {
		this.remessas = remessas;
		this.contaBancaria = contaBancaria;
	}

	public int getNumberOfRecords() {
		return remessas.size();
	}

	public void readRowData(int row, int sequence) {
		this.codigoBanco = contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo(); // G001
		this.loteServico = 1; // G002
		this.numeroSequencialRegistro = sequence;// G038
		this.codigoMovimentoRemessa = remessas.get(row).getCodigoMovimentoRemessa().getTipo();// C004
		this.codigoDesconto1 = remessas.get(row).getTitulo().getTipoDesconto().getTipo();
		this.dtDesconto1 = remessas.get(row).getTitulo().getDataDesconto();
		this.vlDesconto1 = remessas.get(row).getTitulo().getValorDesconto();
		this.codigoMulta = remessas.get(row).getTitulo().getTipoMulta() != null ? remessas.get(row).getTitulo().getTipoMulta().getTipo() : "0";
		this.dtMulta = remessas.get(row).getTitulo().getDataMulta();
		this.vlMulta = remessas.get(row).getTitulo().getPercentualMulta();
	}

	public String getCodigoSegmentoRegistro() {
		return codigoSegmentoRegistro;
	}

	public void setCodigoSegmentoRegistro(String codigoSegmentoRegistro) {
		this.codigoSegmentoRegistro = codigoSegmentoRegistro;
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

	public Integer getTipoRegistro() {
		return tipoRegistro;
	}

	public void setTipoRegistro(Integer tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public Integer getNumeroSequencialRegistro() {
		return numeroSequencialRegistro;
	}

	public void setNumeroSequencialRegistro(Integer numeroSequencialRegistro) {
		this.numeroSequencialRegistro = numeroSequencialRegistro;
	}

	public String getBrancos1() {
		return brancos1;
	}

	public void setBrancos1(String brancos1) {
		this.brancos1 = brancos1;
	}

	public Integer getCodigoMovimentoRemessa() {
		return codigoMovimentoRemessa;
	}

	public void setCodigoMovimentoRemessa(Integer codigoMovimentoRemessa) {
		this.codigoMovimentoRemessa = codigoMovimentoRemessa;
	}

	public Integer getCodigoDesconto1() {
		return codigoDesconto1;
	}

	public void setCodigoDesconto1(Integer codigoDesconto1) {
		this.codigoDesconto1 = codigoDesconto1;
	}

	public Date getDtDesconto1() {
		return dtDesconto1;
	}

	public void setDtDesconto1(Date dtDesconto1) {
		this.dtDesconto1 = dtDesconto1;
	}

	public BigDecimal getVlDesconto1() {
		return vlDesconto1;
	}

	public void setVlDesconto1(BigDecimal vlDesconto1) {
		this.vlDesconto1 = vlDesconto1;
	}

	public Integer getCodigoDesconto2() {
		return codigoDesconto2;
	}

	public void setCodigoDesconto2(Integer codigoDesconto2) {
		this.codigoDesconto2 = codigoDesconto2;
	}

	public Date getDtDesconto2() {
		return dtDesconto2;
	}

	public void setDtDesconto2(Date dtDesconto2) {
		this.dtDesconto2 = dtDesconto2;
	}

	public BigDecimal getVlDesconto2() {
		return vlDesconto2;
	}

	public void setVlDesconto2(BigDecimal vlDesconto2) {
		this.vlDesconto2 = vlDesconto2;
	}

	public String getCodigoMulta() {
		return codigoMulta;
	}

	public void setCodigoMulta(String codigoMulta) {
		this.codigoMulta = codigoMulta;
	}

	public Date getDtMulta() {
		return dtMulta;
	}

	public void setDtMulta(Date dtMulta) {
		this.dtMulta = dtMulta;
	}

	public BigDecimal getVlMulta() {
		return vlMulta;
	}

	public void setVlMulta(BigDecimal vlMulta) {
		this.vlMulta = vlMulta;
	}

	public String getInformacaoAoPagador() {
		return informacaoAoPagador;
	}

	public void setInformacaoAoPagador(String informacaoAoPagador) {
		this.informacaoAoPagador = informacaoAoPagador;
	}

	public String getMensagem1() {
		return mensagem1;
	}

	public void setMensagem1(String mensagem1) {
		this.mensagem1 = mensagem1;
	}

	public String getMensagem2() {
		return mensagem2;
	}

	public void setMensagem2(String mensagem2) {
		this.mensagem2 = mensagem2;
	}

	public String getBrancos2() {
		return brancos2;
	}

	public void setBrancos2(String brancos2) {
		this.brancos2 = brancos2;
	}

	public Integer getCodigoOcorrenciaPagador() {
		return codigoOcorrenciaPagador;
	}

	public void setCodigoOcorrenciaPagador(Integer codigoOcorrenciaPagador) {
		this.codigoOcorrenciaPagador = codigoOcorrenciaPagador;
	}

	public Integer getBanco() {
		return banco;
	}

	public void setBanco(Integer banco) {
		this.banco = banco;
	}

	public Integer getAgenciaMantenedora() {
		return agenciaMantenedora;
	}

	public void setAgenciaMantenedora(Integer agenciaMantenedora) {
		this.agenciaMantenedora = agenciaMantenedora;
	}

	public String getDigitoVerificadorAgencia() {
		return digitoVerificadorAgencia;
	}

	public void setDigitoVerificadorAgencia(String digitoVerificadorAgencia) {
		this.digitoVerificadorAgencia = digitoVerificadorAgencia;
	}

	public Long getNumeroContaCorrente() {
		return numeroContaCorrente;
	}

	public void setNumeroContaCorrente(Long numeroContaCorrente) {
		this.numeroContaCorrente = numeroContaCorrente;
	}

	public String getDigitoVerificadorContaCorrente() {
		return DigitoVerificadorContaCorrente;
	}

	public void setDigitoVerificadorContaCorrente(String digitoVerificadorContaCorrente) {
		DigitoVerificadorContaCorrente = digitoVerificadorContaCorrente;
	}

	public String getDigitoVerificadorAgenciaConta() {
		return digitoVerificadorAgenciaConta;
	}

	public void setDigitoVerificadorAgenciaConta(String digitoVerificadorAgenciaConta) {
		this.digitoVerificadorAgenciaConta = digitoVerificadorAgenciaConta;
	}

	public Integer getEmissaoAvisoDebioAutomatico() {
		return emissaoAvisoDebioAutomatico;
	}

	public void setEmissaoAvisoDebioAutomatico(Integer emissaoAvisoDebioAutomatico) {
		this.emissaoAvisoDebioAutomatico = emissaoAvisoDebioAutomatico;
	}

	public String getBrancos3() {
		return brancos3;
	}

	public void setBrancos3(String brancos3) {
		this.brancos3 = brancos3;
	}

	public ContaBancaria getContaBancaria() {
		return contaBancaria;
	}

	public void setContaBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

	public List<RemessaCobranca> getRemessas() {
		return remessas;
	}

	public void setRemessas(List<RemessaCobranca> remessas) {
		this.remessas = remessas;
	}

	public static CobrancaSegmentoR of(ContaBancaria contaBancaria, List<RemessaCobranca> remessas) {
		return new CobrancaSegmentoR(contaBancaria, remessas);
	}

	public void set(br.com.anteros.flatfile.Record record) {

	}

}
