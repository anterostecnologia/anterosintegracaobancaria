package br.com.anteros.automacao.bancaria.boleto.campo.caixa;


import br.com.anteros.automacao.bancaria.boleto.Boleto;
import br.com.anteros.automacao.bancaria.boleto.ResourceBundle;
import br.com.anteros.automacao.bancaria.boleto.campo.AbstractBoletoInfoCampoView;
import br.com.anteros.automacao.bancaria.parametro.ParametroCaixaEconomicaFederal;
import br.com.anteros.core.utils.ObjectUtils;
import br.com.anteros.core.utils.StringUtils;
import br.com.anteros.integracao.bancaria.banco.febraban.Carteira;
import br.com.anteros.integracao.bancaria.banco.febraban.TipoDeCobranca;

/**
 * View para o convênio SICOB, Nosso número com 10 dígitos, da CAIXA.
 * 
 * @author Rômulo Augusto
 */
public class BoletoInfoViewCaixaSICOB10 extends AbstractBoletoInfoCampoView {
	
	public BoletoInfoViewCaixaSICOB10(ResourceBundle resourceBundle, Boleto boleto) {
		super(resourceBundle, boleto);
	}
	
	@Override
	public String getTextoFcCarteira() {
		String textoCarteira = StringUtils.EMPTY;
		Carteira carteira = getBoleto().getTitulo().getCarteira();
		if (ObjectUtils.isNotNull(carteira) && ObjectUtils.isNotNull(carteira.getTipoDeCobranca())) {
			textoCarteira = (carteira.getTipoDeCobranca().equals(TipoDeCobranca.COM_REGISTRO)) ? "CR" : "SR";
		}
		return textoCarteira;
	}
	
	@Override
	public String getTextoFcAgenciaCodigoCedente() {
		Integer agencia = getBoleto().getTitulo().getContaBancaria().getAgencia().getCodigo();
		Integer codigoOperacao = getBoleto().getTitulo().getParametrosBancarios().getValor(ParametroCaixaEconomicaFederal.CODIGO_OPERACAO);
		Integer codigoBeneficiario = getBoleto().getTitulo().getContaBancaria().getNumeroDaConta().getCodigoDaConta();
		String digitoDaConta = getBoleto().getTitulo().getContaBancaria().getNumeroDaConta().getDigitoDaConta();
		
		return String.format("%04d.%03d.%08d-%s", agencia, codigoOperacao, codigoBeneficiario, digitoDaConta);
	}
}
