package br.com.anteros.integracao.bancaria.banco.layout.cnab240.pagamento.bradesco;

import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.*;

import java.math.BigDecimal;
import java.util.Date;

import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.Formats;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.annotation.RecordData;
import br.com.anteros.flatfile.language.EnumTypes;

public class PagamentoSegmentoO implements RecordData {
	
	@IdType(name = CD_SEGMENTO_REGISTRO, length = 1, positionField = 5, value = "O")
	private String codigoSegmentoRegistro;

	@Field(name = CD_BANCO, length = 3, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoBanco;

	@Field(name = LT_SERVICO, length = 4, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer loteServico;

	@Field(name = TP_REGISTRO, length = 1, type = EnumTypes.INTEGER, value = "3", padding = Paddings.ZERO_LEFT)
	private Integer tipoRegistro;

	@Field(name = NR_SEQUENCIA_REGISTRO, length = 5, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer numeroSequencialRegistro;
	
	@Field(name = TP_MOVIMENTO, length = 1, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer tipoMovimento;
	
	@Field(name = CD_MOVIMENTO, length = 2, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoMovimento;
	
	@Field(name = CD_BARRA, length = 44)
	private String codigoBarras;
	
	@Field(name = NOME, length = 30, padding = Paddings.WHITE_SPACE_RIGHT)
	private String nomeConcessionaria;
	
	@Field(name = DT_VENCIMENTO, length = 8, type = EnumTypes.DATE, padding = Paddings.ZERO_LEFT, format = Formats.DATE_DDMMYYYY)
	private Date dtVencimento;
	
	@Field(name = DT_PAGAMENTO, length = 8, type = EnumTypes.DATE, padding = Paddings.ZERO_LEFT, format = Formats.DATE_DDMMYYYY)
	private Date dtPagamento;
	
	@Field(name = VL_PAGAMENTO, length = 15, type = EnumTypes.BIGDECIMAL, padding = Paddings.ZERO_LEFT, format = Formats.DECIMAL_DD)
	private BigDecimal vlPagamento;
	
	@Field(name = IDENTIFICADOR_TITULO, length = 20, padding = Paddings.WHITE_SPACE_RIGHT)
	private String identificadorTituloEmpresa;

	@Field(name = IDENTIFICADOR_TITULO_BANCO, length = 20, padding = Paddings.WHITE_SPACE_RIGHT)
	private String identificadorTituloBanco;
	
	@Field(name = BRANCOS_1, value = " ", padding = Paddings.WHITE_SPACE_RIGHT, length = 68)
	private String brancos1;
	
	@Field(name = CD_OCORRENCIA, length = 10, padding = Paddings.WHITE_SPACE_RIGHT)
	private String codOcorrenciaRetorno;

	@Override
	public int getNumberOfRecords() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void readRowData(int row, int sequence) {
		// TODO Auto-generated method stub
		
	}

}
