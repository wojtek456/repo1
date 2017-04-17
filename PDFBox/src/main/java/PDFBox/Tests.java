package PDFBox;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.color.PDColor;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionURI;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;
import org.apache.pdfbox.util.Matrix;

import PDFBox.FileChooserTest.SaveL;

public class Tests {

	public static void main(String[] args) throws IOException {

		PDDocument document = new PDDocument();
		float pageHeight = 600f;
		float pageWidth = 800f;
		PDPage page1 = new PDPage(new PDRectangle(pageHeight, pageWidth));
		page1.setRotation(90);
		double textRotation = Math.PI / 2;
		document.addPage(page1);
		PDPageContentStream contentStream = new PDPageContentStream(document, page1);

		// Insert background
		PDImageXObject background = PDImageXObject
				.createFromFile("C:/Users/wojtek/Desktop/Apache PDF tests/images/tlo.png", document);
		float backgroundUpperLeftY = 0f;
		float backgroundUpperLeftX = 0f;
		contentStream.drawImage(background, backgroundUpperLeftX, backgroundUpperLeftY);

		String symbolName = "BULLSTAR";
		PDFont symbolNameFont = PDType1Font.HELVETICA;
		int symbolNameFontSize = 32;
		contentStream.setNonStrokingColor(100, 100, 100);
		float symbolNameLowerLeftX = (page1.getMediaBox().getHeight() / 2)
				- (symbolNameFont.getStringWidth(symbolName) / 1000 * symbolNameFontSize) / 2;
		float symbolNameLowerLeftY = (float) (347f + 0.8 * symbolNameFontSize / 2);

		// Insert symbol name

		contentStream.beginText();
		contentStream.setFont(symbolNameFont, symbolNameFontSize);
		contentStream.setTextRotation(textRotation, symbolNameLowerLeftY, symbolNameLowerLeftX);
		contentStream.showText(symbolName);
		contentStream.endText();

		// monitoring period time text settings
		String periodTimeText = "03.04.2017 - 10.04.2017";
		PDFont periodTimeTextFont = PDType1Font.HELVETICA;
		int periodTimeTextFontSize = 22;
		contentStream.setNonStrokingColor(255, 255, 0);
		float centerperiodTimeTextY = 538f;
		float periodTimeTextLowerLeftX = 58f;
		float periodTimeTextLowerLeftY = (float) (centerperiodTimeTextY + 0.8 * periodTimeTextFontSize / 2);

		// Insert monitoring period date (left bottom corner)
		contentStream.beginText();
		contentStream.setFont(periodTimeTextFont, periodTimeTextFontSize);
		contentStream.setTextRotation(textRotation, periodTimeTextLowerLeftY, periodTimeTextLowerLeftX);
		contentStream.showText(periodTimeText);
		contentStream.endText();

		// release date text settings
		String releaseDateText = "14.04.2017";
		PDFont releaseDateTextFont = PDType1Font.HELVETICA;
		int releaseDateTextFontSize = 22;
		contentStream.setNonStrokingColor(255, 159, 127);
		float centerReleaseDateTimeTextY = 538f;
		float releaseDateTextLowerLeftX = 735f
				- (releaseDateTextFont.getStringWidth(releaseDateText) / 1000 * releaseDateTextFontSize);
		float releaseDateTextLowerLeftY = (float) (centerReleaseDateTimeTextY + 0.8 * releaseDateTextFontSize / 2);

		// Insert release date (right bottom corner)
		contentStream.beginText();
		contentStream.setFont(releaseDateTextFont, releaseDateTextFontSize);
		contentStream.setTextRotation(textRotation, releaseDateTextLowerLeftY, releaseDateTextLowerLeftX);
		contentStream.showText(releaseDateText);
		contentStream.endText();

		contentStream.close();

		document.save("C:/Users/wojtek/Desktop/Apache PDF tests/test_sologo.pdf");
		document.close();

	}

}
