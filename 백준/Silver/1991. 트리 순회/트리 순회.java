import java.io.*;
import java.util.*;

public class Main {

	static class Node {
		char value;
		Node left;
		Node right;
		
		Node(char value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	
	static Node head = new Node('A', null, null);
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			insertNode(head, root, left, right);
		}
			preOrder(head);   // 전위 순회 (루트 -> 왼쪽 -> 오른쪽)
			System.out.println();
			inOrder(head);    // 중위 순회 (왼쪽 -> 루트 -> 오른쪽)
			System.out.println();
			postOrder(head);  // 후위 순회 (왼쪽 -> 오른쪽 -> 루트)
			System.out.println();
	}
	
	public static void insertNode(Node temp, char root, char left, char right) {
		if(temp.value == root) {
			temp.left = (left == '.' ? null : new Node(left, null, null));
			temp.right = (right == '.' ? null : new Node(right, null, null));	
		}
		else {
			if(temp.left != null) insertNode(temp.left, root, left, right);
			if(temp.right != null) insertNode(temp.right, root, left, right);
		}
	}
	
	// 전위 순회 (루트 -> 왼쪽 -> 오른쪽)
	public static void preOrder(Node node) {
		if(node == null) return;
		System.out.print(node.value);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	// 중위 순회 (왼쪽 -> 루트 -> 오른쪽)
	public static void inOrder(Node node) {
		if(node == null) return;
		inOrder(node.left);
		System.out.print(node.value);
		inOrder(node.right);
	}
	
	// 후위 순회 (왼쪽 -> 오른쪽 -> 루트)
	public static void postOrder(Node node) {
		if(node == null) return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.value);
	}	
}
