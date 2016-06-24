package br.com.anteros.automacao.bancaria.boleto.campo;

import br.com.anteros.automacao.bancaria.comum.pessoa.endereco.Endereco;
import br.com.anteros.core.utils.ObjectUtils;
import br.com.anteros.core.utils.StringUtils;
import br.com.anteros.integracao.bancaria.banco.febraban.EntidadeDeCobranca;

/**
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 */
public class BoletoInfoCampoEndereco {
	
	public static String getTextoEnderecoLinha1(EntidadeDeCobranca pessoa){
		if (ObjectUtils.isNotNull(pessoa)) {
			return getTextoEnderecoLinha1(pessoa.getNextEndereco());
		}
		return StringUtils.EMPTY;
	}
	
	public static String getTextoEnderecoLinha1(Endereco endereco){
		
		final StringBuilder texto = new StringBuilder(StringUtils.EMPTY);
		
		if (ObjectUtils.isNotNull(endereco)) {
			
			boolean temBairro = false;
			boolean temLocalidade = false;
			
			if (StringUtils.isNotBlank(endereco.getBairro())) {
				temBairro = true;
				texto.append(endereco.getBairro());
			}
			
			if (StringUtils.isNotBlank(endereco.getLocalidade())) {
				temLocalidade = true;
				if(temBairro){
					texto.append(" - ");
				}
				texto.append(endereco.getLocalidade());
			}
			
			if (ObjectUtils.isNotNull(endereco.getUF())) {
				if(temBairro || temLocalidade){
					texto.append(" / ");
				}
				texto.append(endereco.getUF().getSigla());
			}
		}
		
		return texto.toString();
	}
	
	public static String getTextoEnderecoLinha2(EntidadeDeCobranca pessoa){
		if (ObjectUtils.isNotNull(pessoa)) {
			return getTextoEnderecoLinha2(pessoa.getNextEndereco());
		}
		return StringUtils.EMPTY;
	}

	public static String getTextoEnderecoLinha2(Endereco endereco){

		final StringBuilder texto = new StringBuilder(StringUtils.EMPTY);
		
		if (ObjectUtils.isNotNull(endereco)) {
			
			if (StringUtils.isNotBlank(endereco.getLogradouro())) {
				texto.append(endereco.getLogradouro());
			}

			if (StringUtils.isNotBlank(endereco.getNumero())) {
				texto.append(", n°: ")
				.append(endereco.getNumero());
			}
			
			if (StringUtils.isNotBlank(endereco.getComplemento())) {
				texto.append(" / ")
				.append(endereco.getComplemento());
			}

			if (ObjectUtils.isNotNull(endereco.getCEP()) && StringUtils.isNotBlank(endereco.getCEP().getCep())) {
				texto.append(" - ")
				.append("CEP: ")
				.append(endereco.getCEP().getCep());
			}

		}
		
		return texto.toString();
	}

}
