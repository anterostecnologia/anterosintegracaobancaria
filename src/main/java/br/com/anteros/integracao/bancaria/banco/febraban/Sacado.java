package br.com.anteros.integracao.bancaria.banco.febraban;

import br.com.anteros.automacao.bancaria.comum.pessoa.id.cprf.CPRF;

/**
 * <p>
 * Representa um Sacado no modelo de negócio financeiro, que é 
 * aquele que emite um título de crédito a favor de alguém.
 * </p>
 * <p>
 * Pessoa física ou jurídica a que se destina a cobrança do compromisso, é o cliente do Cedente.
 * </p>
 * 
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public class Sacado extends EntidadeDeCobranca {

	public Sacado(String nome) {
		super(nome);
	}
	
	public Sacado(String nome, String cadastroDePessoa) {
		super(nome, cadastroDePessoa);
	}
	
	public Sacado(String nome, CPRF cadastroDePessoa) {
		super(nome, cadastroDePessoa);
	}
	
}
