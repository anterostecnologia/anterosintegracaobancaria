package br.com.anteros.integracao.bancaria.banco.layout;

import java.math.BigDecimal;
import java.util.Date;

public interface Lancamento {

	public String getNaturezaLancamento();
	
	public Integer getTipoComplementoHistorico();
	
    public String getComplementoHistorico();
	
	public String getIdentificadorCPMF();
	
	public Date getDataContabil();
	
	public Date getDataLancamento();

	public BigDecimal getValorLancamento();
	
	public String getDebitoCredito();
	
	public String getCategoriaLancamento();
	
	public Integer getCodigoHistorico();
	
	public String getHistoricoLancamento();
	
	public String getNumeroDocumento();
	
	public Integer getAgenciaOrigemLancamento();

	public Integer getCodigoBancoOrigem();

	public String getCodigoSubHistorico();

	public Integer getNumeroSequencialRegistro();
	
}
