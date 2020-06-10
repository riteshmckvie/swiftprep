package solutions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


class Result {

	
	/*
	 * Problem Statement : In a given array, We need to delete one element such that
	 * the sum of even index will be equal to the sum of odd index.
	 */
	
    /*
     * Complete the 'countBalancingElements' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int countBalancingElements(List<Integer> arr) {
    // Write your code here
    	arr.add(2);arr.add(1);arr.add(6);arr.add(4);
    	
    	int n = arr.size();
        long[] left = new long[n];
        long[] right = new long[n];
        
        left[0] = arr.get(0);
        
        if(n>1)
            left[1] = arr.get(1);
        
        for(int i=2;i<n;i++)
            left[i] = left[i-2] + arr.get(i);
        
        right[n-1] = arr.get(n-1);
        if(n-2 >= 0)
        right[n-2] = arr.get(n-2);
        
        for(int i=n-3;i>=0;i--)
            right[i] = right[i+2] + arr.get(i);
        
        int count = 0;
        for(int i=0;i<n;i++)
        {
            long l1 = 0, l2 = 0, r1 = 0, r2 = 0;
            
            if(i-2 >= 0)
                l1 = left[i-2];
            
            if(i-1 >= 0)
                l2 = left[i-1];
            
            if(i+1 <n)
                r1 = right[i+1];
            if(i+2 < n)
                r2 = right[i+2];
            
            if(l1 + r1 == l2 + r2)
                count++;
        }
        
        return count;
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
    	List<Integer> arr = new ArrayList<Integer>();
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
//        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
//            try {
//                return bufferedReader.readLine().replaceAll("\\s+$", "");
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        })
//            .map(String::trim)
//            .map(Integer::parseInt)
//            .collect(toList());

        int result = Result.countBalancingElements(arr);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}

