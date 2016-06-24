package br.com.anteros.automacao.bancaria.campolivre;

import br.com.anteros.integracao.bancaria.banco.febraban.Titulo;

/**
 *<p>
 * Interface comum para todos os campos livres do Banco Mercantil do Brasil que
 * venham a existir.
 * </p>
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
abstract class AbstractCLMercantilDoBrasil extends AbstractCampoLivre {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6705784312499730452L;

	/**
	 * <p>Cria um campo livre com um determinado número de campos</p>
	 * 
	 * @see AbstractCampoLivre
	 * 
	 * @param fieldsLength - Número de campos
	 */
	protected AbstractCLMercantilDoBrasil(Integer fieldsLength) {
		
		super(fieldsLength);
	}
	
	protected static CampoLivre create(Titulo titulo) throws NotSupportedCampoLivreException {

		return new CLMercantilDoBrasil(titulo);
	}
}
