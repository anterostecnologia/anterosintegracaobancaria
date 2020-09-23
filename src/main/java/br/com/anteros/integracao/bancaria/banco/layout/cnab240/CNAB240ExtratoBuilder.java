package br.com.anteros.integracao.bancaria.banco.layout.cnab240;

import java.util.Calendar;
import java.util.Date;

import br.com.anteros.core.utils.Assert;
import br.com.anteros.integracao.bancaria.banco.layout.CNABException;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.extrato.bancobrasil.v87.BancoBrasilCNAB240Extrato;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.extrato.bradesco.v50.BradescoCNAB240Extrato;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.extrato.itau.v50.ItauCNAB240Extrato;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.extrato.sicoob.BancoSicoobCNAB240Extrato;
import br.com.anteros.integracao.bancaria.util.Constants;

public class CNAB240ExtratoBuilder {

	private ContaBancaria contaBancaria;

	private Date dataHoraGeracao = Calendar.getInstance().getTime();

	public CNAB240ExtratoBuilder contaBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
		return this;
	}

	public CNAB240ExtratoBuilder dataHoraGeracao(Date dataHoraGeracao) {
		this.dataHoraGeracao = dataHoraGeracao;
		return this;
	}

	public CNAB240Extrato build() {
		Assert.notNull(contaBancaria, "Informe a conta bancária para criar o contexto CNAB240.");

		if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.BANCO_BRASIL)) {
			return BancoBrasilCNAB240Extrato.of(contaBancaria, dataHoraGeracao);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.BRADESCO)) {
			return BradescoCNAB240Extrato.of(contaBancaria, dataHoraGeracao);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.ITAU)) {
			return ItauCNAB240Extrato.of(contaBancaria, dataHoraGeracao);
		} else if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.SICOOB)) {
			return BancoSicoobCNAB240Extrato.of(contaBancaria, dataHoraGeracao);
		} else {
			throw new CNABException(
					"Layout CNAB240 do banco " + contaBancaria.getBanco().getNome() + " ainda não implementado.");
		}
	}

}
