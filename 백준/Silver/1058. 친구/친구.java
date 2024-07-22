import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		boolean[][] arr = new boolean[n][n];
		boolean[][] res = new boolean[n][n];
		int ans = 0;
		for(int i = 0; i < n; ++i) {
			String str = br.readLine();
			for(int j = 0; j < n; ++j) {
				arr[i][j] = str.charAt(j) == 'Y' ? true : false;
			}
		}
		
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < n; ++j) {
				for(int k = 0; k < n; ++k) {
					if(arr[j][k] || (arr[j][i] && arr[i][k]))
						res[j][k] = true;
				}
			}
		}
		
		for(int i = 0; i < n; ++i) {
			int cnt = 0;
			for(int j = 0; j < n; ++j) {
				if(i != j && res[i][j])
					cnt++;
			}
			if(ans < cnt)
				ans = cnt;
		}
		
		System.out.println(ans);
	}
}
