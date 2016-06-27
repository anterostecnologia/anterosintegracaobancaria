package br.com.anteros.integracao.bancaria.banco.febraban.cnab240;

import java.math.BigDecimal;
import java.util.Date;

import br.com.anteros.flatfile.Record;
import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.Formats;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.language.EnumTypes;
import br.com.anteros.integracao.bancaria.banco.febraban.ContaBancaria;

public class TitulosCobrancaSegmentoU {

	private static final String BRANCOS_2 = "BRANCOS2";
	private static final String NOSSO_NR_BANCO_CORRESPONDENTE = "NOSSO_NR_BANCO_CORRESPONDENTE";
	private static final String CD_BANCO_CORRESPONDENTE = "CD_BANCO_CORRESPONDENTE";
	private static final String COMPLEMENTO_OCORRENCIA = "COMPLEMENTO_OCORRENCIA";
	private static final String VL_OCORRENCIA = "VL_OCORRENCIA";
	private static final String DT_OCORRENCIA = "DT_OCORRENCIA";
	private static final String CD_OCORRENCIA = "CD_OCORRENCIA";
	private static final String DT_EFETIVACAO_CREDITO = "DT_EFETIVACAO_CREDITO";
	private static final String DT_OCORRENCIA_PAGAMENTO = "DT_OCORRENCIA_PAGAMENTO";
	private static final String VL_OUTROS_CREDITOS = "VL_OUTROS_CREDITOS";
	private static final String VL_OUTRAS_DESPESAS = "VL_OUTRAS_DESPESAS";
	private static final String VL_LIQUIDO_CREDITADO = "VL_LIQUIDO_CREDITADO";
	private static final String VL_PAGOSACADO = "VL_PAGOSACADO";
	private static final String VL_IOF = "VL_IOF";
	private static final String VL_ABATIMENTO = "VL_ABATIMENTO";
	private static final String VL_DESCONTO = "VL_DESCONTO";
	private static final String VL_JUROS_MULTAS = "VL_JUROS_MULTAS";
	private static final String CD_MOVIMENTO_RETORNO = "CD_MOVIMENTO_RETORNO";
	private static final String BRANCOS_1 = "BRANCOS1";
	private static final String NR_SEQUENCIAL_REGISTRO = "NR_SEQUENCIAL_REGISTRO";
	private static final String TP_REGISTRO = "TP_REGISTRO";
	private static final String LOTE_SERVICO = "LOTE_SERVICO";
	private static final String CD_BANCO = "CD_BANCO";
	private static final String CD_SEGMENTO_REGISTRO = "CD_SEGMENTO_REGISTRO";

	@IdType(name = CD_SEGMENTO_REGISTRO, length = 1, position = 5, value = "U")
	private String codigoSegmentoRegistro;

	@Field(name = CD_BANCO, length = 3, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoBanco;

	@Field(name = LOTE_SERVICO, length = 4, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer loteServico;

	@Field(name = TP_REGISTRO, length = 1, value = "3", type = EnumTypes.INTEGER)
	private Integer tipoRegistro;

	@Field(name = NR_SEQUENCIAL_REGISTRO, length = 5, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer numeroSequencialRegistro;

	@Field(name = BRANCOS_1, length = 1, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos1;

	@Field(name = CD_MOVIMENTO_RETORNO, length = 2, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoMovimentoRetorno;

	@Field(name = VL_JUROS_MULTAS, length = 15, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD, padding = Paddings.ZERO_LEFT)
	private BigDecimal valorJurosMultasEncargos;

	@Field(name = VL_DESCONTO, length = 15, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD, padding = Paddings.ZERO_LEFT)
	private BigDecimal valorDesconto;

	@Field(name = VL_ABATIMENTO, length = 15, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD, padding = Paddings.ZERO_LEFT)
	private BigDecimal valorAbatimento;

	@Field(name = VL_IOF, length = 15, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD, padding = Paddings.ZERO_LEFT)
	private BigDecimal valorIOF;

	@Field(name = VL_PAGOSACADO, length = 15, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD, padding = Paddings.ZERO_LEFT)
	private BigDecimal valorPagoSacado;

	@Field(name = VL_LIQUIDO_CREDITADO, length = 15, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD, padding = Paddings.ZERO_LEFT)
	private BigDecimal valorLiquidoCreditado;

	@Field(name = VL_OUTRAS_DESPESAS, length = 15, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD, padding = Paddings.ZERO_LEFT)
	private BigDecimal valorOutrasDespesas;

	@Field(name = VL_OUTROS_CREDITOS, length = 15, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD, padding = Paddings.ZERO_LEFT)
	private BigDecimal valorOutrosCreditos;

	@Field(name = DT_OCORRENCIA_PAGAMENTO, length = 8, type = EnumTypes.DATE, format = Formats.DATE_DDMMYYYY, padding = Paddings.ZERO_LEFT)
	private Date dataOcorrenciaPagamento;

	@Field(name = DT_EFETIVACAO_CREDITO, length = 8, type = EnumTypes.DATE, format = Formats.DATE_DDMMYYYY, padding = Paddings.ZERO_LEFT)
	private Date dataEfetivacaoCredito;

	@Field(name = CD_OCORRENCIA, length = 4, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String codigoOcorrencia;

	@Field(name = DT_OCORRENCIA, length = 8, type = EnumTypes.DATE, format = Formats.DATE_DDMMYYYY, padding = Paddings.ZERO_LEFT)
	private Date dataOcorrencia;

	@Field(name = VL_OCORRENCIA, length = 15, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD, padding = Paddings.ZERO_LEFT)
	private BigDecimal valorOcorrencia;

	@Field(name = COMPLEMENTO_OCORRENCIA, length = 30, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String complementoOcorrencia;

	@Field(name = CD_BANCO_CORRESPONDENTE, length = 3, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoBancoCorrespondente;

	@Field(name = NOSSO_NR_BANCO_CORRESPONDENTE, length = 20, padding = Paddings.WHITE_SPACE_RIGHT)
	private String nossoNumeroBancoCorrespondente;

	@Field(name = BRANCOS_2, length = 7, padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos2;

	private ContaBancaria contaBancaria;

	public TitulosCobrancaSegmentoU(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
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

	public String getBrancos1() {
		return brancos1;
	}

	public void setBrancos1(String brancos1) {
		this.brancos1 = brancos1;
	}

	public Integer getCodigoMovimentoRetorno() {
		return codigoMovimentoRetorno;
	}

	public void setCodigoMovimentoRetorno(Integer codigoMovimentoRetorno) {
		this.codigoMovimentoRetorno = codigoMovimentoRetorno;
	}

	public BigDecimal getValorJurosMultasEncargos() {
		return valorJurosMultasEncargos;
	}

	public void setValorJurosMultasEncargos(BigDecimal valorJurosMultasEncargos) {
		this.valorJurosMultasEncargos = valorJurosMultasEncargos;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public BigDecimal getValorAbatimento() {
		return valorAbatimento;
	}

	public void setValorAbatimento(BigDecimal valorAbatimento) {
		this.valorAbatimento = valorAbatimento;
	}

	public BigDecimal getValorIOF() {
		return valorIOF;
	}

	public void setValorIOF(BigDecimal valorIOF) {
		this.valorIOF = valorIOF;
	}

	public BigDecimal getValorPagoSacado() {
		return valorPagoSacado;
	}

	public void setValorPagoSacado(BigDecimal valorPagoSacado) {
		this.valorPagoSacado = valorPagoSacado;
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

	public String getCodigoOcorrencia() {
		return codigoOcorrencia;
	}

	public void setCodigoOcorrencia(String codigoOcorrencia) {
		this.codigoOcorrencia = codigoOcorrencia;
	}

	public Date getDataOcorrencia() {
		return dataOcorrencia;
	}

	public void setDataOcorrencia(Date dataOcorrencia) {
		this.dataOcorrencia = dataOcorrencia;
	}

	public BigDecimal getValorOcorrencia() {
		return valorOcorrencia;
	}

	public void setValorOcorrencia(BigDecimal valorOcorrencia) {
		this.valorOcorrencia = valorOcorrencia;
	}

	public String getComplementoOcorrencia() {
		return complementoOcorrencia;
	}

	public void setComplementoOcorrencia(String complementoOcorrencia) {
		this.complementoOcorrencia = complementoOcorrencia;
	}

	public Integer getCodigoBancoCorrespondente() {
		return codigoBancoCorrespondente;
	}

	public void setCodigoBancoCorrespondente(Integer codigoBancoCorrespondente) {
		this.codigoBancoCorrespondente = codigoBancoCorrespondente;
	}

	public String getNossoNumeroBancoCorrespondente() {
		return nossoNumeroBancoCorrespondente;
	}

	public void setNossoNumeroBancoCorrespondente(String nossoNumeroBancoCorrespondente) {
		this.nossoNumeroBancoCorrespondente = nossoNumeroBancoCorrespondente;
	}

	public String getBrancos2() {
		return brancos2;
	}

	public void setBrancos2(String brancos2) {
		this.brancos2 = brancos2;
	}

	public static TitulosCobrancaSegmentoU of(ContaBancaria contaBancaria) {
		return new TitulosCobrancaSegmentoU(contaBancaria);
	}

	public void set(Record record) {
		this.codigoSegmentoRegistro = record.getValue(CD_SEGMENTO_REGISTRO);
		this.codigoBanco = record.getValue(CD_BANCO);
		this.loteServico = record.getValue(LOTE_SERVICO);
		this.tipoRegistro = record.getValue(TP_REGISTRO);
		this.numeroSequencialRegistro = record.getValue(NR_SEQUENCIAL_REGISTRO);
		this.brancos1 = record.getValue(BRANCOS_1);
		this.codigoMovimentoRetorno = record.getValue(CD_MOVIMENTO_RETORNO);
		this.valorJurosMultasEncargos = record.getValue(VL_JUROS_MULTAS);
		this.valorDesconto = record.getValue(VL_DESCONTO);
		this.valorAbatimento = record.getValue(VL_ABATIMENTO);
		this.valorIOF = record.getValue(VL_IOF);
		this.valorPagoSacado = record.getValue(VL_PAGOSACADO);
		this.valorLiquidoCreditado = record.getValue(VL_LIQUIDO_CREDITADO);
		this.valorOutrasDespesas = record.getValue(VL_OUTRAS_DESPESAS);
		this.valorOutrosCreditos = record.getValue(VL_OUTROS_CREDITOS);
		this.dataOcorrenciaPagamento = record.getValue(DT_OCORRENCIA_PAGAMENTO);
		this.dataEfetivacaoCredito = record.getValue(DT_EFETIVACAO_CREDITO);
		this.codigoOcorrencia = record.getValue(CD_OCORRENCIA);
		this.dataOcorrencia = record.getValue(DT_OCORRENCIA);
		this.valorOcorrencia = record.getValue(VL_OCORRENCIA);
		this.complementoOcorrencia = record.getValue(COMPLEMENTO_OCORRENCIA);
		this.codigoBancoCorrespondente = record.getValue(CD_BANCO_CORRESPONDENTE);
		this.nossoNumeroBancoCorrespondente = record.getValue(NOSSO_NR_BANCO_CORRESPONDENTE);
		this.brancos2 = record.getValue(BRANCOS_2);
	}

}
