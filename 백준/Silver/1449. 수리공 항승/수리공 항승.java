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
		int m = Integer.valueOf(st.nextToken());
		int[] arr = new int[n];
		int ans = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; ++i) {
			arr[i] = Integer.valueOf(st.nextToken());
		}
		Arrays.sort(arr);
		
		int dis = m;
		ans++;
		for(int i = 1; i < n; ++i) {
			int tmp = arr[i] - arr[i-1];
			if(dis <= tmp) {
				dis = m;
				ans++;
			}
			else {
				dis -= tmp;
			}
		}
		System.out.println(ans);
	}
}