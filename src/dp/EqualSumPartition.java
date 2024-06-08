package dp;

public class EqualSumPartition {

	public static void main(String[] args) {
		int set[] = { 1,3,5,1,0 };
		int sum = 6;
		int n = set.length;
		int totalSetSum = 0;
		for(int i = 0; i < set.length ; i++) {
			totalSetSum = +set[i];
		}
		if(totalSetSum % 2 != 0) {
			System.out.println("No EqualSumPartition with" + " given sum");
			return;
		}
		if (SubsetSum.isSubsetSum(set, n, sum) == true)
			System.out.println("Found a EqualSumPartition" + " with given sum");
		else
			System.out.println("No subset with" + " given sum");
	}

}
