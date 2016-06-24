package br.com.anteros.integracao.bancaria.banco.febraban;

public enum TipoDeProtesto {
	
	PROTESTAR_DIAS_CORRIDOS(1),
	PROTESTAR_DIAS_UTEIS(2),
	NAO_PROTESTAR(3),
	PROTESTAR_FIM_FALIMENTAR_DIAS_UTEIS(4),
	PROTESTAR_FIM_FALIMENTAR_DIAS_CORRIDAS(5),
	NEGATIVACAO_SEM_PROTESTO(8),
	CANCELAMENTO_PROTESTO_AUTOMATICO(9);
	
	private Integer tipo;
	
	private TipoDeProtesto(Integer tipo){
		this.tipo = tipo;
	}
	
	public Integer getTipo(){
		return tipo;
	}
	

}
