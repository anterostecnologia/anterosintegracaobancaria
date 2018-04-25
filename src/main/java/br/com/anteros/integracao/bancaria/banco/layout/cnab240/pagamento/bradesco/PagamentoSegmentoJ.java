package br.com.anteros.integracao.bancaria.banco.layout.cnab240.pagamento.bradesco;

import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.BRANCOS_1;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CD_BANCO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CD_BARRA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CD_MOEDA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CD_MOVIMENTO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CD_OCORRENCIA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CD_SEGMENTO_REGISTRO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.DT_PAGAMENTO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.DT_VENCIMENTO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.IDENTIFICADOR_TITULO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.IDENTIFICADOR_TITULO_BANCO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.LT_SERVICO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NOME;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NR_SEQUENCIA_REGISTRO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.QT_MOEDA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.TP_MOVIMENTO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.TP_REGISTRO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.VL_DESCONTO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.VL_MULTA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.VL_PAGAMENTO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.VL_TITULO;

import java.math.BigDecimal;
import java.util.Date;

import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.Formats;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.annotation.RecordData;
import br.com.anteros.flatfile.language.EnumTypes;

public class PagamentoSegmentoJ implements RecordData {

	@IdType(name = CD_SEGMENTO_REGISTRO, length = 1, positionField = 5, value = "J")
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

	@Field(name = CD_BARRA, length = 44, type = EnumTypes.LONG, padding = Paddings.ZERO_LEFT)
	private Long codigoBarras;

	@Field(name = NOME, length = 30, padding = Paddings.WHITE_SPACE_RIGHT)
	private String nomeCedente;

	@Field(name = DT_VENCIMENTO, length = 8, type = EnumTypes.DATE, padding = Paddings.ZERO_LEFT, format = Formats.DATE_DDMMYYYY)
	private Date dtVencimento;

	@Field(name = VL_TITULO, length = 15, type = EnumTypes.BIGDECIMAL, padding = Paddings.ZERO_LEFT, format = Formats.DECIMAL_DD)
	private BigDecimal vlTitulo;

	@Field(name = VL_DESCONTO, length = 15, type = EnumTypes.BIGDECIMAL, padding = Paddings.ZERO_LEFT, format = Formats.DECIMAL_DD)
	private BigDecimal vlDescontoEAbatimento;

	@Field(name = VL_MULTA, length = 15, type = EnumTypes.BIGDECIMAL, padding = Paddings.ZERO_LEFT, format = Formats.DECIMAL_DD)
	private BigDecimal vlMoraEMulta;

	@Field(name = DT_PAGAMENTO, length = 8, type = EnumTypes.DATE, padding = Paddings.ZERO_LEFT, format = Formats.DATE_DDMMYYYY)
	private Date dtPagamento;

	@Field(name = VL_PAGAMENTO, length = 15, type = EnumTypes.BIGDECIMAL, padding = Paddings.ZERO_LEFT, format = Formats.DECIMAL_DD)
	private BigDecimal vlPagamento;

	@Field(name = QT_MOEDA, length = 15, type = EnumTypes.BIGDECIMAL, padding = Paddings.ZERO_LEFT, format = Formats.DECIMAL_DDDDD)
	private BigDecimal quantidadeMoeda;

	@Field(name = IDENTIFICADOR_TITULO, length = 20, padding = Paddings.WHITE_SPACE_RIGHT)
	private String identificadorTituloEmpresa;

	@Field(name = IDENTIFICADOR_TITULO_BANCO, length = 20, padding = Paddings.WHITE_SPACE_RIGHT)
	private String identificadorTituloBanco;

	@Field(name = CD_MOEDA, length = 2, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoMoeda;

	@Field(name = BRANCOS_1, value = " ", padding = Paddings.WHITE_SPACE_RIGHT, length = 6)
	private String brancos1;

	@Field(name = CD_OCORRENCIA, length = 10, padding = Paddings.WHITE_SPACE_RIGHT)
	private String codOcorrenciaRetorno;

	@Override
	public int getNumberOfRecords() {
		return 0;
	}

	@Override
	public void readRowData(int row, int sequence) {
		// TODO Auto-generated method stub

	}

}
