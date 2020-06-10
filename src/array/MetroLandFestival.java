package array;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

class Result1 {

	/*
	 * Complete the 'minimizeCost' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER_ARRAY numPeople 2. INTEGER_ARRAY x 3. INTEGER_ARRAY y
	 */

	public static int minimizeCost(List<Integer> numPeople, List<Integer> x, List<Integer> y) {
		// Write your code here
		int numPeopleSize = numPeople.size();
		int col = Collections.max(x);
		int row = Collections.max(y);
		int min = Integer.MAX_VALUE;
		
		for (int i = 0 ;i < row ; i++) {
			for (int j = 0 ; j < col ; j++) {
				int sum = 0;
				for (int k = 0; k < numPeopleSize ;k++) {
					sum = sum + (numPeople.get(k))*(Math.abs(x.get(k)-i) + Math.abs(y.get(k)-j));
				}
				min = Math.min(min, sum);
			}
		}
		System.out.println(min);
		return min;
	}

}

public class MetroLandFestival {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int numPeopleCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> numPeople = IntStream.range(0, numPeopleCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		int xCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> x = IntStream.range(0, xCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		int yCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> y = IntStream.range(0, yCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		int result = Result1.minimizeCost(numPeople, x, y);
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
