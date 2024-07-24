import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] arr;
	static int[][] cheese;
	static boolean[][] visit;
	static int ans = 0;
	static Queue<int[]> q = new LinkedList<>();
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static boolean boundOk(int y, int x) {
		return 0<=y && 0<=x && y <n && x <m;
	}
	
	public static void melt(int y, int x, int time) {
		if(ans < time)
			ans = time;
		for(int i = 0; i < 4; ++i) {
			int ny = y + dr[i];
			int nx = x + dc[i];
			if(boundOk(ny,nx)) {
				if(arr[ny][nx] == 1) {
					cheese[ny][nx]++;
					if(cheese[ny][nx] == 2) {
						q.add(new int[] {ny,nx,time+1});
					}
				}
				else {
					if(!visit[ny][nx]) {
						visit[ny][nx] = true;
						melt(ny,nx,time);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		arr = new int[n][m];
		cheese = new int[n][m];
		visit = new boolean[n][m];
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; ++j) {
				arr[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < m; ++j) {
				if(arr[i][j] == 0) {
					melt(i,j,0);
					break;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] cur = q.remove();
			melt(cur[0],cur[1],cur[2]);
		}
		System.out.println(ans);
	}
}
