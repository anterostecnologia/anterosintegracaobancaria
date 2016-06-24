package br.com.anteros.automacao.bancaria.boleto.campo;



import br.com.anteros.automacao.bancaria.boleto.Boleto;
import br.com.anteros.automacao.bancaria.boleto.ResourceBundle;
import br.com.anteros.core.utils.StringUtils;

/**
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 */
public class BoletoInfoViewCecred extends AbstractBoletoInfoCampoView {

	BoletoInfoViewCecred(ResourceBundle resourceBundle, Boleto boleto) {
		super(resourceBundle, boleto);
	}
	
	@Override
	public String getTextoFcLocalPagamento() {
		String textoFcLocalPagamento = super.getTextoFcLocalPagamento();
		return StringUtils.isBlank(textoFcLocalPagamento) ? "PAGAVEL PREFERENCIALMENTE NAS COOPERATIVAS DO SISTEMA CECRED." : textoFcLocalPagamento;
	}
	
	/**
	 * @see org.jrimum.bopepo.view.info.campo.AbstractBoletoInfoCampoView#getTextoRsAgenciaCodigoCedente()
	 */
	@Override
	public String getTextoRsAgenciaCodigoCedente() {
		return getAgenciaCodigoCedente();
	}

	/**
	 * @see org.jrimum.bopepo.view.info.campo.AbstractBoletoInfoCampoView#getTextoFcAgenciaCodigoCedente()
	 */
	@Override
	public String getTextoFcAgenciaCodigoCedente() {
		return getAgenciaCodigoCedente();
	}

	private String getAgenciaCodigoCedente(){
		Integer agencia = super.getBoleto().getTitulo().getContaBancaria().getAgencia().getCodigo();
		String agDv = super.getBoleto().getTitulo().getContaBancaria().getAgencia().getDigitoVerificador();
		Integer numeroDaConta = super.getBoleto().getTitulo().getContaBancaria().getNumeroDaConta().getCodigoDaConta();
		String contaDv = super.getBoleto().getTitulo().getContaBancaria().getNumeroDaConta().getDigitoDaConta();
		
		return String.format("%04d-%s / %07d-%s", agencia, agDv, numeroDaConta, contaDv);
	}

}
