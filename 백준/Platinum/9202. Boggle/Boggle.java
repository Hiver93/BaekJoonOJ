import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static Node root = new Node();
	static class Node{
		Node[] arr = new Node[26];
		String str = null;
	}
	static void insert(String str) {
		Node node = root;
		for(int i = 0; i < str.length(); ++i) {
			char c = str.charAt(i);
			if(node.arr[c-'A'] == null)
				node.arr[c-'A'] = new Node();
			node = node.arr[c-'A'];
		}
		node.str = str;
	}
	
	static class El{
		Node node;
		int y;
		int x;
		public El(Node node, int y, int x) {
			super();
			this.node = node;
			this.y = y;
			this.x = x;
		}
		
		
	}
	
	static int[] scores = {0,0,0,1,1,2,3,5,11};
	static int[] dr = {-1,1,0,0,-1,-1,1,1};
	static int[] dc = {0,0,-1,1,-1,1,-1,1};
	static int[][] arr;
	static boolean[][] visit;
	static String ansString = "";
	static int score = 0;
	static int cnt = 0;
	static Map<String,Boolean> map = new HashMap<>();
	static StringBuilder sb;
	
	static boolean boundOk(int y, int x) {
		return 0 <= y && 0 <= x && y < 4 && x < 4;
	}
	
	static void func(Node node, int y, int x) {
		if(node.str != null && !map.get(node.str)) {
			cnt++;
			score += scores[node.str.length()];
			map.put(node.str, true);
			if(ansString.length() < node.str.length()) {
				ansString = node.str;
			}
			else if(ansString.length() == node.str.length()&&0<ansString.compareTo(node.str)) {
				ansString = node.str;
			}
		}
		for(int k = 0; k < 8; ++k) {
			int ny = y + dr[k];
			int nx = x + dc[k];
			if(!boundOk(ny,nx))
				continue;
			if(visit[ny][nx])
				continue;
			if(node.arr[arr[ny][nx]-'A'] == null)
				continue;
			Node next = node.arr[arr[ny][nx]-'A'];
						
			visit[ny][nx] = true;
			func(next,ny,nx);
			visit[ny][nx] = false;
		}
	}
	
	static void solve() {
		for(int i = 0; i < 4; ++i) {
			for(int j = 0; j < 4; ++j) {
				visit = new boolean[4][4];
				func(root,i,j);
			}
		}
		sb.append(score).append(' ').append(ansString).append(' ').append(cnt).append('\n');
		score = 0;
		cnt = 0;
		ansString = "";
		for(Entry<String, Boolean> en : map.entrySet()) {
			map.put(en.getKey(), false);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.valueOf(st.nextToken());
		for(int i = 0; i < w; ++i) {
			String str = br.readLine();
			insert(str);
			map.put(str, false);
		}
		br.readLine();
		int n = Integer.valueOf(br.readLine());
		sb = new StringBuilder();
		
		
		for(int tc = 0; tc < n; ++tc) {
			arr = new int[4][4];
			
			// 입력
			// 쓰레기줄
			for(int i = 0; i < 4; ++i) {
				String str = br.readLine();
				if(str.equals("")) {
					str = br.readLine();
				}
				for(int j = 0; j < 4; ++j) {
					arr[i][j] = str.charAt(j);
				}
			}
			
			// 풀기
			solve();
		}
		System.out.println(sb);
	}
}
