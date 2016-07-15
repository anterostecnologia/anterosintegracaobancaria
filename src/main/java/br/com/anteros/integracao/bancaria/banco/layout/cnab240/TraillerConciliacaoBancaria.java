package br.com.anteros.integracao.bancaria.banco.layout.cnab240;

import java.math.BigDecimal;
import java.util.Date;

import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.Formats;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.language.EnumTypes;
import br.com.anteros.flatfile.type.component.Record;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;

import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.*;

public class TraillerConciliacaoBancaria {

	@IdType(name = TP_REGISTRO, length = 1, positionField = 3, value = "5")
	private String tipoRegistro;

	@Field(name = CD_BANCO, length = 3, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoBanco;

	@Field(name = LT_SERVICO, length = 4, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer loteServico;

	@Field(name = "BRANCOS1", length = 9, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos1;

	@Field(name = TP_INSCRICAO, length = 1, type = EnumTypes.INTEGER)
	private Integer tipoInscricao;

	@Field(name = NR_INSCRICAO, length = 15, padding = Paddings.ZERO_LEFT)
	private String numeroInscricao;

	@Field(name = CD_CONVENIO, length = 20, padding = Paddings.WHITE_SPACE_RIGHT)
	private String codigoConvenio;

	@Field(name = AGENCIA_MANTENEDORA, length = 5, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer agenciaMantenedora;

	@Field(name = DIGITO_AGENCIA, length = 1)
	private String digitoVerificadorAgencia;

	@Field(name = NR_CONTACORRENTE, length = 12, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer numeroContaCorrente;

	@Field(name = DIGITO_CONTACORRENTE, length = 1)
	private String digitoVerificadorContaCorrente;

	@Field(name = DIGITO_AGENCIACONTA, length = 1)
	private String digitoVerificadorAgenciaConta;

	@Field(name = "BRANCOS3", length = 16, value = " ")
	private String brancos3;

	@Field(name = SALDO_BLOQUEADO, length = 16, format = Formats.DECIMAL_DD, type = EnumTypes.BIGDECIMAL)
	private BigDecimal saldoBloqueado;

	@Field(name = DT_SALDO_ATUAL, length = 6, format = Formats.DATE_DDMMYY)
	private Date dataSaldoAtual;

	@Field(name = SALDO_ATUAL, length = 16, format = Formats.DECIMAL_DD, type = EnumTypes.BIGDECIMAL)
	private BigDecimal saldoAtual;

	@Field(name = DEBITO_CREDITO, length = 1)
	private String debitoCredito;

	@Field(name = "BRANCOS4", length = 1, value = " ")
	private String brancos4;

	@Field(name = QT_REGISTROS_LOTE, length = 6, type = EnumTypes.INTEGER)
	private Integer quantidadeRegistrosLote;

	@Field(name = VL_TOTAL_DEBITOS, length = 16, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD)
	private BigDecimal valorTotalDebitos;

	@Field(name = VL_TOTAL_CREDITOS, length = 16, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD)
	private BigDecimal valorTotalCreditos;
	
	@Field(name = "BRANCOS5", length = 28, value = " ")
	private String brancos5;

	private ContaBancaria contaBancaria;
	
	
	public TraillerConciliacaoBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

	public void set(Record record){
		setCodigoBanco((Integer) record.getValue(CD_BANCO));
		setLoteServico((Integer) record.getValue(LT_SERVICO));
		setTipoInscricao((Integer) record.getValue(TP_INSCRICAO));
		setNumeroInscricao((String) record.getValue(NR_INSCRICAO));
		setCodigoConvenio((String) record.getValue(CD_CONVENIO));
		setAgenciaMantenedora((Integer) record.getValue(AGENCIA_MANTENEDORA));
		setDigitoVerificadorAgencia((String) record.getValue(DIGITO_AGENCIA));
		setNumeroContaCorrente((Integer) record.getValue(NR_CONTACORRENTE));
		setDigitoVerificadorContaCorrente((String) record.getValue(DIGITO_CONTACORRENTE));
		setDigitoVerificadorAgenciaConta((String) record.getValue(DIGITO_AGENCIACONTA));
		setSaldoBloqueado((BigDecimal) record.getValue(SALDO_BLOQUEADO));
		setDataSaldoAtual((Date) record.getValue(DT_SALDO_ATUAL));
		setSaldoAtual((BigDecimal) record.getValue(SALDO_ATUAL));
		setDebitoCredito((String) record.getValue(DEBITO_CREDITO));
		setQuantidadeRegistrosLote((Integer) record.getValue(QT_REGISTROS_LOTE));
		setValorTotalDebitos((BigDecimal) record.getValue(VL_TOTAL_DEBITOS));
		setValorTotalCreditos((BigDecimal) record.getValue(VL_TOTAL_CREDITOS));
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

	public Integer getTipoInscricao() {
		return tipoInscricao;
	}

	public void setTipoInscricao(Integer tipoInscricao) {
		this.tipoInscricao = tipoInscricao;
	}

	public String getNumeroInscricao() {
		return numeroInscricao;
	}

	public void setNumeroInscricao(String numeroInscricao) {
		this.numeroInscricao = numeroInscricao;
	}

	public String getCodigoConvenio() {
		return codigoConvenio;
	}

	public void setCodigoConvenio(String codigoConvenio) {
		this.codigoConvenio = codigoConvenio;
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

	public Integer getNumeroContaCorrente() {
		return numeroContaCorrente;
	}

	public void setNumeroContaCorrente(Integer numeroContaCorrente) {
		this.numeroContaCorrente = numeroContaCorrente;
	}

	public String getDigitoVerificadorContaCorrente() {
		return digitoVerificadorContaCorrente;
	}

	public void setDigitoVerificadorContaCorrente(String digitoVerificadorContaCorrente) {
		this.digitoVerificadorContaCorrente = digitoVerificadorContaCorrente;
	}

	public String getDigitoVerificadorAgenciaConta() {
		return digitoVerificadorAgenciaConta;
	}

	public void setDigitoVerificadorAgenciaConta(String digitoVerificadorAgenciaConta) {
		this.digitoVerificadorAgenciaConta = digitoVerificadorAgenciaConta;
	}

	public BigDecimal getSaldoBloqueado() {
		return saldoBloqueado;
	}

	public void setSaldoBloqueado(BigDecimal saldoBloqueado) {
		this.saldoBloqueado = saldoBloqueado;
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

	public String getDebitoCredito() {
		return debitoCredito;
	}

	public void setDebitoCredito(String debitoCredito) {
		this.debitoCredito = debitoCredito;
	}

	public Integer getQuantidadeRegistrosLote() {
		return quantidadeRegistrosLote;
	}

	public void setQuantidadeRegistrosLote(Integer quantidadeRegistrosLote) {
		this.quantidadeRegistrosLote = quantidadeRegistrosLote;
	}

	public BigDecimal getValorTotalDebitos() {
		return valorTotalDebitos;
	}

	public void setValorTotalDebitos(BigDecimal valorTotalDebitos) {
		this.valorTotalDebitos = valorTotalDebitos;
	}

	public BigDecimal getValorTotalCreditos() {
		return valorTotalCreditos;
	}

	public void setValorTotalCreditos(BigDecimal valorTotalCreditos) {
		this.valorTotalCreditos = valorTotalCreditos;
	}

	public static TraillerConciliacaoBancaria of(ContaBancaria contaBancaria) {
		return new TraillerConciliacaoBancaria(contaBancaria);
	}

}
