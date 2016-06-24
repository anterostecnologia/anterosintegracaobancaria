package br.com.anteros.automacao.bancaria.boleto;

import java.awt.Image;
import java.util.Map;

/**
 * Contém todos os campos de imagem e texto usados para preencher o boleto.
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public interface BoletoInfoView {

	public Map<String, String> texts();

	public Map<String, Image> images();
}
