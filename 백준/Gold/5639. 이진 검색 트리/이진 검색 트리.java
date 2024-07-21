import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static class Node{
		int num;
		Node left;
		Node right;
	}
	static class Tree{
		StringBuilder sb = new StringBuilder();
		Node root;
		public void push(int num){
			Node node = new Node();
			node.num = num;
			if(root == null) {
				root = node;
				return;
			}
			Node cur = root;
			while(true) {
				if(cur.num < num) {
					if(cur.right == null) {
						cur.right = node;
						return;
					}
					cur = cur.right;
				}
				else {
					if(cur.left == null) {
						cur.left = node;
						return;
					}
					cur = cur.left;
				}
			}
		}
		
		public void traversal(Node node) {
			if(node == null)
				return;
			traversal(node.left);
			traversal(node.right);
			sb.append(node.num).append('\n');
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Tree tree = new Tree();
		String str = br.readLine();
		while(str != null) {
			int num = Integer.valueOf(str);
			tree.push(num);
			str = br.readLine();
		}
		tree.traversal(tree.root);
		System.out.println(tree.sb);
	}
}