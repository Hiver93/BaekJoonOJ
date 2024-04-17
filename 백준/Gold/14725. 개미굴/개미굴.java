import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	// 정담 문자열
	static StringBuilder sb = new StringBuilder();
	
	// 트라이
	static Node trie = new Node("");
	
	// 트라이의 노드
	public static class Node implements Comparable<Node>{
		
		// 저장된 문자열
		String value;
		
		// 해당 굴에서 이어진 다른 굴
		Map<String,Node> map = new HashMap<String,Node>();
		public Node(String str) {
			this.value = str;
		}
		
		// 우선순위 큐 활용을 위한 비교함수
		@Override
		public int compareTo(Node o) {
			return this.value.compareTo(o.value);
		}
		
	}
	
	
	public static void insert(String[] strs) {
		Node node = trie;
		
		// 문자열 배열의 값들을 집어넣는다.
		for(int i = 0; i < strs.length; ++i) {
			
			// 이미 존재한다면 그 노드로 현재 노드 변경
			if(node.map.containsKey(strs[i])) {
				node = node.map.get(strs[i]);
			}
			// 새로운 값이라면 생성해서 집어넣고 현재 노드 변경
			else {
				Node tmp = new Node(strs[i]);
				node.map.put(strs[i], tmp);
				node = tmp;
			}
		}
	}
	
	// 정답 문자열 생성 함수 BFS 이용
	public static void makeSbByDFS(Node node, int depth) {
		
		// PQ에 집어넣고 빼면서 사전순 출력
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for(Entry<String,Node> e : node.map.entrySet()) {
			pq.add(e.getValue());
		}
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			for(int i = 0; i < depth; ++i) {
				sb.append("--");
			}
			sb.append(cur.value);
			sb.append("\n");
			makeSbByDFS(cur,depth+1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// 입력받으며 트라이 생성
		for(int i = 0; i < n; ++i) {
			int m = sc.nextInt();
			String[] strs = new String[m];
			for(int j = 0; j < m; ++j) {
				strs[j] = sc.next();
			}
			insert(strs);
		}
		
		// 정답 생성 및 출력
		makeSbByDFS(trie, 0);
		System.out.println(sb);
	}
}