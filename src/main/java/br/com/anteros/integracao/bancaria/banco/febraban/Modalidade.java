package br.com.anteros.integracao.bancaria.banco.febraban;

import br.com.anteros.core.utils.StringUtils;

/**
 * @author <a href="mailto:misaelbarreto@gmail.com">Misael Barreto</a>
 *
 */
public class Modalidade {

	private String codigo;
	
	private String nome;
	
	public Modalidade() {
	}
	
	public Modalidade(String codigo) {
		this.codigo = codigo;	
	}
	
	public Modalidade(Integer codigo) {
		this.codigo = String.valueOf(codigo);	
	}	
	
	public Modalidade(String codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;		
	}

	public Modalidade(Integer codigo, String nome) {
		this.codigo = String.valueOf(codigo);
		this.nome = nome;
	}	
	
	public String getCodigo() {
		return codigo;
	}

	public Integer getCodigoAsInteger() {
		
		if (StringUtils.isNumber(codigo)) {
			return Integer.parseInt(codigo);
			
		} else {
			return null;
		}
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = String.valueOf(codigo);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Modalidade [codigo=" + codigo + ", nome=" + nome + "]";
	}
		
}
