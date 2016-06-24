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

import static java.lang.String.format;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;
import java.util.TreeMap;

import javax.imageio.ImageIO;

import br.com.anteros.core.utils.Assert;
import br.com.anteros.core.utils.IOUtils;
import br.com.anteros.core.utils.ObjectUtils;
import br.com.anteros.core.utils.ResourceUtils;


/**
 * Acessa os resources usados pelo Bopepo e os mantém nesta instância para as
 * próximas chamadas.
 * 
 * @author <a href="http://gilmatryx.googlepages.com/">Gilmar P.S.L.</a>
 * 
 * @since 0.2
 * 
 * @version 0.2
 */
public class ResourceBundle {
	
	private static ResourceBundle instance = null;
	
	/**
	 * Nome do arquivo pdf.
	 */
	public static final String BOLETO_TEMPLATE_COM_SACADOR_AVALISTA = "BoletoTemplateComSacadorAvalista.pdf";
	
	/**
	 * Nome do arquivo pdf.
	 */
	public static final String BOLETO_TEMPLATE_SEM_SACADOR_AVALISTA = "BoletoTemplateSemSacadorAvalista.pdf";

	/**
	 * Imagens usadas na instancia. 
	 */
	private final Map<String,Image> imagensLogoBanco;

	/**
	 * Template do projeto usando na isntancia.
	 */
	private byte[] defaultTemplateComSacadorAvalista;
	
	/**
	 * Template do projeto usando na isntancia.
	 */
	private byte[] defaultTemplateSemSacadorAvalista;
	
	
	public static ResourceBundle getInstance(){
		if (instance==null){
			instance = new ResourceBundle();
		}
		return instance;
	}
	
	/**
	 * Inicia a instancia com os valores padrões necessários.
	 */
	private ResourceBundle(){
		imagensLogoBanco = new TreeMap<String, Image>();
	}

	/**
	 * 
	 * 
	 * @return template em bytes
	 */
	public byte[] getTemplateComSacadorAvalista() {

		if (ObjectUtils.isNull(defaultTemplateComSacadorAvalista)) {

			defaultTemplateComSacadorAvalista = loadPdf("BoletoTemplateComSacadorAvalista.pdf");
		}

		return defaultTemplateComSacadorAvalista;
	}

	public byte[] getTemplateSemSacadorAvalista() {

		if (ObjectUtils.isNull(defaultTemplateSemSacadorAvalista)) {

			defaultTemplateSemSacadorAvalista = loadPdf("BoletoTemplateSemSacadorAvalista.pdf");
		}

		return defaultTemplateSemSacadorAvalista;
	}
	
	public Image getLogotipoDoBanco(String codigo){
		
		Image logo = imagensLogoBanco.get(codigo);
		
		if(ObjectUtils.isNull(logo)){
			logo = loadLogotipoDoBanco(codigo);
			imagensLogoBanco.put(codigo, logo);
		}

		return logo;
	}
	
	private BufferedImage loadLogotipoDoBanco(String codigo){	
		
		final String path = "/img/%s.png";
		
		Assert.notNull(codigo,"Codigo do banco não informado!");
		
		final String logo = format(path, codigo);
		
		URL url = ResourceUtils.getResource(logo, this.getClass());
		
		Assert.notNull(url, format("Logo não \"%s\" não encontrada!",logo));		

		BufferedImage imageLogo = null;
		
		try {
			imageLogo = ImageIO.read(url);
			Assert.notNull(imageLogo);	
		} catch (IOException e) {
			throw new IllegalStateException("Erro ao tentar ler a imagem logotipo do banco "+codigo,e);
		}
		
		return imageLogo;
	}
	
	private byte[] loadPdf(String fileName){
		
		byte[] pdf = null;
		InputStream is = null;
		
		try {
			
			is = ResourceUtils.getResource(
						"/pdf/"+fileName,
						this.getClass()).openStream();
			
			pdf = IOUtils.toByteArray(is);
			
		} catch (Exception e) {
			
			throw new IllegalStateException(e);
			
		}finally{
			if(is != null){
				try {
					is.close();
				} catch (Exception e) {
					throw new IllegalStateException(e);
				}
			}
		}
		
		return pdf;
	}
}
