package solutions;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicates extends BinarySearch {
	
	public static void main(String[] args) {
		String s= "abcdeedffyttssyssydes";
		removeDuplicate(s);
	}
	
	public void test() {
		System.out.println("Other");
	}

	private static void removeDuplicate(String s) {
		BinarySearch other = new RemoveDuplicates();
		other.test();
		List<Character> stringCharaSet = new ArrayList<Character>();
		char[] charArray = s.toCharArray();
		for(int i = 0; i < charArray.length ;i++) {
			if (((i+1) < charArray.length) && charArray[i] == charArray[i+1]) {
				i++;
				continue;
			}
			stringCharaSet.add(s.toCharArray()[i]);
		}
		for (Character ele : stringCharaSet) {
			System.out.print(ele);
		}
	}

}

