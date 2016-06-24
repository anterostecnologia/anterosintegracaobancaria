package br.com.anteros.automacao.bancaria.boleto;

/**
 * 
 * <p>
 * Qualquer exceção gerada durante a geração de um Boleto gera uma <code>BoletoExceptiton</code>. Centraliza e localiza os problemas relativos a geração de um boleto.
 * </p>
 * 
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 * 
 */

public class BoletoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3874521668322644183L;

	/**
	 * 
	 */
	public BoletoException() {
		
	}

	/**
	 * @param message
	 * @param cause
	 */
	public BoletoException(String message, Throwable cause) {
		super(message, cause);
		
	}

	/**
	 * @param message
	 */
	public BoletoException(String message) {
		super(message);
		
	}

	/**
	 * @param cause
	 */
	public BoletoException(Throwable cause) {
		super(cause);
		
	}

}
