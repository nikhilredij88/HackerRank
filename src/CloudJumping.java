
public class CloudJumping 
{
    static int jumpingOnClouds(int[] c) 
    {
    	if(c.length == 0)
    		return 0;
    	int jumpCount = 0;
    	int i = 0;
    	while(i < c.length)
    	{
    		if(i+2 <= c.length-1 && c[i+2] == 0 )
    		{
    			jumpCount++;
    			i = i + 2;
    		}
    		else if(c[i+1] == 0)
    		{
    			jumpCount++;
    			i++;
    		}
    		if(i >= c.length-1)
    			i++;
    	}
    	return jumpCount;
    }
	
	public static void main(String[] args)
	{
		int[] arr = {0,0,0,1,0,0};
		int result = jumpingOnClouds(arr);
		System.out.println(result);
	}
}
