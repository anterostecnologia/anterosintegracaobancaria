package br.com.anteros.integracao.bancaria.banco.layout;

import static java.lang.String.format;

public enum TipoMulta {

	ISENTO("0"), 
	VALOR_FIXO("1"), 
	PERCENTUAL("2");

	private String tipo;

	private TipoMulta(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public static TipoMulta valueOfTipo(String tipo) {
		for (TipoMulta t : values()) {
			if (t.getTipo().equals(tipo)) {
				return t;
			}
		}
		throw new IllegalArgumentException(format("Nenhuma constante enum %s com sigla igual a %s!", TipoMulta.class, tipo));
	}
}
