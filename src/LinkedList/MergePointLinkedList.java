package LinkedList;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class MergePointLinkedList {

	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}

	static class SinglyLinkedList {
		public SinglyLinkedListNode head;
		public SinglyLinkedListNode tail;

		public SinglyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodeData) {
			SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

			if (this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
			}

			this.tail = node;
		}
	}

	public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter)
			throws IOException {
		while (node != null) {
			bufferedWriter.write(String.valueOf(node.data));

			node = node.next;

			if (node != null) {
				bufferedWriter.write(sep);
			}
		}
	}

	// Complete the findMergeNode function below.

	/*
	 * For your reference:
	 *
	 * SinglyLinkedListNode { int data; SinglyLinkedListNode next; }
	 *
	 */
	static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
		SinglyLinkedListNode currentA = head1;
		SinglyLinkedListNode currentB = head2;

		// Do till the two nodes are the same
		while (currentA != currentB) {
			// If you reached the end of one list start at the beginning of the other one
			// currentA
			if (currentA.next == null) {
				currentA = head2;
			} else {
				currentA = currentA.next;
			}
			// currentB
			if (currentB.next == null) {
				currentB = head1;
			} else {
				currentB = currentB.next;
			}
		}
		return currentB.data;

	}

}
