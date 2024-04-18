import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), k = sc.nextInt();
		int[][] j = new int[n][2];
		int[] bag = new int[k];
		long ans = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a1,a2)->{return a2[1]-a1[1];});
		
		for(int i = 0; i < n; ++i) {
			j[i][0] = sc.nextInt();
			j[i][1] = sc.nextInt();
		}
		for(int i = 0; i < k; ++i) {
			bag[i] = sc.nextInt();
		}
		
		Arrays.sort(j,(o1,o2)-> {return o1[0] - o2[0];});
		Arrays.sort(bag);
		
		int idx = 0;
		for(int i = 0; i < bag.length; ++i) {
			while(idx < n&&j[idx][0] <= bag[i]) {
				pq.add(j[idx++]);
			}
			if(!pq.isEmpty())
				ans += pq.poll()[1];
		}
		System.out.println(ans);
		
	}
}
