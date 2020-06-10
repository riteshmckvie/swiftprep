package solutions;

public class IsBST {

	static class Node {
		int data;
		Node left, right;
	};

	static boolean isBST(Node root, Node l, Node r) {
		if (root == null)
			return true;

		if (l != null && root.data <= l.data)
			return false;

		if (r != null && root.data >= r.data)
			return false;

		return isBST(root.left, l, root) && isBST(root.right, root, r);
	}

	static Node newNode(int data) {
		Node node = new Node();
		node.data = data;
		node.left = node.right = null;
		return (node);
	}

	public static void main(String args[]) {
		Node root = newNode(20);
		root.left = newNode(12);
		root.right = newNode(30);
		root.left.left = newNode(10);
		root.left.right = newNode(4);

		if (isBST(root, null, null))
			System.out.print("Is BST");
		else
			System.out.print("Not a BST");
	}
}
