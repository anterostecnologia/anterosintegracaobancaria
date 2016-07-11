package br.com.anteros.integracao.bancaria.banco.febraban.cnab240;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.anteros.core.utils.Assert;
import br.com.anteros.integracao.bancaria.banco.febraban.CNABException;
import br.com.anteros.integracao.bancaria.banco.febraban.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.febraban.RemessaCobranca;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.bancobrasil.BancoBrasilCNAB240;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.bradesco.BradescoCNAB240;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.caixa.CaixaEconomicaFederalCNAB240;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.hsbc.HsbcCNAB240;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.itau.ItauCNAB240;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.santander.SantanderCNAB240;
import br.com.anteros.integracao.bancaria.util.Constants;

public class CNAB240Factory {


	public static CNAB240 create(List<RemessaCobranca> remessas) {
		return CNAB240Factory.create(remessas, Calendar.getInstance().getTime(), Calendar.getInstance().getTime());
	}

	public static CNAB240 create(List<RemessaCobranca> remessas, Date dataHoraGeracao, Date dataGravacao) {
		Assert.checkArgument(remessas.size() > 0, "Informe as remessas para cobrança bancária.");
		ContaBancaria contaBancaria = remessas.iterator().next().getTitulo().getContaBancaria();
		if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.BANCO_BRASIL)) {
			return BancoBrasilCNAB240.of(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.BRADESCO)) {
			return BradescoCNAB240.of(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.CAIXA_ECONOMICA_FEDERAL)) {
			return CaixaEconomicaFederalCNAB240.of(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.HSBC)) {
			return HsbcCNAB240.of(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.ITAU)) {
			return ItauCNAB240.of(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.SANTANDER)) {
			return SantanderCNAB240.of(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
		}
		throw new CNABException(
				"Layout CNAB240 do banco " + contaBancaria.getBanco().getNome() + " ainda não implementado.");
	}

	public static CNAB240 create(ContaBancaria contaBancaria) {
		return CNAB240Factory.create(contaBancaria, Calendar.getInstance().getTime(), Calendar.getInstance().getTime());
	}

	public static CNAB240 create(ContaBancaria contaBancaria, Date dataHoraGeracao, Date dataGravacao) {
		if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.BANCO_BRASIL)) {
			return BancoBrasilCNAB240.of(contaBancaria, dataHoraGeracao, dataGravacao);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.BRADESCO)) {
			return BradescoCNAB240.of(contaBancaria, dataHoraGeracao, dataGravacao);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.CAIXA_ECONOMICA_FEDERAL)) {
			return CaixaEconomicaFederalCNAB240.of(contaBancaria, dataHoraGeracao, dataGravacao);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.HSBC)) {
			return HsbcCNAB240.of(contaBancaria, dataHoraGeracao, dataGravacao);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.ITAU)) {
			return ItauCNAB240.of(contaBancaria, dataHoraGeracao, dataGravacao);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.SANTANDER)) {
			return SantanderCNAB240.of(contaBancaria, dataHoraGeracao, dataGravacao);
		}
		throw new CNABException(
				"Layout CNAB240 do banco " + contaBancaria.getBanco().getNome() + " ainda não implementado.");
	}
}
