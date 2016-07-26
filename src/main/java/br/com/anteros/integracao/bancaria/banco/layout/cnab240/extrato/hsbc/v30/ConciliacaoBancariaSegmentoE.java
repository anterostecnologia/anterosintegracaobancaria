package br.com.anteros.integracao.bancaria.banco.layout.cnab240.extrato.hsbc.v30;

import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.AGENCIA_MANTENEDORA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CATEGORIA_LANCAMENTO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CD_BANCO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CD_CONVENIO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CD_HISTORICO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CD_SEGMENTO_REGISTRO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.DEBITO_CREDITO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.DIGITO_AGENCIA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.DIGITO_AGENCIACONTA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.DIGITO_CONTACORRENTE;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.DT_LANCAMENTO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.HISTORICO_LANCAMENTO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.LT_SERVICO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NOME_EMPRESA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NR_CONTACORRENTE;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NR_DOCUMENTO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NR_INSCRICAO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NR_SEQUENCIAL_REGISTRO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.PREFIXO_HISTORICO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.TP_INSCRICAO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.TP_REGISTRO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.VL_LANCAMENTO;

import java.math.BigDecimal;
import java.util.Date;

import br.com.anteros.flatfile.Record;
import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.Formats;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.annotation.RecordData;
import br.com.anteros.flatfile.language.EnumTypes;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.Lancamento;

public class ConciliacaoBancariaSegmentoE implements Lancamento, RecordData {

	@IdType(value = "E", length = 1, positionField = 5, name = CD_SEGMENTO_REGISTRO)
	private String codigoSegmentoRegistro;

	@Field(name = CD_BANCO, type = EnumTypes.INTEGER, length = 3, padding = Paddings.ZERO_LEFT)
	private Integer codigoBanco;

	@Field(name = LT_SERVICO, type = EnumTypes.INTEGER, length = 4, padding = Paddings.ZERO_LEFT)
	private Integer loteServico;

	@Field(name = TP_REGISTRO, type = EnumTypes.INTEGER, length = 1, value = "3", padding = Paddings.ZERO_LEFT)
	private Integer tipoRegistro;

	@Field(name = NR_SEQUENCIAL_REGISTRO, type = EnumTypes.INTEGER, length = 5, padding = Paddings.ZERO_LEFT)
	private Integer numeroSequencialRegistro;

	@Field(name = "BRANCOS_1", length = 3, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
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

	@Field(name = NOME_EMPRESA, length = 30, padding = Paddings.WHITE_SPACE_RIGHT)
	private String nomeEmpresa;

	@Field(name = "BRANCOS_2", length = 40, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos2;

	@Field(name = DT_LANCAMENTO, length = 8, format = Formats.DATE_DDMMYYYY, type = EnumTypes.DATE)
	private Date dataLancamento;

	@Field(name = VL_LANCAMENTO, length = 18, format = Formats.DECIMAL_DD, type = EnumTypes.BIGDECIMAL)
	private BigDecimal valorLancamento;

	@Field(name = DEBITO_CREDITO, length = 1)
	private String debitoCredito;

	@Field(name = CATEGORIA_LANCAMENTO, length = 3, type = EnumTypes.INTEGER)
	private Integer categoriaLancamento;

	@Field(name = CD_HISTORICO, length = 4)
	private String codigoHistorico;

	@Field(name = PREFIXO_HISTORICO, length = 4)
	private String prefixoHistorico;

	@Field(name = HISTORICO_LANCAMENTO, length = 21)
	private String historicoLancamento;

	@Field(name = NR_DOCUMENTO, length = 39)
	private String numeroDocumento;

	private ContaBancaria contaBancaria;

	public ConciliacaoBancariaSegmentoE(ContaBancaria contaBancaria) {
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
		setNomeEmpresa((String) record.getValue(NOME_EMPRESA));
		setDataLancamento((Date) record.getValue(DT_LANCAMENTO));
		setValorLancamento((BigDecimal) record.getValue(VL_LANCAMENTO));
		setDebitoCredito((String) record.getValue(DEBITO_CREDITO));
		setHistoricoLancamento((String) record.getValue(HISTORICO_LANCAMENTO));
		setNumeroDocumento((String) record.getValue(NR_DOCUMENTO));
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

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public BigDecimal getValorLancamento() {
		return valorLancamento;
	}

	public void setValorLancamento(BigDecimal valorLancamento) {
		this.valorLancamento = valorLancamento;
	}

	public String getDebitoCredito() {
		return debitoCredito;
	}

	public void setDebitoCredito(String debitoCredito) {
		this.debitoCredito = debitoCredito;
	}

	public String getHistoricoLancamento() {
		return historicoLancamento;
	}

	public void setHistoricoLancamento(String historicoLancamento) {
		this.historicoLancamento = historicoLancamento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public static ConciliacaoBancariaSegmentoE of(ContaBancaria contaBancaria) {
		return new ConciliacaoBancariaSegmentoE(contaBancaria);
	}

	@Override
	public int getNumberOfRecords() {
		return 0;
	}

	@Override
	public void readRowData(int row) {

	}

	@Override
	public Integer getAgenciaOrigemLancamento() {
		return null;
	}

	@Override
	public Integer getCodigoBancoOrigem() {
		return null;
	}

	@Override
	public String getCodigoSubHistorico() {
		return "";
	}

	@Override
	public Integer getNumeroSequencialRegistro() {
		return numeroSequencialRegistro;
	}

	@Override
	public String getNaturezaLancamento() {
		return null;
	}

	@Override
	public Integer getTipoComplementoHistorico() {
		return null;
	}

	@Override
	public String getComplementoHistorico() {
		return null;
	}

	@Override
	public String getIdentificadorCPMF() {
		return null;
	}

	@Override
	public Date getDataContabil() {
		return null;
	}

	@Override
	public String getCategoriaLancamento() {
		return null;
	}

	@Override
	public Integer getCodigoHistorico() {
		return null;
	}

}
