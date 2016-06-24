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

import java.io.File;
import java.io.InputStream;
import java.net.URL;

public class BoletoConfigurationBuilder {

	private boolean groupResults;
	private String templatePath;
	private URL templateURL;
	private File templateFile;
	private InputStream templateInput;
	private String destinationPath;
	private String prefix;
	private String sufix;
	private Boolean fullCompression;
	private String title;
	private String author;
	private String subject;
	private String keywords;
	private String creator;
	private String creationDate;
	private String modificationDate;
	private String producer;

	public BoletoConfigurationBuilder() {
	}

	public BoletoConfigurationBuilder groupResults() {
		this.groupResults = true;
		return this;
	}

	public BoletoConfigurationBuilder template(String templatePath) {
		this.templatePath = templatePath;
		return this;
	}

	public BoletoConfigurationBuilder template(URL templateURL) {
		this.templateURL = templateURL;
		return this;
	}

	public BoletoConfigurationBuilder template(File templateFile) {
		this.templateFile = templateFile;
		return this;
	}

	public BoletoConfigurationBuilder template(InputStream templateInput) {
		this.templateInput = templateInput;
		return this;
	}

	public BoletoConfigurationBuilder destinationPath(String destinationPath) {
		this.destinationPath = destinationPath;
		return this;
	}

	public BoletoConfigurationBuilder prefix(String prefix) {
		this.prefix = prefix;
		return this;
	}

	public BoletoConfigurationBuilder sufix(String sufix) {
		this.sufix = sufix;
		return this;
	}

	public BoletoConfigurationBuilder fullCompression(Boolean fullCompression) {
		this.fullCompression = fullCompression;
		return this;
	}

	public BoletoConfiguration build() {
		return new BoletoConfiguration(this);
	}

	public boolean isGroupResults() {
		return groupResults;
	}

	public String getTemplatePath() {
		return templatePath;
	}

	public URL getTemplateURL() {
		return templateURL;
	}

	public File getTemplateFile() {
		return templateFile;
	}

	public InputStream getTemplateInput() {
		return templateInput;
	}

	public String getDestinationPath() {
		return destinationPath;
	}

	public String getPrefix() {
		return prefix;
	}

	public String getSufix() {
		return sufix;
	}

	public Boolean isFullCompression() {
		return fullCompression;
	}

	public String getTitle() {
		return title;
	}

	public BoletoConfigurationBuilder title(String title) {
		this.title = title;
		return this;
	}

	public String getAuthor() {
		return author;
	}

	public BoletoConfigurationBuilder author(String author) {
		this.author = author;
		return this;
	}

	public String getSubject() {
		return subject;
	}

	public BoletoConfigurationBuilder subject(String subject) {
		this.subject = subject;
		return this;
	}

	public String getKeywords() {
		return keywords;
	}

	public BoletoConfigurationBuilder keywords(String keywords) {
		this.keywords = keywords;
		return this;
	}

	public String getCreator() {
		return creator;
	}

	public BoletoConfigurationBuilder creator(String creator) {
		this.creator = creator;
		return this;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public BoletoConfigurationBuilder creationDate(String creationDate) {
		this.creationDate = creationDate;
		return this;
	}

	public String getModificationDate() {
		return modificationDate;
	}

	public BoletoConfigurationBuilder modificationDate(String modificationDate) {
		this.modificationDate = modificationDate;
		return this;
	}

	public String getProducer() {
		return producer;
	}

	public BoletoConfigurationBuilder producer(String producer) {
		this.producer = producer;
		return this;
	}

}
