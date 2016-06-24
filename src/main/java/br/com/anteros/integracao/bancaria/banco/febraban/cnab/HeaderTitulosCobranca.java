package br.com.anteros.integracao.bancaria.banco.febraban.cnab;

import java.util.Date;

import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.Formats;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.language.EnumTypes;
import br.com.anteros.integracao.bancaria.banco.febraban.Carteira;
import br.com.anteros.integracao.bancaria.banco.febraban.Cedente;
import br.com.anteros.integracao.bancaria.banco.febraban.ContaBancaria;

public class HeaderTitulosCobranca {

	@IdType(name = "TP_REGISTRO", length = 1, position = 3, value = "1")
	private String tipoRegistro;

	@Field(name = "CD_BANCO", length = 3, value = "1", padding = Paddings.ZERO_LEFT)
	private Integer codigoBanco;

	@Field(name = "LT_SERVICO", length = 4, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer loteServico;

	@Field(name = "TP_OPERACAO", length = 1, value = "R")
	private String tipoOperacao;

	@Field(name = "TP_SERVICO", length = 2, value = "01", padding = Paddings.ZERO_LEFT)
	private Integer tipoServico;

	@Field(name = "BRANCOS1", length = 2, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos1;

	@Field(name = "LAYOUT_LOTE", length = 3, value = "045", type = EnumTypes.INTEGER)
	private String layoutLote;

	@Field(name = "BRANCOS2", length = 1, value = " ")
	private String brancos2;

	@Field(name = "TP_INSCRICAO", length = 1, type = EnumTypes.INTEGER)
	private Integer tipoInscricao;

	@Field(name = "NR_INSCRICAO", length = 15, type = EnumTypes.LONG)
	private Long numeroInscricao;

	@Field(name = "CD_CONVENIO", length = 20, padding = Paddings.WHITE_SPACE_RIGHT)
	private String codigoConvenio;

	@Field(name = "AGENCIA_MANTENEDORA", length = 5, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer agenciaMantenedora;

	@Field(name = "DIGITO_AGENCIA", length = 1)
	private String digitoVerificadorAgencia;

	@Field(name = "NR_CONTACORRENTE", length = 12, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer numeroContaCorrente;

	@Field(name = "DIGITO_CONTACORRENTE", length = 1)
	private String digitoVerificadorContaCorrente;

	@Field(name = "DIGITO_AGENCIACONTA", length = 1)
	private String digitoVerificadorAgenciaConta;

	@Field(name = "NOME_EMPRESA", length = 30, padding = Paddings.WHITE_SPACE_RIGHT)
	private String nomeEmpresa;

	@Field(name = "MENSAGEM1", length = 40, padding = Paddings.WHITE_SPACE_RIGHT, value=" ")
	private String mensagem1;

	@Field(name = "MENSAGEM1", length = 40, padding = Paddings.WHITE_SPACE_RIGHT, value=" ")
	private String mensagem2;

	@Field(name = "NR_REMESSA_RETORNO", length = 8, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer numeroRemessaRetorno;

	@Field(name = "DT_GRAVACAO", length = 8, type = EnumTypes.DATE, format = Formats.DATE_DDMMYYYY)
	private Date dataGravacao;

	@Field(name = "DT_CREDITO", length = 8, type = EnumTypes.DATE, format = Formats.DATE_DDMMYYYY)
	private Date dataCredito;

	@Field(name = "BRANCOS3", length = 33, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos3;

	public HeaderTitulosCobranca(ContaBancaria contaBancaria, Carteira carteira, Cedente cedente) {
		this.codigoBanco = contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo();// G001
		this.loteServico = 1;//G002		
		this.tipoInscricao = (cedente.getCPRF().isFisica() ? 1 : 2); // G005
		this.numeroInscricao = cedente.getCPRF().getCodigo(); // G006
		this.codigoConvenio = carteira.getCodigoConvenio();// G007
		this.agenciaMantenedora = contaBancaria.getAgencia().getCodigo();// G008
		this.digitoVerificadorAgencia = contaBancaria.getAgencia().getDigitoVerificador();// G009
		this.numeroContaCorrente = contaBancaria.getNumeroDaConta().getCodigoDaConta();// G010
		this.digitoVerificadorContaCorrente = contaBancaria.getNumeroDaConta().getDigitoDaConta();// G011
		this.digitoVerificadorAgenciaConta = contaBancaria.getAgencia().getDigitoVerificador();// G012
		this.nomeEmpresa = cedente.getNome();// G013
		this.numeroRemessaRetorno = 1; //G079
		this.dataGravacao = new Date();// G068
	}

	public static HeaderTitulosCobranca of(ContaBancaria contaBancaria, Carteira carteira, Cedente cedente) {
		return new HeaderTitulosCobranca(contaBancaria, carteira, cedente);
	}

	public String getTipoRegistro() {
		return tipoRegistro;
	}

	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
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

	public String getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(String tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	public Integer getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(Integer tipoServico) {
		this.tipoServico = tipoServico;
	}

	public String getBrancos1() {
		return brancos1;
	}

	public void setBrancos1(String brancos1) {
		this.brancos1 = brancos1;
	}

	public String getLayoutLote() {
		return layoutLote;
	}

	public void setLayoutLote(String layoutLote) {
		this.layoutLote = layoutLote;
	}

	public String getBrancos2() {
		return brancos2;
	}

	public void setBrancos2(String brancos2) {
		this.brancos2 = brancos2;
	}

	public Integer getTipoInscricao() {
		return tipoInscricao;
	}

	public void setTipoInscricao(Integer tipoInscricao) {
		this.tipoInscricao = tipoInscricao;
	}

	public Long getNumeroInscricao() {
		return numeroInscricao;
	}

	public void setNumeroInscricao(Long numeroInscricao) {
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

	public Integer getNumeroContaCorrente() {
		return numeroContaCorrente;
	}

	public void setNumeroContaCorrente(Integer numeroContaCorrente) {
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

	public String getMensagem1() {
		return mensagem1;
	}

	public void setMensagem1(String mensagem1) {
		this.mensagem1 = mensagem1;
	}

	public String getMensagem2() {
		return mensagem2;
	}

	public void setMensagem2(String mensagem2) {
		this.mensagem2 = mensagem2;
	}

	public Integer getNumeroRemessaRetorno() {
		return numeroRemessaRetorno;
	}

	public void setNumeroRemessaRetorno(Integer numeroRemessaRetorno) {
		this.numeroRemessaRetorno = numeroRemessaRetorno;
	}

	public Date getDataGravacao() {
		return dataGravacao;
	}

	public void setDataGravacao(Date dataGravacao) {
		this.dataGravacao = dataGravacao;
	}

	public Date getDataCredito() {
		return dataCredito;
	}

	public void setDataCredito(Date dataCredito) {
		this.dataCredito = dataCredito;
	}

	public String getBrancos3() {
		return brancos3;
	}

	public void setBrancos3(String brancos3) {
		this.brancos3 = brancos3;
	}

}
