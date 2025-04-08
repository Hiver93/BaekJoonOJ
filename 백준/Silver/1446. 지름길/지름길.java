import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.valueOf(st.nextToken());
		int dis = Integer.valueOf(st.nextToken());
		
		int[][] arr = new int[n][3];
		int[] memo = new int[10001];
		for(int i = 0; i < 10001; ++i) {
			memo[i] = i;
		}
		
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());
			arr[i][0] = a;
			arr[i][1] = b;
			arr[i][2] = c;
		}
		
		Arrays.sort(arr,(a,b)->{
			if(a[1] < b[1]) {
				return -1;
			}
			else return 1;
		});
		
		int idx = 0;
		
		for(int i = 1; i <= dis; ++i) {
			if(memo[i-1] + 1 < memo[i]) {
				memo[i] = memo[i-1]+1;
			}
			while(idx < n && arr[idx][1] == i) {
				if(memo[arr[idx][0]] + arr[idx][2] < memo[arr[idx][1]]) {
					memo[arr[idx][1]] = memo[arr[idx][0]] + arr[idx][2]; 
				}
				idx++;
			}
		}
		System.out.println(memo[dis]);
	}
}