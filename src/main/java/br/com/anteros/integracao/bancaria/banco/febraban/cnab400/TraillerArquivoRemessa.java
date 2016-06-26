package br.com.anteros.integracao.bancaria.banco.febraban.cnab400;

import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.language.EnumTypes;

public class TraillerArquivoRemessa {

	@IdType(name="ID_REGISTRO", length=1, position=1, value="9")
	private Integer codigoRegistro;
	
	@Field(name="BRANCOS", length=393, value=" ", padding=Paddings.WHITE_SPACE_RIGHT)
	private String brancos;
	
	@Field(name="NR_SEQUENCIAL_REGISTRO", length=6, padding=Paddings.ZERO_LEFT, type=EnumTypes.INTEGER)
	private Integer numeroSequencialRegistro;

	public Integer getCodigoRegistro() {
		return codigoRegistro;
	}

	public void setCodigoRegistro(Integer codigoRegistro) {
		this.codigoRegistro = codigoRegistro;
	}

	public String getBrancos() {
		return brancos;
	}

	public void setBrancos(String brancos) {
		this.brancos = brancos;
	}

	public Integer getNumeroSequencialRegistro() {
		return numeroSequencialRegistro;
	}

	public void setNumeroSequencialRegistro(Integer numeroSequencialRegistro) {
		this.numeroSequencialRegistro = numeroSequencialRegistro;
	}
	
	
}
