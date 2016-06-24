package br.com.anteros.integracao.bancaria.banco.febraban;


/**
 * 
 * <p>
 * Identifica uma conta bancária e assume os sinônimos:
 * <ul>
 * <li>Código do cedente</li>
 * <li>Convênio</li>
 * </ul>
 * </p>
 * 
 * @author <a href="http://gilmatryx.googlepages.com">Gilmar P.S.L.</a>
 * @author <a href="mailto:misaelbarreto@gmail.com">Misael Barreto</a>
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * @author <a href="mailto:samuelvalerio@gmail.com">Samuel Valério</a>
 * 
 * @since 0.2 
 * 
 * @version 0.2
 */
public class NumeroDaConta {

	private Integer codigoDaConta = 0;

	private String digitoDaConta = "";
	
	public NumeroDaConta() {}
	
	public NumeroDaConta(Integer codigoDaConta) {
		
		this.codigoDaConta = codigoDaConta;
	}
	
	public NumeroDaConta(Integer codigoDaConta, String digitoDaConta) {
		
		this.codigoDaConta = codigoDaConta;
		this.digitoDaConta = digitoDaConta;
	}

	public Integer getCodigoDaConta() {
		return codigoDaConta;
	}

	public void setCodigoDaConta(Integer codigoDaConta) {
		this.codigoDaConta = codigoDaConta;
	}

	public String getDigitoDaConta() {
		return digitoDaConta;
	}

	public void setDigitoDaConta(String digitoDaConta) {
		this.digitoDaConta = digitoDaConta;
	}

	@Override
	public String toString() {
		return "NumeroDaConta [codigoDaConta=" + codigoDaConta + ", digitoDaConta=" + digitoDaConta + "]";
	}
	
}
