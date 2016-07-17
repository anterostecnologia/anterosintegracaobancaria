package br.com.anteros.integracao.bancaria.banco.layout;

import java.math.BigDecimal;
import java.util.Date;

public interface SaldoAnterior {

	public Date getDataSaldoAnterior();

	public BigDecimal getValorSaldoAnterior();

	public String getDebitoCredito();
}
