package br.com.anteros.automacao.bancaria.campolivre;

import br.com.anteros.integracao.bancaria.banco.febraban.Titulo;

/**
 * <p>
 * Interface comum para todos os campos livres do CECRED - Cooperativa Central de Crédito Urbano que
 * venham a existir.
 * </p>
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public abstract class AbstractCLCecred extends AbstractCampoLivre {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5579081722726761569L;

	protected AbstractCLCecred(Integer fieldsLength) {
		super(fieldsLength);
	}
	
	protected static CampoLivre create(Titulo titulo){
		return new CLCecred().build(titulo);
	}	

}