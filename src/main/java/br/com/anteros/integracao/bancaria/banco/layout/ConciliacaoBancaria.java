package br.com.anteros.integracao.bancaria.banco.layout;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author edsonmartins
 *
 */
public class ConciliacaoBancaria {

	private ContaBancaria contaBancaria;
	private ConciliacaoBancariaSaldoAnterior saldoAnterior;
	private ConciliacaoBancariaSaldoAtual saldoAtual;

	private List<ConciliacaoBancariaLancamento> lancamentos = new ArrayList<ConciliacaoBancariaLancamento>();

	private ConciliacaoBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

	public static ConciliacaoBancaria of(ContaBancaria contaBancaria) {
		return new ConciliacaoBancaria(contaBancaria);
	}

	public void add(Lancamento lancamento) {
		lancamentos.add(ConciliacaoBancariaLancamento.of(lancamento));
	}

	public void set(SaldoAnterior saldoAnterior) {
       this.saldoAnterior = ConciliacaoBancariaSaldoAnterior.of(saldoAnterior);
	}

	public void set(SaldoAtual saldoAtual) {
		this.saldoAtual = ConciliacaoBancariaSaldoAtual.of(saldoAtual);
	}

	public ContaBancaria getContaBancaria() {
		return contaBancaria;
	}

	public void setContaBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

	public ConciliacaoBancariaSaldoAnterior getSaldoAnterior() {
		return saldoAnterior;
	}

	public void setSaldoAnterior(ConciliacaoBancariaSaldoAnterior saldoAnterior) {
		this.saldoAnterior = saldoAnterior;
	}

	public ConciliacaoBancariaSaldoAtual getSaldoAtual() {
		return saldoAtual;
	}

	public void setSaldoAtual(ConciliacaoBancariaSaldoAtual saldoAtual) {
		this.saldoAtual = saldoAtual;
	}

	public List<ConciliacaoBancariaLancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<ConciliacaoBancariaLancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(saldoAnterior);
		sb.append("\n");
		for(ConciliacaoBancariaLancamento lancamento: lancamentos){
			sb.append(lancamento);
			sb.append("\n");
		}
		sb.append(saldoAtual);
		return sb.toString();
	}

}
