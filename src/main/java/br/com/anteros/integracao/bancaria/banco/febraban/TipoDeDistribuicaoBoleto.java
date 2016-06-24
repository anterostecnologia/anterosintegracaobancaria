package br.com.anteros.integracao.bancaria.banco.febraban;

import static java.lang.String.format;

public enum TipoDeDistribuicaoBoleto {


	BANCO_DISTRIBUI("1"),
	CLIENTE_DISTRIBUI("2");
	
	private String tipo;
	
	private TipoDeDistribuicaoBoleto(String tipo){
		this.tipo = tipo;
	}
	
	public String getTipo(){
		return tipo;
	}
	
	public TipoDeDistribuicaoBoleto valueOfTipo(String tipo){
		for(TipoDeDistribuicaoBoleto t : values()){
			if(t.getTipo().equals(tipo)){
				return t;
			}
		}
		throw  new IllegalArgumentException(format("Nenhuma constante enum %s com tipo igual a %s!", TipoDeDistribuicaoBoleto.class, tipo));
	}
}
