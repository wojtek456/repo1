package PDFCreator;

import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.util.Matrix;

public class PDFConstructor {
	private PDDocument document;
	private PDPage page;
	private PDPageContentStream contentStream;
	private ImageBuilder image;
	private String logoText;
	private String monitoringPeriodTimeTxt;
	private String releaseDateTxt;
	private TextBuilder text;
	private float pageHeight = 600;
	private float pageWidth = 800;
	private List<String> listWithSimilarPathImage;
	private List<String> listWithSimilarImageName;
	private List<String> listWithConflictsPathImage;
	private List<String> listWithConflictsImageName;

	public PDFConstructor(String logoTextPage1, String monitoringPeriodTimeTxtPage1,
			String releaseDateTxtPage1, List<String> listWithSimilarPathImage,
			List<String> listWithSimilarImageName, List<String> listWithConflictsPathImage,
			List<String> listWithConflictsImageName) {
		this.logoText = logoTextPage1;
		this.monitoringPeriodTimeTxt = monitoringPeriodTimeTxtPage1;
		this.releaseDateTxt = releaseDateTxtPage1;
		this.listWithSimilarPathImage = listWithSimilarPathImage;
		this.listWithSimilarImageName = listWithSimilarImageName;
		this.listWithConflictsPathImage = listWithConflictsPathImage;
		this.listWithConflictsImageName = listWithConflictsImageName;
	}

	private void generateDocument() {
		document = new PDDocument();
	}

	private void addPage() throws IOException {
		page = new PDPage(new PDRectangle(pageHeight, pageWidth));
		page.setRotation(90);
		document.addPage(page);

	}

	private void openContentStream(PDDocument document, PDPage page) throws IOException {
		contentStream = new PDPageContentStream(document, page);
	}

	private void closeContentStream() throws IOException {
		contentStream.close();
	}

	private void addBacgroundPage(String path) throws IOException {
		image = new ImageBuilder(path, document);
		image.setParametersForBackgroundImage();
		contentStream.drawImage(image.getObjectImage().getImage(),
				createMatrix(image.getObjectImage(), pageHeight, pageWidth));
	}

	private Matrix createMatrix(Image imageObject) {
		double imageHeight = imageObject.getImage().getHeight();
		double imageWidth = imageObject.getImage().getWidth();
		float imageX = imageObject.getCoordinateLowerLeftX();
		float imageY = imageObject.getCoordinateLowerLeftY();
		AffineTransform at = new AffineTransform(imageHeight, 0, 0, imageWidth, imageY
				+ imageHeight / 2, imageX - imageWidth / 2);
		at.rotate(Math.toRadians(90));
		return new Matrix(at);
	}

	private Matrix createMatrix(Image imageObject, float pageHeight, float pageWidth) {
		double imageHeight = imageObject.getImage().getHeight();
		double imageWidth = imageObject.getImage().getWidth();
		float imageX = imageObject.getCoordinateLowerLeftX();
		float imageY = imageObject.getCoordinateLowerLeftY();
		AffineTransform at = new AffineTransform(imageHeight, 0, 0, imageWidth, imageY, imageX);
		at.rotate(Math.toRadians(90));
		Matrix matrix = new Matrix(at);
		matrix.scale((float) (pageHeight / imageHeight), (float) (pageWidth / imageWidth));
		return matrix;
	}

	private void addText(Text textObject) throws IOException {
		contentStream.setNonStrokingColor(textObject.getColorA(), textObject.getColorB(),
				textObject.getColorC());
		contentStream.beginText();
		contentStream.setFont(textObject.getFont(), textObject.getFontSize());
		contentStream.setTextRotation(textObject.getTextRotation(),
				textObject.getCoordinateLowerLeftY(), textObject.getCoordinateLowerLeftX());
		contentStream.showText(textObject.getText());
		contentStream.endText();

	}

	private void insertMultiTextsAndImages(List<String> listWithPathImage,
			List<String> listWithImageName, String backgroundForEmpty, String backgroundForElement)
			throws IOException {
		if (listWithPathImage.size() == 0) {
			addPage();
			openContentStream(document, page);
			addBacgroundPage("F:/PDFBox/images/" + backgroundForEmpty + ".JPG");
			closeContentStream();
		} else {

			int numberOfPages;
			numberOfPages = Math.round(listWithPathImage.size() / 12) + 1;
			int licznikObrazki = 0;

			for (int i = 0; i < numberOfPages; i++) {
				addPage();
				openContentStream(document, page);
				addBacgroundPage("F:/PDFBox/images/" + backgroundForElement + ".JPG");
				for (int k = 0; k < 12; k++) {
					if (licznikObrazki < listWithPathImage.size()) {
						image = new ImageBuilder("F:/PDFBox/images/"
								+ listWithPathImage.get(licznikObrazki) + ".png", document);
						image.createParameterForSimilarAndConflictsTrademarkImage();
						image.setParameterForSimilarAndConflictsTrademarkImage(k);
						float imageX = image.getObjectImage().getCoordinateLowerLeftX();
						float imageY = image.getObjectImage().getCoordinateLowerLeftY();
						float imageHeight = image.getObjectImage().getImage().getHeight();
						text = new TextBuilder();
						text.setParametersForTrademarkNameBelowImage(listWithImageName.get(k),
								imageX, imageY, imageHeight);
						contentStream.drawImage(image.getObjectImage().getImage(),
								createMatrix(image.getObjectImage()));
						addText(text.getObjectText());
						licznikObrazki += 1;
					} else {
						break;
					}
				}
				closeContentStream();
			}
		}
	}

	private void createPage1() throws IOException {
		addPage();
		openContentStream(document, page);
		addBacgroundPage("F:/PDFBox/images/backgroundPage1.JPG");
		text = new TextBuilder();
		text.setParametersForLogoName(logoText);
		addText(text.getObjectText());
		text.setParametersForMonitoringPeriodTimeText(monitoringPeriodTimeTxt);
		addText(text.getObjectText());
		text.setParametersForreleaseDateText(releaseDateTxt);
		addText(text.getObjectText());
		closeContentStream();
	}

	private void createPage2() throws IOException {
		addPage();
		openContentStream(document, page);
		addBacgroundPage("F:/PDFBox/images/backgroundPage2.JPG");
		image = new ImageBuilder("F:/PDFBox/images/AnalyzedTrademarkImage.png", document);
		image.setParametersForAnalyzedTrademarkImage();
		contentStream.drawImage(image.getObjectImage().getImage(),
				createMatrix(image.getObjectImage()));

		text = new TextBuilder();
		text.setParametersForTrademarkName(logoText);
		addText(text.getObjectText());
		text.setParametersForMonitorindEndDate("20.08.2017");
		addText(text.getObjectText());
		text.setParametersForMonitoringStartDate("15.08.2017");
		addText(text.getObjectText());
		text.setParametersForMonitoringBase("Urzad patentowy");
		addText(text.getObjectText());
		text.setParametersForMonitoringClass("35,31,42");
		addText(text.getObjectText());
		text.setParametersForNumberAnalyzedTrademark("19091");
		addText(text.getObjectText());
		text.setParametersForNumberOfSimilarTrademark("82");
		addText(text.getObjectText());
		text.setParametersForNumberOfConflictsTrademark("0");
		addText(text.getObjectText());
		closeContentStream();

	}

	private void createPage3() throws IOException {
		addPage();
		openContentStream(document, page);
		addBacgroundPage("F:/PDFBox/images/backgroundPage3.JPG");
		image = new ImageBuilder("F:/PDFBox/images/statisticAnalize.png", document);
		image.setParametersForStatisticAnaliseImage();
		contentStream.drawImage(image.getObjectImage().getImage(),
				createMatrix(image.getObjectImage()));
		closeContentStream();

	}

	private void createPagesWithCollisionTrademark() throws IOException {
		insertMultiTextsAndImages(listWithConflictsPathImage, listWithConflictsImageName,
				"backgroundForCollisionTradeMarkEmpty", "backgroundForCollisionTradeMark");

	}

	private void createPagesWithSimilarTrademark() throws IOException {
		insertMultiTextsAndImages(listWithSimilarPathImage, listWithSimilarImageName,
				"backgroundForSimilarTradeMarkEmpty", "backgroundForSimilarTradeMark");

	}

	private void createLastPage() throws IOException {
		addPage();
		openContentStream(document, page);
		addBacgroundPage("F:/PDFBox/images/backgroundLastPage.JPG");
		closeContentStream();

	}

	public void generatePDF(String savePath) throws IOException {
		generateDocument();
		createPage1();
		createPage2();
		createPage3();
		createPagesWithCollisionTrademark();
		createPagesWithSimilarTrademark();
		createLastPage();
		document.save(savePath);
		document.close();
		System.out.println("The report was generated successfully");

	}


}
