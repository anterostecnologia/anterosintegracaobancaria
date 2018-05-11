package br.com.anteros.integracao.bancaria.banco.layout;

public class RemessaPagamento {

	private Titulo titulo;

	private Integer nrLote;

	private RemessaPagamento(Titulo titulo, Integer nrLote) {
		super();
		this.titulo = titulo;
		this.nrLote = nrLote;
	}

	public static RemessaPagamento of(Titulo titulo, Integer nrLote) {
		return new RemessaPagamento(titulo, nrLote);
	}

	public Titulo getTitulo() {
		return titulo;
	}

	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}

	public Integer getNrLote() {
		return nrLote;
	}

	public void setNrLote(Integer nrLote) {
		this.nrLote = nrLote;
	}

}
