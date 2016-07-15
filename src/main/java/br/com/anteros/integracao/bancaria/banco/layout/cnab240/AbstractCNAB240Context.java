package br.com.anteros.integracao.bancaria.banco.layout.cnab240;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBException;

import br.com.anteros.core.utils.Assert;
import br.com.anteros.flatfile.FlatFileManager;
import br.com.anteros.flatfile.FlatFileManagerException;
import br.com.anteros.flatfile.annotation.InnerRecord;
import br.com.anteros.flatfile.annotation.Record;
import br.com.anteros.integracao.bancaria.banco.layout.CNABException;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.RemessaCobranca;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.strategy.CNAB240Strategy;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.*;

public abstract class AbstractCNAB240Context<T> implements CNAB240Context<T> {

	@Record(name = HEADER, description = "Protocolo de comunicação", order = 1, groups = { REMESSA_COBRANCA, RETORNO_COBRANCA, RETORNO_CONCILIACAO_BANCARIA })
	protected HeaderArquivo headerArquivo;
	
	/**
	 * COBRANÇA
	 */

	@Record(name = HEADER_COBRANCA, description = "Cabeçalho lote de cobrança", order = 2, groups = {
			REMESSA_COBRANCA, RETORNO_COBRANCA })
	protected HeaderCobranca headerCobranca;

	@Record(name = COBRANCA_SEGMENTO_P, description = "Segmento P Remessa dos titulos cobrança", order = 3, repeatable = true, groups = {
			REMESSA_COBRANCA })
	protected CobrancaSegmentoP segmentoP;

	@InnerRecord(name = COBRANCA_SEGMENTO_Q, description = "Segmento Q Remessa dos titulos cobrança", recordOwner = COBRANCA_SEGMENTO_P, order = 4, repeatable = true, groups = {
			REMESSA_COBRANCA })
	protected CobrancaSegmentoQ segmentoQ;

	@Record(name = COBRANCA_SEGMENTO_T, description = "Segmento T Retorno dos titulos cobrança", order = 5, repeatable = true, groups = {
			RETORNO_COBRANCA })
	protected CobrancaSegmentoT segmentoT;

	@InnerRecord(name = COBRANCA_SEGMENTO_U, description = "Segmento U Retorno dos titulos cobrança", order = 6, repeatable = true, groups = {
			RETORNO_COBRANCA }, recordOwner = COBRANCA_SEGMENTO_T)
	protected CobrancaSegmentoU segmentoU;

	@Record(name = TRAILLER_COBRANCA, description = "Resumo lote de cobrança", order = 7, groups = {
			REMESSA_COBRANCA, RETORNO_COBRANCA })
	protected TraillerCobranca traillerCobranca;
	
	/**
	 * CONCILIAÇÃO BANCÁRIA
	 */
	@Record(name = HEADER_CONCILIACAO_BANCARIA, description = "Cabeçalho conciliação bancária", order = 8, groups = {
			RETORNO_CONCILIACAO_BANCARIA })
	protected HeaderConciliacaoBancaria headerConciliacaoBancaria;
	
	@Record(name = CONCILIACAO_BANCARIA_SEGMENTO_E, description = "Segmento E Conciliação bancária", order = 9, repeatable = true, groups = {
			RETORNO_CONCILIACAO_BANCARIA })
	protected ConciliacaoBancariaSegmentoE segmentoE;
	
	@Record(name = TRAILLER_CONCILIACAO_BANCARIA, description = "Resumo lote de cobrança", order = 10, groups = {
			RETORNO_CONCILIACAO_BANCARIA })
	protected TraillerConciliacaoBancaria traillerConciliacaoBancaria;
	
	

	@Record(name = TRAILLER, order = 11, groups = { REMESSA_COBRANCA, RETORNO_COBRANCA, RETORNO_CONCILIACAO_BANCARIA })
	protected TraillerArquivo traillerArquivo;

	private ContaBancaria contaBancaria;
	
	protected AbstractCNAB240Context(ContaBancaria contaBancaria, List<RemessaCobranca> remessas, Date dataHoraGeracao,
			Date dataGravacao) {
		Assert.notNull(remessas, "Informe as remessas para geração do arquivo.");
		if (remessas.size() == 0) {
			throw new CNABException("Informe as remessas para geração do arquivo.");
		}
		
		this.contaBancaria = contaBancaria;

		headerArquivo = HeaderArquivo.of(contaBancaria,
				remessas.get(PRIMEIRA_REMESSA).getTitulo().getCarteira(),
				remessas.get(PRIMEIRA_REMESSA).getTitulo().getCedente(), getVersaoLayoutArquivo(),
				dataHoraGeracao);
		headerCobranca = HeaderCobranca.of(contaBancaria,
				remessas.get(PRIMEIRA_REMESSA).getTitulo().getCarteira(),
				remessas.get(PRIMEIRA_REMESSA).getTitulo().getCedente(), getVersaoLayoutLote(), dataGravacao);
		headerConciliacaoBancaria = HeaderConciliacaoBancaria.of(contaBancaria);
		segmentoE = ConciliacaoBancariaSegmentoE.of(contaBancaria);
		segmentoP = CobrancaSegmentoP.of(contaBancaria, remessas);
		segmentoQ = CobrancaSegmentoQ.of(contaBancaria, remessas);
		segmentoT = CobrancaSegmentoT.of(contaBancaria);
		segmentoU = CobrancaSegmentoU.of(contaBancaria);
		traillerCobranca = TraillerCobranca.of(contaBancaria, remessas);
		traillerConciliacaoBancaria = TraillerConciliacaoBancaria.of(contaBancaria);
		traillerArquivo = TraillerArquivo.of(contaBancaria);
	}

	protected AbstractCNAB240Context(ContaBancaria contaBancaria, Date dataHoraGeracao, Date dataGravacao) {
		this.contaBancaria = contaBancaria;
		headerArquivo = HeaderArquivo.of(contaBancaria, dataHoraGeracao);
		headerCobranca = HeaderCobranca.of(contaBancaria, dataGravacao);
		headerConciliacaoBancaria = HeaderConciliacaoBancaria.of(contaBancaria);
		segmentoE = ConciliacaoBancariaSegmentoE.of(contaBancaria);
		segmentoT = CobrancaSegmentoT.of(contaBancaria);
		segmentoU = CobrancaSegmentoU.of(contaBancaria);
		traillerCobranca = TraillerCobranca.of(contaBancaria);
		traillerConciliacaoBancaria = TraillerConciliacaoBancaria.of(contaBancaria);
		traillerArquivo = TraillerArquivo.of(contaBancaria);
	}	

	public byte[] generate() throws FlatFileManagerException, JAXBException, IllegalArgumentException,
			IllegalAccessException, IOException {
		return generate(new String[] { GLOBAL });
	}

	public byte[] generate(String[] groups) throws FlatFileManagerException, JAXBException, IllegalArgumentException,
			IllegalAccessException, IOException {
		FlatFileManager manager = new FlatFileManager();
		return manager.generate(this, groups);
	}
	public byte[] getXMLSchema() throws FlatFileManagerException, JAXBException {
		return new FlatFileManager().getXMLSchema(this);
	}
	
	@Override
	public HeaderArquivo getHeaderArquivo() {
		return headerArquivo;
	}

	@Override
	public HeaderConciliacaoBancaria getHeaderConciliacaoBancaria() {
		return headerConciliacaoBancaria;
	}

	@Override
	public HeaderCobranca getHeaderCobranca() {
		return headerCobranca;
	}

	@Override
	public ConciliacaoBancariaSegmentoE getConciliacaoBancariaSegmentoE() {
		return segmentoE;
	}

	@Override
	public CobrancaSegmentoP getCobrancaSegmentoP() {
		return segmentoP;
	}

	@Override
	public CobrancaSegmentoQ getCobrancaSegmentoQ() {
		return segmentoQ;
	}

	@Override
	public CobrancaSegmentoT getCobrancaSegmentoT() {
		return segmentoT;
	}

	@Override
	public CobrancaSegmentoU getCobrancaSegmentoU() {
		return segmentoU;
	}

	@Override
	public TraillerArquivo getTraillerArquivo() {
		return traillerArquivo;
	}

	@Override
	public TraillerConciliacaoBancaria geTraillerConciliacaoBancaria() {
		return traillerConciliacaoBancaria;
	}

	@Override
	public TraillerCobranca geTraillerCobranca() {
		return traillerCobranca;
	}

	@Override
	public ContaBancaria getContaBancaria() {
		return contaBancaria;
	}

	@Override
	public List<T> read(CNAB240Strategy<T> strategy, File file, String[] groups) throws IOException,
			IllegalArgumentException, IllegalAccessException, FlatFileManagerException, JAXBException {
		return strategy.read(this, file, groups);
	}


}
