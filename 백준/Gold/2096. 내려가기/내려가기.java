import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int[][] arr = new int[n+1][5];
		int[][] min = new int[n+1][5];
		int[][] max = new int[n+1][5];
		for(int i = 1; i <= n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; ++j) {
				arr[i][j+1] = Integer.valueOf(st.nextToken());
			}
		}
		
		for(int i = 1; i < 4; ++i) {
			min[1][i] = arr[1][i];
			max[1][i] = arr[1][i];
		}
		min[1][0] = 2147483647;
		min[1][4] = 2147483647;
		for(int i = 2; i <= n; ++i) {
			for(int j = 1; j < 4; ++j) {
				min[i][j] = Math.min(Math.min(min[i-1][j-1], min[i-1][j]), min[i-1][j+1]) + arr[i][j]; 
				max[i][j] = Math.max(Math.max(max[i-1][j-1], max[i-1][j]), max[i-1][j+1]) + arr[i][j]; 
			}
			min[i][0] = 2147483647;
			min[i][4] = 2147483647;
		}
		for(int i = 1; i < 3; ++i) {
			if(min[n][i] < min[n][3])
				min[n][3] = min[n][i];
			if(max[n][3] < max[n][i])
				max[n][3] = max[n][i];
		}
		System.out.println(max[n][3] + " " + min[n][3]);
	}
}