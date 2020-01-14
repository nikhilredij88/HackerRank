package Arrays;

public class LeftRotation 
{
	static int[] rotLeft(int[] a, int d) 
	{
		if(d == 0 || a.length == 0 || d == a.length)
			return a;
		int[] output = new int[a.length];
		int start = 0;
		if(d < a.length)
		{
			start = d;
		}
		else if(d > a.length)
		{
			start = d % a.length;
			if(start == 0)
				return a;				
		}
		for(int i = 0; i < output.length; i++)
		{
			output[i] = a[start];
			start++;
			if(start == output.length)
				start = 0;
		}
		return output;
    }
	
	public static void main(String[] args)
	{
		int rotations = 4;
		int[] arr = {1,2,3,4,5};
		int[] output = rotLeft(arr, rotations);
		for(int i : output)
		{
			System.out.print(i + " ");
		}
	}
}
