import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static class Node{
		int next;
		int dis;
		Node(int next, int dis){
			this.next = next;
			this.dis = dis;
		}
	}
	
	static List<Node>[] es = new LinkedList[100001];
	static int ans = 0;
	static int idx = 0;
	
	static public void dfs(int st, int cur, int dis, boolean[] visit) {
		visit[cur] = true;
		if(ans < dis) {
			ans = dis;
			idx = cur;
		}
		for(Node node : es[cur]) {
			if(!visit[node.next])
				dfs(st,node.next, node.dis+dis, visit);
		}
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		for(int i = 0; i < n; ++i) {
			int cur = sc.nextInt();
			while(true) {
				int next = sc.nextInt();
				if(next == -1)
					break;
				if(es[cur] == null)
					es[cur] = new LinkedList<Node>();
				es[cur].add(new Node(next,sc.nextInt())); 
			}
		}
		boolean[] visit = new boolean[100001];
		dfs(1,1,0,visit);
		int tmp = idx;
		idx = 0;
		ans = 0;
		visit = new boolean[100001];
		dfs(tmp,tmp,0,visit);

		System.out.println(ans);
		
		
	}
}