import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken()), m = Integer.valueOf(st.nextToken());
		
		int[][] arr = new int[n+1][n+1];
		for(int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken()), b = Integer.valueOf(st.nextToken());
			arr[a][b] = 1;
			arr[b][a] = -1;
		}
		
		for(int i = 1; i <= n; ++i) {
			for(int j = 1; j <= n; ++j) {
				if(arr[j][i] != 0) {
					for(int k = 1; k <= n; ++k) {
						if(arr[i][k] == arr[j][i]) {
							arr[j][k] = arr[j][i];
						}
					}
				}
			}
		}
		
		
		int ans = 0;
		for(int i = 1; i <= n; ++i) {
			int cnt = 0;
			for(int j = 1; j <= n; ++j) {
				if(arr[i][j] == 0)
					cnt++;
			}
			if(cnt == 1)
				ans++;
		}
		System.out.println(ans);
	}
}