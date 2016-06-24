package br.com.anteros.automacao.bancaria.boleto.campo;


import java.awt.Image;

import br.com.anteros.automacao.bancaria.boleto.BancosSuportados;
import br.com.anteros.automacao.bancaria.boleto.ResourceBundle;
import br.com.anteros.core.utils.ObjectUtils;
import br.com.anteros.integracao.bancaria.banco.febraban.ContaBancaria;

/**
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 *
 */
public class BoletoInfoCampoLogoBanco {
	
	public static Image getImagemBanco(ResourceBundle resourceBundle, ContaBancaria conta){
			
		if (ObjectUtils.isNotNull(conta.getBanco().getImgLogo())) {
			return conta.getBanco().getImgLogo();
		} 
		
		if (BancosSuportados.isSuportado(conta.getBanco().getCodigoDeCompensacaoBACEN().getCodigoFormatado())) {
				
			conta.getBanco().setImgLogo(
					resourceBundle
							.getLogotipoDoBanco(conta.getBanco()
									.getCodigoDeCompensacaoBACEN()
									.getCodigoFormatado()));
		} 
		
		return conta.getBanco().getImgLogo();		
	}

}
