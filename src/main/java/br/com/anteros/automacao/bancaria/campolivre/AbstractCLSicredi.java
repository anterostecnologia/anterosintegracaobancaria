package br.com.anteros.automacao.bancaria.campolivre;

import br.com.anteros.integracao.bancaria.banco.febraban.Titulo;

/**
 *<p>
 * Interface comum para todos os campos livres do Banco Sicredi que venham a
 * existir.
 * </p>
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
abstract class AbstractCLSicredi extends AbstractCampoLivre {

	/**
	 * {@code serialVersionUID = 636384334503863949L}
	 */
	private static final long serialVersionUID = 636384334503863949L;

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
	protected AbstractCLSicredi(Integer fieldsLength) {

		super(fieldsLength);
	}

	protected static CampoLivre create(Titulo titulo) {

		return new CLSicredi().build(titulo);
	}
}
