package br.com.anteros.integracao.bancaria.banco.layout;

import java.util.ArrayList;
import java.util.List;

public class ConciliacaoBancaria {

	private ContaBancaria contaBancaria;

	private List<ConciliacaoBancariaLancamento> lancamentos = new ArrayList<ConciliacaoBancariaLancamento>();

	private ConciliacaoBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

	public static ConciliacaoBancaria of(ContaBancaria contaBancaria) {
		return new ConciliacaoBancaria(contaBancaria);
	}

	public void add(Lancamento lancamento) {
		
	}

	public void set(SaldoAnterior saldoAnterior) {

	}

	public void set(SaldoAtual saldoAtual) {

	}

}
