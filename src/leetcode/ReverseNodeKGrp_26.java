package leetcode;

public class ReverseNodeKGrp_26 {

	static class Node {
		int val;
		Node next;

		Node(int value, Node element) {
			this.val = value;
			this.next = element;
		}
	}

	// 1 -> 2 -> 3 -> 4 -> 5 ------ 2 -> 1 -> 4 -> 3 -> 5
	
	public static void main(String[] args) {
		Node hardCoded = new Node(10, new Node(20, new Node(30, new Node(40, new Node(50, null)))));
		hardCoded = reverseKthNode(hardCoded, 3);
		System.out.println(hardCoded);
	}

	static Node reverseKthNode(Node head, int k) {
		Node temp = head;
		for (int i = 0; i < k; i++) {
			if (temp == null) {
				return head;
			}
			temp = temp.next;
		}
		Node sp = reverseKthNode(temp, k);
		Node prev = null;
		Node curr = head;
		for (int i = 0; i < k; i++) {
			Node after = curr.next;
			curr.next = prev;
			prev = curr;
			curr = after;
		}
		head.next = sp;
		return prev;
	}
}
