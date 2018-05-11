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

import br.com.anteros.core.utils.ObjectUtils;
import br.com.anteros.integracao.bancaria.banco.ParametroBancario;
import br.com.anteros.integracao.bancaria.banco.ParametrosBancariosMap;

/**
 * Representa um título em cobrança, tais como:
 * 
 * <br />
 * 
 * <ul>
 * <li>Cheque</li>
 * <li>Duplicata Mercantil</li>
 * <li>Duplicata de Serviço</li>
 * <li>Duplicata Rural</li>
 * <li>Letra de Câmbio</li>
 * <li>Nota de Crédito Comercial</li>
 * <li>Nota de Crédito Industrial</li>
 * <li>Nota de Crédito Rural</li>
 * <li>E outras espécies pagáveis através da rede bancária.</li>
 * 
 */
public class Titulo {

	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private String numeroDocumento;
	
	private String quantidadeParcela;

	private Date dataDocumento;

	private Date dataVencimento;
	
	private Date dataPagamento;
	
	private Date dataMulta;

	private TipoMoeda tipoMoeda = TipoMoeda.REAL;

	private BigDecimal valorTitulo = BigDecimal.ZERO;

	private BigDecimal valorDescontoConcedido = BigDecimal.ZERO;

	private BigDecimal percentualDescontoConcedido = BigDecimal.ZERO;

	private BigDecimal percentualMulta = BigDecimal.ZERO;

	private BigDecimal valorJurosMoraPorAtraso = BigDecimal.ZERO;

	private BigDecimal valorAcrecimo = BigDecimal.ZERO;

	private BigDecimal valorJuros = BigDecimal.ZERO;

	private BigDecimal valorDesconto = BigDecimal.ZERO;

	private BigDecimal valorDeducao = BigDecimal.ZERO;

	private BigDecimal valorCobrado = BigDecimal.ZERO;

	private BigDecimal valorIOF = BigDecimal.ZERO;

	private BigDecimal valorAbatimentoConcedido = BigDecimal.ZERO;

	private BigDecimal valorAbatimento = BigDecimal.ZERO;
	
	private BigDecimal valorPagamento = BigDecimal.ZERO;

	private Integer nrDiasProtesto = 0;

	private TipoDeBaixaDevolucao tipoBaixaDevolucao;

	private Integer nrDiasBaixaDevolucao = 0;

	private TipoTitulo tipoDocumento;

	private TipoJurosMora tipoJurosMora;

	private TipoDesconto tipoDesconto;

	private TipoMulta tipoMulta;

	private TipoProtesto tipoProtesto;

	private Date dataDesconto;

	private Date dataJurosMora;

	private String nossoNumero;

	private String digitoNossoNumero;

	private ContaBancaria contaBancaria;

	private Cedente cedente;

	private Sacado sacado;

	private SacadorAvalista sacadorAvalista;

	private Carteira carteira;

	private ParametrosBancariosMap parametrosBancariosMap;

	public enum Aceite {
		A, N;
	}

	private Aceite aceite;

	private Integer instrucaoCobranca1;

	private Integer instrucaoCobranca2;

	public Titulo(ContaBancaria contaBancaria) {
		this.setContaBancaria(contaBancaria);
	}

	public Titulo(ContaBancaria contaBancaria, Sacado sacado, Cedente cedente, Carteira carteira) {
		this.setContaBancaria(contaBancaria);
		this.setSacado(sacado);
		this.setCedente(cedente);
		this.setCarteira(carteira);
	}

	public Titulo(ContaBancaria contaBancaria, Sacado sacado, Cedente cedente, SacadorAvalista sacadorAvalista,
			Carteira carteira) {
		this(contaBancaria, sacado, cedente, carteira);
		this.setSacadorAvalista(sacadorAvalista);
	}

	public Titulo(ContaBancaria contaBancaria, Sacado sacado, Cedente cedente,
			ParametrosBancariosMap parametrosBancariosMap, Carteira carteira) {
		this.setContaBancaria(contaBancaria);
		this.setSacado(sacado);
		this.setCedente(cedente);
		this.setCarteira(carteira);
		this.setParametrosBancarios(parametrosBancariosMap);
	}

	public Titulo(ContaBancaria contaBancaria, Sacado sacado, Cedente cedente,
			ParametrosBancariosMap parametrosBancariosMap, SacadorAvalista sacadorAvalista, Carteira carteira) {
		this(contaBancaria, sacado, cedente, parametrosBancariosMap, carteira);
		this.setSacadorAvalista(sacadorAvalista);
	}

	public boolean hasSacadorAvalista() {

		boolean has = false;

		if (ObjectUtils.isNotNull(this.sacadorAvalista)) {
			has = true;
		}

		return has;
	}

	public Aceite getAceite() {
		return aceite;
	}

	public void setAceite(Aceite aceite) {
		this.aceite = aceite;
	}

	public Date getDataDocumento() {
		return dataDocumento;
	}

	public void setDataDocumento(Date dataDocumento) {
		this.dataDocumento = dataDocumento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Date getDataMulta() {
		return dataMulta;
	}

	public void setDataMulta(Date dataMulta) {
		this.dataMulta = dataMulta;
	}

	public String getDigitoNossoNumero() {
		return digitoNossoNumero;
	}

	public void setDigitoNossoNumero(String digitoNossoNumero) {
		this.digitoNossoNumero = digitoNossoNumero;
	}

	public TipoMoeda getTipoMoeda() {
		return tipoMoeda;
	}

	public void setTipoMoeda(TipoMoeda tipoMoeda) {
		this.tipoMoeda = tipoMoeda;
	}

	public String getNossoNumero() {
		return nossoNumero;
	}

	public void setNossoNumero(String nossoNumero) {
		this.nossoNumero = nossoNumero;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getQuantidadeParcela() {
		return quantidadeParcela;
	}

	public void setQuantidadeParcela(String quantidadeParcela) {
		this.quantidadeParcela = quantidadeParcela;
	}

	public ContaBancaria getContaBancaria() {
		return contaBancaria;
	}

	public void setContaBancaria(ContaBancaria contaBancaria) {

		if (ObjectUtils.isNotNull(contaBancaria)) {
			this.contaBancaria = contaBancaria;
		} else {
			throw new IllegalArgumentException("ContaBancaria não pode ser nula!");
		}
	}

	public Cedente getCedente() {
		return cedente;
	}

	public void setCedente(Cedente cedente) {
		if (ObjectUtils.isNotNull(cedente)) {
			this.cedente = cedente;
		} else {
			throw new IllegalArgumentException("Cedente não pode ser nulo!");
		}
	}

	public Sacado getSacado() {
		return sacado;
	}

	public void setSacado(Sacado sacado) {
		if (ObjectUtils.isNotNull(sacado)) {
			this.sacado = sacado;
		} else {
			throw new IllegalArgumentException("Sacado não pode ser nulo!");
		}
	}

	public SacadorAvalista getSacadorAvalista() {
		return sacadorAvalista;
	}

	public void setSacadorAvalista(SacadorAvalista sacadorAvalista) {
		if (ObjectUtils.isNotNull(sacadorAvalista)) {
			this.sacadorAvalista = sacadorAvalista;
		} else {
			throw new IllegalArgumentException("SacadorAvalista não pode ser nulo!");
		}
	}

	public TipoTitulo getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoTitulo tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public BigDecimal getValorTitulo() {
		return valorTitulo;
	}

	public void setValorTitulo(BigDecimal valor) {
		this.valorTitulo = valor;
	}

	public BigDecimal getValorDescontoConcedido() {
		return valorDescontoConcedido;
	}

	public void setValorDescontoConcedido(BigDecimal valorDescontoConcedido) {
		this.valorDescontoConcedido = valorDescontoConcedido;
	}

	public BigDecimal getValorJurosMoraPorAtraso() {
		return valorJurosMoraPorAtraso;
	}

	public void setValorJurosMoraPorAtraso(BigDecimal valorJurosMoraPorAtraso) {
		this.valorJurosMoraPorAtraso = valorJurosMoraPorAtraso;
	}

	public BigDecimal getValorAcrecimo() {
		return valorAcrecimo;
	}

	public void setValorAcrecimo(BigDecimal valorAcrecimo) {
		this.valorAcrecimo = valorAcrecimo;
	}

	public BigDecimal getValorCobrado() {
		return valorCobrado;
	}

	public void setValorCobrado(BigDecimal valorCobrado) {
		this.valorCobrado = valorCobrado;
	}

	public boolean hasParametrosBancarios() {
		return ParametrosBancariosMap.hasElement(getParametrosBancarios());
	}

	public ParametrosBancariosMap getParametrosBancarios() {
		return parametrosBancariosMap;
	}

	public <P extends ParametroBancario<?>> void setParametrosBancarios(ParametrosBancariosMap parametrosBancariosMap) {
		this.parametrosBancariosMap = parametrosBancariosMap;
	}

	public Carteira getCarteira() {
		return carteira;
	}

	public void setCarteira(Carteira carteira) {
		this.carteira = carteira;
	}

	public void setJurosMora(BigDecimal jurosMora) {
		this.valorJurosMoraPorAtraso = jurosMora;
	}

	public TipoJurosMora getTipoJurosMora() {
		return tipoJurosMora;
	}

	public void setTipoJurosMora(TipoJurosMora tipoJurosMora) {
		this.tipoJurosMora = tipoJurosMora;
	}

	public Date getDataJurosMora() {
		return dataJurosMora;
	}

	public void setDataJurosMora(Date dataJurosMora) {
		this.dataJurosMora = dataJurosMora;
	}

	public TipoDesconto getTipoDesconto() {
		return tipoDesconto;
	}

	public void setTipoDesconto(TipoDesconto tipoDesconto) {
		this.tipoDesconto = tipoDesconto;
	}

	public TipoMulta getTipoMulta() {
		return tipoMulta;
	}

	public void setTipoMulta(TipoMulta tipoMulta) {
		this.tipoMulta = tipoMulta;
	}

	public Date getDataDesconto() {
		return dataDesconto;
	}

	public void setDataDesconto(Date dataDesconto) {
		this.dataDesconto = dataDesconto;
	}

	public BigDecimal getPercentualDesconto() {
		return percentualDescontoConcedido;
	}

	public void setPercentualDesconto(BigDecimal percentualDesconto) {
		this.percentualDescontoConcedido = percentualDesconto;
	}

	public SimpleDateFormat getSdf() {
		return sdf;
	}

	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}

	public BigDecimal getPercentualDescontoConcedido() {
		return percentualDescontoConcedido;
	}

	public void setPercentualDescontoConcedido(BigDecimal percentualDescontoConcedido) {
		this.percentualDescontoConcedido = percentualDescontoConcedido;
	}

	public BigDecimal getPercentualMulta() {
		return percentualMulta;
	}

	public void setPercentualMulta(BigDecimal percentualMulta) {
		this.percentualMulta = percentualMulta;
	}

	public ParametrosBancariosMap getParametrosBancariosMap() {
		return parametrosBancariosMap;
	}

	public void setParametrosBancariosMap(ParametrosBancariosMap parametrosBancariosMap) {
		this.parametrosBancariosMap = parametrosBancariosMap;
	}

	public TipoDeBaixaDevolucao getTipoBaixaDevolucao() {
		return tipoBaixaDevolucao;
	}

	public BigDecimal getValorIOF() {
		return valorIOF;
	}

	public void setValorIOF(BigDecimal valorIOF) {
		this.valorIOF = valorIOF;
	}

	public BigDecimal getValorAbatimento() {
		return valorAbatimentoConcedido;
	}

	public void setValorAbatimento(BigDecimal valorAbatimento) {
		this.valorAbatimentoConcedido = valorAbatimento;
	}

	public BigDecimal getValorPagamento() {
		return valorPagamento;
	}

	public void setValorPagamento(BigDecimal valorPagamento) {
		this.valorPagamento = valorPagamento;
	}

	public TipoProtesto getTipoProtesto() {
		return tipoProtesto;
	}

	public void setTipoProtesto(TipoProtesto tipoProtesto) {
		this.tipoProtesto = tipoProtesto;
	}

	public Integer getNrDiasProtesto() {
		return nrDiasProtesto;
	}

	public void setNrDiasProtesto(Integer nrDiasProtesto) {
		this.nrDiasProtesto = nrDiasProtesto;
	}

	public TipoDeBaixaDevolucao getTipoDeBaixaDevolucao() {
		return tipoBaixaDevolucao;
	}

	public void setTipoBaixaDevolucao(TipoDeBaixaDevolucao tipoBaixaDevolucao) {
		this.tipoBaixaDevolucao = tipoBaixaDevolucao;
	}

	public Integer getNrDiasBaixaDevolucao() {
		return nrDiasBaixaDevolucao;
	}

	public void setNrDiasBaixaDevolucao(Integer nrDiasBaixaDevolucao) {
		this.nrDiasBaixaDevolucao = nrDiasBaixaDevolucao;
	}

	public Integer getInstrucaoCobranca1() {
		return instrucaoCobranca1;
	}

	public void setInstrucaoCobranca1(Integer instrucaoCobranca1) {
		this.instrucaoCobranca1 = instrucaoCobranca1;
	}

	public Integer getInstrucaoCobranca2() {
		return instrucaoCobranca2;
	}

	public void setInstrucaoCobranca2(Integer instrucaoCobranca2) {
		this.instrucaoCobranca2 = instrucaoCobranca2;
	}
	//
	// @Override
	// public String toString() {
	// return "Titulo [numeroDocumento=" + numeroDocumento + ", dataDocumento="
	// + (dataDocumento == null ? "" : sdf.format(dataDocumento)) + ",
	// dataVencimento="
	// + (dataVencimento == null ? "" : sdf.format(dataVencimento)) + ",
	// tipoDeMoeda=" + tipoMoeda
	// + ", valorTitulo=" + valorTitulo + ", valorDesconto=" +
	// valorDescontoConcedido + ", percentualDesconto="
	// + percentualDescontoConcedido + ", valorJurosMora=" + valorJurosMoraPorAtraso
	// + ", valorAcrecimo=" + valorAcrecimo +
	// ", valorCobrado=" + valorCobrado + ", valorIOF="
	// + valorIOF + ", valorAbatimento=" + valorAbatimentoConcedido + ",
	// nrDiasProtesto=" + nrDiasProtesto
	// + ", tipoDeBaixaDevolucao=" + tipoBaixaDevolucao + ", nrDiasBaixaDevolucao="
	// + nrDiasBaixaDevolucao
	// + ", tipoDeDocumento=" + tipoDocumento + ", tipoDeJurosMora=" + tipoJurosMora
	// + ", tipoDeDesconto="
	// + tipoDesconto + ", tipoDeProtesto=" + tipoProtesto + ", dataDesconto="
	// + (dataDesconto == null ? "" : sdf.format(dataDesconto)) + ", dataJurosMora="
	// + (dataJurosMora == null ? "" : sdf.format(dataJurosMora)) + ", nossoNumero="
	// + nossoNumero
	// + ", digitoDoNossoNumero=" + digitoNossoNumero + ", contaBancaria=" +
	// contaBancaria + ", cedente="
	// + cedente + ", sacado=" + sacado + ", sacadorAvalista=" + sacadorAvalista +
	// ", carteira=" + carteira
	// + ", parametrosBancariosMap=" + parametrosBancariosMap + ", aceite=" + aceite
	// + ", instrucaoCobranca1="
	// + instrucaoCobranca1 + ", instrucaoCobranca2=" + instrucaoCobranca2 + "]";
	// }

	public BigDecimal getValorAbatimentoConcedido() {
		return valorAbatimentoConcedido;
	}

	public void setValorAbatimentoConcedido(BigDecimal valorAbatimentoConcedido) {
		this.valorAbatimentoConcedido = valorAbatimentoConcedido;
	}

	public BigDecimal getValorJuros() {
		return valorJuros;
	}

	public void setValorJuros(BigDecimal valorJuros) {
		this.valorJuros = valorJuros;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public BigDecimal getValorDeducao() {
		return valorDeducao;
	}

	public void setValorDeducao(BigDecimal valorDeducao) {
		this.valorDeducao = valorDeducao;
	}

	@Override
	public String toString() {
		return "Titulo [numeroDocumento=" + numeroDocumento + ", quantidadeParcela=" + quantidadeParcela + ", dataDocumento=" + dataDocumento + ", dataVencimento="
				+ formatarData(dataVencimento) + ", tipoMoeda=" + tipoMoeda + ", valorTitulo=" + valorTitulo
				+ ", valorDescontoConcedido=" + valorDescontoConcedido + ", percentualDescontoConcedido="
				+ percentualDescontoConcedido + ", valorJurosMoraPorAtraso=" + valorJurosMoraPorAtraso
				+ ", valorAcrecimo=" + valorAcrecimo + ", valorJuros=" + valorJuros + ", valorDesconto=" + valorDesconto
				+ ", valorDeducao=" + valorDeducao + ", valorCobrado=" + valorCobrado + ", valorIOF=" + valorIOF
				+ ", valorAbatimentoConcedido=" + valorAbatimentoConcedido + ", valorAbatimento=" + valorAbatimento
				+ ", nrDiasProtesto=" + nrDiasProtesto + ", tipoBaixaDevolucao=" + tipoBaixaDevolucao
				+ ", nrDiasBaixaDevolucao=" + nrDiasBaixaDevolucao + ", tipoDocumento=" + tipoDocumento
				+ ", tipoJurosMora=" + tipoJurosMora + ", tipoDesconto=" + tipoDesconto + ", tipoProtesto="
				+ tipoProtesto + ", dataDesconto=" + formatarData(dataDesconto) + ", dataJurosMora="
				+ formatarData(dataJurosMora) + ", nossoNumero=" + nossoNumero + ", digitoNossoNumero="
				+ digitoNossoNumero + ", contaBancaria=" + contaBancaria + ", cedente=" + cedente + ", sacado=" + sacado
				+ ", sacadorAvalista=" + sacadorAvalista + ", carteira=" + carteira + ", parametrosBancariosMap="
				+ parametrosBancariosMap + ", aceite=" + aceite + ", instrucaoCobranca1=" + instrucaoCobranca1
				+ ", instrucaoCobranca2=" + instrucaoCobranca2 + "]";
	}

	private String formatarData(Date data) {
		if (data == null)
			return "";
		return sdf.format(data);
	}

}
