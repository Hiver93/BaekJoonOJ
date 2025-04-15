import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	static int n;
	
	public static boolean isBoundOk(int y, int x) {
		return 0 <= y && y < n && 0 <= x && x < n; 
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine().trim());
		int[][] arr = new int[n][n];
		boolean[][] visited = new boolean[n][n];
		int ans = 0;
		for(int i = 0; i < n; ++i) {
			String str = br.readLine();
			for(int j = 0; j < n; ++j) {
				arr[i][j] = (str.charAt(j) - '0') ^ 1;
			}
		}
		
		// y x dis
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
			if(a[2] < b[2]) {
				return -1;
			}
			else {
				return 1;
			}
		}); 
		pq.add(new int[] {0,0,0});
		visited[0][0] = true;
		while(!pq.isEmpty()) {
			int[] tmp = pq.remove();
			int y = tmp[0];
			int x = tmp[1];
			int dis = tmp[2];
			if(y == n-1 && x == n-1) {
				ans = dis;
				break;
			}
			for(int i = 0; i < 4; ++i) {
				int ny = y + dr[i];
				int nx = x + dc[i];
				if(isBoundOk(ny,nx) && !visited[ny][nx]) {
					visited[ny][nx] = true;
					pq.add(new int[] {ny,nx,dis+arr[ny][nx]});
				}
			}
			
		}
		System.out.println(ans);
	}
}