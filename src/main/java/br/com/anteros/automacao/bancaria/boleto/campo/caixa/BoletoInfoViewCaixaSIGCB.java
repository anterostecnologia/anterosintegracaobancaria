package br.com.anteros.automacao.bancaria.boleto.campo.caixa;


import br.com.anteros.automacao.bancaria.boleto.Boleto;
import br.com.anteros.automacao.bancaria.boleto.ResourceBundle;
import br.com.anteros.automacao.bancaria.boleto.campo.AbstractBoletoInfoCampoView;
import br.com.anteros.core.utils.StringUtils;

/**
 * View para o convênio SIGCB da CAIXA.
 * 
 * @author Rômulo Augusto
 */
public class BoletoInfoViewCaixaSIGCB extends AbstractBoletoInfoCampoView {

	private static final String EMISSAO_BENEFICIARIO = "4";

	BoletoInfoViewCaixaSIGCB(ResourceBundle resourceBundle, Boleto boleto) {
		super(resourceBundle, boleto);
	}
	
	@Override
	public String getTextoFcNossoNumero() {
		return getBoleto().getTitulo().getCarteira().getCodigo() 
				+ EMISSAO_BENEFICIARIO 
				+ super.getTextoFcNossoNumero();
	}
	
	@Override
	public String getTextoFcCarteira() {
		return (getBoleto().getTitulo().getCarteira().isComRegistro()) ? "RG" : "SR";
	}
	
	@Override
	public String getTextoFcLocalPagamento() {
		String textoFcLocalPagamento = super.getTextoFcLocalPagamento();
		return StringUtils.isBlank(textoFcLocalPagamento) ? "PREFERENCIALMENTE NAS CASAS LOTÉRICAS ATÉ O VALOR LIMITE" : textoFcLocalPagamento;
	}
}
