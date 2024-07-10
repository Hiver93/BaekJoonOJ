import java.util.Scanner;

public class Main {
	static int[][] arr;
	static int n;
	static int ans = 2147483647;
	static boolean visit[];
	static int st;
	
	public static void dfs(int cur, int cost, int depth) {
		if(depth == n) {
			if(cost < ans)
				ans = cost;
			return;
		}
		
		for(int i = 0; i < n; ++i) {
			if(i == st && depth == n-1 && arr[cur][i] != 0) {
				dfs(i, cost+arr[cur][i],depth+1);
			}
			if(!visit[i] && arr[cur][i] != 0) {
				visit[i] = true;
				dfs(i,cost+arr[cur][i],depth+1);
				visit[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n][n];
		visit = new boolean[n];
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < n; ++j) {
				arr[i][j] = sc.nextInt();
			}
		}
		for(int i = 0; i < n; ++i) {
			st = i;
			visit[i] = true;
			dfs(i,0,0);
			visit[i] = false;
		}
		System.out.println(ans);
		
	}
}
