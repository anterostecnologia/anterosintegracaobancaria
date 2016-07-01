package br.com.anteros.integracao.bancaria.banco.febraban.cnab240;

import java.util.Date;
import java.util.List;

import br.com.anteros.core.utils.Assert;
import br.com.anteros.integracao.bancaria.banco.Banco;
import br.com.anteros.integracao.bancaria.banco.febraban.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.febraban.RemessaCobranca;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.bancobrasil.BancoBrasilCNAB240;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.bradesco.BradescoCNAB240;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.caixa.CaixaEconomicaFederalCNAB240;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.hsbc.HsbcCNAB240;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.itau.ItauCNAB240;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.santander.SantanderCNAB240;

public class CNAB240Factory {

	public static final Integer BANCO_BRASIL = 1;
	public static final Integer BRADESCO = 237;
	public static final Integer CAIXA_ECONOMICA_FEDERAL = 104;
	public static final Integer HSBC = 399;
	public static final Integer ITAU = 184;
	public static final Integer SANTANDER = 033;
	public static final Integer REAL = 356;

	public static CNAB240 create(List<RemessaCobranca> remessas, Date dataHoraGeracao) {
		Assert.checkArgument(remessas.size()>0, "Informe as remessas para cobrança bancária.");
		ContaBancaria contaBancaria = remessas.iterator().next().getTitulo().getContaBancaria();
		if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo() == BANCO_BRASIL) {
			return new BancoBrasilCNAB240(contaBancaria, remessas, dataHoraGeracao);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo() == BRADESCO) {
			return new BradescoCNAB240(contaBancaria, remessas,dataHoraGeracao);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo() == CAIXA_ECONOMICA_FEDERAL) {
			return new CaixaEconomicaFederalCNAB240(contaBancaria, remessas,dataHoraGeracao);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo() == HSBC) {
			return new HsbcCNAB240(contaBancaria, remessas,dataHoraGeracao);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo() == ITAU) {
			return new ItauCNAB240(contaBancaria, remessas,dataHoraGeracao);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo() == SANTANDER) {
			return new SantanderCNAB240(contaBancaria, remessas,dataHoraGeracao);
		}
		throw new CNABException(
				"Layout CNAB240 do banco " + contaBancaria.getBanco().getNome() + " ainda não implementado.");
	}

	public static CNAB240 create(ContaBancaria contaBancaria,  Date dataHoraGeracao) {
		if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo() == BANCO_BRASIL) {
			return new BancoBrasilCNAB240(contaBancaria, dataHoraGeracao);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo() == BRADESCO) {
			return new BradescoCNAB240(contaBancaria,dataHoraGeracao);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo() == CAIXA_ECONOMICA_FEDERAL) {
			return new CaixaEconomicaFederalCNAB240(contaBancaria,dataHoraGeracao);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo() == HSBC) {
			return new HsbcCNAB240(contaBancaria,dataHoraGeracao);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo() == ITAU) {
			return new ItauCNAB240(contaBancaria,dataHoraGeracao);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo() == SANTANDER) {
			return new SantanderCNAB240(contaBancaria,dataHoraGeracao);
		}
		throw new CNABException(
				"Layout CNAB240 do banco " + contaBancaria.getBanco().getNome() + " ainda não implementado.");
	}
}
