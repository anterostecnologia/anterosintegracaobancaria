package br.com.anteros.automacao.bancaria.boleto.campo.hsbc;



import br.com.anteros.automacao.bancaria.boleto.Boleto;
import br.com.anteros.automacao.bancaria.boleto.ResourceBundle;
import br.com.anteros.core.utils.StringUtils;

/**
 * View para a cobrança registrada do HSBC.
 * 
 * @author Rômulo Augusto
 */
public class BoletoInfoViewHSBCRegistrada extends AbstractBoletoInfoViewHSBC {

	public BoletoInfoViewHSBCRegistrada(ResourceBundle resourceBundle, Boleto boleto) {
		super(resourceBundle, boleto);
	}
	
	@Override
	public String getTextoFcAgenciaCodigoCedente() {
		String agencia = StringUtils.leftPad(getBoleto().getTitulo().getContaBancaria().getAgencia().getCodigo().toString(), 4, "0");
		String conta = StringUtils.leftPad(getBoleto().getTitulo().getContaBancaria().getNumeroDaConta().getCodigoDaConta().toString(), 7, "0");
		return agencia + conta;
	}
	
	@Override
	public String getTextoRsAgenciaCodigoCedente() {
		return getTextoFcAgenciaCodigoCedente();
	}
	
	@Override
	public String getTextoFcEspecieDocumento() {
		return "PD";
	}
	
	@Override
	public String getTextoFcAceite() {
		return "NÃO";
	}
	
	@Override
	public String getTextoFcCarteira() {
		return "CSB";
	}
}
