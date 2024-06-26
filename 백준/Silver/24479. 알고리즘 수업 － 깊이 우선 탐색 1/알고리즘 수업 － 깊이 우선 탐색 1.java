import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

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
		int n = sc.nextInt();
		int m = sc.nextInt();
		int st = sc.nextInt();
		int[] v = new int[n+1];
		PriorityQueue<Integer>[] e = new PriorityQueue[n+1];
		visited = new boolean[n+1];
		for(int i = 1; i < n+1; ++i) {
			e[i] = new PriorityQueue<Integer>();
		}
		for(int i = 0; i < m; ++i) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			e[a].add(b);
			e[b].add(a);
		}
		dfs(v,e,st);
		System.out.println(
				Arrays.stream(v,1,n+1).mapToObj(Integer::toString).collect(Collectors.joining("\n")
						));
		
	}
}
