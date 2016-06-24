package br.com.anteros.automacao.bancaria.boleto;



/**
 * 
 * <p>
 * Qualquer exceção gerada durante a geração do Código de Barras gera uma <code>CodigoDeBarrasException</code>. Centraliza e localiza os problemas relativos a geração de um código de barras.
 * </p>
 * 
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 * 
 * @see org.jrimum.bopepo.CodigoDeBarras
 * 
 * @since 0.2
 * 
 * @version 0.2
 */

public class CodigoDeBarrasException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3577770829101964833L;

	/**
	 * 
	 */
	public CodigoDeBarrasException() {
	
	}

	/**
	 * @param message
	 * @param cause
	 */
	public CodigoDeBarrasException(String message, Throwable cause) {
		super(message, cause);
	
	}

	/**
	 * @param message
	 */
	public CodigoDeBarrasException(String message) {
		super(message);
	
	}

	/**
	 * @param cause
	 */
	public CodigoDeBarrasException(Throwable cause) {
		super(cause);
	
	}

}
