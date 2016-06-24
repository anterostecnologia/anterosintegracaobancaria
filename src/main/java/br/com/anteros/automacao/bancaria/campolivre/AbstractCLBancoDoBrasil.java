package br.com.anteros.automacao.bancaria.campolivre;

import br.com.anteros.integracao.bancaria.banco.febraban.Titulo;

/**
 * <p>
 * Interface comum para todos os campos livres do Banco do Brasil que venham a existir.
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
abstract class AbstractCLBancoDoBrasil extends AbstractCampoLivre {
	
	/**
	 *
	 */
	private static final long serialVersionUID = -7324315662526104153L;

	/**
	 * <p>Cria um campo livre com um determinado número de campos</p>
	 * 
	 * @see AbstractCampoLivre
	 * 
	 * @param fieldsLength - Número de campos
	 */
	protected AbstractCLBancoDoBrasil(Integer fieldsLength) {
		
		super(fieldsLength);
	}

	protected static CampoLivre create(Titulo titulo) throws NotSupportedCampoLivreException{

		checkNossoNumero(titulo);
		checkNumeroDaContaNotNull(titulo);
		checkCodigoDoNumeroDaConta(titulo);
		
		switch(titulo.getNossoNumero().length()){
		case NN10:
			return new CLBancoDoBrasilNN10(titulo);
		case NN11:
			return new CLBancoDoBrasilNN11(titulo);
		case NN17:
			if(titulo.getContaBancaria().getNumeroDaConta().getCodigoDaConta() < 1000000){
				return new CLBancoDoBrasilNN17Convenio6(titulo);
			}else{
				return new CLBancoDoBrasilNN17Convenio7().build(titulo);
			}
		default:
			throw new NotSupportedCampoLivreException(
					"Campo livre diponível somente para títulos com nosso número " +
					"composto por 10 posições(convênio com 7), 11 posições ou " +
					"17 posições(convênio com 6)."
				);
		}
	}
}
