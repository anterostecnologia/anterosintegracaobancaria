package br.com.anteros.automacao.bancaria.comum.pessoa.contato;

/**
 * 
 * <p>
 * Representação particio
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
public class NumeroDeTelefone{

	private int ddi;

	private int ddd;

	private int prefixo;

	private int sufixo;
	
	private String telefone;

	public NumeroDeTelefone() {}
	
	public int getDDI() {
		return ddi;
	}

	public void setDDI(int ddi) {
		this.ddi = ddi;
	}

	public int getDDD() {
		return ddd;
	}

	public void setDDD(int ddd) {
		this.ddd = ddd;
	}

	public int getPrefixo() {
		return prefixo;
	}

	public void setPrefixo(int prefixo) {
		this.prefixo = prefixo;
	}

	public int getSufixo() {
		return sufixo;
	}

	public void setSufixo(int sufixo) {
		this.sufixo = sufixo;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "NumeroDeTelefone [ddi=" + ddi + ", ddd=" + ddd + ", prefixo=" + prefixo + ", sufixo=" + sufixo
				+ ", telefone=" + telefone + "]";
	}

}
