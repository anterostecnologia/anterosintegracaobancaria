package br.com.anteros.integracao.bancaria.banco.febraban.cnab400;

import java.util.List;

import br.com.anteros.integracao.bancaria.banco.febraban.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.febraban.RemessaCobranca;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.CNABException;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab400.bancobrasil.BancoBrasilCNAB400;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab400.bradesco.BradescoCNAB400;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab400.caixa.CaixaEconomicaFederalCNAB400;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab400.hsbc.HsbcCNAB400;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab400.itau.ItauCNAB400;

public class CNAB400Factory {
	

	public static final Integer BANCO_BRASIL = 1;
	public static final Integer BRADESCO = 237;
	public static final Integer CAIXA_ECONOMICA_FEDERAL = 104;
	public static final Integer HSBC = 399;
	public static final Integer ITAU = 184;
	public static final Integer SANTANDER = 033;
	public static final Integer REAL = 356;

	public static CNAB400 create(ContaBancaria contaBancaria, List<RemessaCobranca> remessas) {
		if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo() == BANCO_BRASIL) {
			return new BancoBrasilCNAB400(contaBancaria,remessas);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo() == BRADESCO) {
			return new BradescoCNAB400(contaBancaria,remessas);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo() == CAIXA_ECONOMICA_FEDERAL) {
			return new CaixaEconomicaFederalCNAB400(contaBancaria,remessas);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo() == HSBC) {
			return new HsbcCNAB400(contaBancaria,remessas);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo() == ITAU) {
			return new ItauCNAB400(contaBancaria,remessas);
		}
		throw new CNABException(
				"Layout CNAB400 do banco " + contaBancaria.getBanco().getNome() + " ainda não implementado.");
	}
	
	public static CNAB400 create(ContaBancaria contaBancaria) {
		if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo() == BANCO_BRASIL) {
			return new BancoBrasilCNAB400(contaBancaria);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo() == BRADESCO) {
			return new BradescoCNAB400(contaBancaria);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo() == CAIXA_ECONOMICA_FEDERAL) {
			return new CaixaEconomicaFederalCNAB400(contaBancaria);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo() == HSBC) {
			return new HsbcCNAB400(contaBancaria);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo() == ITAU) {
			return new ItauCNAB400(contaBancaria);
		}
		throw new CNABException(
				"Layout CNAB400 do banco " + contaBancaria.getBanco().getNome() + " ainda não implementado.");
	}

}
