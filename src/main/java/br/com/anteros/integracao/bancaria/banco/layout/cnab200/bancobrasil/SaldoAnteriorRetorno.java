package br.com.anteros.integracao.bancaria.banco.layout.cnab200.bancobrasil;

import java.math.BigDecimal;
import java.util.Date;

import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.Formats;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.language.EnumTypes;
import br.com.anteros.integracao.bancaria.banco.layout.SaldoAnterior;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.*;

public class SaldoAnteriorRetorno implements SaldoAnterior {	

	@IdType(name = ID_TIPOREGISTRO, length = 1, positionField = 8, value = "0")
	private String tipoRegistro;

	@Field(name = CD_REGISTRO, length = 1, value = "1", type = EnumTypes.INTEGER)
	private Integer codigoRegistro;

	@Field(name = TP_TIPO_INSCRICAO, length = 2)
	private String tipoInscricao;

	@Field(name = NR_INSCRICAO_EMPRESA, length = 14)
	private String numeroInscricao;

	@Field(name = AGENCIA, length = 4, type = EnumTypes.INTEGER)
	private Integer agencia;

	@Field(name = "BRANCOS1", length = 8, padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos1;

	@Field(name = NR_CONTACORRENTE, length = 11, type = EnumTypes.INTEGER)
	private Integer codigoContaCorrente;

	@Field(name = DIGITO_CONTA_CORRENTE, length = 1)
	private String digitoContaCorrente;

	@Field(name = VL_BLOQUEADO, length = 15, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD)
	private BigDecimal valorBloqueado;

	@Field(name = CD_CONVENIO, length = 9)
	private String codigoConvenio;

	@Field(name = NR_ORDEM_EXTRATO, length = 3, type = EnumTypes.INTEGER)
	private Integer nrOrdemExtrato;

	@Field(name = "BRANCOS3", length = 9)
	private String brancos3;

	@Field(name = DT_SALDO_ANTERIOR, length = 6, type = EnumTypes.DATE, format = Formats.DATE_DDMMYY)
	private Date dataSaldoAnterior;

	@Field(name = VL_SALDO_ANTERIOR, length = 16, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD)
	private BigDecimal valorSaldoAnterior;

	@Field(name = STATUS_CONTA, length = 1)
	private String statusConta;

	@Field(name = VL_TOTAL_BLOQUEADO_04_09, length = 15, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD)
	private BigDecimal valorTotalBloqueado04A09Dias;

	@Field(name = VL_TOTAL_BLOQUEADO_03, length = 15, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD)
	private BigDecimal valorTotalBloqueado03Dias;

	@Field(name = VL_TOTAL_BLOQUEADO_02, length = 15, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD)
	private BigDecimal valorTotalBloqueado02Dias;

	@Field(name = VL_TOTAL_BLOQUEADO_01, length = 15, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD)
	private BigDecimal valorTotalBloqueado01Dia;

	@Field(name = "BRANCOS4", length = 8)
	private String brancos4;

	@Field(name = "BRANCOS5", length = 8)
	private String brancos5;

	@Field(name = "BRANCOS6", length = 2)
	private String brancos6;

	@Field(name = "BRANCOS7", length = 3)
	private String brancos7;

	@Field(name = NR_SEQUENCIAL_REGISTRO, length = 6, padding = Paddings.ZERO_LEFT, type = EnumTypes.INTEGER)
	private Integer numeroSequencialRegistro;

	public void set(br.com.anteros.flatfile.Record record) {

		setTipoInscricao((String) record.getValue(TP_TIPO_INSCRICAO));
		setNumeroInscricao((String) record.getValue(NR_INSCRICAO_EMPRESA));
		setAgencia((Integer) record.getValue(AGENCIA));
		setCodigoContaCorrente((Integer) record.getValue(NR_CONTACORRENTE));
		setDigitoContaCorrente((String) record.getValue(DIGITO_CONTA_CORRENTE));
		setValorBloqueado((BigDecimal) record.getValue(VL_BLOQUEADO));
		setCodigoConvenio((String) record.getValue(CD_CONVENIO));
		setNrOrdemExtrato((Integer) record.getValue(NR_ORDEM_EXTRATO));
		setDataSaldoAnterior((Date) record.getValue(DT_SALDO_ANTERIOR));
		setValorSaldoAnterior((BigDecimal) record.getValue(VL_SALDO_ANTERIOR));
		setStatusConta((String) record.getValue(STATUS_CONTA));
		setValorTotalBloqueado04A09Dias((BigDecimal) record.getValue(VL_TOTAL_BLOQUEADO_04_09));
		setValorTotalBloqueado03Dias((BigDecimal) record.getValue(VL_TOTAL_BLOQUEADO_03));
		setValorTotalBloqueado02Dias((BigDecimal) record.getValue(VL_TOTAL_BLOQUEADO_02));
		setValorTotalBloqueado01Dia((BigDecimal) record.getValue(VL_TOTAL_BLOQUEADO_01));
		setNumeroSequencialRegistro((Integer) record.getValue(NR_SEQUENCIAL_REGISTRO));

	}

	public String getTipoRegistro() {
		return tipoRegistro;
	}

	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public Integer getCodigoRegistro() {
		return codigoRegistro;
	}

	public void setCodigoRegistro(Integer codigoRegistro) {
		this.codigoRegistro = codigoRegistro;
	}

	public String getTipoInscricao() {
		return tipoInscricao;
	}

	public void setTipoInscricao(String tipoInscricao) {
		this.tipoInscricao = tipoInscricao;
	}

	public String getNumeroInscricao() {
		return numeroInscricao;
	}

	public void setNumeroInscricao(String numeroInscricao) {
		this.numeroInscricao = numeroInscricao;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public Integer getCodigoContaCorrente() {
		return codigoContaCorrente;
	}

	public void setCodigoContaCorrente(Integer codigoContaCorrente) {
		this.codigoContaCorrente = codigoContaCorrente;
	}

	public String getDigitoContaCorrente() {
		return digitoContaCorrente;
	}

	public void setDigitoContaCorrente(String digitoContaCorrente) {
		this.digitoContaCorrente = digitoContaCorrente;
	}

	public BigDecimal getValorBloqueado() {
		return valorBloqueado;
	}

	public void setValorBloqueado(BigDecimal valorBloqueado) {
		this.valorBloqueado = valorBloqueado;
	}

	public String getCodigoConvenio() {
		return codigoConvenio;
	}

	public void setCodigoConvenio(String codigoConvenio) {
		this.codigoConvenio = codigoConvenio;
	}

	public Integer getNrOrdemExtrato() {
		return nrOrdemExtrato;
	}

	public void setNrOrdemExtrato(Integer nrOrdemExtrato) {
		this.nrOrdemExtrato = nrOrdemExtrato;
	}

	public Date getDataSaldoAnterior() {
		return dataSaldoAnterior;
	}

	public void setDataSaldoAnterior(Date dataSaldoAnterior) {
		this.dataSaldoAnterior = dataSaldoAnterior;
	}

	public BigDecimal getValorSaldoAnterior() {
		return valorSaldoAnterior;
	}

	public void setValorSaldoAnterior(BigDecimal valorSaldoAnterior) {
		this.valorSaldoAnterior = valorSaldoAnterior;
	}

	public String getStatusConta() {
		return statusConta;
	}

	public void setStatusConta(String statusConta) {
		this.statusConta = statusConta;
	}

	public BigDecimal getValorTotalBloqueado04A09Dias() {
		return valorTotalBloqueado04A09Dias;
	}

	public void setValorTotalBloqueado04A09Dias(BigDecimal valorTotalBloqueado04A09Dias) {
		this.valorTotalBloqueado04A09Dias = valorTotalBloqueado04A09Dias;
	}

	public BigDecimal getValorTotalBloqueado03Dias() {
		return valorTotalBloqueado03Dias;
	}

	public void setValorTotalBloqueado03Dias(BigDecimal valorTotalBloqueado03Dias) {
		this.valorTotalBloqueado03Dias = valorTotalBloqueado03Dias;
	}

	public BigDecimal getValorTotalBloqueado02Dias() {
		return valorTotalBloqueado02Dias;
	}

	public void setValorTotalBloqueado02Dias(BigDecimal valorTotalBloqueado02Dias) {
		this.valorTotalBloqueado02Dias = valorTotalBloqueado02Dias;
	}

	public BigDecimal getValorTotalBloqueado01Dia() {
		return valorTotalBloqueado01Dia;
	}

	public void setValorTotalBloqueado01Dia(BigDecimal valorTotalBloqueado01Dia) {
		this.valorTotalBloqueado01Dia = valorTotalBloqueado01Dia;
	}

	public Integer getNumeroSequencialRegistro() {
		return numeroSequencialRegistro;
	}

	public void setNumeroSequencialRegistro(Integer numeroSequencialRegistro) {
		this.numeroSequencialRegistro = numeroSequencialRegistro;
	}

}
