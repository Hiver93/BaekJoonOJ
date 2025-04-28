import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.valueOf(st.nextToken());
		
		while(tc-- != 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.valueOf(st.nextToken());
			sb.append(n/2+1);
			PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
			PriorityQueue<Integer> right = new PriorityQueue<>();
			left.add(Integer.MIN_VALUE);
			right.add(Integer.MAX_VALUE);
			
			for(int i = 0; i < n; ++i) {
				if(i % 10 == 0) {
					st = new StringTokenizer(br.readLine());
				}
				int num = Integer.valueOf(st.nextToken());
				
				// 왼쪽의 최대보다 작거나 같으면 왼쪽에 넣고 아니면 오른쪽에 넣는다.
				if(num <= left.peek()) {
					left.add(num);
				}
				else {
					right.add(num);
				}
				
				// 두 pq의 차이가 둘 이상이라면 맞춰준다.
				if(1 < left.size() - right.size()) {
					right.add(left.remove());
				}
				else if(1 < right.size() - left.size()) {
					left.add(right.remove());
				}
				
				if((left.size() + right.size()) % 2 == 1) {
					if(i % 20 == 0) {
						sb.append('\n');
					}
					if(left.size() < right.size()) {
						sb.append(right.peek()).append(' ');
					}
					else {
						sb.append(left.peek()).append(' ');
					}
				}
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}