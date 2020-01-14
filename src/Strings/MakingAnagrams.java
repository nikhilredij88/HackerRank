package Strings;

import java.util.Arrays;
import java.util.HashMap;

public class MakingAnagrams 
{
	static int makeAnagram(String a, String b) 
	{
		if(a.equals(b))
			return 0;

		int difference = 0;
		char[] arr1 = a.toCharArray();
		char[] arr2 = b.toCharArray();
		
		HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
		
		String main = "abcdefghijklmnopqrstuvwxyz";
		
		for(char c : main.toCharArray())
		{
			map1.put(c, 0);
			map2.put(c, 0);
		}
		
		for(char c : arr1)
		{
			map1.put(c, (map1.get(c) + 1));
		}
		
		for(char c : arr2)
		{
			map2.put(c, (map2.get(c) + 1));
		}
		
		for(char c : main.toCharArray())
		{
			//System.out.println(c+","+map1.get(c)+","+map2.get(c)+","+Math.abs(map1.get(c) - map2.get(c)));
			difference += Math.abs(map1.get(c) - map2.get(c));
		}
		
		return difference;
	}

	public static void main(String[] args)
	{
		String str1 = "fcrxzwscanmligyxyvym";
		String str2 = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";
		int output = makeAnagram(str1.toLowerCase(), str2.toLowerCase());
		System.out.println(output);
	}
}
