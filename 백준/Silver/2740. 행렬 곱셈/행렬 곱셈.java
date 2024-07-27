import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] mul(int[][] a, int[][] b, int n, int m) {
		int[][] res = new int[n][m];
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < m; ++j) {
				for(int k = 0; k < b.length; ++k) {
					res[i][j] += (a[i][k] * b[k][j]);
				}				
			}
		}
		return res;
	}
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		int[][] a = new int[n][m];
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; ++j) {
				a[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		int[][] b = new int[n][m];
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; ++j) {
				b[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		
		
		int[][] res = mul(a,b, a.length, b[0].length);
		for(int i = 0; i < a.length; ++i) {
			for(int j = 0; j < b[0].length; ++j) {
				sb.append(res[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}