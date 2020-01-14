package d11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class test1 
{
	static void add(int a, int b)
	{
		int x = a;
		int y = b;
		while(x != y)
		{
			if(x > y)
				x = x-y;
			if(y > x)
				y = y-x;
			System.out.println(x+","+y);
		}
	}

	static boolean isAnagram(String s1, String s2)
	{
		if(s1.equals(s2))
			return true;
		if(s1.length() != s2.length())
			return false;

		char[] arr1 = s1.toCharArray();
		Arrays.sort(arr1);
		char[] arr2 = s2.toCharArray();
		Arrays.sort(arr2);

		for(int i = 0; i < arr1.length; i++)
		{
			if(arr1[i] != arr2[i])
				return false;
		}
		return true;	
	}

	public static List<String> funWithAnagrams(List<String> text)
	{
		List<String> text1 = new ArrayList<String>();
		String[] arr1 = text.toArray(new String[0]);
		for(int i = 1; i < text.size(); i ++)
		{
			for(int j = i; j < text.size(); j++)
			{
			if(isAnagram(text.get(j), text.get(i-1)))
			{
				arr1[j] = null;
			}
			}
		}
		
		for(String i : arr1)
		{
			if(i != null)
			text1.add(i);
		}
		Collections.sort(text1);
		return text1;
	}

	public static void main(String[] args)
	{
		//add(2437, 875);
		List<String> list = new ArrayList<String>();
		list.add("code");
		list.add("aaagmnrs");
		list.add("anagrams");
		list.add("doce");


		List<String> list1 = new ArrayList<String>();
		list1.add("code");
		list1.add("doce");
		list1.add("ecod");
		list1.add("framer");
		list1.add("frame");

		List<String> output = funWithAnagrams(list);
		System.out.println(output);

	}
}
