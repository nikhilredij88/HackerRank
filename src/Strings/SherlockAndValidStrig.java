package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;


public class SherlockAndValidStrig 
{
	static String isValid(String s) 
	{
		if(s.isEmpty())
			return "YES";
		if(s == null)
			return "NO";

		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		for(char c : arr)
		{
			if(!map.containsKey(c))
				map.put(c, 1);
			else
				map.put(c, (map.get(c) + 1));
		}

		HashMap<Integer, Integer> mapCount = new HashMap<Integer, Integer>();
		for(Integer e : map.values())
		{
			if(!mapCount.containsKey(e))
				mapCount.put(e, 1);
			else
				mapCount.put(e, (mapCount.get(e) + 1));
		}

		if(mapCount.size() > 2)
			return "NO";
		if(mapCount.size() == 2 && (int)mapCount.values().toArray()[0] > 1 && (int)mapCount.values().toArray()[1] > 1)
			return "NO";
		return "YES";
	}

	public static void main(String[] args)
	{
		String str = "abbbccc";//aaaaabc ??,abbbccc,abcdefghhgfedecba
		String output = isValid(str);
		System.out.println(output);
	}
}
