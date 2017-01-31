package myProject;

public class WypiszTablice {

	
	void wypiszTablice(int[][] a)
	
	{
		for (int i=0; i<a.length ; i++)
		{
			System.out.println("");
			for(int j=0; j<a[i].length; j++)
			{
				System.out.print(a[i][j] + ", ");
			}
		}
	}


}
