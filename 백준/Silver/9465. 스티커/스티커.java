import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.valueOf(st.nextToken());
		
		for(int t = 0; t < tc; ++t) {
			int n = Integer.valueOf(br.readLine());
			int[][] arr = new int[n+1][2];
			for(int i = 0; i < 2; ++i) {
				st = new StringTokenizer(br.readLine());				
				for(int j = 1; j <= n; ++j) {
					arr[j][i] = Integer.valueOf(st.nextToken());
				}
			}
			
			for(int i = 2; i <= n; ++i) {
				arr[i][0] = Math.max(arr[i-2][1] + arr[i][0], arr[i-1][1] + arr[i][0]);
				arr[i][1] = Math.max(arr[i-2][0] + arr[i][1], arr[i-1][0] + arr[i][1]); 
			}
			System.out.println(Math.max(arr[n][0], arr[n][1]));
		}
	}
}