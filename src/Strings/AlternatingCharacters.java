package Strings;

import java.util.ArrayList;
import java.util.List;

public class AlternatingCharacters 
{
	private static void altChar(List<String> slist) 
	{
		int cnt = Integer.parseInt(slist.get(0));
		if(slist.size() != cnt + 1)
			return;
		for(int i = 1;i<slist.size();i++)
		{
			String str = slist.get(i);
			if(str.isEmpty() || str == null)
				System.out.println(0);
			if(str.toUpperCase().matches("[A,B]*"))
			{
				int count = 0;
				for(int j = 0; j<str.length()-1; j++)
				{
					if(str.charAt(j) == str.charAt(j+1))
					{
						count++;
					}
				}
				System.out.println(count);
			}
		}
	}

	public static void main(String[] args) 
	{
		List<String> list = new ArrayList<String>();
		list.add("5");
		list.add("AAAA");
		list.add("BBBBB");
		list.add("ABABABAB");
		list.add("BABABA");
		list.add("AAABBB");

		altChar(list);
	}
}
