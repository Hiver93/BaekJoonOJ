import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[6];
		int ans = 0;
		int n = sc.nextInt();
		int sum = 0;
		for(int i = 0; i < 6; ++i) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		int t = sc.nextInt(), p = sc.nextInt();
		for(int i = 0; i < 6; ++i) {
			if(arr[i] == 0)
				continue;
			if(arr[i] < t) {
				ans++;
			}
			else {
				ans += ((arr[i] / t) + ((arr[i] % t == 0) ? 0 : 1));
			}
		}
		System.out.println(ans);
		System.out.println(sum / p + " " + sum % p);
		
		
	}
}