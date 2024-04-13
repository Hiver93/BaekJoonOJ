import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static boolean[] visited;
	static int cnt = 1;
	public static void dfs(int[] v, PriorityQueue<Integer>[] e, int r) {
		visited[r] = true;
		v[r] = cnt++;
		while(!e[r].isEmpty()) {
			int x = e[r].poll();
			if(!visited[x]) {
				dfs(v,e,x);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int m = sc.nextInt();
		int st = sc.nextInt();
		int[] v = new int[n+1];
		PriorityQueue<Integer>[] e = new PriorityQueue[n+1];
		visited = new boolean[n+1];
		for(int i = 1; i < n+1; ++i) {
			e[i] = new PriorityQueue<Integer>(new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
				
			});
		}
		for(int i = 0; i < m; ++i) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			e[a].add(b);
			e[b].add(a);
		}
		dfs(v,e,st);
		Arrays.stream(v,1,n+1).forEach(i->sb.append(i).append("\n"));
		System.out.println(sb);
		
	}
}