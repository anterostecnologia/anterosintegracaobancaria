package br.com.anteros.integracao.bancaria.banco.febraban.cnab400.bancobrasil;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import br.com.anteros.flatfile.Record;
import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.Formats;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.language.EnumTypes;
import br.com.anteros.integracao.bancaria.banco.febraban.ContaBancaria;

public class TitulosCobrancaDetalheRetorno {

	@IdType(name = "CD_REGISTRO", length = 1, position = 1, value = "1")
	private Integer codigoRegistro;

	@Field(name = "BRANCOS1", length = 2, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos1;

	@Field(name = "BRANCOS2", length = 14, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos2;

	@Field(name = "CD_EMPRESA", length = 14, type = EnumTypes.LONG, padding = Paddings.ZERO_LEFT)
	private Long codigoEmpresa;

	@Field(name = "NR_CONVENIO", length = 7, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer numeroConvenio;

	@Field(name = "BRANCOS3", length = 25, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos3;

	@Field(name = "NOSSO_NUMERO", length = 17)
	private String nossoNumero;

	@Field(name = "TP_COBRANCA", length = 1)
	private String tipoCobranca;

	@Field(name = "TP_COBRANCA_ESPECIFICO", length = 1)
	private String tipoCobrancaEspecifico;

	@Field(name = "BRANCOS4", length = 4, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos4;

	@Field(name = "BRANCOS5", length = 2, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos5;

	@Field(name = "BRANCOS6", length = 3, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos6;

	@Field(name = "VARIACAO_CARTEIRA", length = 3)
	private String variacaoCarteira;

	@Field(name = "BRANCOS7", length = 1, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos7;

	@Field(name = "TAXA_DESCONTO", length = 5, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD)
	private BigDecimal taxaDesconto;

	@Field(name = "TAXA_IOF", length = 5, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD)
	private BigDecimal taxaIOF;

	@Field(name = "BRANCOS8", length = 1, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos8;

	@Field(name = "CARTEIRA", length = 2)
	private String carteira;

	@Field(name = "CD_OCORRENCIA", length = 2, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoOcorrencia;

	@Field(name = "DT_OCORRENCIA", length = 6, type = EnumTypes.DATE, format = Formats.DATE_DDMMYY)
	private Date dataOcorrencia;

	@Field(name = "NR_DOCUMENTO", length = 10)
	private String numeroDocumento;

	@Field(name = "BRANCOS9", length = 20, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos9;

	@Field(name = "DT_VENCIMENTO", length = 6, type = EnumTypes.DATE, format = Formats.DATE_DDMMYY)
	private Date dataVencimento;

	@Field(name = "VL_TITULO", length = 13, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD)
	private BigDecimal valorTitulo;

	@Field(name = "CD_BANCO", length = 3, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoBanco;

	@Field(name = "BRANCOS10", length = 20, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos10;

	@Field(name = "BRANCOS11", length = 1, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos11;

	@Field(name = "BRANCOS12", length = 2, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos12;

	@Field(name = "DT_CREDITO", length = 6, type = EnumTypes.DATE, format = Formats.DATE_DDMMYY)
	private Date dataCredito;

	@Field(name = "VL_TARIFA", length = 7, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD)
	private BigDecimal valorTarifa;

	@Field(name = "VL_OUTRASDESPESAS", length = 13, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD)
	private BigDecimal valorOutrasDespesas;

	@Field(name = "VL_JUROSDESCONTO", length = 13, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD)
	private BigDecimal valorJurosDesconto;

	@Field(name = "VL_IOF", length = 13, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD)
	private BigDecimal valorIOF;

	@Field(name = "VL_ABATIMENTO", length = 13, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD)
	private BigDecimal valorAbatimento;

	@Field(name = "VL_DESCONTO", length = 13, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD)
	private BigDecimal valorDesconto;

	@Field(name = "VL_PAGO", length = 13, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD)
	private BigDecimal valorPago;

	@Field(name = "VL_JUROS", length = 13, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD)
	private BigDecimal valorJuros;

	@Field(name = "VL_OUTROS_CREDITOS", length = 13, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD)
	private BigDecimal valorOutrosCreditos;

	@Field(name = "BRANCOS13", length = 13, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos13;

	@Field(name = "VL_LANCAMENTO", length = 13, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD)
	private BigDecimal valorLancamento;

	@Field(name = "INDICATIVO_DEBITO_CREDITO", length = 1)
	private String indicativoDebitoCredito;

	@Field(name = "INDICADOR_VALOR", length = 1)
	private String indicadorValor;

	@Field(name = "BRANCOS14", length = 12, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos14;

	@Field(name = "BRANCOS15", length = 1, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos15;

	@Field(name = "BRANCOS16", length = 9, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos16;

	@Field(name = "BRANCOS17", length = 7, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos17;

	@Field(name = "BRANCOS18", length = 9, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos18;

	@Field(name = "BRANCOS19", length = 7, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos19;

	@Field(name = "BRANCOS20", length = 9, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos20;

	@Field(name = "BRANCOS21", length = 7, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos21;

	@Field(name = "BRANCOS22", length = 9, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos22;

	@Field(name = "BRANCOS23", length = 2, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos23;

	@Field(name = "BRANCOS24", length = 2, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos24;

	@Field(name = "NR_SEQUENCIAL_REGISTRO", length = 6)
	private Integer numeroSequencialRegistro;

	public TitulosCobrancaDetalheRetorno(ContaBancaria contaBancaria) {

	}

	public Integer getCodigoRegistro() {
		return codigoRegistro;
	}

	public void setCodigoRegistro(Integer codigoRegistro) {
		this.codigoRegistro = codigoRegistro;
	}

	public String getBrancos1() {
		return brancos1;
	}

	public void setBrancos1(String brancos1) {
		this.brancos1 = brancos1;
	}

	public String getBrancos2() {
		return brancos2;
	}

	public void setBrancos2(String brancos2) {
		this.brancos2 = brancos2;
	}

	public Long getCodigoEmpresa() {
		return codigoEmpresa;
	}

	public void setCodigoEmpresa(Long codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}

	public Integer getNumeroConvenio() {
		return numeroConvenio;
	}

	public void setNumeroConvenio(Integer numeroConvenio) {
		this.numeroConvenio = numeroConvenio;
	}

	public String getBrancos3() {
		return brancos3;
	}

	public void setBrancos3(String brancos3) {
		this.brancos3 = brancos3;
	}

	public String getNossoNumero() {
		return nossoNumero;
	}

	public void setNossoNumero(String nossoNumero) {
		this.nossoNumero = nossoNumero;
	}

	public String getTipoCobranca() {
		return tipoCobranca;
	}

	public void setTipoCobranca(String tipoCobranca) {
		this.tipoCobranca = tipoCobranca;
	}

	public String getTipoCobrancaEspecifico() {
		return tipoCobrancaEspecifico;
	}

	public void setTipoCobrancaEspecifico(String tipoCobrancaEspecifico) {
		this.tipoCobrancaEspecifico = tipoCobrancaEspecifico;
	}

	public String getBrancos4() {
		return brancos4;
	}

	public void setBrancos4(String brancos4) {
		this.brancos4 = brancos4;
	}

	public String getBrancos5() {
		return brancos5;
	}

	public void setBrancos5(String brancos5) {
		this.brancos5 = brancos5;
	}

	public String getBrancos6() {
		return brancos6;
	}

	public void setBrancos6(String brancos6) {
		this.brancos6 = brancos6;
	}

	public String getVariacaoCarteira() {
		return variacaoCarteira;
	}

	public void setVariacaoCarteira(String variacaoCarteira) {
		this.variacaoCarteira = variacaoCarteira;
	}

	public String getBrancos7() {
		return brancos7;
	}

	public void setBrancos7(String brancos7) {
		this.brancos7 = brancos7;
	}

	public BigDecimal getTaxaDesconto() {
		return taxaDesconto;
	}

	public void setTaxaDesconto(BigDecimal taxaDesconto) {
		this.taxaDesconto = taxaDesconto;
	}

	public BigDecimal getTaxaIOF() {
		return taxaIOF;
	}

	public void setTaxaIOF(BigDecimal taxaIOF) {
		this.taxaIOF = taxaIOF;
	}

	public String getBrancos8() {
		return brancos8;
	}

	public void setBrancos8(String brancos8) {
		this.brancos8 = brancos8;
	}

	public String getCarteira() {
		return carteira;
	}

	public void setCarteira(String carteira) {
		this.carteira = carteira;
	}

	public Integer getCodigoOcorrencia() {
		return codigoOcorrencia;
	}

	public void setCodigoOcorrencia(Integer codigoOcorrencia) {
		this.codigoOcorrencia = codigoOcorrencia;
	}

	public Date getDataOcorrencia() {
		return dataOcorrencia;
	}

	public void setDataOcorrencia(Date dataOcorrencia) {
		this.dataOcorrencia = dataOcorrencia;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getBrancos9() {
		return brancos9;
	}

	public void setBrancos9(String brancos9) {
		this.brancos9 = brancos9;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public BigDecimal getValorTitulo() {
		return valorTitulo;
	}

	public void setValorTitulo(BigDecimal valorTitulo) {
		this.valorTitulo = valorTitulo;
	}

	public Integer getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(Integer codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public String getBrancos10() {
		return brancos10;
	}

	public void setBrancos10(String brancos10) {
		this.brancos10 = brancos10;
	}

	public String getBrancos11() {
		return brancos11;
	}

	public void setBrancos11(String brancos11) {
		this.brancos11 = brancos11;
	}

	public String getBrancos12() {
		return brancos12;
	}

	public void setBrancos12(String brancos12) {
		this.brancos12 = brancos12;
	}

	public Date getDataCredito() {
		return dataCredito;
	}

	public void setDataCredito(Date dataCredito) {
		this.dataCredito = dataCredito;
	}

	public BigDecimal getValorTarifa() {
		return valorTarifa;
	}

	public void setValorTarifa(BigDecimal valorTarifa) {
		this.valorTarifa = valorTarifa;
	}

	public BigDecimal getValorOutrasDespesas() {
		return valorOutrasDespesas;
	}

	public void setValorOutrasDespesas(BigDecimal valorOutrasDespesas) {
		this.valorOutrasDespesas = valorOutrasDespesas;
	}

	public BigDecimal getValorJurosDesconto() {
		return valorJurosDesconto;
	}

	public void setValorJurosDesconto(BigDecimal valorJurosDesconto) {
		this.valorJurosDesconto = valorJurosDesconto;
	}

	public BigDecimal getValorIOF() {
		return valorIOF;
	}

	public void setValorIOF(BigDecimal valorIOF) {
		this.valorIOF = valorIOF;
	}

	public BigDecimal getValorAbatimento() {
		return valorAbatimento;
	}

	public void setValorAbatimento(BigDecimal valorAbatimento) {
		this.valorAbatimento = valorAbatimento;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public BigDecimal getValorPago() {
		return valorPago;
	}

	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}

	public BigDecimal getValorJuros() {
		return valorJuros;
	}

	public void setValorJuros(BigDecimal valorJuros) {
		this.valorJuros = valorJuros;
	}

	public BigDecimal getValorOutrosCreditos() {
		return valorOutrosCreditos;
	}

	public void setValorOutrosCreditos(BigDecimal valorOutrosCreditos) {
		this.valorOutrosCreditos = valorOutrosCreditos;
	}

	public String getBrancos13() {
		return brancos13;
	}

	public void setBrancos13(String brancos13) {
		this.brancos13 = brancos13;
	}

	public BigDecimal getValorLancamento() {
		return valorLancamento;
	}

	public void setValorLancamento(BigDecimal valorLancamento) {
		this.valorLancamento = valorLancamento;
	}

	public String getIndicativoDebitoCredito() {
		return indicativoDebitoCredito;
	}

	public void setIndicativoDebitoCredito(String indicativoDebitoCredito) {
		this.indicativoDebitoCredito = indicativoDebitoCredito;
	}

	public String getIndicadorValor() {
		return indicadorValor;
	}

	public void setIndicadorValor(String indicadorValor) {
		this.indicadorValor = indicadorValor;
	}

	public String getBrancos14() {
		return brancos14;
	}

	public void setBrancos14(String brancos14) {
		this.brancos14 = brancos14;
	}

	public String getBrancos15() {
		return brancos15;
	}

	public void setBrancos15(String brancos15) {
		this.brancos15 = brancos15;
	}

	public String getBrancos16() {
		return brancos16;
	}

	public void setBrancos16(String brancos16) {
		this.brancos16 = brancos16;
	}

	public String getBrancos17() {
		return brancos17;
	}

	public void setBrancos17(String brancos17) {
		this.brancos17 = brancos17;
	}

	public String getBrancos18() {
		return brancos18;
	}

	public void setBrancos18(String brancos18) {
		this.brancos18 = brancos18;
	}

	public String getBrancos19() {
		return brancos19;
	}

	public void setBrancos19(String brancos19) {
		this.brancos19 = brancos19;
	}

	public String getBrancos20() {
		return brancos20;
	}

	public void setBrancos20(String brancos20) {
		this.brancos20 = brancos20;
	}

	public String getBrancos21() {
		return brancos21;
	}

	public void setBrancos21(String brancos21) {
		this.brancos21 = brancos21;
	}

	public String getBrancos22() {
		return brancos22;
	}

	public void setBrancos22(String brancos22) {
		this.brancos22 = brancos22;
	}

	public String getBrancos23() {
		return brancos23;
	}

	public void setBrancos23(String brancos23) {
		this.brancos23 = brancos23;
	}

	public String getBrancos24() {
		return brancos24;
	}

	public void setBrancos24(String brancos24) {
		this.brancos24 = brancos24;
	}

	public Integer getNumeroSequencialRegistro() {
		return numeroSequencialRegistro;
	}

	public void setNumeroSequencialRegistro(Integer numeroSequencialRegistro) {
		this.numeroSequencialRegistro = numeroSequencialRegistro;
	}

	public static TitulosCobrancaDetalheRetorno of(ContaBancaria contaBancaria) {
		return new TitulosCobrancaDetalheRetorno(contaBancaria);
	}

	public void set(Collection<Record> collection) {
		for (Record record : collection) {
			setCodigoRegistro((Integer) record.getValue("CD_REGISTRO"));
			setCodigoEmpresa((Long) record.getValue("CD_EMPRESA"));
			setNumeroConvenio((Integer) record.getValue("NR_CONVENIO"));
			setNossoNumero((String) record.getValue("NOSSO_NUMERO"));
			setTipoCobranca((String) record.getValue("TP_COBRANCA"));
			setTipoCobrancaEspecifico((String) record.getValue("TP_COBRANCA_ESPECIFICO"));
			setVariacaoCarteira((String) record.getValue("VARIACAO_CARTEIRA"));
			setTaxaDesconto((BigDecimal) record.getValue("TAXA_DESCONTO"));
			setTaxaIOF((BigDecimal) record.getValue("TAXA_IOF"));
			setCarteira((String) record.getValue("CARTEIRA"));
			setCodigoOcorrencia((Integer) record.getValue("CD_OCORRENCIA"));
			setDataOcorrencia((Date) record.getValue("DT_OCORRENCIA"));
			setNumeroDocumento((String) record.getValue("NR_DOCUMENTO"));
			setDataVencimento((Date) record.getValue("DT_VENCIMENTO"));
			setValorTitulo((BigDecimal) record.getValue("VL_TITULO"));
			setCodigoBanco((Integer) record.getValue("CD_BANCO"));
			setDataCredito((Date) record.getValue("DT_CREDITO"));
			setValorTarifa((BigDecimal) record.getValue("VL_TARIFA"));
			setValorOutrasDespesas((BigDecimal) record.getValue("VL_OUTRASDESPESAS"));
			setValorJurosDesconto((BigDecimal) record.getValue("VL_JUROSDESCONTO"));
			setValorIOF((BigDecimal) record.getValue("VL_IOF"));
			setValorAbatimento((BigDecimal) record.getValue("VL_ABATIMENTO"));
			setValorDesconto((BigDecimal) record.getValue("VL_DESCONTO"));
			setValorPago((BigDecimal) record.getValue("VL_PAGO"));
			setValorJuros((BigDecimal) record.getValue("VL_JUROS"));
			setValorOutrosCreditos((BigDecimal) record.getValue("VL_OUTROS_CREDITOS"));
			setValorLancamento((BigDecimal) record.getValue("VL_LANCAMENTO"));
			setIndicadorValor((String) record.getValue("INDICADOR_VALOR"));
			setIndicativoDebitoCredito((String) record.getValue("INDICATIVO_DEBITO_CREDITO"));
			setNumeroSequencialRegistro((Integer) record.getValue("NR_SEQUENCIAL_REGISTRO"));
		}

	}

}
