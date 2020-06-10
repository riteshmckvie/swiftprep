package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AirportPassg {

	static List<List<Integer>> mat;

	public AirportPassg() {
		mat = new ArrayList<>();
		List<Integer> row1 = Arrays.asList(0, 1, -1);
		List<Integer> row2 = Arrays.asList(1, 0, -1);
		List<Integer> row3 = Arrays.asList(1, 1, 1);
		mat.add(row1);
		mat.add(row2);
		mat.add(row3);
	}

	int countPass(List<List<Integer>> mat) {
		int count = 0;
		int rowSize = mat.size();
		int colSize = mat.get(0).size();

		if (mat.get(rowSize - 1).get(colSize - 1) == -1 || mat.get(0).get(0) == -1)
			return count;
		int i = 0, j = 0;
		if (mat.get(i).get(j) == 0) {
			j++;
			while (i < rowSize && j < colSize && i >= 0 && j >= 0) {
				if (mat.get(i).get(j) == 1) {
					mat.get(i).set(j, 0);
					count++;
					j++;
				} else if (mat.get(i).get(j) == -1) {
					i++;
					j--;
				} else if (mat.get(i).get(j) == 0) {
					if (i + 1 < rowSize) {
						i++;
						continue;
					}
					if (j + 1 < colSize) {
						j++;
					}
				}
			}
			i = rowSize - 1;
			j = colSize - 1;
			while (i >= 0 && j >= 0 && i < rowSize && j < colSize) {
				if (mat.get(i).get(j) == 1) {
					mat.get(i).set(j, 0);
					count++;
					if (j - 1 >= 0) {
						j--;
					}
				} else if (mat.get(i).get(j) == -1) {
					i--;
					j++;
				} else if (mat.get(i).get(j) == 0) {
					if (j - 1 >= 0) {
						j--;
					} else if (i - 1 >= 0) {
						i--;
					}
				}
				if (i == 0 && j == 0)
					break;
			}
		}

		return count;

	}

	public static void main(String[] args) {
		AirportPassg airportPassg = new AirportPassg();
		System.out.println(airportPassg.countPass(mat));
	}

}
