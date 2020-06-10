package array;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Result {

	/*
	 * Complete the 'bioHazard' function below.
	 *
	 * The function is expected to return a LONG_INTEGER. The function accepts
	 * following parameters: 1. INTEGER n 2. INTEGER_ARRAY allergic 3. INTEGER_ARRAY
	 * poisonous
	 */
	static long count = 0;

	public static long bioHazard(int n, List<Integer> allergic, List<Integer> poisonous) {
		// Write your code here
		count = n;
		List<Integer> integerArray = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			integerArray.add(i);
		}
		checkNotProhibited(allergic, poisonous, integerArray);
		for (int j = n - 1; j >= 2; j--) {
			int k = 0;
			while (n - k >= j) {
				List<Integer> subList = integerArray.subList(k, k+j);
				checkNotProhibited(allergic, poisonous, subList);
				k++;
			}
		}
		System.out.println(count);
		return count;
	}

	private static void checkNotProhibited(List<Integer> allergic, List<Integer> poisonous, List<Integer> subList) {
		for(int x  = 0; x < poisonous.size(); x++) {
			if (subList.contains(poisonous.get(x)) && subList.contains(allergic.get(x))) {
				return;
			}
		}
		count++;
	}

}

public class BiologicalHazards {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		int allergicCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> allergic = IntStream.range(0, allergicCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		int poisonousCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> poisonous = IntStream.range(0, poisonousCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		long result = Result.bioHazard(n, allergic, poisonous);

		bufferedReader.close();
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//		bufferedWriter.write(String.valueOf(result));
//		bufferedWriter.newLine();
//
//		bufferedWriter.close();
	}
}
