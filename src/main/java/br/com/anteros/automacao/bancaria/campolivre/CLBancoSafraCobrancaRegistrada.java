package br.com.anteros.automacao.bancaria.campolivre;

import br.com.anteros.flatfile.type.component.Fillers;
import br.com.anteros.flatfile.type.component.FixedField;
import br.com.anteros.integracao.bancaria.banco.febraban.Titulo;

/**
 * <p>
 * O campo livre do Bradesco deve seguir esta forma:
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
 * <td style="text-align:left;padding-left:10">Sistema = constante 7</td>
 * <td style="text-align:left;padding-left:10">Valor fixo 7</td>
 * </tr>
 * <tr>
 * <td >21-34</td>
 * <td >14</td>
 * <td >9(14)</td>
 * <td style="text-align:left;padding-left:10">Código do cliente = Agência +
 * Conta</td>
 * <td style="text-align:left;padding-left:10">Código do cliente = (Ag[4] +
 * dv[1]) + (Cc[8] + dv[1])</td>
 * </tr>
 * <tr>
 * <td >35-43</td>
 * <td >9</td>
 * <td >&nbsp;9(9)</td>
 * <td style="text-align:left;padding-left:10">Número do Nosso Número(Sem o
 * digito verificador)</td>
 * <td style="text-align:left;padding-left:10">Nosso Número do título exatamente
 * com 9 dígitos (sem dígito verificador)</td>
 * </tr>
 * <tr>
 * <td >44-44</td>
 * <td >1</td>
 * <td >9</td>
 * <td style="text-align:left;padding-left:10">Tipo cobrança = constante 2 -
 * Eletrônica Emitido pelo Cliente</td>
 * <td style="text-align:left;padding-left:10">Valor fixo 2</td>
 * </tr>
 * </table>
 * 
 * @see org.jrimum.bopepo.campolivre.AbstractCampoLivre
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
class CLBancoSafraCobrancaRegistrada extends AbstractCLBancoSafra {

	/**
	 * {@code serialVersionUID = -4532989921797507161L}
	 */
	private static final long serialVersionUID = -4532989921797507161L;
	
	/**
	 * Tamanho do número de campos = 7.
	 */
	protected static final Integer FIELDS_LENGTH = Integer.valueOf(7);
	
	/**
	 * Tamanho do campo Agência = 4. 
	 */
	private static final Integer AGENCIA_LENGTH = Integer.valueOf(4);
	
	/**
	 * Tamanho do campo Dígito da Agência = 1. 
	 */
	private static final Integer AGENCIA_DIGITO_LENGTH = Integer.valueOf(1);
	
	/**
	 * Tamanho do campo Conta = 8. 
	 */
	private static final Integer CONTA_LENGTH = Integer.valueOf(8);
	
	/**
	 * Tamanho do campo Dígito da Conta = 1. 
	 */
	private static final Integer CONTA_DIGITO_LENGTH = Integer.valueOf(1);
	
	/**
	 * Tamanho do campo Nosso Número = 9. 
	 */
	private static final Integer NOSSO_NUMERO_LENGTH = Integer.valueOf(9);

	/**
	 * Cria um campo livre instanciando o número de fields ({@code FIELDS_LENGTH}
	 * ) deste campo.
	 * 
	 * @since 0.2
	 */
	protected CLBancoSafraCobrancaRegistrada() {

		super(FIELDS_LENGTH);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.jrimum.bopepo.campolivre.AbstractCampoLivre#checkValues(org.jrimum.domkee.financeiro.banco.febraban.Titulo)
	 */
	@Override
	protected void checkValues(Titulo titulo){
		
		checkAgenciaNotNull(titulo);
		checkCodigoDaAgencia(titulo);
		checkCodigoDaAgenciaMenorOuIgualQue(titulo, 9999);
		checkDigitoDoCodigoDaAgencia(titulo);
		checkNumeroDaContaNotNull(titulo);
		checkCodigoDoNumeroDaConta(titulo);
		checkCodigoDoNumeroDaContaMenorOuIgualQue(titulo, 999999);
		checkDigitoDoCodigoDoNumeroDaConta(titulo);
		checkNossoNumero(titulo);
		checkTamanhoDoNossoNumero(titulo, NN9);
	}

	/**
	 *  {@inheritDoc}
	 *  
	 * @see org.jrimum.bopepo.campolivre.AbstractCampoLivre#addFields(org.jrimum.domkee.financeiro.banco.febraban.Titulo)
	 */
	@Override
	protected void addFields(Titulo titulo) {

		this.add(SISTEMA_CONSTANT_FIELD);
		this.add(new FixedField<Integer>(titulo.getContaBancaria().getAgencia().getCodigo(), AGENCIA_LENGTH, Fillers.ZERO_LEFT));
		this.add(new FixedField<String>(titulo.getContaBancaria().getAgencia().getDigitoVerificador(), AGENCIA_DIGITO_LENGTH));
		this.add(new FixedField<Integer>(titulo.getContaBancaria().getNumeroDaConta().getCodigoDaConta(), CONTA_LENGTH, Fillers.ZERO_LEFT));
		this.add(new FixedField<String>(titulo.getContaBancaria().getNumeroDaConta().getDigitoDaConta(), CONTA_DIGITO_LENGTH));
		this.add(new FixedField<String>(titulo.getNossoNumero(), NOSSO_NUMERO_LENGTH));
		this.add(new FixedField<Integer>(TipoDeCobranca.DIRETA_BOLETO_EMITIDO_PELO_CLIENTE.codigo(), TIPO_COBRANCA_FIELD_LENGTH));
	}

}
