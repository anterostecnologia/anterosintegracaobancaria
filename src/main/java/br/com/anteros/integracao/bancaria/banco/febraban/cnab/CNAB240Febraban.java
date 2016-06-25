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
package br.com.anteros.integracao.bancaria.banco.febraban.cnab;

import java.util.List;

import br.com.anteros.core.utils.Assert;
import br.com.anteros.flatfile.annotation.FlatFile;
import br.com.anteros.flatfile.annotation.InnerRecord;
import br.com.anteros.flatfile.annotation.Record;
import br.com.anteros.integracao.bancaria.banco.febraban.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.febraban.RemessaCobranca;

@FlatFile(name = "Arquivo CNAB240", description = "Arquivo de remessa/retorno CNAB240", version = "1.0")
public class CNAB240Febraban implements CNAB240 {

	@Record(name = "Header", description = "Protocolo de comunicação", order = 1, groups={"REMESSA","RETORNO"})
	private HeaderArquivo headerArquivo;

	@Record(name = "HeaderLoteCobranca", description = "Cabeçalho lote de titulos cobrança", order = 2, groups={"REMESSA","RETORNO"})
	private HeaderTitulosCobranca headerTitulosCobranca;

	@Record(name = "TituloCobrancaSegmentoP", description = "Segmento P Remessa dos titulos cobrança", order = 3, repeatable = true, groups={"REMESSA"})
	private TitulosCobrancaSegmentoP segmentoP;

	@InnerRecord(name = "TituloCobrancaSegmentoQ", description = "Segmento Q Remessa dos titulos cobrança", recordOwner = "TituloCobrancaSegmentoP", order = 4, repeatable = true, groups={"REMESSA"})
	private TitulosCobrancaSegmentoQ segmentoQ;

	@Record(name = "TituloCobrancaSegmentoT", description = "Segmento T Retorno dos titulos cobrança", order = 5, repeatable = true, groups={"RETORNO"})
	private TitulosCobrancaSegmentoT segmentoT;

	@Record(name = "TraillerLoteCobranca", description = "Resumo lote de titulos cobrança", order = 5)
	private TraillerTitulosCobranca traillerTitulosCobranca;

	@Record(name = "Trailler", order = 6)
	private TraillerArquivo traillerArquivo;

	public CNAB240Febraban(ContaBancaria contaBancaria, List<RemessaCobranca> remessas) {

		Assert.notNull(remessas, "Informe as remessas para geração do arquivo.");
		if (remessas.size() == 0) {
			throw new CNABException("Informe as remessas para geração do arquivo.");
		}

		headerArquivo = HeaderArquivo.of(contaBancaria,
				remessas.get(CNAB240.PRIMEIRA_REMESSA).getTitulo().getCarteira(),
				remessas.get(CNAB240.PRIMEIRA_REMESSA).getTitulo().getCedente(),
				CNAB240.VERSAO_LAYOUT_ARQUIVO_FEBRABAN);
		headerTitulosCobranca = HeaderTitulosCobranca.of(contaBancaria,
				remessas.get(CNAB240.PRIMEIRA_REMESSA).getTitulo().getCarteira(),
				remessas.get(CNAB240.PRIMEIRA_REMESSA).getTitulo().getCedente(), CNAB240.VERSAO_LAYOUT_LOTE_FEBRABAN);
		segmentoP = TitulosCobrancaSegmentoP.of(contaBancaria, remessas);
		segmentoQ = TitulosCobrancaSegmentoQ.of(contaBancaria, remessas);
		segmentoT = TitulosCobrancaSegmentoT.of(contaBancaria);
		traillerTitulosCobranca = TraillerTitulosCobranca.of(contaBancaria, remessas);
		traillerArquivo = TraillerArquivo.of(contaBancaria);
	}

}
