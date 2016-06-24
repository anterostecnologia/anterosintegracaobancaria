package br.com.anteros.integracao.bancaria.banco.febraban;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;


import br.com.anteros.integracao.bancaria.banco.ParametroBancario;
import br.com.anteros.integracao.bancaria.banco.ParametrosBancariosMap;
import br.com.anteros.core.utils.ObjectUtils;


/**
 * Representa um título em cobrança, tais como:
 * 
 * <br />
 * 
 * <ul>
 * <li>Cheque</li>
 * <li>Duplicata Mercantil</li>
 * <li>Duplicata de Serviço</li>
 * <li>Duplicata Rural</li>
 * <li>Letra de Câmbio</li>
 * <li>Nota de Crédito Comercial</li>
 * <li>Nota de Crédito Industrial</li>
 * <li>Nota de Crédito Rural</li>
 * <li>E outras espécies pagáveis através da rede bancária.</li>
 * 
 * @see TipoDeTitulo
 * 
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * @author <a href="mailto:misaelbarreto@gmail.com">Misael Barreto</a>
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * @author <a href="http://www.nordestefomento.com.br">Nordeste Fomento
 *         Mercantil</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public class Titulo {

	/**
	 * @see #setNumeroDoDocumento(String)
	 */
	private String numeroDoDocumento;

	/**
	 * @see #setDataDoDocumento(Date)
	 */
	private Date dataDoDocumento;

	/**
	 * @see #setDataDoVencimento(Date)
	 */
	private Date dataDoVencimento;

	/**
	 * @see br.com.anteros.integracao.bancaria.banco.febraban.TipoDeMoeda
	 */
	private TipoDeMoeda tipoDeMoeda = TipoDeMoeda.REAL;

	/**
	 * @see #setValor(BigDecimal)
	 */
	private BigDecimal valor;

	/**
	 * @see #setDesconto(BigDecimal)
	 */
	private BigDecimal valorDesconto;
	
	private BigDecimal percentualDesconto;
	
	/**
	 * @see #setMora(BigDecimal)
	 */
	private BigDecimal valorJurosMora;
	
	/**
	 * @see #setDeducao(BigDecimal)
	 */
	private BigDecimal valorDeducao;
	
	/**
	 * @see #setAcrecimo(BigDecimal)
	 */
	private BigDecimal valorAcrecimo;
	
	/**
	 * @see #setValorCobrado(BigDecimal)
	 */
	private BigDecimal valorCobrado;
	
	private BigDecimal valorIOF;
	
	private BigDecimal valorAbatimento;
	
	private Integer nrDiasProtesto;
	
	private TipoDeBaixaDevolucao tipoDeBaixaDevolucao;
	
	private Integer nrDiasBaixaDevolucao;
	
	

	/**
	 * @see br.com.anteros.integracao.bancaria.banco.febraban.TipoDeTitulo
	 */
	private TipoDeTitulo tipoDeDocumento;
	
	private TipoDeJurosMora tipoDeJurosMora;
	
	private TipoDeTitulo tipoDeTitulo;
	
	private TipoDeDesconto tipoDeDesconto;
	
	private TipoDeProtesto tipoDeProtesto;
	
	private Date dataDesconto;
	/**
	 * Data indicativa do início da cobrança do Juros de Mora de um título de cobrança.
	 */
	private Date dataJurosMora;

	/**
	 * @see #setNossoNumero(String)
	 */
	private String nossoNumero;

	/**
	 * @see #setDigitoDoNossoNumero(String)
	 */
	private String digitoDoNossoNumero;

	/**
	 * @see #setContaBancaria(ContaBancaria)
	 */
	private ContaBancaria contaBancaria;

	/**
	 * @see #setCedente(Cedente)
	 */
	private Cedente cedente;

	/**
	 * @see #setSacado(Sacado)
	 */
	private Sacado sacado;

	/**
	 * @see #setSacadorAvalista(SacadorAvalista)
	 */
	private SacadorAvalista sacadorAvalista;
	
	private Carteira carteira;

	/**
	 * @see #setParametrosBancarios(ParametrosBancariosMap)
	 */
	private ParametrosBancariosMap parametrosBancariosMap;

	/**
	 * <p>
	 * Identificação de Título Aceito / Não Aceito Código adotado pela FEBRABAN
	 * para identificar se o título de cobrança foi aceito (reconhecimento da
	 * dívida pelo Sacado). Domínio:
	 * </p>
	 * <ul>
	 * <li>'A' = Aceite</li>
	 * <li>'N' = Não Aceite</li>
	 * </ul>
	 * 
	 * @since 0.2
	 * 
	 * @version 0.2
	 */
	public enum Aceite {
		/**
		 * 'A' = Título Aceite.
		 */
		A, 
		/**
		 * 'N' = Título Não Aceite.
		 */
		N;
	}

	/**
	 * @see #setAceite(br.com.anteros.integracao.bancaria.banco.febraban.Titulo.Aceite)
	 * 
	 * @see Aceite
	 */
	private Aceite aceite;

	/**
	 * <p>
	 * Cria uma instância de título.
	 * </p>
	 * 
	 * @param contaBancaria
	 * @param sacado
	 * @param cedente
	 * 
	 */
	public Titulo(ContaBancaria contaBancaria, Sacado sacado, Cedente cedente, Carteira carteira) {
		this.setContaBancaria(contaBancaria);
		this.setSacado(sacado);
		this.setCedente(cedente);
		this.setCarteira(carteira);
	}

	/**
	 * <p>
	 * Cria uma instância de título com sacador avalista.
	 * </p>
	 * 
	 * @param contaBancaria
	 * @param sacado
	 * @param cedente
	 * @param sacadorAvalista
	 * 
	 */
	public Titulo(ContaBancaria contaBancaria, Sacado sacado, Cedente cedente, SacadorAvalista sacadorAvalista, Carteira carteira) {
		this(contaBancaria, sacado, cedente, carteira);
		this.setSacadorAvalista(sacadorAvalista);
	}

	/**
	 * <p>
	 * Cria uma instância de título acrescentado outros dados bancários ao
	 * mesmo.
	 * </p>
	 * 
	 * @param contaBancaria
	 * @param sacado
	 * @param cedente
	 * @param parametrosBancariosMap
	 * 
	 */
	public Titulo(ContaBancaria contaBancaria, Sacado sacado, Cedente cedente,
			ParametrosBancariosMap parametrosBancariosMap, Carteira carteira) {
		this.setContaBancaria(contaBancaria);
		this.setSacado(sacado);
		this.setCedente(cedente);
		this.setCarteira(carteira);
		this.setParametrosBancarios(parametrosBancariosMap);
	}

	/**
	 * <p>
	 * Cria uma instância de título com sacador avalista e acrescentado outros
	 * dados bancários além do título.
	 * </p>
	 * 
	 * @param contaBancaria
	 * @param sacado
	 * @param cedente
	 * @param parametrosBancariosMap
	 * @param sacadorAvalista
	 * 
	 */
	public Titulo(ContaBancaria contaBancaria, Sacado sacado, Cedente cedente,
			ParametrosBancariosMap parametrosBancariosMap, SacadorAvalista sacadorAvalista, Carteira carteira) {
		this(contaBancaria, sacado, cedente, parametrosBancariosMap, carteira);
		this.setSacadorAvalista(sacadorAvalista);
	}

	/**
	 * <p>
	 * Indica se o título possuem sacador avalista na instância
	 * </p>
	 * 
	 * @return true se tem
	 */
	public boolean hasSacadorAvalista() {

		boolean has = false;

		if (ObjectUtils.isNotNull(this.sacadorAvalista)) {
			has = true;
		}

		return has;
	}

	/**
	 * @see #setAceite(br.com.anteros.integracao.bancaria.banco.febraban.Titulo.Aceite)
	 * 
	 * @return the aceite
	 */
	public Aceite getAceite() {
		return aceite;
	}

	/**
	 * <p>
	 * Indicação de aceite.
	 * </p>
	 * 
	 * @param aceite
	 *            the aceite to set
	 */
	public void setAceite(Aceite aceite) {
		this.aceite = aceite;
	}

	/**
	 * @see #setDataDoDocumento(Date)
	 * 
	 * @return the dataDoDocumento
	 */
	public Date getDataDoDocumento() {
		return dataDoDocumento;
	}

	/**
	 * <p>
	 * Data de emissão do documento.
	 * </p>
	 * 
	 * @param dataDoDocumento
	 *            the dataDoDocumento to set
	 */
	public void setDataDoDocumento(Date dataDoDocumento) {
		this.dataDoDocumento = dataDoDocumento;
	}

	/**
	 * @see #setDataDoVencimento(Date)
	 * 
	 * @return the dataDoVencimento
	 */
	public Date getDataDoVencimento() {
		return dataDoVencimento;
	}

	/**
	 * <p>
	 * Data de vencimento nominal do título de cobrança, ou melhor, data limite
	 * para pagamento do título.
	 * </p>
	 * 
	 * @param dataDoVencimento
	 *            the dataDoVencimento to set
	 */
	public void setDataDoVencimento(Date dataDoVencimento) {
		this.dataDoVencimento = dataDoVencimento;
	}

	/**
	 * @see #setDigitoDoNossoNumero(String)
	 * 
	 * @return the dígitoDoNossoNúmero
	 */
	public String getDigitoDoNossoNumero() {
		return digitoDoNossoNumero;
	}

	/**
	 * <p>
	 * Dígito verificador do nosso número, caso exista.
	 * </p>
	 * 
	 * @param digitoDoNossoNumero
	 *            the dígitoDoNossoNúmero to set
	 */
	public void setDigitoDoNossoNumero(String digitoDoNossoNumero) {
		this.digitoDoNossoNumero = digitoDoNossoNumero;
	}

	/**
	 * @see br.com.anteros.integracao.bancaria.banco.febraban.TipoDeMoeda
	 * 
	 * @return the enumMoeda
	 */
	public TipoDeMoeda getTipoDeMoeda() {
		return tipoDeMoeda;
	}

	/**
	 * @see br.com.anteros.integracao.bancaria.banco.febraban.TipoDeMoeda
	 * 
	 * @param tipoDeMoeda
	 *            the enumMoeda to set
	 */
	public void setTipoDeMoeda(TipoDeMoeda tipoDeMoeda) {
		this.tipoDeMoeda = tipoDeMoeda;
	}

	/**
	 * @see #setNossoNumero(String)
	 * 
	 * @return the nossoNúmero
	 */
	public String getNossoNumero() {
		return nossoNumero;
	}

	/**
	 * <p>
	 * Código fornecido pelo Banco correspondente para identificação do título
	 * ou identificação do título atribuído pelo esmissor do título de cobrança.
	 * </p>
	 * 
	 * @param nossoNumero
	 *            the nossoNúmero to set
	 */
	public void setNossoNumero(String nossoNumero) {
		this.nossoNumero = nossoNumero;
	}

	/**
	 * @see #setNumeroDoDocumento(String)
	 * 
	 * @return the númeroDoDocumento
	 */
	public String getNumeroDoDocumento() {
		return numeroDoDocumento;
	}

	/**
	 * <p>
	 * Número de controle do cedente para o referido título. Não confundir com o
	 * nosso número.
	 * </p>
	 * 
	 * @param numeroDoDocumento
	 *            the númeroDoDocumento to set
	 */
	public void setNumeroDoDocumento(String numeroDoDocumento) {
		this.numeroDoDocumento = numeroDoDocumento;
	}

	/**
	 * @see #setContaBancaria(ContaBancaria)
	 * 
	 * @return the contaBancaria
	 */
	public ContaBancaria getContaBancaria() {
		return contaBancaria;
	}

	/**
	 * <p>
	 * Conta na qual o título se encontra, conta do favorecido (Cedente).
	 * </p>
	 * 
	 * @param contaBancaria
	 *            the contaBancaria to set
	 */
	public void setContaBancaria(ContaBancaria contaBancaria) {

		if (ObjectUtils.isNotNull(contaBancaria)) {
			this.contaBancaria = contaBancaria;
		} else {
			throw new IllegalArgumentException("ContaBancaria não pode ser nula!");
		}
	}

	/**
	 * @see #setCedente(Cedente)
	 * 
	 * @return the cedente
	 */
	public Cedente getCedente() {
		return cedente;
	}

	/**
	 * <p>
	 * Cliente que entrega os títulos ao Banco para serem cobrados.
	 * </p>
	 * 
	 * @param cedente
	 *            the cedente to set
	 */
	public void setCedente(Cedente cedente) {
		if (ObjectUtils.isNotNull(cedente)) {
			this.cedente = cedente;
		} else {
			throw new IllegalArgumentException("Cedente não pode ser nulo!");
		}
	}

	/**
	 * @see #setSacado(Sacado)
	 * 
	 * @return the sacado
	 */
	public Sacado getSacado() {
		return sacado;
	}

	/**
	 * <p>
	 * Pessoa física ou jurídica a que se destina a cobrança do compromisso, é o
	 * cliente do Cedente.
	 * </p>
	 * 
	 * @param sacado
	 *            the sacado to set
	 */
	public void setSacado(Sacado sacado) {
		if (ObjectUtils.isNotNull(sacado)) {
			this.sacado = sacado;
		} else {
			throw  new IllegalArgumentException("Sacado não pode ser nulo!");
		}
	}

	/**
	 * @see #setSacadorAvalista(SacadorAvalista)
	 * 
	 * @return the sacadorAvalista
	 */
	public SacadorAvalista getSacadorAvalista() {
		return sacadorAvalista;
	}

	/**
	 * <p>
	 * Cedente original do Título.
	 * </p>
	 * 
	 * @param sacadorAvalista
	 *            the sacadorAvalista to set
	 */
	public void setSacadorAvalista(SacadorAvalista sacadorAvalista) {
		if (ObjectUtils.isNotNull(sacadorAvalista)) {
			this.sacadorAvalista = sacadorAvalista;
		} else {
			throw new IllegalArgumentException("SacadorAvalista não pode ser nulo!");
		}
	}

	/**
	 * @return the tipoDeDocumento
	 */
	public TipoDeTitulo getTipoDeDocumento() {
		return tipoDeDocumento;
	}

	/**
	 * @param tipoDeDocumento
	 *            the tipoDeDocumento to set
	 */
	public void setTipoDeDocumento(TipoDeTitulo tipoDeDocumento) {
		this.tipoDeDocumento = tipoDeDocumento;
	}

	/**
	 * @see #setValor(BigDecimal)
	 * 
	 * @return the valor
	 */
	public BigDecimal getValor() {
		return valor;
	}

	/**
	 * <p>
	 * Atribui um valor (original do Título) expresso em moeda corrente e
	 * arredondanda em duas casas decimais para baixo.
	 * </p>
	 * <p>
	 * Exemplo: Para o valor 12,349 ele definirá o valor para 12,34.
	 * </p>
	 * 
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(BigDecimal valor) {
		valor = valor.setScale(2, RoundingMode.DOWN);
		this.valor = valor;
	}

	/**
	 * @see #setDesconto(BigDecimal)
	 * 
	 * @return the desconto
	 */
	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	/**
	 * <p>
	 * Atribui um valor de descontos/abatimentos ao valor original do título expresso em
	 * moeda corrente e arredondanda em duas casas decimais para baixo.
	 * </p>
	 * <p>
	 * Exemplo: Para o valor 12,349 ele definirá o valor para 12,34.
	 * </p>
	 * 
	 * @param desconto
	 *            the desconto to set
	 */
	public void setValorDesconto(BigDecimal valorDesconto) {

		if (valorDesconto != null) {
			valorDesconto = valorDesconto.setScale(2, RoundingMode.DOWN);
		}
		this.valorDesconto = valorDesconto;
	}

	/**
	 * @see #setMora(BigDecimal)
	 * 
	 * @return the mora
	 */
	public BigDecimal getValorJurosMora() {
		return valorJurosMora;
	}

	/**
	 * <p>
	 * Atribui um valor de mora/multa ao título expresso em moeda corrente e
	 * arredondanda em duas casas decimais para baixo.
	 * </p>
	 * <p>
	 * Exemplo: Para o valor 12,349 ele definirá o valor para 12,34.
	 * </p>
	 * 
	 * @param mora
	 */
	public void setValorJurosMora(BigDecimal valorJurosMora) {
		if (valorJurosMora != null) {
			valorJurosMora = valorJurosMora.setScale(2, RoundingMode.DOWN);
		}
		this.valorJurosMora = valorJurosMora;
	}

	/**
	 * @see #setValorDeducao(BigDecimal)
	 * 
	 * @return the deducao
	 */
	public BigDecimal getValorDeducao() {
		return valorDeducao;
	}

	/**
	 * <p>
	 * Atribui um valor para outras deduções ao título expresso em moeda
	 * corrente e arredondanda em duas casas decimais para baixo.
	 * </p>
	 * <p>
	 * Exemplo: Para o valor 12,349 ele definirá o valor para 12,34.
	 * </p>
	 * 
	 * @param deducao
	 */
	public void setValorDeducao(BigDecimal valorDeducao) {
		if (valorDeducao != null) {
			valorDeducao = valorDeducao.setScale(2, RoundingMode.DOWN);
		}
		this.valorDeducao = valorDeducao;
	}
	
	/**
	 * @see #setAcrecimo(BigDecimal)
	 * 
	 * @return the acrecimo
	 */
	public BigDecimal getValorAcrecimo() {
		
		return valorAcrecimo;
	}
	
	/**
	 * <p>
	 * Atribui um valor para outros acrécimos ao título expresso em moeda
	 * corrente e arredondanda em duas casas decimais para baixo.
	 * </p>
	 * <p>
	 * Exemplo: Para o valor 12,349 ele definirá o valor para 12,34.
	 * </p>
	 * 
	 * @param acrecimo
	 */
	public void setValorAcrecimo(BigDecimal valorAcrecimo) {
		if (valorAcrecimo != null) {
			valorAcrecimo = valorAcrecimo.setScale(2, RoundingMode.DOWN);
		}
		this.valorAcrecimo = valorAcrecimo;
	}

	/**
	 * @see #setValorCobrado(BigDecimal)
	 * 
	 * @return the valorCobrado
	 */
	public BigDecimal getValorCobrado() {
		return valorCobrado;
	}

	/**
	 * <p>
	 * Atribui um "valor cobrardo" ao título expresso em moeda corrente e
	 * arredondanda em duas casas decimais para baixo.
	 * </p>
	 * <p>
	 * Exemplo: Para o valor 12,349 ele definirá o valor para 12,34.
	 * </p>
	 * 
	 * <p>
	 * Note que o valor cobrado não é o valor de face do título e sim um valor
	 * resultante de deduções ou acrécimos.
	 * </p>
	 * 
	 * @param valorCobrado
	 */
	public void setValorCobrado(BigDecimal valorCobrado) {
		if (valorCobrado != null) {
			valorCobrado = valorCobrado.setScale(2, RoundingMode.DOWN);
		}
		this.valorCobrado = valorCobrado;
	}
	
	/**
	 * <p>
	 * Indica se existe parâmetros bancários no título.
	 * </p>
	 * 
	 * @return parametrosBancarios
	 * 
	 * @see #getParametrosBancarios()
	 * 
	 * @since 0.2
	 */

	public boolean hasParametrosBancarios() {
		return ParametrosBancariosMap.hasElement(getParametrosBancarios());
	}

	/**
	 * <p>
	 * Retorna os parâmetros bancários usados no título.
	 * </p>
	 * 
	 * @return parametrosBancarios
	 * 
	 * @see #setParametrosBancarios(ParametrosBancariosMap)
	 * 
	 * @since 0.2
	 */
	public ParametrosBancariosMap getParametrosBancarios() {
		return parametrosBancariosMap;
	}

	/**
	 * <p>
	 * Atribui Parâmetros bancários necessários ao título.
	 * </p>
	 * 
	 * <p>
	 * Em alguns casos, talvez seja necessário utilizar este campo para fornecer
	 * mais informações a um título. Seja para simplesmente gerar um boleto ou
	 * quando se desejar implementar um campo livre ou banco ainda não
	 * suportado.
	 * </p>
	 * 
	 * @see br.com.anteros.integracao.bancaria.banco.ParametrosBancariosMap
	 * 
	 * @param parametrosBancariosMap
	 * 
	 * @since 0.2
	 */

	public <P extends ParametroBancario<?>> void setParametrosBancarios(ParametrosBancariosMap parametrosBancariosMap) {
		this.parametrosBancariosMap = parametrosBancariosMap;
	}

	@Override
	public String toString() {
		return "Titulo [numeroDoDocumento=" + numeroDoDocumento + ", dataDoDocumento=" + dataDoDocumento
				+ ", dataDoVencimento=" + dataDoVencimento + ", tipoDeMoeda=" + tipoDeMoeda + ", valor=" + valor
				+ ", desconto=" + valorDesconto + ", mora=" + valorJurosMora + ", deducao=" + valorDeducao + ", acrecimo=" + valorAcrecimo
				+ ", valorCobrado=" + valorCobrado + ", tipoDeDocumento=" + tipoDeDocumento + ", nossoNumero="
				+ nossoNumero + ", digitoDoNossoNumero=" + digitoDoNossoNumero + ", contaBancaria=" + contaBancaria
				+ ", cedente=" + cedente + ", sacado=" + sacado + ", sacadorAvalista=" + sacadorAvalista
				+ ", parametrosBancariosMap=" + parametrosBancariosMap + ", aceite=" + aceite + "]";
	}

	public Carteira getCarteira() {
		return carteira;
	}

	public void setCarteira(Carteira carteira) {
		this.carteira = carteira;
	}

	public void setJurosMora(BigDecimal jurosMora) {
		this.valorJurosMora = jurosMora;
	}

	public TipoDeJurosMora getTipoDeJurosMora() {
		return tipoDeJurosMora;
	}

	public void setTipoDeJurosMora(TipoDeJurosMora tipoDeJurosMora) {
		this.tipoDeJurosMora = tipoDeJurosMora;
	}

	public Date getDataJurosMora() {
		return dataJurosMora;
	}

	public void setDataJurosMora(Date dataJurosMora) {
		this.dataJurosMora = dataJurosMora;
	}

	public TipoDeTitulo getTipoDeTitulo() {
		return tipoDeTitulo;
	}

	public void setTipoDeTitulo(TipoDeTitulo tipoDeTitulo) {
		this.tipoDeTitulo = tipoDeTitulo;
	}

	public TipoDeDesconto getTipoDeDesconto() {
		return tipoDeDesconto;
	}

	public void setTipoDeDesconto(TipoDeDesconto tipoDeDesconto) {
		this.tipoDeDesconto = tipoDeDesconto;
	}

	public Date getDataDesconto() {
		return dataDesconto;
	}

	public void setDataDesconto(Date dataDesconto) {
		this.dataDesconto = dataDesconto;
	}

	public BigDecimal getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(BigDecimal percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
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

	public TipoDeProtesto getTipoDeProtesto() {
		return tipoDeProtesto;
	}

	public void setTipoDeProtesto(TipoDeProtesto tipoDeProtesto) {
		this.tipoDeProtesto = tipoDeProtesto;
	}

	public Integer getNrDiasProtesto() {
		return nrDiasProtesto;
	}

	public void setNrDiasProtesto(Integer nrDiasProtesto) {
		this.nrDiasProtesto = nrDiasProtesto;
	}

	public TipoDeBaixaDevolucao getTipoDeBaixaDevolucao() {
		return tipoDeBaixaDevolucao;
	}

	public void setTipoDeBaixaDevolucao(TipoDeBaixaDevolucao tipoDeBaixaDevolucao) {
		this.tipoDeBaixaDevolucao = tipoDeBaixaDevolucao;
	}

	public Integer getNrDiasBaixaDevolucao() {
		return nrDiasBaixaDevolucao;
	}

	public void setNrDiasBaixaDevolucao(Integer nrDiasBaixaDevolucao) {
		this.nrDiasBaixaDevolucao = nrDiasBaixaDevolucao;
	}

}
