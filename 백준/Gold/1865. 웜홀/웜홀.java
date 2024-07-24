import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int INF = 987654321;
	static class Node{
		int num;
		int dis;
		Node(int num, int dis){
			this.num = num;
			this.dis = dis;
		}
	}
	static List<Node>[] nodes;
	static int[][] arr;
	
	// 벨만포드
	public static void bf(int v, int st) {
		for(int i = 1; i <= v; ++i) {
			for(int j = 1; j <= v; ++j) {
				for(Node n : nodes[j]) {
					if(n.dis + arr[st][j] < arr[st][n.num]) {
						arr[st][n.num]= n.dis + arr[st][j]; 
					}
				}
			}
		}
	}
	
	// 사이클이 생기는 지 확인
	public static boolean hasCycle(int v, int st) {
		for(int j = 1; j <= v; ++j) {
			for(Node n : nodes[j]) {
				if(n.dis + arr[st][j] < arr[st][n.num]) {
					return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.valueOf(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(tc-- != 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.valueOf(st.nextToken()), m = Integer.valueOf(st.nextToken()), w = Integer.valueOf(st.nextToken());
			nodes = new List[n+1];
			arr = new int[n+1][n+1];
			for(int i = 1; i <= n; ++i) {
				nodes[i] = new LinkedList<Node>();
				for(int j = 1; j <= n; ++j) {
					if(i == j)
						continue;;
					arr[i][j] = INF;
				}
			}
			for(int i = 0; i < m; ++i) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.valueOf(st.nextToken()), b = Integer.valueOf(st.nextToken()), c = Integer.valueOf(st.nextToken());
				nodes[a].add(new Node(b,c));
				nodes[b].add(new Node(a,c));
				arr[a][b] = c;
				arr[b][a] = c;
			}
			
			for(int i = 0; i < w; ++i) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.valueOf(st.nextToken()), b = Integer.valueOf(st.nextToken()), c = Integer.valueOf(st.nextToken());
				nodes[a].add(new Node(b,-c));
				arr[a][b] = -c;
			}
			boolean check = false;
			bf(n,1);
			if(hasCycle(n,1)){
				check = true;
			}
			if(check) {
				sb.append("YES").append('\n');
			}
			else {
				sb.append("NO").append('\n');
			}
			
		}
		
		System.out.println(sb);
	}
}