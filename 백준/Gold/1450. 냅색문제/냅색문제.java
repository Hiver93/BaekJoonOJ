import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int[] arr1, arr2;
	static PriorityQueue<Long> pq1 = new PriorityQueue<Long>();
	static PriorityQueue<Long> pq2 = new PriorityQueue<Long>((l1,l2)->l2-l1 < 0 ? -1 : 1);
	
	// 경우의 수를 전부 구하여 pq에 저장
	public static void dfs(int[] arr, PriorityQueue<Long> pq, int idx, long sum) {
		if(idx == arr.length)
			return;
		
		pq.add(sum+arr[idx]);
		dfs(arr,pq,idx+1,sum);
		dfs(arr,pq,idx+1,sum+arr[idx]);
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(), c = sc.nextInt();
		int i;
		long ans = 0;
		arr1 = new int[n/2];
		arr2 = new int[n - n/2];
		
		// 2등분하여 입력받는다.
		for(i = 0; i < n / 2; ++i) {
			arr1[i] = sc.nextInt();
		}
		for(;i < n; ++i) {
			arr2[i - n/2] = sc.nextInt();
		}
		pq1.add(0L);
		pq2.add(0L);
		dfs(arr1,pq1,0,0);
		dfs(arr2,pq2,0,0);
		
		
		int cnt = 0;
		long cur1 = pq1.remove();
		long cur2 = pq2.remove();
		// 1집합은 작은 수부터 2집합은 큰수부터 비교해가며 경우의 수를 모두 구한다.
		while(true) {
			if(cur1 + cur2 <= c) {
				cnt++;
				ans++;
				if(!pq1.isEmpty()) {
					cur1 = pq1.remove();
				}
				else {
					cnt--;
					if(pq2.isEmpty())
						break;
					cur2 = pq2.remove();
					ans += cnt;
				}
			}
			else {
				if(!pq2.isEmpty()) {
					cur2 = pq2.remove();
					ans += cnt;
				}
				else
					break;
			}
		}
		System.out.println(ans);
	}
}