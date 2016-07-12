package br.com.anteros.integracao.bancaria.banco.layout.cnab200.bancobrasil;

import java.math.BigDecimal;
import java.util.Date;

import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.Formats;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.language.EnumTypes;
import br.com.anteros.integracao.bancaria.banco.layout.Lancamento;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.*;

public class ConciliacaoDetalheRetorno implements Lancamento {		
	
	@IdType(name = ID_TIPOREGISTRO, length = 1, positionField = 8, value = "1")
	private String tipoRegistro;
	
	@Field(name = CD_REGISTRO, length = 1, value = "1", type=EnumTypes.INTEGER)
	private Integer codigoRegistro;
	
	@Field(name=TP_TIPO_INSCRICAO, length=2)
	private String tipoInscricao;
	
	@Field(name=NR_INSCRICAO_EMPRESA, length=14)
	private String numeroInscricaoEmpresa;
	
	@Field(name=AGENCIA, length=4, type=EnumTypes.INTEGER)
	private Integer agencia;
	
	@Field(name="BRANCOS1", length=8, padding=Paddings.WHITE_SPACE_RIGHT)
	private String brancos1;
	
	@Field(name=NR_CONTACORRENTE, length=11, type=EnumTypes.INTEGER)
	private Integer codigoContaCorrente;
	
	@Field(name=DIGITO_CONTA_CORRENTE, length=1)
	private String digitoContaCorrente;
	
	@Field(name=CATEGORIA_LANCAMENTO, length=3)
	private String categoriaLancamento;
	
	@Field(name=CD_LANCAMENTO, length=4, type=EnumTypes.INTEGER)
	private Integer codigoLancamento;

	@Field(name=LITERAL_LANCAMENTO, length=25)
	private String literalLancamento;
	
	@Field(name=NR_DOCUMENTO, length=6, type=EnumTypes.INTEGER)
	private Integer numeroDocumento;
	
	@Field(name=DT_LANCAMENTO, length=6, format=Formats.DATE_DDMMYY, type=EnumTypes.DATE)
	private Date dataLancamento;
	
	@Field(name=VL_LANCAMENTO, length=16, format=Formats.DECIMAL_DD, type=EnumTypes.BIGDECIMAL)
	private BigDecimal valorLancamento;
	
	@Field(name=DT_BALANCETE, length=6, format=Formats.DECIMAL_DD, type=EnumTypes.DATE)
	private Date dataBalancete;
	
	@Field(name=NR_LOTE, length=5, type=EnumTypes.INTEGER)
	private Integer numeroLote;
	
	@Field(name=AGENCIA_ORIGEM_LANCAMENTO, length=4, type=EnumTypes.INTEGER)
	private Integer agenciaOrigemLancamento;
	
	@Field(name=CD_BANCO_ORIGEM, length=3, type=EnumTypes.INTEGER)
	private Integer codigoBancoOrigem;
	
	@Field(name=IDENTIFICADOR_CPMF, length=1)
	private String identificadorCPMF;
	
	@Field(name="BRANCOS2", length=5)
	private String brancos2;
	
	@Field(name=CD_SUBHISTORICO, length=7)
	private String codigoSubHistorico;
	
	@Field(name="BRANCOS3", length=15)
	private String brancos3;
	
	@Field(name="BRANCOS4", length=23)
	private String brancos4;
	
	@Field(name="BRANCOS5", length=8)
	private String brancos5;
	
	@Field(name="BRANCOS6", length=8)
	private String brancos6;
	
	@Field(name="BRANCOS7", length=2)
	private String brancos7;
	
	@Field(name="BRANCOS8", length=3)
	private String brancos8;
	
	@Field(name=NR_SEQUENCIAL_REGISTRO, length=6, padding=Paddings.ZERO_LEFT, type=EnumTypes.INTEGER)
	private Integer numeroSequencialRegistro;	
	
	
	public void set(br.com.anteros.flatfile.Record record) {
		
	}


	public String getTipoRegistro() {
		return tipoRegistro;
	}


	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}


	public Integer getCodigoRegistro() {
		return codigoRegistro;
	}


	public void setCodigoRegistro(Integer codigoRegistro) {
		this.codigoRegistro = codigoRegistro;
	}


	public String getTipoInscricao() {
		return tipoInscricao;
	}


	public void setTipoInscricao(String tipoInscricao) {
		this.tipoInscricao = tipoInscricao;
	}


	public String getNumeroInscricaoEmpresa() {
		return numeroInscricaoEmpresa;
	}


	public void setNumeroInscricaoEmpresa(String numeroInscricaoEmpresa) {
		this.numeroInscricaoEmpresa = numeroInscricaoEmpresa;
	}


	public Integer getAgencia() {
		return agencia;
	}


	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}


	public Integer getCodigoContaCorrente() {
		return codigoContaCorrente;
	}


	public void setCodigoContaCorrente(Integer codigoContaCorrente) {
		this.codigoContaCorrente = codigoContaCorrente;
	}


	public String getDigitoContaCorrente() {
		return digitoContaCorrente;
	}


	public void setDigitoContaCorrente(String digitoContaCorrente) {
		this.digitoContaCorrente = digitoContaCorrente;
	}


	public String getCategoriaLancamento() {
		return categoriaLancamento;
	}


	public void setCategoriaLancamento(String categoriaLancamento) {
		this.categoriaLancamento = categoriaLancamento;
	}


	public Integer getCodigoLancamento() {
		return codigoLancamento;
	}


	public void setCodigoLancamento(Integer codigoLancamento) {
		this.codigoLancamento = codigoLancamento;
	}


	public String getLiteralLancamento() {
		return literalLancamento;
	}


	public void setLiteralLancamento(String literalLancamento) {
		this.literalLancamento = literalLancamento;
	}


	public Integer getNumeroDocumento() {
		return numeroDocumento;
	}


	public void setNumeroDocumento(Integer numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}


	public Date getDataLancamento() {
		return dataLancamento;
	}


	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}


	public BigDecimal getValorLancamento() {
		return valorLancamento;
	}


	public void setValorLancamento(BigDecimal valorLancamento) {
		this.valorLancamento = valorLancamento;
	}


	public Date getDataBalancete() {
		return dataBalancete;
	}


	public void setDataBalancete(Date dataBalancete) {
		this.dataBalancete = dataBalancete;
	}


	public Integer getNumeroLote() {
		return numeroLote;
	}


	public void setNumeroLote(Integer numeroLote) {
		this.numeroLote = numeroLote;
	}


	public Integer getAgenciaOrigemLancamento() {
		return agenciaOrigemLancamento;
	}


	public void setAgenciaOrigemLancamento(Integer agenciaOrigemLancamento) {
		this.agenciaOrigemLancamento = agenciaOrigemLancamento;
	}


	public Integer getCodigoBancoOrigem() {
		return codigoBancoOrigem;
	}


	public void setCodigoBancoOrigem(Integer codigoBancoOrigem) {
		this.codigoBancoOrigem = codigoBancoOrigem;
	}


	public String getIdentificadorCPMF() {
		return identificadorCPMF;
	}


	public void setIdentificadorCPMF(String identificadorCPMF) {
		this.identificadorCPMF = identificadorCPMF;
	}


	public String getCodigoSubHistorico() {
		return codigoSubHistorico;
	}


	public void setCodigoSubHistorico(String codigoSubHistorico) {
		this.codigoSubHistorico = codigoSubHistorico;
	}


	public Integer getNumeroSequencialRegistro() {
		return numeroSequencialRegistro;
	}


	public void setNumeroSequencialRegistro(Integer numeroSequencialRegistro) {
		this.numeroSequencialRegistro = numeroSequencialRegistro;
	}

}
