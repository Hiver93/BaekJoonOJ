import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Main {
	static List<Function<Integer,Integer>> fList = List.of(
			(i) ->{
				return i * 2 % 10000;
			},
			(i) ->{
				return i-1 < 0 ? 9999 : i-1;
			},
			(i)->{
				return (i * 10) + (i / 1000) - (i / 1000 * 10000);
			},
			(i)->{
				return (i / 10) + (i % 10 * 1000);
			}
			); 
	static boolean[] visit = new boolean[10000];
	static char[] cmd = {'D','S','L','R'};
	
	static class Node{
		int num;
		LinkedList<Integer> list = new LinkedList<>();
		Node(int num){
			this.num = num;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.valueOf(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken()), b = Integer.valueOf(st.nextToken());
			Queue<Node> q = new LinkedList<>();
			q.add(new Node(a));
			visit = new boolean[10000];
			visit[a] = true;
			while(!q.isEmpty()) {
				Node cur = q.remove();
				if(cur.num == b) {
					for(int num : cur.list) {
						sb.append(cmd[num]);
					}
					sb.append('\n');
					break;
				}
				for(int j = 0; j < 4; ++j) {
					int next = fList.get(j).apply(cur.num);
					if(visit[next])
						continue;
					visit[next] = true;
					Node nNode = new Node(next);
					nNode.list.addAll(cur.list);
					nNode.list.add(j);
					q.add(nNode);
				}
			}
		}
		System.out.println(sb);
	}
}