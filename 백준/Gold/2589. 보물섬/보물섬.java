import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int n, m;
	static boolean[][] arr;
	static boolean[][] visit;
	static int ans = -1;
	static Queue<int[]> q;
	
	public static boolean boundOk(int y, int x) {
		return 0 <= y && 0 <= x && y < n && x < m && arr[y][x];
	}
	
	public static void bfs() {
		while(!q.isEmpty()) {
			int[] cur = q.remove();
			for(int i = 0; i < 4; ++i) {
				int ny = cur[0]+dr[i];
				int nx = cur[1]+dc[i];
				if(boundOk(ny, nx) && !visit[ny][nx]) {
					visit[ny][nx] = true;
					q.add(new int[] {ny,nx,cur[2]+1});
					if(ans < cur[2]+1)
						ans = cur[2]+1;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); m = sc.nextInt();
		arr = new boolean[n][m];
		for(int i = 0; i < n; ++i) {
			String input = sc.next();
			for(int j = 0;j < m; ++j) {
				arr[i][j] = input.charAt(j) == 'L';
			}
		}
		
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < m; ++j) {
				if(arr[i][j]) {
					q = new LinkedList<int[]>();
					visit = new boolean[n][m];
					visit[i][j] = true;
					q.add(new int[] {i,j,0});
					bfs();
				}
			}
		}
		System.out.println(ans);
	}
}
