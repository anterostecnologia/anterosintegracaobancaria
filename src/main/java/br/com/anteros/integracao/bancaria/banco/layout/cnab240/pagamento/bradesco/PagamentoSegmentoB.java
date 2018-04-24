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

public class PagamentoSegmentoB implements RecordData {

	@IdType(name = CD_SEGMENTO_REGISTRO, length = 1, positionField = 5, value = "B")
	private String codigoSegmentoRegistro;

	@Field(name = CD_BANCO, length = 3, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoBanco;

	@Field(name = LT_SERVICO, length = 4, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer loteServico;

	@Field(name = TP_REGISTRO, length = 1, type = EnumTypes.INTEGER, value = "3", padding = Paddings.ZERO_LEFT)
	private Integer tipoRegistro;

	@Field(name = NR_SEQUENCIA_REGISTRO, length = 5, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer numeroSequencialRegistro;

	@Field(name = BRANCOS_1, value = " ", padding = Paddings.WHITE_SPACE_RIGHT, length = 3)
	private String brancos1;
	
	@Field(name = TP_INSCRICAO, length = 1, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer tipoInscricaoFavorecido;
	
	@Field(name = NR_INSCRICAO, length = 14, type = EnumTypes.LONG, padding = Paddings.ZERO_LEFT)
	private Long numeroInscricaoFavorecido;
	
	@Field(name = ENDERECO, length = 30, padding = Paddings.WHITE_SPACE_RIGHT)
	private String endereco;

	@Field(name = NUMERO, length = 5, padding = Paddings.WHITE_SPACE_RIGHT)
	private String numero;

	@Field(name = COMPLEMENTO, length = 15, padding = Paddings.WHITE_SPACE_RIGHT)
	private String complemento;
	
	@Field(name = BAIRRO, length = 15, padding = Paddings.WHITE_SPACE_RIGHT)
	private String bairro;

	@Field(name = CIDADE, length = 20, padding = Paddings.WHITE_SPACE_RIGHT)
	private String cidade;

	@Field(name = CEP, length = 5, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer cep;

	@Field(name = SUFIXO_CEP, length = 3, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer sufixoCep;

	@Field(name = UF, length = 2, padding = Paddings.WHITE_SPACE_RIGHT)
	private String estado;
	
	@Field(name = DT_VENCIMENTO, length = 8, type = EnumTypes.DATE, padding = Paddings.ZERO_LEFT, format = Formats.DATE_DDMMYYYY)
	private Date dtVencimento;
	
	@Field(name = VL_DOCUMENTO, length = 15, type = EnumTypes.BIGDECIMAL, padding = Paddings.ZERO_LEFT, format = Formats.DECIMAL_DD)
	private BigDecimal vlDocumento;
	
	@Field(name = VL_ABATIMENTO, length = 15, type = EnumTypes.BIGDECIMAL, padding = Paddings.ZERO_LEFT, format = Formats.DECIMAL_DD)
	private BigDecimal vlAbatimento;
	
	@Field(name = VL_DESCONTO, length = 15, type = EnumTypes.BIGDECIMAL, padding = Paddings.ZERO_LEFT, format = Formats.DECIMAL_DD)
	private BigDecimal vlDesconto;
	
	@Field(name = VL_JUROS_MORA, length = 15, type = EnumTypes.BIGDECIMAL, padding = Paddings.ZERO_LEFT, format = Formats.DECIMAL_DD)
	private BigDecimal vlJurosMora;
	
	@Field(name = VL_MULTA, length = 15, type = EnumTypes.BIGDECIMAL, padding = Paddings.ZERO_LEFT, format = Formats.DECIMAL_DD)
	private BigDecimal vlMulta;
	
	@Field(name = NR_DOCUMENTO, length = 15, padding = Paddings.WHITE_SPACE_RIGHT)
	private String codigoDocumentoFavorecido;
	
	@Field(name = NR_AVISO, length = 1, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer avisoFavorecido;

	@Field(name = BRANCOS_2, value = " ", padding = Paddings.WHITE_SPACE_RIGHT, length = 6)
	private String brancos2;
	
	@Field(name = CD_ISPB_BANCO, length = 8, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoIspbBanco;

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
