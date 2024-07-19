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
		StringBuilder sb = new StringBuilder();
		int n = Integer.valueOf(st.nextToken());
		int[][] arr  = new int[n][n];
		int[][] ans = new int[n][n];
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; ++j) {
				arr[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		
		for(int i = 0; i < n; ++i) {
			boolean[] visit = new boolean[n];
			Queue<Integer> q = new LinkedList<>();
			q.add(i);
			visit[i] = true;
			while(!q.isEmpty()) {
				int cur = q.remove();
				for(int j = 0; j < n; ++j) {
					if(arr[cur][j] == 0)
						continue;
					ans[i][j] = 1;
					if(visit[j])
						continue;
					visit[j] = true;
					q.add(j);
				}
			}
		}
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < n; ++j) {
				sb.append(ans[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}