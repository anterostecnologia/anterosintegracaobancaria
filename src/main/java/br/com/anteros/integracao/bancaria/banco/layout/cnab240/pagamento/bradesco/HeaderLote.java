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
package br.com.anteros.integracao.bancaria.banco.layout.cnab240.pagamento.bradesco;

import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.AGENCIA_MANTENEDORA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.BRANCOS_1;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.BRANCOS_2;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CD_BANCO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CD_CONVENIO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CD_OCORRENCIA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CEP;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.CIDADE;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.COMPLEMENTO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.DIGITO_AGENCIA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.DIGITO_AGENCIACONTA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.DIGITO_CONTACORRENTE;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.DT_CREDITO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.DT_GRAVACAO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.ENDERECO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.FORMA_LANCAMENTO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.FORMA_PAGAMENTO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.LAYOUT_LOTE;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.LT_SERVICO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.MENSAGEM_1;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.MENSAGEM_2;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NOME_EMPRESA;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NR_CONTACORRENTE;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NR_INSCRICAO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NR_REMESSA_RETORNO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.NUMERO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.SUFIXO_CEP;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.TP_INSCRICAO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.TP_OPERACAO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.TP_REGISTRO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.TP_SERVICO;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.UF;

import java.util.Calendar;
import java.util.Date;

import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.language.EnumTypes;
import br.com.anteros.integracao.bancaria.banco.layout.Carteira;
import br.com.anteros.integracao.bancaria.banco.layout.Cedente;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;

public class HeaderLote {

	@IdType(name = TP_REGISTRO, length = 1, positionField = 3, value = "1")
	private String tipoRegistro;

	@Field(name = CD_BANCO, length = 3, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoBanco;

	@Field(name = LT_SERVICO, length = 4, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer loteServico;

	@Field(name = TP_OPERACAO, length = 1, value = "C")
	private String tipoOperacao;

	@Field(name = TP_SERVICO, length = 2, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer tipoServico;

	@Field(name = FORMA_LANCAMENTO, length = 2, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer formaLancamento;

	@Field(name = LAYOUT_LOTE, length = 3, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT, value = "045")
	private Integer layoutLote;

	@Field(name = BRANCOS_1, length = 1, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos1;

	@Field(name = TP_INSCRICAO, length = 1, type = EnumTypes.INTEGER)
	private Integer tipoInscricao;

	@Field(name = NR_INSCRICAO, length = 14, padding = Paddings.ZERO_LEFT)
	private String numeroInscricao;

	@Field(name = CD_CONVENIO, length = 20, padding = Paddings.WHITE_SPACE_RIGHT)
	private String codigoConvenio;

	@Field(name = AGENCIA_MANTENEDORA, length = 5, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer agenciaMantenedora;

	@Field(name = DIGITO_AGENCIA, length = 1)
	private String digitoVerificadorAgencia;

	@Field(name = NR_CONTACORRENTE, length = 12, type = EnumTypes.LONG, padding = Paddings.ZERO_LEFT)
	private Long numeroContaCorrente;

	@Field(name = DIGITO_CONTACORRENTE, length = 1)
	private String digitoVerificadorContaCorrente;

	@Field(name = DIGITO_AGENCIACONTA, length = 1)
	private String digitoVerificadorAgenciaConta;

	@Field(name = NOME_EMPRESA, length = 30, padding = Paddings.WHITE_SPACE_RIGHT)
	private String nomeEmpresa;

	@Field(name = MENSAGEM_1, length = 40, padding = Paddings.WHITE_SPACE_RIGHT, value = " ")
	private String mensagem1;

	@Field(name = ENDERECO, length = 30, padding = Paddings.WHITE_SPACE_RIGHT)
	private String endereco;

	@Field(name = NUMERO, length = 5, padding = Paddings.WHITE_SPACE_RIGHT)
	private String numero;

	@Field(name = COMPLEMENTO, length = 15, padding = Paddings.WHITE_SPACE_RIGHT)
	private String complemento;

	@Field(name = CIDADE, length = 20, padding = Paddings.WHITE_SPACE_RIGHT)
	private String cidade;

	@Field(name = CEP, length = 5, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer cep;

	@Field(name = SUFIXO_CEP, length = 3, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer sufixoCep;

	@Field(name = UF, length = 2, padding = Paddings.WHITE_SPACE_RIGHT)
	private String estado;

	@Field(name = FORMA_PAGAMENTO, length = 2, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT, value = "01")
	private Integer IndicativoFormaPagamento;

	@Field(name = BRANCOS_2, length = 6, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos2;

	@Field(name = CD_OCORRENCIA, length = 10, padding = Paddings.WHITE_SPACE_RIGHT)
	private String codOcorrencia;

	public HeaderLote(ContaBancaria contaBancaria, Carteira carteira, Cedente cedente, Integer versaoLayoutLote,
			Date dataGravacao) {
		this.codigoBanco = contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo();// G001
		this.loteServico = 1;// G002
		this.tipoInscricao = (cedente.getCPRF().isFisica() ? 1 : 2); // G005
		this.numeroInscricao = cedente.getCPRF().getCodigoComZeros(); // G006
		this.codigoConvenio = carteira.getCodigoConvenio();// G007
		this.agenciaMantenedora = contaBancaria.getAgencia().getCodigo();// G008
		this.layoutLote = versaoLayoutLote;// G030
		this.digitoVerificadorAgencia = contaBancaria.getAgencia().getDigitoVerificador();// G009
		this.numeroContaCorrente = contaBancaria.getNumeroDaConta().getCodigoDaConta();// G010
		this.digitoVerificadorContaCorrente = contaBancaria.getNumeroDaConta().getDigitoDaConta();// G011
		this.digitoVerificadorAgenciaConta = contaBancaria.getAgencia().getDigitoVerificador();// G012
		this.nomeEmpresa = cedente.getNome();// G013
	}

	public HeaderLote(ContaBancaria contaBancaria, Date dataGravacao) {
		this.codigoBanco = contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo();// G001
		this.loteServico = 1;// G002
		this.agenciaMantenedora = contaBancaria.getAgencia().getCodigo();// G008
		this.digitoVerificadorAgencia = contaBancaria.getAgencia().getDigitoVerificador();// G009
		this.numeroContaCorrente = contaBancaria.getNumeroDaConta().getCodigoDaConta();// G010
		this.digitoVerificadorContaCorrente = contaBancaria.getNumeroDaConta().getDigitoDaConta();// G011
		this.digitoVerificadorAgenciaConta = contaBancaria.getAgencia().getDigitoVerificador();// G012
	}

	public HeaderLote(ContaBancaria contaBancaria, Carteira carteira, Cedente cedente, Integer versaoLayoutLote) {
		this(contaBancaria, carteira, cedente, versaoLayoutLote, Calendar.getInstance().getTime());
	}

	public HeaderLote(ContaBancaria contaBancaria) {
		this(contaBancaria, Calendar.getInstance().getTime());
	}

	public static HeaderLote of(ContaBancaria contaBancaria, Carteira carteira, Cedente cedente,
			Integer versaoLayoutLote, Date dataGravacao) {
		return new HeaderLote(contaBancaria, carteira, cedente, versaoLayoutLote, dataGravacao);
	}

	public static HeaderLote of(ContaBancaria contaBancaria, Carteira carteira, Cedente cedente,
			Integer versaoLayoutLote) {
		return new HeaderLote(contaBancaria, carteira, cedente, versaoLayoutLote);
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

	public String getCodigoConvenio() {
		return codigoConvenio;
	}

	public void setCodigoConvenio(String codigoConvenio) {
		this.codigoConvenio = codigoConvenio;
	}

	public Integer getAgenciaMantenedora() {
		return agenciaMantenedora;
	}

	public void setAgenciaMantenedora(Integer agenciaMantenedora) {
		this.agenciaMantenedora = agenciaMantenedora;
	}

	public String getDigitoVerificadorAgencia() {
		return digitoVerificadorAgencia;
	}

	public void setDigitoVerificadorAgencia(String digitoVerificadorAgencia) {
		this.digitoVerificadorAgencia = digitoVerificadorAgencia;
	}

	public Long getNumeroContaCorrente() {
		return numeroContaCorrente;
	}

	public void setNumeroContaCorrente(Long numeroContaCorrente) {
		this.numeroContaCorrente = numeroContaCorrente;
	}

	public String getDigitoVerificadorContaCorrente() {
		return digitoVerificadorContaCorrente;
	}

	public void setDigitoVerificadorContaCorrente(String digitoVerificadorContaCorrente) {
		this.digitoVerificadorContaCorrente = digitoVerificadorContaCorrente;
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

	public String getMensagem1() {
		return mensagem1;
	}

	public void setMensagem1(String mensagem1) {
		this.mensagem1 = mensagem1;
	}

	public Integer getFormaLancamento() {
		return formaLancamento;
	}

	public void setFormaLancamento(Integer formaLancamento) {
		this.formaLancamento = formaLancamento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public Integer getSufixoCep() {
		return sufixoCep;
	}

	public void setSufixoCep(Integer sufixoCep) {
		this.sufixoCep = sufixoCep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getIndicativoFormaPagamento() {
		return IndicativoFormaPagamento;
	}

	public void setIndicativoFormaPagamento(Integer indicativoFormaPagamento) {
		IndicativoFormaPagamento = indicativoFormaPagamento;
	}

	public String getCodOcorrencia() {
		return codOcorrencia;
	}

	public void setCodOcorrencia(String codOcorrencia) {
		this.codOcorrencia = codOcorrencia;
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
		setCodigoConvenio((String) record.getValue(CD_CONVENIO));
		setAgenciaMantenedora((Integer) record.getValue(AGENCIA_MANTENEDORA));
		setDigitoVerificadorAgencia((String) record.getValue(DIGITO_AGENCIA));
		setNumeroContaCorrente((Long) record.getValue(NR_CONTACORRENTE));
		setDigitoVerificadorContaCorrente((String) record.getValue(DIGITO_CONTACORRENTE));
		setDigitoVerificadorAgenciaConta((String) record.getValue(DIGITO_AGENCIACONTA));
		setNomeEmpresa((String) record.getValue(NOME_EMPRESA));
		setMensagem1((String) record.getValue(MENSAGEM_1));
	}

	public static HeaderLote of(ContaBancaria contaBancaria, Date dataGravacao) {
		return new HeaderLote(contaBancaria, dataGravacao);
	}

	public static HeaderLote of(ContaBancaria contaBancaria) {
		return new HeaderLote(contaBancaria);
	}

}
