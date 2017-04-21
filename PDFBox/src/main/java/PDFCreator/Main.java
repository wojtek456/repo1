package PDFCreator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		List<String> listWithSimilarImage = new ArrayList<String>();
		for (int i = 1; i < 50; i++) {
			listWithSimilarImage.add("pic" + i);
		}
		List<String> listWithCollisionImage = new ArrayList<String>();
		 for (int i = 1; i < 50; i++) {
		 listWithCollisionImage.add("pic" + i);
		 }

		PDFConstructor pdf = new PDFConstructor("BULLSTAR", "03.04.2017 - 10.04.2017",
				"14.04.2017", listWithSimilarImage, listWithSimilarImage, listWithCollisionImage,
				listWithCollisionImage);
		pdf.generatePDF("F:/PDFBox/test_sologo.pdf");
		

	}

}
