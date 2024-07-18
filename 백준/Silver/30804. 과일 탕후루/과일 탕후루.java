import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr = new int[2];
	
	public static boolean cmp(int num) {
		if(num != arr[0] && num != arr[1]) {
			return false;
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int ans = 0;
		arr[0] = Integer.valueOf(st.nextToken());
		int cnt = 1;
		int last = 0;
		int i;
		
		int[] f = new int[n];
		f[0] = arr[0];
		for(i = 1; i < n; ++i) {
			int cur = Integer.valueOf(st.nextToken());
			f[i] = cur;
			if(cur != arr[0]) {
				arr[1] = cur;
				cnt++;
				last = i;
				break;
			}
			cnt++;
		}
		++i;
		for(; i < n; ++i) {
			int cur = Integer.valueOf(st.nextToken());
			f[i] = cur;
			if(!cmp(cur)) {
				if(f[i-1] != arr[0])
					arr[0] = cur;
				else
					arr[1] = cur;
				if(ans < cnt)
					ans = cnt;
				cnt = i - last + 1;
				last = i;
				continue;
			}
			if(f[last] != cur)
				last = i;
			cnt++;
		}
		if(ans < cnt)
			ans = cnt;
		System.out.println(ans);
	}
}