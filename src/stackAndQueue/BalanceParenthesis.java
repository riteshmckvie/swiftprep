package stackAndQueue;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class BalanceParenthesis {

	static String isBalanced(String s) {
		Stack<Character> stk = new Stack<Character>();

		char[] key = s.toCharArray();
		for (int i = 0; i < key.length; i++) {
			if (key[i] == '(')
				stk.push(')');
			if (key[i] == '[')
				stk.push(']');
			if (key[i] == '{')
				stk.push('}');

			if (key[i] == '}' || key[i] == ')' || key[i] == ']') {
				if (stk.peek() == key[i])
					stk.pop();
				else
					return "NO";
			}
		}
		if (stk.empty())
			return "YES";
		else
			return "NO";

	}
	
	public void test() {
		
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//		int t = scanner.nextInt();
//		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//		for (int tItr = 0; tItr < t; tItr++) {
//			String s = scanner.nextLine();
//
//			String result = isBalanced(s);
//
//			bufferedWriter.write(result);
//			bufferedWriter.newLine();
//		}
//
//		bufferedWriter.close();
//
//		scanner.close();
		String result = isBalanced("{(([])[])[]]}");
		System.out.println(result);
	}
}
