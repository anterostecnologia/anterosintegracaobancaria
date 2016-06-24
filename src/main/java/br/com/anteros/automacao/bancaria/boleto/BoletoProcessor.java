package br.com.anteros.automacao.bancaria.boleto;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

import br.com.anteros.core.utils.ObjectUtils;
import br.com.anteros.core.utils.StringUtils;

public class BoletoProcessor {

	private Map<String, String> texts = new WeakHashMap<String, String>();
	private Map<String, java.awt.Image> images = new WeakHashMap<String, java.awt.Image>();
	private Map<java.awt.Image, Image> imagesInUseMap = new WeakHashMap<java.awt.Image, Image>();

	private byte[] template;

	public BoletoProcessor(Boleto boleto, BoletoInfoViewBuilder builder, byte[] template) {
		this.texts.putAll(builder.texts());
		this.images.putAll(builder.images());
		this.template = template;
	}

	public byte[] execute() throws IOException, DocumentException {

		PdfReader reader = new PdfReader(template);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PdfStamper stamper = new PdfStamper(reader, baos);

		AcroFields form = stamper.getAcroFields();
		for (Entry<String, String> e : texts.entrySet()) {
			form.setField(e.getKey(), e.getValue());
		}

		for (Entry<String, java.awt.Image> e : images.entrySet()) {
			setImage(stamper, e.getKey(), e.getValue());
		}
		stamper.setFullCompression();
		stamper.setFreeTextFlattening(true);
		stamper.setFormFlattening(true);
		reader.removeFields();
		reader.consolidateNamedDestinations();
		reader.eliminateSharedStreams();
		baos.flush();
		baos.close();
		reader.close();
		stamper.close();
		return baos.toByteArray();
	}

	private void setImage(PdfStamper stamper, String fieldName, java.awt.Image image) {
		float posImgField[];
		if (StringUtils.isNotBlank(fieldName)) {
			posImgField = stamper.getAcroFields().getFieldPositions(fieldName);
			if (ObjectUtils.isNotNull(posImgField)) {
				try {
					changeFieldToImage(stamper, new PdfRectangle(posImgField), getPdfImage(image));
				} catch (Exception e) {
					throw new IllegalStateException(e);
				}
			}
		}
	}

	public Image getPdfImage(java.awt.Image image) {
		Image pdfImage = imagesInUseMap.get(image);
		if (ObjectUtils.isNull(pdfImage)) {
			try {
				pdfImage = Image.getInstance(image, null);
				imagesInUseMap.put(image, pdfImage);
			} catch (Exception ex) {
				throw new IllegalStateException(ex);
			}
		}
		return pdfImage;
	}

	public PdfRectangle changeFieldToImage(PdfStamper stamper, PdfRectangle rect, Image image)
			throws DocumentException {
		image.scaleAbsolute(rect.getWidth(), rect.getHeight());
		image.setAbsolutePosition(rect.getLowerLeftX() + (rect.getWidth() - image.getScaledWidth()) / 2,
				rect.getLowerLeftY() + (rect.getHeight() - image.getScaledHeight()) / 2);
		stamper.getOverContent(rect.getPage()).addImage(image);
		return rect;
	}

}
