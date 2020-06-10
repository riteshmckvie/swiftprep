package LinkedList;

import java.io.BufferedWriter;
import java.io.IOException;

public class InsertNode {
	
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

	    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
	        while (node != null) {
	            bufferedWriter.write(String.valueOf(node.data));

	            node = node.next;

	            if (node != null) {
	                bufferedWriter.write(sep);
	            }
	        }
	    }

	  
	    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
	        if(head == null) return head;
	        SinglyLinkedListNode trackedHeadNode = head;
	        
	         SinglyLinkedListNode nodeToInsert = new SinglyLinkedListNode(data);              nodeToInsert.data = data;
	    
	       
	    if (position == 0){nodeToInsert.next = head; return nodeToInsert;}    
	    
	    int currPosition = 0;
	    
	    while (currPosition < position -1 && head.next != null){
	        head = head.next;        
	        currPosition++;       
	    }

	    SinglyLinkedListNode nodeAtPosition = head.next;
	    head.next = nodeToInsert;
	    head = head.next;
	    head.next = nodeAtPosition;
	        
	    return trackedHeadNode;

	    }

}
