import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static final int INF = 2147483647;
	
	// 우선순위큐에 들어갈 노드
	static class QNode{
		int idx;
		int dis;
		QNode(int idx, int dis){
			this.idx = idx;
			this.dis = dis;
		}
	}
	
	// 시간 기록 배열
	static int[] arr = new int[200001];
	static PriorityQueue<QNode> pq;
	
	// 범위 확인
	static boolean boundOk(int next) {
		return 0 <= next && next <= 200000;
	}
	
	// 다익스트라
	static int dk(int st, int dest) {
		for(int i = 0; i < 200001; ++i) {
			arr[i] = INF;
		}
		arr[st] = 0;
		pq = new PriorityQueue<QNode>((n1,n2) -> {return n1.dis - n2.dis;});
		pq.add(new QNode(st,0));
		while(!pq.isEmpty()) {
			QNode cur = pq.remove();
			if(cur.idx == dest) {
				return cur.dis;
			}
			if(cur.dis < arr[cur.idx])
				 continue;
			
			// 다음 인덱스가 범위가 되고 기존보다 짧은 시간내에 갈 수 있다면 교체
			int next = cur.idx*2;
			if(boundOk(next) && next != 0 &&cur.dis < arr[next]) {
				arr[next] = cur.dis;
				pq.add(new QNode(next, cur.dis));
			}
			next = cur.idx+1;
			if(boundOk(next) && cur.dis + 1 < arr[next]) {
				arr[next] = cur.dis + 1;
				pq.add(new QNode(next, cur.dis+1));
			}
			next = cur.idx-1;
			if(boundOk(next) && cur.dis + 1 < arr[next]) {
				arr[next] = cur.dis + 1;
				pq.add(new QNode(next, cur.dis+1));
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(), b = sc.nextInt();
		System.out.println(dk(a,b));
	}
}