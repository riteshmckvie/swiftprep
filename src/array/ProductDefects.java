package array;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result4 {
	
/*
5
5
1 1 1 1 1
1 1 1 0 0
1 1 1 0 0
1 1 1 0 0
1 1 1 1 1

1 1 1 1 1
1 2 2 0 0
1 2 3 0 0
1 2 3 0 0
1 2 3 1 1
*/
	/*
	 * Complete the 'largestArea' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts
	 * 2D_INTEGER_ARRAY samples as parameter.
	 */

	public static int minimum(int x, int y, int z) {
		return Integer.min(Integer.min(x, y), z);
	}

	public static int largestArea(List<List<Integer>> samples) {
		int row = samples.size();
		int col = samples.get(0).size();
		int[][] maxSquare = new int[samples.size()][samples.get(0).size()];

		int max = 0;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				maxSquare[i][j] = samples.get(i).get(j);

				if (i > 0 && j > 0 && samples.get(i).get(j) == 1) {

					maxSquare[i][j] = minimum(maxSquare[i][j - 1], maxSquare[i - 1][j], maxSquare[i - 1][j - 1]) + 1;
				}

				if (max < maxSquare[i][j]) {
					max = maxSquare[i][j];
				}
			}
		}
		System.out.println(max);
		return max;

	}
	
}

public class ProductDefects {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int samplesRows = Integer.parseInt(bufferedReader.readLine().trim());
		int samplesColumns = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<Integer>> samples = new ArrayList<>();

		IntStream.range(0, samplesRows).forEach(i -> {
			try {
				samples.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt).collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		int result = Result4.largestArea(samples);

		bufferedReader.close();
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//		bufferedWriter.write(String.valueOf(result));
//		bufferedWriter.newLine();
//
//		bufferedWriter.close();
	}
}
