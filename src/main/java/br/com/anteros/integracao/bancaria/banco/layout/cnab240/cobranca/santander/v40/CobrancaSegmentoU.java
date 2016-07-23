package br.com.anteros.integracao.bancaria.banco.layout.cnab240.cobranca.santander.v40;

import java.math.BigDecimal;
import java.util.Date;

import br.com.anteros.flatfile.Record;
import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.Formats;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.language.EnumTypes;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.*;

public class CobrancaSegmentoU {

	@IdType(name = CD_SEGMENTO_REGISTRO, length = 1, positionField = 5, value = "U")
	private String codigoSegmentoRegistro;

	@Field(name = CD_BANCO, length = 3, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoBanco;

	@Field(name = LOTE_SERVICO, length = 4, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer loteServico;

	@Field(name = TP_REGISTRO, length = 1, value = "3", type = EnumTypes.INTEGER)
	private Integer tipoRegistro;

	@Field(name = NR_SEQUENCIAL_REGISTRO, length = 5, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer numeroSequencialRegistro;

	@Field(name = "BRANCOS1", length = 1, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
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

	@Field(name = "BRANCOS2", length = 7, padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos2;

	private ContaBancaria contaBancaria;

	public CobrancaSegmentoU(ContaBancaria contaBancaria) {
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

	public static CobrancaSegmentoU of(ContaBancaria contaBancaria) {
		return new CobrancaSegmentoU(contaBancaria);
	}

	public void set(Record record) {
		setCodigoSegmentoRegistro((String) record.getValue(CD_SEGMENTO_REGISTRO));
		setCodigoBanco((Integer) record.getValue(CD_BANCO));
		setLoteServico((Integer) record.getValue(LOTE_SERVICO));
		setTipoRegistro((Integer) record.getValue(TP_REGISTRO));
		setNumeroSequencialRegistro((Integer) record.getValue(NR_SEQUENCIAL_REGISTRO));
		setCodigoMovimentoRetorno((Integer) record.getValue(CD_MOVIMENTO_RETORNO));
		setValorJurosMultasEncargos((BigDecimal) record.getValue(VL_JUROS_MULTAS));
		setValorDesconto((BigDecimal) record.getValue(VL_DESCONTO));
		setValorAbatimento((BigDecimal) record.getValue(VL_ABATIMENTO));
		setValorIOF((BigDecimal) record.getValue(VL_IOF));
		setValorPagoSacado((BigDecimal) record.getValue(VL_PAGOSACADO));
		setValorLiquidoCreditado((BigDecimal) record.getValue(VL_LIQUIDO_CREDITADO));
		setValorOutrasDespesas((BigDecimal) record.getValue(VL_OUTRAS_DESPESAS));
		setValorOutrosCreditos((BigDecimal) record.getValue(VL_OUTROS_CREDITOS));
		setDataOcorrenciaPagamento((Date) record.getValue(DT_OCORRENCIA_PAGAMENTO));
		setDataEfetivacaoCredito((Date) record.getValue(DT_EFETIVACAO_CREDITO));
		setCodigoOcorrencia((String) record.getValue(CD_OCORRENCIA));
		setDataOcorrencia((Date) record.getValue(DT_OCORRENCIA));
		setValorOcorrencia((BigDecimal) record.getValue(VL_OCORRENCIA));
		setComplementoOcorrencia((String) record.getValue(COMPLEMENTO_OCORRENCIA));
		setCodigoBancoCorrespondente((Integer) record.getValue(CD_BANCO_CORRESPONDENTE));
		setNossoNumeroBancoCorrespondente((String) record.getValue(NOSSO_NR_BANCO_CORRESPONDENTE));
	}

}
