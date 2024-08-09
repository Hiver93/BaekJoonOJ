import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {-1,1,0,0,-1,-1,1,1};
	static int[] dc = {0,0,-1,1,-1,1,-1,1};
	
	static boolean boundOk(int n, int m, int y, int x) {
		return 0 <= y && 0 <= x && y < n && x < m;
	}
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n, m;
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.valueOf(st.nextToken());
		n = Integer.valueOf(st.nextToken());
		while(n != 0) {
			int cnt = 0;
			int[][] arr = new int[n][m];
			boolean[][] visit = new boolean[n][m];
			
			for(int i = 0; i < n; ++i) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < m; ++j) {
					arr[i][j] = Integer.valueOf(st.nextToken());
				}
			}
			
			for(int i = 0; i < n; ++i) {
				for(int j = 0; j < m; ++j) {
					if(visit[i][j] || arr[i][j] == 0)
						continue;
					cnt++;
					Queue<int[]> q = new LinkedList<>();
					q.add(new int[] {i,j});
					visit[i][j] = true;
					while(!q.isEmpty()) {
						int[] cur = q.remove();
						int y = cur[0];
						int x = cur[1];
						for(int k = 0; k < 8; ++k) {
							int ny = y + dr[k];
							int nx = x + dc[k];
							if(boundOk(n,m,ny,nx) && arr[ny][nx] == 1 && !visit[ny][nx]) {
								visit[ny][nx] = true;
								q.add(new int[] {ny,nx});
							}
						}
					}
				}
			}
			sb.append(cnt).append('\n');
			st = new StringTokenizer(br.readLine());
			m = Integer.valueOf(st.nextToken());
			n = Integer.valueOf(st.nextToken());
		}
		System.out.println(sb);
	}
}