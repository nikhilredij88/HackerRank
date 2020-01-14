package Arrays;

public class ArrayManipulation 
{
	static void printarray(int[] arr)
	{
		if(arr.length == 0)
			System.out.println(0);
		for(int i : arr)
		{
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	static long arrayManipulation1(int n, int[][] queries) 
	{
		int[] arr = new int[n];
		long max = 0;
		for(int i = 0; i < queries.length; i++)
		{
			int num1 = queries[i][0];
			int num2 = queries[i][1];
			int num3 = queries[i][2];
			arr[num1] += num3;
			if(num2 + 1 < n)
				arr[num2 + 1] -= num3;
			//printarray(arr);
		}
		int temp = 0;
		for(int i : arr)
		{
			temp += i;
			if(temp > max)
				max = temp;
		}
		return max;
	}
	
	
	static long arrayManipulation(int n, int[][] queries) 
	{
		long[] arr = new long[n];
		long max = 0;
		for(int i = 0; i < queries.length; i++)
		{
			long num1 = queries[i][0] - 1;
			long num2 = queries[i][1] - 1;
			long num3 = queries[i][2];
			for(int j = (int)num1; j <= num2; j++)
			{
				arr[j] += num3;
				if(arr[j] > max)
					max = arr[j];
			}
			//printarray(arr);
		}
		return max;
	}

	public static void main(String[] args)
	{

		int[] row1 = {1,2,100};
		int[] row2 = {2,5,100};
		int[] row3 = {3,4,100};
		int n = 5;
		int[][] matrix = {row1, row2, row3};
		long output = arrayManipulation1(n, matrix);
		System.out.println(output);

	}
}
