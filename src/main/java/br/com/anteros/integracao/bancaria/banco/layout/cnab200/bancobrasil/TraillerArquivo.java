package br.com.anteros.integracao.bancaria.banco.layout.cnab200.bancobrasil;

import java.math.BigDecimal;

import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.Formats;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.language.EnumTypes;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.*;

public class TraillerArquivo {
	
	@IdType(name = TIPO_REGISTRO, length = 1, positionField = 1, value = "9")
	private String tipoRegistro;
	
	@Field(name="BRANCOS1", length=5)
	private String brancos1;
	
	@Field(name="BRANCOS2", length=6)
	private String brancos2;
	
	@Field(name=VL_TOTAL_DEBITOS, length=14, type=EnumTypes.BIGDECIMAL, format=Formats.DECIMAL_DD)
	private BigDecimal valorTotalDebitos;
	
	@Field(name=VL_TOTAL_CREDITOS, length=14, type=EnumTypes.BIGDECIMAL, format=Formats.DECIMAL_DD)
	private BigDecimal valorTotalCreditos;
	
	@Field(name="BRANCOS3", length=145)
	private String brancos3;
	
	@Field(name="BRANCOS4", length=2)
	private String brancos4;
	
	@Field(name="CD_BANCO", length=3)
	private Integer codigoBanco;
	
	@Field(name=NR_SEQUENCIAL_REGISTRO, length=6, padding=Paddings.ZERO_LEFT, type=EnumTypes.INTEGER)
	private Integer numeroSequencialRegistro;

	public String getTipoRegistro() {
		return tipoRegistro;
	}

	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public BigDecimal getValorTotalDebitos() {
		return valorTotalDebitos;
	}

	public void setValorTotalDebitos(BigDecimal valorTotalDebitos) {
		this.valorTotalDebitos = valorTotalDebitos;
	}

	public BigDecimal getValorTotalCreditos() {
		return valorTotalCreditos;
	}

	public void setValorTotalCreditos(BigDecimal valorTotalCreditos) {
		this.valorTotalCreditos = valorTotalCreditos;
	}

	public Integer getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(Integer codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public Integer getNumeroSequencialRegistro() {
		return numeroSequencialRegistro;
	}

	public void setNumeroSequencialRegistro(Integer numeroSequencialRegistro) {
		this.numeroSequencialRegistro = numeroSequencialRegistro;
	}	
	
	

}
