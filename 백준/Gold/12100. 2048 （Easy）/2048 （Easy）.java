import java.util.Scanner;

public class Main {
	
	static int ans = 0;
	static int n;
	public static void func(int[][] arr, int current, int direct) {
		if(current == 6) {
			for(int i = 0; i < n; ++i) {
				for(int j = 0; j < n; ++j) {
					if(arr[i][j] != 0&&ans < arr[i][j]) {
						ans = arr[i][j];
					}
				}
			}
			return;
		}
		int[][] temp = new int[n][n];
		boolean[][] check = new boolean[n][n];
		// 좌로 밀착
		if (direct == 0) {
			for(int i = 0; i < n; ++i) {
				int idx = -1;
				for(int j = 0; j < n; ++j) {
					if(arr[i][j] != 0) {
						temp[i][++idx] = arr[i][j];
						if(idx != 0&&!check[i][idx-1]&&temp[i][idx-1] == arr[i][j]) {
							temp[i][--idx] = (arr[i][j]<<1);
							check[i][idx] = true;
							temp[i][idx+1] = 0;
						}
					}
				}
			}
		// 상으로 밀착
		} else if (direct == 1) {
			for(int i = 0; i < n; ++i) {
				int idx = -1;
				for(int j = 0; j < n; ++j) {
					if(arr[j][i] != 0) {
						temp[++idx][i] = arr[j][i];
						if(idx != 0&&!check[idx-1][i]&&temp[idx-1][i] == arr[j][i]) {
							temp[--idx][i] = (arr[j][i]<<1);
							check[idx][i] = true;
							temp[idx+1][i] = 0;
						}
					}
				}
			}
			// 우로 밀착
		} else if (direct == 2) {
			for(int i = 0; i < n; ++i) {
				int idx = n;
				for(int j = n-1; j >= 0; --j) {
					if(arr[i][j] != 0) {
						temp[i][--idx] = arr[i][j];
						if(idx != n-1&&!check[i][idx+1]&&temp[i][idx+1] == arr[i][j]) {
							temp[i][++idx] = (arr[i][j]<<1);
							check[i][idx] = true;
							temp[i][idx-1] = 0;
						}
					}
				}
			}
		} else {
			for(int i = 0; i < n; ++i) {
				int idx = n;
				for(int j = n-1; j >= 0; --j) {
					if(arr[j][i] != 0) {
						temp[--idx][i] = arr[j][i];
						if(idx != n-1&&!check[idx+1][i]&&temp[idx+1][i] == arr[j][i]) {
							temp[++idx][i] = (arr[j][i]<<1);
							check[idx][i] = true;
							temp[idx-1][i] = 0;
						}
					}
				}
			}
		}
		
		for(int i = 0; i < 4; ++i) {
			func(temp,current+1,i);
		}
	}
	
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[][] arr = new int[n][n];
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < n; ++j) {
				arr[i][j] = sc.nextInt();
			}
		}
		for(int i = 0; i < 4; ++i) {
			func(arr,1,i);
		}
		System.out.println(ans);
	}
}
