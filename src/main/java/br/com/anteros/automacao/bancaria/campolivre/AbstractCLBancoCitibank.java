package br.com.anteros.automacao.bancaria.campolivre;

import br.com.anteros.integracao.bancaria.banco.febraban.Titulo;

/**
 * Interface comum para todos os campos livres do CITIBANK
 * 
 * @author <a href="mailto:fabianojustino@gmail.com">Fabiano Carrijo Justino</a>
 * @since 0.2
 * @version 0.2
 */
abstract class AbstractCLBancoCitibank extends AbstractCampoLivre {

	/**
	 * {@code serialVersionUID = 6080749970883991308L}
	 */
	private static final long serialVersionUID = 6080749970883991308L;

	/**
	 * <p>
	 * Cria um campo livre com um determinado nÃºmero de campos
	 * </p>
	 * 
	 * @see AbstractCampoLivre
	 * 
	 * @param fieldsLength
	 *            - NÃºmero de campos
	 */
	protected AbstractCLBancoCitibank(Integer fieldsLength) {

		super(fieldsLength);
	}

	/**
	 * @param titulo
	 * @return um CampoLivre
	 * 
	 */
	 protected static CampoLivre create(Titulo titulo)
     throws NotSupportedCampoLivreException	{
	     checkNossoNumero(titulo);
	     checkNumeroDaContaNotNull(titulo);
	     checkCodigoDoNumeroDaConta(titulo);
	     checkNossoNumero(titulo);
	     checkNumeroDaContaNotNull(titulo);
	     checkCodigoDoNumeroDaConta(titulo);
	     switch(titulo.getNossoNumero().length())
	     {
     case 11: 
         return new CLBancoCitiBankNN11(titulo);
     }
     throw new NotSupportedCampoLivreException("Campo livre diponivel somente para titulos com nosso nmero composto por 10 posicoes(convenio com 7), 11 posicoes ou 17 posicoes(convenio com 6).");
 }


}
