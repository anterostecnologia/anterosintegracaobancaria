package br.com.anteros.integracao.bancaria.banco.febraban;

import br.com.anteros.core.utils.StringUtils;

/**
 * <p>
 * Representa as moedas existentes que fazem parte do universo de um título, segundo a FEBRABAN.
 * </p>
 * 
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * @author <a href="mailto:misaelbarreto@gmail.com">Misael Barreto</a> 
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * @author <a href="http://www.nordestefomento.com.br">Nordeste Fomento Mercantil</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public enum TipoDeMoeda {
	
	/**
	 * Padrão FEBRABAN
	 */
	
	DOLAR_AMERICANO_COMERCIAL_VENDA(2),
	DOLAR_AMERICANO_TURISMO_VENDA(3),
	ITRD(4),
	IDTR(5),
	UFIR_DIARIA(6),
	UFIR_MENSAL(7),
	FAJ_TR(8),
	REAL(9),
	TR(10),
	IGPM(11),
	CDI(12),
	PERCENTUAL_DO_CDI(13),
	EURO(14);

	private int codigo;
	
	/**
	 * @param codigo
	 */
	private TipoDeMoeda(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		
		return this.codigo;
	}
	
	public String write(){
		
		String s = StringUtils.EMPTY;
		
		switch (this) {
			
			case REAL:
				s = "R$";
				break;
		
			default:
				s += this.getCodigo();
		}
		
		return s;
	}
}
