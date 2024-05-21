import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static class Edge{
		int dis;
		int idx;
		Edge(int idx, int dis){
			this.idx = idx;
			this.dis = dis;
		}
	}
	
	static boolean[] visit;
	static int ans = 0;
	static int x = 1;
	static LinkedList<Edge>[] es = new LinkedList[10001];
	
	public static void dfs(int idx, int dis) {
		if(visit[idx])
			return;
		visit[idx] = true;
		if(ans < dis) {
			ans = dis;
			x = idx;
		}
		
		for(Edge e : es[idx]) {
			dfs(e.idx, dis + e.dis);
		}
	}
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		es[1] = new LinkedList<Edge>();
		for(int i = 0; i < n-1; ++i) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if(es[a] == null)
				es[a] = new LinkedList<Edge>();
			if(es[b] == null)
				es[b] = new LinkedList<Edge>();
			es[a].add(new Edge(b,c));
			es[b].add(new Edge(a,c));
		}
		
		visit = new boolean[10001];
		dfs(1,0);
		visit = new boolean[10001];
		ans = 0;
		dfs(x,0);
		System.out.println(ans);
	}
}