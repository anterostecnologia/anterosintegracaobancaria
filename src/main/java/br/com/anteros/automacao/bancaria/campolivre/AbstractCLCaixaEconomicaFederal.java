package br.com.anteros.automacao.bancaria.campolivre;

import br.com.anteros.integracao.bancaria.banco.febraban.Titulo;
import static java.lang.String.format;

/**
 *<p>
 * Interface comum para todos os campos livres do Banco Caixa Econômica Federal
 * que venham a existir.
 * </p>
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * @author <a href="mailto:misaelbarreto@gmail.com">Misael Barreto</a>
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * @author <a href="mailto:rogerio@visaosoft.com.br">Rogério Kleinkauf</a> -
 *         Colaborador do campo livre SIGCB
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
abstract class AbstractCLCaixaEconomicaFederal extends AbstractCampoLivre {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4104858478390595830L;
	
	/**
	 * <p>Cria um campo livre com um determinado número de campos</p>
	 * 
	 * @see AbstractCampoLivre
	 * 
	 * @param fieldsLength - Número de campos
	 */
	protected AbstractCLCaixaEconomicaFederal(Integer fieldsLength) {
		
		super(fieldsLength);
	}

	protected static CampoLivre create(Titulo titulo) throws NotSupportedCampoLivreException{
		
		checkNossoNumero(titulo);
		
		switch(titulo.getNossoNumero().length()){
		case NN10:
			return new CLCaixaEconomicaFederalSICOBNossoNumero10(titulo);
		case NN14:
			return new CLCaixaEconomicaFederalSICOBNossoNumero14().build(titulo);
		case NN15:
			return new CLCaixaEconomicaFederalSIGCB(titulo);
		case NN17:
			return new CLCaixaEconomicaFederalSINCO(titulo);
		default:
			throw new NotSupportedCampoLivreException(
					format("Campo Livre não suportado para o Nosso Número [%s] de tamanho [%s]." 
					+ " Apenas títulos com Nosso Número de tamanho [%s] são suportados (SICOB, SIGCB e SINCO respectivamente)."
					,titulo.getNossoNumero(), titulo.getNossoNumero().length() 
					,NN10 + "," + NN14 + ","+ NN15 + "," + NN17)
					);
		}
	}
}
