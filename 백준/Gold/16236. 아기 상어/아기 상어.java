import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {-1,0,0,1};
	static int[] dc = {0,-1,1,0};
	static int n;
	static int[][] arr;
	
	public static boolean boundOk(int y, int x) {
		return 0 <= y && 0 <= x && y < n && x < n;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		arr = new int[n][n];
		PriorityQueue<int[]> q = new PriorityQueue<int[]>((a,b)->{
			if(a[2] < b[2])
				return -1;
			if(a[2] > b[2])
				return 1;
			if(a[0] < b[0])
				return -1;
			if(a[0] > b[0])
				return 1;
			if(a[1] < b[1])
				return -1;
			return 1;
		});
		for(int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; ++j) {
				arr[i][j] = Integer.valueOf(st.nextToken());
				if(arr[i][j] == 9) {
					q.add(new int[] {i,j,0});
					arr[i][j] = 0;
				}
			}
		}
		
		int h = 2;
		int cnt = 0;
		int time = 0;
		boolean[][] visit = new boolean[n][n];
		while(!q.isEmpty()) {
			int[] cur = q.remove();
			int y = cur[0];
			int x = cur[1];
			int dis = cur[2];
			if(arr[y][x] < h && 0 < arr[y][x]) {
				time = dis;
				cnt++;
				if(cnt == h) {
					cnt = 0;
					h++;
				}
				arr[y][x] = 0;
				q = new PriorityQueue<int[]>((a,b)->{
					if(a[2] < b[2])
						return -1;
					if(a[2] > b[2])
						return 1;
					if(a[0] < b[0])
						return -1;
					if(a[0] > b[0])
						return 1;
					if(a[1] < b[1])
						return -1;
					return 1;
				});
				visit = new boolean[n][n];
				visit[y][x] = true;
				q.add(new int[] {y,x,dis});
				continue;
			}
			for(int i = 0; i < 4; ++i) {
				int ny = y + dr[i];
				int nx = x + dc[i];
				if(boundOk(ny,nx) && arr[ny][nx] <= h && !visit[ny][nx]) {
					q.add(new int[] {ny,nx,dis+1});
					visit[ny][nx] = true;
				}
			}
		}
		System.out.println(time);
	}
}