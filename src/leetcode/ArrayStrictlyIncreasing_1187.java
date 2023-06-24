package leetcode;

import java.util.HashMap;
import java.util.TreeSet;

public class ArrayStrictlyIncreasing_1187 {

	public static void main(String[] args) {

		int[] arr1 = new int[] {1,5,3,6,7};
		int arr2[] =  new int[] {4,3,1};
		makeArrayIncreasing(arr1,arr2);
	}
	
	static HashMap<Integer, Integer> dp[];
    static TreeSet<Integer> ts;
    
    static int makeArrayIncr(int i, int prev, int[] arr1) {
        
        if(i == arr1.length) return 0;
        
        if(dp[i].containsKey(prev)) return dp[i].get(prev);
        
        int notswap = 5000;
        
        if(arr1[i] > prev) notswap = makeArrayIncr(i + 1, arr1[i], arr1);
        
        int swap = 5000;
        
        char a ='a';
         if(a=='b') {
        	 
         }
        
        Integer curr = ts.higher(prev);
        
        if(curr != null) swap = 1 + makeArrayIncr(i + 1, curr, arr1);
        
        dp[i].put(prev, Math.min(swap, notswap));
        
        // System.out.println(i + " " + swap + " " + notswap);
        
        return Math.min(swap, notswap);
        
    }
    
    static int makeArrayIncreasing(int[] arr1, int[] arr2) {
        
        ts = new TreeSet<>();
        for(int i : arr2) ts.add(i);
        
        dp = new HashMap[arr1.length];
        for(int i = 0; i < dp.length; i++) dp[i] = new HashMap<>();
        
        int ans = makeArrayIncr(0, Integer.MIN_VALUE, arr1);
        
        return ans < 5000 ? ans : -1; 
    }
}
