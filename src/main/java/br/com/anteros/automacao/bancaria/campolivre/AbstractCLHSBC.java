package br.com.anteros.automacao.bancaria.campolivre;

import br.com.anteros.integracao.bancaria.banco.febraban.Titulo;

/**
 * <p>
 * Interface comum para todos os campos livres do Banco HSBC que venham a
 * existir.
 * </p>
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * @author <a href="mailto:misaelbarreto@gmail.com">Misael Barreto</a>
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * @author <a href="http://www.nordestefomento.com.br">Nordeste Fomento
 *         Mercantil</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
abstract class AbstractCLHSBC extends AbstractCampoLivre {

	/**
	 *
	 */
	private static final long serialVersionUID = 3179450500491723317L;

	/**
	 * <p>Cria um campo livre com um determinado número de campos</p>
	 * 
	 * @see AbstractCampoLivre
	 * 
	 * @param fieldsLength - Número de campos
	 */
	protected AbstractCLHSBC(Integer fieldsLength) {
		
		super(fieldsLength);
	}

	 protected static CampoLivre create(Titulo titulo) {
		
		checkCarteiraNotNull(titulo);
		checkRegistroDaCarteiraNotNull(titulo);

		switch(titulo.getCarteira().getTipoDeCobranca()){
		case SEM_REGISTRO:
			return new CLHSBCCobrancaNaoRegistrada(titulo);
		case COM_REGISTRO:
			return new CLHSBCCobrancaRegistrada(titulo);
		default:
			return null;
		}
	}
}
