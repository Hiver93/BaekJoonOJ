import java.util.Scanner;

public class Main {
	static int ans = 2147483647;
	public static void func(long cur, long d, int depth) {
		if(d < cur)
			return;
		if(cur == d) {
			if(depth < ans)
				ans = depth;
			return;
		}
		func(cur*2, d, depth+1);
		func(cur*10+1, d, depth+1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextInt(), b = sc.nextInt();
		func(a,b,1);
		System.out.println(ans == 2147483647 ? -1 : ans);
	}
}
