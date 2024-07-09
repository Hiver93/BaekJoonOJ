import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt(), w = sc.nextInt(), n = sc.nextInt(), m = sc.nextInt();
		System.out.println(
				(h / (n+1) + ((h % (n+1) == 0) ? 0 : 1)) *
				(w / (m+1) + ((w % (m+1) == 0) ? 0 : 1))
				);
	}
}
