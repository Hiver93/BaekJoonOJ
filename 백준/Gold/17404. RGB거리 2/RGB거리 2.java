import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int[][] memo;
	static int n;
	static int ans = 2147483647;
	
	
	public static void init(int st) {
		memo = new int[n][3];
		memo[0][0] = 987654321;
		memo[0][1] = 987654321;
		memo[0][2] = 987654321;
		memo[0][st] = arr[0][st];
	}
	
	public static void func(int st) {
		init(st);
		for(int i = 1; i < n; ++i) {
			for(int j = 0; j < 3; ++j) {
				int min = 987564321;
				for(int k = 0; k < 3; ++k) {
					if(j==k)
						continue;
					int tmp = memo[i-1][k] + arr[i][j];
					if(tmp < min)
						min = tmp;
				}
				memo[i][j] = min;
			}
		}
		
		for(int i = 0; i < 3; ++i) {
			if(st == i)
				continue;
			if(memo[n-1][i] < ans)
				ans = memo[n-1][i];
		}
	}
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		arr = new int[n][3];
		for(int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; ++j) {
				arr[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		func(0);
		func(1);
		func(2);
		System.out.println(ans);
		
	}
}