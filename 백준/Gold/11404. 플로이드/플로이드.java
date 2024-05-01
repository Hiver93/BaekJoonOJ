import java.util.Scanner;

public class Main {
	static final long INF = 21474836470L;
	static long[][] result;
	static int n, m;
	
	// 플로이드 워셜
	public static void fw() {
		
		// 중간 지점 i
		for(int i = 1; i <= n; ++i) {
			// 시작지점 j
			for(int j = 1; j <= n; ++j) {
				// 도착지점 k
				for(int k = 1; k <= n; ++k) {
					// 중간지점을 지나며 도착하는 경우가 더 저렴하다면 변경
					if(result[j][i] + result[i][k] < result[j][k]) {
						result[j][k] = result[j][i] + result[i][k];
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		n = sc.nextInt();
		m = sc.nextInt();
		result = new long[n+1][n+1];
		
		// 초기화 및 입력
		for(int i = 1; i <= n; ++i) {
			for(int j = 1; j <= n; ++j) {
				if(i == j)
					result[i][j] = 0;
				else
					result[i][j] = INF;
			}
		}
		
		// 같은 경로의 노선이 여러개인 경우가 있음
		for(int i = 0; i < m; ++i) {
			int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
			if(c <result[a][b])
				result[a][b] = c;
		}
		
		// 플로이드 워셜
		fw();
		for(int i = 1; i <= n; ++i) {
			for(int j = 1; j <= n; ++j) {
				sb.append(result[i][j] == INF ? 0 : result[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}