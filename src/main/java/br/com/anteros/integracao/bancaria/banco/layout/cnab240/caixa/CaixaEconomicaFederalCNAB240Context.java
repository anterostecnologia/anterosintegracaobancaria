package br.com.anteros.integracao.bancaria.banco.layout.cnab240.caixa;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.anteros.flatfile.annotation.FlatFile;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.RemessaCobranca;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.AbstractCNAB240Context;

@FlatFile(name = "Arquivo CNAB240 - Caixa Econômica Federal", description = "Arquivo de remessa/retorno CNAB240", version = "1.0")
public class CaixaEconomicaFederalCNAB240Context<T> extends AbstractCNAB240Context<T> {

	private static final int VERSAO_LAYOUT_ARQUIVO_CEF = 50;
	private static final int VERSAO_LAYOUT_LOTE_CEF = 30;

	public CaixaEconomicaFederalCNAB240Context(ContaBancaria contaBancaria, Date dataHoraGeracao, Date dataGravacao) {
		super(contaBancaria, dataHoraGeracao, dataGravacao);
	}

	public CaixaEconomicaFederalCNAB240Context(ContaBancaria contaBancaria, List<RemessaCobranca> remessas, Date dataHoraGeracao,
			Date dataGravacao) {
		super(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
	}

	public static <K> CaixaEconomicaFederalCNAB240Context<K> of(ContaBancaria contaBancaria, List<RemessaCobranca> remessas,
			Date dataHoraGeracao, Date dataGravacao) {
		return new CaixaEconomicaFederalCNAB240Context<K>(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
	}

	public static <K> CaixaEconomicaFederalCNAB240Context<K> of(ContaBancaria contaBancaria, Date dataHoraGeracao,
			Date dataGravacao) {
		return new CaixaEconomicaFederalCNAB240Context<K>(contaBancaria, dataHoraGeracao, dataGravacao);
	}

	public static <K> CaixaEconomicaFederalCNAB240Context<K> of(ContaBancaria contaBancaria, List<RemessaCobranca> remessas) {
		return new CaixaEconomicaFederalCNAB240Context<K>(contaBancaria, remessas, Calendar.getInstance().getTime(),
				Calendar.getInstance().getTime());
	}

	public static <K> CaixaEconomicaFederalCNAB240Context<K> of(ContaBancaria contaBancaria) {
		return new CaixaEconomicaFederalCNAB240Context<K>(contaBancaria, Calendar.getInstance().getTime(),
				Calendar.getInstance().getTime());
	}

	@Override
	public int getVersaoLayoutArquivo() {
		return VERSAO_LAYOUT_ARQUIVO_CEF;
	}

	@Override
	public int getVersaoLayoutLote() {
		return VERSAO_LAYOUT_LOTE_CEF;
	}
}
