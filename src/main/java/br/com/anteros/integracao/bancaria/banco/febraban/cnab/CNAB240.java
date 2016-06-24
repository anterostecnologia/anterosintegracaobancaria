package br.com.anteros.integracao.bancaria.banco.febraban.cnab;

import java.util.List;

import br.com.anteros.core.utils.Assert;
import br.com.anteros.flatfile.annotation.FlatFile;
import br.com.anteros.flatfile.annotation.InnerRecord;
import br.com.anteros.flatfile.annotation.Record;
import br.com.anteros.integracao.bancaria.banco.febraban.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.febraban.RemessaCobranca;

@FlatFile(name = "Arquivo CNAB240", description = "Arquivo de remessa/retorno CNAB240", version = "1.0")
public class CNAB240 {

	private static final int PRIMEIRA_REMESSA = 0;

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


	public CNAB240(ContaBancaria contaBancaria, List<RemessaCobranca> remessas) {
		
		Assert.notNull(remessas,"Informe as remessas para geração do arquivo.");
		if (remessas.size()==0){
			throw new CNABException("Informe as remessas para geração do arquivo.");
		}
		
		headerArquivo = HeaderArquivo.of(contaBancaria, remessas.get(PRIMEIRA_REMESSA).getTitulo().getCarteira(), remessas.get(PRIMEIRA_REMESSA).getTitulo().getCedente());
		headerTitulosCobranca = HeaderTitulosCobranca.of(contaBancaria,remessas.get(PRIMEIRA_REMESSA).getTitulo().getCarteira(), remessas.get(PRIMEIRA_REMESSA).getTitulo().getCedente());
		segmentoP = TitulosCobrancaSegmentoP.of(contaBancaria,remessas);
		segmentoQ = TitulosCobrancaSegmentoQ.of(contaBancaria,remessas);
		traillerTitulosCobranca = TraillerTitulosCobranca.of(contaBancaria,remessas);
		traillerArquivo = TraillerArquivo.of(contaBancaria);
	}
	
	

}
