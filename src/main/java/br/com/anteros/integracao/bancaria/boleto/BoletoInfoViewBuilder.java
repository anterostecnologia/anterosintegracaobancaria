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
package br.com.anteros.integracao.bancaria.boleto;


import java.awt.Image;
import java.util.Map;
import java.util.Map.Entry;

import br.com.anteros.core.log.Logger;
import br.com.anteros.core.log.LoggerProvider;
import br.com.anteros.core.utils.Assert;
import br.com.anteros.core.utils.ObjectUtils;
import br.com.anteros.integracao.bancaria.boleto.campo.BoletoInfoCampoView;
import br.com.anteros.integracao.bancaria.boleto.campo.BoletoInfoCampoViewFactory;

import java.util.WeakHashMap;


/**
 * Lê os dados do Boleto e monta-os para uso em {@linkplain #texts()} e {@linkplain #images()}. 
 * 
 *
 */
public class BoletoInfoViewBuilder {
	
	private static Logger log = LoggerProvider.getInstance().getLogger(BoletoInfoViewBuilder.class);
	
	private final Map<String,String> text;
	private final Map<String,Image> image;

	private final Map<String,String> boletoTextosExtra;
	private final Map<String,Image> boletoImagensExtra;

	private final BoletoInfoCampoView boletoInfoCampo;
	
	
	/**
	 * Modo de instanciação não permitido.
	 * 
	 * @throws IllegalStateException
	 *             Caso haja alguma tentativa de utilização deste construtor.
	 */
	@SuppressWarnings("unused")
	private BoletoInfoViewBuilder(){
		text = null;
		image = null;
		boletoTextosExtra = null;
		boletoImagensExtra = null;
		boletoInfoCampo = null;
		throw new IllegalStateException("Instanciação não permitida!");
	}
	
	public BoletoInfoViewBuilder(ResourceBundle resourceBundle, Boleto boleto){
		
		Assert.notNull(resourceBundle);
		Assert.notNull(boleto);
		
		text = new WeakHashMap<String, String>();
		image = new WeakHashMap<String, Image>();
		
		this.boletoTextosExtra = boleto.getTextosExtras();
		this.boletoImagensExtra = boleto.getImagensExtras();
		this.boletoInfoCampo = BoletoInfoCampoViewFactory.create(resourceBundle, boleto);
	}
	
	public Map<String,String> texts(){
		
		return new WeakHashMap<String, String>(text);
	}
	
	public Map<String,Image> images(){
		
		return new WeakHashMap<String, Image>(image);
	}
	
	/**
	 * Preenche todos os campos com os dados do boleto contido na instância.
	 * 
	 * @return Esta instância após operação
	 * 
	 * @since 0.2
	 */
	public BoletoInfoViewBuilder build(){
		
		setLogotipoDoBanco();
		setCodigoDoBanco();
		setLinhaDigitavel();
		setCedente();
		setAgenciaCodigoCedente();
		setEspecie();
		setNossoNumero();
		setNumeroDocumento();
		setCprfCedente();
		setDataVencimeto();
		setValorDocumento();
		setDescontoAbatimento();
		setOutraDeducao();
		setMoraMulta();
		setOutroAcrescimo();
		setValorCobrado();
		setInstrucaoAoSacado();
		setInstrucaoAoCaixa();
		setSacado();
		setLocalPagamento();
		setDataDocumento();
		setEspecieDoc();
		setAceite();
		setDataProcessamento();
		setSacadorAvalista();
		setCodigoDeBarras();
		setCarteira();
		setTodosOsCamposTexto();
		setTodosOsCamposImagem();
		
		return this;
	}
	
	private void setInstrucaoAoSacado(){
		text.put(BoletoCampo.txtRsInstrucaoAoSacado.name(), boletoInfoCampo.getTextoRsInstrucaoAoSacado());
	}
	
	private void setCprfCedente(){
		text.put(BoletoCampo.txtRsCpfCnpj.name(), boletoInfoCampo.getTextoRsCpfCnpj());
	}

	private void setDataProcessamento(){
		text.put(BoletoCampo.txtFcDataProcessamento.name(), boletoInfoCampo.getTextoFcDataProcessamento());
	}

	private void setLocalPagamento(){
		text.put(BoletoCampo.txtFcLocalPagamento.name(), boletoInfoCampo.getTextoFcLocalPagamento());
	}

	private void setAceite(){
		text.put(BoletoCampo.txtFcAceite.name(), boletoInfoCampo.getTextoFcAceite());
	}

	private void setEspecieDoc(){
		text.put(BoletoCampo.txtFcEspecieDocumento.name(), boletoInfoCampo.getTextoFcEspecieDocumento());
	}

	private void setDataDocumento(){
		text.put(BoletoCampo.txtFcDataDocumento.name(), boletoInfoCampo.getTextoFcDataDocumento());
	}

	private void setCarteira(){
		text.put(BoletoCampo.txtFcCarteira.name(), boletoInfoCampo.getTextoFcCarteira());
	}

	private void setSacado(){
		text.put(BoletoCampo.txtRsSacado.name(), boletoInfoCampo.getTextoRsSacado());
		text.put(BoletoCampo.txtFcSacadoL1.name(), boletoInfoCampo.getTextoFcSacadoL1());
		text.put(BoletoCampo.txtFcSacadoL2.name(), boletoInfoCampo.getTextoFcSacadoL2());
		text.put(BoletoCampo.txtFcSacadoL3.name(), boletoInfoCampo.getTextoFcSacadoL3());
	}
	
	private void setSacadorAvalista(){
		text.put(BoletoCampo.txtFcSacadorAvalistaL1.name(), boletoInfoCampo.getTextoFcSacadorAvalistaL1());
		text.put(BoletoCampo.txtFcSacadorAvalistaL2.name(), boletoInfoCampo.getTextoFcSacadorAvalistaL2());
		text.put(BoletoCampo.txtFcSacadorAvalistaL3.name(), boletoInfoCampo.getTextoFcSacadorAvalistaL3());
	}
	
	private void setInstrucaoAoCaixa(){
		text.put(BoletoCampo.txtFcInstrucaoAoCaixa1.name(), boletoInfoCampo.getTextoFcInstrucaoAoCaixa1());
		text.put(BoletoCampo.txtFcInstrucaoAoCaixa2.name(), boletoInfoCampo.getTextoFcInstrucaoAoCaixa2());
		text.put(BoletoCampo.txtFcInstrucaoAoCaixa3.name(), boletoInfoCampo.getTextoFcInstrucaoAoCaixa3());
		text.put(BoletoCampo.txtFcInstrucaoAoCaixa4.name(), boletoInfoCampo.getTextoFcInstrucaoAoCaixa4());
		text.put(BoletoCampo.txtFcInstrucaoAoCaixa5.name(), boletoInfoCampo.getTextoFcInstrucaoAoCaixa5());
		text.put(BoletoCampo.txtFcInstrucaoAoCaixa6.name(), boletoInfoCampo.getTextoFcInstrucaoAoCaixa6());
		text.put(BoletoCampo.txtFcInstrucaoAoCaixa7.name(), boletoInfoCampo.getTextoFcInstrucaoAoCaixa7());
		text.put(BoletoCampo.txtFcInstrucaoAoCaixa8.name(), boletoInfoCampo.getTextoFcInstrucaoAoCaixa8());
	}

	private void setMoraMulta(){
		text.put(BoletoCampo.txtRsMoraMulta.name(), boletoInfoCampo.getTextoRsMoraMulta());
		text.put(BoletoCampo.txtFcMoraMulta.name(), boletoInfoCampo.getTextoFcMoraMulta());
	}
	
	private void setOutroAcrescimo(){
		text.put(BoletoCampo.txtRsOutroAcrescimo.name(), boletoInfoCampo.getTextoRsOutroAcrescimo());
		text.put(BoletoCampo.txtFcOutroAcrescimo.name(), boletoInfoCampo.getTextoFcOutroAcrescimo());
	}

	private void setOutraDeducao(){
		text.put(BoletoCampo.txtRsOutraDeducao.name(), boletoInfoCampo.getTextoRsOutraDeducao());
		text.put(BoletoCampo.txtFcOutraDeducao.name(), boletoInfoCampo.getTextoFcOutraDeducao());
	}

	private void setDescontoAbatimento(){
		text.put(BoletoCampo.txtRsDescontoAbatimento.name(), boletoInfoCampo.getTextoRsDescontoAbatimento());
		text.put(BoletoCampo.txtFcDescontoAbatimento.name(), boletoInfoCampo.getTextoFcDescontoAbatimento());
	}
	private void setValorDocumento(){
		text.put(BoletoCampo.txtRsValorDocumento.name(), boletoInfoCampo.getTextoRsValorDocumento());
		text.put(BoletoCampo.txtFcValorDocumento.name(), boletoInfoCampo.getTextoFcValorDocumento());
	}

	private void setValorCobrado(){
		text.put(BoletoCampo.txtRsValorCobrado.name(), boletoInfoCampo.getTextoRsValorCobrado());
		text.put(BoletoCampo.txtFcValorCobrado.name(), boletoInfoCampo.getTextoFcValorCobrado());
	}

	private void setDataVencimeto(){
		text.put(BoletoCampo.txtRsDataVencimento.name(),  boletoInfoCampo.getTextoRsDataVencimento());
		text.put(BoletoCampo.txtFcDataVencimento.name(),  boletoInfoCampo.getTextoFcDataVencimento());
	}

	private void setNumeroDocumento(){
		text.put(BoletoCampo.txtRsNumeroDocumento.name(), boletoInfoCampo.getTextoRsNumeroDocumento());
		text.put(BoletoCampo.txtFcNumeroDocumento.name(), boletoInfoCampo.getTextoFcNumeroDocumento());
	}
	
	private void setCedente(){
		text.put(BoletoCampo.txtRsCedente.name(), boletoInfoCampo.getTextoRsCedente());
		text.put(BoletoCampo.txtFcCedente.name(), boletoInfoCampo.getTextoFcCedente());
	}
	
	private void setEspecie(){
		text.put(BoletoCampo.txtRsEspecie.name(), boletoInfoCampo.getTextoRsEspecie());
		text.put(BoletoCampo.txtFcEspecie.name(), boletoInfoCampo.getTextoFcEspecie());
	}
	
	private void setCodigoDoBanco(){
		text.put(BoletoCampo.txtRsCodBanco.name(), boletoInfoCampo.getTextoRsCodigoBanco());
		text.put(BoletoCampo.txtFcCodBanco.name(), boletoInfoCampo.getTextoFcCodigoBanco());
	}

	private void setAgenciaCodigoCedente(){
		text.put(BoletoCampo.txtRsAgenciaCodigoCedente.name(), boletoInfoCampo.getTextoRsAgenciaCodigoCedente());
		text.put(BoletoCampo.txtFcAgenciaCodigoCedente.name(), boletoInfoCampo.getTextoFcAgenciaCodigoCedente());
	}

	private void setNossoNumero(){
		text.put(BoletoCampo.txtRsNossoNumero.name(), boletoInfoCampo.getTextoRsNossoNumero());
		text.put(BoletoCampo.txtFcNossoNumero.name(), boletoInfoCampo.getTextoFcNossoNumero());
	}
	
	private void setLogotipoDoBanco(){
		if (ObjectUtils.isNotNull(boletoInfoCampo.getImagemFcLogoBanco())) {
			image.put(BoletoCampo.txtRsLogoBanco.name(),boletoInfoCampo.getImagemRsLogoBanco());
			image.put(BoletoCampo.txtFcLogoBanco.name(),boletoInfoCampo.getImagemFcLogoBanco());
		} else {
			log.warn("Banco sem imagem definida. O nome da instituição será usado como logo.");
			text.put(BoletoCampo.txtRsLogoBanco.name(),boletoInfoCampo.getTextoRsLogoBanco());
			text.put(BoletoCampo.txtFcLogoBanco.name(),boletoInfoCampo.getTextoFcLogoBanco());
		}		
	}

	private void setLinhaDigitavel(){
		text.put(BoletoCampo.txtRsLinhaDigitavel.name(), boletoInfoCampo.getTextoRsLinhaDigitavel());
		text.put(BoletoCampo.txtFcLinhaDigitavel.name(), boletoInfoCampo.getTextoFcLinhaDigitavel());
	}
	
	private void setCodigoDeBarras(){
		image.put(BoletoCampo.txtFcCodigoBarra.name(), boletoInfoCampo.getImagemFcCodigoBarra());
	}
	
	private void setTodosOsCamposTexto(){
		if (this.boletoTextosExtra !=null && this.boletoTextosExtra.size()>0) {
			for (Entry<String, String> entry : boletoTextosExtra.entrySet()) {
				text.put(entry.getKey(), entry.getValue());
			}
		}
	}
	
	private void setTodosOsCamposImagem(){
		if (boletoImagensExtra!=null && boletoImagensExtra.size()>0) {
			for (Entry<String, Image> entry : boletoImagensExtra.entrySet()) {
				image.put(entry.getKey(), entry.getValue());
			}
		}
	}
}