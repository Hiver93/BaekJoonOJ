import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int n;
	
	static boolean boundOk(int y, int x) {
		return 0<=y && 0<=x && y < n && x < n;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		n = sc.nextInt();
		int tc = 0;
		while(n != 0) {
			tc++;
			int[][] arr = new int[n][n];
			int[][] disArr = new int[n][n];
			for(int i = 0; i < n; ++i) {
				for(int j = 0; j < n; ++j) {
					arr[i][j] = sc.nextInt();
					disArr[i][j] = 2147483647;
				}
			}
			PriorityQueue<Integer[]> pq = new PriorityQueue<Integer[]>((a,b)->a[2]-b[2]);
			pq.add(new Integer[] {0,0,arr[0][0]});
			disArr[0][0] = arr[0][0];
			while(!pq.isEmpty()) {
				Integer[] cur = pq.remove();
				int y = cur[0];
				int x = cur[1];
				int dis = cur[2];
				if(disArr[y][x] < dis)
					continue;
				for(int i = 0; i < 4; ++i) {
					int ny = y + dr[i];
					int nx = x + dc[i];
					if(!boundOk(ny,nx) || disArr[ny][nx] <= dis + arr[ny][nx])
						continue;
					disArr[ny][nx] = dis + arr[ny][nx];
					pq.add(new Integer[] {ny,nx,disArr[ny][nx]});
				}
			}
			sb.append("Problem ").append(tc).append(": ").append(disArr[n-1][n-1]).append('\n');
			n = sc.nextInt();
		}
		System.out.println(sb);
	}
}