import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken()), m = Integer.valueOf(st.nextToken()), r = Integer.valueOf(st.nextToken());
		int[] item = new int[n+1];
		int[][] arr = new int[n+1][n+1];
		int ans = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; ++i) {
			item[i+1] = Integer.valueOf(st.nextToken());
		}
		
		for(int i = 1; i <= n; ++i) {
			for(int j = 1; j <= n; ++j) {
				arr[i][j] = 987654321;
				if(i == j)
					arr[i][j] = 0;
			}
		}
		
		for(int i = 0; i < r; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken()), b = Integer.valueOf(st.nextToken()), c = Integer.valueOf(st.nextToken());
			arr[a][b] = c;
			arr[b][a] = c;
		}
		
		for(int i = 1; i <= n; ++i) {
			for(int j = 1; j <= n; ++j) {
				for(int k = 1; k <= n; ++k) {
					if(arr[j][i] + arr[i][k] < arr[j][k]) {
						arr[j][k] = arr[j][i] + arr[i][k];
					}
				}
			}
		}
		
		for(int i = 1; i <= n; ++i) {
			int tmp = 0;
			for(int j = 1; j <= n; ++j) {
				if(arr[i][j] <= m) {
					tmp += item[j];
				}
			}
			if(ans < tmp)
				ans = tmp;
		}
		System.out.println(ans);
	}
}
