import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		n = 1000 - n;
		int[] arr = {500,100,50,10,5,1};
		int ans = 0;
		for(int i = 0; i < 6; ++i) {
			ans += n / arr[i];
			n = n % arr[i];
		}
		System.out.println(ans);
	}
}