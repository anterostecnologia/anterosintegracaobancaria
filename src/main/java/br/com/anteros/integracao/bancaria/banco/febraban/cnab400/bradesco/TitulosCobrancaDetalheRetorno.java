package br.com.anteros.integracao.bancaria.banco.febraban.cnab400.bradesco;

import java.math.BigDecimal;
import java.util.Date;

import br.com.anteros.flatfile.Record;
import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.Formats;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.annotation.RecordData;
import br.com.anteros.flatfile.language.EnumTypes;
import br.com.anteros.integracao.bancaria.banco.febraban.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.febraban.DetalheRetorno;

public class TitulosCobrancaDetalheRetorno implements RecordData, DetalheRetorno {

	private static final String DIGITO_CONTACORRENTE = "DIGITO_CONTACORRENTE";
	private static final String NR_CONTACORRENTE = "NR_CONTACORRENTE";
	private static final String AGENCIA = "AGENCIA";
	private static final String NR_PROTOCOLO = "NR_PROTOCOLO";
	private static final String NR_CARTORIO = "NR_CARTORIO";
	private static final String MOTIVO_OCORRENCIA5 = "MOTIVO_OCORRENCIA5";
	private static final String MOTIVO_OCORRENCIA4 = "MOTIVO_OCORRENCIA4";
	private static final String MOTIVO_OCORRENCIA3 = "MOTIVO_OCORRENCIA3";
	private static final String MOTIVO_OCORRENCIA2 = "MOTIVO_OCORRENCIA2";
	private static final String MOTIVO_OCORRENCIA1 = "MOTIVO_OCORRENCIA1";
	private static final String ORIGEM_PAGAMENTO = "ORIGEM_PAGAMENTO";
	private static final String ESPECIE_TITULO = "ESPECIE_TITULO";
	private static final String DIGITO_AGENCIA_RECEBEDORA = "DIGITO_AGENCIA_RECEBEDORA";
	private static final String AGENCIA_RECEBEDORA = "AGENCIA_RECEBEDORA";
	private static final String NR_SEQUENCIAL_REGISTRO = "NR_SEQUENCIAL_REGISTRO";
	private static final String VL_OUTROS_CREDITOS = "VL_OUTROS_CREDITOS";
	private static final String VL_JUROS = "VL_JUROS";
	private static final String VL_PAGO = "VL_PAGO";
	private static final String VL_DESCONTO = "VL_DESCONTO";
	private static final String VL_ABATIMENTO = "VL_ABATIMENTO";
	private static final String VL_IOF = "VL_IOF";
	private static final String VL_OUTRASDESPESAS = "VL_OUTRASDESPESAS";
	private static final String VL_DESPESAS_COBRANCA = "VL_TARIFA";
	private static final String DT_CREDITO = "DT_CREDITO";
	private static final String VL_TITULO = "VL_TITULO";
	private static final String DT_VENCIMENTO = "DT_VENCIMENTO";
	private static final String NR_DOCUMENTO = "NR_DOCUMENTO";
	private static final String DT_OCORRENCIA = "DT_OCORRENCIA";
	private static final String CD_OCORRENCIA = "CD_OCORRENCIA";
	private static final String CARTEIRA = "CARTEIRA";
	private static final String NOSSO_NUMERO = "NOSSO_NUMERO";
	private static final String CD_REGISTRO = "CD_REGISTRO";
	private static final String CD_BANCO_RECEBEDOR = "CD_BANCO_RECEBEDOR";
	private static final String DIGITO_NOSSO_NUMERO = "DIGITO_NOSSO_NUMERO";

	@IdType(name = CD_REGISTRO, length = 1, positionField = 1, value = "1")
	private String codigoRegistro;
	
	@Field(name = "TP_INSCRICAO", length = 2, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer tipoInscricao;

	@Field(name = "NR_INSCRICAO", length = 14, type = EnumTypes.LONG, padding = Paddings.ZERO_LEFT)
	private Long numeroInscricao;
	
	@Field(name="BRANCOS1", length=3, value=" ", padding=Paddings.WHITE_SPACE_RIGHT)
	private String BRANCOS1;
	
	@Field(name="ZEROS1", value="0", length=1)
	private String zeros1;
	
	@Field(name=CARTEIRA, length=3, type=EnumTypes.INTEGER, padding=Paddings.ZERO_LEFT)
	private Integer carteira;
	
	@Field(name=AGENCIA, length=5, padding=Paddings.ZERO_LEFT, type=EnumTypes.INTEGER)
	private Integer agencia;
	
	@Field(name=NR_CONTACORRENTE, length=7, padding=Paddings.ZERO_LEFT, type=EnumTypes.INTEGER)
	private Integer numeroContaCorrente;
	
	@Field(name=DIGITO_CONTACORRENTE, length=1)
	private String digitoContaCorrente;	
		
	@Field(name = "BRANCOS3", length = 25, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos3;
	
	@Field(name = "BRANCOS4", length = 8, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos4;
	
	@Field(name = NOSSO_NUMERO, length = 11, padding = Paddings.ZERO_LEFT)
	private String nossoNumero;
	
	@Field(name = DIGITO_NOSSO_NUMERO, length = 1, padding = Paddings.ZERO_LEFT)
	private String digitoNossoNumero;
	
	@Field(name = "BRANCOS5", length = 10, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos5;

	@Field(name = "BRANCOS6", length = 12, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos6;

	@Field(name = "BRANCOS7", length = 1, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos7;
	
	@Field(name = "BRANCOS8", length = 2, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos8;
	
	@Field(name = "BRANCOS9", length = 1, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos9;
	
	@Field(name = CD_OCORRENCIA, length = 2, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoOcorrencia;
	
	@Field(name = DT_OCORRENCIA, length = 6, type = EnumTypes.DATE, format = Formats.DATE_DDMMYY)
	private Date dataOcorrencia;

	@Field(name = NR_DOCUMENTO, length = 10, padding = Paddings.WHITE_SPACE_LEFT)
	private String numeroDocumento;
	
	@Field(name = "BRANCOS10", length = 20, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos10;
	
	@Field(name = DT_VENCIMENTO, length = 6, type = EnumTypes.DATE, format = Formats.DATE_DDMMYY)
	private Date dataVencimento;	
	
	@Field(name = VL_TITULO, length = 13, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD)
	private BigDecimal valorTitulo;
	
	@Field(name = CD_BANCO_RECEBEDOR, length = 3, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoBancoRecebedor;
	
	@Field(name = AGENCIA_RECEBEDORA, length = 4, padding = Paddings.ZERO_LEFT, type = EnumTypes.INTEGER)
	private Integer agenciaRecebedora;

	@Field(name = DIGITO_AGENCIA_RECEBEDORA, length = 1, padding = Paddings.WHITE_SPACE_RIGHT)
	private String digitoAgenciaRecebedora;
	
	@Field(name = ESPECIE_TITULO, length = 2, padding = Paddings.ZERO_LEFT, type = EnumTypes.INTEGER)
	private Integer especieTitulo;
	
	@Field(name = VL_DESPESAS_COBRANCA, length = 13, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD)
	private BigDecimal valorDespesasCobranca;
	
	@Field(name = VL_OUTRASDESPESAS, length = 13, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD)
	private BigDecimal valorOutrasDespesas;
	
	@Field(name="BRANCOS11", length=13, value=" ", padding=Paddings.WHITE_SPACE_RIGHT)
	private String brancos11;
	
	@Field(name = VL_IOF, length = 13, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD)
	private BigDecimal valorIOF;

	@Field(name = VL_ABATIMENTO, length = 13, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD)
	private BigDecimal valorAbatimento;

	@Field(name = VL_DESCONTO, length = 13, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD)
	private BigDecimal valorDesconto;
	
	@Field(name = VL_PAGO, length = 13, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD)
	private BigDecimal valorPago;	
	
	@Field(name = VL_JUROS, length = 13, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD)
	private BigDecimal valorJuros;
	
	@Field(name = VL_OUTROS_CREDITOS, length = 13, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD)
	private BigDecimal valorOutrosCreditos;
	
	@Field(name="BRANCOS12", length=2, value=" ", padding=Paddings.WHITE_SPACE_RIGHT)
	private String brancos12;
	
	@Field(name="BRANCOS13", length=1, value=" ", padding=Paddings.WHITE_SPACE_RIGHT)
	private String brancos13;
	
	@Field(name = DT_CREDITO, length = 6, type = EnumTypes.DATE, format = Formats.DATE_DDMMYY)
	private Date dataCredito;
	
	@Field(name=ORIGEM_PAGAMENTO,length=3, type=EnumTypes.INTEGER, padding=Paddings.ZERO_LEFT)
	private Integer origemPagamento;
	
	@Field(name="BRANCOS14", length=14, value=" ", padding=Paddings.WHITE_SPACE_RIGHT)
	private String brancos14;
	
	@Field(name=MOTIVO_OCORRENCIA1, length=2, padding=Paddings.WHITE_SPACE_RIGHT)
	private String motivoOcorrencia1;
	
	@Field(name=MOTIVO_OCORRENCIA2, length=2, padding=Paddings.WHITE_SPACE_RIGHT)
	private String motivoOcorrencia2;
	
	@Field(name=MOTIVO_OCORRENCIA3, length=2, padding=Paddings.WHITE_SPACE_RIGHT)
	private String motivoOcorrencia3;
	
	@Field(name=MOTIVO_OCORRENCIA4, length=2, padding=Paddings.WHITE_SPACE_RIGHT)
	private String motivoOcorrencia4;
	
	@Field(name=MOTIVO_OCORRENCIA5, length=2, padding=Paddings.WHITE_SPACE_RIGHT)
	private String motivoOcorrencia5;
	
	@Field(name="BRANCOS15", length=40, value=" ", padding=Paddings.WHITE_SPACE_RIGHT)
	private String brancos15;
	
	@Field(name=NR_CARTORIO,length=2, type=EnumTypes.INTEGER, padding=Paddings.ZERO_LEFT)
	private Integer numeroCartorio;
	
	@Field(name=NR_PROTOCOLO, length=10, padding=Paddings.WHITE_SPACE_RIGHT)
	private String numeroProtocolo;
	
	@Field(name = "BRANCOS16", length = 14, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos16;
	
	@Field(name = NR_SEQUENCIAL_REGISTRO, length = 6, padding = Paddings.ZERO_LEFT, type = EnumTypes.INTEGER)
	private Integer numeroSequencialRegistro;

	public TitulosCobrancaDetalheRetorno(ContaBancaria contaBancaria) {

	}

	public String getCodigoRegistro() {
		return codigoRegistro;
	}

	public void setCodigoRegistro(String codigoRegistro) {
		this.codigoRegistro = codigoRegistro;
	}


	public void set(Record record) {
		setCodigoRegistro((String) record.getValue(CD_REGISTRO));
		setNossoNumero((String) record.getValue(NOSSO_NUMERO));		
		setCarteira((Integer) record.getValue(CARTEIRA));
		setCodigoOcorrencia((Integer) record.getValue(CD_OCORRENCIA));
		setDataOcorrencia((Date) record.getValue(DT_OCORRENCIA));
		setNumeroDocumento((String) record.getValue(NR_DOCUMENTO));
		setDataVencimento((Date) record.getValue(DT_VENCIMENTO));
		setValorTitulo((BigDecimal) record.getValue(VL_TITULO));
		setDataCredito((Date) record.getValue(DT_CREDITO));
		setValorDespesasCobranca((BigDecimal) record.getValue(VL_DESPESAS_COBRANCA));
		setValorOutrasDespesas((BigDecimal) record.getValue(VL_OUTRASDESPESAS));
		setValorIOF((BigDecimal) record.getValue(VL_IOF));
		setValorAbatimento((BigDecimal) record.getValue(VL_ABATIMENTO));
		setValorDesconto((BigDecimal) record.getValue(VL_DESCONTO));
		setValorPago((BigDecimal) record.getValue(VL_PAGO));
		setValorJuros((BigDecimal) record.getValue(VL_JUROS));
		setValorOutrosCreditos((BigDecimal) record.getValue(VL_OUTROS_CREDITOS));
		setNumeroSequencialRegistro((Integer) record.getValue(NR_SEQUENCIAL_REGISTRO));
		setEspecieTitulo((Integer) record.getValue(ESPECIE_TITULO));
		setCodigoBancoRecebedor((Integer) record.getValue(CD_BANCO_RECEBEDOR));
		setAgenciaRecebedora((Integer) record.getValue(AGENCIA_RECEBEDORA));
		setDigitoAgenciaRecebedora((String) record.getValue(DIGITO_AGENCIA_RECEBEDORA));	
		setDigitoContaCorrente((String) record.getValue(DIGITO_CONTACORRENTE));
		setNumeroContaCorrente((Integer) record.getValue(NR_CONTACORRENTE));
		setAgencia((Integer) record.getValue(AGENCIA));
		setNumeroProtocolo((String) record.getValue(NR_PROTOCOLO));
		setNumeroCartorio((Integer) record.getValue(NR_CARTORIO));
        setMotivoOcorrencia1((String) record.getValue(MOTIVO_OCORRENCIA1));
        setMotivoOcorrencia2((String) record.getValue(MOTIVO_OCORRENCIA2));
        setMotivoOcorrencia3((String) record.getValue(MOTIVO_OCORRENCIA3));
        setMotivoOcorrencia4((String) record.getValue(MOTIVO_OCORRENCIA4));
        setMotivoOcorrencia5((String) record.getValue(MOTIVO_OCORRENCIA5));
        setOrigemPagamento((Integer) record.getValue(ORIGEM_PAGAMENTO));		

	}

	public int getNumberOfRecords() {
		return 0;
	}

	public void readRowData(int row) {

	}

	public Integer getTipoInscricao() {
		return tipoInscricao;
	}

	public void setTipoInscricao(Integer tipoInscricao) {
		this.tipoInscricao = tipoInscricao;
	}

	public Long getNumeroInscricao() {
		return numeroInscricao;
	}

	public void setNumeroInscricao(Long numeroInscricao) {
		this.numeroInscricao = numeroInscricao;
	}

	public Integer getCarteira() {
		return carteira;
	}

	public void setCarteira(Integer carteira) {
		this.carteira = carteira;
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

	public Integer getCodigoBancoRecebedor() {
		return codigoBancoRecebedor;
	}

	public void setCodigoBancoRecebedor(Integer codigoBancoRecebedor) {
		this.codigoBancoRecebedor = codigoBancoRecebedor;
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

	public Integer getEspecieTitulo() {
		return especieTitulo;
	}

	public void setEspecieTitulo(Integer especieTitulo) {
		this.especieTitulo = especieTitulo;
	}

	public BigDecimal getValorDespesasCobranca() {
		return valorDespesasCobranca;
	}

	public void setValorDespesasCobranca(BigDecimal valorDespesasCobranca) {
		this.valorDespesasCobranca = valorDespesasCobranca;
	}

	public BigDecimal getValorOutrasDespesas() {
		return valorOutrasDespesas;
	}

	public void setValorOutrasDespesas(BigDecimal valorOutrasDespesas) {
		this.valorOutrasDespesas = valorOutrasDespesas;
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

	public Date getDataCredito() {
		return dataCredito;
	}

	public void setDataCredito(Date dataCredito) {
		this.dataCredito = dataCredito;
	}

	public Integer getOrigemPagamento() {
		return origemPagamento;
	}

	public void setOrigemPagamento(Integer origemPagamento) {
		this.origemPagamento = origemPagamento;
	}

	public String getMotivoOcorrencia1() {
		return motivoOcorrencia1;
	}

	public void setMotivoOcorrencia1(String motivoOcorrencia1) {
		this.motivoOcorrencia1 = motivoOcorrencia1;
	}

	public String getMotivoOcorrencia2() {
		return motivoOcorrencia2;
	}

	public void setMotivoOcorrencia2(String motivoOcorrencia2) {
		this.motivoOcorrencia2 = motivoOcorrencia2;
	}

	public String getMotivoOcorrencia3() {
		return motivoOcorrencia3;
	}

	public void setMotivoOcorrencia3(String motivoOcorrencia3) {
		this.motivoOcorrencia3 = motivoOcorrencia3;
	}

	public String getMotivoOcorrencia4() {
		return motivoOcorrencia4;
	}

	public void setMotivoOcorrencia4(String motivoOcorrencia4) {
		this.motivoOcorrencia4 = motivoOcorrencia4;
	}

	public String getMotivoOcorrencia5() {
		return motivoOcorrencia5;
	}

	public void setMotivoOcorrencia5(String motivoOcorrencia5) {
		this.motivoOcorrencia5 = motivoOcorrencia5;
	}

	public Integer getNumeroCartorio() {
		return numeroCartorio;
	}

	public void setNumeroCartorio(Integer numeroCartorio) {
		this.numeroCartorio = numeroCartorio;
	}

	public String getNumeroProtocolo() {
		return numeroProtocolo;
	}

	public void setNumeroProtocolo(String numeroProtocolo) {
		this.numeroProtocolo = numeroProtocolo;
	}

	public Integer getNumeroSequencialRegistro() {
		return numeroSequencialRegistro;
	}

	public void setNumeroSequencialRegistro(Integer numeroSequencialRegistro) {
		this.numeroSequencialRegistro = numeroSequencialRegistro;
	}

	public Integer getNumeroConvenio() {
		return null;
	}

	public String getTipoCobranca() {
		return null;
	}

	public String getTipoCobrancaEspecifico() {
		return null;
	}

	public String getVariacaoCarteira() {
		return null;
	}

	public BigDecimal getTaxaDesconto() {
		return null;
	}

	public BigDecimal getTaxaIOF() {
		return null;
	}

	public Integer getCodigoMovimentoRetorno() {
		return null;
	}

	public BigDecimal getValorLancamento() {
		return null;
	}

	public String getIndicativoDebitoCredito() {
		return null;
	}

	public String getIndicadorValor() {
		return null;
	}

	public Integer getTipoInscricaoSacadoAvalista() {
		return null;
	}

	public Long getNumeroInscricaoSacadoAvalista() {
		return null;
	}

	public String getNomeSacadorAvalista() {
		return null;
	}
	
	public static TitulosCobrancaDetalheRetorno of(ContaBancaria contaBancaria) {
		return new TitulosCobrancaDetalheRetorno(contaBancaria);
	}
}
