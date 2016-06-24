package br.com.anteros.integracao.bancaria.banco.febraban;

import br.com.anteros.core.utils.StringUtils;

/**
 * <p>
 * Esta classe segue o padrão especificado pela FEBRABAN:
 * <br/>
 * Invariantes:
 * <ul>
 * <li>Código: deve ser um inteiro natural (incluindo zero) entre 1 e 5 dígitos</li>
 * <li>Dígito Verificador: alpha-numérico sendo um inteiro natural (incluindo zero)
 * ou caracter não vazio (' ') com um dígito.</li>
 * </ul>
 * </p>
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a> 
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * @author <a href="mailto:misaelbarreto@gmail.com">Misael Barreto</a>
 * @author <a href="mailto:samuelvalerio@gmail.com">Samuel Valério</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public class Agencia implements br.com.anteros.integracao.bancaria.banco.Agencia<Integer, String> {

	private final Integer codigo;

	private final String digitoVerificador;
	
	public Agencia(Integer codigo) {

		this.codigo = codigo;
		verifyCodigo();
		this.digitoVerificador = StringUtils.EMPTY;
	}
	
	public Agencia(Integer codigo, String digito) {

		this.codigo = codigo;
		verifyCodigo();
		this.digitoVerificador = digito;
		verifyDv();
	}
	
	public void verifyCodigo() {

		if (codigo < 0 ) {
			throw new IllegalArgumentException("O código da agência deve ser um inteiro natural (incluindo zero)");
		}
		
		if (String.valueOf(codigo).length() > 5) {
			throw new IllegalArgumentException("O código da agência deve possuir de 1 a 5 dígitos");
		}
	}
	
	public void verifyDv(){
		
		if (StringUtils.isBlank(digitoVerificador)) {
			throw new IllegalArgumentException("O dígito verificador da agência não pode ser null ou apenas espaços em branco");
		}
		
		if (digitoVerificador.length() > 1) {
			throw new IllegalArgumentException("O dígito verificador da agência deve possuir apenas um dígito");
		}
			
		if (!StringUtils.isAlphanumeric(digitoVerificador)) {
			throw new IllegalArgumentException("O dígito verificador da agência deve ser letra ou dígito");
		}
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDigitoVerificador() {
		return digitoVerificador;
	}

	@Override
	public String toString() {
		return "Agencia [codigo=" + codigo + ", digitoVerificador=" + digitoVerificador + "]";
	}
	
}
