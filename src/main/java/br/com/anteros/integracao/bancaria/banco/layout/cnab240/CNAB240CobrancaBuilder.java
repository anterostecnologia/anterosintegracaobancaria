package br.com.anteros.integracao.bancaria.banco.layout.cnab240;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.anteros.integracao.bancaria.banco.layout.CNABException;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.RemessaCobranca;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.cobranca.bancobrasil.v87.BancoBrasilCNAB240Cobranca;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.cobranca.bradesco.v84.BradescoCNAB240Cobranca;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.cobranca.caixa.v50.CaixaEconomicaFederalCNAB240Cobranca;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.cobranca.hsbc.v10.HsbcCNAB240Cobranca;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.cobranca.itau.v40.ItauCNAB240Cobranca;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.cobranca.santander.v40.SantanderCNAB240Cobranca;
import br.com.anteros.integracao.bancaria.util.Constants;

public class CNAB240CobrancaBuilder {

	private List<RemessaCobranca> remessas;

	private ContaBancaria contaBancaria;

	private Date dataGravacao = Calendar.getInstance().getTime();

	private Date dataHoraGeracao = Calendar.getInstance().getTime();

	public CNAB240CobrancaBuilder remessas(List<RemessaCobranca> remessas) {
		this.remessas = remessas;
		return this;
	}

	public CNAB240CobrancaBuilder contaBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
		return this;
	}

	public CNAB240CobrancaBuilder dataGravacao(Date dataGravacao) {
		this.dataGravacao = dataGravacao;
		return this;
	}

	public CNAB240CobrancaBuilder dataHoraGeracao(Date dataHoraGeracao) {
		this.dataHoraGeracao = dataHoraGeracao;
		return this;
	}

	public CNAB240Cobranca build() {
		if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.BANCO_BRASIL)) {
			return BancoBrasilCNAB240Cobranca.of(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.BRADESCO)) {
			return BradescoCNAB240Cobranca.of(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo()
				.equals(Constants.CAIXA_ECONOMICA_FEDERAL)) {
			return CaixaEconomicaFederalCNAB240Cobranca.of(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.HSBC)) {
			return HsbcCNAB240Cobranca.of(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.ITAU)) {
			return ItauCNAB240Cobranca.of(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.SANTANDER)) {
			return SantanderCNAB240Cobranca.of(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
		}
		throw new CNABException(
				"Layout CNAB240 do banco " + contaBancaria.getBanco().getNome() + " ainda não implementado.");
	}

}
