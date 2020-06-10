package solutions;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

class Result6 {

	/*
	 * Complete the 'stockLounge' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER_ARRAY onHand 2. INTEGER_ARRAY supplier 3. INTEGER
	 * demand
	 */

	public static int stockLounge(List<Integer> onHand, List<Integer> supplier, int demand) {
		// Write your code here
		int onHandMax = Collections.max(onHand);
		int supplierMax = Collections.max(supplier);
		int maxExpiryDays = Integer.max(onHandMax, supplierMax);
		
		int maximumUnitNo = 0;
		for (Integer i = 0 ; i <= maxExpiryDays ; i++) {
			int count = 0;
			while (count < demand) {
				int oldCount = count;
				if(onHand.remove(i)) {
					count++;
				} 
				if (supplier.remove(i)){
					count++;
					maximumUnitNo++;
					continue;
				} 
				if(oldCount == count) {
					break;
				}
			}
		}
		System.out.println(maximumUnitNo);
		return maximumUnitNo > onHand.size() ? maximumUnitNo : -1;
	}

}

public class LoungeStocking {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int onHandCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> onHand = IntStream.range(0, onHandCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		int supplierCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> supplier = IntStream.range(0, supplierCount).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).map(String::trim).map(Integer::parseInt).collect(toList());

		int demand = Integer.parseInt(bufferedReader.readLine().trim());

		int result = Result6.stockLounge(onHand, supplier, demand);

		bufferedReader.close();
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//		bufferedWriter.write(String.valueOf(result));
//		bufferedWriter.newLine();
//
//		bufferedWriter.close();
	}
}
