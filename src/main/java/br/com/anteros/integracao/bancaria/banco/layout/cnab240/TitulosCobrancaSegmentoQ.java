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
package br.com.anteros.integracao.bancaria.banco.layout.cnab240;

import java.util.List;

import br.com.anteros.flatfile.annotation.Field;
import br.com.anteros.flatfile.annotation.IdType;
import br.com.anteros.flatfile.annotation.Paddings;
import br.com.anteros.flatfile.annotation.RecordData;
import br.com.anteros.flatfile.language.EnumTypes;
import br.com.anteros.integracao.bancaria.banco.layout.ContaBancaria;
import br.com.anteros.integracao.bancaria.banco.layout.RemessaCobranca;
import static br.com.anteros.integracao.bancaria.banco.layout.ConstantsCNAB.*;

public class TitulosCobrancaSegmentoQ implements RecordData {

	@IdType(name = "CD_SEGMENTO_REGISTRO", length = 1, positionField = 5, value = "Q")
	private String codigoSegmentoRegistro;

	@Field(name = "CD_BANCO", length = 3, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoBanco;

	@Field(name = "LT_SERVICO", length = 4, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer loteServico;

	@Field(name = "TP_REGISTRO", length = 1, type = EnumTypes.INTEGER, value = "3", padding = Paddings.ZERO_LEFT)
	private Integer tipoRegistro;

	@Field(name = "NR_SEQUENCIA_REGISTRO", length = 5, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer numeroSequencialRegistro;

	@Field(name = "BRANCOS_1", length = 1, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos1;

	@Field(name = "CD_MOVIMENTO_REMESSA", length = 2, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoMovimentoRemessa;

	@Field(name = "TP_INSCRICAO_SACADO", length = 1, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer tipoInscricaoSacado;

	@Field(name = "NR_INSCRICAO_SACADO", length = 15, type = EnumTypes.LONG, padding = Paddings.ZERO_LEFT)
	private Long numeroInscricaoSacado;

	@Field(name = "NOME", length = 40, padding = Paddings.WHITE_SPACE_RIGHT)
	private String nome;

	@Field(name = "ENDERECO", length = 40, padding = Paddings.WHITE_SPACE_RIGHT)
	private String endereco;

	@Field(name = "BAIRRO", length = 15, padding = Paddings.WHITE_SPACE_RIGHT)
	private String bairro;

	@Field(name = "CEP", length = 5, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer cep;

	@Field(name = "SUFIXO_CEP", length = 3, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer sufixoCEP;

	@Field(name = "CIDADE", length = 15, padding = Paddings.WHITE_SPACE_RIGHT)
	private String cidade;

	@Field(name = "UF", length = 2, padding = Paddings.WHITE_SPACE_RIGHT)
	private String uf;

	@Field(name = "TP_INSCRICAO_SACADO_AVALISTA", length = 1, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer tipoInscricaoSacadoAvalista;

	@Field(name = "NR_INSCRICAO_SACADO_AVALISTA", length = 15, type = EnumTypes.LONG, padding = Paddings.ZERO_LEFT)
	private Long numeroInscricaoSacadoAvalista;

	@Field(name = "NOME_SACADO_AVALISTA", length = 40, padding = Paddings.WHITE_SPACE_RIGHT)
	private String nomeSacadorAvalista;

	@Field(name = "CD_BANCO_CORRESPONDENTE_COMPE", length = 3, type = EnumTypes.INTEGER, padding = Paddings.ZERO_LEFT)
	private Integer codigoBancoCorrespondenteCompe;

	@Field(name = "NOSSO_NUMERO_BANCO_CORRESPONDENTE", length = 20, padding = Paddings.WHITE_SPACE_RIGHT)
	private String nossoNumeroBancoCorrespondente;

	@Field(name = "BRANCOS_2", length = 8, value = " ", padding = Paddings.WHITE_SPACE_RIGHT)
	private String brancos2;

	private List<RemessaCobranca> remessas;

	private ContaBancaria contaBancaria;

	private TitulosCobrancaSegmentoQ(ContaBancaria contaBancaria, List<RemessaCobranca> remessas) {
		this.remessas = remessas;
		this.contaBancaria = contaBancaria;
	}

	public static TitulosCobrancaSegmentoQ of(ContaBancaria contaBancaria, List<RemessaCobranca> remessas) {
		return new TitulosCobrancaSegmentoQ(contaBancaria, remessas);
	}

	public String getCodigoSegmentoRegistro() {
		return codigoSegmentoRegistro;
	}

	public void setCodigoSegmentoRegistro(String codigoSegmentoRegistro) {
		this.codigoSegmentoRegistro = codigoSegmentoRegistro;
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

	public Integer getTipoRegistro() {
		return tipoRegistro;
	}

	public void setTipoRegistro(Integer tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public Integer getNumeroSequencialRegistro() {
		return numeroSequencialRegistro;
	}

	public void setNumeroSequencialRegistro(Integer numeroSequencialRegistro) {
		this.numeroSequencialRegistro = numeroSequencialRegistro;
	}

	public String getBrancos1() {
		return brancos1;
	}

	public void setBrancos1(String brancos1) {
		this.brancos1 = brancos1;
	}

	public Integer getCodigoMovimentoRemessa() {
		return codigoMovimentoRemessa;
	}

	public void setCodigoMovimentoRemessa(Integer codigoMovimentoRemessa) {
		this.codigoMovimentoRemessa = codigoMovimentoRemessa;
	}

	public Integer getTipoInscricaoSacado() {
		return tipoInscricaoSacado;
	}

	public void setTipoInscricaoSacado(Integer tipoInscricaoSacado) {
		this.tipoInscricaoSacado = tipoInscricaoSacado;
	}

	public Long getNumeroInscricaoSacado() {
		return numeroInscricaoSacado;
	}

	public void setNumeroInscricaoSacado(Long numeroInscricaoSacado) {
		this.numeroInscricaoSacado = numeroInscricaoSacado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public Integer getSufixoCEP() {
		return sufixoCEP;
	}

	public void setSufixoCEP(Integer sufixoCEP) {
		this.sufixoCEP = sufixoCEP;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Integer getTipoInscricaoSacadoAvalista() {
		return tipoInscricaoSacadoAvalista;
	}

	public void setTipoInscricaoSacadoAvalista(Integer tipoInscricaoSacadoAvalista) {
		this.tipoInscricaoSacadoAvalista = tipoInscricaoSacadoAvalista;
	}

	public Long getNumeroInscricaoSacadoAvalista() {
		return numeroInscricaoSacadoAvalista;
	}

	public void setNumeroInscricaoSacadoAvalista(Long numeroInscricaoSacadoAvalista) {
		this.numeroInscricaoSacadoAvalista = numeroInscricaoSacadoAvalista;
	}

	public String getNomeSacadorAvalista() {
		return nomeSacadorAvalista;
	}

	public void setNomeSacadorAvalista(String nomeSacadorAvalista) {
		this.nomeSacadorAvalista = nomeSacadorAvalista;
	}

	public Integer getCodigoBancoCorrespondenteCompe() {
		return codigoBancoCorrespondenteCompe;
	}

	public void setCodigoBancoCorrespondenteCompe(Integer codigoBancoCorrespondenteCompe) {
		this.codigoBancoCorrespondenteCompe = codigoBancoCorrespondenteCompe;
	}

	public String getNossoNumeroBancoCorrespondente() {
		return nossoNumeroBancoCorrespondente;
	}

	public void setNossoNumeroBancoCorrespondente(String nossoNumeroBancoCorrespondente) {
		this.nossoNumeroBancoCorrespondente = nossoNumeroBancoCorrespondente;
	}

	public String getBrancos2() {
		return brancos2;
	}

	public void setBrancos2(String brancos2) {
		this.brancos2 = brancos2;
	}

	public List<RemessaCobranca> getRemessas() {
		return remessas;
	}

	public void setRemessas(List<RemessaCobranca> remessas) {
		this.remessas = remessas;
	}

	public int getNumberOfRecords() {
		return remessas.size();
	}

	public void readRowData(int row) {
		this.codigoBanco = contaBancaria.getBanco().getCodigoDeCompensacaoBACEN().getCodigo(); // G001
		this.loteServico = 1; // G002
		this.numeroSequencialRegistro = row + 1;// G038
		this.codigoMovimentoRemessa = remessas.get(row).getCodigoMovimentoRemessa().getTipo();// C004
		this.tipoInscricaoSacado = (remessas.get(row).getTitulo().getSacado().getCPRF().isFisica() ? 1 : 2);// G005
		this.numeroInscricaoSacado = remessas.get(row).getTitulo().getSacado().getCPRF().getCodigo();// G006
		this.nome = remessas.get(row).getTitulo().getSacado().getNome();// G013
		this.endereco = remessas.get(row).getTitulo().getSacado().getNextEndereco().getLogradouro() + ", "
				+ remessas.get(row).getTitulo().getSacado().getNextEndereco().getNumero();// G032
		this.bairro = remessas.get(row).getTitulo().getSacado().getNextEndereco().getBairro();// G032
		this.cep = remessas.get(row).getTitulo().getSacado().getNextEndereco().getCEP().getPrefixo();// G034
		this.sufixoCEP = remessas.get(row).getTitulo().getSacado().getNextEndereco().getCEP().getSufixo();// G035
		this.cidade = remessas.get(row).getTitulo().getSacado().getNextEndereco().getLocalidade();// G033
		this.uf = remessas.get(row).getTitulo().getSacado().getNextEndereco().getUF().getSigla();// G036
		if (remessas.get(row).getTitulo().getSacadorAvalista() == null) {
			this.tipoInscricaoSacadoAvalista = 0;// G005
			this.numeroInscricaoSacadoAvalista = 0L;// G006
			this.nomeSacadorAvalista = " ";// G013
		} else {
			this.tipoInscricaoSacadoAvalista = (remessas.get(row).getTitulo().getSacadorAvalista().getCPRF().isFisica()// G005
					? 1 : 2);
			this.numeroInscricaoSacadoAvalista = remessas.get(row).getTitulo().getSacadorAvalista().getCPRF()
					.getCodigo();// G006
			this.nomeSacadorAvalista = remessas.get(row).getTitulo().getSacadorAvalista().getNome();// G013
		}
		this.nossoNumeroBancoCorrespondente = " ";// C032
		this.codigoBancoCorrespondenteCompe = 0; // C031
	}

	public void set(br.com.anteros.flatfile.Record record) {
		
	}

}
