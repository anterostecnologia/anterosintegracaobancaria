package br.com.anteros.integracao.bancaria.banco.layout.cnab200.extrato;

import br.com.anteros.core.utils.Assert;
import br.com.anteros.integracao.bancaria.banco.layout.CNABException;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.cnab200.extrato.bancobrasil.BancoBrasilCNAB200;
import br.com.anteros.integracao.bancaria.banco.layout.cnab200.extrato.bradesco.BradescoCNAB200;
import br.com.anteros.integracao.bancaria.util.Constants;

public class CNAB200Factory {


	public static CNAB200 create(ContaBancaria contaBancaria) {
		Assert.checkArgument(contaBancaria!=null, "Informe a conta bancária.");
		if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.BANCO_BRASIL)) {
			return BancoBrasilCNAB200.of(contaBancaria);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.BRADESCO)) {
			return BradescoCNAB200.of(contaBancaria);
		}
		throw new CNABException(
				"Layout CNAB200 do banco " + contaBancaria.getBanco().getNome() + " ainda não implementado ou não suportado.");
	}

}
