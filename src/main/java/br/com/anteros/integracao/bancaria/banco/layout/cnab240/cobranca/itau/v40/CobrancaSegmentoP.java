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
package br.com.anteros.integracao.bancaria.banco.layout.cnab240.cobranca.itau.v40;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.Formats;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.annotation.RecordData;
import br.com.anteros.flatfile.language.EnumTypes;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.RemessaCobranca;

public class CobrancaSegmentoP implements RecordData {

	@IdType(name = "CD_SEGMENTO_REGISTRO", length = 1, positionField = 5, value = "P")
	private String codigoSegmentoRegistro;

	@Field(name = "CD_BANCO", length = 3, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoBanco;

	@Field(name = "LT_SERVICO", length = 4, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer loteServico;

	@Field(name = "TP_REGISTRO", length = 1, value = "3", padding = Paddings.ZERO_LEFT, type = EnumTypes.INTEGER)
	private Integer tipoRegistro;

	@Field(name = "NR_SEQUENCIAL_REGISTRO", length = 5, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer numeroSequencialRegistro;

	@Field(name = "BRANCOS_1", value = " ", padding = Paddings.WHITE_SPACE_RIGHT, length = 1)
	private String brancos;

	@Field(name = "CD_MOVIMENTO_REMESSA", length = 2, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoMovimentoRemessa;

	@Field(name = "ZEROS_1", type = EnumTypes.INTEGER, length = 1, padding = Paddings.ZERO_LEFT, value = "0")
	private Integer zeros1;

	@Field(name = "AGENCIA_MANTENEDORA", type = EnumTypes.INTEGER, length = 4, padding = Paddings.ZERO_LEFT)
	private Integer agenciaMantenedora;

	@Field(name = "BRANCOS_2", value = " ", padding = Paddings.WHITE_SPACE_RIGHT, length = 1)
	private String brancos2;

	@Field(name = "ZEROS_2", type = EnumTypes.INTEGER, length = 7, padding = Paddings.ZERO_LEFT, value = "0000000")
	private Integer zeros2;

	@Field(name = "NR_CONTACORRENTE", length = 5, type = EnumTypes.LONG)
	private Long numeroContaCorrente;

	@Field(name = "BRANCOS_3", value = " ", padding = Paddings.WHITE_SPACE_RIGHT, length = 1)
	private String brancos3;

	@Field(name = "DIGITO_VERIFICADOR_AGENCIACONTA", length = 1)
	private String digitoVerificadorAgenciaConta;

	@Field(name = "NUMERO_CARTEIRA", length = 3, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer numeroCarteira;

	@Field(name = "NOSSO_NUMERO", length = 8)
	private String nossoNumero;

	@Field(name = "DIGITO_NOSSO_NUMERO", length = 1)
	private String digitoNossoNumero;

	@Field(name = "BRANCOS_4", value = " ", padding = Paddings.WHITE_SPACE_RIGHT, length = 8)
	private String brancos4;

	@Field(name = "ZEROS_3", type = EnumTypes.INTEGER, length = 5, padding = Paddings.ZERO_LEFT)
	private Integer zeros3;

	@Field(name = "NR_DOCUMENTOCOBRANCA", length = 10, padding = Paddings.WHITE_SPACE_RIGHT)
	private String numeroDocumentoCobranca;

	@Field(name = "BRANCOS5", value = " ", padding = Paddings.WHITE_SPACE_RIGHT, length = 5)
	private String brancos5;

	@Field(name = "DT_VENCIMENTO", length = 8, type = EnumTypes.DATE, padding = Paddings.ZERO_LEFT, format = Formats.DATE_DDMMYYYY)
	private Date dtVencimentoTitulo;

	@Field(name = "VL_NOMINAL_TITULO", length = 15, type = EnumTypes.BIGDECIMAL, padding = Paddings.ZERO_LEFT, format = Formats.DECIMAL_DD)
	private BigDecimal vlNominalTitulo;

	@Field(name = "AGENCIA_ENCARREGADA_COBRANCA", length = 5, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer agenciaEncarregadaCobranca;

	@Field(name = "DIGITO_VERIFICADOR_AGENCIA_COBRANCA", length = 1)
	private String digitoVerificadorAgenciaCobranca;

	@Field(name = "ESPECIE_TITULO", length = 2, padding = Paddings.ZERO_LEFT, type = EnumTypes.INTEGER)
	private Integer especieTitulo;

	@Field(name = "ID_TITULO_ACEITO", length = 1)
	private String identificadorTituloAceito;

	@Field(name = "DT_EMISSAO_TITULO", length = 8, type = EnumTypes.DATE, format = Formats.DATE_DDMMYYYY, padding = Paddings.ZERO_LEFT)
	private Date dtEmissaoTitulo;

	@Field(name = "CD_JUROSMORA", length = 1, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoJurosMora;

	@Field(name = "DT_JUROSMORA", length = 8, type = EnumTypes.DATE, format = Formats.DATE_DDMMYYYY)
	private Date dtJurosMora;

	@Field(name = "JUROS_MORA_DIA", length = 15, type = EnumTypes.BIGDECIMAL, padding = Paddings.ZERO_LEFT, format = Formats.DECIMAL_DD)
	private BigDecimal jurosMoraDia;

	@Field(name = "CD_DESCONTO1", type = EnumTypes.INTEGER, length = 1, padding = Paddings.ZERO_LEFT)
	private Integer codigoDesconto1;

	@Field(name = "DT_DESCONTO1", type = EnumTypes.DATE, length = 8, format = Formats.DATE_DDMMYYYY, padding = Paddings.ZERO_LEFT)
	private Date dtDesconto1;

	@Field(name = "VL_PERCENTUAL_CONCEDIDO", length = 15, type = EnumTypes.BIGDECIMAL, padding = Paddings.ZERO_LEFT, format = Formats.DECIMAL_DD)
	private BigDecimal vlPercentualConcedido;

	@Field(name = "VL_IOF_RECOLHIDO", length = 15, type = EnumTypes.BIGDECIMAL, padding = Paddings.ZERO_LEFT, format = Formats.DECIMAL_DD)
	private BigDecimal vlIOFRecolhido;

	@Field(name = "VL_ABATIMENTO", length = 15, type = EnumTypes.BIGDECIMAL, padding = Paddings.ZERO_LEFT, format = Formats.DECIMAL_DD)
	private BigDecimal vlAbatimento;

	@Field(name = "ID_TITULO_EMPRESA", length = 25)
	private String identificadorTituloEmpresa;

	@Field(name = "CD_PROTESTO", length = 1, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoProtesto;

	@Field(name = "NR_DIAS_PROTESTO", length = 2, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer numeroDiasProtesto;

	@Field(name = "CD_BAIXADEVOLUCAO", length = 1, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoBaixaDevolucao;

	@Field(name = "NR_DIAS_BAIXA_DEVOLUCAO", length = 2, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer numeroDiasBaixaDevolucao;

	@Field(name = "ZEROS_4", type = EnumTypes.INTEGER, length = 13, padding = Paddings.ZERO_LEFT)
	private Long zeros4;

	@Field(name = "BRANCOS_1", length = 1, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos1;

	private List<RemessaCobranca> remessas;

	private ContaBancaria contaBancaria;

	public CobrancaSegmentoP(ContaBancaria contaBancaria, List<RemessaCobranca> remessas) {
		this.remessas = remessas;
		this.contaBancaria = contaBancaria;
	}

	public int getNumberOfRecords() {
		return remessas.size();
	}

	public void readRowData(int row, int sequence) {
		this.codigoBanco = contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo(); // G001
		this.loteServico = 1; // G002
		this.numeroSequencialRegistro = sequence;// G038
		this.codigoMovimentoRemessa = remessas.get(row).getCodigoMovimentoRemessa().getTipo();// C004
		this.agenciaMantenedora = contaBancaria.getAgencia().getCodigo();// G008
		this.numeroContaCorrente = contaBancaria.getNumeroDaConta().getCodigoDaConta();// G010
		this.digitoVerificadorAgenciaConta = contaBancaria.getAgencia().getDigitoVerificador();// G012
		this.nossoNumero = remessas.get(row).getTitulo().getNossoNumero();// G069
		this.digitoNossoNumero = remessas.get(row).getTitulo().getDigitoNossoNumero();
		this.numeroDocumentoCobranca = remessas.get(row).getTitulo().getNumeroDocumento();// C011
		this.dtVencimentoTitulo = remessas.get(row).getTitulo().getDataVencimento();// C012
		this.vlNominalTitulo = remessas.get(row).getTitulo().getValorTitulo();// G070
		this.agenciaEncarregadaCobranca = contaBancaria.getAgencia().getCodigo();// C014
		this.digitoVerificadorAgenciaCobranca = contaBancaria.getAgencia().getDigitoVerificador();// G009
		this.especieTitulo = remessas.get(row).getTitulo().getTipoDocumento().getCodigo();// C015
		this.identificadorTituloAceito = remessas.get(row).getTitulo().getAceite().name();// C016
		this.dtEmissaoTitulo = remessas.get(row).getTitulo().getDataDocumento(); // G071
		this.codigoJurosMora = remessas.get(row).getTitulo().getTipoJurosMora().getTipo();// C018
		this.dtJurosMora = remessas.get(row).getTitulo().getDataJurosMora(); // C019
		this.jurosMoraDia = remessas.get(row).getTitulo().getValorJurosMoraPorAtraso(); // C020
		this.codigoDesconto1 = remessas.get(row).getTitulo().getTipoDesconto().getTipo();// C021
		this.dtDesconto1 = remessas.get(row).getTitulo().getDataDesconto(); // C022
		this.vlPercentualConcedido = remessas.get(row).getTitulo().getPercentualDesconto(); // C023;
		this.vlIOFRecolhido = remessas.get(row).getTitulo().getValorIOF();// C024
		this.vlAbatimento = remessas.get(row).getTitulo().getValorAbatimento();// G045
		this.identificadorTituloEmpresa = remessas.get(row).getTitulo().getNumeroDocumento();// G072
		this.codigoProtesto = remessas.get(row).getTitulo().getTipoProtesto().getTipo();// C026
		this.numeroDiasProtesto = remessas.get(row).getTitulo().getNrDiasProtesto();// C027
		this.codigoBaixaDevolucao = remessas.get(row).getTitulo().getTipoDeBaixaDevolucao().getTipo();// C028
		this.numeroDiasBaixaDevolucao = remessas.get(row).getTitulo().getNrDiasBaixaDevolucao();// C029
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

	public Integer getNumeroSequencialRegistro() {
		return numeroSequencialRegistro;
	}

	public void setNumeroSequencialRegistro(Integer numeroSequencialRegistro) {
		this.numeroSequencialRegistro = numeroSequencialRegistro;
	}

	public String getBrancos() {
		return brancos;
	}

	public void setBrancos(String brancos) {
		this.brancos = brancos;
	}

	public Integer getCodigoMovimentoRemessa() {
		return codigoMovimentoRemessa;
	}

	public void setCodigoMovimentoRemessa(Integer codigoMovimentoRemessa) {
		this.codigoMovimentoRemessa = codigoMovimentoRemessa;
	}

	public Integer getAgenciaMantenedora() {
		return agenciaMantenedora;
	}

	public void setAgenciaMantenedora(Integer agenciaMantenedora) {
		this.agenciaMantenedora = agenciaMantenedora;
	}

	public Long getNumeroContaCorrente() {
		return numeroContaCorrente;
	}

	public void setNumeroContaCorrente(Long numeroContaCorrente) {
		this.numeroContaCorrente = numeroContaCorrente;
	}

	public String getDigitoVerificadorAgenciaConta() {
		return digitoVerificadorAgenciaConta;
	}

	public void setDigitoVerificadorAgenciaConta(String digitoVerificadorAgenciaConta) {
		this.digitoVerificadorAgenciaConta = digitoVerificadorAgenciaConta;
	}

	public String getNumeroDocumentoCobranca() {
		return numeroDocumentoCobranca;
	}

	public void setNumeroDocumentoCobranca(String numeroDocumentoCobranca) {
		this.numeroDocumentoCobranca = numeroDocumentoCobranca;
	}

	public Date getDtVencimentoTitulo() {
		return dtVencimentoTitulo;
	}

	public void setDtVencimentoTitulo(Date dtVencimentoTitulo) {
		this.dtVencimentoTitulo = dtVencimentoTitulo;
	}

	public BigDecimal getVlNominalTitulo() {
		return vlNominalTitulo;
	}

	public void setVlNominalTitulo(BigDecimal vlNominalTitulo) {
		this.vlNominalTitulo = vlNominalTitulo;
	}

	public Integer getAgenciaEncarregadaCobranca() {
		return agenciaEncarregadaCobranca;
	}

	public void setAgenciaEncarregadaCobranca(Integer agenciaEncarregadaCobranca) {
		this.agenciaEncarregadaCobranca = agenciaEncarregadaCobranca;
	}

	public String getDigitoVerificadorAgenciaCobranca() {
		return digitoVerificadorAgenciaCobranca;
	}

	public void setDigitoVerificadorAgenciaCobranca(String digitoVerificadorAgenciaCobranca) {
		this.digitoVerificadorAgenciaCobranca = digitoVerificadorAgenciaCobranca;
	}

	public Integer getEspecieTitulo() {
		return especieTitulo;
	}

	public void setEspecieTitulo(Integer especieTitulo) {
		this.especieTitulo = especieTitulo;
	}

	public String getIdentificadorTituloAceito() {
		return identificadorTituloAceito;
	}

	public void setIdentificadorTituloAceito(String identificadorTituloAceito) {
		this.identificadorTituloAceito = identificadorTituloAceito;
	}

	public Date getDtEmissaoTitulo() {
		return dtEmissaoTitulo;
	}

	public void setDtEmissaoTitulo(Date dtEmissaoTitulo) {
		this.dtEmissaoTitulo = dtEmissaoTitulo;
	}

	public Integer getCodigoJurosMora() {
		return codigoJurosMora;
	}

	public void setCodigoJurosMora(Integer codigoJurosMora) {
		this.codigoJurosMora = codigoJurosMora;
	}

	public Date getDtJurosMora() {
		return dtJurosMora;
	}

	public void setDtJurosMora(Date dtJurosMora) {
		this.dtJurosMora = dtJurosMora;
	}

	public BigDecimal getJurosMoraDia() {
		return jurosMoraDia;
	}

	public void setJurosMoraDia(BigDecimal jurosMoraDia) {
		this.jurosMoraDia = jurosMoraDia;
	}

	public Integer getCodigoDesconto1() {
		return codigoDesconto1;
	}

	public void setCodigoDesconto1(Integer codigoDesconto1) {
		this.codigoDesconto1 = codigoDesconto1;
	}

	public Date getDtDesconto1() {
		return dtDesconto1;
	}

	public void setDtDesconto1(Date dtDesconto1) {
		this.dtDesconto1 = dtDesconto1;
	}

	public BigDecimal getVlPercentualConcedido() {
		return vlPercentualConcedido;
	}

	public void setVlPercentualConcedido(BigDecimal vlPercentualConcedido) {
		this.vlPercentualConcedido = vlPercentualConcedido;
	}

	public BigDecimal getVlIOFRecolhido() {
		return vlIOFRecolhido;
	}

	public void setVlIOFRecolhido(BigDecimal vlIOFRecolhido) {
		this.vlIOFRecolhido = vlIOFRecolhido;
	}

	public BigDecimal getVlAbatimento() {
		return vlAbatimento;
	}

	public void setVlAbatimento(BigDecimal vlAbatimento) {
		this.vlAbatimento = vlAbatimento;
	}

	public String getIdentificadorTituloEmpresa() {
		return identificadorTituloEmpresa;
	}

	public void setIdentificadorTituloEmpresa(String identificadorTituloEmpresa) {
		this.identificadorTituloEmpresa = identificadorTituloEmpresa;
	}

	public Integer getCodigoProtesto() {
		return codigoProtesto;
	}

	public void setCodigoProtesto(Integer codigoProtesto) {
		this.codigoProtesto = codigoProtesto;
	}

	public Integer getNumeroDiasProtesto() {
		return numeroDiasProtesto;
	}

	public void setNumeroDiasProtesto(Integer numeroDiasProtesto) {
		this.numeroDiasProtesto = numeroDiasProtesto;
	}

	public Integer getCodigoBaixaDevolucao() {
		return codigoBaixaDevolucao;
	}

	public void setCodigoBaixaDevolucao(Integer codigoBaixaDevolucao) {
		this.codigoBaixaDevolucao = codigoBaixaDevolucao;
	}

	public Integer getNumeroDiasBaixaDevolucao() {
		return numeroDiasBaixaDevolucao;
	}

	public void setNumeroDiasBaixaDevolucao(Integer numeroDiasBaixaDevolucao) {
		this.numeroDiasBaixaDevolucao = numeroDiasBaixaDevolucao;
	}

	public Integer getZeros1() {
		return zeros1;
	}

	public void setZeros1(Integer zeros1) {
		this.zeros1 = zeros1;
	}

	public String getBrancos2() {
		return brancos2;
	}

	public void setBrancos2(String brancos2) {
		this.brancos2 = brancos2;
	}

	public Integer getZeros2() {
		return zeros2;
	}

	public void setZeros2(Integer zeros2) {
		this.zeros2 = zeros2;
	}

	public String getBrancos3() {
		return brancos3;
	}

	public void setBrancos3(String brancos3) {
		this.brancos3 = brancos3;
	}

	public Integer getNumeroCarteira() {
		return numeroCarteira;
	}

	public void setNumeroCarteira(Integer numeroCarteira) {
		this.numeroCarteira = numeroCarteira;
	}

	public String getNossoNumero() {
		return nossoNumero;
	}

	public void setNossoNumero(String nossoNumero) {
		this.nossoNumero = nossoNumero;
	}

	public String getDigitoNossoNumero() {
		return digitoNossoNumero;
	}

	public void setDigitoNossoNumero(String digitoNossoNumero) {
		this.digitoNossoNumero = digitoNossoNumero;
	}

	public String getBrancos4() {
		return brancos4;
	}

	public void setBrancos4(String brancos4) {
		this.brancos4 = brancos4;
	}

	public Integer getZeros3() {
		return zeros3;
	}

	public void setZeros3(Integer zeros3) {
		this.zeros3 = zeros3;
	}

	public String getBrancos5() {
		return brancos5;
	}

	public void setBrancos5(String brancos5) {
		this.brancos5 = brancos5;
	}

	public Long getZeros4() {
		return zeros4;
	}

	public void setZeros4(Long zeros4) {
		this.zeros4 = zeros4;
	}

	public ContaBancaria getContaBancaria() {
		return contaBancaria;
	}

	public void setContaBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

	public String getBrancos1() {
		return brancos1;
	}

	public void setBrancos1(String brancos1) {
		this.brancos1 = brancos1;
	}

	public List<RemessaCobranca> getRemessas() {
		return remessas;
	}

	public void setRemessas(List<RemessaCobranca> remessas) {
		this.remessas = remessas;
	}

	public static CobrancaSegmentoP of(ContaBancaria contaBancaria, List<RemessaCobranca> remessas) {
		return new CobrancaSegmentoP(contaBancaria, remessas);
	}

	public void set(br.com.anteros.flatfile.Record record) {

	}

}
