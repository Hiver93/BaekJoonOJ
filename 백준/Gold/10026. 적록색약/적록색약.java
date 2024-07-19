import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Main {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int n;
	static char[][] arr;
	static boolean[][] visit;
	
	
	public static boolean boundOk(int y, int x) {
		return 0<=y && 0<=x && y < n && x < n;
	}
	
	public static void bfs(int y, int x, Function<char[],Boolean> f) {
		Queue<int[]> q = new LinkedList<>();
		visit[y][x] = true;
		q.add(new int[] {y,x});
		while(!q.isEmpty()) {
			int[] cur = q.remove();
			for(int i = 0; i < 4; ++i) {
				int ny = cur[0] + dr[i];
				int nx = cur[1] + dc[i];
				if(boundOk(ny,nx) && !visit[ny][nx] && f.apply(new char[] {arr[ny][nx], arr[y][x]})) {
					visit[ny][nx] = true;
					q.add(new int[] {ny,nx});
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		arr = new char[n][n];
		int[] ans = new int[2];
		for(int i = 0; i < n; ++i) {
			String str = br.readLine();
			for(int j = 0; j < n; ++j) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		visit = new boolean[n][n];
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < n; ++j) {
				if(visit[i][j])
					continue;
				ans[0]++;
				bfs(i,j,cs->cs[0] == cs[1]);
			}
		}
		
		visit = new boolean[n][n];
		for(int i= 0; i < n; ++i) {
			for(int j = 0; j < n; ++j) {
				if(visit[i][j])
					continue;
				ans[1]++;
				bfs(i,j,cs->{return (cs[0] == 'R' || cs[0] == 'G') ? (cs[1] == 'R' || cs[1] == 'G') : cs[1] == 'B';});
			}
		}
		System.out.println(ans[0] + " " + ans[1]);
	}
}