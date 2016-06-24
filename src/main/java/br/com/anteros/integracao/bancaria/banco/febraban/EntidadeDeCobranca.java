package br.com.anteros.integracao.bancaria.banco.febraban;

import java.util.Collection;

import br.com.anteros.automacao.bancaria.comum.pessoa.contato.NumeroDeTelefone;
import br.com.anteros.automacao.bancaria.comum.pessoa.endereco.Endereco;
import br.com.anteros.automacao.bancaria.comum.pessoa.id.cprf.CPRF;
import br.com.anteros.integracao.bancaria.banco.Pessoa;


/**
 * Supertipo para as entidades de cobrança (Sacado, Cedente, SacadorAvalista). Encapsula
 * a composição com o objeto Pessoa deixando apenas as particularidades de cada entidade nos subtipos.
 * 
 * @author <a href="mailto:romulomail@gmail.com">Rômulo Augusto</a>
 *
 * @since 0.2
 * 
 * @version 0.2
 */
public class EntidadeDeCobranca{

	/**
	 * Utilizado como composição
	 */
	private Pessoa pessoa;
	
	public EntidadeDeCobranca(String nome) {
		pessoa = new Pessoa(nome);
	}
	
	public EntidadeDeCobranca(String nome, String cadastroDePessoa) {
		pessoa = new Pessoa(nome, cadastroDePessoa);
	}
	
	public EntidadeDeCobranca(String nome, CPRF cadastroDePessoa) {
		pessoa = new Pessoa(nome, cadastroDePessoa);
	}
	
	/**
	 * @return Nome da entidade
	 */
	public String getNome() {
		return pessoa.getNome();
	}
	
	public void setNome(String nome) {
		pessoa.setNome(nome);
	}
	
	/**
	 * @see CPRF
	 */
	public CPRF getCPRF() {
		return pessoa.getCPRF();
	}
	
	/**
	 * @see CPRF
	 */
	public void setCPRF(CPRF cprf) {
		pessoa.setCPRF(cprf);
	}
	
	/**
	 * @see ContaBancaria
	 */
	public void addContaBancaria(ContaBancaria contaBancaria) {
		pessoa.addContaBancaria(contaBancaria);
	}
	
	/** 
	 * Verifica se esta pessoa tem alguma conta bancária.
	 * 
	 * @see ContaBancaria
	 */
	public boolean hasContaBancaria(){
		return pessoa.hasContaBancaria();
	}
	
	/**
	 * @return A próxima conta bancária
	 */
	public ContaBancaria getNextContaBancaria(){
		
		return pessoa.getNextContaBancaria();
	}
	
	/**
	 * @see ContaBancaria
	 * @see Collection
	 */
	public Collection<ContaBancaria> getContasBancarias() {
		return pessoa.getContasBancarias();
	}
	
	/**
	 * @see ContaBancaria
	 * @see Collection
	 */
	public void setContasBancarias(Collection<ContaBancaria> contasBancarias) {
		pessoa.setContasBancarias(contasBancarias);
	}
	
	/**
	 * @see Endereco
	 */
	public void addEndereco(Endereco endereco) {
		pessoa.addEndereco(endereco);
	}
	
	/**
	 * @return O próximo endereço da entidade.
	 */
	public Endereco getNextEndereco(){
		
		return pessoa.getNextEndereco(); 
	}
	
	/**
	 * @see Endereco
	 * @see Collection
	 */
	public Collection<Endereco> getEnderecos() {
		return pessoa.getEnderecos();
	}
	
	/**
	 * @see Endereco
	 * @see Collection
	 */
	public void setEnderecos(Collection<Endereco> enderecos) {
		pessoa.setEnderecos(enderecos);
	}

	/**
	 * @see NumeroDeTelefone
	 */
	public void addTelefone(NumeroDeTelefone telefone) {
		pessoa.addTelefone(telefone);
	}

	/**
	 * @return O próximo telefone da entidade.
	 */
	public NumeroDeTelefone getNextTelefone(){
		
		return pessoa.getNextTelefone(); 
	}
	
	/**
	 * @see NumeroDeTelefone
	 * @see Collection
	 */
	public Collection<NumeroDeTelefone> getTelefones() {
		return pessoa.getTelefones();
	}

	/**
	 * @see NumeroDeTelefone
	 * @see Collection
	 */
	public void setTelefones(Collection<NumeroDeTelefone> telefones) {
		pessoa.setTelefones(telefones);
	}

}
