package br.com.anteros.integracao.bancaria.banco.febraban;

import br.com.anteros.core.utils.StringUtils;
import br.com.anteros.integracao.bancaria.validador.digitoverificador.CodigoDeCompensacaoBancosBACENDV;

/**
 * <p>
 * Código de compensação para bancos supervisionados pelo <a
 * href="http://www.bcb.gov.br/?CHEQUESCOMPE">BACEN</a>
 * </p>
 * 
 * @author <a href="http://gilmatryx.googlepages.com">Gilmar P.S.L.</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public class CodigoDeCompensacaoBACEN {

	private static final CodigoDeCompensacaoBancosBACENDV dv4Compensacao = new CodigoDeCompensacaoBancosBACENDV();
	
	private Integer codigo;

	private Integer digito;

	/**
	 * @param codigo
	 */
	public CodigoDeCompensacaoBACEN(Integer codigo) {
		super();
		
		setCodigo(codigo);
	}

	/**
	 * @param codigo
	 */
	public CodigoDeCompensacaoBACEN(String codigo) {
		super();
		
		setCodigo(codigo);
	}

	private void initDV(){
		
		if(dv4Compensacao.isCodigoValido(codigo)){
			this.digito = dv4Compensacao.calcule(codigo);
		}
	}
	
	/**
	 * @return the codigo formatado ex: "001"
	 */
	public String getCodigoFormatado() {
		return StringUtils.padZero(String.valueOf(getCodigo()), 3);
	}
	
	/**
	 * @return the codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Integer codigo) {
		
		if(dv4Compensacao.isCodigoValido(codigo)){
			this.codigo = codigo;
			initDV();
		}
	}
	
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		
		if(dv4Compensacao.isCodigoValido(codigo)){
			this.codigo = Integer.valueOf(codigo);
			initDV();
		}
	}

	/**
	 * @return the digito
	 */
	public Integer getDigito() {
		return digito;
	}

	@Override
	public String toString() {
		return "CodigoDeCompensacaoBACEN [codigo=" + codigo + ", digito=" + digito + "]";
	}

	
}