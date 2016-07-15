package br.com.anteros.integracao.bancaria.banco.layout.cnab200.extrato.bancobrasil;

import java.math.BigDecimal;
import java.util.Date;

import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.Formats;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.language.EnumTypes;
import br.com.anteros.integracao.bancaria.banco.layout.SaldoAtual;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.*;

public class SaldoAtualRetorno implements SaldoAtual {	
	
	@IdType(name = ID_TIPOREGISTRO, length = 1, positionField = 8, value = "2")
	private String tipoRegistro;
	
	@Field(name = CD_REGISTRO, length = 1, value = "1", type=EnumTypes.INTEGER)
	private Integer codigoRegistro;
	
	@Field(name=TP_TIPO_INSCRICAO, length=2)
	private String tipoInscricao;
	
	@Field(name=NR_INSCRICAO_EMPRESA, length=14)
	private String numeroInscricaoEmpresa;
	
	@Field(name=AGENCIA, length=4, type=EnumTypes.INTEGER)
	private Integer agencia;
	
	@Field(name="BRANCOS1", length=8, padding=Paddings.WHITE_SPACE_RIGHT)
	private String brancos1;
	
	@Field(name=NR_CONTACORRENTE, length=11, type=EnumTypes.INTEGER)
	private Integer numeroContaCorrente;
	
	@Field(name=DIGITO_CONTA_CORRENTE, length=1)
	private String digitoContaCorrente;
	
	@Field(name=SALDO_LIQUIDO_FUNDO_CURTOPRAZO, length=15, format=Formats.DECIMAL_DD, type=EnumTypes.BIGDECIMAL)
	private BigDecimal saldoLiquidoFundoCurtoPrazo;
	
	@Field(name=VALOR_CPMF, length=15, format=Formats.DECIMAL_DD, type=EnumTypes.BIGDECIMAL)
	private BigDecimal valorCPMF;
	
	@Field(name="BRANCOS2", length=4)
	private String brancos2;
	
	@Field(name=DT_SALDO_ATUAL, length=6, format=Formats.DATE_DDMMYY)
	private Date dataSaldoAtual;
	
	@Field(name=SALDO_ATUAL, length=16, format=Formats.DECIMAL_DD, type=EnumTypes.BIGDECIMAL)
	private BigDecimal saldoAtual;
	
	@Field(name=STATUS_SALDO_ATUAL, length=1)
	private String statusSaldoAtual;
	
	@Field(name=ESTAGIO_SALDO_ATUAL, length=1)
	private String estagioSaldoAtual;
	
	@Field(name=SALDO_LIQUIDO_COMMODITIES, length=15, format=Formats.DECIMAL_DD, type=EnumTypes.BIGDECIMAL)
	private BigDecimal saldoLiquidoFundoCommodities;
	
	@Field(name=JUROS_CAPITALIZADOS, length=13, format=Formats.DECIMAL_DD, type=EnumTypes.BIGDECIMAL)
	private BigDecimal jurosCapitalizados;
	
	@Field(name=IOF_CAPITALIZADOS, length=13, format=Formats.DECIMAL_DD, type=EnumTypes.BIGDECIMAL)
	private BigDecimal IOFCapitalizados;
	
	@Field(name=VL_LIMITE_CONTACORRENTE, length=9, format=Formats.DECIMAL_DD, type=EnumTypes.BIGDECIMAL)
	private BigDecimal valorLimiteContaCorrente;
	
	@Field(name="BRANCOS3", length=15)
	private String brancos3;
	
	@Field(name="BRANCOS4", length=2)
	private String brancos4;
	
	@Field(name="BRANCOS5", length=8)
	private String brancos5;
	
	@Field(name="BRANCOS6", length=2)
	private String brancos6;
	
	@Field(name="BRANCOS7", length=3)
	private String brancos7;
	
	@Field(name=NR_SEQUENCIAL_REGISTRO, length=6, padding=Paddings.ZERO_LEFT, type=EnumTypes.INTEGER)
	private Integer numeroSequencialRegistro;	
	
	
	public void set(br.com.anteros.flatfile.Record record) {
		setTipoInscricao((String) record.getValue(TP_TIPO_INSCRICAO));
		setNumeroInscricao((String) record.getValue(NR_INSCRICAO_EMPRESA));
		setAgencia((Integer) record.getValue(AGENCIA));
		setNumeroContaCorrente((Integer) record.getValue(NR_CONTACORRENTE));
		setDigitoContaCorrente((String) record.getValue(DIGITO_CONTA_CORRENTE));
		setSaldoLiquidoFundoCurtoPrazo((BigDecimal) record.getValue(SALDO_LIQUIDO_FUNDO_CURTOPRAZO));
		setValorCPMF((BigDecimal) record.getValue(VALOR_CPMF));
		setDataSaldoAtual((Date) record.getValue(DT_SALDO_ATUAL));
		setSaldoAtual((BigDecimal) record.getValue(SALDO_ATUAL));
		setStatusSaldoAtual((String) record.getValue(STATUS_SALDO_ATUAL));
		setEstagioSaldoAtual((String) record.getValue(ESTAGIO_SALDO_ATUAL));
		setSaldoLiquidoFundoCommodities((BigDecimal) record.getValue(SALDO_LIQUIDO_COMMODITIES));
		setJurosCapitalizados((BigDecimal) record.getValue(JUROS_CAPITALIZADOS));
		setIOFCapitalizados((BigDecimal) record.getValue(IOF_CAPITALIZADOS));
		setValorLimiteContaCorrente((BigDecimal) record.getValue(VL_LIMITE_CONTACORRENTE));
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
		return numeroInscricaoEmpresa;
	}


	public void setNumeroInscricao(String numeroInscricao) {
		this.numeroInscricaoEmpresa = numeroInscricao;
	}


	public Integer getAgencia() {
		return agencia;
	}


	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}


	public Integer getNumeroContaCorrente() {
		return numeroContaCorrente;
	}


	public void setNumeroContaCorrente(Integer numeroContaCorrente) {
		this.numeroContaCorrente = numeroContaCorrente;
	}


	public String getDigitoContaCorrente() {
		return digitoContaCorrente;
	}


	public void setDigitoContaCorrente(String digitoContaCorrente) {
		this.digitoContaCorrente = digitoContaCorrente;
	}


	public BigDecimal getSaldoLiquidoFundoCurtoPrazo() {
		return saldoLiquidoFundoCurtoPrazo;
	}


	public void setSaldoLiquidoFundoCurtoPrazo(BigDecimal saldoLiquidoFundoCurtoPrazo) {
		this.saldoLiquidoFundoCurtoPrazo = saldoLiquidoFundoCurtoPrazo;
	}


	public BigDecimal getValorCPMF() {
		return valorCPMF;
	}


	public void setValorCPMF(BigDecimal valorCPMF) {
		this.valorCPMF = valorCPMF;
	}


	public Date getDataSaldoAtual() {
		return dataSaldoAtual;
	}


	public void setDataSaldoAtual(Date dataSaldoAtual) {
		this.dataSaldoAtual = dataSaldoAtual;
	}


	public BigDecimal getSaldoAtual() {
		return saldoAtual;
	}


	public void setSaldoAtual(BigDecimal saldoAtual) {
		this.saldoAtual = saldoAtual;
	}


	public String getStatusSaldoAtual() {
		return statusSaldoAtual;
	}


	public void setStatusSaldoAtual(String statusSaldoAtual) {
		this.statusSaldoAtual = statusSaldoAtual;
	}


	public String getEstagioSaldoAtual() {
		return estagioSaldoAtual;
	}


	public void setEstagioSaldoAtual(String estagioSaldoAtual) {
		this.estagioSaldoAtual = estagioSaldoAtual;
	}


	public BigDecimal getSaldoLiquidoFundoCommodities() {
		return saldoLiquidoFundoCommodities;
	}


	public void setSaldoLiquidoFundoCommodities(BigDecimal saldoLiquidoFundoCommodities) {
		this.saldoLiquidoFundoCommodities = saldoLiquidoFundoCommodities;
	}


	public BigDecimal getJurosCapitalizados() {
		return jurosCapitalizados;
	}


	public void setJurosCapitalizados(BigDecimal jurosCapitalizados) {
		this.jurosCapitalizados = jurosCapitalizados;
	}


	public BigDecimal getIOFCapitalizados() {
		return IOFCapitalizados;
	}


	public void setIOFCapitalizados(BigDecimal iOFCapitalizados) {
		IOFCapitalizados = iOFCapitalizados;
	}


	public BigDecimal getValorLimiteContaCorrente() {
		return valorLimiteContaCorrente;
	}


	public void setValorLimiteContaCorrente(BigDecimal valorLimiteContaCorrente) {
		this.valorLimiteContaCorrente = valorLimiteContaCorrente;
	}


	public Integer getNumeroSequencialRegistro() {
		return numeroSequencialRegistro;
	}


	public void setNumeroSequencialRegistro(Integer numeroSequencialRegistro) {
		this.numeroSequencialRegistro = numeroSequencialRegistro;
	}

}
