package br.com.anteros.automacao.bancaria.boleto.campo;

import br.com.anteros.core.utils.StringUtils;
import br.com.anteros.integracao.bancaria.banco.febraban.Titulo;

/**
 * Formata o Nosso Número do Título que é impresso no boleto.
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 */
public class BoletoInfoCampoNossoNumero {

	/**
	 * Retorna o nosso número fomatado no estilo "123456-7".
	 * 
	 * 
	 * @param titulo
	 * @return string formatada para ser exibida no boleto
	 */
	public static String getTextoNossoNumero(Titulo titulo) {

		StringBuilder texto = new StringBuilder(StringUtils.EMPTY);

		if (StringUtils.isNotBlank(titulo.getNossoNumero())) {
			texto.append(titulo.getNossoNumero());

			if (StringUtils.isNotBlank(titulo.getDigitoDoNossoNumero())) {
				texto.append("-" + titulo.getDigitoDoNossoNumero());
			}
		}

		return texto.toString();
	}
}
