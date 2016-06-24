package br.com.anteros.integracao.bancaria.banco.febraban.cnab;

public class CNABException extends RuntimeException {

	public CNABException() {
		super();
	}

	public CNABException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CNABException(String message, Throwable cause) {
		super(message, cause);
	}

	public CNABException(String message) {
		super(message);
	}

	public CNABException(Throwable cause) {
		super(cause);
	}

}
