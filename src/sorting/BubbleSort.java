package sorting;

import java.util.Scanner;

public class BubbleSort {

	private static void swap(int a[], int element1, int element2) {
		int temp = a[element1];
		a[element1] = a[element2];
		a[element2] = temp;
	}

	static void countSwaps(int[] a) {
		int totalSwaps = 0;
		int n = a.length;
		for (int i = 0; i < n; i++) {

			int numberOfSwaps = 0;

			for (int j = 0; j < n - 1; j++) {
				if (a[j] > a[j + 1]) {
					swap(a, j, j + 1);
					numberOfSwaps++;
				}
			}

			totalSwaps += numberOfSwaps;

			if (numberOfSwaps == 0) {
				break;
			}
		}
		System.out.println("Array is sorted in " + totalSwaps + " swaps.");

		System.out.println("First Element: " + a[0]);
		System.out.println("Last Element: " + a[n - 1]);

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] a = new int[n];

		String[] aItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int aItem = Integer.parseInt(aItems[i]);
			a[i] = aItem;
		}

		countSwaps(a);

		scanner.close();
	}
}
