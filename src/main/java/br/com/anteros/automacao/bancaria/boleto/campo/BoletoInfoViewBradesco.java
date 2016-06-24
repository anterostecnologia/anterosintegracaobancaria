package br.com.anteros.automacao.bancaria.boleto.campo;


import br.com.anteros.automacao.bancaria.boleto.Boleto;
import br.com.anteros.automacao.bancaria.boleto.ResourceBundle;
import br.com.anteros.core.utils.StringUtils;
import br.com.anteros.integracao.bancaria.banco.febraban.Agencia;
import br.com.anteros.integracao.bancaria.banco.febraban.Carteira;
import br.com.anteros.integracao.bancaria.banco.febraban.NumeroDaConta;

/**
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 */
public class BoletoInfoViewBradesco extends AbstractBoletoInfoCampoView{

	BoletoInfoViewBradesco(ResourceBundle resourceBundle, Boleto boleto) {
		super(resourceBundle, boleto);
	}

	@Override
	public String getTextoFcLocalPagamento() {
		String textoFcLocalPagamento = super.getTextoFcLocalPagamento();
		return StringUtils.isBlank(textoFcLocalPagamento) ? "Pagável Preferencialmente na rede Bradesco ou no Bradesco expresso" : textoFcLocalPagamento;
	}
	
	@Override
	public String getTextoFcAgenciaCodigoCedente() {
		Agencia agencia = getBoleto().getTitulo().getContaBancaria().getAgencia();
		NumeroDaConta numeroDaConta = getBoleto().getTitulo().getContaBancaria().getNumeroDaConta();
		
		return StringUtils.leftPad(agencia.getCodigo().toString(), 4, "0")
				+ "-" + agencia.getDigitoVerificador()
				+ " / "
				+ StringUtils.leftPad(numeroDaConta.getCodigoDaConta().toString(), 7, "0")
				+ "-" + numeroDaConta.getDigitoDaConta();
	}
	
	@Override
	public String getTextoRsAgenciaCodigoCedente() {
		return getTextoFcAgenciaCodigoCedente();
	}
	
	@Override
	public String getTextoFcNossoNumero() {
		Carteira carteira = getBoleto().getTitulo().getCarteira();
		return StringUtils.leftPad(carteira.getCodigo().toString(), 2, "0") 
				+ "/" 
				+ getBoleto().getTitulo().getNossoNumero() 
				+ "-" + getBoleto().getTitulo().getDigitoDoNossoNumero();
	}
	
	@Override
	public String getTextoRsNossoNumero() {
		return getTextoFcNossoNumero();
	}
}
