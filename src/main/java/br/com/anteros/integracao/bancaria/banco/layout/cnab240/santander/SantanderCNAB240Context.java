package br.com.anteros.integracao.bancaria.banco.layout.cnab240.santander;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.anteros.flatfile.annotation.FlatFile;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.RemessaCobranca;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.AbstractCNAB240Context;

@FlatFile(name = "Arquivo CNAB240 - Santander", description = "Arquivo de remessa/retorno CNAB240", version = "1.0")
public class SantanderCNAB240Context<T> extends AbstractCNAB240Context<T> {

	private static final int VERSAO_LAYOUT_ARQUIVO_ITAU = 40;
	private static final int VERSAO_LAYOUT_LOTE_ITAU = 30;

	public SantanderCNAB240Context(ContaBancaria contaBancaria, Date dataHoraGeracao, Date dataGravacao) {
		super(contaBancaria, dataHoraGeracao, dataGravacao);
	}

	public SantanderCNAB240Context(ContaBancaria contaBancaria, List<RemessaCobranca> remessas, Date dataHoraGeracao,
			Date dataGravacao) {
		super(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
	}

	public static <K> SantanderCNAB240Context<K> of(ContaBancaria contaBancaria, List<RemessaCobranca> remessas, Date dataHoraGeracao,
			Date dataGravacao) {
		return new SantanderCNAB240Context<K>(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
	}

	public static <K> SantanderCNAB240Context<K> of(ContaBancaria contaBancaria, Date dataHoraGeracao, Date dataGravacao) {
		return new SantanderCNAB240Context<K>(contaBancaria, dataHoraGeracao, dataGravacao);
	}

	public static <K> SantanderCNAB240Context<K> of(ContaBancaria contaBancaria, List<RemessaCobranca> remessas) {
		return new SantanderCNAB240Context<K>(contaBancaria, remessas, Calendar.getInstance().getTime(),
				Calendar.getInstance().getTime());
	}

	public static <K> SantanderCNAB240Context<K> of(ContaBancaria contaBancaria) {
		return new SantanderCNAB240Context<K>(contaBancaria, Calendar.getInstance().getTime(), Calendar.getInstance().getTime());
	}

	@Override
	public int getVersaoLayoutArquivo() {
		return VERSAO_LAYOUT_ARQUIVO_ITAU;
	}

	@Override
	public int getVersaoLayoutLote() {
		return VERSAO_LAYOUT_LOTE_ITAU;
	}

}