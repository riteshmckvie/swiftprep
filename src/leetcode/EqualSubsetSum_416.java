package leetcode;

public class EqualSubsetSum_416 {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 5, 11, 5 };
		canPartition(arr);
	}

	static boolean canPartition(int[] nums) {
		int length = nums.length;
		int sum = 0;
		if (length == 0)
			return false;
		for (int i = 0; i < length; i++) {
			sum = sum + nums[i];
		}
		if (sum % 2 != 0)	
			return false;

		return isSubsetSum(nums, length, sum/2);
	}
	
	// set[] with sum equal to given sum
	public static boolean isSubsetSum(int set[], int n, int sum) {
		boolean subset[][] = new boolean[sum + 1][n + 1];

		// If sum is 0, then answer is true
		for (int i = 0; i <= n; i++)
			subset[0][i] = true;

		// If sum is not 0 and set is empty,
		// then answer is false
		for (int i = 1; i <= sum; i++)
			subset[i][0] = false;

		// Fill the subset table in bottom
		// up manner
		for (int i = 1; i <= sum; i++) {
			for (int j = 1; j <= n; j++) {
				subset[i][j] = subset[i][j - 1];
				if (i >= set[j - 1])
					subset[i][j] = subset[i][j] || subset[i - set[j - 1]][j - 1];
			}
		}

		return subset[sum][n];
	}
}
