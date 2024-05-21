import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Main {
	
	static class Node{
		Node left;
		Node right;
		char c;
		Node(char c){
			this.c = c;
		}
	}
	static StringBuilder sb;
	
	public static void func(Node n, Function<Node,Node> first, Function<Node,Node> second, Function<Node,Node> third) {
		Node next = first.apply(n); 
		if(next != null)
			func(next,first,second,third);
		next = second.apply(n);
		if(next != null)
			func(next,first,second,third);
		next = third.apply(n);
		if(next != null)
			func(next,first,second,third);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Node[] nodes = IntStream.range(0, 26).mapToObj(i->new Node((char)(i+'A'))).toArray(Node[]::new);
		
		int n = sc.nextInt();
		for(int i = 0; i < n; ++i) {
			char c = sc.next().charAt(0);
			char l = sc.next().charAt(0);
			char r = sc.next().charAt(0);
			
			Node node = nodes[c-'A'];
			node.left = l == '.' ? null : nodes[l-'A'];
			node.right = r == '.' ? null : nodes[r-'A'];
		}
		Function<Node, Node> ap = node->{sb.append(node.c); return null;};
		Function<Node, Node> left = node -> node.left;
		Function<Node, Node> right = node -> node.right;
		
		sb = new StringBuilder();
		func(nodes[0],ap,left,right);
		sb.append('\n');
		func(nodes[0],left,ap,right);
		sb.append('\n');
		func(nodes[0],left,right,ap);
		System.out.println(sb);
		
	}
}
