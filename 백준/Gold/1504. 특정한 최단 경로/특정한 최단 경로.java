import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static final int INF = 2147483647;
	
	
	// 초기값 저장할 노드
	static class Node{
		int idx;
		int dis;
		Node(int idx, int dis){
			this.idx = idx;
			this.dis  = dis;
		}
	}
	
	// 우선순위 큐에 저장할 노드
	static class QNode{
		int idx;
		int dis;
		QNode(int idx, int dis){
			this.idx = idx;
			this.dis = dis;
		}
	}
	
	
	static LinkedList<Node>[] eds;
	static int[] disArr;
	static PriorityQueue<QNode> pq;
	static int v,e;
	
	
	// 다익스트라
	static int dijkstra(int st, int dest) {
		PriorityQueue<QNode> pq = new PriorityQueue<QNode>((i1,i2)->{return i1.dis - i2.dis;});
		disArr = new int[v+1];
		for(int i = 0; i < v+1; ++i)
			disArr[i] = INF;
		disArr[st] = 0;
		pq.add(new QNode(st,0));
		while(!pq.isEmpty()) {
			QNode cur = pq.remove();
			if(disArr[cur.idx] < cur.dis)
				continue;
			for(Node n : eds[cur.idx]) {
				if(n.dis + disArr[cur.idx] < disArr[n.idx]) {
					disArr[n.idx] = n.dis + disArr[cur.idx];
					pq.add(new QNode(n.idx,disArr[n.idx]));
				}
			}
		}
		if(disArr[dest] == INF)
			return -1;
		return disArr[dest];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		v = sc.nextInt();
		e = sc.nextInt();
		int a, b;
		eds = new LinkedList[v+1];
		for(int i = 1; i < v+1; ++i) {
			eds[i] = new LinkedList<Node>();
		}
		for(int i = 0; i < e; ++i) {
			int st = sc.nextInt(), ed = sc.nextInt(), dis = sc.nextInt();
			eds[st].add(new Node(ed,dis));
			eds[ed].add(new Node(st,dis));
		}
		
		a = sc.nextInt();
		b = sc.nextInt();
		// a에서 출발한 값과, b에서 출발한 값을 구한다.
		int res1 = dijkstra(a,v);
		int res2 = dijkstra(b,v);
		
		// 중간 경로 값을 구한다. 경로가 없다면 -1 바로 리턴
		int mid = dijkstra(a,b);
		if(mid == -1) {
			System.out.println(-1);
			return;
		}
		
		// 이후 b에 도착한 값과 a에 도착한 값을 구한다. 불가능하면 넘어간다.
		if(res1 != -1) {
			int tmp = dijkstra(1,b);
			if(tmp != -1)
				res1 = res1 + tmp + mid;
		}
		if(res2 != -1) {
			int tmp = dijkstra(1,a);
			if(tmp != -1) {
				res2 = res2 + tmp + mid;
			}
		}
		
		// 적은 값을 출력한다.
		if(res1 != -1 && res2 != -1) {
			System.out.println(res1 < res2 ? res1 : res2);
		}
		else if(res1 == -1) {
			System.out.println(res2);
		}
		else {
			System.out.println(res1);
		}
	}
}