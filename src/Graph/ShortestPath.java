package Graph;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {

	/*
	 * Complete the 'minMoves' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. 2D_INTEGER_ARRAY maze 2. INTEGER x 3. INTEGER y
	 */

	static class Node {
		int row, col;

		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public static int minMoves(List<List<Integer>> maze, int x, int y) {
		// Write your code here
		int row = maze.size();
		int col = maze.get(0).size();
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(0, 0));
		int sum = 0;
		while (!queue.isEmpty()) {
			Node node = queue.peek();
			queue.remove();

			if (node.col + 1 < col && maze.get(node.row).get(node.col + 1) == 2) {
				queue.add(new Node(node.row, node.col + 1));
				sum = sum + 2;
			} else if (node.col + 1 < col && maze.get(node.row).get(node.col + 1) == 0) {
				if (node.row == x && node.row == y) {
					break;
				}
				queue.add(new Node(node.row, node.col + 1));
			}

			if (node.row + 1 < row && maze.get(node.row + 1).get(node.col) == 2) {
				queue.add(new Node(node.row + 1, node.col));
			} else if (node.row + 1 < row && maze.get(node.row + 1).get(node.col) == 0) {
				if (node.row == x && node.row == y) {
					break;
				}
				queue.add(new Node(node.row + 1, node.col));
			}
		}
		return (sum == 0) ? -1 : sum;
	}

	public static int minMoves1(List<List<Integer>> maze, int x, int y) {
		int result = 0;
		int row = maze.size();
		int col = maze.get(0).size();
		// creat 2D matrix to store the sum
		// of the path
		int dp[][] = new int[row][col + 2];

		// initialize all dp matrix as '0'
		for (int[] rows : dp)
			Arrays.fill(rows, 0);

		// copy all element of first column into
		// 'dp' first column
		for (int i = 0; i < row; i++)
			dp[0][i + 1] = maze.get(0).get(i);

		for (int i = 1; i < row; i++)
			for (int j = 1; j <= row; j++)
				if (maze.get(i).get(j - 1) != 1) {
					dp[i][j] = Math.max(dp[i - 1][j - 1], Math.max(dp[i - 1][j], dp[i - 1][j + 1]))
							+ maze.get(i).get(j - 1);
				}

		// Find maximum path sum that end ups
		// at any column of last row 'N-1'
		for (int i = 0; i <= row; i++)
			result = Math.max(result, dp[x][y]);

		// return maximum sum path
		return result == 0 ? -1 : result;
	}

}

public class ShortestPath {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int mazeRows = Integer.parseInt(bufferedReader.readLine().trim());
		int mazeColumns = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<Integer>> maze = new ArrayList<>();

		IntStream.range(0, mazeRows).forEach(i -> {
			try {
				maze.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
						.collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		int x = Integer.parseInt(bufferedReader.readLine().trim());

		int y = Integer.parseInt(bufferedReader.readLine().trim());

		int result = Result.minMoves1(maze, x, y);
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
