package br.com.anteros.integracao.bancaria.banco.febraban;

import br.com.anteros.automacao.bancaria.comum.pessoa.id.cprf.CPRF;

/**
 * <p>
 * Representa um Cedente no modelo de negócio financeiro, que é 
 * aquele que realiza a cobrança do título.
 * </p>
 * <p>
 * Cliente que entrega os títulos ao Banco para serem cobrados.
 * </p>
 * 
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public class Cedente extends EntidadeDeCobranca {

	public Cedente(String nome) {
		super(nome);
	}
	
	public Cedente(String nome, String cadastroDePessoa) {
		super(nome, cadastroDePessoa);
	}
	
	public Cedente(String nome, CPRF cadastroDePessoa) {
		super(nome, cadastroDePessoa);
	}
}
