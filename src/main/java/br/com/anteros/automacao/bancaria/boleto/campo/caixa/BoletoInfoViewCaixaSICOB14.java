package br.com.anteros.automacao.bancaria.boleto.campo.caixa;

import br.com.anteros.automacao.bancaria.boleto.Boleto;
import br.com.anteros.automacao.bancaria.boleto.ResourceBundle;
import br.com.anteros.automacao.bancaria.boleto.campo.AbstractBoletoInfoCampoView;
import br.com.anteros.automacao.bancaria.parametro.ParametroCaixaEconomicaFederal;
import br.com.anteros.core.utils.ObjectUtils;
import br.com.anteros.core.utils.StringUtils;
import br.com.anteros.integracao.bancaria.banco.febraban.Titulo;

/**
 * View para o convênio SICOB, Nosso número com 14 dígitos, da CAIXA.
 * 
 * @author Rômulo Augusto
 */
public class BoletoInfoViewCaixaSICOB14 extends AbstractBoletoInfoCampoView {

	private static final int CODIGO_OPERACAO_PADRAO = 870;

	public BoletoInfoViewCaixaSICOB14(ResourceBundle resourceBundle, Boleto boleto) {
		super(resourceBundle, boleto);
	}
	
	@Override
	public String getTextoFcCarteira() {
		return "SR";
	}
	
	@Override
	public String getTextoFcAgenciaCodigoCedente() {
		Integer agencia = getBoleto().getTitulo().getContaBancaria().getAgencia().getCodigo();
		Integer codigoOperacao = getCodigoOperacao();
		Integer codigoBeneficiario = getBoleto().getTitulo().getContaBancaria().getNumeroDaConta().getCodigoDaConta();
		String digitoDaConta = getBoleto().getTitulo().getContaBancaria().getNumeroDaConta().getDigitoDaConta();
		
		return String.format("%04d.%03d.%08d-%s", agencia, codigoOperacao, codigoBeneficiario, digitoDaConta);
	}

	private Integer getCodigoOperacao() {
		Titulo titulo = getBoleto().getTitulo();
		Integer codigoOperacao = CODIGO_OPERACAO_PADRAO;
		
		if (titulo.hasParametrosBancarios() && ObjectUtils.isNotNull(titulo.getParametrosBancarios().getValor(ParametroCaixaEconomicaFederal.CODIGO_OPERACAO))) {
			codigoOperacao = titulo.getParametrosBancarios().getValor(ParametroCaixaEconomicaFederal.CODIGO_OPERACAO);
		}
		
		return codigoOperacao;
	}
	
	@Override
	public String getTextoFcLocalPagamento() {
		String textoFcLocalPagamento = super.getTextoFcLocalPagamento();
		return StringUtils.isBlank(textoFcLocalPagamento) ? "PREFERENCIALMENTE NAS CASAS LOTÉRICAS ATÉ O VALOR LIMITE" : textoFcLocalPagamento;
	}
}
