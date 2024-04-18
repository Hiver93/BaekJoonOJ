import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] arr = new long[n];
		long ans = 0;
		for(int i = 0; i < n; ++i) {
			arr[i] = sc.nextLong();
		}
		Arrays.sort(arr);
		for(int i = 0; i < n; ++i) {
			long tmp = arr[i] * (n - i); 
			if(ans < tmp) {
				ans = tmp;
			}
		}
		System.out.println(ans);
	}
}