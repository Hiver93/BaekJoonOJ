import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static class Node{
		int idx;
		int dis;
		public Node(int idx, int dis) {
			this.idx = idx;
			this.dis = dis;
		}
	}
	
	static List<Node>[] arr;
	static int[] ans;
	static int st, ed;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new List[n+1];
		ans = new int[n+1];
		int m = sc.nextInt();
		for(int i = 0; i < n+1; ++i) {
			arr[i] = new ArrayList<>();
			ans[i] = 2147483647;
		}
		for(int i = 0; i < m; ++i) {
			int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
			arr[a].add(new Node(b,c));
		}
		st = sc.nextInt();
		ed = sc.nextInt();
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>((a,b)->{return a.dis-b.dis;});
		pq.add(new Node(st,0));
		ans[st] = 0;
		while(!pq.isEmpty()) {
			Node cur = pq.remove();
			int idx = cur.idx;
			int dis = cur.dis;
			if(ans[idx] < dis)
				continue;
			for(Node next : arr[idx]) {
				if(next.dis + dis < ans[next.idx]) {
					ans[next.idx] = next.dis + dis;
					pq.add(new Node(next.idx,next.dis+dis));
				}
			}
		}
		System.out.println(ans[ed]);
	}
}