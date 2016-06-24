package br.com.anteros.integracao.bancaria.validador.digitoverificador;

import java.io.Serializable;

/**
 * Enumeração das implementações dos módulos.
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public enum TipoDeModulo implements Serializable {

	/**
	 * Módulo do tipo 11.
	 * 
	 * @since 0.2
	 */
	MODULO10 {
		/**
		 * @see org.jrimum.vallia.digitoverificador.TipoDeModulo#valor()
		 * @since 0.2
		 */
		public int valor() {
			return 10;
		}
	},

	/**
	 * Módulo do tipo 11.
	 * 
	 * @since 0.2
	 */
	MODULO11 {
		/**
		 * @see org.jrimum.vallia.digitoverificador.TipoDeModulo#valor()
		 * @since 0.2
		 */
		public int valor() {
			return 11;
		}
	};

	/**
	 * Retorna o valor do módulo.
	 * 
	 * @return 10 ou 11
	 * 
	 * @since 0.2
	 */
	public abstract int valor();
}