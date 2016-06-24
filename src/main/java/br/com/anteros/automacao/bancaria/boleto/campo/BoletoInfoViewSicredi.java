package br.com.anteros.automacao.bancaria.boleto.campo;


import br.com.anteros.automacao.bancaria.boleto.Boleto;
import br.com.anteros.automacao.bancaria.boleto.ResourceBundle;
import br.com.anteros.automacao.bancaria.parametro.ParametroBancoSicredi;
import br.com.anteros.integracao.bancaria.banco.febraban.Titulo.Aceite;

/**
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 *
 */
public class BoletoInfoViewSicredi extends AbstractBoletoInfoCampoView{

	BoletoInfoViewSicredi(ResourceBundle resourceBundle, Boleto boleto) {
		super(resourceBundle, boleto);
	}

	/**
	 * @see org.jrimum.bopepo.view.info.campo.AbstractBoletoInfoCampoView#getTextoRsCodigoBanco()
	 */
	@Override
	public String getTextoRsCodigoBanco() {
		return getTextoCodigoDoBanco();
	}

	/**
	 * @see org.jrimum.bopepo.view.info.campo.AbstractBoletoInfoCampoView#getTextoFcCodigoBanco()
	 */
	@Override
	public String getTextoFcCodigoBanco() {
		return getTextoCodigoDoBanco();
	}
	
	/**
	 * @see org.jrimum.bopepo.view.info.campo.AbstractBoletoInfoCampoView#getTextoFcLocalPagamento()
	 */
	@Override
	public String getTextoFcLocalPagamento() {
		return "Preferencialmente nas cooperativas de crédito do SICREDI";
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

	/**
	 * @see org.jrimum.bopepo.view.info.campo.AbstractBoletoInfoCampoView#getTextoRsNossoNumero()
	 */
	@Override
	public String getTextoRsNossoNumero() {
		return getTextoNossoNumero();
	}

	/**
	 * @see org.jrimum.bopepo.view.info.campo.AbstractBoletoInfoCampoView#getTextoFcNossoNumero()
	 */
	@Override
	public String getTextoFcNossoNumero() {
		return getTextoNossoNumero(); 
	}
	
	/**
	 * @see org.jrimum.bopepo.view.info.campo.AbstractBoletoInfoCampoView#getTextoFcAceite()
	 */
	@Override
	public String getTextoFcAceite() {
		Aceite aceite = super.getBoleto().getTitulo().getAceite();
		if(aceite == Aceite.A){
			return "SIM";
		}
		return "NÃO";
	}

	private String getAgenciaCodigoCedente(){
		Integer agencia = super.getBoleto().getTitulo().getContaBancaria().getAgencia().getCodigo();
		Integer posto = super.getBoleto().getTitulo().getParametrosBancarios().getValor(ParametroBancoSicredi.POSTO_DA_AGENCIA);
		Integer codigoCedente = super.getBoleto().getTitulo().getContaBancaria().getNumeroDaConta().getCodigoDaConta();
		
		return String.format("%04d.%02d.%05d", agencia, posto, codigoCedente);
	}
	
	private String getTextoNossoNumero() {
		String nn = super.getTextoFcNossoNumero();
		return nn.substring(0,2)+"/"+nn.substring(2);
	}
	
	private String getTextoCodigoDoBanco(){
		return super.getTextoFcCodigoBanco().replace("-0", "-X");
	}

}
