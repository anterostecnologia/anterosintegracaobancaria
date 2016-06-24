package br.com.anteros.integracao.bancaria.banco.febraban.cnab.caixa;

import java.util.List;

import br.com.anteros.core.utils.Assert;
import br.com.anteros.flatfile.annotation.FlatFile;
import br.com.anteros.flatfile.annotation.InnerRecord;
import br.com.anteros.flatfile.annotation.Record;
import br.com.anteros.integracao.bancaria.banco.febraban.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.febraban.RemessaCobranca;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab.CNAB240;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab.CNABException;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab.HeaderArquivo;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab.HeaderTitulosCobranca;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab.TitulosCobrancaSegmentoP;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab.TitulosCobrancaSegmentoQ;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab.TraillerArquivo;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab.TraillerTitulosCobranca;

@FlatFile(name = "Arquivo CNAB240 - Caixa Econômica Federal", description = "Arquivo de remessa/retorno CNAB240", version = "1.0")
public class CaixaEconomicaFederalCNAB240 implements CNAB240 {

	private static final int VERSAO_LAYOUT_ARQUIVO_CEF = 50;
	private static final int VERSAO_LAYOUT_LOTE_CEF = 30;

	@Record(name = "Header", description = "Protocolo de comunicação", order = 1)
	private HeaderArquivo headerArquivo;

	@Record(name = "HeaderLoteCobranca", description = "Cabeçalho lote de titulos cobrança", order = 2)
	private HeaderTitulosCobranca headerTitulosCobranca;

	@Record(name = "TituloCobrancaSegmentoP", description = "Segmento P dos titulos cobrança", order = 3, repeatable = true)
	private TitulosCobrancaSegmentoP segmentoP;

	@InnerRecord(name = "TituloCobrancaSegmentoQ", description = "Segmento Q dos titulos cobrança", recordOwner = "TituloCobrancaSegmentoP", order = 4, repeatable = true)
	private TitulosCobrancaSegmentoQ segmentoQ;

	@Record(name = "TraillerLoteCobranca", description = "Resumo lote de titulos cobrança", order = 5)
	private TraillerTitulosCobranca traillerTitulosCobranca;

	@Record(name = "Trailler", order = 6)
	private TraillerArquivo traillerArquivo;

	public CaixaEconomicaFederalCNAB240(ContaBancaria contaBancaria, List<RemessaCobranca> remessas) {

		Assert.notNull(remessas, "Informe as remessas para geração do arquivo.");
		if (remessas.size() == 0) {
			throw new CNABException("Informe as remessas para geração do arquivo.");
		}

		headerArquivo = HeaderArquivo.of(contaBancaria,
				remessas.get(CNAB240.PRIMEIRA_REMESSA).getTitulo().getCarteira(),
				remessas.get(CNAB240.PRIMEIRA_REMESSA).getTitulo().getCedente(),
				VERSAO_LAYOUT_ARQUIVO_CEF);
		headerTitulosCobranca = HeaderTitulosCobranca.of(contaBancaria,
				remessas.get(CNAB240.PRIMEIRA_REMESSA).getTitulo().getCarteira(),
				remessas.get(CNAB240.PRIMEIRA_REMESSA).getTitulo().getCedente(), VERSAO_LAYOUT_LOTE_CEF);
		segmentoP = TitulosCobrancaSegmentoP.of(contaBancaria, remessas);
		segmentoQ = TitulosCobrancaSegmentoQ.of(contaBancaria, remessas);
		traillerTitulosCobranca = TraillerTitulosCobranca.of(contaBancaria, remessas);
		traillerArquivo = TraillerArquivo.of(contaBancaria);
	}
}
