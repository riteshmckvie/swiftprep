package dp;

public class CountSubsetWithDifference {

	public static void main(String[] args) {
		int n = 5;
	    Integer[] arr = { 1, 2, 3, 1, 2 };
	    int diff = 1;
	    int anotherSubsetSum = getAnotherSubsetSum(diff,arr);
	    
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
