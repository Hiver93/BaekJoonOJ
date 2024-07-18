import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int ans = 0;
		int n = Integer.valueOf(st.nextToken()), m = Integer.valueOf(st.nextToken());
		boolean[] visit = new boolean[n+1];
		LinkedList<Integer>[] arr = new LinkedList[n+1];
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i <= n; ++i) {
			arr[i] = new LinkedList<>();
		}
		for(int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
			
		}
		
		for(int i = 1; i <= n; ++i) {
			if(visit[i])
				continue;
			visit[i] = true;
			ans++;
			q.add(i);
			while(!q.isEmpty()) {
				int cur = q.remove();
				visit[cur] = true;
				for(int next : arr[cur]) {
					if(visit[next])
						continue;
					q.add(next);
					visit[next] = true;
				}
			}
		}
		System.out.println(ans);
	}
}