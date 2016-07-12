package br.com.anteros.integracao.bancaria.banco.layout;

import java.math.BigDecimal;
import java.util.Date;

public interface DetalheRetorno {

	public String getCodigoRegistro();

	public Integer getNumeroConvenio();

	public String getNossoNumero();

	public String getTipoCobranca();

	public String getTipoCobrancaEspecifico();

	public String getVariacaoCarteira();

	public BigDecimal getTaxaDesconto();

	public BigDecimal getTaxaIOF();

	public Integer getCarteira();

	public Integer getCodigoMovimentoRetorno();

	public Date getDataOcorrencia();

	public String getNumeroDocumento();

	public Date getDataVencimento();

	public BigDecimal getValorTitulo();

	public Date getDataCredito();

	public BigDecimal getValorDespesasCobranca();

	public BigDecimal getValorOutrasDespesas();

	public BigDecimal getValorIOF();

	public BigDecimal getValorAbatimento();

	public BigDecimal getValorDesconto();
	
	public BigDecimal getValorJuros();

	public BigDecimal getValorPago();

	public BigDecimal getValorOutrosCreditos();

	public BigDecimal getValorLancamento();

	public String getIndicativoDebitoCredito();

	public String getIndicadorValor();

	public Integer getNumeroSequencialRegistro();

	public String getMotivoOcorrencia1();

	public Integer getTipoInscricaoSacadoAvalista();

	public Long getNumeroInscricaoSacadoAvalista();

	public String getNomeSacadorAvalista();

	public Integer getAgenciaRecebedora();
	
	public String getDigitoAgenciaRecebedora();

	public String getMotivoOcorrencia2();
	
	public String getMotivoOcorrencia3();
	
	public String getMotivoOcorrencia4();
	
	public String getMotivoOcorrencia5();

}
