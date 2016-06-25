package br.com.anteros.integracao.bancaria.banco.febraban.cnab;

import java.math.BigDecimal;

import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.Formats;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.annotation.RecordData;
import br.com.anteros.flatfile.language.EnumTypes;
import br.com.anteros.integracao.bancaria.banco.febraban.ContaBancaria;

public class TitulosCobrancaSegmentoT implements RecordData {
	
	
	@IdType(value="T", length=1, position=5, name="CD_SEGMENTO_REGISTRO")
	private String codigoSegmentoRegistro;
	
	@Field(name="CD_BANCO", type=EnumTypes.INTEGER, length=3, padding=Paddings.ZERO_LEFT)
	private Integer codigoBanco;
	
	@Field(name="LT_SERVICO", type=EnumTypes.INTEGER, length=4, padding=Paddings.ZERO_LEFT)
	private Integer loteServico;
	
	@Field(name="TP_REGISTRO", type=EnumTypes.INTEGER, length=1, value="3", padding=Paddings.ZERO_LEFT)
	private Integer tipoRegistro; 
	
	@Field(name="NR_SEQUENCIAL_REGISTRO", type=EnumTypes.INTEGER, length=5, padding=Paddings.ZERO_LEFT)
	private Integer numeroSequencialRegistro;
	
	@Field(name="BRANCOS1", length=1, value=" ", padding=Paddings.WHITE_SPACE_RIGHT)
	private String brancos1;
	
	@Field(name="CD_MOVIMENTO_RETORNO", length=2, type=EnumTypes.INTEGER, padding=Paddings.ZERO_LEFT)
	private Integer codigoMovimentoRetorno; 
    
	@Field(name="AGENCIA_MANTENEDORA", type=EnumTypes.INTEGER, length=5, padding=Paddings.ZERO_LEFT)
    private Integer agenciaMantenedora;
    
	@Field(name="DIGITO_VERIFICADOR_AGENCIA", length=1)
    private String digitoVerificadorAgencia;
	
	@Field(name="NR_CONTACORRENTE", length=12, type=EnumTypes.INTEGER, padding=Paddings.ZERO_LEFT)
	private Integer numeroContaCorrente; 
    
	@Field(name="DIGITO_CONTACORRENTE", length=1)
    private String digitoVerificadorContaCorrente;
    
	@Field(name="DIGITO_AGENCIA_CONTA", length=1)
    private String digitoVerificadorAgenciaConta;
    
	@Field(name="ID_TITULO", length=20, padding=Paddings.WHITE_SPACE_RIGHT)
	private String identificadorTitulo;
	
	@Field(name="CD_CARTEIRA", length=1, padding=Paddings.WHITE_SPACE_RIGHT)
	private String codigoCarteira; 
    
	@Field(name="NR_DOCUMENTO_COBRANCA", length=15, padding=Paddings.WHITE_SPACE_RIGHT)
	private String numeroDocumentoCobranca;
    
	@Field(name="DT_VENCIMENTO", length=8, padding=Paddings.ZERO_LEFT, format=Formats.DATE_DDMMYYYY)
    private String dataVencimentoTitulo;
	
	@Field(name="VL_NOMINAL_TITULO", length=15, type=EnumTypes.BIGDECIMAL, padding=Paddings.ZERO_LEFT, format=Formats.DECIMAL_DD)
	private BigDecimal valorNominalTitulo;
    
	@Field(name="NR_BANCO", type=EnumTypes.INTEGER, length=3, padding=Paddings.ZERO_LEFT)
	private Integer numeroBanco;
	
	@Field(name="AGENCIA_COBRADORA_RECEBEDORA", length=5, type=EnumTypes.INTEGER, padding=Paddings.ZERO_LEFT)
	private Integer agenciaCobradoraRecebedora;
    
	@Field(name="DIGITO_AGENCIA_COBRADORA", length=1)
	private String digitoVerificadorAgenciaCobradora;
    
	@Field(name="ID_TITULO_EMPRESA", length=25)
	private String identificadorTituloEmpresa;
    
	@Field(name="CD_MOEDA", length=2, padding=Paddings.WHITE_SPACE_RIGHT)
	private String codigoMoeda;
	
	@Field(name="TP_INSCRICAO_SACADO_AVALISTA", length=1, type=EnumTypes.INTEGER, padding=Paddings.ZERO_LEFT)
	private Integer tipoInscricaoSacadoAvalista;
	
	@Field(name="NR_INSCRICAO_SACADO_AVALISTA", length=15, type=EnumTypes.LONG, padding=Paddings.ZERO_LEFT)
	private Long numeroInscricaoSacadoAvalista; 
	
	@Field(name="NOME_SACADOR_AVALISTA", length=40, padding=Paddings.WHITE_SPACE_RIGHT)
    private String nomeSacadorAvalista;	
	
	@Field(name="NR_CONTRATO_OPERACAO_CREDITO", length=10, padding=Paddings.WHITE_SPACE_RIGHT)
	private String numeroContratoOperacaoCredito;
 	
	@Field(name="VL_TARIFA_CUSTAS", length=15, type=EnumTypes.BIGDECIMAL, padding=Paddings.ZERO_LEFT, format=Formats.DECIMAL_DD)
    private BigDecimal valorTarifaCustas;
	
	@Field(name="ID_REJEICAO", length=10, padding=Paddings.WHITE_SPACE_RIGHT)
	private String identificadorRejeicao;
	
	@Field(name="BRANCOS2", length=17, padding=Paddings.WHITE_SPACE_RIGHT, value=" ")
	private String brancos2;

	private ContaBancaria contaBancaria;

	public TitulosCobrancaSegmentoT(ContaBancaria contaBancaria) {
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

	public Integer getAgenciaMantenedora() {
		return agenciaMantenedora;
	}

	public void setAgenciaMantenedora(Integer agenciaMantenedora) {
		this.agenciaMantenedora = agenciaMantenedora;
	}

	public String getDigitoVerificadorAgencia() {
		return digitoVerificadorAgencia;
	}

	public void setDigitoVerificadorAgencia(String digitoVerificadorAgencia) {
		this.digitoVerificadorAgencia = digitoVerificadorAgencia;
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

	public String getDigitoVerificadorAgenciaConta() {
		return digitoVerificadorAgenciaConta;
	}

	public void setDigitoVerificadorAgenciaConta(String digitoVerificadorAgenciaConta) {
		this.digitoVerificadorAgenciaConta = digitoVerificadorAgenciaConta;
	}

	public String getIdentificadorTitulo() {
		return identificadorTitulo;
	}

	public void setIdentificadorTitulo(String identificadorTitulo) {
		this.identificadorTitulo = identificadorTitulo;
	}

	public String getCodigoCarteira() {
		return codigoCarteira;
	}

	public void setCodigoCarteira(String codigoCarteira) {
		this.codigoCarteira = codigoCarteira;
	}

	public String getNumeroDocumentoCobranca() {
		return numeroDocumentoCobranca;
	}

	public void setNumeroDocumentoCobranca(String numeroDocumentoCobranca) {
		this.numeroDocumentoCobranca = numeroDocumentoCobranca;
	}

	public String getDataVencimentoTitulo() {
		return dataVencimentoTitulo;
	}

	public void setDataVencimentoTitulo(String dataVencimentoTitulo) {
		this.dataVencimentoTitulo = dataVencimentoTitulo;
	}

	public BigDecimal getValorNominalTitulo() {
		return valorNominalTitulo;
	}

	public void setValorNominalTitulo(BigDecimal valorNominalTitulo) {
		this.valorNominalTitulo = valorNominalTitulo;
	}

	public Integer getNumeroBanco() {
		return numeroBanco;
	}

	public void setNumeroBanco(Integer numeroBanco) {
		this.numeroBanco = numeroBanco;
	}

	public Integer getAgenciaCobradoraRecebedora() {
		return agenciaCobradoraRecebedora;
	}

	public void setAgenciaCobradoraRecebedora(Integer agenciaCobradoraRecebedora) {
		this.agenciaCobradoraRecebedora = agenciaCobradoraRecebedora;
	}

	public String getDigitoVerificadorAgenciaCobradora() {
		return digitoVerificadorAgenciaCobradora;
	}

	public void setDigitoVerificadorAgenciaCobradora(String digitoVerificadorAgenciaCobradora) {
		this.digitoVerificadorAgenciaCobradora = digitoVerificadorAgenciaCobradora;
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

	public String getNumeroContratoOperacaoCredito() {
		return numeroContratoOperacaoCredito;
	}

	public void setNumeroContratoOperacaoCredito(String numeroContratoOperacaoCredito) {
		this.numeroContratoOperacaoCredito = numeroContratoOperacaoCredito;
	}

	public BigDecimal getValorTarifaCustas() {
		return valorTarifaCustas;
	}

	public void setValorTarifaCustas(BigDecimal valorTarifaCustas) {
		this.valorTarifaCustas = valorTarifaCustas;
	}

	public String getIdentificadorRejeicao() {
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

	public static TitulosCobrancaSegmentoT of(ContaBancaria contaBancaria) {
		return new TitulosCobrancaSegmentoT(contaBancaria);
	}

	public int getNumberOfRecords() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void readRowData(int row) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
