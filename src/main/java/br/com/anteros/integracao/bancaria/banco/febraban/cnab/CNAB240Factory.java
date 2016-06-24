package br.com.anteros.integracao.bancaria.banco.febraban.cnab;

import br.com.anteros.integracao.bancaria.banco.febraban.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab.bancobrasil.BancoBrasilCNAB240;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab.bradesco.BradescoCNAB240;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab.caixa.CaixaEconomicaFederalCNAB240;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab.hsbc.HsbcCNAB240;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab.itau.ItauCNAB240;

public class CNAB240Factory {

	public static final Integer BANCO_BRASIL = 1;
	public static final Integer BRADESCO = 237;
	public static final Integer CAIXA_ECONOMICA_FEDERAL = 104;
	public static final Integer HSBC = 399;
	public static final Integer ITAU = 184;
	public static final Integer UNIBANCO = 409;
	public static final Integer SANTANDER = 033;
	public static final Integer REAL = 356;

	public static CNAB240 create(ContaBancaria contaBancaria) {
		if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo() == BANCO_BRASIL) {
			return new BancoBrasilCNAB240();
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo() == BRADESCO) {
			return new BradescoCNAB240();
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo() == CAIXA_ECONOMICA_FEDERAL) {
			return new CaixaEconomicaFederalCNAB240();
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo() == HSBC) {
			return new HsbcCNAB240();
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo() == ITAU) {
			return new ItauCNAB240();
		}
		throw new CNABException(
				"Layout CNAB240 do banco " + contaBancaria.getBanco().getNome() + " ainda não implementado.");
	}
}
