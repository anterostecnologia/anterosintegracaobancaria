/*******************************************************************************
 * Copyright 2016 Anteros Tecnologia
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package br.com.anteros.integracao.bancaria.banco.febraban.cnab240;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.anteros.flatfile.annotation.FlatFile;
import br.com.anteros.integracao.bancaria.banco.febraban.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.febraban.RemessaCobranca;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.bancobrasil.BancoBrasilCNAB240;

@FlatFile(name = "Arquivo CNAB240", description = "Arquivo de remessa/retorno CNAB240", version = "1.0")
public class CNAB240Febraban extends AbstractCNAB240 {

	public CNAB240Febraban(ContaBancaria contaBancaria, Date dataHoraGeracao, Date dataGravacao) {
		super(contaBancaria, dataHoraGeracao, dataGravacao);
	}

	public CNAB240Febraban(ContaBancaria contaBancaria, List<RemessaCobranca> remessas, Date dataHoraGeracao,
			Date dataGravacao) {
		super(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
	}

	public static CNAB240Febraban of(ContaBancaria contaBancaria, List<RemessaCobranca> remessas,
			Date dataHoraGeracao, Date dataGravacao) {
		return new CNAB240Febraban(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
	}

	public static CNAB240Febraban of(ContaBancaria contaBancaria, Date dataHoraGeracao, Date dataGravacao) {
		return new CNAB240Febraban(contaBancaria, dataHoraGeracao, dataGravacao);
	}

	public static CNAB240Febraban of(ContaBancaria contaBancaria, List<RemessaCobranca> remessas) {
		return new CNAB240Febraban(contaBancaria, remessas, Calendar.getInstance().getTime(),
				Calendar.getInstance().getTime());
	}

	public static BancoBrasilCNAB240 of(ContaBancaria contaBancaria) {
		return new BancoBrasilCNAB240(contaBancaria, Calendar.getInstance().getTime(),
				Calendar.getInstance().getTime());
	}

	@Override
	public int getVersaoLayoutArquivo() {
		return VERSAO_LAYOUT_ARQUIVO_FEBRABAN;
	}

	@Override
	public int getVersaoLayoutLote() {
		return VERSAO_LAYOUT_LOTE_FEBRABAN;
	}
}
