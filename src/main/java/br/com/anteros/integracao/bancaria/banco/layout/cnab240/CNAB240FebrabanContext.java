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
package br.com.anteros.integracao.bancaria.banco.layout.cnab240;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.anteros.flatfile.annotation.FlatFile;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.RemessaCobranca;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.bancobrasil.BancoBrasilCNAB240Context;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.*;

@FlatFile(name = "Arquivo CNAB240", description = "Arquivo de remessa/retorno CNAB240", version = "1.0")
public class CNAB240FebrabanContext<T> extends AbstractCNAB240Context<T> {

	public CNAB240FebrabanContext(ContaBancaria contaBancaria, Date dataHoraGeracao, Date dataGravacao) {
		super(contaBancaria, dataHoraGeracao, dataGravacao);
	}

	public CNAB240FebrabanContext(ContaBancaria contaBancaria, List<RemessaCobranca> remessas, Date dataHoraGeracao,
			Date dataGravacao) {
		super(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
	}

	public static <T> CNAB240FebrabanContext<T> of(ContaBancaria contaBancaria, List<RemessaCobranca> remessas,
			Date dataHoraGeracao, Date dataGravacao) {
		return new CNAB240FebrabanContext<T>(contaBancaria, remessas, dataHoraGeracao, dataGravacao);
	}

	public static <T> CNAB240FebrabanContext<T> of(ContaBancaria contaBancaria, Date dataHoraGeracao, Date dataGravacao) {
		return new CNAB240FebrabanContext<T>(contaBancaria, dataHoraGeracao, dataGravacao);
	}

	public static <T> CNAB240FebrabanContext<T> of(ContaBancaria contaBancaria, List<RemessaCobranca> remessas) {
		return new CNAB240FebrabanContext<T>(contaBancaria, remessas, Calendar.getInstance().getTime(),
				Calendar.getInstance().getTime());
	}

	public static <T> BancoBrasilCNAB240Context<T> of(ContaBancaria contaBancaria) {
		return new BancoBrasilCNAB240Context<T>(contaBancaria, Calendar.getInstance().getTime(),
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
