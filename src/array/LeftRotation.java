package array;

import java.io.IOException;

public class LeftRotation {

	// Complete the rotLeft function below.
	static int[] rotLeft(int[] a, int d) {

		int leng = a.length;
		int[] newArr = new int[leng];
		if (d > leng) {
			d = d % leng;
		}
		int diff = leng - d;
		int j = 0;
		for (int i = 0; i < a.length; i++) {
			int index = diff + i;
			if(index >= a.length ) 
				newArr[j++] = a[i];
			else 
				newArr[diff + i] = a[i];
		}
		return newArr;

	}

	public static void main(String[] args) throws IOException {
		int[] a = {1,2,3,4,5};
		int d = 101;
		int[] result = rotLeft(a, d);
		System.out.println(result);
	}
}
