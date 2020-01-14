import java.util.*;
import java.io.*;

public class SockMerchant 
{
	public static int sockMerchant(int n, int[] ar) 
	{
		if(ar.length != n)
			return 0;
		int count = 0;
		Arrays.sort(ar);
		for(int i = 0; i < ar.length - 1; i++)
		{
			if(ar[i] == ar[i+1])
			{
				i++;
				count++;
			}
		}
		return count;
    }
	
	public static void main(String[] args)
	{
		int[] arr = {1,1,1,2,1,3,2,3};
		int result = sockMerchant(arr.length, arr);
		System.out.println(result);
	}
}
