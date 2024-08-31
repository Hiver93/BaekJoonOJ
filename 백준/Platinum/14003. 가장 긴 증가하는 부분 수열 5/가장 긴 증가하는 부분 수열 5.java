import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static int find(int[] arr, int start, int end, int target) {
		int res = 0;
		while(start <= end) {
			int mid = (start + end) / 2;
			if(arr[mid] < target) {
				res = mid;
				start = mid+1;
			}
			else {
				end = mid-1;
			}
		}
		return res;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		Deque<Integer> stack = new LinkedList<>();
		int n = Integer.valueOf(st.nextToken());
		int[] arr = new int[n+1];
		int[] result = new int[n+1];
		int[] l = new int[n+1];
		int[] idxs = new int[n+1];
		arr[0] = -2147483647;
		result[0] = -2147483647;
		int idx = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; ++i) {
			arr[i+1] = Integer.valueOf(st.nextToken());
		}
		
		for(int i = 1; i <= n; ++i) {
			int res = find(result,0,idx,arr[i]);
			l[i] = idxs[res];
			if(idxs[res+1] == 0) {
				idxs[res+1] = i;
				result[res+1] = arr[i];
				idx++;
			}
			else if(arr[i] < result[res+1]) {
				idxs[res+1] = i;
				result[res+1] = arr[i];
			}
		}
		sb.append(idx).append('\n');
		idx = idxs[idx];
		while(idx != 0) {
			stack.addLast(arr[idx]);
			idx = l[idx];
		}
		while(!stack.isEmpty()) {
			sb.append(stack.removeLast()).append(' ');
		}
		System.out.println(sb);
	}
}