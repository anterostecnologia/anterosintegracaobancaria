package br.com.anteros.automacao.bancaria.comum.pessoa;


/**
 * 
 * @author <a href="http://gilmatryx.googlepages.com">Gilmar P.S.L.</a>
 * @author <a href="mailto:misaelbarreto@gmail.com">Misael Barreto</a>
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * 
 * @see br.com.anteros.integracao.bancaria.banco.PessoaJuridica
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public interface PessoaJuridica extends Pessoa {

	public String getNomeFantasia();

	public void setNomeFantasia(String nomeFantasia);

	public Long getInscricaoEstadual();

	public void setInscricaoEstadual(Long inscricaoEstadual);

	public Long getInscricaoMunicipal();

	public void setInscricaoMunicipal(Long inscricaoMunicipal);
}
