package br.com.anteros.integracao.bancaria.banco.layout.cnab240.extrato.itau.v50;

import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.AGENCIA_CONTA_ORIGEM_LANCAMENTO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.AGENCIA_MANTENEDORA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.AGENCIA_ORIGEM_LANCAMENTO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CATEGORIA_LANCAMENTO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CD_BANCO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CD_BANCO_ORIGEM;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CD_CONVENIO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CD_LANCAMENTO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CD_SEGMENTO_REGISTRO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.DIGITO_AGENCIA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.DIGITO_AGENCIACONTA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.DIGITO_CONTACORRENTE;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.DT_CONTABIL;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.DT_LANCAMENTO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.HISTORICO_LANCAMENTO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.IDENTIFICADOR_CPMF;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.LANCAMENTO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.LT_SERVICO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NATUREZA_LANCAMENTO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NOME_EMPRESA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NR_CONTACORRENTE;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NR_DOCUMENTO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NR_INSCRICAO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NR_SEQUENCIAL_REGISTRO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.TP_COMPLEMENTO_HISTORICO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.TP_INSCRICAO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.TP_LANCAMENTO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.TP_REGISTRO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.USO_RESERVADO_BANCO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.VL_LANCAMENTO;

import java.math.BigDecimal;
import java.util.Date;

import br.com.anteros.flatfile.Record;
import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.Formats;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.annotation.RecordData;
import br.com.anteros.flatfile.language.EnumTypes;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.Lancamento;

public class ConciliacaoBancariaSegmentoE implements Lancamento, RecordData {

	@IdType(value = "E", length = 1, positionField = 5, name = CD_SEGMENTO_REGISTRO)
	private String codigoSegmentoRegistro;

	@Field(name = CD_BANCO, type = EnumTypes.INTEGER, length = 3, padding = Paddings.ZERO_LEFT)
	private Integer codigoBanco;

	@Field(name = LT_SERVICO, type = EnumTypes.INTEGER, length = 4, padding = Paddings.ZERO_LEFT)
	private Integer loteServico;

	@Field(name = TP_REGISTRO, type = EnumTypes.INTEGER, length = 1, value = "3", padding = Paddings.ZERO_LEFT)
	private Integer tipoRegistro;

	@Field(name = NR_SEQUENCIAL_REGISTRO, type = EnumTypes.INTEGER, length = 5, padding = Paddings.ZERO_LEFT)
	private Integer numeroSequencialRegistro;

	@Field(name = TP_LANCAMENTO, type = EnumTypes.INTEGER, length = 1, padding = Paddings.ZERO_LEFT)
	private Integer tipoLancamento;

	@Field(name = "BRANCOS_1", length = 2, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos1;

	@Field(name = TP_INSCRICAO, length = 1, type = EnumTypes.INTEGER)
	private Integer tipoInscricao;

	@Field(name = NR_INSCRICAO, length = 14, padding = Paddings.ZERO_LEFT)
	private String numeroInscricao;

	@Field(name = "BRANCOS_2", length = 15, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos2;

	@Field(name = CD_CONVENIO, length = 5, padding = Paddings.WHITE_SPACE_RIGHT)
	private String codigoConvenio;

	@Field(name = "ZEROS_1", length = 1, type = EnumTypes.INTEGER, value = "0")
	private Integer zeros1;

	@Field(name = AGENCIA_MANTENEDORA, length = 4, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer agenciaMantenedora;

	@Field(name = DIGITO_AGENCIA, length = 1)
	private String digitoVerificadorAgencia;

	@Field(name = "ZEROS_2", length = 7, type = EnumTypes.INTEGER, value = "0000000")
	private Integer zeros2;

	@Field(name = NR_CONTACORRENTE, length = 5, type = EnumTypes.LONG, padding = Paddings.ZERO_LEFT)
	private Long numeroContaCorrente;

	@Field(name = DIGITO_CONTACORRENTE, length = 1)
	private String digitoVerificadorContaCorrente;

	@Field(name = DIGITO_AGENCIACONTA, length = 1)
	private String digitoVerificadorAgenciaConta;

	@Field(name = NOME_EMPRESA, length = 30, padding = Paddings.WHITE_SPACE_RIGHT)
	private String nomeEmpresa;

	@Field(name = USO_RESERVADO_BANCO, length = 6, padding = Paddings.WHITE_SPACE_RIGHT)
	private String usoReservadoBanco;

	@Field(name = NATUREZA_LANCAMENTO, length = 3)
	private String naturezaLancamento;

	@Field(name = TP_COMPLEMENTO_HISTORICO, length = 2, type = EnumTypes.INTEGER)
	private Integer tipoComplementoHistorico;

	@Field(name = CD_BANCO_ORIGEM, type = EnumTypes.INTEGER, length = 3, padding = Paddings.ZERO_LEFT)
	private Integer codigoBancoOrigem;

	@Field(name = AGENCIA_ORIGEM_LANCAMENTO, type = EnumTypes.INTEGER, length = 5, padding = Paddings.ZERO_LEFT)
	private Integer agenciaOrigemLancamento;

	@Field(name = AGENCIA_CONTA_ORIGEM_LANCAMENTO, length = 12)
	private String agenciaContaOrigemLancamento;

	@Field(name = IDENTIFICADOR_CPMF, length = 1)
	private String identificadorCPMF;

	@Field(name = DT_CONTABIL, length = 8, format = Formats.DATE_DDMMYYYY, type = EnumTypes.DATE)
	private Date dataContabil;

	@Field(name = DT_LANCAMENTO, length = 8, format = Formats.DATE_DDMMYYYY, type = EnumTypes.DATE)
	private Date dataLancamento;

	@Field(name = VL_LANCAMENTO, length = 18, format = Formats.DECIMAL_DD, type = EnumTypes.BIGDECIMAL)
	private BigDecimal valorLancamento;

	@Field(name = LANCAMENTO, length = 1)
	private String lancamento;

	@Field(name = CATEGORIA_LANCAMENTO, length = 3)
	private String categoriaLancamento;

	@Field(name = CD_LANCAMENTO, length = 4, type = EnumTypes.INTEGER)
	private Integer codigoLancamento;

	@Field(name = HISTORICO_LANCAMENTO, length = 25)
	private String historicoLancamento;

	@Field(name = "BRANCOS_3", length = 33, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos3;

	@Field(name = NR_DOCUMENTO, length = 6)
	private String numeroDocumento;

	private ContaBancaria contaBancaria;

	public ConciliacaoBancariaSegmentoE(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

	public void set(Record record) {
		setCodigoBanco((Integer) record.getValue(CD_BANCO));
		setLoteServico((Integer) record.getValue(LT_SERVICO));
		setTipoInscricao((Integer) record.getValue(TP_INSCRICAO));
		setNumeroInscricao((String) record.getValue(NR_INSCRICAO));
		setCodigoConvenio((String) record.getValue(CD_CONVENIO));
		setAgenciaMantenedora((Integer) record.getValue(AGENCIA_MANTENEDORA));
		setDigitoVerificadorAgencia((String) record.getValue(DIGITO_AGENCIA));
		setNumeroContaCorrente((Long) record.getValue(NR_CONTACORRENTE));
		setDigitoVerificadorContaCorrente((String) record.getValue(DIGITO_CONTACORRENTE));
		setDigitoVerificadorAgenciaConta((String) record.getValue(DIGITO_AGENCIACONTA));
		setNomeEmpresa((String) record.getValue(NOME_EMPRESA));
		setNaturezaLancamento((String) record.getValue(NATUREZA_LANCAMENTO));
		setTipoComplementoHistorico((Integer) record.getValue(TP_COMPLEMENTO_HISTORICO));
		setIdentificadorCPMF((String) record.getValue(IDENTIFICADOR_CPMF));
		setDataContabil((Date) record.getValue(DT_CONTABIL));
		setDataLancamento((Date) record.getValue(DT_LANCAMENTO));
		setValorLancamento((BigDecimal) record.getValue(VL_LANCAMENTO));
		setCategoriaLancamento((String) record.getValue(CATEGORIA_LANCAMENTO));
		setHistoricoLancamento((String) record.getValue(HISTORICO_LANCAMENTO));
		setNumeroDocumento((String) record.getValue(NR_DOCUMENTO));
	}

	public String getCodigoSegmentoRegistro() {
		return codigoSegmentoRegistro;
	}

	public void setCodigoSegmentoRegistro(String codigoSegmentoRegistro) {
		this.codigoSegmentoRegistro = codigoSegmentoRegistro;
	}

	public Integer getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(Integer codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public Integer getLoteServico() {
		return loteServico;
	}

	public void setLoteServico(Integer loteServico) {
		this.loteServico = loteServico;
	}

	public Integer getTipoRegistro() {
		return tipoRegistro;
	}

	public void setTipoRegistro(Integer tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public Integer getTipoInscricao() {
		return tipoInscricao;
	}

	public void setTipoInscricao(Integer tipoInscricao) {
		this.tipoInscricao = tipoInscricao;
	}

	public String getNumeroInscricao() {
		return numeroInscricao;
	}

	public void setNumeroInscricao(String numeroInscricao) {
		this.numeroInscricao = numeroInscricao;
	}

	public String getCodigoConvenio() {
		return codigoConvenio;
	}

	public void setCodigoConvenio(String codigoConvenio) {
		this.codigoConvenio = codigoConvenio;
	}

	public Integer getAgenciaMantenedora() {
		return agenciaMantenedora;
	}

	public void setAgenciaMantenedora(Integer agenciaMantenedora) {
		this.agenciaMantenedora = agenciaMantenedora;
	}

	public String getDigitoVerificadorAgencia() {
		return digitoVerificadorAgencia;
	}

	public void setDigitoVerificadorAgencia(String digitoVerificadorAgencia) {
		this.digitoVerificadorAgencia = digitoVerificadorAgencia;
	}

	public Long getNumeroContaCorrente() {
		return numeroContaCorrente;
	}

	public void setNumeroContaCorrente(Long numeroContaCorrente) {
		this.numeroContaCorrente = numeroContaCorrente;
	}

	public String getDigitoVerificadorContaCorrente() {
		return digitoVerificadorContaCorrente;
	}

	public void setDigitoVerificadorContaCorrente(String digitoVerificadorContaCorrente) {
		this.digitoVerificadorContaCorrente = digitoVerificadorContaCorrente;
	}

	public String getDigitoVerificadorAgenciaConta() {
		return digitoVerificadorAgenciaConta;
	}

	public void setDigitoVerificadorAgenciaConta(String digitoVerificadorAgenciaConta) {
		this.digitoVerificadorAgenciaConta = digitoVerificadorAgenciaConta;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getNaturezaLancamento() {
		return naturezaLancamento;
	}

	public void setNaturezaLancamento(String naturezaLancamento) {
		this.naturezaLancamento = naturezaLancamento;
	}

	public Integer getTipoComplementoHistorico() {
		return tipoComplementoHistorico;
	}

	public void setTipoComplementoHistorico(Integer tipoComplementoHistorico) {
		this.tipoComplementoHistorico = tipoComplementoHistorico;
	}

	public String getIdentificadorCPMF() {
		return identificadorCPMF;
	}

	public void setIdentificadorCPMF(String identificadorCPMF) {
		this.identificadorCPMF = identificadorCPMF;
	}

	public Date getDataContabil() {
		return dataContabil;
	}

	public void setDataContabil(Date dataContabil) {
		this.dataContabil = dataContabil;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public BigDecimal getValorLancamento() {
		return valorLancamento;
	}

	public void setValorLancamento(BigDecimal valorLancamento) {
		this.valorLancamento = valorLancamento;
	}

	public String getCategoriaLancamento() {
		return categoriaLancamento;
	}

	public void setCategoriaLancamento(String categoriaLancamento) {
		this.categoriaLancamento = categoriaLancamento;
	}

	public String getHistoricoLancamento() {
		return historicoLancamento;
	}

	public void setHistoricoLancamento(String historicoLancamento) {
		this.historicoLancamento = historicoLancamento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public Integer getTipoLancamento() {
		return tipoLancamento;
	}

	public void setTipoLancamento(Integer tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

	public String getAgenciaContaOrigemLancamento() {
		return agenciaContaOrigemLancamento;
	}

	public void setAgenciaContaOrigemLancamento(String agenciaContaOrigemLancamento) {
		this.agenciaContaOrigemLancamento = agenciaContaOrigemLancamento;
	}

	public String getLancamento() {
		return lancamento;
	}

	public void setLancamento(String lancamento) {
		this.lancamento = lancamento;
	}

	public Integer getCodigoLancamento() {
		return codigoLancamento;
	}

	public void setCodigoLancamento(Integer codigoLancamento) {
		this.codigoLancamento = codigoLancamento;
	}

	public ContaBancaria getContaBancaria() {
		return contaBancaria;
	}

	public void setContaBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

	public void setNumeroSequencialRegistro(Integer numeroSequencialRegistro) {
		this.numeroSequencialRegistro = numeroSequencialRegistro;
	}

	public void setCodigoBancoOrigem(Integer codigoBancoOrigem) {
		this.codigoBancoOrigem = codigoBancoOrigem;
	}

	public void setAgenciaOrigemLancamento(Integer agenciaOrigemLancamento) {
		this.agenciaOrigemLancamento = agenciaOrigemLancamento;
	}

	public static ConciliacaoBancariaSegmentoE of(ContaBancaria contaBancaria) {
		return new ConciliacaoBancariaSegmentoE(contaBancaria);
	}

	@Override
	public int getNumberOfRecords() {
		return 0;
	}

	@Override
	public void readRowData(int row) {

	}

	@Override
	public Integer getAgenciaOrigemLancamento() {
		return null;
	}

	@Override
	public Integer getCodigoBancoOrigem() {
		return null;
	}

	@Override
	public String getCodigoSubHistorico() {
		return "";
	}

	@Override
	public Integer getNumeroSequencialRegistro() {
		return numeroSequencialRegistro;
	}

	@Override
	public String getComplementoHistorico() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDebitoCredito() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getCodigoHistorico() {
		// TODO Auto-generated method stub
		return null;
	}

}
