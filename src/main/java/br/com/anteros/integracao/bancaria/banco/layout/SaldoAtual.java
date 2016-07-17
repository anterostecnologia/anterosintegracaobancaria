package br.com.anteros.integracao.bancaria.banco.layout;

import java.math.BigDecimal;
import java.util.Date;

public interface SaldoAtual {

	public BigDecimal getSaldoBloqueado();

	public Date getDataSaldoAtual();

	public BigDecimal getSaldoAtual();

	public String getDebitoCredito();

	public BigDecimal getValorTotalDebitos();

	public BigDecimal getValorTotalCreditos();
	
}
