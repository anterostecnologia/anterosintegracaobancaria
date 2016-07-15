/*******************************************************************************
 * Copyright 2016 Anteros Tecnologia
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package br.com.anteros.integracao.bancaria.banco.layout;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.anteros.integracao.bancaria.banco.layout.cnab240.CobrancaSegmentoT;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.CobrancaSegmentoU;

public class RetornoCobranca {

	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Titulo titulo;

	private Integer nrLote;

	private Integer numeroSequencial;

	private Integer codigoMovimentoRetorno;

	private String numeroContratoOperacaoCredito;

	private Integer tipoInscricaoSacadoAvalista;

	private Long numeroInscricaoSacadoAvalista;

	private String nomeSacadorAvalista;

	private BigDecimal valorTarifasCustas = BigDecimal.ZERO;

	private String motivoRejeicao1;

	private BigDecimal valorLiquidoCreditado = BigDecimal.ZERO;

	private BigDecimal valorOutrasDespesas = BigDecimal.ZERO;

	private BigDecimal valorOutrosCreditos = BigDecimal.ZERO;

	private Date dataOcorrenciaPagamento;

	private Date dataEfetivacaoCredito;

	private String codigoOcorrenciaSacado;

	private Date dataOcorrenciaSacado;

	private BigDecimal valorOcorrenciaSacado = BigDecimal.ZERO;

	private String complementoOcorrenciaSacado;

	private Integer agenciaRecebedora;

	private String digitoAgenciaRecebedora;

	private Object motivoRejeicao2;

	private Object motivoRejeicao3;

	private Object motivoRejeicao4;

	private Object motivoRejeicao5;

	private RetornoCobranca(ContaBancaria contaBancaria, CobrancaSegmentoT segmentoT,
			CobrancaSegmentoU segmentoU) {
		titulo = new Titulo(contaBancaria);
		titulo.setCarteira(new Carteira(Integer.valueOf(segmentoT.getCodigoCarteira())));
		titulo.setValorTitulo(segmentoT.getValorNominalTitulo());
		titulo.setDataVencimento(segmentoT.getDataVencimentoTitulo());
		titulo.setNossoNumero(segmentoT.getIdentificadorTitulo());
		titulo.setNumeroDocumento(segmentoT.getNumeroDocumentoCobranca());
		titulo.setValorJuros(segmentoU.getValorJurosMultasEncargos());
		titulo.setValorAbatimento(segmentoU.getValorAbatimento());
		titulo.setValorDesconto(segmentoU.getValorDesconto());
		titulo.setValorIOF(segmentoU.getValorIOF());
		titulo.setValorCobrado(segmentoU.getValorPagoSacado());
		titulo.setTipoMoeda(TipoMoeda.convert(Integer.valueOf(segmentoT.getCodigoMoeda())));

		this.nrLote = segmentoT.getLoteServico();
		this.numeroSequencial = segmentoT.getNumeroSequencialRegistro();
		this.codigoMovimentoRetorno = segmentoT.getCodigoMovimentoRetorno();
		this.numeroContratoOperacaoCredito = segmentoT.getNumeroContratoOperacaoCredito();
		this.tipoInscricaoSacadoAvalista = segmentoT.getTipoInscricaoSacadoAvalista();
		this.numeroInscricaoSacadoAvalista = segmentoT.getNumeroInscricaoSacadoAvalista();
		this.nomeSacadorAvalista = segmentoT.getNomeSacadorAvalista();
		this.valorTarifasCustas = segmentoT.getValorTarifaCustas();
		this.motivoRejeicao1 = segmentoT.getMotivoRejeicao1();
		this.valorLiquidoCreditado = segmentoU.getValorLiquidoCreditado();
		this.valorOutrasDespesas = segmentoU.getValorOutrasDespesas();
		this.valorOutrosCreditos = segmentoU.getValorOutrosCreditos();
		this.dataOcorrenciaPagamento = segmentoU.getDataOcorrenciaPagamento();
		this.dataEfetivacaoCredito = segmentoU.getDataEfetivacaoCredito();
		this.codigoOcorrenciaSacado = segmentoU.getCodigoOcorrencia();
		this.dataOcorrenciaSacado = segmentoU.getDataOcorrencia();
		this.valorOcorrenciaSacado = segmentoU.getValorOcorrencia();
		this.complementoOcorrenciaSacado = segmentoU.getComplementoOcorrencia();
		this.agenciaRecebedora = segmentoT.getAgenciaRecebedora();
		this.digitoAgenciaRecebedora = segmentoT.getDigitoAgenciaRecebedora();
	}

	public RetornoCobranca(ContaBancaria contaBancaria, DetalheRetorno detalheRetorno) {
		titulo = new Titulo(contaBancaria);
		titulo.setCarteira(new Carteira(Integer.valueOf(detalheRetorno.getCarteira())));
		titulo.setValorTitulo(detalheRetorno.getValorTitulo());
		titulo.setDataVencimento(detalheRetorno.getDataVencimento());
		titulo.setNossoNumero(detalheRetorno.getNossoNumero());
		titulo.setNumeroDocumento(detalheRetorno.getNumeroDocumento());
		titulo.setValorJuros(detalheRetorno.getValorJuros());
		titulo.setValorAbatimento(detalheRetorno.getValorAbatimento());
		titulo.setValorDesconto(detalheRetorno.getValorDesconto());
		titulo.setValorIOF(detalheRetorno.getValorIOF());
		titulo.setValorCobrado(detalheRetorno.getValorPago());

		this.nrLote = 1;
		this.numeroSequencial = detalheRetorno.getNumeroSequencialRegistro();
		this.codigoMovimentoRetorno = detalheRetorno.getCodigoMovimentoRetorno();
		this.tipoInscricaoSacadoAvalista = detalheRetorno.getTipoInscricaoSacadoAvalista();
		this.numeroInscricaoSacadoAvalista = detalheRetorno.getNumeroInscricaoSacadoAvalista();
		this.nomeSacadorAvalista = detalheRetorno.getNomeSacadorAvalista();
		this.valorTarifasCustas = detalheRetorno.getValorDespesasCobranca();
		this.motivoRejeicao1 = detalheRetorno.getMotivoOcorrencia1();
		this.motivoRejeicao2 = detalheRetorno.getMotivoOcorrencia2();
		this.motivoRejeicao3 = detalheRetorno.getMotivoOcorrencia3();
		this.motivoRejeicao4 = detalheRetorno.getMotivoOcorrencia4();
		this.motivoRejeicao5 = detalheRetorno.getMotivoOcorrencia5();
		this.valorLiquidoCreditado = detalheRetorno.getValorPago();
		this.valorOutrasDespesas = detalheRetorno.getValorOutrasDespesas();
		this.valorOutrosCreditos = detalheRetorno.getValorOutrosCreditos();
		this.dataOcorrenciaPagamento = detalheRetorno.getDataOcorrencia();
		this.dataEfetivacaoCredito = detalheRetorno.getDataCredito();
		this.agenciaRecebedora = detalheRetorno.getAgenciaRecebedora();
		this.digitoAgenciaRecebedora = detalheRetorno.getDigitoAgenciaRecebedora();
	}

	public static RetornoCobranca of(ContaBancaria contaBancaria, CobrancaSegmentoT segmentoT,
			CobrancaSegmentoU segmentoU) {
		return new RetornoCobranca(contaBancaria, segmentoT, segmentoU);
	}

	public SimpleDateFormat getSdf() {
		return sdf;
	}

	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}

	public Titulo getTitulo() {
		return titulo;
	}

	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}

	public Integer getNrLote() {
		return nrLote;
	}

	public void setNumeroLote(Integer numeroLote) {
		this.nrLote = numeroLote;
	}

	public Integer getNumeroSequencial() {
		return numeroSequencial;
	}

	public void setNumeroSequencial(Integer numeroSequencial) {
		this.numeroSequencial = numeroSequencial;
	}

	public Integer getCodigoMovimentoRetorno() {
		return codigoMovimentoRetorno;
	}

	public void setCodigoMovimentoRetorno(Integer codigoMovimentoRetorno) {
		this.codigoMovimentoRetorno = codigoMovimentoRetorno;
	}

	public String getNumeroContratoOperacaoCredito() {
		return numeroContratoOperacaoCredito;
	}

	public void setNumeroContratoOperacaoCredito(String numeroContratoOperacaoCredito) {
		this.numeroContratoOperacaoCredito = numeroContratoOperacaoCredito;
	}

	public Integer getTipoInscricaoSacadoAvalista() {
		return tipoInscricaoSacadoAvalista;
	}

	public void setTipoInscricaoSacadoAvalista(Integer tipoInscricaoSacadoAvalista) {
		this.tipoInscricaoSacadoAvalista = tipoInscricaoSacadoAvalista;
	}

	public Long getNumeroInscricaoSacadoAvalista() {
		return numeroInscricaoSacadoAvalista;
	}

	public void setNumeroInscricaoSacadoAvalista(Long numeroInscricaoSacadoAvalista) {
		this.numeroInscricaoSacadoAvalista = numeroInscricaoSacadoAvalista;
	}

	public String getNomeSacadorAvalista() {
		return nomeSacadorAvalista;
	}

	public void setNomeSacadorAvalista(String nomeSacadorAvalista) {
		this.nomeSacadorAvalista = nomeSacadorAvalista;
	}

	public BigDecimal getValorTarifasCustas() {
		return valorTarifasCustas;
	}

	public void setValorTarifasCustas(BigDecimal valorTarifasCustas) {
		this.valorTarifasCustas = valorTarifasCustas;
	}

	public BigDecimal getValorLiquidoCreditado() {
		return valorLiquidoCreditado;
	}

	public void setValorLiquidoCreditado(BigDecimal valorLiquidoCreditado) {
		this.valorLiquidoCreditado = valorLiquidoCreditado;
	}

	public BigDecimal getValorOutrasDespesas() {
		return valorOutrasDespesas;
	}

	public void setValorOutrasDespesas(BigDecimal valorOutrasDespesas) {
		this.valorOutrasDespesas = valorOutrasDespesas;
	}

	public BigDecimal getValorOutrosCreditos() {
		return valorOutrosCreditos;
	}

	public void setValorOutrosCreditos(BigDecimal valorOutrosCreditos) {
		this.valorOutrosCreditos = valorOutrosCreditos;
	}

	public Date getDataOcorrenciaPagamento() {
		return dataOcorrenciaPagamento;
	}

	public void setDataOcorrenciaPagamento(Date dataOcorrenciaPagamento) {
		this.dataOcorrenciaPagamento = dataOcorrenciaPagamento;
	}

	public Date getDataEfetivacaoCredito() {
		return dataEfetivacaoCredito;
	}

	public void setDataEfetivacaoCredito(Date dataEfetivacaoCredito) {
		this.dataEfetivacaoCredito = dataEfetivacaoCredito;
	}

	public String getCodigoOcorrenciaSacado() {
		return codigoOcorrenciaSacado;
	}

	public void setCodigoOcorrenciaSacado(String codigoOcorrenciaSacado) {
		this.codigoOcorrenciaSacado = codigoOcorrenciaSacado;
	}

	public Date getDataOcorrenciaSacado() {
		return dataOcorrenciaSacado;
	}

	public void setDataOcorrenciaSacado(Date dataOcorrenciaSacado) {
		this.dataOcorrenciaSacado = dataOcorrenciaSacado;
	}

	public BigDecimal getValorOcorrenciaSacado() {
		return valorOcorrenciaSacado;
	}

	public void setValorOcorrenciaSacado(BigDecimal valorOcorrenciaSacado) {
		this.valorOcorrenciaSacado = valorOcorrenciaSacado;
	}

	public String getComplementoOcorrenciaSacado() {
		return complementoOcorrenciaSacado;
	}

	public void setComplementoOcorrenciaSacado(String complementoOcorrenciaSacado) {
		this.complementoOcorrenciaSacado = complementoOcorrenciaSacado;
	}

	public static RetornoCobranca of(ContaBancaria contaBancaria, DetalheRetorno detalheRetorno) {
		return new RetornoCobranca(contaBancaria, detalheRetorno);
	}

	@Override
	public String toString() {
		return "RetornoCobranca [titulo=" + titulo + ", nrLote=" + nrLote + ", numeroSequencial=" + numeroSequencial
				+ ", codigoMovimentoRetorno=" + codigoMovimentoRetorno + ", numeroContratoOperacaoCredito="
				+ numeroContratoOperacaoCredito + ", tipoInscricaoSacadoAvalista=" + tipoInscricaoSacadoAvalista
				+ ", numeroInscricaoSacadoAvalista=" + numeroInscricaoSacadoAvalista + ", nomeSacadorAvalista="
				+ nomeSacadorAvalista + ", valorTarifasCustas=" + valorTarifasCustas + ", motivoRejeicao1="
				+ motivoRejeicao1 + ", motivoRejeicao2=" + motivoRejeicao2 + ", motivoRejeicao3=" + motivoRejeicao3
				+ ", motivoRejeicao4=" + motivoRejeicao4 + ", motivoRejeicao5=" + motivoRejeicao5
				+ ", valorLiquidoCreditado=" + valorLiquidoCreditado + ", valorOutrasDespesas=" + valorOutrasDespesas
				+ ", valorOutrosCreditos=" + valorOutrosCreditos + ", dataOcorrenciaPagamento="
				+ (dataOcorrenciaPagamento == null ? "" : sdf.format(dataOcorrenciaPagamento))
				+ ", dataEfetivacaoCredito=" + (dataEfetivacaoCredito == null ? "" : sdf.format(dataEfetivacaoCredito))
				+ ", codigoOcorrenciaSacado=" + codigoOcorrenciaSacado + ", dataOcorrenciaSacado="
				+ (dataOcorrenciaSacado == null ? "" : sdf.format(dataOcorrenciaSacado)) + ", valorOcorrenciaSacado="
				+ valorOcorrenciaSacado + ", complementoOcorrenciaSacado=" + complementoOcorrenciaSacado
				+ ", agenciaRecebedora=" + agenciaRecebedora + ", digitoAgenciaRecebedora=" + digitoAgenciaRecebedora
				+ "]";
	}

	public Integer getAgenciaRecebedora() {
		return agenciaRecebedora;
	}

	public void setAgenciaRecebedora(Integer agenciaRecebedora) {
		this.agenciaRecebedora = agenciaRecebedora;
	}

	public String getDigitoAgenciaRecebedora() {
		return digitoAgenciaRecebedora;
	}

	public void setDigitoAgenciaRecebedora(String digitoAgenciaRecebedora) {
		this.digitoAgenciaRecebedora = digitoAgenciaRecebedora;
	}

}
