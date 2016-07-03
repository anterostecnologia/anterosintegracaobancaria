package br.com.anteros.integracao.bancaria.banco.febraban.cnab240.bancobrasil;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.anteros.flatfile.annotation.FlatFile;
import br.com.anteros.integracao.bancaria.banco.febraban.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.febraban.RemessaCobranca;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.AbstractCNAB240;

@FlatFile(name = "Arquivo CNAB240 - Banco do Brasil", description = "Arquivo de remessa/retorno CNAB240", version = "1.0")
public class BancoBrasilCNAB240 extends AbstractCNAB240 {

	private static final int VERSAO_LAYOUT_ARQUIVO_BB = 83;
	private static final int VERSAO_LAYOUT_LOTE_BB = 42;

	public BancoBrasilCNAB240(ContaBancaria contaBancaria, Date dataHoraGeracao, Date dataGravacao) {
		super(contaBancaria, dataHoraGeracao, dataGravacao);
	}

	public BancoBrasilCNAB240(ContaBancaria contaBancaria, List<RemessaCobranca> remessas, Date dataHoraGeracao,
			Date dataGravacao) {
		super(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
	}

	public static BancoBrasilCNAB240 of(ContaBancaria contaBancaria, List<RemessaCobranca> remessas,
			Date dataHoraGeracao, Date dataGravacao) {
		return new BancoBrasilCNAB240(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
	}

	public static BancoBrasilCNAB240 of(ContaBancaria contaBancaria, Date dataHoraGeracao, Date dataGravacao) {
		return new BancoBrasilCNAB240(contaBancaria, dataHoraGeracao, dataGravacao);
	}

	public static BancoBrasilCNAB240 of(ContaBancaria contaBancaria, List<RemessaCobranca> remessas) {
		return new BancoBrasilCNAB240(contaBancaria, remessas, Calendar.getInstance().getTime(),
				Calendar.getInstance().getTime());
	}

	public static BancoBrasilCNAB240 of(ContaBancaria contaBancaria) {
		return new BancoBrasilCNAB240(contaBancaria, Calendar.getInstance().getTime(),
				Calendar.getInstance().getTime());
	}

	@Override
	public int getVersaoLayoutArquivo() {
		return VERSAO_LAYOUT_ARQUIVO_BB;
	}

	@Override
	public int getVersaoLayoutLote() {
		return VERSAO_LAYOUT_LOTE_BB;
	}

}
