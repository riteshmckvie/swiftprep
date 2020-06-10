package dp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MaxSubsetSum {

	// Complete the maxSubsetSum function below.
	static int maxSubsetSum(int[] arr) {

		int n = arr.length;

		// base case
		if (n == 1) {
			return arr[0];
		}

		// create an auxiliary array to store solution of sub-problems
		int[] lookup = new int[n];

		// lookup[i] stores the maximum sum possible till index i

		// trivial case
		lookup[0] = arr[0];
		lookup[1] = Math.max(arr[0], arr[1]);

		// traverse array from index 2
		for (int i = 2; i < n; i++) {
			// lookup[i] stores the maximum sum we get by

			// 1. excluding current element & take maximum sum till index i-1
			// 2. including current element A[i] and take maximum sum till index i-2
			lookup[i] = Math.max(lookup[i - 1], lookup[i - 2] + arr[i]);

			// if current element is more than max sum till current element
			lookup[i] = Math.max(lookup[i], arr[i]);
		}

		// return maximum sum
		return lookup[n - 1];
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int res = maxSubsetSum(arr);

		bufferedWriter.write(String.valueOf(res));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
