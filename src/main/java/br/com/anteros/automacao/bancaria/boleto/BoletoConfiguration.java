package br.com.anteros.automacao.bancaria.boleto;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import br.com.anteros.core.utils.IOUtils;
import br.com.anteros.core.utils.StringUtils;

public class BoletoConfiguration {
	private boolean groupResults;
	private String templatePath;
	private URL templateURL;
	private File templateFile;
	private InputStream templateInput;
	private String destinationPath;
	private String prefix;
	private String sufix;
	private String title;
	private String author;
	private String subject;
	private String keywords;
	private String creator;
	private String creationDate;
	private String modificationDate;
	private String producer;

	public BoletoConfiguration(BoletoConfigurationBuilder builder) {
		this.groupResults = builder.isGroupResults();
		this.templatePath = builder.getTemplatePath();
		this.templateURL = builder.getTemplateURL();
		this.templateFile = builder.getTemplateFile();
		this.templateInput = builder.getTemplateInput();
		this.destinationPath = builder.getDestinationPath();
		this.prefix = builder.getPrefix();
		this.sufix = builder.getSufix();
		this.title = builder.getTitle();
		this.author = builder.getAuthor();
		this.subject = builder.getSubject();
		this.keywords = builder.getKeywords();
		this.creator = builder.getCreator();
		this.creationDate = builder.getCreationDate();
		this.modificationDate = builder.getModificationDate();
		this.producer = builder.getProducer();
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

	public byte[] getTemplate(Boleto boleto) throws IOException {
		if (StringUtils.isNotEmpty(templatePath)) {
			File file = new File(templatePath);
			if (!file.exists()) {
				throw new BoletoException("Template " + templatePath + " não encontrado.");
			}
			FileInputStream fis = new FileInputStream(file);
			byte[] byteArray = IOUtils.toByteArray(fis);
			return byteArray;
		}

		if (templateURL != null) {
			InputStream fis = templateURL.openStream();
			byte[] byteArray = IOUtils.toByteArray(fis);
			return byteArray;
		}

		if (templateFile != null) {
			FileInputStream fis = new FileInputStream(templateFile);
			byte[] byteArray = IOUtils.toByteArray(fis);
			return byteArray;
		}

		if (templateInput != null) {
			byte[] byteArray = IOUtils.toByteArray(templateInput);
			return byteArray;
		}

		if (boleto.getTitulo().hasSacadorAvalista()) {
			return ResourceBundle.getInstance().getTemplateComSacadorAvalista();
		} else {
			return ResourceBundle.getInstance().getTemplateSemSacadorAvalista();
		}
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getSubject() {
		return subject;
	}

	public String getKeywords() {
		return keywords;
	}

	public String getCreator() {
		return creator;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public String getProducer() {
		return producer;
	}

	public String getModificationDate() {
		return modificationDate;
	}

}
