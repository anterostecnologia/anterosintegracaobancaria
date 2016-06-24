package br.com.anteros.integracao.bancaria.banco.febraban;

import br.com.anteros.automacao.bancaria.comum.pessoa.id.cprf.CPRF;

/**
 * <p>
 * Representa um Sacador Avalista no modelo de negócio financeiro, que é o co-responsável
 * pelo título emitido pelo avalizado (Sacado), ou seja, caso a dívida não seja liquidada pelo Sacado,
 * cabe ao Sacador Avalista liquidá-la.
 * </p>
 * <p>
 * Cedente original do Título.
 * </p>
 * 
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public class SacadorAvalista extends EntidadeDeCobranca {

	public SacadorAvalista(String nome) {
		super(nome);
	}
	
	public SacadorAvalista(String nome, String cadastroDePessoa) {
		super(nome, cadastroDePessoa);
	}
	
	public SacadorAvalista(String nome, CPRF cadastroDePessoa) {
		super(nome, cadastroDePessoa);
	}
}
