import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->{
			if(a[0] < b[0])
				return 1;
			if(b[0] < a[0])
				return -1;
			if(a[1] < b[1])
				return -1;
			return 1;
		});
		int len = 0;
		int[] arr1, arr2;
		int a = Integer.valueOf(br.readLine());
		arr1 = new int[a];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < a; ++i) {
			arr1[i] = Integer.valueOf(st.nextToken());
			pq.add(new int[] {arr1[i],i});
		}
		int b = Integer.valueOf(br.readLine());
		arr2 = new int[b];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < b; ++i) {
			arr2[i] = Integer.valueOf(st.nextToken());
		}
		
		int last = -1;
		int aIdx = 0;
		int bIdx = 0;
		boolean started = false;
		while(!pq.isEmpty()) {
			int[] cur = pq.remove();
			if(cur[1] < aIdx && started)
				continue;
			for(int i = bIdx; i < b; ++i) {
				if(arr2[i] == cur[0]) {
					last = cur[0];
					aIdx = cur[1];
					started = true;
					bIdx = i+1;
					len++;
					sb.append(arr2[i]).append(" ");
					break;
				}
			}
		}
		
		System.out.println(len + "\n" + sb);
		
	}
}
