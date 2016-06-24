package br.com.anteros.automacao.bancaria.boleto.campo.hsbc;



import br.com.anteros.automacao.bancaria.boleto.Boleto;
import br.com.anteros.automacao.bancaria.boleto.ResourceBundle;
import br.com.anteros.core.utils.StringUtils;

/**
 * View para a cobrança não registrada do HSBC.
 * 
 * @author Rômulo Augusto
 */
public class BoletoInfoViewHSBCNaoRegistrada extends AbstractBoletoInfoViewHSBC{

	public BoletoInfoViewHSBCNaoRegistrada(ResourceBundle resourceBundle, Boleto boleto) {
		super(resourceBundle, boleto);
	}
	
	@Override
	public String getTextoFcAgenciaCodigoCedente() {
		return StringUtils.leftPad(getBoleto().getTitulo().getContaBancaria().getNumeroDaConta().getCodigoDaConta().toString(), 7, "0");
	}
	
	@Override
	public String getTextoRsAgenciaCodigoCedente() {
		return getTextoFcAgenciaCodigoCedente();
	}
	
	@Override
	public String getTextoFcEspecieDocumento() {
		return StringUtils.EMPTY;
	}
	
	@Override
	public String getTextoFcAceite() {
		return StringUtils.EMPTY;
	}

	@Override
	public String getTextoFcCarteira() {
		return "CNR";
	}
}
