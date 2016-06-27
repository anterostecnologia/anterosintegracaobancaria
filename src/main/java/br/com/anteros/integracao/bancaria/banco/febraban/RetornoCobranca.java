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
package br.com.anteros.integracao.bancaria.banco.febraban;

import java.math.BigDecimal;
import java.util.Date;

import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.TitulosCobrancaSegmentoT;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.TitulosCobrancaSegmentoU;

public class RetornoCobranca {

	private String codigoSegmentoRegistroT;
	private Integer codigoBancoT;
	private Integer loteServicoT;
	private Integer tipoRegistroT;
	private Integer numeroSequencialRegistroT;
	private Integer codigoMovimentoRetornoT;
	private Integer agenciaMantenedoraT;
	private String digitoVerificadorAgenciaT;
	private Integer numeroContaCorrenteT;
	private String digitoVerificadorContaCorrenteT;
	private String digitoVerificadorAgenciaContaT;
	private String identificadorTituloT;
	private String codigoCarteiraT;
	private String numeroDocumentoCobrancaT;
	private String dataVencimentoTituloT;
	private BigDecimal valorNominalTituloT;
	private Integer numeroBancoT;
	private Integer agenciaCobradoraRecebedoraT;
	private String digitoVerificadorAgenciaCobradoraT;
	private String identificadorTituloEmpresaT;
	private String codigoMoedaT;
	private Integer tipoInscricaoSacadoAvalistaT;
	private Long numeroInscricaoSacadoAvalistaT;
	private String nomeSacadorAvalistaT;
	private String numeroContratoOperacaoCreditoT;
	private BigDecimal valorTarifaCustasT;
	private String identificadorRejeicaoT;

	private String codigoSegmentoRegistroU;
	private Integer codigoBancoU;
	private Integer loteServicoU;
	private Integer tipoRegistroU;
	private Integer numeroSequencialRegistroU;
	private Integer codigoMovimentoRetornoU;
	private BigDecimal valorJurosMultasEncargosU;
	private BigDecimal valorDescontoU;
	private BigDecimal valorAbatimentoU;
	private BigDecimal valorIOFU;
	private BigDecimal valorPagoSacadoU;
	private BigDecimal valorLiquidoCreditadoU;
	private BigDecimal valorOutrasDespesasU;
	private BigDecimal valorOutrosCreditosU;
	private Date dataOcorrenciaPagamentoU;
	private Date dataEfetivacaoCreditoU;
	private String codigoOcorrenciaU;
	private Date dataOcorrenciaU;
	private BigDecimal valorOcorrenciaU;
	private String complementoOcorrenciaU;
	private Integer codigoBancoCorrespondenteU;
	private String nossoNumeroBancoCorrespondenteU;

	private RetornoCobranca(TitulosCobrancaSegmentoT segmentoT, TitulosCobrancaSegmentoU segmentoU) {
		/**
		 * Segmento T
		 */
		this.codigoSegmentoRegistroT = segmentoT.getCodigoSegmentoRegistro();
		this.codigoBancoT = segmentoT.getCodigoBanco();
		this.loteServicoT = segmentoT.getLoteServico();
		this.tipoRegistroT = segmentoT.getTipoRegistro();
		this.numeroSequencialRegistroT = segmentoT.getNumeroSequencialRegistro();
		this.codigoMovimentoRetornoT = segmentoT.getCodigoMovimentoRetorno();
		this.agenciaMantenedoraT = segmentoT.getAgenciaMantenedora();
		this.digitoVerificadorAgenciaT = segmentoT.getDigitoVerificadorAgencia();
		this.numeroContaCorrenteT = segmentoT.getNumeroContaCorrente();
		this.digitoVerificadorContaCorrenteT = segmentoT.getDigitoVerificadorContaCorrente();
		this.digitoVerificadorAgenciaContaT = segmentoT.getDigitoVerificadorAgenciaConta();
		this.identificadorTituloT = segmentoT.getIdentificadorTitulo();
		this.codigoCarteiraT = segmentoT.getCodigoCarteira();
		this.numeroDocumentoCobrancaT = segmentoT.getNumeroDocumentoCobranca();
		this.dataVencimentoTituloT = segmentoT.getDataVencimentoTitulo();
		this.valorNominalTituloT = segmentoT.getValorNominalTitulo();
		this.numeroBancoT = segmentoT.getNumeroBanco();
		this.agenciaCobradoraRecebedoraT = segmentoT.getAgenciaCobradoraRecebedora();
		this.digitoVerificadorAgenciaCobradoraT = segmentoT.getDigitoVerificadorAgenciaCobradora();
		this.identificadorTituloEmpresaT = segmentoT.getIdentificadorTituloEmpresa();
		this.codigoMoedaT = segmentoT.getCodigoMoeda();
		this.tipoInscricaoSacadoAvalistaT = segmentoT.getTipoInscricaoSacadoAvalista();
		this.numeroInscricaoSacadoAvalistaT = segmentoT.getNumeroInscricaoSacadoAvalista();
		this.nomeSacadorAvalistaT = segmentoT.getNomeSacadorAvalista();
		this.numeroContratoOperacaoCreditoT = segmentoT.getNumeroContratoOperacaoCredito();
		this.valorTarifaCustasT = segmentoT.getValorTarifaCustas();
		this.identificadorRejeicaoT = segmentoT.getIdentificadorRejeicao();

		/**
		 * Segmento U
		 */
		this.codigoSegmentoRegistroU = segmentoU.getCodigoSegmentoRegistro();
		this.codigoBancoU = segmentoU.getCodigoBanco();
		this.loteServicoU = segmentoU.getLoteServico();
		this.tipoRegistroU = segmentoU.getTipoRegistro();
		this.numeroSequencialRegistroU = segmentoU.getNumeroSequencialRegistro();
		this.codigoMovimentoRetornoU = segmentoU.getCodigoMovimentoRetorno();
		this.valorJurosMultasEncargosU = segmentoU.getValorJurosMultasEncargos();
		this.valorDescontoU = segmentoU.getValorDesconto();
		this.valorAbatimentoU = segmentoU.getValorAbatimento();
		this.valorIOFU = segmentoU.getValorIOF();
		this.valorPagoSacadoU = segmentoU.getValorPagoSacado();
		this.valorLiquidoCreditadoU = segmentoU.getValorLiquidoCreditado();
		this.valorOutrasDespesasU = segmentoU.getValorOutrasDespesas();
		this.valorOutrosCreditosU = segmentoU.getValorOutrosCreditos();
		this.dataOcorrenciaPagamentoU = segmentoU.getDataOcorrenciaPagamento();
		this.dataEfetivacaoCreditoU = segmentoU.getDataEfetivacaoCredito();
		this.codigoOcorrenciaU = segmentoU.getCodigoOcorrencia();
		this.dataOcorrenciaU = segmentoU.getDataOcorrencia();
		this.valorOcorrenciaU = segmentoU.getValorOcorrencia();
		this.complementoOcorrenciaU = segmentoU.getComplementoOcorrencia();
		this.codigoBancoCorrespondenteU = segmentoU.getCodigoBancoCorrespondente();
		this.nossoNumeroBancoCorrespondenteU = segmentoU.getNossoNumeroBancoCorrespondente();
	}

	public static RetornoCobranca of(TitulosCobrancaSegmentoT segmentoT, TitulosCobrancaSegmentoU segmentoU) {
		return new RetornoCobranca(segmentoT, segmentoU);
	}

	public String getCodigoSegmentoRegistroT() {
		return codigoSegmentoRegistroT;
	}

	public void setCodigoSegmentoRegistroT(String codigoSegmentoRegistroT) {
		this.codigoSegmentoRegistroT = codigoSegmentoRegistroT;
	}

	public Integer getCodigoBancoT() {
		return codigoBancoT;
	}

	public void setCodigoBancoT(Integer codigoBancoT) {
		this.codigoBancoT = codigoBancoT;
	}

	public Integer getLoteServicoT() {
		return loteServicoT;
	}

	public void setLoteServicoT(Integer loteServicoT) {
		this.loteServicoT = loteServicoT;
	}

	public Integer getTipoRegistroT() {
		return tipoRegistroT;
	}

	public void setTipoRegistroT(Integer tipoRegistroT) {
		this.tipoRegistroT = tipoRegistroT;
	}

	public Integer getNumeroSequencialRegistroT() {
		return numeroSequencialRegistroT;
	}

	public void setNumeroSequencialRegistroT(Integer numeroSequencialRegistroT) {
		this.numeroSequencialRegistroT = numeroSequencialRegistroT;
	}

	public Integer getCodigoMovimentoRetornoT() {
		return codigoMovimentoRetornoT;
	}

	public void setCodigoMovimentoRetornoT(Integer codigoMovimentoRetornoT) {
		this.codigoMovimentoRetornoT = codigoMovimentoRetornoT;
	}

	public Integer getAgenciaMantenedoraT() {
		return agenciaMantenedoraT;
	}

	public void setAgenciaMantenedoraT(Integer agenciaMantenedoraT) {
		this.agenciaMantenedoraT = agenciaMantenedoraT;
	}

	public String getDigitoVerificadorAgenciaT() {
		return digitoVerificadorAgenciaT;
	}

	public void setDigitoVerificadorAgenciaT(String digitoVerificadorAgenciaT) {
		this.digitoVerificadorAgenciaT = digitoVerificadorAgenciaT;
	}

	public Integer getNumeroContaCorrenteT() {
		return numeroContaCorrenteT;
	}

	public void setNumeroContaCorrenteT(Integer numeroContaCorrenteT) {
		this.numeroContaCorrenteT = numeroContaCorrenteT;
	}

	public String getDigitoVerificadorContaCorrenteT() {
		return digitoVerificadorContaCorrenteT;
	}

	public void setDigitoVerificadorContaCorrenteT(String digitoVerificadorContaCorrenteT) {
		this.digitoVerificadorContaCorrenteT = digitoVerificadorContaCorrenteT;
	}

	public String getDigitoVerificadorAgenciaContaT() {
		return digitoVerificadorAgenciaContaT;
	}

	public void setDigitoVerificadorAgenciaContaT(String digitoVerificadorAgenciaContaT) {
		this.digitoVerificadorAgenciaContaT = digitoVerificadorAgenciaContaT;
	}

	public String getIdentificadorTituloT() {
		return identificadorTituloT;
	}

	public void setIdentificadorTituloT(String identificadorTituloT) {
		this.identificadorTituloT = identificadorTituloT;
	}

	public String getCodigoCarteiraT() {
		return codigoCarteiraT;
	}

	public void setCodigoCarteiraT(String codigoCarteiraT) {
		this.codigoCarteiraT = codigoCarteiraT;
	}

	public String getNumeroDocumentoCobrancaT() {
		return numeroDocumentoCobrancaT;
	}

	public void setNumeroDocumentoCobrancaT(String numeroDocumentoCobrancaT) {
		this.numeroDocumentoCobrancaT = numeroDocumentoCobrancaT;
	}

	public String getDataVencimentoTituloT() {
		return dataVencimentoTituloT;
	}

	public void setDataVencimentoTituloT(String dataVencimentoTituloT) {
		this.dataVencimentoTituloT = dataVencimentoTituloT;
	}

	public BigDecimal getValorNominalTituloT() {
		return valorNominalTituloT;
	}

	public void setValorNominalTituloT(BigDecimal valorNominalTituloT) {
		this.valorNominalTituloT = valorNominalTituloT;
	}

	public Integer getNumeroBancoT() {
		return numeroBancoT;
	}

	public void setNumeroBancoT(Integer numeroBancoT) {
		this.numeroBancoT = numeroBancoT;
	}

	public Integer getAgenciaCobradoraRecebedoraT() {
		return agenciaCobradoraRecebedoraT;
	}

	public void setAgenciaCobradoraRecebedoraT(Integer agenciaCobradoraRecebedoraT) {
		this.agenciaCobradoraRecebedoraT = agenciaCobradoraRecebedoraT;
	}

	public String getDigitoVerificadorAgenciaCobradoraT() {
		return digitoVerificadorAgenciaCobradoraT;
	}

	public void setDigitoVerificadorAgenciaCobradoraT(String digitoVerificadorAgenciaCobradoraT) {
		this.digitoVerificadorAgenciaCobradoraT = digitoVerificadorAgenciaCobradoraT;
	}

	public String getIdentificadorTituloEmpresaT() {
		return identificadorTituloEmpresaT;
	}

	public void setIdentificadorTituloEmpresaT(String identificadorTituloEmpresaT) {
		this.identificadorTituloEmpresaT = identificadorTituloEmpresaT;
	}

	public String getCodigoMoedaT() {
		return codigoMoedaT;
	}

	public void setCodigoMoedaT(String codigoMoedaT) {
		this.codigoMoedaT = codigoMoedaT;
	}

	public Integer getTipoInscricaoSacadoAvalistaT() {
		return tipoInscricaoSacadoAvalistaT;
	}

	public void setTipoInscricaoSacadoAvalistaT(Integer tipoInscricaoSacadoAvalistaT) {
		this.tipoInscricaoSacadoAvalistaT = tipoInscricaoSacadoAvalistaT;
	}

	public Long getNumeroInscricaoSacadoAvalistaT() {
		return numeroInscricaoSacadoAvalistaT;
	}

	public void setNumeroInscricaoSacadoAvalistaT(Long numeroInscricaoSacadoAvalistaT) {
		this.numeroInscricaoSacadoAvalistaT = numeroInscricaoSacadoAvalistaT;
	}

	public String getNomeSacadorAvalistaT() {
		return nomeSacadorAvalistaT;
	}

	public void setNomeSacadorAvalistaT(String nomeSacadorAvalistaT) {
		this.nomeSacadorAvalistaT = nomeSacadorAvalistaT;
	}

	public String getNumeroContratoOperacaoCreditoT() {
		return numeroContratoOperacaoCreditoT;
	}

	public void setNumeroContratoOperacaoCreditoT(String numeroContratoOperacaoCreditoT) {
		this.numeroContratoOperacaoCreditoT = numeroContratoOperacaoCreditoT;
	}

	public BigDecimal getValorTarifaCustasT() {
		return valorTarifaCustasT;
	}

	public void setValorTarifaCustasT(BigDecimal valorTarifaCustasT) {
		this.valorTarifaCustasT = valorTarifaCustasT;
	}

	public String getIdentificadorRejeicaoT() {
		return identificadorRejeicaoT;
	}

	public void setIdentificadorRejeicaoT(String identificadorRejeicaoT) {
		this.identificadorRejeicaoT = identificadorRejeicaoT;
	}

	public String getCodigoSegmentoRegistroU() {
		return codigoSegmentoRegistroU;
	}

	public void setCodigoSegmentoRegistroU(String codigoSegmentoRegistroU) {
		this.codigoSegmentoRegistroU = codigoSegmentoRegistroU;
	}

	public Integer getCodigoBancoU() {
		return codigoBancoU;
	}

	public void setCodigoBancoU(Integer codigoBancoU) {
		this.codigoBancoU = codigoBancoU;
	}

	public Integer getLoteServicoU() {
		return loteServicoU;
	}

	public void setLoteServicoU(Integer loteServicoU) {
		this.loteServicoU = loteServicoU;
	}

	public Integer getTipoRegistroU() {
		return tipoRegistroU;
	}

	public void setTipoRegistroU(Integer tipoRegistroU) {
		this.tipoRegistroU = tipoRegistroU;
	}

	public Integer getNumeroSequencialRegistroU() {
		return numeroSequencialRegistroU;
	}

	public void setNumeroSequencialRegistroU(Integer numeroSequencialRegistroU) {
		this.numeroSequencialRegistroU = numeroSequencialRegistroU;
	}

	public Integer getCodigoMovimentoRetornoU() {
		return codigoMovimentoRetornoU;
	}

	public void setCodigoMovimentoRetornoU(Integer codigoMovimentoRetornoU) {
		this.codigoMovimentoRetornoU = codigoMovimentoRetornoU;
	}

	public BigDecimal getValorJurosMultasEncargosU() {
		return valorJurosMultasEncargosU;
	}

	public void setValorJurosMultasEncargosU(BigDecimal valorJurosMultasEncargosU) {
		this.valorJurosMultasEncargosU = valorJurosMultasEncargosU;
	}

	public BigDecimal getValorDescontoU() {
		return valorDescontoU;
	}

	public void setValorDescontoU(BigDecimal valorDescontoU) {
		this.valorDescontoU = valorDescontoU;
	}

	public BigDecimal getValorAbatimentoU() {
		return valorAbatimentoU;
	}

	public void setValorAbatimentoU(BigDecimal valorAbatimentoU) {
		this.valorAbatimentoU = valorAbatimentoU;
	}

	public BigDecimal getValorIOFU() {
		return valorIOFU;
	}

	public void setValorIOFU(BigDecimal valorIOFU) {
		this.valorIOFU = valorIOFU;
	}

	public BigDecimal getValorPagoSacadoU() {
		return valorPagoSacadoU;
	}

	public void setValorPagoSacadoU(BigDecimal valorPagoSacadoU) {
		this.valorPagoSacadoU = valorPagoSacadoU;
	}

	public BigDecimal getValorLiquidoCreditadoU() {
		return valorLiquidoCreditadoU;
	}

	public void setValorLiquidoCreditadoU(BigDecimal valorLiquidoCreditadoU) {
		this.valorLiquidoCreditadoU = valorLiquidoCreditadoU;
	}

	public BigDecimal getValorOutrasDespesasU() {
		return valorOutrasDespesasU;
	}

	public void setValorOutrasDespesasU(BigDecimal valorOutrasDespesasU) {
		this.valorOutrasDespesasU = valorOutrasDespesasU;
	}

	public BigDecimal getValorOutrosCreditosU() {
		return valorOutrosCreditosU;
	}

	public void setValorOutrosCreditosU(BigDecimal valorOutrosCreditosU) {
		this.valorOutrosCreditosU = valorOutrosCreditosU;
	}

	public Date getDataOcorrenciaPagamentoU() {
		return dataOcorrenciaPagamentoU;
	}

	public void setDataOcorrenciaPagamentoU(Date dataOcorrenciaPagamentoU) {
		this.dataOcorrenciaPagamentoU = dataOcorrenciaPagamentoU;
	}

	public Date getDataEfetivacaoCreditoU() {
		return dataEfetivacaoCreditoU;
	}

	public void setDataEfetivacaoCreditoU(Date dataEfetivacaoCreditoU) {
		this.dataEfetivacaoCreditoU = dataEfetivacaoCreditoU;
	}

	public String getCodigoOcorrenciaU() {
		return codigoOcorrenciaU;
	}

	public void setCodigoOcorrenciaU(String codigoOcorrenciaU) {
		this.codigoOcorrenciaU = codigoOcorrenciaU;
	}

	public Date getDataOcorrenciaU() {
		return dataOcorrenciaU;
	}

	public void setDataOcorrenciaU(Date dataOcorrenciaU) {
		this.dataOcorrenciaU = dataOcorrenciaU;
	}

	public BigDecimal getValorOcorrenciaU() {
		return valorOcorrenciaU;
	}

	public void setValorOcorrenciaU(BigDecimal valorOcorrenciaU) {
		this.valorOcorrenciaU = valorOcorrenciaU;
	}

	public String getComplementoOcorrenciaU() {
		return complementoOcorrenciaU;
	}

	public void setComplementoOcorrenciaU(String complementoOcorrenciaU) {
		this.complementoOcorrenciaU = complementoOcorrenciaU;
	}

	public Integer getCodigoBancoCorrespondenteU() {
		return codigoBancoCorrespondenteU;
	}

	public void setCodigoBancoCorrespondenteU(Integer codigoBancoCorrespondenteU) {
		this.codigoBancoCorrespondenteU = codigoBancoCorrespondenteU;
	}

	public String getNossoNumeroBancoCorrespondenteU() {
		return nossoNumeroBancoCorrespondenteU;
	}

	public void setNossoNumeroBancoCorrespondenteU(String nossoNumeroBancoCorrespondenteU) {
		this.nossoNumeroBancoCorrespondenteU = nossoNumeroBancoCorrespondenteU;
	}

}
