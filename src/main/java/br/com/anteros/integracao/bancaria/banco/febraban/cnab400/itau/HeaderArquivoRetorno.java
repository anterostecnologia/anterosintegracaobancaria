package br.com.anteros.integracao.bancaria.banco.febraban.cnab400.itau;

import java.util.Date;

import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.Formats;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.language.EnumTypes;
import br.com.anteros.integracao.bancaria.banco.febraban.ContaBancaria;

public class HeaderArquivoRetorno {

	
	@IdType(name="CD_REGISTRO", length=1, position=1, value="0")
	private Integer codigoRegistro;
	
	@Field(name="CD_RETORNO", length=1)
	private String codigoRetorno;
	
	@Field(name="BRANCOS1", length=7, value=" ")
	private String brancos1;
	
	@Field(name="BRANCOS2", length=2, value=" ")
	private String brancos2;
	
	@Field(name="BRANCOS3", length=8, value=" ")
	private String brancos3;
	
	@Field(name="BRANCOS4", length=7, value=" ")
	private String brancos4;
	
	@Field(name="BRANCOS5", length=4, value=" ")
	private String brancos5;
	
	@Field(name="BRANCOS6", length=1, value=" ")
	private String brancos6;
	
	@Field(name="BRANCOS8", length=8, value=" ")
	private String brancos8;
	
	@Field(name="BRANCOS9", length=1, value=" ")
	private String brancos9;
	
	@Field(name="BRANCOS10", length=6, value=" ")
	private String brancos10;
	
	@Field(name="BRANCOS11", length=30, value=" ")
	private String brancos11;
	
	@Field(name="CD_BANCO", length=3, type=EnumTypes.INTEGER, padding=Paddings.ZERO_LEFT)
	private Integer codigoBanco;
	
	@Field(name="NOME_BANCO", length=15, padding=Paddings.WHITE_SPACE_RIGHT)
	private String nomeBanco;
	
	@Field(name="DT_GRAVACAO", length=6, type=EnumTypes.DATE, format=Formats.DATE_DDMMYY)
	private Date dataGravacao;
	
	@Field(name="BRANCOS12", length=7, value=" ")
	private String brancos12;
	
	@Field(name="BRANCOS13", length=42, value=" ")
	private String brancos13;

	@Field(name="BRANCOS14", length=7, value=" ")
	private String brancos14;
	
	@Field(name="BRANCOS15", length=238, value=" ")
	private String brancos15;
	
	@Field(name="BRANCOS16", length=6, value=" ")
	private String brancos16;

	public HeaderArquivoRetorno(ContaBancaria contaBancaria) {
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

	public String getBrancos2() {
		return brancos2;
	}

	public void setBrancos2(String brancos2) {
		this.brancos2 = brancos2;
	}

	public String getBrancos3() {
		return brancos3;
	}

	public void setBrancos3(String brancos3) {
		this.brancos3 = brancos3;
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

	public String getBrancos8() {
		return brancos8;
	}

	public void setBrancos8(String brancos8) {
		this.brancos8 = brancos8;
	}

	public String getBrancos9() {
		return brancos9;
	}

	public void setBrancos9(String brancos9) {
		this.brancos9 = brancos9;
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

	public Integer getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(Integer codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

	public Date getDataGravacao() {
		return dataGravacao;
	}

	public void setDataGravacao(Date dataGravacao) {
		this.dataGravacao = dataGravacao;
	}

	public String getBrancos12() {
		return brancos12;
	}

	public void setBrancos12(String brancos12) {
		this.brancos12 = brancos12;
	}

	public String getBrancos13() {
		return brancos13;
	}

	public void setBrancos13(String brancos13) {
		this.brancos13 = brancos13;
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

	public static HeaderArquivoRetorno of(ContaBancaria contaBancaria) {
		return new HeaderArquivoRetorno(contaBancaria);
	}

	public void set(br.com.anteros.flatfile.Record record) {
		
	}
	
	
			
	
}
