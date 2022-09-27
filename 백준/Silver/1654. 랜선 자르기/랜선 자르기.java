import java.util.Scanner;

public class Main {
	static long k;
	static long n;
	static long[] arr;
	static long ans = 0;
	public static void func(long left, long right) {
		long sum = 0;
		long mid = (left + right)/2;
		for(int i = 0; i < k; ++i) {
			sum += arr[i] / mid;
		}
		if(n <= sum) {
			if(ans < mid)
				ans = mid;
		}
		if(right <= left)
			return;
		if(sum < n) {
			func(left, mid);
		}
		else if(n <= sum) {
			if(ans < mid)
				ans = mid;
			func(mid+1,right);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();
		n = sc.nextInt();
		arr = new long[(int)k];
		long max = 0;
		for(int i = 0; i < k; ++i) {
			arr[i] = sc.nextInt();
			if(max < arr[i])
				max = arr[i];
		}
		func(1,max);
		System.out.println(ans);
	}
}