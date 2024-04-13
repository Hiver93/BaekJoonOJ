import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	static int cnt = 1;
	static boolean visited[];
	static Queue<Integer> q = new LinkedList<>();
	
	public static void bfs(int[] v, PriorityQueue<Integer>[] e, int r) {
		visited[r] = true;
		q.add(r);
		while(!q.isEmpty()) {
			int u = q.poll();
			v[u] = cnt++;
			while(!e[u].isEmpty()) {
				int x = e[u].poll();
				if(!visited[x]) {
					visited[x] = true;
					q.add(x);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt(), st = sc.nextInt();
		visited = new boolean[n+1];
		PriorityQueue<Integer>[] e = new PriorityQueue[n+1];
		int[] v = new int[n+1];
		for(int i = 1; i < n+1; ++i) {
			e[i] = new PriorityQueue<>((i1,i2)->i2-i1);
		}
		for(int i = 0; i < m; ++i) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			e[a].add(b);
			e[b].add(a);
		}
		bfs(v,e,st);
		System.out.println(
				Arrays.stream(v,1,n+1)
					.mapToObj(Integer::toString)
					.collect(Collectors.joining("\n"))
				);
	}
}