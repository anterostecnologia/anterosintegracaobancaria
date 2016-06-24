package br.com.anteros.automacao.bancaria.comum.pessoa.endereco;
/**
 * 
 * <p>
 * Representação básica de um CEP.
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
public class CEP {

	/**
	 * Primeiros cinco dígitos.
	 * Exemplo: Para o CEP 59.020-300 o prefixo é o 59020.
	 */
	private Integer prefixo;
	
	/**
	 * Últimos dois dígitos.
	 * Exemplo: Para o CEP 59.020-300 o sufixo é o 300.
	 */
	private Integer sufixo;
	
	/**
	 * CEP completo (prefixo+sufixo).
	 * Exemplo: Para o CEP 59.020-300 o cep pode ser:
	 * <ul>
	 * <li>59.020-300<li>
	 * <li>59020300<li>
	 * </ul>
	 */
	private String cep;
	
	public CEP() {}
	
	public CEP(String cep) {
		
		this.cep = cep;
	}

	public Integer getPrefixo() {
		return prefixo;
	}

	public void setPrefixo(Integer prefixo) {
		this.prefixo = prefixo;
	}

	public Integer getSufixo() {
		return sufixo;
	}

	public void setSufixo(Integer sufixo) {
		this.sufixo = sufixo;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "CEP [prefixo=" + prefixo + ", sufixo=" + sufixo + ", cep=" + cep + "]";
	}

	
}
