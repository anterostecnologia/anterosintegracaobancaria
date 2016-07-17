package br.com.anteros.integracao.bancaria.banco.layout;

import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.AGENCIA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.AGENCIA_ORIGEM_LANCAMENTO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CATEGORIA_LANCAMENTO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CD_BANCO_ORIGEM;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CD_HISTORICO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CD_REGISTRO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CD_SUBHISTORICO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.DIGITO_CONTA_CORRENTE;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.DT_CONTABIL;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.DT_LANCAMENTO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.HISTORICO_LANCAMENTO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.IDENTIFICADOR_CPMF;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.ID_TIPOREGISTRO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NR_CONTACORRENTE;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NR_DOCUMENTO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NR_INSCRICAO_EMPRESA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NR_LOTE;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NR_SEQUENCIAL_REGISTRO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.TP_TIPO_INSCRICAO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.VL_LANCAMENTO;

import java.math.BigDecimal;
import java.util.Date;

import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.Formats;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.language.EnumTypes;

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
