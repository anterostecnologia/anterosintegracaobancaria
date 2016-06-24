package br.com.anteros.automacao.bancaria.campolivre;

import br.com.anteros.integracao.bancaria.banco.febraban.Titulo;

/**
 *<p>
 * Interface comum para todos os campos livres do Banco Banestes que venham a
 * existir.
 * </p>
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 * @author <a href="mailto:misaelbarreto@gmail.com">Misael Barreto</a>
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * @author <a href="mailto:samuelvalerio@gmail.com">Samuel Valério</a> Valerio
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
abstract class AbstractCLBanestes extends AbstractCampoLivre {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2713363808443832056L;

	/**
	 * <p>Cria um campo livre com um determinado número de campos</p>
	 * 
	 * @see AbstractCampoLivre
	 * 
	 * @param fieldsLength - Número de campos
	 */
	protected AbstractCLBanestes(Integer fieldsLength) {
		
		super(fieldsLength);
	}
	
	protected static CampoLivre create(Titulo titulo) throws NotSupportedCampoLivreException {
		
		return new CLBanestes(titulo);
	}
}
