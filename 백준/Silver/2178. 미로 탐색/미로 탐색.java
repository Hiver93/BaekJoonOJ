import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n][m];
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		boolean[][] check = new boolean[n][m];
		Queue<Integer[]> q = new LinkedList<>();
		for(int i = 0; i < n; ++i) {
			String str = sc.next();
			for(int j = 0; j < m; ++j) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		
		check[0][0] = true;
		q.add(new Integer[]{0,0,0});
		while(!q.isEmpty()) {
			int row = q.peek()[0];
			int col = q.peek()[1];
			int count = q.poll()[2];
			if(row == n-1&&col == m-1) {
				System.out.println(count+1);
				break;
			}
			for(int i= 0; i < 4; ++i) {
				if(row+dr[i]<0||n<=row+dr[i]||col+dc[i] < 0||m<=col+dc[i]||check[row+dr[i]][col+dc[i]]||arr[row+dr[i]][col+dc[i]] == 0)
					continue;
				check[row+dr[i]][col+dc[i]] = true;
				q.add(new Integer[] {row+dr[i],col+dc[i],count+1});
				
			}
		}
	}
}
