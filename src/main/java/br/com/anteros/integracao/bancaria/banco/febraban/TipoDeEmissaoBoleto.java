package br.com.anteros.integracao.bancaria.banco.febraban;

import static java.lang.String.format;

public enum TipoDeEmissaoBoleto {

	BANCO_EMITE(1),
	CLIENTE_EMITE(2);
	
	private Integer tipo;
	
	private TipoDeEmissaoBoleto(Integer tipo){
		this.tipo = tipo;
	}
	
	public Integer getTipo(){
		return tipo;
	}
	
	public TipoDeEmissaoBoleto valueOfTipo(Integer tipo){
		for(TipoDeEmissaoBoleto t : values()){
			if(t.getTipo().equals(tipo)){
				return t;
			}
		}
		throw  new IllegalArgumentException(format("Nenhuma constante enum %s com tipo igual a %s!", TipoDeEmissaoBoleto.class, tipo));
	}
}
