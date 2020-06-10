package Tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Lexicographically {

	/*
	 * Complete the 'sExpression' function below.
	 *
	 * The function is expected to return a STRING. The function accepts STRING
	 * nodes as parameter.
	 */

	static StringBuilder strBui = new StringBuilder();
	static String error = null;
	static class Node {
		String data;
		Node left;
		Node right;

		Node(String data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

		Node(String data, Node left) {
			this.data = data;
			this.left = left;
			this.right = null;
		}
	}

	public static String sExpression(String nodes) {
		// Write your code here
		Node root = transformToTree(nodes);
		preOrderTraversal(root);
		if(error != null) return error;
		// System.out.println(strBui.toString());
		return strBui.toString();
	}

	private static Node transformToTree(String nodes) {
		Node node = null;
		String[] splited = nodes.replace("(", "").replace(")", "").split("\\s+");

		List<Integer> isVisited = new ArrayList<>();
		HashSet<String> uni = new HashSet<>();
		for (int i = 0; i < splited.length; i++) {
			if(!uni.add(splited[i])) {
				error = "E2";
				return node;
			}
			Node temp = constructTree(node, splited[i].charAt(0), splited[i].charAt(2));
			if (temp == null)
				isVisited.add(i);
			else
				node = temp;
		}
		for (Integer elem : isVisited) {
			node = constructTree(node, splited[elem].charAt(0), splited[elem].charAt(2));
		}

		return node;
	}

	private static Node constructTree(Node node, char par, char child) {
		if (node == null)
			return new Node(Character.toString(par), new Node(Character.toString(child)));
		Node parent = preOrderSearch(node, Character.toString(par));
		if (parent == null) {
			Node parentNode = new Node(Character.toString(par), new Node(Character.toString(child)));
			Node children = preOrderSearch(node, Character.toString(child));
			if (children != null && children.data != null) {
				parentNode.left = children;
				return parentNode;
			} else
				return children;
		} else {
			if (parent.left == null) {
				parent.left = new Node(Character.toString(child));
			} else if (parent.right == null) {
				parent.right = new Node(Character.toString(child));
			} else {
				error = "E1";
			}
		}
		return node;
	}

	private static Node preOrderSearch(Node node, String key) {
		if (node == null) {
			return node;
		}
		if (key.equalsIgnoreCase(node.data))
			return node;
		Node left = preOrderSearch(node.left, key);
		if (left != null && key.equalsIgnoreCase(left.data)) {
			return left;
		}
		Node right = preOrderSearch(node.right, key);
		if (right != null && key.equalsIgnoreCase(right.data)) {
			return right;
		}
		if (left == null && right == null) {
			return left;
		}
		return node;
	}

	private static void preOrderTraversal(Node node) {
		if (node == null)
			return;
		
        if (strBui.toString().contains(node.data)) {
        	error = "E3";
		}

		strBui.append("(").append(node.data);

		preOrderTraversal(node.left);

		preOrderTraversal(node.right);
		strBui.append(")");
	}

	public static void main(String[] args) throws IOException {
//		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//		String nodes = bufferedReader.readLine();

		String result = Lexicographically.sExpression("(B,D) (D,E) (A,B) (C,F) (E,G) (A,C)");

//		bufferedWriter.write();
//		bufferedWriter.newLine();
//
//		bufferedReader.close();
//		bufferedWriter.close();
	}
}
