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
package br.com.anteros.integracao.bancaria.banco.layout.cnab240.cobranca.santander.v40;

import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CD_BANCO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CD_TRANSMISSAO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.DT_GRAVACAO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.LAYOUT_LOTE;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.LT_SERVICO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.MENSAGEM_1;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.MENSAGEM_2;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NOME_EMPRESA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NR_INSCRICAO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NR_REMESSA_RETORNO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.TP_INSCRICAO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.TP_OPERACAO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.TP_REGISTRO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.TP_SERVICO;

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

	@Field(name = "BRANCOS_1", length = 2, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos1;

	@Field(name = LAYOUT_LOTE, length = 3, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer layoutLote;

	@Field(name = "BRANCOS_2", length = 1, value = " ")
	private String brancos2;

	@Field(name = TP_INSCRICAO, length = 1, type = EnumTypes.INTEGER)
	private Integer tipoInscricao;

	@Field(name = NR_INSCRICAO, length = 15, padding = Paddings.ZERO_LEFT)
	private String numeroInscricao;

	@Field(name = "BRANCOS_3", length = 20, value = " ")
	private String brancos3;

	@Field(name = CD_TRANSMISSAO, length = 15, type = EnumTypes.LONG, padding = Paddings.ZERO_LEFT)
	private Long codigoTransmissao;

	@Field(name = "BRANCOS_4", length = 5, value = " ")
	private String brancos4;

	@Field(name = NOME_EMPRESA, length = 30, padding = Paddings.WHITE_SPACE_RIGHT)
	private String nomeEmpresa;

	@Field(name = MENSAGEM_1, length = 40, padding = Paddings.WHITE_SPACE_RIGHT, value = " ")
	private String mensagem1;

	@Field(name = MENSAGEM_2, length = 40, padding = Paddings.WHITE_SPACE_RIGHT, value = " ")
	private String mensagem2;

	@Field(name = NR_REMESSA_RETORNO, length = 8, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer numeroRemessaRetorno;

	@Field(name = DT_GRAVACAO, length = 8, type = EnumTypes.DATE, format = Formats.DATE_DDMMYYYY)
	private Date dataGravacao;

	@Field(name = "BRANCOS_5", length = 41, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos5;

	public HeaderCobranca(ContaBancaria contaBancaria, Carteira carteira, Cedente cedente,
			Integer versaoLayoutLote, Date dataGravacao) {
		this.codigoBanco = contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo();// G001
		this.loteServico = 1;// G002
		this.tipoInscricao = (cedente.getCPRF().isFisica() ? 1 : 2); // G005
		this.numeroInscricao = cedente.getCPRF().getCodigoComZeros(); // G006
		this.layoutLote = versaoLayoutLote;// G030
		this.nomeEmpresa = cedente.getNome();// G013
		this.numeroRemessaRetorno = 1; // G079
		this.dataGravacao = dataGravacao;// G068
	}

	public HeaderCobranca(ContaBancaria contaBancaria, Date dataGravacao) {
		this.codigoBanco = contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo();// G001
		this.loteServico = 1;// G002
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

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getMensagem1() {
		return mensagem1;
	}

	public void setMensagem1(String mensagem1) {
		this.mensagem1 = mensagem1;
	}

	public String getMensagem2() {
		return mensagem2;
	}

	public void setMensagem2(String mensagem2) {
		this.mensagem2 = mensagem2;
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

	public Long getCodigoTransmissao() {
		return codigoTransmissao;
	}

	public void setCodigoTransmissao(Long codigoTransmissao) {
		this.codigoTransmissao = codigoTransmissao;
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

	public String getBrancos3() {
		return brancos3;
	}

	public void setBrancos3(String brancos3) {
		this.brancos3 = brancos3;
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
		setNomeEmpresa((String) record.getValue(NOME_EMPRESA));
		setMensagem1((String) record.getValue(MENSAGEM_1));
		setMensagem2((String) record.getValue(MENSAGEM_2));
		setNumeroRemessaRetorno((Integer) record.getValue(NR_REMESSA_RETORNO));
		setDataGravacao((Date) record.getValue(DT_GRAVACAO));
	}

	public static HeaderCobranca of(ContaBancaria contaBancaria, Date dataGravacao) {
		return new HeaderCobranca(contaBancaria, dataGravacao);
	}

	public static HeaderCobranca of(ContaBancaria contaBancaria) {
		return new HeaderCobranca(contaBancaria);
	}

}
