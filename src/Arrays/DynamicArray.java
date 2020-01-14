package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicArray 
{
    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) 
    {
    	int lastAnswer = 0;
    	List<List<Integer>> seqlist = new ArrayList<List<Integer>>();
    	List<Integer> seq1 = new ArrayList<Integer>();
    	List<Integer> seq2 = new ArrayList<Integer>();
    	for(List<Integer> list1 : queries)
    	{
    		int type = list1.get(0);
    		int x = list1.get(1);
    		int y = list1.get(2);
    		int xor = (x | lastAnswer) % n;
    		if(type == 1)
    			seq1.add(y);
    		else if(type == 2)
    			seq2.add(y);
    		System.out.println(x +","+lastAnswer);
    		System.out.println(xor);
    	}
    	return seq1;
    }
	
	public static void main(String[] args)
	{
		List<Integer> list1 = Arrays.asList(1,0,5);
		List<Integer> list2 = Arrays.asList(1,1,7);
		List<Integer> list3 = Arrays.asList(1,0,3);
		List<Integer> list4 = Arrays.asList(2,1,0);
		List<Integer> list5 = Arrays.asList(2,1,1);

		int n = 2;
		List<List<Integer>> queries = new ArrayList<List<Integer>>();
		queries.add(list1);
		queries.add(list2);
		queries.add(list3);
		queries.add(list4);
		queries.add(list5);

		List<Integer> output = dynamicArray(n, queries);
		for(int i : output)
		{
			System.out.print(i + " ");
		}

	}
}
