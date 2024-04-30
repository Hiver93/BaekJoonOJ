import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static final long INF = 214748362147483647L;
	
	// 초기값 할당을 위한 노드
	static class Node{
		int idx;
		int dis;
		Node(int idx, int dis){
			this.idx = idx;
			this.dis = dis;
		}
	}
	
	// 간선 리스트
	static LinkedList<Node>[] ll;
	static long[] arr;
	
	// 벨만포드
	public static void bf(int v) {
		for(int i = 2; i <= v; ++i) {
			arr[i] = INF;
		}
		for(int i = 1; i <= v; ++i) {
			for(int j = 1; j <= v; ++j) {
				if(arr[j] == INF)
					continue;
				for(Node n : ll[j]) {
					if(n.dis + arr[j] < arr[n.idx]) {
						arr[n.idx]= n.dis + arr[j]; 
					}
				}
			}
		}
	}
	
	// 사이클이 생기는 지 확인
	public static boolean check(int v) {
		for(int i = 1; i <= v; ++i) {
			for(int j = 1; j <= v; ++j) {
				if(arr[j] == INF)
					continue;
				for(Node n : ll[j]) {
					if(n.dis + arr[j] < arr[n.idx]) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int v = sc.nextInt(), e = sc.nextInt();
		ll = new LinkedList[v+1];
		arr = new long[v+1];
		
		for(int i = 1; i < v+1; ++i) {
			ll[i] = new LinkedList<Node>();
		}
		
		for(int i = 0; i < e; ++i) {
			int a,b,c;
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			ll[a].add(new Node(b,c));
		}
		// 벨만포드
		bf(v);
		
		// 사이클 확인
		if(check(v)) {
			for(int i = 2; i < v+1; ++i) {
				sb.append(arr[i] == INF ? -1 : arr[i]).append('\n');
			}
		}
		else {
			sb.append(-1);
		}
		System.out.println(sb);
	}
}
