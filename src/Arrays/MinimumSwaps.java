package Arrays;

import java.util.Arrays;

public class MinimumSwaps 
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

	static int[] swap(int[] arr, int a, int b)
	{
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
		return arr;
	}

	static int minimumSwaps(int[] arr)
	{
		int swapCount = 0;

		int[] temparr = new int[arr.length];
		System.arraycopy(arr, 0, temparr, 0, arr.length);
		Arrays.sort(temparr);


		int i = 0;
		while(!Arrays.equals(arr, temparr))
		{
			if(arr[i] == i+1)
			{
				i++;
			}
			else
			{
				int tempPosition = arr[i] - 1;
				swap(arr, tempPosition, i);
				swapCount++;
				if(arr[i] == i+1)
					i++;
				printarray(arr);
			}
		}
		return swapCount;

	}

	public static void main(String[] args)
	{

		//int[] arr = {5,1,2,3,7,8,6,4};
		int[] arr = {1,3,5,2,4,6,7};
		//int[] arr = {4,3,1,2};
		//int[] arr = {2,5,1,3,4};

		printarray(arr);
		int output = minimumSwaps(arr);
		System.out.println(output);

	}
}
