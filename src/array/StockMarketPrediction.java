package array;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.IntStream;

class Result2 {

	/*
	 * Complete the 'predictAnswer' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * following parameters: 1. INTEGER_ARRAY stockData 2. INTEGER_ARRAY queries
	 */

	public static List<Integer> predictAnswer(List<Integer> stockData, List<Integer> queries) {
		// Write your code here
		List<Integer> predictAnsers = new ArrayList<>();
		for (int i = 0; i < queries.size(); i++) {
			int index = queries.get(i) - 1;
			int currDayPrice = stockData.get(index);

			int rightVal = 0;
			int rightGap = 0;
			for (int j = index + 1; j < stockData.size(); j++) {
				if (currDayPrice > stockData.get(j)) {
					rightVal = j;
					rightGap = j - index;
					break;
				}
			}

			int leftVal = 0;
			int leftGap = 0;
			if (index > 0) {
				for (int k = index - 1; k >= 0; k--) {
					if (currDayPrice > stockData.get(k)) {
						leftVal = k;
						leftGap = index - k;
						break;
					}
				}
			}

			if (leftGap == 0 && rightGap == 0) {
				predictAnsers.add(-1);
			} else if (leftVal == 0 && rightVal != 0) {
				predictAnsers.add(rightVal + 1);
			} else if (leftGap == rightGap) {
				predictAnsers.add(leftVal + 1);
			} else if (leftGap > rightGap && rightGap != 0) {
				predictAnsers.add(rightVal + 1);
			} else if (leftGap < rightGap) {
				predictAnsers.add(leftVal + 1);
			} else if (leftGap > rightGap && rightGap == 0) {
				predictAnsers.add(leftVal + 1);
			}
		}
		return predictAnsers;
	}

	public static List<Integer> predictAnswer1(List<Integer> stockData, List<Integer> queries) {
		List<Integer> predictAnsers = new ArrayList<>();
		TreeMap<Integer, String> dayValMap = new TreeMap<Integer, String>();

		for (int i = 0; i < stockData.size(); i++) {
			String val = Integer.toString(i+1);
			if (dayValMap.get(stockData.get(i)) != null) {
				dayValMap.put(stockData.get(i), dayValMap.get(stockData.get(i)).concat("," + val));
			} else {
				dayValMap.put(stockData.get(i), val);
			}
		}

		for (int i = 0; i < queries.size(); i++) {
			int index = queries.get(i) - 1;
			int currDayPrice = stockData.get(index);
			Integer lowerKey = dayValMap.lowerKey(currDayPrice);
			if (lowerKey == null) {
				predictAnsers.add(-1);
				continue;
			}
			String lowVal = dayValMap.get(lowerKey);
			if (!lowVal.contains(",")) {
				predictAnsers.add(Integer.valueOf(lowVal));
				continue;
			}
			String[] valArray = lowVal.split(",");
			predictAnsers.add(Integer.valueOf(valArray[0]));

		}
		return predictAnsers;
	}

}

public class StockMarketPrediction {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int stockDataCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> stockData = IntStream.range(0, stockDataCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		List<Integer> result = Result2.predictAnswer(stockData, queries);
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		bufferedWriter.write(result.stream().map(Object::toString).collect(joining("\n")) + "\n");

		bufferedReader.close();
		bufferedWriter.close();
	}
}
