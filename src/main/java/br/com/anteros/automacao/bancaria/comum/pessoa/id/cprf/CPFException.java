package br.com.anteros.automacao.bancaria.comum.pessoa.id.cprf;



/**
 * 
 * <p>
 * Qualquer falha na geração ou operações próprias da classe CPF.
 * </p>

 * 
 * @author <a href="http://gilmatryx.googlepages.com">Gilmar P.S.L.</a>
 * @author <a href="mailto:misaelbarreto@gmail.com">Misael Barreto</a>
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * 
 * @since 0.2
 * 
 * @version 0.2 
 */

public class CPFException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = -3614884453255335650L;

	/**
	 * 
	 */
	public CPFException() {

	}

	/**
	 * @param message
	 * @param cause
	 */
	public CPFException(String message, Throwable cause) {
		super(message, cause);
		
	}

	/**
	 * @param message
	 */
	public CPFException(String message) {
		super(message);
		
	}

	/**
	 * @param cause
	 */
	public CPFException(Throwable cause) {
		super(cause);
		
	}

}
