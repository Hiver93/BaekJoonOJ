import java.util.Scanner;

public class Main {
	static int[][] arr;
	static int n;
	static int ans = 0;
	
	// 현재idx, 이때까지의 합을 인자로 받는다.
	public static void dfs(int curIdx, int sum) {
		
		// idx가 넘어서는 경우 return
		if(curIdx >= n) {
			if(ans < sum)
				ans = sum;
			return;
		}
		
		// 지금 일을 맡을 수 있고 맡는 경우
		if(curIdx+arr[curIdx][0] <= n)
			dfs(curIdx+arr[curIdx][0],sum+arr[curIdx][1]);			
		// 안맡고 넘어가는 경우
		dfs(curIdx+1,sum);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 데이터 수, 데이터 입력을 위한 배열
		n = sc.nextInt();
		arr = new int[n][2];
		
		// 입력
		for(int i = 0; i < n; ++i) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		// dfs
		dfs(0,0);
		
		// 정답 출력
		System.out.println(ans);
	}
}