package myProject;

public class Kolo 
{

	double  poleKola;
	
	double poleKola(double promien)
	{
		double poleKola = Math.PI*Math.pow(promien, 2);
		return poleKola;
		
	}
		void komunikatKolo ()
	{
		System.out.println("Pole kola wynosi: " + poleKola);
	}


}
