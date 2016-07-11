package br.com.anteros.integracao.bancaria.banco.febraban.cnab400.santander;

import java.math.BigDecimal;

import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.Formats;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.language.EnumTypes;
import br.com.anteros.integracao.bancaria.banco.febraban.ContaBancaria;

public class TraillerArquivoRetorno {
	
	
	@IdType(name="CD_REGISTRO", length=1, positionField=1, value="9")
	private Integer codigoRegistro;

	@Field(name="CD_RETORNO", length=1)
	private String codigoRetorno;
	
	@Field(name="BRANCOS1", length=2, value=" ", padding=Paddings.WHITE_SPACE_RIGHT)
	private String brancos1;
	
	@Field(name="CD_BANCO", length=3, type=EnumTypes.INTEGER, padding=Paddings.ZERO_LEFT)
	private Integer codigoBanco;
	
	@Field(name="BRANCOS2", length=10, value=" ", padding=Paddings.WHITE_SPACE_RIGHT)
	private String brancos2;
		
	@Field(name="QT_TITULOS_CARTEIRA_SIMPLES", length=8, type=EnumTypes.LONG, padding=Paddings.ZERO_LEFT)
	private Long quantidadeTitulosCarteiraSimples;
	
	@Field(name="VL_TOTAL_CARTEIRA_SIMPLES", length=13, type=EnumTypes.BIGDECIMAL, format=Formats.DECIMAL_DD)
	private BigDecimal valorTotalTitulosCarteiraSimples;
	
	@Field(name="NR_AVISO_CARTEIRA_SIMPLES", length=8, type=EnumTypes.LONG, padding=Paddings.ZERO_LEFT)
	private Long numeroAvisoCarteiraSimples;
	
	@Field(name="BRANCOS_CARTEIRA_SIMPLES", length=10, value=" ", padding=Paddings.WHITE_SPACE_RIGHT)
	private String brancosCarteiraSimples;
	
	@Field(name="QT_TITULOS_CARTEIRA_VINCULADA", length=8, type=EnumTypes.LONG, padding=Paddings.ZERO_LEFT)
	private Long quantidadeTitulosCarteiraVinculada;
	
	@Field(name="VL_TOTAL_CARTEIRA_VINCULADA", length=13, type=EnumTypes.BIGDECIMAL, format=Formats.DECIMAL_DD)
	private BigDecimal valorTotalTitulosCarteiraVinculada;
	
	@Field(name="NR_AVISO_CARTEIRA_VINCULADA", length=8, type=EnumTypes.LONG, padding=Paddings.ZERO_LEFT)
	private Long numeroAvisoCarteiraVinculada;
	
	@Field(name="BRANCOS_CARTEIRA_VINCULADA", length=10, value=" ", padding=Paddings.WHITE_SPACE_RIGHT)
	private String brancosCarteiraVinculada;
	
	@Field(name="QT_TITULOS_CARTEIRA_CAUCIONADA", length=8, type=EnumTypes.LONG, padding=Paddings.ZERO_LEFT)
	private Long quantidadeTitulosCarteiraCaucionada;
	
	@Field(name="VL_TOTAL_CARTEIRA_CAUCIONADA", length=13, type=EnumTypes.BIGDECIMAL, format=Formats.DECIMAL_DD)
	private BigDecimal valorTotalTitulosCarteiraCaucionada;
	
	@Field(name="NR_AVISO_CARTEIRA_CAUCIONADA", length=8, type=EnumTypes.LONG, padding=Paddings.ZERO_LEFT)
	private Long numeroAvisoCarteiraCaucionada;
	
	@Field(name="BRANCOS_CARTEIRA_CAUCIONADA", length=10, value=" ", padding=Paddings.WHITE_SPACE_RIGHT)
	private String brancosCarteiraCaucionada;
	
	@Field(name="QT_TITULOS_CARTEIRA_DESCONTADA", length=8, type=EnumTypes.LONG, padding=Paddings.ZERO_LEFT)
	private Long quantidadeTitulosCarteiraDescontada;
	
	@Field(name="VL_TOTAL_CARTEIRA_DESCONTADA", length=13, type=EnumTypes.BIGDECIMAL, format=Formats.DECIMAL_DD)
	private BigDecimal valorTotalTitulosCarteiraDescontada;
	
	@Field(name="NR_AVISO_CARTEIRA_DESCONTADA", length=8, type=EnumTypes.LONG, padding=Paddings.ZERO_LEFT)
	private Long numeroAvisoCarteiraDescontada;
	
	@Field(name="BRANCOS_CARTEIRA_DESCONTADA", length=10, value=" ", padding=Paddings.WHITE_SPACE_RIGHT)
	private String brancosCarteiraDescontada;
	
	@Field(name="QT_TITULOS_CARTEIRA_VENDOR", length=8, type=EnumTypes.LONG, padding=Paddings.ZERO_LEFT)
	private Long quantidadeTitulosCarteiraVendor;
	
	@Field(name="VL_TOTAL_CARTEIRA_VENDOR", length=13, type=EnumTypes.BIGDECIMAL, format=Formats.DECIMAL_DD)
	private BigDecimal valorTotalTitulosCarteiraVendor;
	
	@Field(name="NR_AVISO_CARTEIRA_VENDOR", length=8, type=EnumTypes.LONG, padding=Paddings.ZERO_LEFT)
	private Long numeroAvisoCarteiraVendor;
	
	@Field(name="BRANCOS_CARTEIRA_VENDOR", length=10, value=" ", padding=Paddings.WHITE_SPACE_RIGHT)
	private String brancosCarteiraVendor;
	
	@Field(name="NR_SEQUENCIAL_REGISTRO", length=6, padding=Paddings.ZERO_LEFT)
	private Integer numeroSequencialRegistro;

	public TraillerArquivoRetorno(ContaBancaria contaBancaria) {
	}

	public Integer getCodigoRegistro() {
		return codigoRegistro;
	}

	public void setCodigoRegistro(Integer codigoRegistro) {
		this.codigoRegistro = codigoRegistro;
	}

	public String getCodigoRetorno() {
		return codigoRetorno;
	}

	public void setCodigoRetorno(String codigoRetorno) {
		this.codigoRetorno = codigoRetorno;
	}

	public String getBrancos1() {
		return brancos1;
	}

	public void setBrancos1(String brancos1) {
		this.brancos1 = brancos1;
	}

	public Integer getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(Integer codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public String getBrancos2() {
		return brancos2;
	}

	public void setBrancos2(String brancos2) {
		this.brancos2 = brancos2;
	}

	public Long getQuantidadeTitulosCarteiraSimples() {
		return quantidadeTitulosCarteiraSimples;
	}

	public void setQuantidadeTitulosCarteiraSimples(Long quantidadeTitulosCarteiraSimples) {
		this.quantidadeTitulosCarteiraSimples = quantidadeTitulosCarteiraSimples;
	}

	public BigDecimal getValorTotalTitulosCarteiraSimples() {
		return valorTotalTitulosCarteiraSimples;
	}

	public void setValorTotalTitulosCarteiraSimples(BigDecimal valorTotalTitulosCarteiraSimples) {
		this.valorTotalTitulosCarteiraSimples = valorTotalTitulosCarteiraSimples;
	}

	public Long getNumeroAvisoCarteiraSimples() {
		return numeroAvisoCarteiraSimples;
	}

	public void setNumeroAvisoCarteiraSimples(Long numeroAvisoCarteiraSimples) {
		this.numeroAvisoCarteiraSimples = numeroAvisoCarteiraSimples;
	}

	public String getBrancosCarteiraSimples() {
		return brancosCarteiraSimples;
	}

	public void setBrancosCarteiraSimples(String brancosCarteiraSimples) {
		this.brancosCarteiraSimples = brancosCarteiraSimples;
	}

	public Long getQuantidadeTitulosCarteiraVinculada() {
		return quantidadeTitulosCarteiraVinculada;
	}

	public void setQuantidadeTitulosCarteiraVinculada(Long quantidadeTitulosCarteiraVinculada) {
		this.quantidadeTitulosCarteiraVinculada = quantidadeTitulosCarteiraVinculada;
	}

	public BigDecimal getValorTotalTitulosCarteiraVinculada() {
		return valorTotalTitulosCarteiraVinculada;
	}

	public void setValorTotalTitulosCarteiraVinculada(BigDecimal valorTotalTitulosCarteiraVinculada) {
		this.valorTotalTitulosCarteiraVinculada = valorTotalTitulosCarteiraVinculada;
	}

	public Long getNumeroAvisoCarteiraVinculada() {
		return numeroAvisoCarteiraVinculada;
	}

	public void setNumeroAvisoCarteiraVinculada(Long numeroAvisoCarteiraVinculada) {
		this.numeroAvisoCarteiraVinculada = numeroAvisoCarteiraVinculada;
	}

	public String getBrancosCarteiraVinculada() {
		return brancosCarteiraVinculada;
	}

	public void setBrancosCarteiraVinculada(String brancosCarteiraVinculada) {
		this.brancosCarteiraVinculada = brancosCarteiraVinculada;
	}

	public Long getQuantidadeTitulosCarteiraCaucionada() {
		return quantidadeTitulosCarteiraCaucionada;
	}

	public void setQuantidadeTitulosCarteiraCaucionada(Long quantidadeTitulosCarteiraCaucionada) {
		this.quantidadeTitulosCarteiraCaucionada = quantidadeTitulosCarteiraCaucionada;
	}

	public BigDecimal getValorTotalTitulosCarteiraCaucionada() {
		return valorTotalTitulosCarteiraCaucionada;
	}

	public void setValorTotalTitulosCarteiraCaucionada(BigDecimal valorTotalTitulosCarteiraCaucionada) {
		this.valorTotalTitulosCarteiraCaucionada = valorTotalTitulosCarteiraCaucionada;
	}

	public Long getNumeroAvisoCarteiraCaucionada() {
		return numeroAvisoCarteiraCaucionada;
	}

	public void setNumeroAvisoCarteiraCaucionada(Long numeroAvisoCarteiraCaucionada) {
		this.numeroAvisoCarteiraCaucionada = numeroAvisoCarteiraCaucionada;
	}

	public String getBrancosCarteiraCaucionada() {
		return brancosCarteiraCaucionada;
	}

	public void setBrancosCarteiraCaucionada(String brancosCarteiraCaucionada) {
		this.brancosCarteiraCaucionada = brancosCarteiraCaucionada;
	}

	public Long getQuantidadeTitulosCarteiraDescontada() {
		return quantidadeTitulosCarteiraDescontada;
	}

	public void setQuantidadeTitulosCarteiraDescontada(Long quantidadeTitulosCarteiraDescontada) {
		this.quantidadeTitulosCarteiraDescontada = quantidadeTitulosCarteiraDescontada;
	}

	public BigDecimal getValorTotalTitulosCarteiraDescontada() {
		return valorTotalTitulosCarteiraDescontada;
	}

	public void setValorTotalTitulosCarteiraDescontada(BigDecimal valorTotalTitulosCarteiraDescontada) {
		this.valorTotalTitulosCarteiraDescontada = valorTotalTitulosCarteiraDescontada;
	}

	public Long getNumeroAvisoCarteiraDescontada() {
		return numeroAvisoCarteiraDescontada;
	}

	public void setNumeroAvisoCarteiraDescontada(Long numeroAvisoCarteiraDescontada) {
		this.numeroAvisoCarteiraDescontada = numeroAvisoCarteiraDescontada;
	}

	public String getBrancosCarteiraDescontada() {
		return brancosCarteiraDescontada;
	}

	public void setBrancosCarteiraDescontada(String brancosCarteiraDescontada) {
		this.brancosCarteiraDescontada = brancosCarteiraDescontada;
	}

	public Long getQuantidadeTitulosCarteiraVendor() {
		return quantidadeTitulosCarteiraVendor;
	}

	public void setQuantidadeTitulosCarteiraVendor(Long quantidadeTitulosCarteiraVendor) {
		this.quantidadeTitulosCarteiraVendor = quantidadeTitulosCarteiraVendor;
	}

	public BigDecimal getValorTotalTitulosCarteiraVendor() {
		return valorTotalTitulosCarteiraVendor;
	}

	public void setValorTotalTitulosCarteiraVendor(BigDecimal valorTotalTitulosCarteiraVendor) {
		this.valorTotalTitulosCarteiraVendor = valorTotalTitulosCarteiraVendor;
	}

	public Long getNumeroAvisoCarteiraVendor() {
		return numeroAvisoCarteiraVendor;
	}

	public void setNumeroAvisoCarteiraVendor(Long numeroAvisoCarteiraVendor) {
		this.numeroAvisoCarteiraVendor = numeroAvisoCarteiraVendor;
	}

	public String getBrancosCarteiraVendor() {
		return brancosCarteiraVendor;
	}

	public void setBrancosCarteiraVendor(String brancosCarteiraVendor) {
		this.brancosCarteiraVendor = brancosCarteiraVendor;
	}

	public Integer getNumeroSequencialRegistro() {
		return numeroSequencialRegistro;
	}

	public void setNumeroSequencialRegistro(Integer numeroSequencialRegistro) {
		this.numeroSequencialRegistro = numeroSequencialRegistro;
	}

	public static TraillerArquivoRetorno of(ContaBancaria contaBancaria) {
		return new TraillerArquivoRetorno(contaBancaria);
	}

	public void set(br.com.anteros.flatfile.Record record) {
		
	}
}
