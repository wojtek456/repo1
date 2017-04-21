package PDFCreator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class ImageBuilder {

	private Image image;
	private List<Float> coordinateImageX;
	private List<Float> coordinateImageY;
	
	public ImageBuilder(String path, PDDocument document) throws IOException {
		image = new Image();
		image.setImage(PDImageXObject.createFromFile(path, document));
		
		}

	public Image getObjectImage() {
		return image;
	}

	public void setParametersForBackgroundImage() {
		image.setCoordinateLowerLeftX(0f);
		image.setCoordinateLowerLeftY(600f);

	}

	public void setParametersForAnalyzedTrademarkImage() {
		image.setCoordinateLowerLeftX(184.5f);
		image.setCoordinateLowerLeftY(240f);

	}
	public void setParametersForStatisticAnaliseImage() {
		image.setCoordinateLowerLeftX(400f);
		image.setCoordinateLowerLeftY(350f);

	}
	public void setParameterForSimilarAndConflictsTrademarkImage(int numberOfElement){
		image.setCoordinateLowerLeftX(coordinateImageX.get(numberOfElement));
		image.setCoordinateLowerLeftY(coordinateImageY.get(numberOfElement));
		
	}
	public void createParameterForSimilarAndConflictsTrademarkImage(){
		coordinateImageX = new ArrayList<Float>();
		coordinateImageY = new ArrayList<Float>();
		float increaseColumnX = 188.5f;
		float firstColumnX = 118.5f;
		float secondColumnX = firstColumnX+increaseColumnX;
		float thirdColumnX = firstColumnX+2*increaseColumnX;
		float fourthColumnX = firstColumnX+3*increaseColumnX;
		coordinateImageX.add(firstColumnX);
		coordinateImageX.add(secondColumnX);
		coordinateImageX.add(thirdColumnX);
		coordinateImageX.add(fourthColumnX);
		coordinateImageX.add(firstColumnX);
		coordinateImageX.add(secondColumnX);
		coordinateImageX.add(thirdColumnX);
		coordinateImageX.add(fourthColumnX);
		coordinateImageX.add(firstColumnX);
		coordinateImageX.add(secondColumnX);
		coordinateImageX.add(thirdColumnX);
		coordinateImageX.add(fourthColumnX);
	
		float increaseRowY = 155.7f;
		float firstRowY = 183f;
		float secondRowY = firstRowY+increaseRowY;
		float thirdRowY = firstRowY+2*increaseRowY;

		
		coordinateImageY.add(firstRowY); 
		coordinateImageY.add(firstRowY);
		coordinateImageY.add(firstRowY);
		coordinateImageY.add(firstRowY);
		coordinateImageY.add(secondRowY);
		coordinateImageY.add(secondRowY);
		coordinateImageY.add(secondRowY);
		coordinateImageY.add(secondRowY);
		coordinateImageY.add(thirdRowY);
		coordinateImageY.add(thirdRowY);
		coordinateImageY.add(thirdRowY);
		coordinateImageY.add(thirdRowY);
	}

}
