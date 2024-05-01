import java.util.Scanner;

public class Main {
	static final int INF = 2147483647;
	static long result[][];
	static int v,e;
	
	// 플로이드 워셜
	static void fw() {
		for(int i = 1; i <= v; ++i) {
			for(int j = 1; j <= v; ++j) {
				for(int k = 1; k <= v; ++k) {
					if(result[j][i] + result[i][k] < result[j][k]) {
						result[j][k] = result[j][i] + result[i][k];
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long ans = INF;
		v = sc.nextInt();
		e = sc.nextInt();
		result = new long[v+1][v+1];
		for(int i = 1; i <= v; ++i) {
			for(int j = 1; j <= v; ++j) {
				if(i == j)
					result[i][j] = 0;
				else
					result[i][j] = INF;
			}
		}
		for(int i = 0; i < e; ++i) {
			int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
			result[a][b] = c;
		}
		
		// 플로이드 워셜로 각 정점에서 정점까지의 최소값을 구한다.
		fw();
		
		// 정점에서 정점간 왕복이 가능한경우의 최솟값을 구한다.
		for(int i = 1; i <= v; ++i) {
			for(int j = 1; j <= v; ++j) {
				if(i == j)
					continue;
				if(result[i][j] + result[j][i] < ans){
					ans = result[i][j] + result[j][i];
				}				
			}
		}
		System.out.println(ans == INF ? -1 : ans);
	}
}