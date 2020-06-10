package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

class Result8 {

	/*
	 * Complete the 'palindrome' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts STRING s
	 * as parameter.
	 */

	public static int palindrome(String s) {
		// Write your code here
		TreeMap<String, Integer> strMap = new TreeMap<>();
		int n = s.length();

		int[][] R = new int[2][n + 1];

		s = "@" + s + "#";

		for (int j = 0; j <= 1; j++) {
			int rp = 0;
			R[j][0] = 0;

			int i = 1;
			while (i <= n) {
				while (s.charAt(i - rp - 1) == s.charAt(i + j + rp))
					rp++;
				R[j][i] = rp;
				int k = 1;
				while ((R[j][i - k] != rp - k) && (k < rp)) {
					R[j][i + k] = Math.min(R[j][i - k], rp - k);
					k++;
				}
				rp = Math.max(rp - k, 0);
				i += k;
			}
		}

		s = s.substring(1, s.length() - 1);

		strMap.put(s.substring(0, 1), 1);
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= 1; j++)
				for (int rp = R[j][i]; rp > 0; rp--)
					strMap.put(s.substring(i - rp - 1, i - rp - 1 + 2 * rp + j), 1);
			strMap.put(s.substring(i, i + 1), 1);
		}

		return strMap.size();
	}

}

public class DistinctPalindrome {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = bufferedReader.readLine();

		int result = Result8.palindrome(s);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
