import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		StringTokenizer st;
		int[][] arr = new int[n+1][n+1];
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= n; ++i) {
			for(int j = 1; j <= n; ++j) {
				arr[i][j] = 987654321;
				if(i == j) {
					arr[i][j] = 0;
				}
			}
		}
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken()), b = Integer.valueOf(st.nextToken());
			if(a == -1)
				break;
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		for(int i = 1; i <= n; ++i) {
			for(int j = 1; j <= n; ++j) {
				for(int k = 1; k <= n; ++k) {
					if(arr[j][i] == 987654321)
						continue;
					if(arr[j][i] + arr[i][k]<arr[j][k])
						arr[j][k] = arr[j][i] + arr[i][k];
				}
			}
		}
		int[] res = new int[n+1];
		int min = 2147483647;
		for(int i = 1; i <= n; ++i) {
			for(int j = 1; j <= n; ++j) {
				if(res[i] < arr[i][j])
					res[i] = arr[i][j];
			}
			if(res[i] < min)
				min = res[i];
		}
		
		int cnt = 0;
		for(int i = 1; i <= n; ++i) {
			if(res[i] == min) {
				cnt++;
				sb.append(i).append(' ');
			}
		}
		System.out.println(min + " " + cnt + '\n' + sb);
	}
}