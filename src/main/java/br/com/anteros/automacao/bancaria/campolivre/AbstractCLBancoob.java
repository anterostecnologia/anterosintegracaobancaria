package br.com.anteros.automacao.bancaria.campolivre;

import br.com.anteros.integracao.bancaria.banco.febraban.Titulo;

/**
 *<p>
 * Interface comum para todos os campos livres do Bancoob (BANCO COOPERATIVO DO
 * BRASIL S.A.) que venham a existir.
 * </p>
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
abstract class AbstractCLBancoob extends AbstractCampoLivre {

	/**
	 * {@code serialVersionUID = 6080749970883991308L}
	 */
	private static final long serialVersionUID = 6080749970883991308L;

	/**
	 * <p>
	 * Cria um campo livre com um determinado número de campos
	 * </p>
	 * 
	 * @see AbstractCampoLivre
	 * 
	 * @param fieldsLength
	 *            - Número de campos
	 */
	protected AbstractCLBancoob(Integer fieldsLength) {

		super(fieldsLength);
	}

	/**
	 * @param titulo
	 * @return um CampoLivre
	 * 
	 * @see org.jrimum.bopepo.campolivre.AbstractCLBancoDoNordesteDoBrasil#create(Titulo)
	 */
	protected static CampoLivre create(Titulo titulo) {

		return new CLBancoobCobrancaNaoRegistrada().build(titulo);
	}
}
