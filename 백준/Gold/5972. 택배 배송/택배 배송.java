import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		int[] memo = new int[n+1];
		Arrays.fill(memo, 2147483647);
		List<int[]>[] list = new List[n+1];
		for(int i = 0; i < n+1; ++i) {
			list[i] = new LinkedList<int[]>();
		}
		for(int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());
			
			// dest, cost
			list[a].add(new int[] {b,c});
			list[b].add(new int[] {a,c});
		}
		
		memo[1] = 0;
		// 여기부터 다익스트라
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
			if(memo[a] <= memo[b]) {
				return -1;
			}
			else {
				return 1;
			}
		});
		
		pq.add(1);
		while(!pq.isEmpty()) {
			int cur = pq.remove();
			for(int[] i : list[cur]) {
				int dest = i[0];
				int cost = i[1];
				if(memo[cur] + cost < memo[dest]) {
					memo[dest] = memo[cur] + cost;
					pq.add(dest);
				}
			}
		}
		System.out.println(memo[n]);
	}
}