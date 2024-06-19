package dp;

import java.util.Arrays;
import java.util.Collections;

//only for positive integers
public class CountTotalSubsetSum {

	public static void main(String[] args) {
		Integer a[] = { 2, 3, 1};
		// sort to make the 0 in the last
		Arrays.sort(a, Collections.reverseOrder());
		int sum = 3;
		int n = a.length;
		System.out.println(perfectSum(a, n, sum));

	}

	public static int perfectSum(Integer a[], int n, int sum) {
		if(sum == -1) sum = 1;
		int dp[][] = new int[n + 1][sum + 1];

		// Initializing the first value of matrix
		dp[0][0] = 1;

		for (int i = 1; i <= sum; i++)
			dp[0][i] = 0;
		
		for (int i = 1; i <= n; i++)
			dp[i][0] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {

				// If the value is greater than the sum
				if (a[i - 1] > j)
					dp[i][j] = dp[i - 1][j];

				else {
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - a[i - 1]];
				}
			}
		}

		return dp[n][sum];
	}

}
