package br.com.anteros.integracao.bancaria.banco.febraban;

public enum TipoDeJurosMora {

	VALOR_POR_DIA(1),
	TAXA_MENSAL(2),
	ISENTO(3);
	
	private Integer tipo;
	
	private TipoDeJurosMora(Integer tipo){
		this.tipo = tipo;
	}
	
	public Integer getTipo(){
		return tipo;
	}
}
