import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int INF = 2147483647;
	static class Node{
		int idx;
		int dis;
		Node prev;
		Node(int idx, int dis, Node prev){
			this.dis = dis;
			this.idx = idx;
			this.prev = prev;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int m = Integer.valueOf(br.readLine());
		Node ans = null;
		StringTokenizer st;
		PriorityQueue<Node> pq = new PriorityQueue<Node>((a,b)->a.dis - b.dis);
		List<Node>[] arr = new List[n+1];
		int[] res = new int[n+1];
		for(int i = 1; i <= n; ++i) {
			arr[i] = new LinkedList<Node>();
			for(int j = 1; j <= n; ++j) {
				res[i] = INF;
			}
		}
		
		for(int i = 0; i < m; ++i) {
			st  = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken()), b = Integer.valueOf(st.nextToken()), c = Integer.valueOf(st.nextToken());
			arr[a].add(new Node(b,c,null));
		}
		st = new StringTokenizer(br.readLine());
		int a = Integer.valueOf(st.nextToken()), b = Integer.valueOf(st.nextToken());
		res[a] = 0;
		pq.add(new Node(a,0,null));
		while(!pq.isEmpty()) {
			Node cur = pq.remove();
			if(res[cur.idx] < cur.dis)
				continue;
			if(cur.idx == b && cur.dis == res[b]) {
				ans = cur;
			}
			int idx = cur.idx;
			int dis = cur.dis;
			for(Node node : arr[idx]) {
				if(node.dis + dis < res[node.idx]) {
					res[node.idx] = node.dis + dis;
					pq.add(new Node(node.idx, node.dis + dis, cur));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		Deque<Integer> dq = new LinkedList<>(); 
		sb.append(ans.dis).append('\n');
		while(ans != null) {
			cnt++;
			dq.addLast(ans.idx);
			ans = ans.prev;
		}
		sb.append(cnt).append('\n');
		while(!dq.isEmpty()) {
			sb.append(dq.removeLast()).append(' ');
		}
		System.out.println(sb);
		
		
		
	}
}	