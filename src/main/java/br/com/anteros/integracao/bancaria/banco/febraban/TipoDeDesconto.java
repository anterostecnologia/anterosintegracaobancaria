package br.com.anteros.integracao.bancaria.banco.febraban;

public enum TipoDeDesconto {

	VALOR_FIXO_ATE_A_DATA(1),
	PERCENTUAL_ATE_A_DATA(2),
	VALOR_ANTECIPACAO_DIA_CORRIDO(3),
	VALOR_ANTECIPACAO_DIA_UTIL(4),
	PERCENTUAL_SOBRE_VL_NOMINAL_DIA_CORRIDO(5),
	PERCENTUAL_SOBRE_VL_NOMINAL_DIA_UTIL(6),
	CANCELAMENTO_DESCONTO(7);
	
	private Integer tipo;
	
	private TipoDeDesconto(Integer tipo){
		this.tipo = tipo;
	}
	
	public Integer getTipo(){
		return tipo;
	}
}
