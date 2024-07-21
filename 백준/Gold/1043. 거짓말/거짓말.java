import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = 0;
		int n = Integer.valueOf(st.nextToken()), m = Integer.valueOf(st.nextToken());
		boolean[] know = new boolean[n+1];
		boolean[] res = new boolean[m];
		List<Integer>[] list = new LinkedList[n+1];
		st = new StringTokenizer(br.readLine());
		int p = Integer.valueOf(st.nextToken());
		for(int i = 0; i < p; ++i) {
			know[Integer.valueOf(st.nextToken())] = true;
		}
		
		for(int i = 1; i < n+1; ++i) {
			list[i] = new LinkedList<Integer>();
		}

		for(int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.valueOf(st.nextToken());
			for(int j = 0; j < num; ++j) {
				int cur = Integer.valueOf(st.nextToken());
				list[cur].add(i);
			}
		}
		
		for(int i = 1; i <= n; ++i) {
			for(int j = 1; j <= n; ++j) {
				for(int k : list[j]) {
					if(res[k] == true) {
						know[j] = true;
						break;
					}
				}
			}
			for(int j = 1; j <= n; ++j) {
				for(int k : list[j]) {
					if(know[j] == true) {
						res[k] = true;
					}
				}
			}
		}
		
		for(int i = 0; i < res.length; ++i) {
			if(!res[i])
				ans++;
		}
		System.out.println(ans);
	}
}