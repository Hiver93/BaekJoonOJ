import java.util.Scanner;

public class Main {
	public static long[][] b = {{1,1},{1,0}};
	public static long[][] calc(long[][] a, long[][] b){
		long[][] res = new long[2][2];
		for(int i = 0; i < a.length; ++i) {
			for(int j = 0; j < a.length; ++j) {
				for(int k = 0; k < a.length; ++k) {
					res[i][j] += (a[i][k] * b[j][k]);
					res[i][j] %= 1000000007;
				}
			}
		}
		return res;
	}
	
	public static long[][] func(long n) {
		if(n == 1) {
			return b;
		}
		long[][] res = func(n/2);
		res = calc(res,res);
		if(n % 2 == 1) {
			res = calc(res,b);
		}
		return res;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		if(n == 0) {
			System.out.println(0);
		}else if(n < 3){
			System.out.println(1);
		}else {
			System.out.println(func(n-1)[0][0]);
		}
	}
}