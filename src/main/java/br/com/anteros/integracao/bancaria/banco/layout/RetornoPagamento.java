package br.com.anteros.integracao.bancaria.banco.layout;

import java.math.BigDecimal;

import br.com.anteros.integracao.bancaria.banco.layout.cnab240.pagamento.bradesco.PagamentoSegmentoJ;

public class RetornoPagamento {

	private Titulo titulo;

	private Integer codigoBancoCompensacao;

	private Integer tipoMovimento;

	private Integer codigoMovimento;

	private Long codigoBarras;

	private String nomeCedente;

	private BigDecimal quantidadeMoeda;

	private String identificadorTituloBanco;

	private String codOcorrenciaRetorno;

	private RetornoPagamento(ContaBancaria contaBancaria, PagamentoSegmentoJ segmentoJ) {
		titulo = new Titulo(contaBancaria);
		titulo.setValorTitulo(segmentoJ.getVlTitulo());
		titulo.setValorDesconto(segmentoJ.getVlDescontoEAbatimento());
		titulo.setValorJuros(segmentoJ.getVlMoraEMulta());
		titulo.setValorPagamento(segmentoJ.getVlPagamento());
		titulo.setDataVencimento(segmentoJ.getDtVencimento());
		titulo.setDataPagamento(segmentoJ.getDtPagamento());
		titulo.setTipoMoeda(TipoMoeda.convert(Integer.valueOf(segmentoJ.getCodigoMoeda())));
		titulo.setNossoNumero(segmentoJ.getIdentificadorTituloEmpresa());
		
		this.codigoBancoCompensacao = segmentoJ.getCodigoBanco();
		this.tipoMovimento = segmentoJ.getTipoMovimento();
		this.codigoMovimento = segmentoJ.getCodigoMovimento();
		this.codigoBarras = segmentoJ.getCodigoBarras();
		this.nomeCedente = segmentoJ.getNomeCedente();
		this.quantidadeMoeda = segmentoJ.getQuantidadeMoeda();
		this.identificadorTituloBanco = segmentoJ.getIdentificadorTituloBanco();
		this.codOcorrenciaRetorno = segmentoJ.getCodOcorrenciaRetorno();
	}

	public static RetornoPagamento of(ContaBancaria contaBancaria, PagamentoSegmentoJ segmentoJ) {
		return new RetornoPagamento(contaBancaria, segmentoJ);
	}

	public Titulo getTitulo() {
		return titulo;
	}

	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}

	public Integer getCodigoBancoCompensacao() {
		return codigoBancoCompensacao;
	}

	public void setCodigoBancoCompensacao(Integer codigoBancoCompensacao) {
		this.codigoBancoCompensacao = codigoBancoCompensacao;
	}

	public Integer getTipoMovimento() {
		return tipoMovimento;
	}

	public void setTipoMovimento(Integer tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}

	public Integer getCodigoMovimento() {
		return codigoMovimento;
	}

	public void setCodigoMovimento(Integer codigoMovimento) {
		this.codigoMovimento = codigoMovimento;
	}

	public Long getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(Long codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getNomeCedente() {
		return nomeCedente;
	}

	public void setNomeCedente(String nomeCedente) {
		this.nomeCedente = nomeCedente;
	}

	public BigDecimal getQuantidadeMoeda() {
		return quantidadeMoeda;
	}

	public void setQuantidadeMoeda(BigDecimal quantidadeMoeda) {
		this.quantidadeMoeda = quantidadeMoeda;
	}

	public String getIdentificadorTituloBanco() {
		return identificadorTituloBanco;
	}

	public void setIdentificadorTituloBanco(String identificadorTituloBanco) {
		this.identificadorTituloBanco = identificadorTituloBanco;
	}

	public String getCodOcorrenciaRetorno() {
		return codOcorrenciaRetorno;
	}

	public void setCodOcorrenciaRetorno(String codOcorrenciaRetorno) {
		this.codOcorrenciaRetorno = codOcorrenciaRetorno;
	}

	@Override
	public String toString() {
		return "RetornoPagamento [titulo=" + titulo + ", codigoBancoCompensacao=" + codigoBancoCompensacao
				+ ", tipoMovimento=" + tipoMovimento + ", codigoMovimento=" + codigoMovimento + ", codigoBarras="
				+ codigoBarras + ", nomeCedente=" + nomeCedente + ", quantidadeMoeda=" + quantidadeMoeda
				+ ", identificadorTituloBanco=" + identificadorTituloBanco + ", codOcorrenciaRetorno="
				+ codOcorrenciaRetorno + "]";
	}

}
