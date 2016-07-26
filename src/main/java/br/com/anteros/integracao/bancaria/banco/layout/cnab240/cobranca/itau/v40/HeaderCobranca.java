/*******************************************************************************
 * Copyright 2016 Anteros Tecnologia
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package br.com.anteros.integracao.bancaria.banco.layout.cnab240.cobranca.itau.v40;

import java.util.Calendar;
import java.util.Date;

import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.Formats;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.language.EnumTypes;
import br.com.anteros.integracao.bancaria.banco.layout.Carteira;
import br.com.anteros.integracao.bancaria.banco.layout.Cedente;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.*;

public class HeaderCobranca {

	@IdType(name = TP_REGISTRO, length = 1, positionField = 3, value = "1")
	private String tipoRegistro;

	@Field(name = CD_BANCO, length = 3, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoBanco;

	@Field(name = LT_SERVICO, length = 4, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer loteServico;
	
	@Field(name = TP_OPERACAO, length = 1, value = "R")
	private String tipoOperacao;

	@Field(name = TP_SERVICO, length = 2, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer tipoServico;

	@Field(name = "ZEROS_1", length = 2, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT, value = "00")
	private Integer zeros1;

	@Field(name = LAYOUT_LOTE, length = 3, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT, value = "030")
	private Integer layoutLote;

	@Field(name = "BRANCOS_1", length = 1, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos1;

	@Field(name = TP_INSCRICAO, length = 1, type = EnumTypes.INTEGER)
	private Integer tipoInscricao;

	@Field(name = NR_INSCRICAO, length = 15, padding = Paddings.ZERO_LEFT)
	private String numeroInscricao;

	@Field(name = "BRANCOS_2", length = 20, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos2;

	@Field(name = "ZEROS_2", length = 1, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT, value = "0")
	private Integer zeros2;

	@Field(name = AGENCIA_MANTENEDORA, length = 4, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer agenciaMantenedora;

	@Field(name = "BRANCOS3", length = 1, padding = Paddings.WHITE_SPACE_RIGHT, value = " ")
	private String brancos3;

	@Field(name = "ZEROS3", length = 7, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT, value = "0000000")
	private Integer zeros3;

	@Field(name = NR_CONTACORRENTE, length = 5, type = EnumTypes.LONG, padding = Paddings.ZERO_LEFT)
	private Long numeroContaCorrente;

	@Field(name = "BRANCOS_4", length = 1, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos4;

	@Field(name = DIGITO_AGENCIACONTA, length = 1)
	private String digitoVerificadorAgenciaConta;

	@Field(name = NOME_EMPRESA, length = 30, padding = Paddings.WHITE_SPACE_RIGHT)
	private String nomeEmpresa;

	@Field(name = "BRANCOS_5", length = 80, padding = Paddings.WHITE_SPACE_RIGHT, value = " ")
	private String brancos5;

	@Field(name = NR_REMESSA_RETORNO, length = 8, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer numeroRemessaRetorno;

	@Field(name = DT_GRAVACAO, length = 8, type = EnumTypes.DATE, format = Formats.DATE_DDMMYYYY)
	private Date dataGravacao;

	@Field(name = DT_CREDITO, length = 8, type = EnumTypes.DATE, format = Formats.DATE_DDMMYYYY)
	private Date dataCredito;

	@Field(name = "BRANCOS_6", length = 33, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos6;

	public HeaderCobranca(ContaBancaria contaBancaria, Carteira carteira, Cedente cedente,
			Integer versaoLayoutLote, Date dataGravacao) {
		this.codigoBanco = contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo();// G001
		this.loteServico = 1;// G002
		this.tipoInscricao = (cedente.getCPRF().isFisica() ? 1 : 2); // G005
		this.numeroInscricao = cedente.getCPRF().getCodigoComZeros(); // G006
		this.agenciaMantenedora = contaBancaria.getAgencia().getCodigo();// G008
		this.layoutLote = versaoLayoutLote;// G030
		this.numeroContaCorrente = contaBancaria.getNumeroDaConta().getCodigoDaConta();// G010
		this.digitoVerificadorAgenciaConta = contaBancaria.getAgencia().getDigitoVerificador();// G012
		this.nomeEmpresa = cedente.getNome();// G013
		this.numeroRemessaRetorno = 1; // G079
		this.dataGravacao = dataGravacao;// G068
	}

	public HeaderCobranca(ContaBancaria contaBancaria, Date dataGravacao) {
		this.codigoBanco = contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo();// G001
		this.loteServico = 1;// G002
		this.agenciaMantenedora = contaBancaria.getAgencia().getCodigo();// G008
		this.numeroContaCorrente = contaBancaria.getNumeroDaConta().getCodigoDaConta();// G010
		this.digitoVerificadorAgenciaConta = contaBancaria.getAgencia().getDigitoVerificador();// G012
		this.numeroRemessaRetorno = 1; // G079
		this.dataGravacao = dataGravacao;// G068
	}

	public HeaderCobranca(ContaBancaria contaBancaria, Carteira carteira, Cedente cedente,
			Integer versaoLayoutLote) {
		this(contaBancaria, carteira, cedente, versaoLayoutLote, Calendar.getInstance().getTime());
	}

	public HeaderCobranca(ContaBancaria contaBancaria) {
		this(contaBancaria, Calendar.getInstance().getTime());
	}

	public static HeaderCobranca of(ContaBancaria contaBancaria, Carteira carteira, Cedente cedente,
			Integer versaoLayoutLote, Date dataGravacao) {
		return new HeaderCobranca(contaBancaria, carteira, cedente, versaoLayoutLote, dataGravacao);
	}

	public static HeaderCobranca of(ContaBancaria contaBancaria, Carteira carteira, Cedente cedente,
			Integer versaoLayoutLote) {
		return new HeaderCobranca(contaBancaria, carteira, cedente, versaoLayoutLote);
	}

	public String getTipoRegistro() {
		return tipoRegistro;
	}

	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public Integer getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(Integer codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public Integer getLoteServico() {
		return loteServico;
	}

	public void setLoteServico(Integer loteServico) {
		this.loteServico = loteServico;
	}

	public String getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(String tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	public Integer getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(Integer tipoServico) {
		this.tipoServico = tipoServico;
	}

	public String getBrancos1() {
		return brancos1;
	}

	public void setBrancos1(String brancos1) {
		this.brancos1 = brancos1;
	}

	public Integer getLayoutLote() {
		return layoutLote;
	}

	public void setLayoutLote(Integer layoutLote) {
		this.layoutLote = layoutLote;
	}

	public String getBrancos2() {
		return brancos2;
	}

	public void setBrancos2(String brancos2) {
		this.brancos2 = brancos2;
	}

	public Integer getTipoInscricao() {
		return tipoInscricao;
	}

	public void setTipoInscricao(Integer tipoInscricao) {
		this.tipoInscricao = tipoInscricao;
	}

	public String getNumeroInscricao() {
		return numeroInscricao;
	}

	public void setNumeroInscricao(String numeroInscricao) {
		this.numeroInscricao = numeroInscricao;
	}

	public Integer getAgenciaMantenedora() {
		return agenciaMantenedora;
	}

	public void setAgenciaMantenedora(Integer agenciaMantenedora) {
		this.agenciaMantenedora = agenciaMantenedora;
	}

	public Long getNumeroContaCorrente() {
		return numeroContaCorrente;
	}

	public void setNumeroContaCorrente(Long numeroContaCorrente) {
		this.numeroContaCorrente = numeroContaCorrente;
	}

	public String getDigitoVerificadorAgenciaConta() {
		return digitoVerificadorAgenciaConta;
	}

	public void setDigitoVerificadorAgenciaConta(String digitoVerificadorAgenciaConta) {
		this.digitoVerificadorAgenciaConta = digitoVerificadorAgenciaConta;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public Integer getNumeroRemessaRetorno() {
		return numeroRemessaRetorno;
	}

	public void setNumeroRemessaRetorno(Integer numeroRemessaRetorno) {
		this.numeroRemessaRetorno = numeroRemessaRetorno;
	}

	public Date getDataGravacao() {
		return dataGravacao;
	}

	public void setDataGravacao(Date dataGravacao) {
		this.dataGravacao = dataGravacao;
	}

	public Date getDataCredito() {
		return dataCredito;
	}

	public void setDataCredito(Date dataCredito) {
		this.dataCredito = dataCredito;
	}

	public String getBrancos3() {
		return brancos3;
	}

	public void setBrancos3(String brancos3) {
		this.brancos3 = brancos3;
	}

	public Integer getZeros1() {
		return zeros1;
	}

	public void setZeros1(Integer zeros1) {
		this.zeros1 = zeros1;
	}

	public Integer getZeros2() {
		return zeros2;
	}

	public void setZeros2(Integer zeros2) {
		this.zeros2 = zeros2;
	}

	public Integer getZeros3() {
		return zeros3;
	}

	public void setZeros3(Integer zeros3) {
		this.zeros3 = zeros3;
	}

	public String getBrancos4() {
		return brancos4;
	}

	public void setBrancos4(String brancos4) {
		this.brancos4 = brancos4;
	}

	public String getBrancos5() {
		return brancos5;
	}

	public void setBrancos5(String brancos5) {
		this.brancos5 = brancos5;
	}

	public String getBrancos6() {
		return brancos6;
	}

	public void setBrancos6(String brancos6) {
		this.brancos6 = brancos6;
	}

	public void set(br.com.anteros.flatfile.Record record) {
		setTipoRegistro((String) record.getValue(TP_REGISTRO));
		setCodigoBanco((Integer) record.getValue(CD_BANCO));
		setLoteServico((Integer) record.getValue(LT_SERVICO));
		setTipoOperacao((String) record.getValue(TP_OPERACAO));
		setTipoServico((Integer) record.getValue(TP_SERVICO));
		setLayoutLote((Integer) record.getValue(LAYOUT_LOTE));
		setTipoInscricao((Integer) record.getValue(TP_INSCRICAO));
		setNumeroInscricao((String) record.getValue(NR_INSCRICAO));
		setAgenciaMantenedora((Integer) record.getValue(AGENCIA_MANTENEDORA));
		setNumeroContaCorrente((Long) record.getValue(NR_CONTACORRENTE));
		setDigitoVerificadorAgenciaConta((String) record.getValue(DIGITO_AGENCIACONTA));
		setNomeEmpresa((String) record.getValue(NOME_EMPRESA));
		setNumeroRemessaRetorno((Integer) record.getValue(NR_REMESSA_RETORNO));
		setDataGravacao((Date) record.getValue(DT_GRAVACAO));
		setDataCredito((Date) record.getValue(DT_CREDITO));
	}

	public static HeaderCobranca of(ContaBancaria contaBancaria, Date dataGravacao) {
		return new HeaderCobranca(contaBancaria, dataGravacao);
	}

	public static HeaderCobranca of(ContaBancaria contaBancaria) {
		return new HeaderCobranca(contaBancaria);
	}

}
