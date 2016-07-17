package br.com.anteros.integracao.bancaria.banco.layout;

import java.math.BigDecimal;
import java.util.Date;

public class ConciliacaoBancariaSaldoAtual {

	private BigDecimal valorSaldoBloqueado;

	private Date dataSaldoAtual;

	private BigDecimal valorSaldoAtual;

	private String debitoCredito;

	private BigDecimal valorTotalDebitos;

	private BigDecimal valorTotalCreditos;

	private ConciliacaoBancariaSaldoAtual(SaldoAtual saldoAtual) {
		this.valorSaldoBloqueado = saldoAtual.getSaldoBloqueado();
		this.valorSaldoAtual = saldoAtual.getSaldoAtual();
		this.debitoCredito = saldoAtual.getDebitoCredito();
		this.dataSaldoAtual = saldoAtual.getDataSaldoAtual();
		this.valorTotalDebitos = saldoAtual.getValorTotalDebitos();
		this.valorTotalCreditos = saldoAtual.getValorTotalCreditos();
	}

	public BigDecimal getValorSaldoBloqueado() {
		return valorSaldoBloqueado;
	}

	public void setValorSaldoBloqueado(BigDecimal valorSaldoBloqueado) {
		this.valorSaldoBloqueado = valorSaldoBloqueado;
	}

	public Date getDataSaldoAtual() {
		return dataSaldoAtual;
	}

	public void setDataSaldoAtual(Date dataSaldoAtual) {
		this.dataSaldoAtual = dataSaldoAtual;
	}

	public BigDecimal getValorSaldoAtual() {
		return valorSaldoAtual;
	}

	public void setValorSaldoAtual(BigDecimal valorSaldoAtual) {
		this.valorSaldoAtual = valorSaldoAtual;
	}

	public String getDebitoCredito() {
		return debitoCredito;
	}

	public void setDebitoCredito(String debitoCredito) {
		this.debitoCredito = debitoCredito;
	}

	public BigDecimal getValorTotalDebitos() {
		return valorTotalDebitos;
	}

	public void setValorTotalDebitos(BigDecimal valorTotalDebitos) {
		this.valorTotalDebitos = valorTotalDebitos;
	}

	public BigDecimal getValorTotalCreditos() {
		return valorTotalCreditos;
	}

	public void setValorTotalCreditos(BigDecimal valorTotalCreditos) {
		this.valorTotalCreditos = valorTotalCreditos;
	}

	public static ConciliacaoBancariaSaldoAtual of(SaldoAtual saldoAtual) {
		return new ConciliacaoBancariaSaldoAtual(saldoAtual);
	}

	@Override
	public String toString() {
		return "ConciliacaoBancariaSaldoAtual [valorSaldoBloqueado=" + valorSaldoBloqueado + ", dataSaldoAtual=" + dataSaldoAtual
				+ ", valorSaldoAtual=" + valorSaldoAtual + ", debitoCredito=" + debitoCredito + ", valorTotalDebitos="
				+ valorTotalDebitos + ", valorTotalCreditos=" + valorTotalCreditos + "]";
	}
}
