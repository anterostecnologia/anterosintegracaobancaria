package br.com.anteros.integracao.bancaria.banco.febraban;

public class RemessaCobranca {
	
	private TipoDeMovimentoRemessa codigoMovimentoRemessa;
	
	private Titulo titulo;
	
	private Long nrLote;
	
	
	
	public TipoDeMovimentoRemessa getCodigoMovimentoRemessa() {
		return codigoMovimentoRemessa;
	}

	public void setCodigoMovimentoRemessa(TipoDeMovimentoRemessa codigoMovimentoRemessa) {
		this.codigoMovimentoRemessa = codigoMovimentoRemessa;
	}

	public Titulo getTitulo() {
		return titulo;
	}

	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}

	public Long getNrLote() {
		return nrLote;
	}

	public void setNrLote(Long nrLote) {
		this.nrLote = nrLote;
	}
	
	

}
