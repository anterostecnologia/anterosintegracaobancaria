package br.com.anteros.integracao.bancaria.banco.layout.cnab400.cobranca.hsbc;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.Formats;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.language.EnumTypes;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.RemessaCobranca;

public class TitulosCobrancaDetalheRemessa {

	@IdType(name="CD_REGISTRO", length=1, value="1", positionField=1)
	private Integer codigoRegistro;
		
	@Field(name="AGENCIA_DEBITO", length=5, value="0", type=EnumTypes.INTEGER, padding=Paddings.ZERO_LEFT)
	private Integer agenciaDebito;
	
	@Field(name="DIGITO_AGENCIA_DEBITO", length=1, value=" ")
	private String digitoAgenciaDebito;
	
	@Field(name="RAZAO_CONTA_DEBITO", length=5, value="0", padding=Paddings.ZERO_LEFT)
	private Integer RazaoSocialContaDebito;
	
	@Field(name="CONTA_CORRENTE_DEBITO", length=7, value="0", padding=Paddings.ZERO_LEFT)
	private Integer contaCorrenteDebito;
	
	@Field(name="DIGITO_CONTA_DEBITO", length=1, value=" ")
	private String digitoContaCorrenteDebito;
	
	@Field(name="ZEROS1", value="0", length=1)
	private String zeros1;
	
	@Field(name="CARTEIRA", length=3, type=EnumTypes.INTEGER, padding=Paddings.ZERO_LEFT)
	private Integer carteira;
	
	@Field(name="AGENCIA", length=5, padding=Paddings.ZERO_LEFT, type=EnumTypes.INTEGER)
	private Integer agencia;
	
	@Field(name="NR_CONTACORRENTE", length=7, padding=Paddings.ZERO_LEFT, type=EnumTypes.LONG)
	private Long numeroContaCorrente;
	
	@Field(name="DIGITO_CONTACORRENTE", length=1)
	private String digitoContaCorrente;
	
	@Field(name="BRANCOS1", length=25, value=" ", padding=Paddings.WHITE_SPACE_RIGHT)
	private String brancos1;
	
	@Field(name="CD_BANCO", length=3, padding=Paddings.ZERO_LEFT, type=EnumTypes.INTEGER)
	private Integer codigoBanco;
	
	@Field(name="CD_MULTA", length=1, type=EnumTypes.INTEGER)
	private Integer codigoMulta;
	
    @Field(name="PC_MULTA", length=4, type=EnumTypes.BIGDECIMAL, padding=Paddings.ZERO_LEFT)
	private BigDecimal percentualMulta;
    
    @Field(name="NOSSO_NUMERO", length=11, padding=Paddings.ZERO_LEFT)
	private Long nossoNumero;
	
    @Field(name="DIGITO_NOSSO_NUMERO", length=1)
	private String digitoNossoNumero;
    
    @Field(name="VL_DESCONTO_BONIFICACAO_DIA", length=10, type=EnumTypes.BIGDECIMAL, format=Formats.DECIMAL_DD, padding=Paddings.ZERO_LEFT)
	private BigDecimal valorDescontoBonificacaoDia;
    
    @Field(name="INDICADOR_RATEIO_CREDITO", length=1, value="R")
    private String indicadorRateioCredito;
    
    @Field(name="BRANCOS2", length=3, value=" ")
    private String brancos2;
    
    @Field(name="CD_OCORRENCIA", length=2, type=EnumTypes.INTEGER, value="1", padding=Paddings.ZERO_LEFT )
	private Integer codigoOcorrencia;
    
    @Field(name="NR_DOCUMENTO", length=10, padding=Paddings.WHITE_SPACE_RIGHT)
	private String numeroDocumento;
    
    @Field(name="DT_VENCIMENTO", length=6, type=EnumTypes.DATE, format=Formats.DATE_DDMMYY, padding=Paddings.ZERO_LEFT)
	private Date dataVencimento;
    
    @Field(name="VL_TITULO", length=13, type=EnumTypes.BIGDECIMAL, format=Formats.DECIMAL_DD, padding=Paddings.ZERO_LEFT)
	private BigDecimal valorNominalTitulo;
    
    @Field(name="ZEROS2", value="0", length=5, padding=Paddings.ZERO_LEFT)
	private String zeros2;
    
    @Field(name="ESPECIE_TITULO", length=2, padding=Paddings.ZERO_LEFT)
	private Integer especieTitulo;
    
    @Field(name="ACEITE", length=1, value="N")
	private String aceite;
    
    @Field(name="DT_EMISSAO", length=6, type=EnumTypes.DATE, format=Formats.DATE_DDMMYY, padding=Paddings.ZERO_LEFT)
	private Date dataEmissao;
    
    @Field(name="PRIMEIRA_INSTRUCAO", length=2, padding=Paddings.ZERO_LEFT, type=EnumTypes.INTEGER)
	private Integer primeiraInstrucao;
	
	@Field(name="SEGUNDA_INSTRUCAO", length=2, padding=Paddings.ZERO_LEFT, type=EnumTypes.INTEGER)
	private Integer segundaInstrucao;
    
	@Field(name="VL_JUROS", length=13, type=EnumTypes.BIGDECIMAL, format=Formats.DECIMAL_DD, padding=Paddings.ZERO_LEFT)
	private BigDecimal valorJuros;
	
	@Field(name="DT_DESCONTO", length=6, type=EnumTypes.DATE, padding=Paddings.ZERO_LEFT, format=Formats.DATE_DDMMYY)
	private Date dataDesconto;
	
	@Field(name="VL_DESCONTO", length=13, type=EnumTypes.BIGDECIMAL, format=Formats.DECIMAL_DD, padding=Paddings.ZERO_LEFT)
	private BigDecimal valorDesconto;
	
	@Field(name="VL_IOF", length=13, type=EnumTypes.BIGDECIMAL, format=Formats.DECIMAL_DD, padding=Paddings.ZERO_LEFT)
	private BigDecimal valorIOF;
	
	@Field(name="VL_ABATIMENTO", length=13, type=EnumTypes.BIGDECIMAL, format=Formats.DECIMAL_DD, padding=Paddings.ZERO_LEFT)
	private BigDecimal valorAbatimento;
    
	@Field(name="TP_SACADO", length=2, type=EnumTypes.INTEGER, padding=Paddings.ZERO_LEFT)
	private Integer tipoSacado;
	
	@Field(name="NR_INSCRICAO_SACADO", length=14, type=EnumTypes.LONG, padding=Paddings.ZERO_LEFT)
	private Long numeroInscricaoSacado;
	
	@Field(name="NOME_SACADO", length=40, padding=Paddings.WHITE_SPACE_RIGHT)
	private String nomeSacado;
	
	@Field(name="ENDERECO_SACADO", length=40, padding=Paddings.WHITE_SPACE_RIGHT)
	private String enderecoSacado;
	
	@Field(name="BRANCOS3", length=12, value=" ")
	private String brancos3;
	
	@Field(name="CEP_SACADO", length=8, type=EnumTypes.INTEGER, padding=Paddings.ZERO_LEFT)
	private Integer cepSacado;
	
	@Field(name="SACADOR_AVALISTA", length=60, padding=Paddings.WHITE_SPACE_RIGHT)
	private String sacadorAvalista;
	
	@Field(name="NR_SEQUENCIAL_REGISTRO", length=6, type=EnumTypes.INTEGER, padding=Paddings.ZERO_LEFT)
	private Integer numeroSequencialRegistro;

	public TitulosCobrancaDetalheRemessa(ContaBancaria contaBancaria, List<RemessaCobranca> remessas) {

	}

	public Integer getCodigoRegistro() {
		return codigoRegistro;
	}

	public void setCodigoRegistro(Integer codigoRegistro) {
		this.codigoRegistro = codigoRegistro;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public Long getNumeroContaCorrente() {
		return numeroContaCorrente;
	}

	public void setNumeroContaCorrente(Long numeroContaCorrente) {
		this.numeroContaCorrente = numeroContaCorrente;
	}

	public String getDigitoContaCorrente() {
		return digitoContaCorrente;
	}

	public void setDigitoContaCorrente(String digitoContaCorrente) {
		this.digitoContaCorrente = digitoContaCorrente;
	}

	public Long getNossoNumero() {
		return nossoNumero;
	}

	public void setNossoNumero(Long nossoNumero) {
		this.nossoNumero = nossoNumero;
	}

	public String getDigitoNossoNumero() {
		return digitoNossoNumero;
	}

	public void setDigitoNossoNumero(String digitoNossoNumero) {
		this.digitoNossoNumero = digitoNossoNumero;
	}

	public String getBrancos1() {
		return brancos1;
	}

	public void setBrancos1(String brancos1) {
		this.brancos1 = brancos1;
	}

	public String getBrancos2() {
		return brancos2;
	}

	public void setBrancos2(String brancos2) {
		this.brancos2 = brancos2;
	}

	public Integer getCarteira() {
		return carteira;
	}

	public void setCarteira(Integer carteira) {
		this.carteira = carteira;
	}

	public Integer getCodigoOcorrencia() {
		return codigoOcorrencia;
	}

	public void setCodigoOcorrencia(Integer codigoOcorrencia) {
		this.codigoOcorrencia = codigoOcorrencia;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public BigDecimal getValorNominalTitulo() {
		return valorNominalTitulo;
	}

	public void setValorNominalTitulo(BigDecimal valorNominalTitulo) {
		this.valorNominalTitulo = valorNominalTitulo;
	}

	public Integer getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(Integer codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public Integer getEspecieTitulo() {
		return especieTitulo;
	}

	public void setEspecieTitulo(Integer especieTitulo) {
		this.especieTitulo = especieTitulo;
	}

	public String getAceite() {
		return aceite;
	}

	public void setAceite(String aceite) {
		this.aceite = aceite;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Integer getPrimeiraInstrucao() {
		return primeiraInstrucao;
	}

	public void setPrimeiraInstrucao(Integer primeiraInstrucao) {
		this.primeiraInstrucao = primeiraInstrucao;
	}

	public Integer getSegundaInstrucao() {
		return segundaInstrucao;
	}

	public void setSegundaInstrucao(Integer segundaInstrucao) {
		this.segundaInstrucao = segundaInstrucao;
	}

	public BigDecimal getValorJuros() {
		return valorJuros;
	}

	public void setValorJuros(BigDecimal valorJuros) {
		this.valorJuros = valorJuros;
	}

	public Date getDataDesconto() {
		return dataDesconto;
	}

	public void setDataDesconto(Date dataDesconto) {
		this.dataDesconto = dataDesconto;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public BigDecimal getValorIOF() {
		return valorIOF;
	}

	public void setValorIOF(BigDecimal valorIOF) {
		this.valorIOF = valorIOF;
	}

	public BigDecimal getValorAbatimento() {
		return valorAbatimento;
	}

	public void setValorAbatimento(BigDecimal valorAbatimento) {
		this.valorAbatimento = valorAbatimento;
	}

	public Integer getTipoSacado() {
		return tipoSacado;
	}

	public void setTipoSacado(Integer tipoSacado) {
		this.tipoSacado = tipoSacado;
	}

	public String getNomeSacado() {
		return nomeSacado;
	}

	public void setNomeSacado(String nomeSacado) {
		this.nomeSacado = nomeSacado;
	}

	public String getBrancos3() {
		return brancos3;
	}

	public void setBrancos3(String brancos3) {
		this.brancos3 = brancos3;
	}

	public String getEnderecoSacado() {
		return enderecoSacado;
	}

	public void setEnderecoSacado(String enderecoSacado) {
		this.enderecoSacado = enderecoSacado;
	}

	public Integer getCepSacado() {
		return cepSacado;
	}

	public void setCepSacado(Integer cepSacado) {
		this.cepSacado = cepSacado;
	}

	
	public String getSacadorAvalista() {
		return sacadorAvalista;
	}

	public void setSacadorAvalista(String sacadorAvalista) {
		this.sacadorAvalista = sacadorAvalista;
	}


	public Integer getNumeroSequencialRegistro() {
		return numeroSequencialRegistro;
	}

	public void setNumeroSequencialRegistro(Integer numeroSequencialRegistro) {
		this.numeroSequencialRegistro = numeroSequencialRegistro;
	}

	public static TitulosCobrancaDetalheRemessa of(ContaBancaria contaBancaria, List<RemessaCobranca> remessas) {
		return new TitulosCobrancaDetalheRemessa(contaBancaria, remessas);
	}

	@Override
	public String toString() {
		return "TitulosCobrancaDetalheRemessa [codigoRegistro=" + codigoRegistro + ", agenciaDebito=" + agenciaDebito
				+ ", digitoAgenciaDebito=" + digitoAgenciaDebito + ", RazaoSocialContaDebito=" + RazaoSocialContaDebito
				+ ", contaCorrenteDebito=" + contaCorrenteDebito + ", digitoContaCorrenteDebito="
				+ digitoContaCorrenteDebito + ", zeros1=" + zeros1 + ", carteira=" + carteira + ", agencia=" + agencia
				+ ", numeroContaCorrente=" + numeroContaCorrente + ", digitoContaCorrente=" + digitoContaCorrente
				+ ", brancos1=" + brancos1 + ", codigoBanco=" + codigoBanco + ", codigoMulta=" + codigoMulta
				+ ", percentualMulta=" + percentualMulta + ", nossoNumero=" + nossoNumero + ", digitoNossoNumero="
				+ digitoNossoNumero + ", valorDescontoBonificacaoDia=" + valorDescontoBonificacaoDia
				+ ", indicadorRateioCredito=" + indicadorRateioCredito + ", brancos2=" + brancos2
				+ ", codigoOcorrencia=" + codigoOcorrencia + ", numeroDocumento=" + numeroDocumento
				+ ", dataVencimento=" + dataVencimento + ", valorNominalTitulo=" + valorNominalTitulo + ", zeros2="
				+ zeros2 + ", especieTitulo=" + especieTitulo + ", aceite=" + aceite + ", dataEmissao=" + dataEmissao
				+ ", primeiraInstrucao=" + primeiraInstrucao + ", segundaInstrucao=" + segundaInstrucao
				+ ", valorJuros=" + valorJuros + ", dataDesconto=" + dataDesconto + ", valorDesconto=" + valorDesconto
				+ ", valorIOF=" + valorIOF + ", valorAbatimento=" + valorAbatimento + ", tipoSacado=" + tipoSacado
				+ ", numeroInscricaoSacado=" + numeroInscricaoSacado + ", nomeSacado=" + nomeSacado
				+ ", enderecoSacado=" + enderecoSacado + ", brancos3=" + brancos3 + ", cepSacado=" + cepSacado
				+ ", sacadorAvalista=" + sacadorAvalista + ", numeroSequencialRegistro=" + numeroSequencialRegistro
				+ "]";
	}
	
}
