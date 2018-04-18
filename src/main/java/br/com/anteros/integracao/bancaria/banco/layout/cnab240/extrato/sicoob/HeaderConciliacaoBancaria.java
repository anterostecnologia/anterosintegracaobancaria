package br.com.anteros.integracao.bancaria.banco.layout.cnab240.extrato.sicoob;

import java.math.BigDecimal;
import java.util.Date;

import br.com.anteros.flatfile.Record;
import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.Formats;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.language.EnumTypes;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.SaldoAnterior;

import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.*;

public class HeaderConciliacaoBancaria implements SaldoAnterior {

	@IdType(name = TP_REGISTRO, length = 1, positionField = 3, value = "1")
	private String tipoRegistro;

	@Field(name = CD_BANCO, length = 3, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoBanco;

	@Field(name = LT_SERVICO, length = 4, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer loteServico;

	@Field(name = TP_OPERACAO, length = 1, value = "E")
	private String tipoOperacao;

	@Field(name = TP_SERVICO, length = 2, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT, value = "04")
	private Integer tipoServico;

	@Field(name = TP_LANCAMENTO, length = 2, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer formaLancamento;

	@Field(name = LAYOUT_LOTE, length = 3, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT, value="033")
	private Integer layoutLote;

	@Field(name = BRANCOS_1, length = 1, value = " ")
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

	@Field(name = NR_CONTACORRENTE, length = 12)
	private String numeroContaCorrente;

	@Field(name = DIGITO_CONTACORRENTE, length = 1)
	private String digitoVerificadorContaCorrente;

	@Field(name = DIGITO_AGENCIACONTA, length = 1)
	private String digitoVerificadorAgenciaConta;

	@Field(name = NOME_EMPRESA, length = 30, padding = Paddings.WHITE_SPACE_RIGHT)
	private String nomeEmpresa;

	@Field(name = BRANCOS_2, length = 40, value = " ")
	private String brancos2;

	@Field(name = DT_SALDO_ANTERIOR, length = 8, format = Formats.DATE_DDMMYYYY, type=EnumTypes.DATE)
	private Date dataSaldoAnterior;

	@Field(name = VL_SALDO_ANTERIOR, length = 18, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD)
	private BigDecimal valorSaldoAnterior;

	@Field(name = DEBITO_CREDITO, length = 1)
	private String situacaoSaldoDebitoCredito;
	
	@Field(name = POSICAO_SALDO, length = 1)
	private String posicaoSaldoInicial;

	@Field(name = TP_MOEDA, length = 3)
	private String tipoMoeda;

	@Field(name = NR_SEQUENCIA_EXTRATO, length = 5, type = EnumTypes.INTEGER)
	private Integer numeroSequenciaExtrato;

	@Field(name = BRANCOS_3, length = 62, value = " ")
	private String brancos3;

	private ContaBancaria contaBancaria;

	public HeaderConciliacaoBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

	public void set(Record record) {
		setCodigoBanco((Integer) record.getValue(CD_BANCO));
		setLoteServico((Integer) record.getValue(LT_SERVICO));
		setTipoServico((Integer) record.getValue(TP_SERVICO));
		setLayoutLote((Integer) record.getValue(LAYOUT_LOTE));
		setTipoInscricao((Integer) record.getValue(TP_INSCRICAO));
		setNumeroInscricao((String) record.getValue(NR_INSCRICAO));
		setCodigoConvenio((String) record.getValue(CD_CONVENIO));
		setAgenciaMantenedora((Integer) record.getValue(AGENCIA_MANTENEDORA));
		setDigitoVerificadorAgencia((String) record.getValue(DIGITO_AGENCIA));
		setNumeroContaCorrente((String) record.getValue(NR_CONTACORRENTE));
		setDigitoVerificadorContaCorrente((String) record.getValue(DIGITO_CONTACORRENTE));
		setDigitoVerificadorAgenciaConta((String) record.getValue(DIGITO_AGENCIACONTA));
		setNomeEmpresa((String) record.getValue(NOME_EMPRESA));
		setDataSaldoAnterior((Date) record.getValue(DT_SALDO_ANTERIOR));
		setValorSaldoAnterior((BigDecimal) record.getValue(VL_SALDO_ANTERIOR));
		setSituacaoSaldoDebitoCredito((String) record.getValue(DEBITO_CREDITO));
		setTipoMoeda((String) record.getValue(TP_MOEDA));
		setNumeroSequenciaExtrato((Integer) record.getValue(NR_SEQUENCIA_EXTRATO));
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

	public String getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(String tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	public Integer getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(Integer tipoServico) {
		this.tipoServico = tipoServico;
	}

	public Integer getLayoutLote() {
		return layoutLote;
	}

	public void setLayoutLote(Integer layoutLote) {
		this.layoutLote = layoutLote;
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

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
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

	public Integer getFormaLancamento() {
		return formaLancamento;
	}

	public void setFormaLancamento(Integer formaLancamento) {
		this.formaLancamento = formaLancamento;
	}

	public String getSituacaoSaldoDebitoCredito() {
		return situacaoSaldoDebitoCredito;
	}

	public void setSituacaoSaldoDebitoCredito(String situacaoSaldoDebitoCredito) {
		this.situacaoSaldoDebitoCredito = situacaoSaldoDebitoCredito;
	}

	public String getPosicaoSaldoInicial() {
		return posicaoSaldoInicial;
	}

	public void setPosicaoSaldoInicial(String posicaoSaldoInicial) {
		this.posicaoSaldoInicial = posicaoSaldoInicial;
	}

	public ContaBancaria getContaBancaria() {
		return contaBancaria;
	}

	public void setContaBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

	public void setNumeroContaCorrente(String numeroContaCorrente) {
		this.numeroContaCorrente = numeroContaCorrente;
	}

	public String getTipoMoeda() {
		return tipoMoeda;
	}

	public void setTipoMoeda(String tipoMoeda) {
		this.tipoMoeda = tipoMoeda;
	}

	public Integer getNumeroSequenciaExtrato() {
		return numeroSequenciaExtrato;
	}

	public void setNumeroSequenciaExtrato(Integer numeroSequenciaExtrato) {
		this.numeroSequenciaExtrato = numeroSequenciaExtrato;
	}

	public static HeaderConciliacaoBancaria of(ContaBancaria contaBancaria) {
		return new HeaderConciliacaoBancaria(contaBancaria);
	}

	@Override
	public String getDebitoCredito() {
		return situacaoSaldoDebitoCredito;
	}
}
