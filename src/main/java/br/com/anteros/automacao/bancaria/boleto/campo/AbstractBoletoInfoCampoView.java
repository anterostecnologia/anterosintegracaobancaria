package br.com.anteros.automacao.bancaria.boleto.campo;

import static br.com.anteros.automacao.bancaria.boleto.campo.BoletoInfoCampoAgenciaCodigoCedente.getTextoAgenciaCodigoCedente;
import static br.com.anteros.automacao.bancaria.boleto.campo.BoletoInfoCampoCodigoBanco.getTextoCodigoDoBanco;
import static br.com.anteros.automacao.bancaria.boleto.campo.BoletoInfoCampoEndereco.getTextoEnderecoLinha1;
import static br.com.anteros.automacao.bancaria.boleto.campo.BoletoInfoCampoEndereco.getTextoEnderecoLinha2;
import static br.com.anteros.automacao.bancaria.boleto.campo.BoletoInfoCampoLogoBanco.getImagemBanco;
import static br.com.anteros.automacao.bancaria.boleto.campo.BoletoInfoCampoNossoNumero.getTextoNossoNumero;
import static br.com.anteros.automacao.bancaria.boleto.campo.BoletoInfoCampoPessoa.getTextoNomeCprfDaPessoa;

import java.awt.Color;
import java.awt.Image;
import java.math.BigDecimal;
import java.util.Date;

import com.lowagie.text.pdf.BarcodeInter25;

import br.com.anteros.automacao.bancaria.boleto.Boleto;
import br.com.anteros.automacao.bancaria.boleto.ResourceBundle;
import br.com.anteros.core.utils.Assert;
import br.com.anteros.core.utils.DateFormat;
import br.com.anteros.core.utils.DecimalFormat;
import br.com.anteros.core.utils.ObjectUtils;
import br.com.anteros.core.utils.StringUtils;

/**
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 *
 */
public abstract class AbstractBoletoInfoCampoView implements BoletoInfoCampoView{
	
	private final ResourceBundle resourceBundle;
	
	private final Boleto boleto;
	
	/**
	 * Modo de instanciação não permitido.
	 * 
	 * @throws IllegalStateException
	 *             Caso haja alguma tentativa de utilização deste construtor.
	 */
	@SuppressWarnings("unused")
	private AbstractBoletoInfoCampoView(){
		resourceBundle = null;
		boleto = null;
		throw  new IllegalStateException("Instanciação não permitida!");		
	}
	
	public AbstractBoletoInfoCampoView(ResourceBundle resourceBundle, Boleto boleto){
		Assert.notNull(resourceBundle);
		Assert.notNull(boleto);
		this.resourceBundle = resourceBundle;
		this.boleto = boleto;
	}

	public String getTextoRsInstrucaoAoSacado() {
		return getValue(boleto.getInstrucaoAoSacado());
	}

	public String getTextoRsCpfCnpj() {
		return boleto.getTitulo().getCedente().getCPRF().getCodigoFormatado();
	}
	
	public String getTextoRsSacado(){
		return getTextoFcSacadoL1();
	}
	
	public String getTextoFcSacadoL1(){
		return getTextoNomeCprfDaPessoa(boleto.getTitulo().getSacado());
	}
	
	public String getTextoFcSacadoL2(){
		return getTextoEnderecoLinha1(boleto.getTitulo().getSacado());
	}
	
	public String getTextoFcSacadoL3(){
		return getTextoEnderecoLinha2(boleto.getTitulo().getSacado());
	}
	
	public String getTextoFcSacadorAvalistaL1(){
		return getTextoNomeCprfDaPessoa(boleto.getTitulo().getSacadorAvalista());
	}
	
	public String getTextoFcSacadorAvalistaL2(){
		return getTextoEnderecoLinha1(boleto.getTitulo().getSacadorAvalista());
	}
	
	public String getTextoFcSacadorAvalistaL3(){
		return getTextoEnderecoLinha2(boleto.getTitulo().getSacadorAvalista());
	}
	
	public String getTextoFcDataProcessamento(){
		return getValue(boleto.getDataDeProcessamento());
	}

	public String getTextoFcAceite(){
		return getValue(boleto.getTitulo().getAceite());
	}

	public String getTextoFcEspecieDocumento() {
		return ObjectUtils.whenNull(boleto.getTitulo().getTipoDeDocumento(), StringUtils.EMPTY, boleto.getTitulo().getTipoDeDocumento().getSigla());
	}

	public String getTextoFcDataDocumento(){
		return getValue(boleto.getTitulo().getDataDoDocumento());
	}

	public String getTextoFcLocalPagamento(){
		return getValue(boleto.getLocalPagamento());
	}
	
	public String getTextoFcCarteira(){
		return ObjectUtils.whenNull(boleto.getTitulo().getCarteira(), StringUtils.EMPTY, boleto.getTitulo().getCarteira().getCodigo().toString());
	}
	
	public String getTextoFcInstrucaoAoCaixa1(){
		return getValue(boleto.getInstrucao1());
	}
	
	public String getTextoFcInstrucaoAoCaixa2(){
		return getValue(boleto.getInstrucao2());
	}
	
	public String getTextoFcInstrucaoAoCaixa3(){
		return getValue(boleto.getInstrucao3());
	}
	
	public String getTextoFcInstrucaoAoCaixa4(){
		return getValue(boleto.getInstrucao4());
	}
	
	public String getTextoFcInstrucaoAoCaixa5(){
		return getValue(boleto.getInstrucao5());
	}
	
	public String getTextoFcInstrucaoAoCaixa6(){
		return getValue(boleto.getInstrucao6());
	}
	
	public String getTextoFcInstrucaoAoCaixa7(){
		return getValue(boleto.getInstrucao7());
	}
	
	public String getTextoFcInstrucaoAoCaixa8(){
		return getValue(boleto.getInstrucao8());
	}

	public String getTextoRsMoraMulta(){
		return getTextoFcMoraMulta();
	}

	public String getTextoFcMoraMulta(){
		return getValue(boleto.getTitulo().getValorJurosMora());
	}
	
	public String getTextoRsOutroAcrescimo(){
		return getTextoFcOutroAcrescimo();
	}

	public String getTextoFcOutroAcrescimo(){
		return getValue(boleto.getTitulo().getValorAcrecimo());
	}

	public String getTextoRsOutraDeducao(){
		return getTextoFcOutraDeducao();
	}

	public String getTextoFcOutraDeducao(){
		return getValue(boleto.getTitulo().getValorDeducao());
	}

	public String getTextoRsDescontoAbatimento(){
		return getTextoFcDescontoAbatimento();
	}
	
	public String getTextoFcDescontoAbatimento(){
		return getValue(boleto.getTitulo().getValorDesconto());
	}
	
	public String getTextoRsValorDocumento(){
		return getTextoFcValorDocumento();
	}

	public String getTextoFcValorDocumento(){
		return getValue(boleto.getTitulo().getValor());
	}
	
	public String getTextoRsValorCobrado(){
		return getTextoFcValorCobrado();
	}
	
	public String getTextoFcValorCobrado(){
		return getValue(boleto.getTitulo().getValorCobrado());
	}

	public String getTextoRsDataVencimento(){
		return getTextoFcDataVencimento();
	}

	public String getTextoFcDataVencimento(){
		return getValue(boleto.getTitulo().getDataDoVencimento());
	}

	public String getTextoRsNumeroDocumento(){
		return getTextoFcNumeroDocumento();
	}
	
	public String getTextoFcNumeroDocumento(){
		return getValue(boleto.getTitulo().getNumeroDoDocumento());
	}
	
	public String getTextoRsCedente(){
		return getTextoFcCedente();
	}
	
	public String getTextoFcCedente(){
		return getValue(boleto.getTitulo().getCedente().getNome());
	}
	
	public String getTextoRsEspecie(){
		return getTextoFcEspecie();
	}

	public String getTextoFcEspecie(){
		return getValue(boleto.getTitulo().getTipoDeMoeda());
	}
		
	public String getTextoRsCodigoBanco(){
		return getTextoFcCodigoBanco();
	}

	public String getTextoFcCodigoBanco(){
		return getTextoCodigoDoBanco(boleto.getTitulo().getContaBancaria());
	}

	public String getTextoRsAgenciaCodigoCedente(){
		return getTextoFcAgenciaCodigoCedente();
	}

	public String getTextoFcAgenciaCodigoCedente(){
		return getTextoAgenciaCodigoCedente(boleto.getTitulo().getContaBancaria());
	}
	
	public String getTextoRsNossoNumero(){
		return getTextoFcNossoNumero();
	}

	public String getTextoFcNossoNumero(){
		return getTextoNossoNumero(boleto.getTitulo());
	}
	
	public Image getImagemRsLogoBanco(){
		return getImagemFcLogoBanco();
	}
	
	public Image getImagemFcLogoBanco(){
		return getImagemBanco(resourceBundle, boleto.getTitulo().getContaBancaria());
	}

	public String getTextoRsLogoBanco(){
		return getTextoFcLogoBanco();
	}

	public String getTextoFcLogoBanco(){
		return boleto.getTitulo().getContaBancaria().getBanco().getNome();
	}

	public String getTextoRsLinhaDigitavel(){
		return getTextoFcLinhaDigitavel();
	}

	public String getTextoFcLinhaDigitavel(){
		return boleto.getLinhaDigitavel().write();
	}
	
	public Image getImagemFcCodigoBarra(){
		BarcodeInter25 barCode = new BarcodeInter25();
		barCode.setCode(boleto.getCodigoDeBarras().write());
		barCode.setExtended(true);
		barCode.setBarHeight(35);
		barCode.setFont(null);
		barCode.setN(3);
		return barCode.createAwtImage(Color.BLACK, Color.WHITE);
	}
	
	protected final Boleto getBoleto(){
		return this.boleto;
	}

	private String getValue(String value){
		if(StringUtils.isNotBlank(value)){
			return value;
		}
		return StringUtils.EMPTY;
	}

	private String getValue(Date value){
		if(ObjectUtils.isNotNull(value)){
			return DateFormat.DDMMYYYY_B.format(value);
		}
		return StringUtils.EMPTY;
	}

	private String getValue(BigDecimal value){
		if(ObjectUtils.isNotNull(value)){
			return DecimalFormat.MONEY_DD_BR.format(value);
		}
		return StringUtils.EMPTY;
	}

	private <T extends Enum<?>> String getValue(T value){
		if(ObjectUtils.isNotNull(value)){
			return value.name();
		}
		return StringUtils.EMPTY;
	}
}
