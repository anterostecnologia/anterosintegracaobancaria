package br.com.anteros.integracao.bancaria.banco.febraban.cnab240.hsbc;

import java.util.List;

import br.com.anteros.core.utils.Assert;
import br.com.anteros.flatfile.annotation.FlatFile;
import br.com.anteros.flatfile.annotation.InnerRecord;
import br.com.anteros.flatfile.annotation.Record;
import br.com.anteros.integracao.bancaria.banco.febraban.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.febraban.RemessaCobranca;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.CNAB240;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.CNABException;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.HeaderArquivo;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.HeaderTitulosCobranca;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.TitulosCobrancaSegmentoP;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.TitulosCobrancaSegmentoQ;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.TitulosCobrancaSegmentoT;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.TraillerArquivo;
import br.com.anteros.integracao.bancaria.banco.febraban.cnab240.TraillerTitulosCobranca;


@FlatFile(name = "Arquivo CNAB240 - Hsbc", description = "Arquivo de remessa/retorno CNAB240", version = "1.0")
public class HsbcCNAB240 implements CNAB240 {

	private static final int VERSAO_LAYOUT_ARQUIVO_HSBC = 10;
	private static final int VERSAO_LAYOUT_LOTE_HSBC = 10;

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


	public HsbcCNAB240(ContaBancaria contaBancaria, List<RemessaCobranca> remessas) {

		Assert.notNull(remessas, "Informe as remessas para geração do arquivo.");
		if (remessas.size() == 0) {
			throw new CNABException("Informe as remessas para geração do arquivo.");
		}

		headerArquivo = HeaderArquivo.of(contaBancaria,
				remessas.get(CNAB240.PRIMEIRA_REMESSA).getTitulo().getCarteira(),
				remessas.get(CNAB240.PRIMEIRA_REMESSA).getTitulo().getCedente(),
				VERSAO_LAYOUT_ARQUIVO_HSBC);
		headerTitulosCobranca = HeaderTitulosCobranca.of(contaBancaria,
				remessas.get(CNAB240.PRIMEIRA_REMESSA).getTitulo().getCarteira(),
				remessas.get(CNAB240.PRIMEIRA_REMESSA).getTitulo().getCedente(), VERSAO_LAYOUT_LOTE_HSBC);
		segmentoP = TitulosCobrancaSegmentoP.of(contaBancaria, remessas);
		segmentoQ = TitulosCobrancaSegmentoQ.of(contaBancaria, remessas);
		segmentoT = TitulosCobrancaSegmentoT.of(contaBancaria);
		traillerTitulosCobranca = TraillerTitulosCobranca.of(contaBancaria, remessas);
		traillerArquivo = TraillerArquivo.of(contaBancaria);
	}

}
