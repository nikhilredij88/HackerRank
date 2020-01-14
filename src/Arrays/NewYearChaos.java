package Arrays;

import java.util.Arrays;
import java.util.HashMap;

public class NewYearChaos 
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

	static void minimumBribes(int[] q) 
	{
		if(q.length == 0)
			System.out.println(0);
		for(int i =0; i < q.length; i++)
		{
			if(q[i] - (i+1) > 2)
			{
				System.out.println("Too chaotic");
				return;
			}
		}
		int swapCount = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i : q)
		{
			map.put(i, 0);
		}
		int[] temparr = new int[q.length];
		System.arraycopy(q, 0, temparr, 0, q.length);
		Arrays.sort(temparr);

		boolean breakflag = false;
		for(int j = 0; j < q.length; j++)
		{
			for(int i = 0; i < q.length - 1; i++)
			{
				if(q[i] > q[i+1] && q[i] != i + 1 && q[i] > i && map.get(q[i]) < 2 && map.get(q[i+1]) < 2)
				{
					int temp = map.get(q[i]) + 1;
					map.put(q[i], temp);
					q = swap(q, i, i+1);
					swapCount++;
				}
				if(Arrays.equals(q, temparr))
				{
					breakflag = true;
					break;
				}
			}
			if(breakflag)
				break;
		}
		System.out.println(swapCount);
	}

	public static void main(String[] args)
	{

		//int[] arr = {5,1,2,3,7,8,6,4};
		int[] arr = {1,2,5,3,7,8,6,4};
		//int[] arr = {2,1,5,3,4};
		//int[] arr = {2,5,1,3,4};

		//printarray(arr);
		minimumBribes(arr);
	}
}
