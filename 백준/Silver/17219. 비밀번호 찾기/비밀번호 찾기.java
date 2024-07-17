import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		int n = Integer.valueOf(st.nextToken()), m = Integer.valueOf(st.nextToken());
		Map<String,String> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			map.put(st.nextToken(),st.nextToken());
		}
		for(int i = 0; i < m; ++i) {
			String str = br.readLine();
			sb.append(map.get(str)).append('\n');
		}
		System.out.println(sb);
		
	}
}
