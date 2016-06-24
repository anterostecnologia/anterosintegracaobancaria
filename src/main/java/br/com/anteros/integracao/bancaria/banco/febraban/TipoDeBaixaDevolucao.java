package br.com.anteros.integracao.bancaria.banco.febraban;

public enum TipoDeBaixaDevolucao {
	
	BAIXAR_DEVOLVER(1),
	NAO_BAIXAR(2),
	NAO_DEVOLVER(3),
	CANCELAR_PRAZO_PARA_BAIXA_DEVOLUCAO(4);
	
	private Integer tipo;
	
	private TipoDeBaixaDevolucao(Integer tipo){
		this.tipo = tipo;
	}
	
	public Integer getTipo(){
		return tipo;
	}

}
