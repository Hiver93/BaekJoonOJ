import java.util.Scanner;

public class Main {
	static int[][] arr = new int[101][101];
	static int v;
	static int e;
	static int ans = -1;
	static boolean[] check = new boolean[101];
	public static void func(int current) {
		ans++;
		check[current] = true;
		for(int i = 1; i < v+1; ++i) {
			if(arr[current][i] == 1&&!check[i])
				func(i);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		v = sc.nextInt();
		e = sc.nextInt();
		for(int i = 0; i < e; ++i) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		func(1);
		System.out.println(ans);
	}
}
