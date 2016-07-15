package br.com.anteros.integracao.bancaria.banco.layout.cnab240;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.anteros.core.utils.Assert;
import br.com.anteros.integracao.bancaria.banco.layout.CNABException;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.RemessaCobranca;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.bancobrasil.BancoBrasilCNAB240Context;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.bradesco.BradescoCNAB240Context;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.caixa.CaixaEconomicaFederalCNAB240Context;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.hsbc.HsbcCNAB240Context;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.itau.ItauCNAB240Context;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.santander.SantanderCNAB240Context;
import br.com.anteros.integracao.bancaria.util.Constants;

public class CNAB240ContextBuilder<T> {

	private List<RemessaCobranca> remessas;

	private ContaBancaria contaBancaria;

	private Date dataGravacao = Calendar.getInstance().getTime();

	private Date dataHoraGeracao = Calendar.getInstance().getTime();

	public CNAB240ContextBuilder<T> remessas(List<RemessaCobranca> remessas) {
		this.remessas = remessas;
		return this;
	}

	public CNAB240ContextBuilder<T> contaBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
		return this;
	}

	public CNAB240ContextBuilder<T> dataGravacao(Date dataGravacao) {
		this.dataGravacao = dataGravacao;
		return this;
	}
	
	public CNAB240ContextBuilder<T> dataHoraGeracao(Date dataHoraGeracao) {
		this.dataHoraGeracao = dataHoraGeracao;
		return this;
	}

	public CNAB240Context<T> build() {
		if (remessas != null) {
			if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.BANCO_BRASIL)) {
				return BancoBrasilCNAB240Context.<T>of(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
			} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.BRADESCO)) {
				return BradescoCNAB240Context.<T>of(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
			} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo()
					.equals(Constants.CAIXA_ECONOMICA_FEDERAL)) {
				return CaixaEconomicaFederalCNAB240Context.<T>of(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
			} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.HSBC)) {
				return HsbcCNAB240Context.<T>of(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
			} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.ITAU)) {
				return ItauCNAB240Context.<T>of(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
			} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.SANTANDER)) {
				return SantanderCNAB240Context.<T>of(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
			}
			throw new CNABException(
					"Layout CNAB240 do banco " + contaBancaria.getBanco().getNome() + " ainda não implementado.");
		} else {
			Assert.notNull(contaBancaria, "Informe a conta bancária para criar o contexto CNAB240.");
			if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.BANCO_BRASIL)) {
				return BancoBrasilCNAB240Context.<T>of(contaBancaria, dataHoraGeracao, dataGravacao);
			} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.BRADESCO)) {
				return BradescoCNAB240Context.<T>of(contaBancaria, dataHoraGeracao, dataGravacao);
			} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo()
					.equals(Constants.CAIXA_ECONOMICA_FEDERAL)) {
				return CaixaEconomicaFederalCNAB240Context.<T>of(contaBancaria, dataHoraGeracao, dataGravacao);
			} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.HSBC)) {
				return HsbcCNAB240Context.<T>of(contaBancaria, dataHoraGeracao, dataGravacao);
			} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.ITAU)) {
				return ItauCNAB240Context.<T>of(contaBancaria, dataHoraGeracao, dataGravacao);
			} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.SANTANDER)) {
				return SantanderCNAB240Context.<T>of(contaBancaria, dataHoraGeracao, dataGravacao);
			}
			throw new CNABException(
					"Layout CNAB240 do banco " + contaBancaria.getBanco().getNome() + " ainda não implementado.");
		}
	}

}
