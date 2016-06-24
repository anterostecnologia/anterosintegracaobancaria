package br.com.anteros.automacao.bancaria.campolivre;

import br.com.anteros.automacao.bancaria.parametro.ParametroBancoob;
import br.com.anteros.flatfile.type.component.Fillers;
import br.com.anteros.flatfile.type.component.FixedField;
import br.com.anteros.integracao.bancaria.banco.febraban.Titulo;

/**
 * <p>
 * O campo livre do bradesco deve seguir esta forma:
 * </p>
 * 
 * <table border="1" cellpadding="0" cellspacing="0" style="border-collapse: collapse" bordercolor="#111111" width="100%" id="campolivre">
 * <thead bgcolor="#DEDEDE">
 * <tr>
 * <th>Posição</th>
 * <th>Tamanho</th>
 * <th>Picture</th>
 * <th>Conteúdo (terminologia padrão)</th>
 * <th>Conteúdo (terminologia do banco)</th>
 * </tr>
 * </thead> <tbody style="text-align:center">
 * <tr>
 * <td >20-20</td>
 * <td >1</td>
 * <td >9(1)</td>
 * <td style="text-align:left;padding-left:10">Carteira</td>
 * <td style="text-align:left;padding-left:10">Carteira</td>
 * </tr>
 * <tr>
 * <td >21-24</td>
 * <td >4</td>
 * <td >9(4)</td>
 * <td style="text-align:left;padding-left:10">Agência Cedente (Cooperativa) (sem o dígito
 * verificador, completar com zeros a esquerda quando necessário)</td>
 * <td style="text-align:left;padding-left:10">Código da Agência (sem dígito)</td>
 * </tr>
 * <tr>
 * <td >25-26</td>
 * <td >2</td>
 * <td >9(2)</td>
 * <td style="text-align:left;padding-left:10">Modalidade</td>
 * <td style="text-align:left;padding-left:10">Modalidade</td>
 * </tr>
 * <tr>
 * <td >27-33</td>
 * <td >7</td>
 * <td >9(7)</td>
 * <td style="text-align:left;padding-left:10">Código do Cliente (sem o dígito
 * verificador, completar com zeros a esquerda quando necessário)</td>
 * <td style="text-align:left;padding-left:10">Conta do Beneficiário (sem dígito)</td>
 * </tr>
 * <tr>
 * <td >34-40</td>
 * <td >7</td>
 * <td >9(7)</td>
 * <td style="text-align:left;padding-left:10">Número do título(sem o dígito
 * verificador, completar com zeros a esquerda quando necessário)</td>
 * <td style="text-align:left;padding-left:10">Nosso Número (sem dígito)</td>
 * </tr>
 * <tr>
 * <td >41-41</td>
 * <td >1</td>
 * <td >9(1)</td>
 * <td style="text-align:left;padding-left:10">Dígito verificador do Nosso Número</td>
 * <td style="text-align:left;padding-left:10">Dígito verificador do Nosso Número</td>
 * </tr>
 * <tr>
 * <td >42-44</td>
 * <td >3</td>
 * <td >9(3)</td>
 * <td style="text-align:left;padding-left:10">Número da Parcela (completar com zeros a esquerda quando necessário)</td>
 * <td style="text-align:left;padding-left:10">Número da Parcela</td>
 * </tr>
 * </table>
 * 
 * @see org.jrimum.bopepo.campolivre.AbstractCampoLivre
 * 
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * @author Rômulo Augusto
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public class CLBancoobCobrancaNaoRegistrada extends AbstractCLBancoob{

	/**
	 * {@code serialVersionUID = 2864939240695151533L}
	 */
	private static final long serialVersionUID = 2864939240695151533L;
	
	/**
	 * Número de campos = 6.
	 */
	protected static final Integer FIELDS_LENGTH = 8;
	
	/**
	 * Tamanho do campo Carteira = 1. 
	 */
	protected static final Integer CARTEIRA_LENGTH = Integer.valueOf(1);
	
	/**
	 * Tamanho do campo Agência = 4. 
	 */
	protected static final Integer AGENCIA_LENGTH = Integer.valueOf(4);
	
	/**
	 * Tamanho do campo código da modalidade de cobrança = 2.
	 */
	protected static final Integer MODALIDADE_DE_COBRANCA_LENGTH = Integer.valueOf(2);
	
	/**
	 * Valor do código da modalidade de cobrança (01) = SIMPLES.
	 */
	protected static final Integer COBRANCA_SIMPLES = Integer.valueOf(1);
	
	/**
	 * Tamanho do campo Nosso Número = 7.
	 */
	private static final Integer NOSSO_NUMERO_LENGTH = Integer.valueOf(7);
	
	/**
	 * Tamanho do campo Dígito Verificador do Nosso Número = 1.
	 */
	private static final Integer DV_NOSSO_NUMERO_LENGTH = Integer.valueOf(1);
	
	/**
	 * Tamanho do campo Conta = 6. 
	 */
	private static final Integer CONTA_LENGTH = Integer.valueOf(6);
	
	/**
	 * Tamanho do campo Dígito da conta = 1
	 */
	private static final Integer DV_CONTA_LENGTH = 1;
	
	/**
	 * Valor do número de parcelas = 1.
	 */
	private static final Integer UMA_PARCELA = Integer.valueOf(1);
	
	/**
	 * Tamanho do campo Conta = 3. 
	 */
	private static final Integer NUMERO_DA_PARCELA_LENGTH = 3;

	/**
	 * <p>
	 *   Cria um campo livre instanciando o número de fields ({@code FIELDS_LENGTH}) deste campo.
	 * </p>
	 * 
	 * @since 0.2
	 */
	protected CLBancoobCobrancaNaoRegistrada() {
		super(FIELDS_LENGTH);
	}

	@Override
	protected void checkValues(Titulo titulo) {
		
		checkCarteiraNotNull(titulo);
		checkCodigoDaCarteira(titulo);
		checkCodigoDaCarteiraMenorOuIgualQue(titulo, 9);
		checkAgenciaNotNull(titulo);
		checkCodigoDaAgencia(titulo);
		checkCodigoDaAgenciaMenorOuIgualQue(titulo, 9999);
		checkNossoNumero(titulo);
		checkTamanhoDoNossoNumero(titulo, NN7);
		checkDigitoDoNossoNumero(titulo);
		checkTamanhoDigitoDoNossoNumero(titulo, DV_NOSSO_NUMERO_LENGTH);
		checkNumeroDaContaNotNull(titulo);
		checkCodigoDoNumeroDaConta(titulo);
		checkCodigoDoNumeroDaContaMenorOuIgualQue(titulo, 9999999);
		checkDigitoDoCodigoDoNumeroDaConta(titulo);
		checkCodigoDoNumeroDaContaMenorOuIgualQue(titulo, 999999);
	}

	@Override
	protected void addFields(Titulo titulo) {
		
		Integer codigoDaModalidadeDeCobranca = COBRANCA_SIMPLES;
		Integer numeroDaParcela = UMA_PARCELA;
		
		if (titulo.hasParametrosBancarios()) {

			if (titulo.getParametrosBancarios().contemComNome(ParametroBancoob.MODALIDADE_DE_COBRANCA)) {
				checkParametroBancario(titulo, ParametroBancoob.MODALIDADE_DE_COBRANCA);
				codigoDaModalidadeDeCobranca = titulo.getParametrosBancarios().getValor(ParametroBancoob.MODALIDADE_DE_COBRANCA);
			}

			if (titulo.getParametrosBancarios().contemComNome(ParametroBancoob.NUMERO_DA_PARCELA)) {
				checkParametroBancario(titulo, ParametroBancoob.NUMERO_DA_PARCELA);
				numeroDaParcela = titulo.getParametrosBancarios().getValor(ParametroBancoob.NUMERO_DA_PARCELA);
			}
		}		

		this.add(new FixedField<Integer>(titulo.getCarteira().getCodigo(), CARTEIRA_LENGTH, Fillers.ZERO_LEFT));
		this.add(new FixedField<Integer>(titulo.getContaBancaria().getAgencia().getCodigo(), AGENCIA_LENGTH, Fillers.ZERO_LEFT));
		this.add(new FixedField<Integer>(codigoDaModalidadeDeCobranca, MODALIDADE_DE_COBRANCA_LENGTH, Fillers.ZERO_LEFT));
		this.add(new FixedField<Integer>(titulo.getContaBancaria().getNumeroDaConta().getCodigoDaConta(), CONTA_LENGTH, Fillers.ZERO_LEFT));
		this.add(new FixedField<String>(titulo.getContaBancaria().getNumeroDaConta().getDigitoDaConta(), DV_CONTA_LENGTH, Fillers.ZERO_LEFT));
		this.add(new FixedField<String>(titulo.getNossoNumero(),NOSSO_NUMERO_LENGTH, Fillers.ZERO_LEFT));
		this.add(new FixedField<String>(titulo.getDigitoDoNossoNumero(),DV_NOSSO_NUMERO_LENGTH));
		this.add(new FixedField<Integer>(numeroDaParcela, NUMERO_DA_PARCELA_LENGTH, Fillers.ZERO_LEFT));
	}
}
