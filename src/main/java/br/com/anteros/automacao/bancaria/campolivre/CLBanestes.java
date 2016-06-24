package br.com.anteros.automacao.bancaria.campolivre;


import br.com.anteros.flatfile.type.component.Fillers;
import br.com.anteros.flatfile.type.component.FixedField;
import br.com.anteros.integracao.bancaria.banco.febraban.TipoDeCobranca;
import br.com.anteros.integracao.bancaria.banco.febraban.Titulo;
import br.com.anteros.integracao.bancaria.validador.digitoverificador.Modulo;
import br.com.anteros.integracao.bancaria.validador.digitoverificador.TipoDeModulo;

/**
 * 
 * <p>
 * Representação do campo livre usado para boletos com carteiras (<em>cobrança</em>)
 * sem registro, caucionadas e com registro. O tipo de cobrança de carteira caucionada
 * se enquadra no conceito de cobrança registrada, sendo diferenciada pelo código
 * da carteira.
 * </p>
 * 
 * <p>
 * Layout:<br />
 * <div align="center">
 * <p align="center">
 * <font face="Arial">Cobrança Normal - CAMPO LIVRE - Chave ASBACE</font>
 * </p>
 * 
 * <table border="1" cellpadding="0" cellspacing="0" style="border-collapse:
 * collapse" bordercolor="#111111" >
 * <tr>
 * <td align="center" bgcolor="#C0C0C0"><strong><font face="Arial">Posição</font></strong></td>
 * <td bgcolor="#C0C0C0"><strong><font face="Arial">Campo Livre No Código De
 * Barras (20 a 44)</font></strong></td>
 * <tr>
 * <td align="center"><font face="Arial">20 a 27</font></td>
 * <td><font face="Arial">Nosso Número (sem os dois dígitos)</font></td>
 * 
 * </tr>
 * <tr>
 * <td align="center"><font face="Arial">28 a 38</font></td>
 * <td><font face="Arial">Conta Corrente</font></td>
 * </tr>
 * <tr>
 * <td align="center"><font face="Arial">39 a 39</font></td>
 * 
 * <td><font face="Arial">Produto = 2-Sem registro; 3-Caucionada; 4,5,6 e 7-Cobrança com registro</font></td>
 * </tr>
 * 
 * <tr>
 * <td align="center"><font face="Arial">40 a 42</font></td>
 * <td><font face="Arial">Constante = "021" Código do BANESTES </font></td>
 * </tr>
 * 
 * <tr>
 * <td align="center"><font face="Arial">43 a 44</font></td>
 * <td><font face="Arial">Duplo Dígito referente às posições 20 a 42</font></td>
 * </tr>
 * 
 * </table> </div>
 * </p>
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 * @author <a href="mailto:misaelbarreto@gmail.com">Misael Barreto</a>
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * @author <a href="mailto:samuelvalerio@gmail.com">Samuel Valério</a> Valerio
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
class CLBanestes extends AbstractCLBanestes {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 476678476727564241L;
	
	private static final Integer FIELDS_LENGTH = 5;

	public CLBanestes(Titulo titulo) {
		
		super(FIELDS_LENGTH);
		
		this.add(new FixedField<Integer>(Integer.valueOf(titulo.getNossoNumero()), 8, Fillers.ZERO_LEFT));
		this.add(new FixedField<Integer>(titulo.getContaBancaria().getNumeroDaConta().getCodigoDaConta(), 11, Fillers.ZERO_LEFT));
		
		final Integer codigoDaCarteiraDeCobranca = titulo.getCarteira().getCodigo();
		
		if (codigoDaCarteiraDeCobranca!=null) {
			this.add(new FixedField<Integer>(codigoDaCarteiraDeCobranca, 1));
			
		} else {
			
			final TipoDeCobranca tipoDeCobranca = titulo.getCarteira().getTipoDeCobranca();
			
			if (tipoDeCobranca == null) {
				throw new CampoLivreException("Tipo de cobrança da carteira não foi especificado!");
			} 
			
			switch (tipoDeCobranca) {
			
				case SEM_REGISTRO:
					this.add(new FixedField<Integer>(2, 1));
					break;
					
				case COM_REGISTRO:
					if (codigoDaCarteiraDeCobranca >= 3 && codigoDaCarteiraDeCobranca <= 7) {
						
						this.add(new FixedField<Integer>(codigoDaCarteiraDeCobranca, 1));
						break;
						
					} else {
						throw new CampoLivreException("Código da carteira de cobrança com registro deve ser" +
							" especificado com 3,4,5,6 ou 7. Valor atual = [" + codigoDaCarteiraDeCobranca + "]");
					}
				default:
					throw new CampoLivreException("Tipo de cobrança [" + tipoDeCobranca  + "] não é suportado!");
					
			}
		}
		this.add(new FixedField<Byte>(titulo.getContaBancaria().getBanco().getCodigoDeCompensacaoBACEN().getCodigo().byteValue(), 3, Fillers.ZERO_LEFT));
		this.add(new FixedField<Byte>(calculaDuploDV(), 2, Fillers.ZERO_LEFT));
	}
	
	/**
	 * Calcula duplo dígito verificador da posição 0 à 23 do campo livre (Chave ASBACE)..
	 * 
	 * @return Duplo dígito verificador. 
	 * 
	 */
	private byte calculaDuploDV() {
		final byte duploDV;
		
		String fields = writeFields();
		
		byte primeiroDV = calculaPrimeiroDV(fields);
		
		final byte segundoDV;
		
		// resto proveniente do módulo 11 com pesos de 2 a 7
		int restoDoModulo11 = new Modulo(TipoDeModulo.MODULO11, 7, 2).calcule(fields + primeiroDV);
		
		if (restoDoModulo11 == 0) {
			segundoDV = 0;
		} else	if (restoDoModulo11 == 1) {
			if (primeiroDV == 9) {
				primeiroDV = 0;
			} else {
				primeiroDV++;
			}
			segundoDV = (byte) new Modulo(TipoDeModulo.MODULO11, 7, 2).calcule(fields + primeiroDV);
		} else {
			segundoDV = (byte) (11 - restoDoModulo11);
		}
		
		duploDV = Byte.parseByte(String.valueOf(primeiroDV) + String.valueOf(segundoDV)); 
		
		return duploDV;
	}

	/**
	 * Calcula o primeiro dígito verificador.
	 * 
	 * @param fields 
	 * 
	 * @return O primeiro dígito verificador dos dois existentes na chave ASBACE (Campo livre).
	 */
	private byte calculaPrimeiroDV(String fields) {
		final byte primeiroDV;
		
		// resto proveniente do módulo 10
		byte restoDoModulo10 = (byte) new Modulo(TipoDeModulo.MODULO10).calcule(fields);
		
		// se não houver resto, primeiroDV = 0
		// caso contrário, primeiroDV = 10 - resto
		primeiroDV = (byte) ((restoDoModulo10 == 0) ? 0 : 10 - restoDoModulo10);
		return primeiroDV;
	}
	
	@Override
	protected void addFields(Titulo titulo) {
		// TODO IMPLEMENTAR
		throw new UnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
	}

	@Override
	protected void checkValues(Titulo titulo) {
		// TODO IMPLEMENTAR
		throw new UnsupportedOperationException("AINDA NÃO IMPLEMENTADO!");
	}

}
