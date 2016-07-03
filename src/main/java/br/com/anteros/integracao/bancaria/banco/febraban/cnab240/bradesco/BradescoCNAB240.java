package br.com.anteros.integracao.bancaria.banco.febraban.cnab240.bradesco;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.anteros.flatfile.annotation.FlatFile;
import br.com.anteros.integracao.bancaria.banco.febraban.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.febraban.RemessaCobranca;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.AbstractCNAB240;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.CNAB240;

@FlatFile(name = "Arquivo CNAB240 - Bradesco", description = "Arquivo de remessa/retorno CNAB240", version = "1.0")
public class BradescoCNAB240 extends AbstractCNAB240 {

	private static final int VERSAO_LAYOUT_LOTE_BRADESCO = 42;

	public BradescoCNAB240(ContaBancaria contaBancaria, Date dataHoraGeracao, Date dataGravacao) {
		super(contaBancaria, dataHoraGeracao, dataGravacao);
	}

	public BradescoCNAB240(ContaBancaria contaBancaria, List<RemessaCobranca> remessas, Date dataHoraGeracao,
			Date dataGravacao) {
		super(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
	}

	public static BradescoCNAB240 of(ContaBancaria contaBancaria, List<RemessaCobranca> remessas, Date dataHoraGeracao,
			Date dataGravacao) {
		return new BradescoCNAB240(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
	}

	public static BradescoCNAB240 of(ContaBancaria contaBancaria, Date dataHoraGeracao, Date dataGravacao) {
		return new BradescoCNAB240(contaBancaria, dataHoraGeracao, dataGravacao);
	}

	public static BradescoCNAB240 of(ContaBancaria contaBancaria, List<RemessaCobranca> remessas) {
		return new BradescoCNAB240(contaBancaria, remessas, Calendar.getInstance().getTime(),
				Calendar.getInstance().getTime());
	}

	public static BradescoCNAB240 of(ContaBancaria contaBancaria) {
		return new BradescoCNAB240(contaBancaria, Calendar.getInstance().getTime(), Calendar.getInstance().getTime());
	}

	@Override
	public int getVersaoLayoutArquivo() {
		return CNAB240.VERSAO_LAYOUT_ARQUIVO_FEBRABAN;
	}

	@Override
	public int getVersaoLayoutLote() {
		return VERSAO_LAYOUT_LOTE_BRADESCO;
	}
}
