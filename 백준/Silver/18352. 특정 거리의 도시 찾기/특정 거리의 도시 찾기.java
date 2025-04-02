import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n, m, k, x;
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(st.nextToken());
		x = Integer.valueOf(st.nextToken());
		int[] memo = new int[n+1];
		List<Integer>[] lists = new LinkedList[n+1];
		for(int i = 0 ; i < n+1; ++i) {
			memo[i] = 2147483647;
			lists[i] = new LinkedList<>();
		}
		
		
		for(int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			lists[a].add(b);
		}
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,0});
		memo[x] = 0;
		while(!q.isEmpty()) {
			int[] last = q.remove();
			int idx = last[0];
			int dis = last[1];
			for(Integer i : lists[idx]) {
				if(memo[i] <= dis + 1) {
					continue;
				}
				memo[i] = dis+1;
				q.add(new int[] {i,dis+1});
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n+1; ++i) {
			if(memo[i] == k) {
				sb.append(i).append('\n');
			}
		}
		if(sb.length() == 0)
			System.out.println(-1);
		else
			System.out.println(sb);
	}
}