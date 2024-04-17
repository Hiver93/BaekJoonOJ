import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static Node trie;
	static class Node{
		public Map<Character,Node> map = new HashMap<>();
		boolean isEndOfStr = false;
	}
	
	// 트라이에 문자열 입력
	static void insert(String str) {
		Node node = trie;
		for(int i = 0; i < str.length(); ++i) {
			
			// 존재하는 알파벳이라면 노드 변경
			if(node.map.containsKey(str.charAt(i))) {
				node = node.map.get(str.charAt(i));
			}
			// 존재하지 않는다면 생성후 변경
			else {
				Node nNode = new Node();
				node.map.put(str.charAt(i),nNode);
				node = nNode;
			}
		}
		
		// 이 노드에서 끝나는 문자열 있음
		node.isEndOfStr = true;
	}
	
	static int getCnt(String str) {
		
		// 처음은 무조건 누르고 시작해야하므로 카운트 1로 시작
		Node node = trie.map.get(str.charAt(0));
		int cnt = 1;
		// 문자열 순회하며 카운트 증가
		for(int i = 1; i < str.length(); ++i) {
			char c = str.charAt(i);
			// 자판을 눌러야하는 상황
			if(1 < node.map.size() || node.isEndOfStr) {
				cnt++;
			}
			// 노드 다음으로
			node = node.map.get(c);
		}
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		while(sc.hasNext()) {
			double ans = 0;
			int n = sc.nextInt();
			trie = new Node();
			String[] strs = new String[n];
			
			// 입력받으며 트라이 생성
			for(int i = 0; i < n; ++i) {
				strs[i] = sc.next();
				insert(strs[i]);
			}
			// 생성된 트라이로 카운트 세기
			for(int i = 0; i < n; ++i) {
				int cnt = getCnt(strs[i]);
				ans+=cnt;				
			}
			
			// 반올림하여 버퍼에 추가
			sb.append(String.format("%.2f",Math.round(ans/n*100)/100.0)).append("\n");
		}
		
		// 출력
		System.out.println(sb);
	}
}