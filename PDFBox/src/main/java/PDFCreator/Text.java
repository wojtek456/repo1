package PDFCreator;

import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class Text {
	private String text;
	private PDFont font;
	private int fontSize;
	private int a, b, c;
	private float coordinateLowerLeftX;
	private float coordinateLowerLeftY;
	private double textRotation;
	
	public void setColor(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;

	}
	public int getColorA(){
		return a;
	}
	public int getColorB(){
		return b;
	}
	public int getColorC(){
		return c;
	}
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public PDFont getFont() {
		return font;
	}

	public void setFont(PDFont font) {
		this.font = font;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public float getCoordinateLowerLeftX() {
		return coordinateLowerLeftX;
	}

	public void setCoordinateLowerLeftX(float coordinateLowerLeftX) {
		this.coordinateLowerLeftX = coordinateLowerLeftX;
	}

	public float getCoordinateLowerLeftY() {
		return coordinateLowerLeftY;
	}

	public void setCoordinateLowerLeftY(float coordinateLowerLeftY) {
		this.coordinateLowerLeftY = coordinateLowerLeftY;
	}

	public double getTextRotation() {
		return textRotation;
	}

	public void setTextRotation(double textRotation) {
		this.textRotation = textRotation;
	}

}
