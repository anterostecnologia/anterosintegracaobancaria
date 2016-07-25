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
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CD_REMESSA_RETORNO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CD_TRANSMISSAO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.DT_GERACAO_ARQUIVO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.LT_SERVICO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NOME_BANCO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NOME_EMPRESA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NR_INSCRICAO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NR_SEQUENCIAL_ARQUIVO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NR_VERSAO_ARQUIVO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.TIPO_REGISTRO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.TP_INSCRICAO;

import java.util.Date;

import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.Formats;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.language.EnumTypes;
import br.com.anteros.integracao.bancaria.banco.layout.Carteira;
import br.com.anteros.integracao.bancaria.banco.layout.Cedente;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;

public class HeaderArquivo {

	@IdType(name = TIPO_REGISTRO, length = 1, positionField = 3, value = "0")
	private String tipoRegistro;

	@Field(name = CD_BANCO, length = 3, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoBanco;

	@Field(name = LT_SERVICO, length = 4, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT, value = "0000")
	private Integer loteServico;

	@Field(name = "BRANCOS_1", length = 8, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos1;

	@Field(name = TP_INSCRICAO, length = 1, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer tipoInscricao;

	@Field(name = NR_INSCRICAO, length = 15, type = EnumTypes.LONG, padding = Paddings.ZERO_LEFT)
	private Long numeroInscricao;

	@Field(name = CD_TRANSMISSAO, length = 15, type = EnumTypes.LONG, padding = Paddings.ZERO_LEFT)
	private Long codigoTransmissao;

	@Field(name = "BRANCOS_2", length = 25, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos2;

	@Field(name = NOME_EMPRESA, length = 30, padding = Paddings.WHITE_SPACE_RIGHT)
	private String nomeEmpresa;

	@Field(name = NOME_BANCO, length = 30, padding = Paddings.WHITE_SPACE_RIGHT)
	private String nomeBanco;

	@Field(name = "BRANCOS_3", length = 10, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos3;

	@Field(name = CD_REMESSA_RETORNO, length = 1, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoRemessaRetorno;

	@Field(name = DT_GERACAO_ARQUIVO, length = 8, type = EnumTypes.DATE, format = Formats.DATE_DDMMYYYY, padding = Paddings.ZERO_LEFT)
	private Date dataGeracaoArquivo;

	@Field(name = "BRANCOS_4", length = 6, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos4;

	@Field(name = NR_SEQUENCIAL_ARQUIVO, length = 6, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer numeroSequencialArquivo;

	@Field(name = NR_VERSAO_ARQUIVO, length = 3, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT, value = "040")
	private Integer numeroVersaoArquivo;

	@Field(name = "BRANCOS_5", length = 74, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos5;

	protected HeaderArquivo(ContaBancaria contaBancaria, Carteira carteira, Cedente cedente,
			Integer versaoLayoutArquivo, Date dataHoraGeracao) {
		this.codigoBanco = contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo();// G001
		this.tipoInscricao = (cedente.getCPRF().isFisica() ? 1 : 2); // G005
		this.numeroInscricao = cedente.getCPRF().getCodigo(); // G006
		this.numeroVersaoArquivo = versaoLayoutArquivo;// G030
		this.nomeEmpresa = cedente.getNome();// G013
		this.nomeBanco = contaBancaria.getBanco().getNome();// G014
		this.codigoRemessaRetorno = 1;// G015
		this.dataGeracaoArquivo = dataHoraGeracao;// G016
		this.numeroSequencialArquivo = 1;// G018
	}

	public HeaderArquivo(ContaBancaria contaBancaria, Date dataHoraGeracao) {
		this.codigoBanco = contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo();// G001
		this.nomeBanco = contaBancaria.getBanco().getNome();// G014
		this.codigoRemessaRetorno = 1;// G015
		this.dataGeracaoArquivo = dataHoraGeracao;// G016
		this.numeroSequencialArquivo = 1;// G018
	}

	public static HeaderArquivo of(ContaBancaria contaBancaria, Carteira carteira, Cedente cedente,
			Integer versaoLayoutArquivo, Date dataHoraGeracao) {
		return new HeaderArquivo(contaBancaria, carteira, cedente, versaoLayoutArquivo, dataHoraGeracao);
	}

	public static HeaderArquivo of(ContaBancaria contaBancaria, Date dataHoraGeracao) {
		return new HeaderArquivo(contaBancaria, dataHoraGeracao);
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

	public String getBrancos1() {
		return brancos1;
	}

	public void setBrancos1(String brancos1) {
		this.brancos1 = brancos1;
	}

	public Integer getTipoInscricao() {
		return tipoInscricao;
	}

	public void setTipoInscricao(Integer tipoInscricao) {
		this.tipoInscricao = tipoInscricao;
	}

	public Long getNumeroInscricao() {
		return numeroInscricao;
	}

	public void setNumeroInscricao(Long numeroInscricao) {
		this.numeroInscricao = numeroInscricao;
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

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

	public String getBrancos2() {
		return brancos2;
	}

	public void setBrancos2(String brancos2) {
		this.brancos2 = brancos2;
	}

	public Integer getCodigoRemessaRetorno() {
		return codigoRemessaRetorno;
	}

	public void setCodigoRemessaRetorno(Integer codigoRemessaRetorno) {
		this.codigoRemessaRetorno = codigoRemessaRetorno;
	}

	public Date getDataGeracaoArquivo() {
		return dataGeracaoArquivo;
	}

	public void setDataGeracaoArquivo(Date dataGeracaoArquivo) {
		this.dataGeracaoArquivo = dataGeracaoArquivo;
	}

	public Integer getNumeroSequencialArquivo() {
		return numeroSequencialArquivo;
	}

	public void setNumeroSequencialArquivo(Integer numeroSequencialArquivo) {
		this.numeroSequencialArquivo = numeroSequencialArquivo;
	}

	public Integer getNumeroVersaoArquivo() {
		return numeroVersaoArquivo;
	}

	public void setNumeroVersaoArquivo(Integer numeroVersaoArquivo) {
		this.numeroVersaoArquivo = numeroVersaoArquivo;
	}

	public String getBrancos3() {
		return brancos3;
	}

	public void setBrancos3(String brancos3) {
		this.brancos3 = brancos3;
	}

	public void set(br.com.anteros.flatfile.Record record) {
		setTipoRegistro((String) record.getValue(TIPO_REGISTRO));
		setCodigoBanco((Integer) record.getValue(CD_BANCO));
		setLoteServico((Integer) record.getValue(LT_SERVICO));
		setTipoInscricao((Integer) record.getValue(TP_INSCRICAO));
		setNumeroInscricao((Long) record.getValue(NR_INSCRICAO));
		setNomeEmpresa((String) record.getValue(NOME_EMPRESA));
		setNomeBanco((String) record.getValue(NOME_BANCO));
		setCodigoRemessaRetorno((Integer) record.getValue(CD_REMESSA_RETORNO));
		setDataGeracaoArquivo((Date) record.getValue(DT_GERACAO_ARQUIVO));
		setNumeroSequencialArquivo((Integer) record.getValue(NR_SEQUENCIAL_ARQUIVO));
		setNumeroVersaoArquivo((Integer) record.getValue(NR_VERSAO_ARQUIVO));
	}

}
