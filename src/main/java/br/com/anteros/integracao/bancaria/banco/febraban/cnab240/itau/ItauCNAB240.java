package br.com.anteros.integracao.bancaria.banco.febraban.cnab240.itau;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.anteros.flatfile.annotation.FlatFile;
import br.com.anteros.integracao.bancaria.banco.febraban.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.febraban.RemessaCobranca;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.AbstractCNAB240;

@FlatFile(name = "Arquivo CNAB240 - Itaú", description = "Arquivo de remessa/retorno CNAB240", version = "1.0")
public class ItauCNAB240 extends AbstractCNAB240 {

	private static final int VERSAO_LAYOUT_ARQUIVO_ITAU = 40;
	private static final int VERSAO_LAYOUT_LOTE_ITAU = 30;
	

	public ItauCNAB240(ContaBancaria contaBancaria, Date dataHoraGeracao, Date dataGravacao) {
		super(contaBancaria, dataHoraGeracao, dataGravacao);
	}

	public ItauCNAB240(ContaBancaria contaBancaria, List<RemessaCobranca> remessas, Date dataHoraGeracao,
			Date dataGravacao) {
		super(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
	}
	

	public static ItauCNAB240 of(ContaBancaria contaBancaria, List<RemessaCobranca> remessas, Date dataHoraGeracao,
			Date dataGravacao) {
		return new ItauCNAB240(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
	}

	public static ItauCNAB240 of(ContaBancaria contaBancaria, Date dataHoraGeracao, Date dataGravacao) {
		return new ItauCNAB240(contaBancaria, dataHoraGeracao, dataGravacao);
	}

	public static ItauCNAB240 of(ContaBancaria contaBancaria, List<RemessaCobranca> remessas) {
		return new ItauCNAB240(contaBancaria, remessas, Calendar.getInstance().getTime(),
				Calendar.getInstance().getTime());
	}

	public static ItauCNAB240 of(ContaBancaria contaBancaria) {
		return new ItauCNAB240(contaBancaria, Calendar.getInstance().getTime(), Calendar.getInstance().getTime());
	}

	@Override
	public int getVersaoLayoutArquivo() {
		return VERSAO_LAYOUT_ARQUIVO_ITAU;
	}

	@Override
	public int getVersaoLayoutLote() {
		return VERSAO_LAYOUT_LOTE_ITAU	;
	}

}
