package PDFCreator;

import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class TextBuilder {
	private Text text;

	public TextBuilder() {
		text = new Text();
		text.setTextRotation(Math.PI / 2);
	}

	public Text getObjectText() {
		return text;
	}

	// Page 1

	public void setParametersForLogoName(String txt) throws IOException {
		text.setText(txt);
		text.setColor(255, 0, 0);
		text.setFont(PDType1Font.HELVETICA);
		text.setFontSize(32);
		text.setCoordinateLowerLeftX((400f - (text.getFont().getStringWidth(text.getText()) / 1000 * text
				.getFontSize()) / 2));
		text.setCoordinateLowerLeftY((float) (347f + 0.8 * text.getFontSize() / 2));

	}

	public void setParametersForMonitoringPeriodTimeText(String txt) {
		text.setText(txt);
		text.setColor(255, 0, 0);
		text.setFont(PDType1Font.HELVETICA);
		text.setFontSize(22);
		text.setCoordinateLowerLeftX(58f);
		text.setCoordinateLowerLeftY((float) (538f + 0.8 * text.getFontSize() / 2));

	}

	public void setParametersForreleaseDateText(String txt) throws IOException {
		text.setText(txt);
		text.setColor(255, 0, 0);
		text.setFont(PDType1Font.HELVETICA);
		text.setFontSize(22);
		text.setCoordinateLowerLeftX(735f - (text.getFont().getStringWidth(text.getText()) / 1000 * text
				.getFontSize()));
		text.setCoordinateLowerLeftY((float) (538f + 0.8 * text.getFontSize() / 2));

	}

	// Page 2
	float textX = 524f;
	float firstTextY = 206.8f;
	float increaseTextY = 25.4f;
	
	public void setParametersForTrademarkName(String txt) throws IOException {
		text.setText(txt);
		text.setColor(255, 0, 0);
		text.setFont(PDType1Font.HELVETICA);
		text.setFontSize(12);
		text.setCoordinateLowerLeftY(firstTextY);
		text.setCoordinateLowerLeftX(textX);

	}

	public void setParametersForMonitorindEndDate(String txt) throws IOException {
		text.setText("Moitorowany do " + txt);
		text.setColor(255, 0, 0);
		text.setFont(PDType1Font.HELVETICA);
		text.setFontSize(12);
		text.setCoordinateLowerLeftY(firstTextY +  increaseTextY);
		text.setCoordinateLowerLeftX(textX);

	}

	public void setParametersForMonitoringStartDate(String txt) throws IOException {
		text.setText(txt);
		text.setColor(255, 0, 0);
		text.setFont(PDType1Font.HELVETICA);
		text.setFontSize(12);
		text.setCoordinateLowerLeftY(firstTextY + 2 * increaseTextY);
		text.setCoordinateLowerLeftX(textX);

	}

	public void setParametersForMonitoringBase(String txt) throws IOException {
		text.setText(txt);
		text.setColor(255, 0, 0);
		text.setFont(PDType1Font.HELVETICA);
		text.setFontSize(12);
		text.setCoordinateLowerLeftY(firstTextY + 3 * increaseTextY);
		text.setCoordinateLowerLeftX(textX);

	}

	public void setParametersForMonitoringClass(String txt) throws IOException {
		text.setText(txt);
		text.setColor(255, 0, 0);
		text.setFont(PDType1Font.HELVETICA);
		text.setFontSize(12);
		text.setCoordinateLowerLeftY(firstTextY + 4 * increaseTextY);
		text.setCoordinateLowerLeftX(textX);

	}

	public void setParametersForNumberAnalyzedTrademark(String txt) throws IOException {
		text.setText(txt);
		text.setColor(255, 0, 0);
		text.setFont(PDType1Font.HELVETICA);
		text.setFontSize(12);
		text.setCoordinateLowerLeftY((float) (494.8f + 0.8 * text.getFontSize() / 2));
		text.setCoordinateLowerLeftX(156.2f - (text.getFont().getStringWidth(text.getText()) / 1000 * text
				.getFontSize()) / 2);

	}

	public void setParametersForNumberOfSimilarTrademark(String txt) throws IOException {
		text.setText(txt);
		text.setColor(255, 0, 0);
		text.setFont(PDType1Font.HELVETICA);
		text.setFontSize(12);
		text.setCoordinateLowerLeftY((float) (494.8f + 0.8 * text.getFontSize() / 2));
		text.setCoordinateLowerLeftX(409.5f - (text.getFont().getStringWidth(text.getText()) / 1000 * text
				.getFontSize()) / 2);

	}

	public void setParametersForNumberOfConflictsTrademark(String txt) throws IOException {
		text.setText(txt);
		text.setColor(255, 0, 0);
		text.setFont(PDType1Font.HELVETICA);
		text.setFontSize(12);
		text.setCoordinateLowerLeftY((float) (494.8f + 0.8 * text.getFontSize() / 2));
		text.setCoordinateLowerLeftX(662.8f - (text.getFont().getStringWidth(text.getText()) / 1000 * text
				.getFontSize()) / 2);

	}

	public void setParametersForTrademarkNameBelowImage(String txt, float ImageX, float ImageY,
			float imageHeight) throws IOException {
		text.setText(txt);
		text.setColor(255, 0, 0);
		text.setFont(PDType1Font.HELVETICA);
		text.setFontSize(12);
		text.setCoordinateLowerLeftX(ImageX
				- (text.getFont().getStringWidth(text.getText()) / 1000 * text.getFontSize()) / 2);
		text.setCoordinateLowerLeftY(ImageY + (imageHeight / 2) + 22f);
	}
}
