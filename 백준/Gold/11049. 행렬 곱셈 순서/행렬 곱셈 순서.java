import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int[][] result;
	static int[][] memo;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		arr = new int[n+1][2];
		result = new int[n+1][n+1];
		memo = new int[n+1][2];
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			arr[i+1][0] = Integer.valueOf(st.nextToken());
			arr[i+1][1] = Integer.valueOf(st.nextToken());
		}
		
		for(int i = 2; i <= n; ++i) {
			result[i][i-1] = arr[i-1][0] * arr[i-1][1] * arr[i][1];
			for(int j = i-2; 1 <= j; --j) {
				result[i][j] = arr[i][1] * arr[i][0] * arr[j][0] + result[i-1][j];
				for(int k = i-2; j+1 <= k; --k) {
					int tmp = result[k][j] + result[i][k+1] + arr[j][0] * arr[k][1] * arr[i][1];
					if(tmp < result[i][j]) {
						result[i][j] = tmp;
					}
				}
				int tmp = arr[j][0] * arr[j][1] * arr[i][1] + result[i][j+1];
				if(tmp < result[i][j]) {
					result[i][j] = tmp;
				}
			}
		}
		System.out.println(result[n][1]);
	}
}