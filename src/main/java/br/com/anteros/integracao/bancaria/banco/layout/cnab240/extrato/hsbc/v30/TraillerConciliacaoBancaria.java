package br.com.anteros.integracao.bancaria.banco.layout.cnab240.extrato.hsbc.v30;

import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.AGENCIA_MANTENEDORA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CD_BANCO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CD_CONVENIO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.DIGITO_AGENCIA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.DIGITO_AGENCIACONTA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.DIGITO_CONTACORRENTE;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.DT_SALDO_ATUAL;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.LT_SERVICO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NOME_EMPRESA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NR_CONTACORRENTE;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NR_INSCRICAO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.QT_REGISTROS_LOTE;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.SALDO_ATUAL;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.SALDO_BLOQUEADO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.SITUACAO_SALDO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.STATUS_SALDO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.TP_INSCRICAO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.TP_REGISTRO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.VL_LIMITE_CONTACORRENTE;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.VL_TOTAL_CREDITOS;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.VL_TOTAL_DEBITOS;

import java.math.BigDecimal;
import java.util.Date;

import br.com.anteros.flatfile.Record;
import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.Formats;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.language.EnumTypes;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.SaldoAtual;

public class TraillerConciliacaoBancaria implements SaldoAtual {

	@IdType(name = TP_REGISTRO, length = 1, positionField = 3, value = "5")
	private String tipoRegistro;

	@Field(name = CD_BANCO, length = 3, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoBanco;

	@Field(name = LT_SERVICO, length = 4, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer loteServico;

	@Field(name = "BRANCOS_1", length = 9, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos1;

	@Field(name = TP_INSCRICAO, length = 1, type = EnumTypes.INTEGER)
	private Integer tipoInscricao;

	@Field(name = NR_INSCRICAO, length = 14, padding = Paddings.ZERO_LEFT)
	private String numeroInscricao;

	@Field(name = CD_CONVENIO, length = 20, padding = Paddings.WHITE_SPACE_RIGHT)
	private String codigoConvenio;

	@Field(name = AGENCIA_MANTENEDORA, length = 5, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer agenciaMantenedora;

	@Field(name = DIGITO_AGENCIA, length = 1)
	private String digitoVerificadorAgencia;

	@Field(name = NR_CONTACORRENTE, length = 12, type = EnumTypes.LONG, padding = Paddings.ZERO_LEFT)
	private Long numeroContaCorrente;

	@Field(name = DIGITO_CONTACORRENTE, length = 1)
	private String digitoVerificadorContaCorrente;

	@Field(name = DIGITO_AGENCIACONTA, length = 1)
	private String digitoVerificadorAgenciaConta;

	@Field(name = NOME_EMPRESA, length = 30)
	private String nomeEmpresa;

	@Field(name = "BRANCOS_2", length = 4, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos2;

	@Field(name = VL_LIMITE_CONTACORRENTE, length = 18, format = Formats.DECIMAL_DD, type = EnumTypes.BIGDECIMAL)
	private BigDecimal limiteContaCorrente;

	@Field(name = SALDO_BLOQUEADO, length = 18, format = Formats.DECIMAL_DD, type = EnumTypes.BIGDECIMAL)
	private BigDecimal saldoBloqueado;

	@Field(name = DT_SALDO_ATUAL, length = 8, format = Formats.DATE_DDMMYYYY, type = EnumTypes.DATE)
	private Date dataSaldoAtual;

	@Field(name = SALDO_ATUAL, length = 18, format = Formats.DECIMAL_DD, type = EnumTypes.BIGDECIMAL)
	private BigDecimal saldoAtual;

	@Field(name = SITUACAO_SALDO, length = 1)
	private String situacaoSaldo;

	@Field(name = STATUS_SALDO, length = 1)
	private String statusSaldo;

	@Field(name = QT_REGISTROS_LOTE, length = 6, type = EnumTypes.INTEGER)
	private Integer quantidadeRegistrosLote;

	@Field(name = VL_TOTAL_DEBITOS, length = 18, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD)
	private BigDecimal valorTotalDebitos;

	@Field(name = VL_TOTAL_CREDITOS, length = 18, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD)
	private BigDecimal valorTotalCreditos;

	@Field(name = "BRANCOS_3", length = 28, value = " ")
	private String brancos3;

	private ContaBancaria contaBancaria;

	public TraillerConciliacaoBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

	public void set(Record record) {
		setCodigoBanco((Integer) record.getValue(CD_BANCO));
		setLoteServico((Integer) record.getValue(LT_SERVICO));
		setTipoInscricao((Integer) record.getValue(TP_INSCRICAO));
		setNumeroInscricao((String) record.getValue(NR_INSCRICAO));
		setCodigoConvenio((String) record.getValue(CD_CONVENIO));
		setAgenciaMantenedora((Integer) record.getValue(AGENCIA_MANTENEDORA));
		setDigitoVerificadorAgencia((String) record.getValue(DIGITO_AGENCIA));
		setNumeroContaCorrente((Long) record.getValue(NR_CONTACORRENTE));
		setDigitoVerificadorContaCorrente((String) record.getValue(DIGITO_CONTACORRENTE));
		setDigitoVerificadorAgenciaConta((String) record.getValue(DIGITO_AGENCIACONTA));
		setDataSaldoAtual((Date) record.getValue(DT_SALDO_ATUAL));
		setSaldoAtual((BigDecimal) record.getValue(SALDO_ATUAL));
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

	public Long getNumeroContaCorrente() {
		return numeroContaCorrente;
	}

	public void setNumeroContaCorrente(Long numeroContaCorrente) {
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

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public BigDecimal getLimiteContaCorrente() {
		return limiteContaCorrente;
	}

	public void setLimiteContaCorrente(BigDecimal limiteContaCorrente) {
		this.limiteContaCorrente = limiteContaCorrente;
	}

	public String getSituacaoSaldo() {
		return situacaoSaldo;
	}

	public void setSituacaoSaldo(String situacaoSaldo) {
		this.situacaoSaldo = situacaoSaldo;
	}

	public String getStatusSaldo() {
		return statusSaldo;
	}

	public void setStatusSaldo(String statusSaldo) {
		this.statusSaldo = statusSaldo;
	}

	public void setSaldoBloqueado(BigDecimal saldoBloqueado) {
		this.saldoBloqueado = saldoBloqueado;
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

	@Override
	public BigDecimal getSaldoBloqueado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDebitoCredito() {
		// TODO Auto-generated method stub
		return null;
	}

}
