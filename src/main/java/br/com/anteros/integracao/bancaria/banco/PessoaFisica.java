package br.com.anteros.integracao.bancaria.banco;


import java.util.Collection;

import br.com.anteros.automacao.bancaria.comum.pessoa.id.RG;
import br.com.anteros.core.utils.ObjectUtils;


/**
 * <p>
 * Representação básica de uma Pessoa Física.
 * </p>
 * 
 * @see Pessoa
 * @see br.com.anteros.automacao.bancaria.comum.pessoa.id.cprf.CPRF
 * @see br.com.anteros.automacao.bancaria.comum.pessoa.id.cprf.CPF
 * 
 * @author <a href="http://gilmatryx.googlepages.com">Gilmar P.S.L.</a>
 * @author <a href="mailto:misaelbarreto@gmail.com">Misael Barreto</a>
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */

public class PessoaFisica extends Pessoa implements
		br.com.anteros.automacao.bancaria.comum.pessoa.PessoaFisica {

	private br.com.anteros.automacao.bancaria.comum.pessoa.PessoaFisica conjuge;

	private String estadoCivil;

	private Collection<RG> rgs;

	public PessoaFisica() {
	}

	public br.com.anteros.automacao.bancaria.comum.pessoa.PessoaFisica getConjuge() {

		return conjuge;
	}

	public String getEstadoCivil() {

		return estadoCivil;
	}

	public Collection<RG> getRgs() {

		return rgs;
	}

	public void setConjuge(
			br.com.anteros.automacao.bancaria.comum.pessoa.PessoaFisica conjuge) {

		this.conjuge = conjuge;

		if (ObjectUtils.isNotNull(conjuge) && ObjectUtils.isNull(conjuge.getConjuge()))
			conjuge.setConjuge(this);
	}

	public void setEstadoCivil(String estadoCivil) {

		this.estadoCivil = estadoCivil;
	}

	public void setRgs(Collection<RG> rgs) {

		this.rgs = rgs;
	}

}
