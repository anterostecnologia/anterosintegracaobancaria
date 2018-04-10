package br.com.anteros.integracao.bancaria.banco.layout.cnab240.cobranca.itau.v40;

import java.math.BigDecimal;
import java.util.Date;

import br.com.anteros.flatfile.Record;
import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.Formats;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.annotation.RecordData;
import br.com.anteros.flatfile.language.EnumTypes;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.*;

public class CobrancaSegmentoT implements RecordData {

	@IdType(value = "T", length = 1, positionField = 5, name = CD_SEGMENTO_REGISTRO)
	private String codigoSegmentoRegistro;

	@Field(name = CD_BANCO, type = EnumTypes.INTEGER, length = 3, padding = Paddings.ZERO_LEFT)
	private Integer codigoBanco;

	@Field(name = LT_SERVICO, type = EnumTypes.INTEGER, length = 4, padding = Paddings.ZERO_LEFT)
	private Integer loteServico;

	@Field(name = TP_REGISTRO, type = EnumTypes.INTEGER, length = 1, value = "3", padding = Paddings.ZERO_LEFT)
	private Integer tipoRegistro;

	@Field(name = NR_SEQUENCIAL_REGISTRO, type = EnumTypes.INTEGER, length = 5, padding = Paddings.ZERO_LEFT)
	private Integer numeroSequencialRegistro;

	@Field(name = INDICADOR_BOLETO_DDA, length = 1)
	private String indicadorBoletoDDA;

	@Field(name = CD_MOVIMENTO_RETORNO, length = 2, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoMovimentoRetorno;

	@Field(name = "ZEROS_1", type = EnumTypes.INTEGER, length = 1, padding = Paddings.ZERO_LEFT, value = "0")
	private Integer zeros1;

	@Field(name = AGENCIA_MANTENEDORA, type = EnumTypes.INTEGER, length = 4, padding = Paddings.ZERO_LEFT)
	private Integer agenciaMantenedora;

	@Field(name = "ZEROS_2", type = EnumTypes.INTEGER, length = 8, padding = Paddings.ZERO_LEFT)
	private Integer zeros2;

	@Field(name = NR_CONTACORRENTE, length = 5, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer numeroContaCorrente;

	@Field(name = "ZEROS_3", type = EnumTypes.INTEGER, length = 1, padding = Paddings.ZERO_LEFT, value = "0")
	private Integer zeros3;

	@Field(name = DIGITO_CONTACORRENTE, length = 1)
	private String digitoVerificadorContaCorrente;

	@Field(name = CD_CARTEIRA, length = 3, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoCarteira;

	@Field(name = "NOSSO_NUMERO", length = 8)
	private String nossoNumero;

	@Field(name = "DIGITO_NOSSO_NUMERO", length = 1)
	private String digitoNossoNumero;

	@Field(name = "BRANCOS_1", value = " ", padding = Paddings.WHITE_SPACE_RIGHT, length = 8)
	private String brancos;

	@Field(name = "ZEROS_4", type = EnumTypes.INTEGER, length = 1, padding = Paddings.ZERO_LEFT, value = "0")
	private Integer zeros4;

	@Field(name = NR_DOCUMENTO_COBRANCA, length = 10, padding = Paddings.WHITE_SPACE_RIGHT)
	private String numeroDocumentoCobranca;

	@Field(name = "BRANCOS_2", value = " ", padding = Paddings.WHITE_SPACE_RIGHT, length = 5)
	private String brancos2;

	@Field(name = DT_VENCIMENTO, length = 8, padding = Paddings.ZERO_LEFT, format = Formats.DATE_DDMMYYYY, type = EnumTypes.DATE)
	private Date dataVencimentoTitulo;

	@Field(name = VL_NOMINAL_TITULO, length = 15, type = EnumTypes.BIGDECIMAL, padding = Paddings.ZERO_LEFT, format = Formats.DECIMAL_DD)
	private BigDecimal valorNominalTitulo;

	@Field(name = "ZEROS_5", type = EnumTypes.INTEGER, length = 3, padding = Paddings.ZERO_LEFT)
	private Integer zeros5;

	@Field(name = AGENCIA_COBRADORA, type = EnumTypes.INTEGER, length = 5, padding = Paddings.ZERO_LEFT)
	private Integer agenciaCobradora;

	@Field(name = DIGITO_AGENCIA_COBRADORA, length = 1)
	private String digitoagenciaCobradora;

	@Field(name = ID_TITULO_EMPRESA, length = 25)
	private String identificadorTituloEmpresa;

	@Field(name = CD_MOEDA, length = 2, padding = Paddings.WHITE_SPACE_RIGHT)
	private String codigoMoeda;

	@Field(name = TP_INSCRICAO_SACADO_AVALISTA, length = 1, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer tipoInscricaoSacadoAvalista;

	@Field(name = NR_INSCRICAO_SACADO_AVALISTA, length = 15, type = EnumTypes.LONG, padding = Paddings.ZERO_LEFT)
	private Long numeroInscricaoSacadoAvalista;

	@Field(name = NOME_SACADOR_AVALISTA, length = 30, padding = Paddings.WHITE_SPACE_RIGHT)
	private String nomeSacadorAvalista;

	@Field(name = "BRANCOS_3", value = " ", padding = Paddings.WHITE_SPACE_RIGHT, length = 10)
	private String brancos3;

	@Field(name = "ZEROS_6", type = EnumTypes.INTEGER, length = 10, padding = Paddings.ZERO_LEFT)
	private Integer zeros6;

	@Field(name = VL_TARIFA_CUSTAS, length = 15, type = EnumTypes.BIGDECIMAL, padding = Paddings.ZERO_LEFT, format = Formats.DECIMAL_DD)
	private BigDecimal valorTarifaCustas;

	@Field(name = CD_MOTIVO_REJEICAO, length = 8, padding = Paddings.WHITE_SPACE_RIGHT)
	private String identificadorRejeicao;

	@Field(name = CD_LIQUIDACAO, length = 2, padding = Paddings.WHITE_SPACE_RIGHT)
	private String codigoLiquidacao;

	@Field(name = "BRANCOS_4", length = 17, padding = Paddings.WHITE_SPACE_RIGHT, value = " ")
	private String brancos4;

	private ContaBancaria contaBancaria;

	public CobrancaSegmentoT(ContaBancaria contaBancaria) {
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

	public Integer getCodigoMovimentoRetorno() {
		return codigoMovimentoRetorno;
	}

	public void setCodigoMovimentoRetorno(Integer codigoMovimentoRetorno) {
		this.codigoMovimentoRetorno = codigoMovimentoRetorno;
	}

	public Integer getAgenciaMantenedora() {
		return agenciaMantenedora;
	}

	public void setAgenciaMantenedora(Integer agenciaMantenedora) {
		this.agenciaMantenedora = agenciaMantenedora;
	}

	public Integer getNumeroContaCorrente() {
		return numeroContaCorrente;
	}

	public void setNumeroContaCorrente(Integer numeroContaCorrente) {
		this.numeroContaCorrente = numeroContaCorrente;
	}

	public String getDigitoVerificadorContaCorrente() {
		return digitoVerificadorContaCorrente;
	}

	public void setDigitoVerificadorContaCorrente(String digitoVerificadorContaCorrente) {
		this.digitoVerificadorContaCorrente = digitoVerificadorContaCorrente;
	}

	public Integer getCodigoCarteira() {
		return codigoCarteira;
	}

	public void setCodigoCarteira(Integer codigoCarteira) {
		this.codigoCarteira = codigoCarteira;
	}

	public String getNumeroDocumentoCobranca() {
		return numeroDocumentoCobranca;
	}

	public void setNumeroDocumentoCobranca(String numeroDocumentoCobranca) {
		this.numeroDocumentoCobranca = numeroDocumentoCobranca;
	}

	public Date getDataVencimentoTitulo() {
		return dataVencimentoTitulo;
	}

	public void setDataVencimentoTitulo(Date dataVencimentoTitulo) {
		this.dataVencimentoTitulo = dataVencimentoTitulo;
	}

	public BigDecimal getValorNominalTitulo() {
		return valorNominalTitulo;
	}

	public void setValorNominalTitulo(BigDecimal valorNominalTitulo) {
		this.valorNominalTitulo = valorNominalTitulo;
	}

	public String getIdentificadorTituloEmpresa() {
		return identificadorTituloEmpresa;
	}

	public void setIdentificadorTituloEmpresa(String identificadorTituloEmpresa) {
		this.identificadorTituloEmpresa = identificadorTituloEmpresa;
	}

	public String getCodigoMoeda() {
		return codigoMoeda;
	}

	public void setCodigoMoeda(String codigoMoeda) {
		this.codigoMoeda = codigoMoeda;
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

	public String getIndicadorBoletoDDA() {
		return indicadorBoletoDDA;
	}

	public void setIndicadorBoletoDDA(String indicadorBoletoDDA) {
		this.indicadorBoletoDDA = indicadorBoletoDDA;
	}

	public Integer getZeros1() {
		return zeros1;
	}

	public void setZeros1(Integer zeros1) {
		this.zeros1 = zeros1;
	}

	public Integer getZeros2() {
		return zeros2;
	}

	public void setZeros2(Integer zeros2) {
		this.zeros2 = zeros2;
	}

	public Integer getZeros3() {
		return zeros3;
	}

	public void setZeros3(Integer zeros3) {
		this.zeros3 = zeros3;
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

	public String getBrancos() {
		return brancos;
	}

	public void setBrancos(String brancos) {
		this.brancos = brancos;
	}

	public Integer getZeros4() {
		return zeros4;
	}

	public void setZeros4(Integer zeros4) {
		this.zeros4 = zeros4;
	}

	public Integer getZeros5() {
		return zeros5;
	}

	public void setZeros5(Integer zeros5) {
		this.zeros5 = zeros5;
	}

	public Integer getAgenciaCobradora() {
		return agenciaCobradora;
	}

	public void setAgenciaCobradora(Integer agenciaCobradora) {
		this.agenciaCobradora = agenciaCobradora;
	}

	public String getDigitoagenciaCobradora() {
		return digitoagenciaCobradora;
	}

	public void setDigitoagenciaCobradora(String digitoagenciaCobradora) {
		this.digitoagenciaCobradora = digitoagenciaCobradora;
	}

	public String getBrancos3() {
		return brancos3;
	}

	public void setBrancos3(String brancos3) {
		this.brancos3 = brancos3;
	}

	public Integer getZeros6() {
		return zeros6;
	}

	public void setZeros6(Integer zeros6) {
		this.zeros6 = zeros6;
	}

	public String getCodigoLiquidacao() {
		return codigoLiquidacao;
	}

	public void setCodigoLiquidacao(String codigoLiquidacao) {
		this.codigoLiquidacao = codigoLiquidacao;
	}

	public String getBrancos4() {
		return brancos4;
	}

	public void setBrancos4(String brancos4) {
		this.brancos4 = brancos4;
	}

	public ContaBancaria getContaBancaria() {
		return contaBancaria;
	}

	public void setContaBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

	public String getIdentificadorRejeicao() {
		return identificadorRejeicao;
	}

	public BigDecimal getValorTarifaCustas() {
		return valorTarifaCustas;
	}

	public void setValorTarifaCustas(BigDecimal valorTarifaCustas) {
		this.valorTarifaCustas = valorTarifaCustas;
	}

	public String getMotivoRejeicao1() {
		return identificadorRejeicao;
	}

	public void setIdentificadorRejeicao(String identificadorRejeicao) {
		this.identificadorRejeicao = identificadorRejeicao;
	}

	public String getBrancos2() {
		return brancos2;
	}

	public void setBrancos2(String brancos2) {
		this.brancos2 = brancos2;
	}

	public static CobrancaSegmentoT of(ContaBancaria contaBancaria) {
		return new CobrancaSegmentoT(contaBancaria);
	}

	public int getNumberOfRecords() {
		return 0;
	}

	public void readRowData(int row, int sequence) {

	}

	public void set(Record record) {
		setCodigoSegmentoRegistro((String) record.getValue(CD_SEGMENTO_REGISTRO));
		setCodigoBanco((Integer) record.getValue(CD_BANCO));
		setLoteServico((Integer) record.getValue(LT_SERVICO));
		setTipoRegistro((Integer) record.getValue(TP_REGISTRO));
		setNumeroSequencialRegistro((Integer) record.getValue(NR_SEQUENCIAL_REGISTRO));
		setCodigoMovimentoRetorno((Integer) record.getValue(CD_MOVIMENTO_RETORNO));
		setAgenciaMantenedora((Integer) record.getValue(AGENCIA_MANTENEDORA));
		setNumeroContaCorrente((Integer) record.getValue(NR_CONTACORRENTE));
		setDigitoVerificadorContaCorrente((String) record.getValue(DIGITO_CONTACORRENTE));
		setNumeroDocumentoCobranca((String) record.getValue(NR_DOCUMENTO_COBRANCA));
		setDataVencimentoTitulo((Date) record.getValue(DT_VENCIMENTO));
		setValorNominalTitulo((BigDecimal) record.getValue(VL_NOMINAL_TITULO));
		setAgenciaCobradora((Integer) record.getValue(AGENCIA_COBRADORA));
		setDigitoagenciaCobradora((String) record.getValue(DIGITO_AGENCIA_COBRADORA));
		setIdentificadorTituloEmpresa((String) record.getValue(ID_TITULO_EMPRESA));
		setCodigoMoeda((String) record.getValue(CD_MOEDA));
		setTipoInscricaoSacadoAvalista((Integer) record.getValue(TP_INSCRICAO_SACADO_AVALISTA));
		setNumeroInscricaoSacadoAvalista((Long) record.getValue(NR_INSCRICAO_SACADO_AVALISTA));
		setNomeSacadorAvalista((String) record.getValue(NOME_SACADOR_AVALISTA));
		setValorTarifaCustas((BigDecimal) record.getValue(VL_TARIFA_CUSTAS));
		setIdentificadorRejeicao((String) record.getValue(CD_MOTIVO_REJEICAO));
	}

}
