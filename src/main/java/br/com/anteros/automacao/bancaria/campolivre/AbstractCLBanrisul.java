package br.com.anteros.automacao.bancaria.campolivre;

import br.com.anteros.core.utils.StringUtils;
import br.com.anteros.flatfile.type.component.FixedField;
import br.com.anteros.integracao.bancaria.banco.febraban.Titulo;
import br.com.anteros.integracao.bancaria.validador.digitoverificador.Modulo;

/**
 *<p>
 * Interface comum para todos os campos livres do Banco Banrisul que venham a
 * existir.
 * </p>
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 * @author <a href="mailto:misaelbarreto@gmail.com">Misael Barreto</a>
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * @author <a href="mailto:samuelvalerio@gmail.com">Samuel Valério</a> Valerio
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
abstract class AbstractCLBanrisul extends AbstractCampoLivre {
	
	/**
	 *
	 */
	private static final long serialVersionUID = -259398499475894938L;

	/**
	 * <p>Cria um campo livre com um determinado número de campos</p>
	 * 
	 * @see AbstractCampoLivre
	 * 
	 * @param fieldsLength - Número de campos
	 */
	protected AbstractCLBanrisul(Integer fieldsLength) {
		
		super(fieldsLength);
	}

	protected static CampoLivre create(Titulo titulo) throws NotSupportedCampoLivreException {
		
		checkCarteiraNotNull(titulo);
		checkRegistroDaCarteiraNotNull(titulo);
		
		switch (titulo.getCarteira().getTipoDeCobranca()) {

			case COM_REGISTRO:
				return new CLBanrisulCobrancaRegistrada(titulo);
			case SEM_REGISTRO:
				return new CLBanrisulCobrancaNaoRegistrada(titulo);
			default:
				throw new NotSupportedCampoLivreException("Campo livre diponível apenas para carteiras com ou sem cobrança.");
		}
	}

	/**
	 * <p>
	 * Calcula o duplo dígito referente às posições 20 a 42 (módulos 10 e 11).
	 * </p>
	 * 
	 * 
	 * @param seisPrimeirosCamposConcatenados
	 * @return duplo dígito
	 * 
	 * @since 0.2
	 */
	protected String calculaDuploDigito(String seisPrimeirosCamposConcatenados) {
		// calcula soma do módulo 10 a partir dos seis primeiros campos concatenados
		final int somaMod10 = Modulo.calculeSomaSequencialMod10(seisPrimeirosCamposConcatenados, 1, 2);
		
		// calcula resto do módulo 10 a partir do resultado da soma
		final byte restoMod10 = calculeRestoMod10(somaMod10);
		
		// calcula primeiro DV a partir do resto módulo 10
		byte primeiroDV = calculePrimeiroDV(restoMod10);

		
		// calcula soma do módulo 10 a partir dos seis primeiros campos concatenados
		// incluindo o primeiro dígito
		int somaMod11 = Modulo.calculeSomaSequencialMod11(seisPrimeirosCamposConcatenados + primeiroDV, 2, 7);
		
		// calcula o resto do módulo 11 a partir do resultado da soma
		byte restoMod11 = calculeRestoMod11(somaMod11);
		
		// se o resto do módulo 11 for 1 então o primeiro dígito é inválido
		// deve ser feito o recálculo até que o resto não seja 1
		while (restoMod11 == 1) {
			
			// encontra um valor válido para o primeiro DV
			primeiroDV = encontreValorValidoParaPrimeiroDV(primeiroDV);
			
			// calcula a soma do módulo 11 agora com um valor
			// válido para o DV
			somaMod11 = Modulo.calculeSomaSequencialMod11(seisPrimeirosCamposConcatenados + primeiroDV, 2, 7);
			
			// calcula o resto do módulo 11 a partir do resultado da soma
			restoMod11 = calculeRestoMod11(somaMod11);
		}

		// calcula o segundo DV a partir do resto módulo 11
		final byte segundoDV = calculeSegundoDV(restoMod11);

		// concatena o primeiro DV com o segundo DV para
		// formar o duplo dígito
		return String.valueOf(primeiroDV) + String.valueOf(segundoDV);
	}

	/**
	 * <p>
	 * Calcula o segundo dígito verificador.
	 * </p>
	 * 
	 * @param restoMod11
	 * @return segundo dígito
	 * 
	 * @since 0.2
	 */
	private byte calculeSegundoDV(byte restoMod11) {
		final byte segundoDV;
		if (restoMod11 == 0)
			segundoDV = restoMod11;
		else
			segundoDV = (byte) (11 - restoMod11);
		return segundoDV;
	}

	/**
	 * <p>
	 * Calcula o primeiro dígito verificador.
	 * </p>
	 * 
	 * @param restoMod10
	 * @return primeiro dígito verificador
	 * 
	 * @since 0.2
	 */
	private byte calculePrimeiroDV(byte restoMod10) {
		final byte primeiroDV;
		if (restoMod10 == 0)
			primeiroDV = 0;
		else
			primeiroDV = (byte) (10 - restoMod10);
		return primeiroDV;
	}

	/**
	 * <p>
	 * Calcula o resto da soma módulo 10.
	 * </p>
	 * 
	 * @param somaMod10
	 * @return Resto do modúlo 10
	 * 
	 * @since 0.2
	 */
	private byte calculeRestoMod10(int somaMod10) {
		final byte restoMod10;
		if (somaMod10 < 10)
			restoMod10 = (byte) somaMod10;
		else
			restoMod10 = (byte) (somaMod10 % 10);
		return restoMod10;
	}

	/**
	 * <p>
	 * Encontra um valor válido para o primeiro dígito.
	 * </p>
	 * 
	 * @param primeiroDV
	 * @return valor válido para o primeiro dígito
	 * 
	 * @since 0.2
	 */
	private byte encontreValorValidoParaPrimeiroDV(byte primeiroDV) {
		final byte novoValorDoPrimeiroDV;
		if (primeiroDV == 9)
			novoValorDoPrimeiroDV = 0;
		else
			novoValorDoPrimeiroDV = (byte) (primeiroDV + 1);
		return novoValorDoPrimeiroDV;
	}

	/**
	 * <p>
	 * Calcula o resto do módulo 11.
	 * </p>
	 * 
	 * @param somaMod11
	 * @return restro do módulo 11
	 * 
	 * @since 0.2
	 */
	private byte calculeRestoMod11(int somaMod11) {
		final byte restoMod11;
		if (somaMod11 < 11)
			restoMod11 = (byte) somaMod11;
		else
			restoMod11 = (byte) (somaMod11 % 11);
		return restoMod11;
	}

	protected String concateneOsCamposExistentesAteOMomento() {
		
		final StringBuilder camposExistentesAteOMomentoConcatenados = new StringBuilder(StringUtils.EMPTY);
		
		for (FixedField<?> field : this) {
			camposExistentesAteOMomentoConcatenados.append(field.write());
		}
		
		return camposExistentesAteOMomentoConcatenados.toString();
	}

}
