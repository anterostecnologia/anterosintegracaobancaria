package br.com.anteros.automacao.bancaria.boleto;



/**
 * 
 * <p>
 * Qualquer exceção gerada durante a geração da Linha Digitável gera uma <code>LinhaDigitavelException</code>. Centraliza e localiza os problemas relativos a geração de uma linha digitável.
 * </p>
 * 
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * @author <a href="mailto:misaelbarreto@gmail.com">Misael Barreto</a>
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * 
 * @see org.jrimum.bopepo.LinhaDigitavel
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public class LinhaDigitavelException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8206303471509231915L;

	/**
	 * 
	 */
	public LinhaDigitavelException() {
		
	}

	/**
	 * @param message
	 * @param cause
	 */
	public LinhaDigitavelException(String message, Throwable cause) {
		super(message, cause);
		
	}

	/**
	 * @param message
	 */
	public LinhaDigitavelException(String message) {
		super(message);
		
	}

	/**
	 * @param cause
	 */
	public LinhaDigitavelException(Throwable cause) {
		super(cause);
		
	}

}
