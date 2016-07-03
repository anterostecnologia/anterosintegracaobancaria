package br.com.anteros.integracao.bancaria.banco.febraban.cnab240.caixa;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.anteros.flatfile.annotation.FlatFile;
import br.com.anteros.integracao.bancaria.banco.febraban.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.febraban.RemessaCobranca;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.AbstractCNAB240;

@FlatFile(name = "Arquivo CNAB240 - Caixa Econômica Federal", description = "Arquivo de remessa/retorno CNAB240", version = "1.0")
public class CaixaEconomicaFederalCNAB240 extends AbstractCNAB240 {

	private static final int VERSAO_LAYOUT_ARQUIVO_CEF = 50;
	private static final int VERSAO_LAYOUT_LOTE_CEF = 30;

	public CaixaEconomicaFederalCNAB240(ContaBancaria contaBancaria, Date dataHoraGeracao, Date dataGravacao) {
		super(contaBancaria, dataHoraGeracao, dataGravacao);
	}

	public CaixaEconomicaFederalCNAB240(ContaBancaria contaBancaria, List<RemessaCobranca> remessas, Date dataHoraGeracao,
			Date dataGravacao) {
		super(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
	}

	public static CaixaEconomicaFederalCNAB240 of(ContaBancaria contaBancaria, List<RemessaCobranca> remessas,
			Date dataHoraGeracao, Date dataGravacao) {
		return new CaixaEconomicaFederalCNAB240(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
	}

	public static CaixaEconomicaFederalCNAB240 of(ContaBancaria contaBancaria, Date dataHoraGeracao,
			Date dataGravacao) {
		return new CaixaEconomicaFederalCNAB240(contaBancaria, dataHoraGeracao, dataGravacao);
	}

	public static CaixaEconomicaFederalCNAB240 of(ContaBancaria contaBancaria, List<RemessaCobranca> remessas) {
		return new CaixaEconomicaFederalCNAB240(contaBancaria, remessas, Calendar.getInstance().getTime(),
				Calendar.getInstance().getTime());
	}

	public static CaixaEconomicaFederalCNAB240 of(ContaBancaria contaBancaria) {
		return new CaixaEconomicaFederalCNAB240(contaBancaria, Calendar.getInstance().getTime(),
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
