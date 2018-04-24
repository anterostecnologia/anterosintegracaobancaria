package br.com.anteros.integracao.bancaria.banco.layout;

import static java.lang.String.format;

public enum TipoFormulario {

	AUTO_COPIATIVO("1"), 
	AUTO_ENVELOPÁVEL("3"), 
	A4_SEM_ENVELOPAMENTO("4");

	private String tipo;

	private TipoFormulario(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public static TipoFormulario valueOfTipo(String tipo) {
		for (TipoFormulario t : values()) {
			if (t.getTipo().equals(tipo)) {
				return t;
			}
		}
		throw new IllegalArgumentException(
				format("Nenhuma constante enum %s com sigla igual a %s!", TipoFormulario.class, tipo));
	}
}
