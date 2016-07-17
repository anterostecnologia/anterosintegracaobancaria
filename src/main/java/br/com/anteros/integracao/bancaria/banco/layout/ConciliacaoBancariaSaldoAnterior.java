package br.com.anteros.integracao.bancaria.banco.layout;

import java.math.BigDecimal;
import java.util.Date;

public class ConciliacaoBancariaSaldoAnterior {

	private Date dataSaldoAnterior;

	private BigDecimal valorSaldoAnterior;

	private String debitoCredito;

	private ConciliacaoBancariaSaldoAnterior(SaldoAnterior saldoAnterior) {
		this.dataSaldoAnterior = saldoAnterior.getDataSaldoAnterior();
		this.valorSaldoAnterior = saldoAnterior.getValorSaldoAnterior();
		this.debitoCredito = saldoAnterior.getDebitoCredito();
	}

	public Date getDataSaldoAnterior() {
		return dataSaldoAnterior;
	}

	public void setDataSaldoAnterior(Date dataSaldoAnterior) {
		this.dataSaldoAnterior = dataSaldoAnterior;
	}

	public BigDecimal getValorSaldoAnterior() {
		return valorSaldoAnterior;
	}

	public void setValorSaldoAnterior(BigDecimal valorSaldoAnterior) {
		this.valorSaldoAnterior = valorSaldoAnterior;
	}

	public String getDebitoCredito() {
		return debitoCredito;
	}

	public void setDebitoCredito(String debitoCredito) {
		this.debitoCredito = debitoCredito;
	}

	public static ConciliacaoBancariaSaldoAnterior of(SaldoAnterior saldoAnterior) {
		return new ConciliacaoBancariaSaldoAnterior(saldoAnterior);
	}

	@Override
	public String toString() {
		return "ConciliacaoBancariaSaldoAnterior [dataSaldoAnterior=" + dataSaldoAnterior + ", valorSaldoAnterior="
				+ valorSaldoAnterior + ", debitoCredito=" + debitoCredito + "]";
	}
	
	
}
