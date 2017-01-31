package myProject;

public class MaxNumber {

	double	max;
	
	double max(double...n)
	{
				
		for(int i =0; i<n.length; i++)
		{
			if (i == 0) max = n[i];
			if (n[i]>max) max = n[i];
			
		}
		return max;
		
	}
}
