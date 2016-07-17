package br.com.anteros.integracao.bancaria.banco.layout.cnab200.extrato.bradesco;

import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CD_BANCO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CD_REGISTRO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.DT_GRAVACAO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NOME_EMPRESA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NR_SEQUENCIAL_REGISTRO;

import java.util.Date;

import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.Formats;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.language.EnumTypes;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;

public class HeaderArquivo {		

	@IdType(name = CD_REGISTRO, length = 1, positionField = 1, value = "0")
	private String codigoRegistro;
	
	@Field(name="BRANCOS1", length=8, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos1;

	@Field(name = "ID_SERVICO", length = 2)
	private String identificadorServico;
	
	@Field(name = "BRANCOS2", length = 15, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos2;
	
	@Field(name=NOME_EMPRESA, length=20)
	private String nomeEmpresa;
	
	@Field(name = "BRANCOS3", length = 30, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos3;
	
	@Field(name = CD_BANCO, length = 3, type = EnumTypes.INTEGER)
	private Integer codigoBanco;
	
	@Field(name = "BRANCOS4", length = 15, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos4;
	
	@Field(name = DT_GRAVACAO, length = 6, type = EnumTypes.DATE, format=Formats.DATE_DDMMYY)
	private Date dataGravacao;
	
	@Field(name = "BRANCOS5", length = 5, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos5;
	
	@Field(name = "BRANCOS6", length = 3, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos6;
	
	@Field(name = "BRANCOS7", length = 56, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos7;
	
	@Field(name = "BRANCOS8", length = 8, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos8;
	
	@Field(name = "BRANCOS9", length = 14, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos9;
	
	@Field(name = "BRANCOS10", length = 3, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos10;
	
	@Field(name = "BRANCOS11", length = 2, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos11;
	
	@Field(name = "BRANCOS12", length = 3, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos12;

	@Field(name = NR_SEQUENCIAL_REGISTRO, length = 6, padding = Paddings.ZERO_LEFT, type = EnumTypes.INTEGER)
	private Integer numeroSequencialRegistro;

	private ContaBancaria contaBancaria;

	public HeaderArquivo(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

	public void set(br.com.anteros.flatfile.Record record) {
		setCodigoBanco((Integer) record.getValue(CD_BANCO));
		setDataGravacao((Date) record.getValue(DT_GRAVACAO));
		setNomeEmpresa((String) record.getValue(NOME_EMPRESA));
		setNumeroSequencialRegistro((Integer) record.getValue(NR_SEQUENCIAL_REGISTRO));
	}

	public String getCodigoRegistro() {
		return codigoRegistro;
	}

	public void setCodigoRegistro(String codigoRegistro) {
		this.codigoRegistro = codigoRegistro;
	}

	public String getIdentificadorServico() {
		return identificadorServico;
	}

	public void setIdentificadorServico(String identificadorServico) {
		this.identificadorServico = identificadorServico;
	}

	public Integer getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(Integer codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public Date getDataGravacao() {
		return dataGravacao;
	}

	public void setDataGravacao(Date dataGravacao) {
		this.dataGravacao = dataGravacao;
	}

	public Integer getNumeroSequencialRegistro() {
		return numeroSequencialRegistro;
	}

	public void setNumeroSequencialRegistro(Integer numeroSequencialRegistro) {
		this.numeroSequencialRegistro = numeroSequencialRegistro;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public static HeaderArquivo of(ContaBancaria contaBancaria) {
		return new HeaderArquivo(contaBancaria);
	}

}
