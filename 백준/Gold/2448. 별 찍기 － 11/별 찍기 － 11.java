import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static int[][] arr;
	public static void func(int y, int x, int cur) {
		if(cur == 3) {
			arr[y][x] = 1;
			arr[y][x+1] = 1;
			arr[y][x+2] = 1;
			arr[y][x+3] = 1;
			arr[y][x+4] = 1;
			arr[y+1][x+1] = 1;
			arr[y+1][x+3] = 1;
			arr[y+2][x+2] = 1;
			return;
		}
		int tmp = cur/2;
		for(int i = 0; i * tmp+ y < y + cur; ++i) {
			func(i * tmp+ y, i * tmp + x, tmp);
			func(y,i * tmp * 2 + x, tmp);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = n / 3;
		arr = new int[n][6*m];
		func(0,0,n);
		StringBuilder sb = new StringBuilder();
		for(int i = n-1; i >= 0; --i) {
			for(int j = 0; j < m*6; ++j) {
				sb.append(arr[i][j] == 1 ? '*' : ' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
