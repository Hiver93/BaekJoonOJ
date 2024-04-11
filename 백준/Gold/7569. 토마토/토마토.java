import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[] dr = {-1,1,0,0,0,0};
	static int[] dc = {0,0,-1,1,0,0};
	static int[] dz = {0,0,0,0,-1,1};
	static int[][][] box;
	static int n, m, h;
	
	// 범위를 벗어나는지 체크
	public static boolean boundOk(int z, int y, int x) {
		return 0 <= y && 0 <= x && y < n && x < m && 0 <= z && z < h;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans = 0;
		m = sc.nextInt();
		n = sc.nextInt();
		h = sc.nextInt();
		Queue<int[]> q = new LinkedList<>();
		box = new int[h][n][m];
		
		// 입력 받으며 익은 토마토는 미리 큐에 넣기
		for(int i = 0; i < h; ++i) {
			for(int j = 0;j  < n; ++j) {
				for(int k = 0; k < m; ++k) {
					box[i][j][k] = sc.nextInt();
					if(box[i][j][k] == 1) {
						q.add(new int[] {i,j,k});
					}
				}
			}
		}
		
		// 큐를 이용한 bfs
		while(!q.isEmpty()) {
			
			// d는 익은 날짜
			int[] arr = q.remove();
			int z = arr[0];
			int y = arr[1];
			int x = arr[2];
			int d = box[z][y][x];
			
			// 상하좌우 확인하여 안익은 토마토가 있다면 현재날짜+1로 익게하고 큐에 집어 넣는다.
			for(int i = 0; i < 6; ++i) {
				int nZ = z + dz[i];
				int nY = y + dr[i];
				int nX = x + dc[i];
				if(boundOk(nZ, nY,nX) && box[nZ][nY][nX] == 0) {
					box[nZ][nY][nX] = d + 1;
					q.add(new int[] {nZ, nY,nX});
				}
			}
		}
		
		// 순회하여 정답 출력, 안익은 날짜가 있다면 -1출력하고 종료
		for(int i = 0; i < h; ++i) {
			for(int j = 0; j < n; ++j) {
				for(int k = 0; k < m; ++k) {
					if(box[i][j][k] == 0) {
						System.out.println(-1);
						return;
					}
					if(ans < box[i][j][k]) {
						ans = box[i][j][k];
					}	
				}
			}
		}
		System.out.println(ans-1);
	}
}	