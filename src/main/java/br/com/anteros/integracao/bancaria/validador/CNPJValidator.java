package br.com.anteros.integracao.bancaria.validador;

/**
 * Validador especialista para CNPJ.
 * 
 * <p>
 * O cadastro de pessoa jurídica tem as seguintes características:
 * <ul>
 * <li>Contém apenas números.</li>
 * <li>Possui tamanho 14 sem formatação e 18 com formatação.</li>
 * <li>Pode estar no formato ##.###.###/####-XX, onde XX é o dígito verificador.
 * </li>
 * </ul>
 * </p>
 * <p>
 * A validação consiste em verificar essas características e se o dígito
 * verificador é válido.
 * </p>
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * @author <a href="mailto:misaelbarreto@gmail.com">Misael Barreto</a>
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * @author <a href="http://www.nordestefomento.com.br">Nordeste Fomento
 *         Mercantil</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
class CNPJValidator extends AbstractCPRFValidator {

	/**
	 * @see org.jrimum.vallia.AbstractCPRFValidator#isValido()
	 * @since 0.2
	 */
	@Override
	public boolean isValido() {

		boolean isValido = false;
		int dv = 0;
		int dvCalculado = -1;

		dv = Integer.parseInt(getCodigoDoCadastro().substring(12, 14));

		dvCalculado = digitoVerificador.calcule(getCodigoDoCadastro()
				.substring(0, 12));

		isValido = (dv == dvCalculado);

		return isValido;
	}

	/**
	 * @see org.jrimum.vallia.AbstractCPRFValidator#removeFormatacao()
	 * @since 0.2
	 */
	@Override
	protected void removeFormatacao() {

		String codigo = codigoDoCadastro.toString();

		codigo = codigo.replace(".", "");
		codigo = codigo.replace("/", "");
		codigo = codigo.replace("-", "");

		codigoDoCadastro.delete(0, codigoDoCadastro.length());

		codigoDoCadastro.append(codigo);
	}

}
