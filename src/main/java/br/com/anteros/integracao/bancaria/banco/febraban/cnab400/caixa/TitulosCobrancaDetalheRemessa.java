package br.com.anteros.integracao.bancaria.banco.febraban.cnab400.caixa;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.Formats;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.language.EnumTypes;
import br.com.anteros.integracao.bancaria.banco.febraban.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.febraban.RemessaCobranca;

public class TitulosCobrancaDetalheRemessa {

	@IdType(name="CD_REGISTRO", length=1, value="1", positionField=1)
	private Integer codigoRegistro;
	
	@Field(name="TP_INSCRICAO_EMPRESA", length=2, padding=Paddings.ZERO_LEFT, type=EnumTypes.INTEGER)
	private Integer tipoInscricaoEmpresa;
	
	@Field(name="NR_INSCRICAO", length=14, padding=Paddings.ZERO_LEFT, type=EnumTypes.LONG)
	private Long numeroInscricao;
	
	@Field(name="AGENCIA", length=4, padding=Paddings.ZERO_LEFT, type=EnumTypes.INTEGER)
	private Integer agencia;
	
	@Field(name="DIGITO_AGENCIA", length=1)
	private String digitoAgencia;
	
	@Field(name="NR_CONTACORRENTE", length=8, padding=Paddings.ZERO_LEFT, type=EnumTypes.LONG)
	private Long numeroContaCorrente;
	
	@Field(name="DIGITO_CONTACORRENTE", length=1)
	private String digitoContaCorrente;
	
	@Field(name="NR_CONVENIO", length=6, padding=Paddings.ZERO_LEFT, type=EnumTypes.INTEGER)
	private Integer numeroConvenio;
	
	@Field(name="USO_EMPRESA", length=25, padding=Paddings.WHITE_SPACE_RIGHT, value=" ")
	private String usoEmpresa;
	
	@Field(name="NOSSO_NUMERO", length=11, padding=Paddings.ZERO_LEFT)
	private Long nossoNumero;
	
	@Field(name="DIGITO_NOSSO_NUMERO", length=1)
	private String digitoNossoNumero;
	
	@Field(name="NR_PRESTACAO", length=2, value="00")
	private String numeroPrestacao;
	
	@Field(name="GRUPO_VALOR", length=2, value="00")
	private String grupoValor;
	
	@Field(name="BRANCOS1", length=3, value=" ", padding=Paddings.WHITE_SPACE_RIGHT)
	private String brancos1;
	
	@Field(name="INDICATIVO_MENSAGEM", length=1)
	private String indicativoMensagem;
	
	@Field(name="BRANCOS2", length=3, value=" ", padding=Paddings.WHITE_SPACE_RIGHT)
	private String brancos2;
	
	@Field(name="VARIACAO_CARTEIRA", length=3, padding=Paddings.ZERO_LEFT, type=EnumTypes.INTEGER)
	private Integer variacaoCarteira;
	
	@Field(name="CONTA_CAUCAO", length=1, type=EnumTypes.INTEGER, value="0")
	private Integer contaCaucao;
	
	@Field(name="NR_BORDERO", length=6, value="000000", type=EnumTypes.INTEGER, padding=Paddings.ZERO_LEFT)
    private Integer numeroBordero;	
	
	@Field(name="TP_COBRANCA", length=5, padding=Paddings.WHITE_SPACE_RIGHT)
	private String tipoCobranca;
	
	@Field(name="CARTEIRA", length=2, type=EnumTypes.INTEGER, padding=Paddings.ZERO_LEFT)
	private Integer carteira;
	
	@Field(name="CD_OCORRENCIA", length=2, type=EnumTypes.INTEGER, value="1", padding=Paddings.ZERO_LEFT )
	private Integer codigoOcorrencia;
	
	@Field(name="NR_DOCUMENTO", length=10, padding=Paddings.WHITE_SPACE_RIGHT)
	private String numeroDocumento;
	
	@Field(name="DT_VENCIMENTO", length=6, type=EnumTypes.DATE, format=Formats.DATE_DDMMYY, padding=Paddings.ZERO_LEFT)
	private Date dataVencimento;
	
	@Field(name="VL_TITULO", length=13, type=EnumTypes.BIGDECIMAL, format=Formats.DECIMAL_DD, padding=Paddings.ZERO_LEFT)
	private BigDecimal valorNominalTitulo;
	
	@Field(name="CD_BANCO", length=3, padding=Paddings.ZERO_LEFT, type=EnumTypes.INTEGER)
	private Integer codigoBanco;
	
	@Field(name="AGENCIA_COBRADORA", length=4, type=EnumTypes.INTEGER, padding=Paddings.ZERO_LEFT)
	private Integer agenciaCobradora;
	
	@Field(name="DIGITO_AGENCIA_COBRADORA", length=1, padding=Paddings.WHITE_SPACE_RIGHT)
	private String digitoAgenciaCobradora;

	@Field(name="ESPECIE_TITULO", length=2, padding=Paddings.ZERO_LEFT)
	private Integer especieTitulo;
	
	@Field(name="ACEITE", length=1)
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
	private Long numeroInscricaoSabado;
	
	@Field(name="NOME_SACADO", length=37, padding=Paddings.WHITE_SPACE_RIGHT)
	private String nomeSacado;
	
	@Field(name="BRANCOS3", length=3, value=" ")
	private String brancos3;
	
	@Field(name="ENDERECO_SACADO", length=37, padding=Paddings.WHITE_SPACE_RIGHT)
	private String enderecoSacado;
	
	@Field(name="BRANCOS4", length=3, value=" ")
	private String brancos4;

	@Field(name="CEP_SACADO", length=8, type=EnumTypes.INTEGER, padding=Paddings.ZERO_LEFT)
	private Integer cepSacado;
	
	@Field(name="CIDADE_SACADO", length=15, padding=Paddings.WHITE_SPACE_RIGHT)
	private String cidadeSacado;
	
	@Field(name="UF_SACADO", length=2)
	private String estadoSacado;
	
	@Field(name="SACADOR_AVALISTA", length=40, padding=Paddings.WHITE_SPACE_RIGHT)
	private String sacadorAvalista;
	
	@Field(name="NR_DIAS_PROTESTO", length=2, padding=Paddings.WHITE_SPACE_RIGHT)
	private String diasProtesto;
	
	@Field(name="BRANCOS5", length=1, value=" ")
	private String brancos5;
	
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

	public Integer getTipoInscricaoEmpresa() {
		return tipoInscricaoEmpresa;
	}

	public void setTipoInscricaoEmpresa(Integer tipoInscricaoEmpresa) {
		this.tipoInscricaoEmpresa = tipoInscricaoEmpresa;
	}

	public Long getNumeroInscricao() {
		return numeroInscricao;
	}

	public void setNumeroInscricao(Long numeroInscricao) {
		this.numeroInscricao = numeroInscricao;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public String getDigitoAgencia() {
		return digitoAgencia;
	}

	public void setDigitoAgencia(String digitoAgencia) {
		this.digitoAgencia = digitoAgencia;
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

	public Integer getNumeroConvenio() {
		return numeroConvenio;
	}

	public void setNumeroConvenio(Integer numeroConvenio) {
		this.numeroConvenio = numeroConvenio;
	}

	public String getUsoEmpresa() {
		return usoEmpresa;
	}

	public void setUsoEmpresa(String usoEmpresa) {
		this.usoEmpresa = usoEmpresa;
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

	public String getNumeroPrestacao() {
		return numeroPrestacao;
	}

	public void setNumeroPrestacao(String numeroPrestacao) {
		this.numeroPrestacao = numeroPrestacao;
	}

	public String getGrupoValor() {
		return grupoValor;
	}

	public void setGrupoValor(String grupoValor) {
		this.grupoValor = grupoValor;
	}

	public String getBrancos1() {
		return brancos1;
	}

	public void setBrancos1(String brancos1) {
		this.brancos1 = brancos1;
	}

	public String getIndicativoMensagem() {
		return indicativoMensagem;
	}

	public void setIndicativoMensagem(String indicativoMensagem) {
		this.indicativoMensagem = indicativoMensagem;
	}

	public String getBrancos2() {
		return brancos2;
	}

	public void setBrancos2(String brancos2) {
		this.brancos2 = brancos2;
	}

	public Integer getVariacaoCarteira() {
		return variacaoCarteira;
	}

	public void setVariacaoCarteira(Integer variacaoCarteira) {
		this.variacaoCarteira = variacaoCarteira;
	}

	public Integer getContaCaucao() {
		return contaCaucao;
	}

	public void setContaCaucao(Integer contaCaucao) {
		this.contaCaucao = contaCaucao;
	}

	public Integer getNumeroBordero() {
		return numeroBordero;
	}

	public void setNumeroBordero(Integer numeroBordero) {
		this.numeroBordero = numeroBordero;
	}

	public String getTipoCobranca() {
		return tipoCobranca;
	}

	public void setTipoCobranca(String tipoCobranca) {
		this.tipoCobranca = tipoCobranca;
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

	public Integer getAgenciaCobradora() {
		return agenciaCobradora;
	}

	public void setAgenciaCobradora(Integer agenciaCobradora) {
		this.agenciaCobradora = agenciaCobradora;
	}

	public String getDigitoAgenciaCobradora() {
		return digitoAgenciaCobradora;
	}

	public void setDigitoAgenciaCobradora(String digitoAgenciaCobradora) {
		this.digitoAgenciaCobradora = digitoAgenciaCobradora;
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

	public Long getNumeroInscricaoSabado() {
		return numeroInscricaoSabado;
	}

	public void setNumeroInscricaoSabado(Long numeroInscricaoSabado) {
		this.numeroInscricaoSabado = numeroInscricaoSabado;
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

	public String getBrancos4() {
		return brancos4;
	}

	public void setBrancos4(String brancos4) {
		this.brancos4 = brancos4;
	}

	public Integer getCepSacado() {
		return cepSacado;
	}

	public void setCepSacado(Integer cepSacado) {
		this.cepSacado = cepSacado;
	}

	public String getCidadeSacado() {
		return cidadeSacado;
	}

	public void setCidadeSacado(String cidadeSacado) {
		this.cidadeSacado = cidadeSacado;
	}

	public String getEstadoSacado() {
		return estadoSacado;
	}

	public void setEstadoSacado(String estadoSacado) {
		this.estadoSacado = estadoSacado;
	}

	public String getSacadorAvalista() {
		return sacadorAvalista;
	}

	public void setSacadorAvalista(String sacadorAvalista) {
		this.sacadorAvalista = sacadorAvalista;
	}

	public String getDiasProtesto() {
		return diasProtesto;
	}

	public void setDiasProtesto(String diasProtesto) {
		this.diasProtesto = diasProtesto;
	}

	public String getBrancos5() {
		return brancos5;
	}

	public void setBrancos5(String brancos5) {
		this.brancos5 = brancos5;
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
	
}
