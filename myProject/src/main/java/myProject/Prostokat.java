package myProject;

public class Prostokat 
{

	double poleProstokata;
	
	public double poleProstokata(double a, double b)
	{
		poleProstokata = a*b;
		return poleProstokata;
	}

	public void komunikatProstokat()
	{
		System.out.println("Pole prostokata wynosi: " + poleProstokata);
		
	}

}
