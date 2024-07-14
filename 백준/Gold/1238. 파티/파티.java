import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Main {
	static class Node{
		int idx;
		int dis;
		Node(int idx, int dis){
			this.idx = idx;
			this.dis = dis;
		}
	}
	
	static LinkedList<Node>[] arr;
	static LinkedList<Node>[] arr2;
	static int[] disArr;
	static int[] disArr2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ans = 0;
		int n = sc.nextInt(), m = sc.nextInt(), x = sc.nextInt();
		arr = new LinkedList[n+1];
		arr2 = new LinkedList[n+1];
		disArr = new int[n+1];
		disArr2 = new int[n+1];
		for(int i = 0; i < n+1; ++i) {
			disArr[i] = 2147483647;
			disArr2[i] = 2147483647;
			arr[i] = new LinkedList<>();
			arr2[i] = new LinkedList<>();
		}
		for(int i = 0; i < m; ++i) {
			int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
			arr[a].add(new Node(b,c));
			arr2[b].add(new Node(a,c));
		}
		PriorityQueue<Node> pq = new PriorityQueue<Node>((a,b)->a.dis-b.dis);
		pq.add(new Node(x,0));
		disArr[x] = 0;
		disArr2[x] = 0;
		while(!pq.isEmpty()) {
			Node cur = pq.remove();
			int idx = cur.idx;
			int dis = cur.dis;
			if(disArr[idx] < dis)
				continue;
			for(Node next : arr[idx]) {
				if(disArr[next.idx] < next.dis + dis)
					continue;
				disArr[next.idx] = next.dis+dis;
				pq.add(new Node(next.idx, next.dis+ dis));
			}
		}
		pq.add(new Node(x,0));
		while(!pq.isEmpty()) {
			Node cur = pq.remove();
			int idx = cur.idx;
			int dis = cur.dis;
			if(disArr2[idx] < dis)
				continue;
			for(Node next : arr2[idx]) {
				if(disArr2[next.idx] < next.dis + dis)
					continue;
				disArr2[next.idx] = next.dis+dis;
				pq.add(new Node(next.idx, next.dis+ dis));
			}
		}
		
		
		for(int i = 1; i < n+1; ++i) {
			if(ans < disArr[i]+ disArr2[i]) {
				ans = disArr[i] + disArr2[i];
			}
		}
		System.out.println(ans);
	}
}