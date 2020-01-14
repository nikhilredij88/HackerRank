import java.util.Arrays;

public class RepeatedStrings 
{
	static int getCharCount(char char1, char[] arr)
	{
		int count = 0;
		for(int j = 0; j < arr.length; j++)
		{
			if(arr[j] == char1)
				count++;
		}
		return count;
	}

	static long repeatedString(String s, long n) 
	{
		String str = s;
		if(n == 0 || s.length() == 0)
			return 0;
		if(!str.contains("a"))
			return 0;
		if(str.matches("[a]*"))
			return n;
		long charCount = 0;
		if(s.length() >= n)
		{
			str = str.substring(0, (int)n);
			char[] arr = str.toCharArray();
			Arrays.sort(arr);
			charCount = getCharCount('a', arr);
		}
		else
		{
			char[] arr = str.toCharArray();
			Arrays.sort(arr);
			charCount = getCharCount('a', arr);
			System.out.println(charCount);
			charCount = charCount * (n / s.length());
			System.out.println(charCount);
			long extraChar = n % s.length();
			charCount = charCount + getCharCount('a', str.substring(0, (int) extraChar).toCharArray());
		}
		return charCount;
	}

	public static void main(String[] args)
	{
		String str = "epsxyyflvrrrxzvnoenvpegvuonodjoxfwdmcvwctmekpsnamchznsoxaklzjgrqruyzavshfbmuhdwwmpbkwcuomqhiyvuztwvq";
		long num = Long.parseLong("549382313570");
		String str1 = "aba";
		long num1 = 10;
		long result = repeatedString(str, num);
		//long result = repeatedString(str1, num1);
		System.out.println(result);
	}
}
