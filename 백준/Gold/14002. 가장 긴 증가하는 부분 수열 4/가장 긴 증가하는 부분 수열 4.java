import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		Deque<Integer> stack = new LinkedList<>();
		int ans = 0;
		int n = Integer.valueOf(st.nextToken());
		int[] arr = new int[n+1];
		int[] result = new int[n+1];
		int[] l = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; ++i) {
			arr[i+1] = Integer.valueOf(st.nextToken());
		}
		
		for(int i = 1; i <= n; ++i) {
			result[i] = 1;
			l[i] = i;
			for(int j = i-1; j >= 1; --j) {
				if(arr[j] < arr[i] && result[i] < result[j] + 1) {
					result[i] = result[j] + 1;
					l[i] = j;
				}
			}
		}
		
		for(int i = 1; i <= n; ++i) {
			if(result[ans] < result[i]) {
				ans = i;
			}
		}
		
		sb.append(result[ans]).append('\n');
		stack.add(arr[ans]);
		while(ans != l[ans]) {
			ans = l[ans];
			stack.addLast(arr[ans]);
		}
		while(!stack.isEmpty()) {
			sb.append(stack.removeLast()).append(' ');
		}
		
		
		
		System.out.println(sb);
	}
}