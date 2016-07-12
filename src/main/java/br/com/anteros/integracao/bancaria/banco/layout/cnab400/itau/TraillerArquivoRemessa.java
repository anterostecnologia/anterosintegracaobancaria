package br.com.anteros.integracao.bancaria.banco.layout.cnab400.itau;

import java.util.List;

import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.language.EnumTypes;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.RemessaCobranca;

public class TraillerArquivoRemessa {

	@IdType(name="ID_REGISTRO", length=1, positionField=1, value="9")
	private Integer codigoRegistro;
	
	@Field(name="BRANCOS", length=393, value=" ", padding=Paddings.WHITE_SPACE_RIGHT)
	private String brancos;
	
	@Field(name="NR_SEQUENCIAL_REGISTRO", length=6, padding=Paddings.ZERO_LEFT, type=EnumTypes.INTEGER)
	private Integer numeroSequencialRegistro;

	public TraillerArquivoRemessa(ContaBancaria contaBancaria, List<RemessaCobranca> remessas) {

	}

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

	public static TraillerArquivoRemessa of(ContaBancaria contaBancaria, List<RemessaCobranca> remessas) {
		return new TraillerArquivoRemessa(contaBancaria, remessas);
	}
	
	
}
