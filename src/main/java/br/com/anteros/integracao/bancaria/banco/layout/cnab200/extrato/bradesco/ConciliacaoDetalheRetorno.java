package br.com.anteros.integracao.bancaria.banco.layout.cnab200.extrato.bradesco;

import java.math.BigDecimal;
import java.util.Date;

import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.Formats;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.annotation.RecordData;
import br.com.anteros.flatfile.language.EnumTypes;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.Lancamento;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.*;

public class ConciliacaoDetalheRetorno implements Lancamento, RecordData {

	@IdType(name = ID_TIPOREGISTRO, length = 1, positionField = 8, value = "1")
	private String tipoRegistro;

	@Field(name = CD_REGISTRO, length = 1, value = "1", type = EnumTypes.INTEGER)
	private Integer codigoRegistro;

	@Field(name = TP_TIPO_INSCRICAO, length = 2)
	private String tipoInscricao;

	@Field(name = NR_INSCRICAO_EMPRESA, length = 14)
	private String numeroInscricaoEmpresa;

	@Field(name = AGENCIA, length = 4, type = EnumTypes.INTEGER)
	private Integer agencia;

	@Field(name = "BRANCOS1", length = 8, padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos1;

	@Field(name = NR_CONTACORRENTE, length = 11, type = EnumTypes.INTEGER)
	private Integer numeroContaCorrente;

	@Field(name = DIGITO_CONTA_CORRENTE, length = 1)
	private String digitoContaCorrente;	

	@Field(name = CATEGORIA_LANCAMENTO, length = 3)
	private String categoriaLancamento;

	@Field(name = CD_HISTORICO, length = 4, type = EnumTypes.INTEGER)
	private Integer codigoHistorico;

	@Field(name = HISTORICO_LANCAMENTO, length = 25)
	private String historicoLancamento;

	@Field(name = NR_DOCUMENTO, length = 6)
	private String numeroDocumento;

	@Field(name = DT_LANCAMENTO, length = 6, format = Formats.DATE_DDMMYY, type = EnumTypes.DATE)
	private Date dataLancamento;

	@Field(name = VL_LANCAMENTO, length = 18, format = Formats.DECIMAL_DD, type = EnumTypes.BIGDECIMAL)
	private BigDecimal valorLancamento;
	
	@Field(name=DEBITO_CREDITO, length=1)
	private String debitoCredito;
	
	@Field(name=COMPLEMENTO_HISTORICO, length=32)
	private String complementoHistorico;
	
	@Field(name = "BRANCOS2", length = 13)
	private String brancos2;
	
	@Field(name = "BRANCOS3", length = 7)
	private String brancos3;
	
	@Field(name = "BRANCOS4", length = 7)
	private String brancos4;
	
	@Field(name = "BRANCOS5", length = 8)
	private String brancos5;
	
	@Field(name = "BRANCOS6", length = 13)
	private String brancos6;
	
	@Field(name= TP_LANCAMENTO, length=1)
	private String tipoLancamento;
	
	@Field(name = "BRANCOS7", length = 3)
	private String brancos7;
	
	@Field(name = "BRANCOS8", length = 2)
	private String brancos8;

	@Field(name = CD_BANCO, length = 3, type = EnumTypes.INTEGER)
	private Integer codigoBanco;

	@Field(name = NR_SEQUENCIAL_REGISTRO, length = 6, padding = Paddings.ZERO_LEFT, type = EnumTypes.INTEGER)
	private Integer numeroSequencialRegistro;

	private ContaBancaria contaBancaria;

	public ConciliacaoDetalheRetorno(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

	public void set(br.com.anteros.flatfile.Record record) {
		setTipoInscricao((String) record.getValue(TP_TIPO_INSCRICAO));
		setNumeroInscricaoEmpresa((String) record.getValue(NR_INSCRICAO_EMPRESA));
		setAgencia((Integer) record.getValue(AGENCIA));
		setNumeroContaCorrente((Integer) record.getValue(NR_CONTACORRENTE));
		setDigitoContaCorrente((String) record.getValue(DIGITO_CONTA_CORRENTE));
		setCategoriaLancamento((String) record.getValue(CATEGORIA_LANCAMENTO));
		setCodigoHistorico((Integer) record.getValue(CD_HISTORICO));
		setHistoricoLancamento((String) record.getValue(HISTORICO_LANCAMENTO));
		setNumeroDocumento((String) record.getValue(NR_DOCUMENTO));
		setDataLancamento((Date) record.getValue(DT_LANCAMENTO));
		setValorLancamento((BigDecimal) record.getValue(VL_LANCAMENTO));
		setComplementoHistorico((String) record.getValue(COMPLEMENTO_HISTORICO));
		setNumeroSequencialRegistro((Integer) record.getValue(NR_SEQUENCIAL_REGISTRO));
		setCodigoBanco((Integer) record.getValue(CD_BANCO));
		setTipoLancamento((String) record.getValue(TP_LANCAMENTO));
		setDebitoCredito((String) record.getValue(DEBITO_CREDITO));		
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

	public String getNumeroInscricaoEmpresa() {
		return numeroInscricaoEmpresa;
	}

	public void setNumeroInscricaoEmpresa(String numeroInscricaoEmpresa) {
		this.numeroInscricaoEmpresa = numeroInscricaoEmpresa;
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

	public String getCategoriaLancamento() {
		return categoriaLancamento;
	}

	public void setCategoriaLancamento(String categoriaLancamento) {
		this.categoriaLancamento = categoriaLancamento;
	}

	public Integer getCodigoHistorico() {
		return codigoHistorico;
	}

	public void setCodigoHistorico(Integer codigoHistorico) {
		this.codigoHistorico = codigoHistorico;
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

	public Integer getNumeroSequencialRegistro() {
		return numeroSequencialRegistro;
	}

	public void setNumeroSequencialRegistro(Integer numeroSequencialRegistro) {
		this.numeroSequencialRegistro = numeroSequencialRegistro;
	}

	public String getDebitoCredito() {
		return debitoCredito;
	}

	public void setDebitoCredito(String debitoCredito) {
		this.debitoCredito = debitoCredito;
	}

	public String getComplementoHistorico() {
		return complementoHistorico;
	}

	public void setComplementoHistorico(String complementoHistorico) {
		this.complementoHistorico = complementoHistorico;
	}

	public String getTipoLancamento() {
		return tipoLancamento;
	}

	public void setTipoLancamento(String tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

	public Integer getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(Integer codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public String getHistoricoLancamento() {
		return historicoLancamento;
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
	public String getIdentificadorCPMF() {
		return "";
	}

	@Override
	public Date getDataContabil() {
		return dataLancamento;
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
		return null;
	}

	@Override
	public int getNumberOfRecords() {
		return 0;
	}

	@Override
	public void readRowData(int row, int sequence) {
	
	}

	public static ConciliacaoDetalheRetorno of(ContaBancaria contaBancaria) {
		return new ConciliacaoDetalheRetorno(contaBancaria);
	}

}
