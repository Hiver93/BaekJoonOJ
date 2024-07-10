import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i = 0; i < n; ++i) {
			pq.add(sc.nextInt());
		}
		
		while(pq.size() != 1){
			int sum = pq.remove() + pq.remove();
			ans += sum;
			pq.add(sum);
		}
		System.out.println(ans);
	}
}