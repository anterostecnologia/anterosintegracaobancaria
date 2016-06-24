package br.com.anteros.automacao.bancaria.boleto;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfReader;

import br.com.anteros.core.utils.Assert;
import br.com.anteros.core.utils.StringUtils;

public class BoletoManager {

	private static BoletoManager instance;

	public static BoletoManager getInstance() {
		if (instance == null) {
			instance = new BoletoManager();
		}

		return instance;
	}

	public List<byte[]> generate(BoletoConfiguration configuration, Boleto... boletos)
			throws IOException, DocumentException {
		List<byte[]> generatedBoletos = new ArrayList<byte[]>();

		for (Boleto boleto : boletos) {
			BoletoInfoViewBuilder builder = new BoletoInfoViewBuilder(ResourceBundle.getInstance(), boleto).build();
			BoletoProcessor processor = new BoletoProcessor(boleto, builder, configuration.getTemplate(boleto));
			generatedBoletos.add(processor.execute());
		}

		if (configuration.isGroupResults()) {
			byte[] mergeFile = mergeFiles(generatedBoletos, configuration);
			generatedBoletos.clear();
			generatedBoletos.add(mergeFile);
		}
		return generatedBoletos;
	}

	public List<byte[]> generate(BoletoConfiguration configuration, List<Boleto> boletos)
			throws IOException, DocumentException {
		return generate(configuration, boletos.toArray(new Boleto[] {}));
	}

	public List<File> generateToFile(BoletoConfiguration configuration, Boleto... boletos)
			throws IOException, DocumentException {

		Assert.notNull(configuration.getDestinationPath(), "Informe o caminho para gerar os boletos.");
		List<byte[]> generatedBoletos = generate(configuration, boletos);
		List<File> result = new ArrayList<File>();
		int i = 0;
		for (byte[] boletoBytes : generatedBoletos) {
			i++;
			String fileName = configuration.getDestinationPath() + "/"
					+ (configuration.getPrefix() == null ? "bl" : configuration.getPrefix())
					+ StringUtils.padZero(String.valueOf(i), 10)
					+ (configuration.getSufix() == null ? "" : configuration.getSufix()) + ".pdf";
			File file = new File(fileName);
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(boletoBytes);
			fos.flush();
			fos.close();
			result.add(file);
		}
		return result;
	}

	public List<File> generateToFile(BoletoConfiguration configuration, List<Boleto> boletos)
			throws IOException, DocumentException {
		return generateToFile(configuration, boletos.toArray(new Boleto[] {}));
	}

	// public List<byte[]> generateToImage(ImageType imageType,
	// BoletoConfiguration configuration, Boleto... boletos)
	// throws IOException, DocumentException {
	// List<byte[]> generatedBoletos = new ArrayList<byte[]>();
	// int i = 0;
	// for (Boleto boleto : boletos) {
	// BoletoInfoViewBuilder builder = new
	// BoletoInfoViewBuilder(ResourceBundle.getInstance(), boleto).build();
	// BoletoProcessor processor = new BoletoProcessor(boleto, builder,
	// configuration.getTemplate(boleto));
	// byte[] generatedBoleto = processor.execute();
	//
	// PDDocument pdfDocument = PDDocument.load(generatedBoleto);
	// PDFRenderer pdfRenderer = new PDFRenderer(pdfDocument);
	//
	// BufferedImage bim = pdfRenderer.renderImageWithDPI(0, 300,
	// org.apache.pdfbox.rendering.ImageType.RGB);
	// i++;
	// FileOutputStream fos = new FileOutputStream(new
	// File("/Users/edson/teste_x" + i + ".png"));
	// ImageIO.write(bim, "png", fos);
	// fos.flush();
	// fos.close();
	// pdfDocument.close();
	// }
	// return generatedBoletos;
	// }
	//
	// public List<byte[]> generateToImage(ImageType imageType,
	// BoletoConfiguration configuration, List<Boleto> boletos)
	// throws IOException, DocumentException {
	// return generateToImage(imageType, configuration, boletos.toArray(new
	// Boleto[] {}));
	// }
	//
	// public List<File> generateToImageFile(ImageType imageType,
	// BoletoConfiguration configuration, Boleto... boletos)
	// throws IOException {
	// return null;
	// }
	//
	// public List<File> generateToImageFile(ImageType imageType,
	// BoletoConfiguration configuration, List<Boleto> boletos)
	// throws IOException {
	// return generateToImageFile(imageType, configuration, boletos.toArray(new
	// Boleto[] {}));
	// }

	private byte[] mergeFiles(Collection<byte[]> pdfFiles, BoletoConfiguration configuration) {

		try {

			ByteArrayOutputStream byteOS = new ByteArrayOutputStream();
			Document document = new Document();
			PdfCopy copy = new PdfCopy(document, byteOS);
			document.open();
			for (byte[] f : pdfFiles) {
				PdfReader reader = new PdfReader(f);
				for (int page = 1; page <= reader.getNumberOfPages(); page++) {
					copy.addPage(copy.getImportedPage(reader, page));
				}
				reader.close();
			}

			document.addCreationDate();

			if (configuration != null && StringUtils.isNotEmpty(configuration.getAuthor())) {
				document.addAuthor(configuration.getAuthor());
				document.addCreator(configuration.getCreator());
				document.addTitle(configuration.getTitle());
				document.addSubject(configuration.getSubject());
				document.addKeywords(configuration.getKeywords());
			}

			copy.close();
			document.close();
			byteOS.close();

			return byteOS.toByteArray();
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

}
