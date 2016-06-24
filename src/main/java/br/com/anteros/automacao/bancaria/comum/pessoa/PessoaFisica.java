package br.com.anteros.automacao.bancaria.comum.pessoa;

import java.util.Collection;

import br.com.anteros.automacao.bancaria.comum.pessoa.id.RG;



/**
 * 
 * @author <a href="http://gilmatryx.googlepages.com">Gilmar P.S.L.</a>
 * @author <a href="mailto:misaelbarreto@gmail.com">Misael Barreto</a>
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * 
 * @see br.com.anteros.integracao.bancaria.banco.PessoaFisica
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public interface PessoaFisica extends Pessoa {
	
	public PessoaFisica getConjuge();

	public void setConjuge(PessoaFisica conjuge);

	public String getEstadoCivil();

	public void setEstadoCivil(String estadoCivil);
	
	public Collection<RG> getRgs();
	
	public void setRgs(Collection<RG> rgs);
}
