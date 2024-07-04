import java.util.Scanner;

public class Main {
	static final int E = 15, S = 28, M = 19;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int de = sc.nextInt(), ds = sc.nextInt(), dm = sc.nextInt();
		int e = 1, s = 1, m = 1;
		for(int i = 0; i < 7980; ++i) {
			if(e == de && s == ds && dm == m) {
				System.out.println(i+1);
				return;
			}
			e++; s++; m++;
			if(e > E)
				e = 1;
			if(s > S)
				s = 1;
			if(m > M)
				m = 1;
		}
	}
}