package br.com.anteros.automacao.bancaria.comum.pessoa.endereco;

import static java.lang.String.format;

import br.com.anteros.core.utils.Assert;


/**
 * <p>
 * Enumera as unidades federativas do Brasil.
 * </p>
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L</a>
 * @author <a href="mailto:misaelbarreto@gmail.com">Misael Barreto</a> 
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 * @author <a href="http://www.nordestefomento.com.br">Nordeste Fomento Mercantil</a>
 * @author <a href="mailto:samuelvalerio@gmail.com">Samuel Valério</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public enum UnidadeFederativa {

	AM("Amazonas","AM","Manaus"),
	PA("Pará","PA","Belém"),
	MT("Mato Grosso","MT","Cuiabá"),
	MG("Minas Gerais","MG","Belo Horizonte"),
	BA("Bahia","BA","Salvador"),
	MS("Mato Grosso do Sul","MS","Campo Grande"),
	GO("Goiás","GO","Goiânia"),
	MA("Maranhão","MA","São Luís"),
	RS("Rio Grande do Sul","RS","Porto Alegre"),
	TO("Tocantins","TO","Palmas"),
	PI("Piauí","PI","Teresina"),
	SP("São Paulo","SP","São Paulo"),
	RO("Rondônia","RO","Porto Velho"),
	RR("Roraima","RR","Boa Vista"),
	PR("Paraná","PR","Curitiba"),
	AC("Acre","AC","Rio Branco"),
	CE("Ceará","CE","Fortaleza"),
	AP("Amapá","AP","Macapá"),
	PE("Pernambuco","PE","Recife"),
	SC("Santa Catarina","SC","Florianópolis"),
	PB("Paraíba","PB","João Pessoa"),
	RN("Rio Grande do Norte","RN","Natal"),
	ES("Espírito Santo","ES","Vitória"),
	RJ("Rio de Janeiro","RJ","Rio de Janeiro"),
	AL("Alagoas","AL","Maceió"),
	SE("Sergipe","SE","Aracaju"),
	DF("Distrito Federal","DF","Brasília"),
	DESCONHECIDO("","","");
	
	private String nome;
	
	private String sigla;
	
	private String capital;
	
	UnidadeFederativa(String nome,String sigla,String capital){
		this.nome = nome;
		this.sigla = sigla;
		this.capital = capital;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @return the sigla
	 */
	public String getSigla() {
		return sigla;
	}

	/**
	 * @return the capital
	 */
	public String getCapital() {
		return capital;
	}
	
	/**
	 * <p>
	 * Retorna uma instância que corresponde com a sigla informada, ao contrário
	 * do método {@link UnidadeFederativa#valueOf(String)}, este não diferencia
	 * maiúsculas de minúsculas. Caso não exista um tipo associado a sigla ou
	 * seja informada uma string vazia, uma {@code IllegalArgumentException}
	 * será lançada.
	 * </p>
	 * 
	 * @param sigla
	 *            - Sigla correspondente a um estado
	 * @return UnidadeFederativa
	 * 
	 * @since 0.2
	 */
	public static UnidadeFederativa valueOfSigla(String sigla) {

		Assert.notNull(sigla, format(
				"Não existe Unidade Federativa com sigla vazia \"%s\"", sigla));

		return valueOf(sigla.toUpperCase());
	}
}
