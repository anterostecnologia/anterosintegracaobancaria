package br.com.anteros.integracao.bancaria.banco.layout.cnab240;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.anteros.integracao.bancaria.banco.layout.CNABException;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.RemessaPagamento;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.pagamento.bradesco.BancoBradescoCNAB240Pagamento;
import br.com.anteros.integracao.bancaria.util.Constants;

public class CNAB240PagamentoBuilder {

	private List<RemessaPagamento> remessas;

	private ContaBancaria contaBancaria;

	private Date dataGravacao = Calendar.getInstance().getTime();

	private Date dataHoraGeracao = Calendar.getInstance().getTime();

	private Integer numeroSequencialArquivo;

	public CNAB240PagamentoBuilder remessas(List<RemessaPagamento> remessas) {
		this.remessas = remessas;
		return this;
	}

	public CNAB240PagamentoBuilder contaBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
		return this;
	}

	public CNAB240PagamentoBuilder dataGravacao(Date dataGravacao) {
		this.dataGravacao = dataGravacao;
		return this;
	}

	public CNAB240PagamentoBuilder dataHoraGeracao(Date dataHoraGeracao) {
		this.dataHoraGeracao = dataHoraGeracao;
		return this;
	}

	public CNAB240PagamentoBuilder numeroSequencialArquivo(Integer numeroSequencialArquivo) {
		this.numeroSequencialArquivo = numeroSequencialArquivo;
		return this;
	}

	public CNAB240Pagamento build() {
		if (contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo().equals(Constants.BRADESCO)) {
			return BancoBradescoCNAB240Pagamento.of(contaBancaria, remessas, dataHoraGeracao, dataGravacao, numeroSequencialArquivo);
		}
		throw new CNABException("Layout CNAB240 do banco " + contaBancaria.getBanco().getNome() + " ainda não implementado.");
	}

}
