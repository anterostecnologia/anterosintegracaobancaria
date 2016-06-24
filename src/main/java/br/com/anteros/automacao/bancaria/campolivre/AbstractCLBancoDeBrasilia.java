package br.com.anteros.automacao.bancaria.campolivre;

import br.com.anteros.integracao.bancaria.banco.febraban.Titulo;

/**
 * <p>
 * Interface comum para todos os campos livres do BRB - Banco de Brasília que
 * venham a existir.
 * </p>
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * @author <a href="mailto:contato@douglasramiro.com.br">Douglas Ramiro</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public abstract class AbstractCLBancoDeBrasilia extends AbstractCampoLivre {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3200353843356508888L;

	protected AbstractCLBancoDeBrasilia(Integer fieldsLength) {
		super(fieldsLength);
	}
	
	protected static CampoLivre create(Titulo titulo){
		return new CLBancoDeBrasilia().build(titulo);
	}	
}