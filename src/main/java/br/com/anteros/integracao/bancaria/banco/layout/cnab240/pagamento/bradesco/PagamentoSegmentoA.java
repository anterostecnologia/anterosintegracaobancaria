package br.com.anteros.integracao.bancaria.banco.layout.cnab240.pagamento.bradesco;

import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.AGENCIA_MANTENEDORA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.BRANCOS_1;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.BRANCOS_2;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CD_BANCO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CD_BANCO_FAVORECIDO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CD_CAMARA_CENTRALIZADORA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CD_MOEDA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CD_MOVIMENTO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CD_OCORRENCIA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CD_SEGMENTO_REGISTRO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.DIGITO_VERFICADOR_AGENCIACONTA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.DIGITO_VERIFICADOR_AGENCIA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.DIGITO_VERIFICADOR_CONTACORRENTE;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.DT_EFETIVACAO_PAGAMENTO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.DT_PAGAMENTO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.FINALIDADE_PAGAMENTO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.FINALIDADE_TED;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.IDENTIFICADOR_TITULO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.IDENTIFICADOR_TITULO_BANCO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.LT_SERVICO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NOME;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NR_AVISO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NR_CONTACORRENTE;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NR_SEQUENCIA_REGISTRO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.QT_MOEDA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.TP_MOVIMENTO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.TP_REGISTRO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.TP_SERVICO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.VL_EFETIVACAO_PAGAMENTO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.VL_PAGAMENTO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.Formats;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.annotation.RecordData;
import br.com.anteros.flatfile.language.EnumTypes;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.RemessaPagamento;

public class PagamentoSegmentoA implements RecordData {

	@IdType(name = CD_SEGMENTO_REGISTRO, length = 1, positionField = 5, value = "A")
	private String codigoSegmentoRegistro;

	@Field(name = CD_BANCO, length = 3, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoBanco;

	@Field(name = LT_SERVICO, length = 4, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer loteServico;

	@Field(name = TP_REGISTRO, length = 1, type = EnumTypes.INTEGER, value = "3", padding = Paddings.ZERO_LEFT)
	private Integer tipoRegistro;

	@Field(name = NR_SEQUENCIA_REGISTRO, length = 5, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer numeroSequencialRegistro;

	@Field(name = TP_MOVIMENTO, length = 1, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer tipoMovimento;

	@Field(name = CD_MOVIMENTO, length = 2, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoMovimento;

	@Field(name = CD_CAMARA_CENTRALIZADORA, length = 3, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoCamaraCentralizadora;

	@Field(name = CD_BANCO_FAVORECIDO, length = 3, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoBancoFavorecido;

	@Field(name = AGENCIA_MANTENEDORA, type = EnumTypes.INTEGER, length = 5, padding = Paddings.ZERO_LEFT)
	private Integer agenciaMantenedora;

	@Field(name = DIGITO_VERIFICADOR_AGENCIA, length = 1)
	private String digitoVerificadorAgencia;

	@Field(name = NR_CONTACORRENTE, length = 12, type = EnumTypes.LONG, padding = Paddings.ZERO_LEFT)
	private Long numeroContaCorrente;

	@Field(name = DIGITO_VERIFICADOR_CONTACORRENTE, length = 1)
	private String DigitoVerificadorContaCorrente;

	@Field(name = DIGITO_VERFICADOR_AGENCIACONTA, length = 1, padding = Paddings.WHITE_SPACE_RIGHT, value = " ")
	private String digitoVerificadorAgenciaConta;

	@Field(name = NOME, length = 30, padding = Paddings.WHITE_SPACE_RIGHT)
	private String nomeFavorecido;

	@Field(name = IDENTIFICADOR_TITULO, length = 20, padding = Paddings.WHITE_SPACE_RIGHT)
	private String identificadorTituloEmpresa;

	@Field(name = DT_PAGAMENTO, length = 8, type = EnumTypes.DATE, padding = Paddings.ZERO_LEFT, format = Formats.DATE_DDMMYYYY)
	private Date dtPagamentoTitulo;

	@Field(name = CD_MOEDA, length = 3, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoMoeda;

	@Field(name = QT_MOEDA, length = 15, type = EnumTypes.BIGDECIMAL, padding = Paddings.ZERO_LEFT, format = Formats.DECIMAL_DDDDD)
	private BigDecimal quantidadeMoeda;

	@Field(name = VL_PAGAMENTO, length = 15, type = EnumTypes.BIGDECIMAL, padding = Paddings.ZERO_LEFT, format = Formats.DECIMAL_DD)
	private BigDecimal vlPagamento;

	@Field(name = IDENTIFICADOR_TITULO_BANCO, length = 20, padding = Paddings.WHITE_SPACE_RIGHT)
	private String identificadorTituloBanco;

	@Field(name = DT_EFETIVACAO_PAGAMENTO, length = 8, type = EnumTypes.DATE, padding = Paddings.ZERO_LEFT, format = Formats.DATE_DDMMYYYY)
	private Date dtRealEfetivacaoPagamento;

	@Field(name = VL_EFETIVACAO_PAGAMENTO, length = 15, type = EnumTypes.BIGDECIMAL, padding = Paddings.ZERO_LEFT, format = Formats.DECIMAL_DD)
	private BigDecimal vlEfetivacaoPagamento;

	@Field(name = BRANCOS_1, value = " ", padding = Paddings.WHITE_SPACE_RIGHT, length = 40)
	private String brancos1;

	@Field(name = TP_SERVICO, length = 2, padding = Paddings.WHITE_SPACE_RIGHT)
	private String tipoServico;

	@Field(name = FINALIDADE_TED, length = 5, padding = Paddings.WHITE_SPACE_RIGHT)
	private String finalidadeTed;

	@Field(name = FINALIDADE_PAGAMENTO, length = 2, padding = Paddings.WHITE_SPACE_RIGHT)
	private String finalidadePagamento;

	@Field(name = BRANCOS_2, value = " ", padding = Paddings.WHITE_SPACE_RIGHT, length = 3)
	private String brancos2;

	@Field(name = NR_AVISO, length = 1, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer avisoFavorecido;

	@Field(name = CD_OCORRENCIA, length = 10, padding = Paddings.WHITE_SPACE_RIGHT)
	private String codOcorrencia;

	private List<RemessaPagamento> remessas;

	private ContaBancaria contaBancaria;

	public PagamentoSegmentoA(ContaBancaria contaBancaria, List<RemessaPagamento> remessas) {
		this.remessas = remessas;
		this.contaBancaria = contaBancaria;
	}

	public int getNumberOfRecords() {
		return remessas.size();
	}

	@Override
	public void readRowData(int row, int sequence) {
		this.codigoBanco = contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo(); //G001
		this.loteServico = 1; //G002
		this.numeroSequencialRegistro = sequence;//G038
		this.agenciaMantenedora = contaBancaria.getAgencia().getCodigo();//G008
		this.digitoVerificadorAgencia = contaBancaria.getAgencia().getDigitoVerificador();//G009
		this.numeroContaCorrente = contaBancaria.getNumeroDaConta().getCodigoDaConta();//G010
		this.DigitoVerificadorContaCorrente = contaBancaria.getNumeroDaConta().getDigitoDaConta();//G011
		this.codigoMoeda = remessas.get(row).getTitulo().getTipoMoeda().getCodigo();//G065
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

	public Integer getNumeroSequencialRegistro() {
		return numeroSequencialRegistro;
	}

	public void setNumeroSequencialRegistro(Integer numeroSequencialRegistro) {
		this.numeroSequencialRegistro = numeroSequencialRegistro;
	}

	public Integer getTipoMovimento() {
		return tipoMovimento;
	}

	public void setTipoMovimento(Integer tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}

	public Integer getCodigoMovimento() {
		return codigoMovimento;
	}

	public void setCodigoMovimento(Integer codigoMovimento) {
		this.codigoMovimento = codigoMovimento;
	}

	public Integer getCodigoCamaraCentralizadora() {
		return codigoCamaraCentralizadora;
	}

	public void setCodigoCamaraCentralizadora(Integer codigoCamaraCentralizadora) {
		this.codigoCamaraCentralizadora = codigoCamaraCentralizadora;
	}

	public Integer getCodigoBancoFavorecido() {
		return codigoBancoFavorecido;
	}

	public void setCodigoBancoFavorecido(Integer codigoBancoFavorecido) {
		this.codigoBancoFavorecido = codigoBancoFavorecido;
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
		return DigitoVerificadorContaCorrente;
	}

	public void setDigitoVerificadorContaCorrente(String digitoVerificadorContaCorrente) {
		DigitoVerificadorContaCorrente = digitoVerificadorContaCorrente;
	}

	public String getDigitoVerificadorAgenciaConta() {
		return digitoVerificadorAgenciaConta;
	}

	public void setDigitoVerificadorAgenciaConta(String digitoVerificadorAgenciaConta) {
		this.digitoVerificadorAgenciaConta = digitoVerificadorAgenciaConta;
	}

	public String getNomeFavorecido() {
		return nomeFavorecido;
	}

	public void setNomeFavorecido(String nomeFavorecido) {
		this.nomeFavorecido = nomeFavorecido;
	}

	public String getIdentificadorTituloEmpresa() {
		return identificadorTituloEmpresa;
	}

	public void setIdentificadorTituloEmpresa(String identificadorTituloEmpresa) {
		this.identificadorTituloEmpresa = identificadorTituloEmpresa;
	}

	public Date getDtPagamentoTitulo() {
		return dtPagamentoTitulo;
	}

	public void setDtPagamentoTitulo(Date dtPagamentoTitulo) {
		this.dtPagamentoTitulo = dtPagamentoTitulo;
	}

	public Integer getCodigoMoeda() {
		return codigoMoeda;
	}

	public void setCodigoMoeda(Integer codigoMoeda) {
		this.codigoMoeda = codigoMoeda;
	}

	public BigDecimal getQuantidadeMoeda() {
		return quantidadeMoeda;
	}

	public void setQuantidadeMoeda(BigDecimal quantidadeMoeda) {
		this.quantidadeMoeda = quantidadeMoeda;
	}

	public BigDecimal getVlPagamento() {
		return vlPagamento;
	}

	public void setVlPagamento(BigDecimal vlPagamento) {
		this.vlPagamento = vlPagamento;
	}

	public String getIdentificadorTituloBanco() {
		return identificadorTituloBanco;
	}

	public void setIdentificadorTituloBanco(String identificadorTituloBanco) {
		this.identificadorTituloBanco = identificadorTituloBanco;
	}

	public Date getDtRealEfetivacaoPagamento() {
		return dtRealEfetivacaoPagamento;
	}

	public void setDtRealEfetivacaoPagamento(Date dtRealEfetivacaoPagamento) {
		this.dtRealEfetivacaoPagamento = dtRealEfetivacaoPagamento;
	}

	public BigDecimal getVlEfetivacaoPagamento() {
		return vlEfetivacaoPagamento;
	}

	public void setVlEfetivacaoPagamento(BigDecimal vlEfetivacaoPagamento) {
		this.vlEfetivacaoPagamento = vlEfetivacaoPagamento;
	}

	public String getBrancos1() {
		return brancos1;
	}

	public void setBrancos1(String brancos1) {
		this.brancos1 = brancos1;
	}

	public String getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}

	public String getFinalidadeTed() {
		return finalidadeTed;
	}

	public void setFinalidadeTed(String finalidadeTed) {
		this.finalidadeTed = finalidadeTed;
	}

	public String getFinalidadePagamento() {
		return finalidadePagamento;
	}

	public void setFinalidadePagamento(String finalidadePagamento) {
		this.finalidadePagamento = finalidadePagamento;
	}

	public String getBrancos2() {
		return brancos2;
	}

	public void setBrancos2(String brancos2) {
		this.brancos2 = brancos2;
	}

	public Integer getAvisoFavorecido() {
		return avisoFavorecido;
	}

	public void setAvisoFavorecido(Integer avisoFavorecido) {
		this.avisoFavorecido = avisoFavorecido;
	}

	public String getCodOcorrencia() {
		return codOcorrencia;
	}

	public void setCodOcorrencia(String codOcorrencia) {
		this.codOcorrencia = codOcorrencia;
	}

	public List<RemessaPagamento> getRemessas() {
		return remessas;
	}

	public void setRemessas(List<RemessaPagamento> remessas) {
		this.remessas = remessas;
	}

	public ContaBancaria getContaBancaria() {
		return contaBancaria;
	}

	public void setContaBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

	public static PagamentoSegmentoA of(ContaBancaria contaBancaria, List<RemessaPagamento> remessas) {
		return new PagamentoSegmentoA(contaBancaria, remessas);
	}

	public void set(br.com.anteros.flatfile.Record record) {

	}

}
