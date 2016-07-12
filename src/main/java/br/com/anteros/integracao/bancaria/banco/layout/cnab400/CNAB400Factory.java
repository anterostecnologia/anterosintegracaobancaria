package br.com.anteros.integracao.bancaria.banco.layout.cnab400;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.anteros.core.utils.Assert;
import br.com.anteros.integracao.bancaria.banco.layout.CNABException;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.RemessaCobranca;
import br.com.anteros.integracao.bancaria.banco.layout.cnab400.bancobrasil.BancoBrasilCNAB400;
import br.com.anteros.integracao.bancaria.banco.layout.cnab400.bradesco.BradescoCNAB400;
import br.com.anteros.integracao.bancaria.banco.layout.cnab400.caixa.CaixaEconomicaFederalCNAB400;
import br.com.anteros.integracao.bancaria.banco.layout.cnab400.hsbc.HsbcCNAB400;
import br.com.anteros.integracao.bancaria.banco.layout.cnab400.itau.ItauCNAB400;
import br.com.anteros.integracao.bancaria.banco.layout.cnab400.santander.SantanderCNAB400;
import br.com.anteros.integracao.bancaria.util.Constants;

public class CNAB400Factory {

	public static CNAB400 create(List<RemessaCobranca> remessas) {
		return CNAB400Factory.create(remessas, Calendar.getInstance().getTime(), Calendar.getInstance().getTime());
	}

	public static CNAB400 create(List<RemessaCobranca> remessas, Date dataHoraGeracao, Date dataGravacao) {
		Assert.checkArgument(remessas.size() > 0, "Informe as remessas para cobrança bancária.");
		ContaBancaria contaBancaria = remessas.iterator().next().getTitulo().getContaBancaria();
		if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.BANCO_BRASIL)) {
			return BancoBrasilCNAB400.of(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.BRADESCO)) {
			return BradescoCNAB400.of(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.CAIXA_ECONOMICA_FEDERAL)) {
			return CaixaEconomicaFederalCNAB400.of(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.HSBC)) {
			return HsbcCNAB400.of(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.ITAU)) {
			return ItauCNAB400.of(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.SANTANDER)) {
			return SantanderCNAB400.of(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
		}
		throw new CNABException(
				"Layout CNAB400 do banco " + contaBancaria.getBanco().getNome() + " ainda não implementado.");
	}

	public static CNAB400 create(ContaBancaria contaBancaria) {
		return CNAB400Factory.create(contaBancaria, Calendar.getInstance().getTime(), Calendar.getInstance().getTime());
	}

	public static CNAB400 create(ContaBancaria contaBancaria, Date dataHoraGeracao, Date dataGravacao) {
		if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.BANCO_BRASIL)) {
			return BancoBrasilCNAB400.of(contaBancaria, dataHoraGeracao, dataGravacao);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.BRADESCO)) {
			return BradescoCNAB400.of(contaBancaria, dataHoraGeracao, dataGravacao);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.CAIXA_ECONOMICA_FEDERAL)) {
			return CaixaEconomicaFederalCNAB400.of(contaBancaria, dataHoraGeracao, dataGravacao);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.HSBC)) {
			return HsbcCNAB400.of(contaBancaria, dataHoraGeracao, dataGravacao);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.ITAU)) {
			return ItauCNAB400.of(contaBancaria, dataHoraGeracao, dataGravacao);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.SANTANDER)) {
			return SantanderCNAB400.of(contaBancaria, dataHoraGeracao, dataGravacao);
		}
		throw new CNABException(
				"Layout CNAB400 do banco " + contaBancaria.getBanco().getNome() + " ainda não implementado.");
	}
}
