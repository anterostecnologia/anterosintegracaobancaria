package br.com.anteros.integracao.bancaria.banco.layout.cnab400.hsbc;

import java.util.Date;

import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.Formats;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.language.EnumTypes;
import br.com.anteros.integracao.bancaria.banco.layout.Carteira;
import br.com.anteros.integracao.bancaria.banco.layout.Cedente;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;

public class HeaderArquivoRemessa {
	
	@IdType(name="ID_REGISTRO", value="0", length=1, positionField=1)
	private String codigoDoRegistro;
	
	@Field(name="ID_REMESSA", length=1, value="1", type=EnumTypes.INTEGER)
	private Integer identificacaoRemessa;
	
	@Field(name="LITERAL_REMESSA", value="REMESSA", length=7)
	private String literalRemessa;
	
	@Field(name="CD_SERVICO", value="01", length=2, padding=Paddings.ZERO_LEFT, type=EnumTypes.INTEGER)
	private Integer codigoServico;
	
	@Field(name="LITERAL_SERVICO", value="COBRANCA", length=15)
	private String literalServico;
	
	
	@Field(name="CD_EMPRESA", length=20, padding=Paddings.ZERO_LEFT, type=EnumTypes.INTEGER)
	private Integer codigoEmpresa;
	
	@Field(name="NOME_EMPRESA", length=30, padding=Paddings.WHITE_SPACE_RIGHT)
	private String nomeEmpresa;
	
	@Field(name="CD_BANCO", length=3, type=EnumTypes.INTEGER, padding=Paddings.ZERO_LEFT)
	private Integer codigoBanco;
	
	@Field(name="NOME_BANCO", length=15, padding=Paddings.WHITE_SPACE_RIGHT)
	private String nomeBanco;
	
	@Field(name="DT_GRAVACAO", length=6, type=EnumTypes.DATE, format=Formats.DATE_DDMMYY, padding=Paddings.ZERO_LEFT)
	private Date dataGravacao;	
	
	@Field(name="BRANCOS1", length=8, padding=Paddings.WHITE_SPACE_RIGHT, value=" ")
	private String brancos1;
	
	@Field(name="ID_SISTEMA", length=2, value="MX")
	private String identificacaoSistema;
	
	@Field(name="NR_SEQUENCIAL_REMESSA", length=7, padding=Paddings.ZERO_LEFT, type=EnumTypes.LONG)
	private Long numeroSequencialRemessa;
	
	@Field(name="BRANCOS2", length=277, value=" ", padding=Paddings.WHITE_SPACE_RIGHT)
	private String brancos2;
	
	@Field(name="NR_SEQUENCIAL_REGISTRO", length=6, padding=Paddings.ZERO_LEFT, type=EnumTypes.INTEGER)
	private Integer numeroSequencialRegistro;
	

	public HeaderArquivoRemessa(ContaBancaria contaBancaria, Carteira carteira, Cedente cedente, Date dataGravacao, Date dataHoraGeracao) {
		this.codigoEmpresa = Integer.valueOf(carteira.getCodigoConvenio());
		this.nomeEmpresa = cedente.getNome();
		this.codigoBanco = contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo();
		this.nomeBanco = contaBancaria.getBanco().getNomeFantasia();
		this.nomeEmpresa = cedente.getNome();
		this.dataGravacao = dataGravacao;
		this.numeroSequencialRemessa = 1L;
		this.numeroSequencialRegistro = 1;
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

	public static HeaderArquivoRemessa of(ContaBancaria contaBancaria, Carteira carteira, Cedente cedente, Date dataHoraGeracao, Date dataGravacao) {
		return new HeaderArquivoRemessa(contaBancaria,carteira,cedente, dataHoraGeracao, dataGravacao);
	}

	public Integer getCodigoEmpresa() {
		return codigoEmpresa;
	}

	public void setCodigoEmpresa(Integer codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}

	public String getIdentificacaoSistema() {
		return identificacaoSistema;
	}

	public void setIdentificacaoSistema(String identificacaoSistema) {
		this.identificacaoSistema = identificacaoSistema;
	}
	
	
}
