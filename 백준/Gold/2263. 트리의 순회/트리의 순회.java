import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	static class Node{
		boolean haveP = false;
		Node left;
		Node right;
		int v;
	}

	static Map<Integer,Integer> in = new HashMap<>();
	static Map<Integer,Integer> post = new HashMap<>();
	static int[] inArr;
	static int[] postArr;
	static Node[] nodes;
	static int n;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void preOrder(Node node) {
		sb.append(node.v).append(" ");
		if(node.left != null) {
			preOrder(node.left);
		}
		if(node.right != null) {
			preOrder(node.right);
		}
	}


	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		inArr = new int[n+1];
		postArr = new int[n+1];		
		nodes = new Node[n+1];
		for(int i = 1; i <= n; ++i) {
			nodes[i] = new Node();
			nodes[i].v = i;
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; ++i) {
			int tmp = Integer.valueOf(st.nextToken());
			in.put(tmp, i);
			inArr[i] = tmp;
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; ++i) {
			int tmp = Integer.valueOf(st.nextToken());
			post.put(tmp, i);
			postArr[i] = tmp;
		}
		
		int last = postArr[1];
		for(int i = 2; i <= n; ++i) {
			int cur = postArr[i];
			if(in.get(cur) < in.get(last)) {
				nodes[cur].right = nodes[last];
				nodes[last].haveP = true;
			}
			last = cur;
		}

		Deque<Integer> stack = new LinkedList<>();
		for(int i = 1; i <= n; ++i) {
			int cur = inArr[i];
			last = (stack.isEmpty() ? 0 : stack.peekLast());
			if(!stack.isEmpty() && post.get(cur) > post.get(last)) {
				nodes[last].haveP = true;
				nodes[cur].left = nodes[last]; 
				stack.removeLast();
			}
			if(!nodes[cur].haveP) {
				stack.addLast(cur);
			}
		}
		
		preOrder(nodes[postArr[n]]);
		System.out.println(sb);
	}
}