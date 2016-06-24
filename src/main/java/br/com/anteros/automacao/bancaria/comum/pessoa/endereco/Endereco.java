package br.com.anteros.automacao.bancaria.comum.pessoa.endereco;

/**
 * <p>
 * Entidade que encapsula dados do endereço de uma pessoa, como também 
 * facilidades na manipulação dos seus atributos.
 * </p>
 *
 * @author   <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * @author   Misael Barreto 
 * @author   Rômulo Augusto
 * @author   <a href="http://www.nordestefomento.com.br">Nordeste Fomento Mercantil</a>
 * @author <a href="mailto:samuelvalerio@gmail.com">Samuel Valério</a>
 * 
 * @since   0.2
 * @version   0.2
 */
public class Endereco {

	/**
	 * Nome da rua, avenida, etc.
	 */
	private String logradouro;
	
	/**
	 * Número que identifica o lugar no logradouro (ex: número da casa).
	 */
	private String numero;
	
	/**
	 * Informação adicional para identificar o estabelecimento na rua.
	 */
	private String complemento;
	
	/**
	 * Cada uma das divisões de uma cidade ou povoação.
	 */
	private String bairro;
	
	/**
	 * Cidade, município, etc.
	 */
	private String localidade;
	
	/**
	 * @see CEP
	 */
	private CEP cep;
	
	/**
	 * @see UnidadeFederativa
	 */
	private UnidadeFederativa uf;
	
	private String pais;
		
	public Endereco() {}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @return the localidade
	 */
	public String getLocalidade() {
		return localidade;
	}

	/**
	 * @param localidade the localidade to set
	 */
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public UnidadeFederativa getUF() {
		return uf;
	}

	public void setUF(UnidadeFederativa uf) {
		this.uf = uf;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public CEP getCEP() {
		return cep;
	}

	public void setCep(CEP cep) {
		this.cep = cep;
	}
	
	public void setCep(String cep) {
		setCep(new CEP(cep));
	}

	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Endereco [logradouro=" + logradouro + ", numero=" + numero + ", complemento=" + complemento
				+ ", bairro=" + bairro + ", localidade=" + localidade + ", cep=" + cep + ", uf=" + uf + ", pais=" + pais
				+ "]";
	}
	
	
	
}
