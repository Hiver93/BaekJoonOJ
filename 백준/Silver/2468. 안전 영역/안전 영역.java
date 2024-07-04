import java.util.Scanner;

public class Main {
	static int n;
	static int[][] arr;
	static boolean[][] visit;
	static int max = 0;
	static int ans = 1;
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	// 범위체크
	public static boolean boundOk(int y , int x) {
		return y < n && x < n && 0 <= y && 0 <= x;
	}
	
	// 인접한 안전 구역을 모두 방문처리
	public static void dfs(int y, int x, int h) {
		visit[y][x] = true;
		for(int i = 0; i < 4; ++i) {
			int nY = y + dr[i];
			int nX = x + dc[i];
			// 범위, 방문, 높이 모두 괜찮다면 다음으로
			if(boundOk(nY,nX) && !visit[nY][nX] && h < arr[nY][nX]) {
				dfs(nY, nX, h);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		arr = new int[n][n];
		
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < n; ++j) {
				arr[i][j] = sc.nextInt();
				if(max < arr[i][j]) {
					max = arr[i][j];
				}
			}
		}
		
		// 1높이 부터 증가하며 모두 확인
		for(int i = 1; i < max; ++i) {
			visit = new boolean[n][n];
			int cnt = 0;
			for(int j = 0; j < n; ++j) {
				for(int k = 0; k < n; ++k) {
					// 방문하지 않았고 높이가 괜찮다면 카운트 올리고 인접구역 모두 방문처리
					if(!visit[j][k] && i < arr[j][k]) {
						cnt++;
						dfs(j,k,i);
					}
				}
			}
			if(ans < cnt)
				ans = cnt;
		}
		System.out.println(ans);
	}
}