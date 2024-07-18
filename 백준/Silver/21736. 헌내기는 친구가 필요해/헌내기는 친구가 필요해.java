import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static String[] arr;
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static boolean boundOk(int y, int x) {
		return 0 <= y && 0 <= x && y < n && x < m;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		
		int ans = 0;
		int x = -1, y = -1;		
		boolean[][] visit = new boolean[n][m];
		arr = new String[n];
		Queue<Integer[]> q = new LinkedList<>();
		
		for(int i = 0; i < n; ++i) {
			arr[i] = br.readLine();
			for(int j = 0; j < m; ++j) {
				if(arr[i].charAt(j) == 'I') {
					y = i;
					x = j;
				}
			}
		}
		
		visit[y][x] = true;
		q.add(new Integer[] {y,x});
		while(!q.isEmpty()) {
			Integer[] cur = q.remove();
			for(int i = 0; i < 4; ++i) {
				int ny = cur[0] + dr[i];
				int nx = cur[1] + dc[i];
				if(boundOk(ny, nx) && !visit[ny][nx] && arr[ny].charAt(nx) != 'X') {
					if(arr[ny].charAt(nx) == 'P')
						ans++;
					visit[ny][nx] = true;
					q.add(new Integer[] {ny,nx});
				}
			}
		}
		System.out.println(ans == 0 ? "TT" : ans);
		
	}
}