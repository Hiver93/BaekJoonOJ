import java.util.Scanner;

public class Main {
	static int[][] arr;
	static int r;
	static int c;
	static void func(int row, int col) {
		if(arr[row][col] == 0)
			return;
		arr[row][col] = 0;
		if(row + 1 < r) {
			func(row+1,col);
		}
		if(col + 1 < c) {
			func(row, col + 1);
		}
		if(0 <= row - 1) {
			func(row-1, col);
		}
		if(0 <= col - 1) {
			func(row, col - 1);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; ++tc) {
			r = sc.nextInt();
			c = sc.nextInt();
			int n = sc.nextInt();
			arr = new int[r][c];
			int ans = 0;
			for(int i = 0; i < n; ++i) {
				arr[sc.nextInt()][sc.nextInt()] = 1;
			}
			for(int i = 0; i < r; ++i) {
				for(int j = 0; j < c; ++j) {
					if(arr[i][j] == 1) {
						func(i,j);
						ans++;					
					}
				}
			}
	
			System.out.println(ans);
		}
	}
}