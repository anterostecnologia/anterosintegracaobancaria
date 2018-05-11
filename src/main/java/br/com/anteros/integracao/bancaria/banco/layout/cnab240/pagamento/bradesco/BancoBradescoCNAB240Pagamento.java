package br.com.anteros.integracao.bancaria.banco.layout.cnab240.pagamento.bradesco;

import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBException;

import br.com.anteros.core.utils.Assert;
import br.com.anteros.flatfile.FlatFileManagerException;
import br.com.anteros.flatfile.annotation.FlatFile;
import br.com.anteros.flatfile.annotation.InnerRecord;
import br.com.anteros.flatfile.annotation.Record;
import br.com.anteros.integracao.bancaria.banco.layout.CNABException;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.RemessaPagamento;
import br.com.anteros.integracao.bancaria.banco.layout.RetornoPagamento;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.CNAB240Pagamento;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.cobranca.sicoob.HeaderArquivo;
import br.com.anteros.integracao.bancaria.banco.layout.cnab240.cobranca.sicoob.TraillerArquivo;

@FlatFile(name = "Arquivo CNAB240 - Banco Bradesco", description = "Arquivo de remessa/retorno PAGAMENTO CNAB240", version = "1.0")
public class BancoBradescoCNAB240Pagamento implements CNAB240Pagamento {

	@Record(name = HEADER, description = "Protocolo de comunicação", order = 1, groups = { REMESSA_PAGAMENTO, RETORNO_PAGAMENTO })
	protected HeaderArquivo headerArquivo;

	@Record(name = HEADER_LOTE, description = "Cabeçalho lote de pagamento", order = 2, groups = { REMESSA_PAGAMENTO, RETORNO_PAGAMENTO })
	protected HeaderLote headerLote;

	@Record(name = PAGAMENTO_SEGMENTO_A, description = "Segmento A Remessa dos pagamentos", order = 3, repeatable = true, groups = { REMESSA_PAGAMENTO, RETORNO_PAGAMENTO })
	protected PagamentoSegmentoA pagamentoSegmentoA;
	
	@InnerRecord(name = PAGAMENTO_SEGMENTO_B, description = "Segmento B Remessa dos pagamentos", recordOwner = PAGAMENTO_SEGMENTO_A, order = 4, repeatable = true, groups = { REMESSA_PAGAMENTO, RETORNO_PAGAMENTO })
	protected PagamentoSegmentoB pagamentoSegmentoB;

	@InnerRecord(name = PAGAMENTO_SEGMENTO_J, description = "Segmento J Remessa dos pagamentos", recordOwner = PAGAMENTO_SEGMENTO_A, order = 5, repeatable = true, groups = { REMESSA_PAGAMENTO, RETORNO_PAGAMENTO })
	protected PagamentoSegmentoJ pagamentoSegmentoJ;
	
	@Record(name = TRAILLER_PAGAMENTO, description = "Resumo lote de pagamento", order = 6, groups = { REMESSA_PAGAMENTO, RETORNO_PAGAMENTO })
	protected TraillerLote traillerLote;

	@Record(name = TRAILLER, order = 7, groups = { REMESSA_PAGAMENTO, RETORNO_PAGAMENTO })
	protected TraillerArquivo traillerArquivo;
	
	private ContaBancaria contaBancaria;

	protected BancoBradescoCNAB240Pagamento(ContaBancaria contaBancaria, List<RemessaPagamento> remessas,
			Date dataHoraGeracao, Date dataGravacao, Integer numeroSequencialArquivo) {
		
		Assert.notNull(remessas, "Informe as remessas para geração do arquivo.");
		if (remessas.size() == 0) {
			throw new CNABException("Informe as remessas para geração do arquivo.");
		}

		this.contaBancaria = contaBancaria;

//		headerArquivo = HeaderArquivo.of(contaBancaria, remessas.get(PRIMEIRA_REMESSA).getTitulo().getCarteira(), remessas.get(PRIMEIRA_REMESSA).getTitulo().getCedente(), dataHoraGeracao, numeroSequencialArquivo);
//		headerLote = HeaderLote.of(contaBancaria, remessas.get(PRIMEIRA_REMESSA).getTitulo().getCarteira(), remessas.get(PRIMEIRA_REMESSA).getTitulo().getCedente(), dataGravacao);
//		pagamentoSegmentoA = PagamentoSegmentoA.of(contaBancaria, remessas);
//		pagamentoSegmentoB = PagamentoSegmentoB.of(contaBancaria, remessas);
//		pagamentoSegmentoJ = PagamentoSegmentoJ.of(contaBancaria, remessas);
//		traillerLote = TraillerLote.of(contaBancaria, remessas);
//		traillerArquivo = TraillerArquivo.of(contaBancaria);
	}
	
	protected BancoBradescoCNAB240Pagamento(ContaBancaria contaBancaria, Date dataHoraGeracao, Date dataGravacao) {
		this.contaBancaria = contaBancaria;
		headerArquivo = HeaderArquivo.of(contaBancaria, dataHoraGeracao);
		headerLote = HeaderLote.of(contaBancaria, dataGravacao);
		traillerLote = TraillerLote.of(contaBancaria);
		traillerArquivo = TraillerArquivo.of(contaBancaria);
	}

	@Override
	public byte[] generate() throws FlatFileManagerException, JAXBException, IllegalArgumentException,
			IllegalAccessException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] generate(String[] groups) throws FlatFileManagerException, JAXBException, IllegalArgumentException,
			IllegalAccessException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] getXMLSchema() throws FlatFileManagerException, JAXBException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static BancoBradescoCNAB240Pagamento of(ContaBancaria contaBancaria, List<RemessaPagamento> remessas,
			Date dataHoraGeracao, Date dataGravacao, Integer numeroSequencialArquivo) {
		return new BancoBradescoCNAB240Pagamento(contaBancaria, remessas, dataHoraGeracao, dataGravacao, numeroSequencialArquivo);
	}

	public static BancoBradescoCNAB240Pagamento of(ContaBancaria contaBancaria, Date dataHoraGeracao, Date dataGravacao) {
		return new BancoBradescoCNAB240Pagamento(contaBancaria, dataHoraGeracao, dataGravacao);
	}

	public static BancoBradescoCNAB240Pagamento of(ContaBancaria contaBancaria, List<RemessaPagamento> remessas, Integer numeroSequencialArquivo) {
		return new BancoBradescoCNAB240Pagamento(contaBancaria, remessas, Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), numeroSequencialArquivo);
	}

	public static BancoBradescoCNAB240Pagamento of(ContaBancaria contaBancaria) {
		return new BancoBradescoCNAB240Pagamento(contaBancaria, Calendar.getInstance().getTime(), Calendar.getInstance().getTime());
	}

	@Override
	public List<RetornoPagamento> read(File file, String[] groups) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RetornoPagamento> read(File file) throws IOException, IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RetornoPagamento> read(InputStream dataInputStream) throws IOException, IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RetornoPagamento> read(byte[] data) throws IllegalArgumentException, IllegalAccessException,
			FlatFileManagerException, JAXBException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RetornoPagamento> read(InputStream dataInputStream, String[] groups) throws IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RetornoPagamento> read(byte[] data, String[] groups) throws IllegalArgumentException,
			IllegalAccessException, FlatFileManagerException, JAXBException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
