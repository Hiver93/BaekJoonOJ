import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int n, m;
	
	public static boolean boundOk(int y, int x) {
		return 0 <= y && 0 <= x && y < n && x < m;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.valueOf(st.nextToken()); m = Integer.valueOf(st.nextToken());
		int[][] arr = new int[n][m];
		boolean[][] visit = new boolean[n][m];
		int[][] ans = new int[n][m];
		int y=0, x=0;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; ++j) {
				arr[i][j] = Integer.valueOf(st.nextToken());
				if(arr[i][j] == 2) {
					y = i;
					x = j;
				}
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{y,x,0});
		visit[y][x] = true;
		while(!q.isEmpty()) {
			int[] cur = q.remove();
			for(int i = 0; i < 4; ++i) {
				int ny = cur[0] + dr[i];
				int nx = cur[1] + dc[i];
				if(boundOk(ny,nx) && arr[ny][nx] == 1 && !visit[ny][nx]) {
					visit[ny][nx] = true;
					ans[ny][nx] = cur[2] + 1;
					q.add(new int[] {ny,nx,cur[2]+1});
				}
			}
		}
		
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < m; ++j) {
				if(ans[i][j] == 0 && arr[i][j] == 1) {
					sb.append(-1).append(' ');
				}
				else {
					sb.append(ans[i][j]).append(' ');					
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}	