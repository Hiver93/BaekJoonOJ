import java.util.Scanner;

public class Main {
	static int n, row, col;
	static int ans = 0;
	public static void func(int start, int i, int j, int n) {
		if(n == 1) {
			if(row%2 == 0 && col%2 == 0)
				ans = start;
			else if(row%2 == 0 && col%2 == 1)
				ans = start+1;
			else if(row%2 == 1 && col%2 == 0)
				ans = start+2;
			else
				ans = start+3;
			return;
		}
		if(i + n <= row && j + n <= col) {
			func(start + n * n * 3, i+n,j+n, n);
			return;
		}
		else if(i + n <= row) {
			func(start + n * n * 2,i+n,j, n);
			return;
		}
		else if(j + n <= col) {
			func(start + n * n, i, j+n, n);
			return;
		}
		func(start,i,j,n/2);

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int len = 2;
		for(int i = 1; i < n; ++i) {
			len *= 2;
		}
		row = sc.nextInt();
		col = sc.nextInt();
		if(n == 1) {
			if(row == 0 && col == 0)
				System.out.println(0);
			else if(row == 0 && col == 1)
				System.out.println(1);
			else if(row == 1 && col == 0)
				System.out.println(2);
			else
				System.out.println(3);
		}
		else {
			func(0,0,0,len);
			System.out.println(ans);
		}
	}
}
