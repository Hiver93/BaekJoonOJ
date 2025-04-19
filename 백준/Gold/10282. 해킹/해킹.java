import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.valueOf(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(tc-- != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.valueOf(st.nextToken());
			int d = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());
			List[] arr = new List[n+1];
			for(int i = 0; i < n+1; ++i) {
				arr[i] = new LinkedList<int[]>();
			}
			for(int i = 0; i < d; ++i) {
				st = new StringTokenizer(br.readLine());
				int end = Integer.valueOf(st.nextToken());
				int start = Integer.valueOf(st.nextToken());
				int dis = Integer.valueOf(st.nextToken());
				arr[start].add(new int[] {end,dis});
			}
			int[] memo = new int[n+1];
			Arrays.fill(memo, 2147483647);
			memo[c] = 0;
			PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
				if(memo[a] <= memo[b]) {
					return -1;
				}
				else {
					return 1;
				}
			});
			
			pq.add(c);
			while(!pq.isEmpty()) {
				int cur = pq.remove();
				List<int[]> curList = arr[cur];
				for(int[] next : curList) {
					int end = next[0];
					int dis = next[1];
					if(memo[cur] + dis < memo[end]) {
						memo[end] = memo[cur] + dis;
						pq.add(end);
					}
				}
			}
			
			int cnt = 0;
			int max = 0;
			for(int i = 1; i < n+1; ++i) {
				if(memo[i] != 2147483647) {
					cnt++;
					if(max < memo[i]) {
						max = memo[i];
					}						
				}
			}
			sb.append(cnt).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
}
