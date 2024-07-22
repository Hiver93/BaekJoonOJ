import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] arr;
	static boolean boundOk(int num, int depth) {
		return 0 <= num && num <= 200000 && (arr[num] == 0 || arr[num] == depth);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(), b = sc.nextInt();
		int cnt = 0;
		int ans = 0;
		arr = new int[200001];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {a,0});
		while(!q.isEmpty()) {
			int[] cur = q.remove();
			if(cnt != 0) {
				if(ans < cur[1])
					break;
				if(cur[0] == b) {
					cnt++;
				}
				continue;
			}
			if(cur[0] == b) {
				cnt++;
				ans = cur[1];
				continue;
			}
				
			int next1 = cur[0] + 1;
			int next2 = cur[0] - 1;
			int next3 = cur[0] * 2;
			if(boundOk(next1, cur[1]+1)) {
				arr[next1] = cur[1]+1;
				q.add(new int[] {next1, cur[1]+1});
			}
			if(boundOk(next2, cur[1]+1)) {
				arr[next2] = cur[1]+1;
				q.add(new int[] {next2, cur[1]+1});
			}
			if(boundOk(next3, cur[1]+1)) {
				arr[next3] = cur[1]+1;
				q.add(new int[] {next3, cur[1]+1});
			}
		}
		System.out.println(ans + "\n" + cnt);
	}
}