package br.com.anteros.integracao.bancaria.banco.layout.cnab240.pagamento.bradesco;

import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.*;

import br.com.anteros.flatfile.annotation.FlatFile;
import br.com.anteros.flatfile.annotation.InnerRecord;
import br.com.anteros.flatfile.annotation.Record;

@FlatFile(name = "Arquivo CNAB240 - Banco Bradesco", description = "Arquivo de remessa PAGAMENTO CNAB240", version = "1.0")
public class BancoBradescoCNAB240Pagamento {
	
	@Record(name = HEADER, description = "Protocolo de comunicação", order = 1, groups = { REMESSA_PAGAMENTO })
	protected HeaderArquivo headerArquivo;
	
	@Record(name = HEADER_LOTE, description = "Cabeçalho lote de pagamento", order = 2, groups = { REMESSA_PAGAMENTO })
	protected HeaderLote headerLote;
	
	@Record(name = PAGAMENTO_SEGMENTO_A, description = "Segmento A Remessa dos pagamentos", order = 3, repeatable = true, groups = {REMESSA_PAGAMENTO })
	protected PagamentoSegmentoA pagamentoSegmentoA;
	
	@InnerRecord(name = PAGAMENTO_SEGMENTO_B, description = "Segmento B Remessa dos pagamentos", recordOwner = PAGAMENTO_SEGMENTO_A, order = 4, repeatable = true, groups = {REMESSA_PAGAMENTO })
	protected PagamentoSegmentoB pagamentoSegmentoB;
	
	@InnerRecord(name = PAGAMENTO_SEGMENTO_C, description = "Segmento C Remessa dos pagamentos", recordOwner = PAGAMENTO_SEGMENTO_A, order = 5, repeatable = true, groups = {REMESSA_PAGAMENTO })
	protected PagamentoSegmentoC pagamentoSegmentoC;
	
//	@InnerRecord(name = PAGAMENTO_SEGMENTO_J, description = "Segmento J Remessa dos pagamentos", recordOwner = PAGAMENTO_SEGMENTO_A, order = 6, repeatable = true, groups = {REMESSA_PAGAMENTO })
//	protected PagamentoSegmentoJ pagamentoSegmentoJ;
	
	
}
