package PDFCreator;

import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class Image {
	private PDImageXObject image;
	private float coordinateLowerLeftX;
	private float coordinateLowerLeftY;

	public PDImageXObject getImage() {
		return image;
	}

	public void setImage(PDImageXObject image) {
		this.image = image;
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

}