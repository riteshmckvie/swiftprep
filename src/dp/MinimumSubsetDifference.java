package dp;

public class MinimumSubsetDifference {

	public static void main(String[] args) {
		int set[] =  {1, 6, 11, 5};
		int sum = 23;//sum of all set numbers
		int n = set.length;
		boolean[][] subsetSum = getSubsetSum(set,n,sum);
		
        int diff = findMinimumSubset(sum, n, subsetSum);
        System.out.println(diff);
	}

	private static int findMinimumSubset(int sum, int n, boolean[][] subsetSum) {
		int diff = Integer.MAX_VALUE;
        for (int j = sum / 2; j >= 0; j--) {
            // Find the
            if (subsetSum[j][n] == true) {
                diff = sum - 2 * j;
                break;
            }
        }
		return diff;
	}
	
	// set[] with sum equal to given sum
	public static boolean[][] getSubsetSum(int set[], int n, int sum) {
		// The value of subset[i][j] will be
		// true if there is a subset of
		// set[0..j-1] with sum equal to i
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

		return subset;
	}
}
