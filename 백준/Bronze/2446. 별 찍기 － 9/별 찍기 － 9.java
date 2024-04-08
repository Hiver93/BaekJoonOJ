import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder[] sbs = new StringBuilder[n];
		for(int i = 0; i < n; ++i) {
			sbs[i] = new StringBuilder();
			for(int j = 0; j < i; ++j) {
				sbs[i].append(' ');
			}
			for(int j = 0; j < n + n - (i*2) - 1; ++j) {
				sbs[i].append('*');
			}
		}
		for(int i =0 ; i < n; ++i) {
			System.out.println(sbs[i]);
		}
		for(int i = n-2; i >= 0; --i) {
			System.out.println(sbs[i]);
		}
	}
}	