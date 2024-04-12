import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] map;
	
	// 방문배열 (턴 확인 역할 포함)
	static int[][] visit;
	static int[][] bVisit;
	static int n, m;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	// 범위 확인
	public static boolean boundOk(int y, int x) {
		return 0 <= y && 0 <= x && y < n && x < m;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans = 2147483647;
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		visit = new int[n][m];
		bVisit = new int[n][m];
		Queue<int[]> q = new LinkedList<>();
		Queue<int[]> bq = new LinkedList<>(); 
		
		for(int i = 0; i < n; ++i) {
			String str = sc.next();
			for(int j = 0; j < m; ++j) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		// {y, x, 부쉈는지 체크}
		q.add(new int[] {0,0});
		visit[0][0] = 1;
		while(!q.isEmpty()) {
			int[] arr = q.remove();
			int y = arr[0];
			int x = arr[1];
			// 마지막 칸이라면 출력 후 종료
			if(y == n-1 && x == m-1) {
				if(visit[y][x] < ans)
					ans = visit[y][x];
			}
			for(int i = 0; i < 4; ++i) {
				// 다음 칸과 부쉈는지 확인변수
				int nY = y + dr[i];
				int nX = x + dc[i];
				if(boundOk(nY,nX) && visit[nY][nX] == 0) {
					
					// 벽이라면 부수고 새로운 bfs를 위한 큐에 추가
					if(map[nY][nX] == 1) {
						if(bVisit[nY][nX] == 0) {
							bVisit[nY][nX] = visit[y][x]+1;
							bq.add(new int[] {nY,nX});
						}
						continue;
					}
					// 다음칸의 턴 기록 후 큐에 추가
					visit[nY][nX] = visit[y][x] + 1;
					q.add(new int[] {nY,nX});
				}
			}
		}
		
		// 벽을 부순 경우의 bfs
		while(!bq.isEmpty()) {
			int[] arr = bq.remove();
			int y = arr[0];
			int x = arr[1];
			if(y == n-1 && x == m-1) {
				if(bVisit[y][x] < ans)
					ans = bVisit[y][x];
			}
			for(int i = 0; i < 4; ++i) {
				// 다음 칸과 부쉈는지 확인변수
				int nY = y + dr[i];
				int nX = x + dc[i];
				if(boundOk(nY,nX) && (bVisit[nY][nX] == 0 || (bVisit[nY][nX] != 0 && bVisit[y][x] + 1 < bVisit[nY][nX]))) {
					// 벽이라면
					if(map[nY][nX] == 1) {
						continue;
					}
					// 다음칸의 턴 기록 후 큐에 추가
					bVisit[nY][nX] = bVisit[y][x] + 1;
					bq.add(new int[] {nY,nX});
				}
			}
		}
		
		if(ans == 2147483647)
			System.out.println(-1);
		else
			System.out.println(ans);
	}
}
