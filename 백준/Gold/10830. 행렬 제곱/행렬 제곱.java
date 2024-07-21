import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static long[][] arr;
	public static long[][] mul(long[][] a, long[][] b) {
		long[][] res = new long[a.length][a.length];
		for(int i = 0; i < a.length; ++i) {
			for(int j = 0; j < a.length; ++j) {
				int tmp = 0;
				for(int k = 0; k < a.length; ++k) {
					tmp += (a[i][k] * b[k][j]);					
				}
				res[i][j] = tmp % 1000;
			}
		}
		return res;
	}
	
	public static long[][] func(long[][] a, long[][] b, long num) {
		if(num == 1)
			return a;
		long[][] res = func(a,b,num/2);
		res = mul(res,res);
		if(num % 2 == 1)
			res = mul(res,arr);
		return res;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.valueOf(st.nextToken());
		long m = Long.valueOf(st.nextToken());
		arr = new long[n][n];
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; ++j) {
				arr[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		long[][] ans = func(arr,arr,m);
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < n; ++j) {
				sb.append(ans[i][j] % 1000).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}