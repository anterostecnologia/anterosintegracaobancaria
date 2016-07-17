package br.com.anteros.integracao.bancaria.banco.layout;

import java.math.BigDecimal;
import java.util.Date;

public class ConciliacaoBancariaLancamento {

	private String naturezaLancamento;

	private Integer tipoComplementoHistorico;

	private String complementoHistorico;

	private String identificadorCPMF;

	private Date dataContabil;

	private Date dataLancamento;

	private BigDecimal valorLancamento;

	private String debitoCredito;

	private String categoriaLancamento;

	private Integer codigoHistorico;

	private String historicoLancamento;

	private String numeroDocumento;

	private Integer agenciaOrigemLancamento;

	private Integer codigoBancoOrigem;

	private String codigoSubHistorico;

	private Integer numeroSequencialRegistro;

	private ConciliacaoBancariaLancamento(Lancamento lancamento) {
		this.naturezaLancamento = lancamento.getNaturezaLancamento();
		this.tipoComplementoHistorico = lancamento.getTipoComplementoHistorico();
		this.complementoHistorico = lancamento.getComplementoHistorico();
		this.identificadorCPMF = lancamento.getIdentificadorCPMF();
		this.dataContabil = lancamento.getDataContabil();
		this.dataLancamento = lancamento.getDataLancamento();
		this.valorLancamento = lancamento.getValorLancamento();
		this.debitoCredito = lancamento.getDebitoCredito();
		this.categoriaLancamento = lancamento.getCategoriaLancamento();
		this.codigoHistorico = lancamento.getCodigoHistorico();
		this.historicoLancamento = lancamento.getHistoricoLancamento();
		this.numeroDocumento = lancamento.getNumeroDocumento();
		this.agenciaOrigemLancamento = lancamento.getAgenciaOrigemLancamento();
		this.codigoBancoOrigem = lancamento.getCodigoBancoOrigem();
		this.codigoSubHistorico = lancamento.getCodigoSubHistorico();
		this.numeroSequencialRegistro = lancamento.getNumeroSequencialRegistro();
	}

	public String getNaturezaLancamento() {
		return naturezaLancamento;
	}

	public void setNaturezaLancamento(String naturezaLancamento) {
		this.naturezaLancamento = naturezaLancamento;
	}

	public Integer getTipoComplementoHistorico() {
		return tipoComplementoHistorico;
	}

	public void setTipoComplementoHistorico(Integer tipoComplementoHistorico) {
		this.tipoComplementoHistorico = tipoComplementoHistorico;
	}

	public String getComplementoHistorico() {
		return complementoHistorico;
	}

	public void setComplementoHistorico(String complementoHistorico) {
		this.complementoHistorico = complementoHistorico;
	}

	public String getIdentificadorCPMF() {
		return identificadorCPMF;
	}

	public void setIdentificadorCPMF(String identificadorCPMF) {
		this.identificadorCPMF = identificadorCPMF;
	}

	public Date getDataContabil() {
		return dataContabil;
	}

	public void setDataContabil(Date dataContabil) {
		this.dataContabil = dataContabil;
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

	public Integer getAgenciaOrigemLancamento() {
		return agenciaOrigemLancamento;
	}

	public void setAgenciaOrigemLancamento(Integer agenciaOrigemLancamento) {
		this.agenciaOrigemLancamento = agenciaOrigemLancamento;
	}

	public Integer getCodigoBancoOrigem() {
		return codigoBancoOrigem;
	}

	public void setCodigoBancoOrigem(Integer codigoBancoOrigem) {
		this.codigoBancoOrigem = codigoBancoOrigem;
	}

	public String getCodigoSubHistorico() {
		return codigoSubHistorico;
	}

	public void setCodigoSubHistorico(String codigoSubHistorico) {
		this.codigoSubHistorico = codigoSubHistorico;
	}

	public Integer getNumeroSequencialRegistro() {
		return numeroSequencialRegistro;
	}

	public void setNumeroSequencialRegistro(Integer numeroSequencialRegistro) {
		this.numeroSequencialRegistro = numeroSequencialRegistro;
	}

	public static ConciliacaoBancariaLancamento of(Lancamento lancamento) {
		return new ConciliacaoBancariaLancamento(lancamento);
	}

	@Override
	public String toString() {
		return "ConciliacaoBancariaLancamento [naturezaLancamento=" + naturezaLancamento + ", tipoComplementoHistorico="
				+ tipoComplementoHistorico + ", complementoHistorico=" + complementoHistorico + ", identificadorCPMF="
				+ identificadorCPMF + ", dataContabil=" + dataContabil + ", dataLancamento=" + dataLancamento
				+ ", valorLancamento=" + valorLancamento + ", debitoCredito=" + debitoCredito + ", categoriaLancamento="
				+ categoriaLancamento + ", codigoHistorico=" + codigoHistorico + ", historicoLancamento="
				+ historicoLancamento + ", numeroDocumento=" + numeroDocumento + ", agenciaOrigemLancamento="
				+ agenciaOrigemLancamento + ", codigoBancoOrigem=" + codigoBancoOrigem + ", codigoSubHistorico="
				+ codigoSubHistorico + ", numeroSequencialRegistro=" + numeroSequencialRegistro + "]";
	}

}
