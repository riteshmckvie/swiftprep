package stackAndQueue;
import java.util.Scanner;
import java.util.Stack;

public class Taleof2Stacks {

	Stack<Integer> stack1;
	Stack<Integer> stack2;

	public Taleof2Stacks() {
		this.stack1 = new Stack<Integer>();
		this.stack2 = new Stack<Integer>();
	}

	public void push(Integer x) {
		stack1.push(x);
	}

	public void pop() {

		if (stack2.empty()) {
			while (!stack1.empty()) {
				stack2.push(stack1.pop());
			}
		}

		stack2.pop();
	}

	public Object peek() {

		Object peek;

		if (stack2.empty()) {
			while (!stack1.empty()) {
				stack2.push(stack1.pop());
			}
		}

		return stack2.peek();
	}

	public static void main(String[] args) {
		Taleof2Stacks queue = new Taleof2Stacks();

		Scanner scanner = new Scanner(System.in);
		int q = scanner.nextInt();

		for (int i = 0; i < q; i++) {
			int queryType = scanner.nextInt();

			if (queryType == 1) {
				int x = scanner.nextInt();
				queue.push(x);
			}

			else if (queryType == 2) {
				queue.pop();
			}

			else {
				System.out.println(queue.peek());
			}
		}

		scanner.close();
	}
}
