package br.com.anteros.automacao.bancaria.boleto.campo.hsbc;



import br.com.anteros.automacao.bancaria.boleto.Boleto;
import br.com.anteros.automacao.bancaria.boleto.ResourceBundle;
import br.com.anteros.automacao.bancaria.boleto.campo.AbstractBoletoInfoCampoView;
import br.com.anteros.automacao.bancaria.boleto.campo.BoletoInfoCampoView;
import br.com.anteros.core.utils.StringUtils;

/**
 * Define campos iguais para as cobranças registrada e não registrada.
 * @author Rômulo Augusto
 */
public class AbstractBoletoInfoViewHSBC extends AbstractBoletoInfoCampoView {
	
	public static BoletoInfoCampoView create(ResourceBundle resourceBundle, Boleto boleto) {
		if (boleto.getTitulo().getCarteira().isComRegistro()) {
			return new BoletoInfoViewHSBCRegistrada(resourceBundle, boleto);
		}
		return new BoletoInfoViewHSBCNaoRegistrada(resourceBundle, boleto);
	}

	public AbstractBoletoInfoViewHSBC(ResourceBundle resourceBundle, Boleto boleto) {
		super(resourceBundle, boleto);
	}
	
	@Override
	public String getTextoFcLocalPagamento() {
		String textoFcLocalPagamento = super.getTextoFcLocalPagamento();
		return StringUtils.isBlank(textoFcLocalPagamento) ? "PAGAR PREFERENCIALMENTE EM AGÊNCIA DO HSBC" : textoFcLocalPagamento;
	}
	
	@Override
	public String getTextoFcAgenciaCodigoCedente() {
		return StringUtils.leftPad(getBoleto().getTitulo().getContaBancaria().getNumeroDaConta().getCodigoDaConta().toString(), 7, "0");
	}
	
	@Override
	public String getTextoFcNossoNumero() {
		return getBoleto().getTitulo().getNossoNumero() + getBoleto().getTitulo().getDigitoDoNossoNumero();
	}
	
	@Override
	public String getTextoRsNossoNumero() {
		return getTextoFcNossoNumero();
	}
}
