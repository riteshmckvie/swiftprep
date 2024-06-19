package dp;

public class PlusMinusTargetSum {

	public static void main(String[] args) {
		int n = 5;
	    //Integer[] arr = { 1,1,1,1,1 };
	    Integer[] arr = { 1,0 };

	    int diff = 3;
	    
	    int anotherSubsetSum = getAnotherSubsetSum(diff,arr);
        if(n == 0) System.out.println(n);
        if(n == 1 && diff == 0) System.out.println(0);
        if(n == 1 && n != diff) System.out.println(0);

        if(n == 1 && diff == n) System.out.println(n);
	    System.out.println(CountTotalSubsetSum.perfectSum(arr, n, anotherSubsetSum));
	}
	
	static int getAnotherSubsetSum(int diff,Integer[] arr) {
		
		int setSum = 0;
		int anotherSubsetSum = 0;
	    for(int i=0;i<arr.length;i++) {
	    	setSum = arr[i].intValue() + setSum;
	    }
	    anotherSubsetSum = (setSum - diff) / 2;
		return anotherSubsetSum;
	}


}
