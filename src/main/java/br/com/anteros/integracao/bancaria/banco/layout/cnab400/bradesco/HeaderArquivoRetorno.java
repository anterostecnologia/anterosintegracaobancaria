package br.com.anteros.integracao.bancaria.banco.layout.cnab400.bradesco;

import java.util.Date;

import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.Formats;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.language.EnumTypes;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.*;

public class HeaderArquivoRetorno {

	
	@IdType(name = CD_REGISTRO, length = 1, positionField = 1, value = "0")
	private String codigoRegistro;

	@Field(name = CD_RETORNO, length = 1)
	private String codigoRetorno;

	@Field(name = "BRANCOS1", length = 7, value = " ")
	private String brancos1;

	@Field(name = "BRANCOS2", length = 2, value = " ")
	private String brancos2;

	@Field(name = "BRANCOS3", length = 15, value = " ")
	private String brancos3;
	
	@Field(name=CD_EMPRESA, length=20, padding=Paddings.ZERO_LEFT)
	private String codigoEmpresa;
	
	@Field(name=NOME_EMPRESA, length=30, padding=Paddings.WHITE_SPACE_RIGHT)
	private String nomeEmpresa;

	@Field(name = CD_BANCO, length = 3, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoBanco;

	@Field(name = NOME_BANCO, length = 15, padding = Paddings.WHITE_SPACE_RIGHT)
	private String nomeBanco;

	@Field(name = DT_GRAVACAO, length = 6, type = EnumTypes.DATE, format = Formats.DATE_DDMMYY)
	private Date dataGravacao;

	@Field(name = "BRANCOS12", length = 8, value = " ")
	private String brancos12;
	
	@Field(name = "BRANCOS13", length = 5, value = " ")
	private String brancos13;

	@Field(name = "BRANCOS14", length = 266, value = " ")
	private String brancos14;
	
	@Field(name="DT_CREDITO", length=6, format=Formats.DATE_DDMMYY, padding=Paddings.ZERO_LEFT)
	private Date dataCredito;

	@Field(name = "BRANCOS15", length = 9, value = " ")
	private String brancos15;
	
	@Field(name = "BRANCOS16", length = 6, value = " ")
	private String brancos16;

	public HeaderArquivoRetorno(ContaBancaria contaBancaria) {
	}


	public static HeaderArquivoRetorno of(ContaBancaria contaBancaria) {
		return new HeaderArquivoRetorno(contaBancaria);
	}

	public void set(br.com.anteros.flatfile.Record record) {
		setCodigoRegistro((String) record.getValue(CD_REGISTRO));
		setCodigoRetorno((String) record.getValue(CD_RETORNO));
		setCodigoBanco((Integer) record.getValue(CD_BANCO));
		setNomeBanco((String) record.getValue(NOME_BANCO));
		setDataGravacao((Date) record.getValue(DT_GRAVACAO));
		setCodigoEmpresa((String)record.getValue(CD_EMPRESA));
		setNomeEmpresa((String)record.getValue(NOME_EMPRESA));
	}


	public String getCodigoRegistro() {
		return codigoRegistro;
	}


	public void setCodigoRegistro(String codigoRegistro) {
		this.codigoRegistro = codigoRegistro;
	}


	public String getCodigoRetorno() {
		return codigoRetorno;
	}


	public void setCodigoRetorno(String codigoRetorno) {
		this.codigoRetorno = codigoRetorno;
	}


	public String getCodigoEmpresa() {
		return codigoEmpresa;
	}


	public void setCodigoEmpresa(String codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}


	public String getNomeEmpresa() {
		return nomeEmpresa;
	}


	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
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


	public Date getDataCredito() {
		return dataCredito;
	}


	public void setDataCredito(Date dataCredito) {
		this.dataCredito = dataCredito;
	}

}
