package br.com.anteros.integracao.bancaria.banco.layout.cnab200.extrato.bradesco;

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
	
	@Field(name="BRANCOS2", length=38)
	private String brancos2;
	
	@Field(name=DT_SALDO_ATUAL, length=6, format=Formats.DATE_DDMMYY)
	private Date dataSaldoAtual;
	
	@Field(name=SALDO_ATUAL, length=16, format=Formats.DECIMAL_DD, type=EnumTypes.BIGDECIMAL)
	private BigDecimal saldoAtual;
	
	@Field(name = DEBITO_CREDITO, length = 1)
	private String debitoCredito;
	
	@Field(name="BRANCOS3", length=1)
	private String brancos3;
	
	@Field(name="BRANCOS4", length=18)
	private String brancos4;
	
	@Field(name="BRANCOS5", length=1)
	private String brancos5;
	
	@Field(name="BRANCOS6", length=8)
	private String brancos6;
	
	@Field(name="BRANCOS7", length=14)
	private String brancos7;
	
	@Field(name="BRANCOS8", length=3)
	private String brancos8;
	
	@Field(name="BRANCOS9", length=2)
	private String brancos9;
	
	@Field(name = CD_BANCO, length = 3, type = EnumTypes.INTEGER)
	private Integer codigoBanco;
	
	@Field(name=NR_SEQUENCIAL_REGISTRO, length=6, padding=Paddings.ZERO_LEFT, type=EnumTypes.INTEGER)
	private Integer numeroSequencialRegistro;	
	
	
	public void set(br.com.anteros.flatfile.Record record) {
		setTipoInscricao((String) record.getValue(TP_TIPO_INSCRICAO));
		setNumeroInscricao((String) record.getValue(NR_INSCRICAO_EMPRESA));
		setAgencia((Integer) record.getValue(AGENCIA));
		setNumeroContaCorrente((Integer) record.getValue(NR_CONTACORRENTE));
		setDigitoContaCorrente((String) record.getValue(DIGITO_CONTA_CORRENTE));
		setDataSaldoAtual((Date) record.getValue(DT_SALDO_ATUAL));
		setSaldoAtual((BigDecimal) record.getValue(SALDO_ATUAL));
		setDebitoCredito((String) record.getValue(DEBITO_CREDITO));
		setCodigoRegistro((Integer) record.getValue(CD_BANCO));
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

	public Integer getNumeroSequencialRegistro() {
		return numeroSequencialRegistro;
	}


	public void setNumeroSequencialRegistro(Integer numeroSequencialRegistro) {
		this.numeroSequencialRegistro = numeroSequencialRegistro;
	}


	public String getNumeroInscricaoEmpresa() {
		return numeroInscricaoEmpresa;
	}


	public void setNumeroInscricaoEmpresa(String numeroInscricaoEmpresa) {
		this.numeroInscricaoEmpresa = numeroInscricaoEmpresa;
	}


	public String getDebitoCredito() {
		return debitoCredito;
	}


	public void setDebitoCredito(String debitoCredito) {
		this.debitoCredito = debitoCredito;
	}


	public Integer getCodigoBanco() {
		return codigoBanco;
	}


	public void setCodigoBanco(Integer codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

}
