package Strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class Point {
	public char key;
	public long count;

	public Point(char x, long y) {
		key = x;
		count = y;
	}
}

public class SpecialStringAgain 
{
	static long substrCount1(int n, String s) 
	{
		s = s + " ";
		ArrayList<Point> l = new ArrayList<Point>();
		long count = 1;
		char ch = s.charAt(0);
		for(int i = 1; i <= n ; i++) 
		{
			if(ch == s.charAt(i))
				count++;
			else 
			{
				l.add(new Point(ch, count));
				count = 1;
				ch = s.charAt(i);
			}
		}
		count = 0;
		if(l.size() >= 3) 
		{   
			Iterator<Point> itr = l.iterator();
			Point prev, curr, next;
			curr = (Point)itr.next();
			next = (Point)itr.next();
			count = (curr.count * (curr.count + 1)) / 2;
			for(int i = 1; i < l.size() - 1; i++) 
			{
				prev = curr;
				curr = next;
				next = itr.next();
				count += (curr.count * (curr.count + 1)) / 2;
				if(prev.key == next.key && curr.count == 1)
					count += prev.count > next.count ? next.count : prev.count;
			}
			count += (next.count * (next.count + 1)) / 2;
		} 
		else 
		{
			for(Point curr:l)
			{
				count += (curr.count * (curr.count + 1)) / 2;
			}
		}
		return count;
	}

	static long substrCount2(int length, String s) {
		long counter = 0;
		for (int i = 0; i < length; i++) 
		{
			// if the current symbol is in the middle of palindrome, e.g. aba
			int offset = 1;
			while (i - offset >= 0 && i + offset < length && s.charAt(i - offset) == s.charAt(i - 1) && s.charAt(i + offset) == s.charAt(i - 1))
			{
				System.out.println(i+","+offset);
				System.out.println(s.charAt(i - offset));
				System.out.println(s.charAt(i + offset));
				System.out.println(s.charAt(i - 1));
				counter++;
				offset++;
			}
			// if this is repeatable characters aa
			int repeats = 0;
			while (i + 1 < length && s.charAt(i) == s.charAt(i + 1)) 
			{
				System.out.println(s.charAt(i));
				System.out.println(s.charAt(i + 1));
				repeats++;
				i++;
			}
			counter += repeats * (repeats + 1) / 2;
		}
		return counter + length;
	}


	static boolean isSpecial(String str)
	{
		char firstChar = str.charAt(0);
		if(str.matches("["+firstChar+"]*"))
			return true;
		return false;
	}

	static long substrCount(int n, String s) 
	{
		//Special if All of the characters are the same, e.g. aaa.
		//Special if All characters except the middle one are the same, e.g. aadaa
		if(s.isEmpty() || s == null || n == 0 || n != s.length())
			return 0;

		if(isSpecial(s))
			return n*(n+1)/2;

		Set<String> set = new HashSet<String>();
		
		long splStrCount = 0;
		splStrCount += n;
		
		for(int i = 2; i <= n; i ++)
		{
			for(int j = 0; j < i; j ++)
			{
				String temp = s.substring(j, i);
				if(temp.length() != 1 && temp.charAt(0) == temp.charAt(temp.length()-1))
				{
					if(!set.contains(temp))
					{
						if(temp.length() % 2 == 1)
						{
							int half = (temp.length() / 2) + 1;
							String firstHalf = temp.substring(0, half - 1);
							String secondHalf = temp.substring(half, temp.length());
//							System.out.println(temp);
//							System.out.println(firstHalf);
//							System.out.println(secondHalf);
							if(firstHalf.equals(secondHalf) && (set.contains(firstHalf) ||  isSpecial(firstHalf)))
							{
								set.add(temp);
								set.add(firstHalf);
								splStrCount++;
								//System.out.println(temp);
							}
						}
						else if(isSpecial(temp))
						{
							set.add(temp);
							splStrCount++;
							//System.out.println(temp);
						}
					}
					else
					{
						splStrCount++;
					}
				}
			}
		}
		return splStrCount;
	}

	public static void main(String[] args) 
	{
		String str = "aasaasd";
		long output = substrCount2(str.length(), str.toLowerCase()); 
		System.out.println(output);

	}
}
