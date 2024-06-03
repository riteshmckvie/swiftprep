package greedy;

public class KnapsackTopDown {

	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	static int knapSack(int W, int wt[], int val[], int n) {
		int i, j;
		int K[][] = new int[n + 1][W + 1];

		for (i = 0; i <= n; i++) {
			for (j = 0; j <= W; j++) {
				if (i == 0 || j == 0)
					K[i][j] = 0;
				else if (wt[i - 1] <= j)
					K[i][j] = max(val[i - 1] + K[i - 1][j - wt[i - 1]], K[i - 1][j]);
				else
					K[i][j] = K[i - 1][j];
			}
		}

		return K[n][W];
	}

	public static void main(String args[]) {
		int val[] = new int[] { 60, 100, 120 };
		int wt[] = new int[] { 10, 20, 30 };
		int W = 50;
		int n = val.length;
		System.out.println(knapSack(W, wt, val, n));
	}
}
