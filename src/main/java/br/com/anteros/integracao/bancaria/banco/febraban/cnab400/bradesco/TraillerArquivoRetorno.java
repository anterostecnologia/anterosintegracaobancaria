package br.com.anteros.integracao.bancaria.banco.febraban.cnab400.bradesco;

import java.math.BigDecimal;

import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.Formats;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.language.EnumTypes;
import br.com.anteros.integracao.bancaria.banco.febraban.ContaBancaria;

public class TraillerArquivoRetorno {

	private static final String NR_SEQUENCIAL_REGISTRO = "NR_SEQUENCIAL_REGISTRO";

	private static final String VL_TOTAL_COBRANCA = "VL_TOTAL_COBRANCA";
	private static final String QT_TITULOS_COBRANCA = "QT_TITULOS_COBRANCA";
	private static final String CD_BANCO = "CD_BANCO";
	private static final String CD_RETORNO = "CD_RETORNO";
	private static final String CD_REGISTRO = "CD_REGISTRO";

	private static final String NR_AVISO_BANCARIO = "NR_AVISO_BANCARIO";

	@IdType(name = CD_REGISTRO, length = 1, positionField = 1, value = "9")
	private String codigoRegistro;

	@Field(name = CD_RETORNO, length = 1)
	private String codigoRetorno;
	
	@Field(name = "BRANCOS1", length = 2, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos1;

	@Field(name = CD_BANCO, length = 3, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoBanco;

	@Field(name = "BRANCOS2", length = 10, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos2;	

	@Field(name = QT_TITULOS_COBRANCA, length = 8, type = EnumTypes.LONG, padding = Paddings.ZERO_LEFT)
	private Long quantidadeTitulosCobranca;

	@Field(name = VL_TOTAL_COBRANCA, length = 14, type = EnumTypes.BIGDECIMAL, format = Formats.DECIMAL_DD)
	private BigDecimal valorTotalCobranca;

	@Field(name = NR_AVISO_BANCARIO, length = 8, type = EnumTypes.LONG, padding = Paddings.ZERO_LEFT)
	private Long numeroAvisoBancario;

	@Field(name = "BRANCOS3", length = 10, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos3;	

	@Field(name = "BRANCOS4", length = 337, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos4;
	
	@Field(name = NR_SEQUENCIAL_REGISTRO, length = 6, padding = Paddings.ZERO_LEFT, type=EnumTypes.INTEGER)
	private Integer numeroSequencialRegistro;

	public TraillerArquivoRetorno(ContaBancaria contaBancaria) {
	}

	public String getCodigoRegistro() {
		return codigoRegistro;
	}

	public void setCodigoRegistro(String codigoRegistro) {
		this.codigoRegistro = codigoRegistro;
	}

	public String getCodigoRetorno() {
		return codigoRetorno;
	}

	public void setCodigoRetorno(String codigoRetorno) {
		this.codigoRetorno = codigoRetorno;
	}

	public String getBrancos1() {
		return brancos1;
	}

	public void setBrancos1(String brancos1) {
		this.brancos1 = brancos1;
	}

	public Integer getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(Integer codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public String getBrancos2() {
		return brancos2;
	}

	public void setBrancos2(String brancos2) {
		this.brancos2 = brancos2;
	}


	public Integer getNumeroSequencialRegistro() {
		return numeroSequencialRegistro;
	}

	public void setNumeroSequencialRegistro(Integer numeroSequencialRegistro) {
		this.numeroSequencialRegistro = numeroSequencialRegistro;
	}

	public static TraillerArquivoRetorno of(ContaBancaria contaBancaria) {
		return new TraillerArquivoRetorno(contaBancaria);
	}

	public void set(br.com.anteros.flatfile.Record record) {
		setCodigoRegistro((String) record.getValue(CD_REGISTRO));
		setCodigoRetorno((String) record.getValue(CD_RETORNO));
		setCodigoBanco((Integer) record.getValue(CD_BANCO));
		setQuantidadeTitulosCobranca((Long) record.getValue(QT_TITULOS_COBRANCA));
		setValorTotalCobranca((BigDecimal) record.getValue(VL_TOTAL_COBRANCA));
		setNumeroAvisoBancario((Long) record.getValue(NR_AVISO_BANCARIO));
		setNumeroSequencialRegistro((Integer) record.getValue(NR_SEQUENCIAL_REGISTRO));
	}

	public Long getQuantidadeTitulosCobranca() {
		return quantidadeTitulosCobranca;
	}

	public void setQuantidadeTitulosCobranca(Long quantidadeTitulosCobranca) {
		this.quantidadeTitulosCobranca = quantidadeTitulosCobranca;
	}

	public BigDecimal getValorTotalCobranca() {
		return valorTotalCobranca;
	}

	public void setValorTotalCobranca(BigDecimal valorTotalCobranca) {
		this.valorTotalCobranca = valorTotalCobranca;
	}

	public Long getNumeroAvisoBancario() {
		return numeroAvisoBancario;
	}

	public void setNumeroAvisoBancario(Long numeroAvisoBancario) {
		this.numeroAvisoBancario = numeroAvisoBancario;
	}
}
