
public class CountingValleys 
{
	public static int countingValleys(int n, String s) 
	{
		s = s.toUpperCase();
		int count = 0;
		int sealevel = 0;
		int descendCount = 0;
		if(s.isEmpty() && n ==0)
			return 0;
		if(!s.matches("[UD]*"))
			return 0;
		for(int i = 0; i < s.length(); i++)
		{
			if(sealevel == -1 && s.charAt(i) == 'U')
				count++;
			if(s.charAt(i) == 'U')
				sealevel++;
			if(s.charAt(i) == 'D')
				sealevel--;
		}
		return count;
    }
	
	public static void main(String[] args)
	{
		String input = "UDDDUDUU";
		int result = countingValleys(input.length(), input);
		System.out.println(result);
	}
}
