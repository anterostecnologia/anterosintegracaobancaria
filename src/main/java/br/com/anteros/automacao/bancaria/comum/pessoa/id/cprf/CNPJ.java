package br.com.anteros.automacao.bancaria.comum.pessoa.id.cprf;

import java.util.Objects;

import org.apache.logging.log4j.util.Strings;

import br.com.anteros.core.utils.Assert;
import br.com.anteros.core.utils.StringUtils;
import br.com.anteros.integracao.bancaria.validador.AbstractCPRFValidator;
import br.com.anteros.integracao.bancaria.validador.AbstractCPRFValidator.TipoDeCPRF;

/**
 * 
 * <p>
 * Representa o cadastro nacional de pssoa jurídica (CNPJ), um número
 * identificador de uma pessoa jurídica junto à Receita Federal, necessário para
 * que a pessoa jurídica tenha capacidade de fazer contratos e processar ou ser
 * processada.
 * </p>
 * 
 * <p>
 * O formato do CNPJ é "##.###.###/####-XX", onde XX é o dígito verificador
 * do número.
 * </p>
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
public class CNPJ extends AbstractCPRF {

	public CNPJ(Long numCNPJ) {

		try {
			if (AbstractCPRFValidator.isParametrosValidos(
					String.valueOf(numCNPJ), TipoDeCPRF.CNPJ)) {
				this.autenticadorCP = AbstractCPRFValidator.create(StringUtils.padZero(String.valueOf(numCNPJ), 14));
				if (autenticadorCP.isValido()){					
					initFromNumber(numCNPJ);					
				}else{
					throw new IllegalArgumentException("O cadastro de pessoa [ \"" + numCNPJ+ "\" ] não é válido.");
				}
			}

		} catch (Exception e) {
			if (!(e instanceof CNPJException))
				throw new CNPJException(e);
		}

	}

	public CNPJ(String strCNPJ) {

		this.autenticadorCP = AbstractCPRFValidator.create(strCNPJ);

		if (autenticadorCP.isValido()) {
			
			if(StringUtils.isNumber(strCNPJ)){				
				initFromNotFormattedString(strCNPJ);				
			}else{				
				initFromFormattedString(strCNPJ);				
			}
			
		} else {
			throw new CNPJException(new IllegalArgumentException(
					"O cadastro de pessoa [ \"" + strCNPJ + "\" ] não é válido."));
		}
	}
	
	public boolean isMatriz(){
		
		return getSufixoFormatado().equals("0001");
	}
	
	public boolean isSufixoEquals(String sufixoFormatado){
		StringUtils.checkNotNumeric(sufixoFormatado, String.format("O sufixo [%s] deve ser um número natural diferente de zero!", sufixoFormatado));
		
		return isSufixoEquals(Integer.valueOf(sufixoFormatado));
	}

	public boolean isSufixoEquals(Integer sufixo){
		
		Assert.notNull(sufixo,"Sufixo nulo!");
		Assert.checkArgument(sufixo > 0, String.format("O sufixo [%s] deve ser um número natural diferente de zero!", sufixo));
		
		return getSufixo().equals(sufixo);
	}
	
	public Integer getSufixo(){
		
		return Integer.valueOf(getSufixoFormatado());
	}
	
	public String getSufixoFormatado(){
		
		return getCodigoFormatado().split("-")[0].split("/")[1];
	}

	private void initFromNumber(Long numCNPJ) {

		try {

			this.setCodigoFormatado(format(StringUtils.padZero(String.valueOf(numCNPJ), 14)));
			this.setCodigo(numCNPJ);

		} catch (Exception e) {
			throw new CNPJException(e);
		}
	}
	private void initFromFormattedString(String strCNPJ) {
		
		try {
			
			this.setCodigoFormatado(strCNPJ);
			this.setCodigo(Long.parseLong(removeFormat(strCNPJ)));
			
		} catch (Exception e) {
			throw new CNPJException(e);
		}
	}
	
	private void initFromNotFormattedString(String strCNPJ) {
		
		try {
			
			this.setCodigoFormatado(format(strCNPJ));
			this.setCodigo(Long.parseLong(strCNPJ));
			
		} catch (Exception e) {
			throw new CNPJException(e);
		}
	}

	private String format(String strCNPJ) {
		
		StringBuilder codigoFormatado = new StringBuilder(strCNPJ);
		
		codigoFormatado.insert(2, '.');
		codigoFormatado.insert(6, '.');
		codigoFormatado.insert(10, '/');
		codigoFormatado.insert(15, '-');
		
		return codigoFormatado.toString();
	}

	private String removeFormat(String codigo) {

		codigo = codigo.replace(".", "");
		codigo = codigo.replace("/", "");
		codigo = codigo.replace("-", "");

		return codigo;
	}
	
}
