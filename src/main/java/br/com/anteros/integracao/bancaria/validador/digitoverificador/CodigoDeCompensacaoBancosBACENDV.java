package br.com.anteros.integracao.bancaria.validador.digitoverificador;

import br.com.anteros.core.utils.StringUtils;

/**
 * <p>
 * Cálculo para o dígito verificador do código de compensação dos bancos
 * supervisionados pelo <a href="http://www.bcb.gov.br/?CHEQUESCOMPE">BACEN</a>
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
public class CodigoDeCompensacaoBancosBACENDV extends AbstractDigitoVerificador {

	/**
	 * Valor mínimo do código de compensação
	 */
	public static final int LIMITE_MINIMO = 1;
	
	/**
	 * Valor máximo do código de compensação
	 */
	public static final int LIMITE_MAXIMO = 999; 

	/**
	 * <p>
	 * Mesagem padrão para erro.
	 * </p>
	 */
	private static final String MSG = "O código de compensação do banco deve ser um número entre 1 e 999.";

	/**
	 * <p>
	 * Calcula o dígito verificador para código de compensação passado.
	 * </p>
	 * 
	 * @see org.jrimum.vallia.digitoverificador.AbstractDigitoVerificador#calcule(java.lang.String)
	 * 
	 * @param numero - Código de compensação
	 * @return Dígito verificador que foi calculado
	 * 
	 * @throws IllegalArgumentException Caso não seja um código válido
	 * 
	 * @since 0.2
	 */
	@Override
	public int calcule(String numero) {
		
		if (!isCodigoValido(numero)) {
			throw new IllegalArgumentException(MSG);
		}
		
		return calcule(Integer.valueOf(numero.trim()));
	}

	/**
	 * <p>
	 * Calcula o dígito verificador para o código de compensação passado.
	 * </p>
	 * 
	 * @param numero - Código de compensação
	 * 
	 * @return Dígito verificador que foi calculado
	 * 
	 * @since 0.2
	 */
	public int calcule(int numero) {

		return calcule((long) numero);
	}

	/**
	 * <p>
	 * Calcula o dígito verificador para o código de compensação passado.
	 * </p>
	 * 
	 * @param numero - Código de compensação
	 * 
	 * @return Dígito verificador que foi calculado
	 * 
	 * @since 0.2
	 * 
	 * @see org.jrimum.vallia.digitoverificador.AbstractDigitoVerificador#calcule(long)
	 */
	@Override
	public int calcule(long numero) {

		int dv = -1;

		if (!isCodigoValido(numero)) {
			throw new IllegalArgumentException(MSG);
		}

		int soma = Modulo.calculeSomaSequencialMod11(
				String.valueOf(numero), 2, 9);

		soma *= 10;

		dv = soma % 11;

		dv = (dv == 10) ? 0 : dv;

		return dv;
	}

	/**
	 * <p>
	 * Retorna se um código de compensação passado é válido, ou seja, se está entre os 
	 * valores inteiros de 1 a 999.
	 * </p>
	 * 
	 * @param codigo - Código de compensação
	 * @return true se for númerio entre 1 e 999; false caso contrário
	 * 
	 * @since 0.2
	 */
	public boolean isCodigoValido(String codigo) {

		boolean codigoValido = false;
		
		if (StringUtils.isNotBlank(codigo) && StringUtils.isNumber(codigo)) {
			codigoValido = isCodigoValido(Integer.valueOf(codigo.trim()));
		}
		
		return codigoValido;
	}

	/**
	 * <p>
	 * Retorna se um código de compensação passado é válido.
	 * </p>
	 * 
	 * @param codigo - Código de compensação
	 * @return true se entre 0 (não incluso) e 999; false caso contrário
	 * 
	 * @since 0.2
	 */
	public boolean isCodigoValido(int codigo) {
		
		return isCodigoValido((long) codigo);
	}
	
	/**
	 * <p>
	 * Retorna se um código de compensação passado é válido.
	 * </p>
	 * 
	 * @param codigo - Código de compensação
	 * @return true se entre 0 (não incluso) e 999; false caso contrário
	 * 
	 * @since 0.2
	 */
	public boolean isCodigoValido(long codigo) {
		
		return (codigo >= LIMITE_MINIMO) && (codigo <= LIMITE_MAXIMO);
	}
}