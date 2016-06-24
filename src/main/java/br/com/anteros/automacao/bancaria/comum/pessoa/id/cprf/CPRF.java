package br.com.anteros.automacao.bancaria.comum.pessoa.id.cprf;

/**
 * Interface comum entre Cadastro de Pessoa na Receita Federal de pessoas
 * Físicas ou Jurídicas.
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 */
public interface CPRF extends Comparable<Object>{

	public boolean isFisica();

	public boolean isJuridica();

	public Long getCodigo();

	public String getCodigoComZeros();
	
	public String getCodigoFormatado();
	
	public Long getRaiz();

	public String getRaizComZeros();
	
	public String getRaizFormatada();
	
	public Integer getDv();

	public String getDvComZeros();
}
