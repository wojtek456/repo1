package myProject;

public class MinNumber {

	double	min;
	
	double min(double...n)
	{
				
		for(int i =0; i<n.length; i++)
		{
			if (i == 0) min = n[i];
			
			if (n[i]<min) min = n[i];
			
		}
		return min;
	
	
	}
}
