import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] arr;
	static boolean[] visit;
	
	
	public static boolean hasCycle(int last, int cur) {
		visit[cur] = true;
		for(int next : arr[cur]) {
			if(last == next)
				continue;
			if(visit[next])
				return true;
			if(hasCycle(cur, next)) {
				return true;
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v, e;
		v = Integer.valueOf(st.nextToken());
		e = Integer.valueOf(st.nextToken());
		int caseNum = 1;
		StringBuilder sb = new StringBuilder();
		
		while(v != 0) {
			int cnt = 0;
			arr = new List[v+1];
			visit = new boolean[v+1];
			for(int i = 1; i <= v; ++i) {
				arr[i] = new LinkedList<Integer>();
			}
			for(int i = 0; i < e; ++i) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.valueOf(st.nextToken());
				int b = Integer.valueOf(st.nextToken());
				arr[a].add(b);
				arr[b].add(a);
			}
			for(int i = 1; i <= v; ++i) {
				if(visit[i])
					continue;
				if(arr[i].size() == 0 || !hasCycle(-1,i)) {
					cnt++;
				}
			}
			sb.append("Case ").append(caseNum).append(": ");
			if(cnt == 0) {
				sb.append("No trees.\n");
			}else if(cnt == 1) {
				sb.append("There is one tree.\n");
			}else {
				sb.append("A forest of ").append(cnt).append(" trees.\n");
			}
			
			caseNum++;
			st = new StringTokenizer(br.readLine());
			v = Integer.valueOf(st.nextToken());
			e = Integer.valueOf(st.nextToken());
		}
		System.out.println(sb);
	}
}