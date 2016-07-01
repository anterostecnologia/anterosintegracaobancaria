package br.com.anteros.integracao.bancaria.banco.febraban.cnab400.caixa;

import java.util.Date;

import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.Formats;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.language.EnumTypes;
import br.com.anteros.integracao.bancaria.banco.febraban.Carteira;
import br.com.anteros.integracao.bancaria.banco.febraban.Cedente;
import br.com.anteros.integracao.bancaria.banco.febraban.ContaBancaria;

public class HeaderArquivoRemessa {
	
	@IdType(name="ID_REGISTRO", value="0", length=1, positionField=1)
	private String codigoDoRegistro;
	
	@Field(name="ID_REMESSA", length=1, value="1", type=EnumTypes.INTEGER)
	private Integer identificacaoRemessa;
	
	@Field(name="LITERAL_REMESSA", value="REMESSA", length=7)
	private String literalRemessa;
	
	@Field(name="CD_SERVICO", value="01", length=2, padding=Paddings.ZERO_LEFT, type=EnumTypes.INTEGER)
	private Integer codigoServico;
	
	@Field(name="LITERAL_SERVICO", value="COBRANCA", length=8)
	private String literalServico;
	
	@Field(name="BRANCOS1", length=7, padding=Paddings.WHITE_SPACE_RIGHT, value=" ")
	private String brancos1;
	
	@Field(name="PREFIXO_AGENCIA", length=9, type=EnumTypes.INTEGER, padding=Paddings.ZERO_LEFT)
	private Integer prefixoAgencia;
	
	@Field(name="DIGITO_AGENCIA", length=1)
	private String digitoVerificadoraAgencia;
	
	@Field(name="NR_CONTACORRENTE", length=8, type=EnumTypes.INTEGER, padding=Paddings.ZERO_LEFT)
	private Integer numeroContaCorrente;
	
	@Field(name="DIGITO_CONTACORRENTE", length=1)
	private String digitoContaCorrente;
	
	@Field(name="COMPLEMENTO_REGISTRO", value="000000", length=6, padding=Paddings.ZERO_LEFT)
	private Integer complementoRegistro;
	
	@Field(name="NOME_EMPRESA", length=30, padding=Paddings.WHITE_SPACE_RIGHT)
	private String nomeEmpresa;
	
	@Field(name="CD_BANCO", length=3, type=EnumTypes.INTEGER, padding=Paddings.ZERO_LEFT)
	private Integer codigoBanco;
	
	@Field(name="NOME_BANCO", length=15, padding=Paddings.WHITE_SPACE_RIGHT)
	private String nomeBanco;
	
	@Field(name="DT_GRAVACAO", length=6, type=EnumTypes.DATE, format=Formats.DATE_DDMMYY, padding=Paddings.ZERO_LEFT)
	private Date dataGravacao;
	
	@Field(name="NR_SEQUENCIAL_REMESSA", length=7, padding=Paddings.ZERO_LEFT, type=EnumTypes.LONG)
	private Long numeroSequencialRemessa;
	
	@Field(name="BRANCOS2", length=287, value=" ", padding=Paddings.WHITE_SPACE_RIGHT)
	private String brancos2;

	@Field(name="NR_SEQUENCIAL_REGISTRO", length=6, padding=Paddings.ZERO_LEFT, type=EnumTypes.INTEGER)
	private Integer numeroSequencialRegistro;

	public HeaderArquivoRemessa(ContaBancaria contaBancaria, Carteira carteira, Cedente cedente) {
		
	}

	public String getCodigoDoRegistro() {
		return codigoDoRegistro;
	}

	public void setCodigoDoRegistro(String codigoDoRegistro) {
		this.codigoDoRegistro = codigoDoRegistro;
	}

	public Integer getIdentificacaoRemessa() {
		return identificacaoRemessa;
	}

	public void setIdentificacaoRemessa(Integer identificacaoRemessa) {
		this.identificacaoRemessa = identificacaoRemessa;
	}

	public String getLiteralRemessa() {
		return literalRemessa;
	}

	public void setLiteralRemessa(String literalRemessa) {
		this.literalRemessa = literalRemessa;
	}

	public Integer getCodigoServico() {
		return codigoServico;
	}

	public void setCodigoServico(Integer codigoServico) {
		this.codigoServico = codigoServico;
	}

	public String getLiteralServico() {
		return literalServico;
	}

	public void setLiteralServico(String literalServico) {
		this.literalServico = literalServico;
	}

	public String getBrancos1() {
		return brancos1;
	}

	public void setBrancos1(String brancos1) {
		this.brancos1 = brancos1;
	}

	public Integer getPrefixoAgencia() {
		return prefixoAgencia;
	}

	public void setPrefixoAgencia(Integer prefixoAgencia) {
		this.prefixoAgencia = prefixoAgencia;
	}

	public String getDigitoVerificadoraAgencia() {
		return digitoVerificadoraAgencia;
	}

	public void setDigitoVerificadoraAgencia(String digitoVerificadoraAgencia) {
		this.digitoVerificadoraAgencia = digitoVerificadoraAgencia;
	}

	public Integer getNumeroContaCorrente() {
		return numeroContaCorrente;
	}

	public void setNumeroContaCorrente(Integer numeroContaCorrente) {
		this.numeroContaCorrente = numeroContaCorrente;
	}

	public String getDigitoContaCorrente() {
		return digitoContaCorrente;
	}

	public void setDigitoContaCorrente(String digitoContaCorrente) {
		this.digitoContaCorrente = digitoContaCorrente;
	}

	public Integer getComplementoRegistro() {
		return complementoRegistro;
	}

	public void setComplementoRegistro(Integer complementoRegistro) {
		this.complementoRegistro = complementoRegistro;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public Integer getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(Integer codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

	public Date getDataGravacao() {
		return dataGravacao;
	}

	public void setDataGravacao(Date dataGravacao) {
		this.dataGravacao = dataGravacao;
	}

	public Long getNumeroSequencialRemessa() {
		return numeroSequencialRemessa;
	}

	public void setNumeroSequencialRemessa(Long numeroSequencialRemessa) {
		this.numeroSequencialRemessa = numeroSequencialRemessa;
	}

	public String getBrancos2() {
		return brancos2;
	}

	public void setBrancos2(String brancos2) {
		this.brancos2 = brancos2;
	}

	public Integer getNumeroSequencialRegistro() {
		return numeroSequencialRegistro;
	}

	public void setNumeroSequencialRegistro(Integer numeroSequencialRegistro) {
		this.numeroSequencialRegistro = numeroSequencialRegistro;
	}

	public static HeaderArquivoRemessa of(ContaBancaria contaBancaria, Carteira carteira, Cedente cedente) {
		return new HeaderArquivoRemessa(contaBancaria,carteira,cedente);
	}
	
	
}
