package br.com.anteros.integracao.bancaria.banco.layout.cnab200.extrato.bradesco;

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
	
	@Field(name=NR_LOTE, length=5, type=EnumTypes.INTEGER)
	private Integer numeroLote;
	
	@Field(name="BRANCOS2", length=33)
	private String brancos2;
	
	@Field(name = DT_SALDO_ANTERIOR, length = 6, type = EnumTypes.DATE, format = Formats.DATE_DDMMYY)
	private Date dataSaldoAnterior;
	
	@Field(name = VL_SALDO_ANTERIOR, length = 18, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD)
	private BigDecimal valorSaldoAnterior;
	
	@Field(name = DEBITO_CREDITO, length = 1)
	private String debitoCredito;
	
	@Field(name = "BRANCOS3", length = 59)
	private String brancos3;
	
	@Field(name = "BRANCOS4", length = 8)
	private String brancos4;
	
	@Field(name = "BRANCOS5", length = 14)
	private String brancos5;
	
	@Field(name = "BRANCOS6", length = 3)
	private String brancos6;
	
	@Field(name = "BRANCOS7", length = 2)
	private String brancos7;	
	
	@Field(name = CD_BANCO, length = 3, type = EnumTypes.INTEGER)
	private Integer codigoBanco;

	@Field(name = NR_SEQUENCIAL_REGISTRO, length = 6, padding = Paddings.ZERO_LEFT, type = EnumTypes.INTEGER)
	private Integer numeroSequencialRegistro;

	public void set(br.com.anteros.flatfile.Record record) {

		setTipoInscricao((String) record.getValue(TP_TIPO_INSCRICAO));
		setNumeroInscricao((String) record.getValue(NR_INSCRICAO_EMPRESA));
		setAgencia((Integer) record.getValue(AGENCIA));
		setCodigoContaCorrente((Integer) record.getValue(NR_CONTACORRENTE));
		setDigitoContaCorrente((String) record.getValue(DIGITO_CONTA_CORRENTE));
		setNumeroLote((Integer) record.getValue(NR_LOTE));
		setDataSaldoAnterior((Date) record.getValue(DT_SALDO_ANTERIOR));
		setValorSaldoAnterior((BigDecimal) record.getValue(VL_SALDO_ANTERIOR));
		setDebitoCredito((String) record.getValue(DEBITO_CREDITO));
		setCodigoBanco((Integer) record.getValue(CD_BANCO));
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
		return debitoCredito;
	}

	public void setDebitoCredito(String debitoCredito) {
		this.debitoCredito = debitoCredito;
	}

	public Integer getNumeroSequencialRegistro() {
		return numeroSequencialRegistro;
	}

	public void setNumeroSequencialRegistro(Integer numeroSequencialRegistro) {
		this.numeroSequencialRegistro = numeroSequencialRegistro;
	}

	public Integer getNumeroLote() {
		return numeroLote;
	}

	public void setNumeroLote(Integer numeroLote) {
		this.numeroLote = numeroLote;
	}

	public Integer getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(Integer codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

}
