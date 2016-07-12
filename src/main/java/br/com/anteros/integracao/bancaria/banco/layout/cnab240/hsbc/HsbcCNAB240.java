package br.com.anteros.integracao.bancaria.banco.layout.cnab240.hsbc;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.anteros.flatfile.annotation.FlatFile;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.RemessaCobranca;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.AbstractCNAB240;

@FlatFile(name = "Arquivo CNAB240 - Hsbc", description = "Arquivo de remessa/retorno CNAB240", version = "1.0")
public class HsbcCNAB240 extends AbstractCNAB240 {

	private static final int VERSAO_LAYOUT_ARQUIVO_HSBC = 10;
	private static final int VERSAO_LAYOUT_LOTE_HSBC = 10;

	public HsbcCNAB240(ContaBancaria contaBancaria, Date dataHoraGeracao, Date dataGravacao) {
		super(contaBancaria, dataHoraGeracao, dataGravacao);
	}

	public HsbcCNAB240(ContaBancaria contaBancaria, List<RemessaCobranca> remessas, Date dataHoraGeracao,
			Date dataGravacao) {
		super(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
	}

	public static HsbcCNAB240 of(ContaBancaria contaBancaria, List<RemessaCobranca> remessas, Date dataHoraGeracao,
			Date dataGravacao) {
		return new HsbcCNAB240(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
	}

	public static HsbcCNAB240 of(ContaBancaria contaBancaria, Date dataHoraGeracao, Date dataGravacao) {
		return new HsbcCNAB240(contaBancaria, dataHoraGeracao, dataGravacao);
	}

	public static HsbcCNAB240 of(ContaBancaria contaBancaria, List<RemessaCobranca> remessas) {
		return new HsbcCNAB240(contaBancaria, remessas, Calendar.getInstance().getTime(),
				Calendar.getInstance().getTime());
	}

	public static HsbcCNAB240 of(ContaBancaria contaBancaria) {
		return new HsbcCNAB240(contaBancaria, Calendar.getInstance().getTime(), Calendar.getInstance().getTime());
	}

	@Override
	public int getVersaoLayoutArquivo() {
		return VERSAO_LAYOUT_ARQUIVO_HSBC;
	}

	@Override
	public int getVersaoLayoutLote() {
		return VERSAO_LAYOUT_LOTE_HSBC;
	}

}
