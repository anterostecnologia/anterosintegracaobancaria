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

public class PagamentoSegmentoA implements RecordData {

	@IdType(name = CD_SEGMENTO_REGISTRO, length = 1, positionField = 5, value = "A")
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
	
	@Field(name = CD_CAMARA_CENTRALIZADORA, length = 3, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoCamaraCentralizadora;
	
	@Field(name = CD_BANCO_FAVORECIDO, length = 3, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoBancoFavorecido;
	
	@Field(name = AGENCIA_MANTENEDORA, type = EnumTypes.INTEGER, length = 5, padding = Paddings.ZERO_LEFT)
	private Integer agenciaMantenedora;

	@Field(name = DIGITO_VERIFICADOR_AGENCIA, length = 1)
	private String digitoVerificadorAgencia;
	
	@Field(name = NR_CONTACORRENTE, length = 12, type = EnumTypes.LONG, padding = Paddings.ZERO_LEFT)
	private Long numeroContaCorrente;

	@Field(name = DIGITO_VERIFICADOR_CONTACORRENTE, length = 1)
	private String DigitoVerificadorContaCorrente;

	@Field(name = DIGITO_VERFICADOR_AGENCIACONTA, length = 1, padding = Paddings.WHITE_SPACE_RIGHT, value = " ")
	private String digitoVerificadorAgenciaConta;
	
	@Field(name = NOME, length = 30, padding = Paddings.WHITE_SPACE_RIGHT)
	private String nomeFavorecido;
	
	@Field(name = IDENTIFICADOR_TITULO, length = 20, padding = Paddings.WHITE_SPACE_RIGHT)
	private String identificadorTituloEmpresa;
	
	@Field(name = DT_PAGAMENTO, length = 8, type = EnumTypes.DATE, padding = Paddings.ZERO_LEFT, format = Formats.DATE_DDMMYYYY)
	private Date dtPagamentoTitulo;
	
	@Field(name = CD_MOEDA, length = 3, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoMoeda;
	
	@Field(name = QT_MOEDA, length = 15, type = EnumTypes.BIGDECIMAL, padding = Paddings.ZERO_LEFT, format = Formats.DECIMAL_DDDDD)
	private BigDecimal quantidadeMoeda;
	
	@Field(name = VL_PAGAMENTO, length = 15, type = EnumTypes.BIGDECIMAL, padding = Paddings.ZERO_LEFT, format = Formats.DECIMAL_DD)
	private BigDecimal vlPagamento;
	
	@Field(name = IDENTIFICADOR_TITULO_BANCO, length = 20, padding = Paddings.WHITE_SPACE_RIGHT)
	private String identificadorTituloBanco;
	
	@Field(name = DT_EFETIVACAO_PAGAMENTO, length = 8, type = EnumTypes.DATE, padding = Paddings.ZERO_LEFT, format = Formats.DATE_DDMMYYYY)
	private Date dtRealEfetivacaoPagamento;
	
	@Field(name = VL_EFETIVACAO_PAGAMENTO, length = 15, type = EnumTypes.BIGDECIMAL, padding = Paddings.ZERO_LEFT, format = Formats.DECIMAL_DD)
	private BigDecimal vlEfetivacaoPagamento;
	
	@Field(name = BRANCOS_1, value = " ", padding = Paddings.WHITE_SPACE_RIGHT, length = 40)
	private String brancos1;
	
	@Field(name = TP_SERVICO, length = 2, padding = Paddings.WHITE_SPACE_RIGHT)
	private String tipoServico;
	
	@Field(name = FINALIDADE_TED, length = 5, padding = Paddings.WHITE_SPACE_RIGHT)
	private String finalidadeTed;
	
	@Field(name = FINALIDADE_PAGAMENTO, length = 2, padding = Paddings.WHITE_SPACE_RIGHT)
	private String finalidadePagamento;
	
	@Field(name = BRANCOS_2, value = " ", padding = Paddings.WHITE_SPACE_RIGHT, length = 3)
	private String brancos2;
	
	@Field(name = NR_AVISO, length = 1, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer avisoFavorecido;
	
	@Field(name = CD_OCORRENCIA, length = 10, padding = Paddings.WHITE_SPACE_RIGHT)
	private String codOcorrencia;
	
	@Override
	public int getNumberOfRecords() {
		return 0;
	}

	@Override
	public void readRowData(int row, int sequence) {
		// TODO Auto-generated method stub
		
	}

}
