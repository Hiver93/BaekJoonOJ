import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int d = sc.nextInt();
		int n = sc.nextInt();
		String str = sc.next();
		int cnt = 0;
		d = 2 * d + 1;
		char last = 'O';
		int ans = 0;
		for(int i = 0; i < n; ++i) {
			if(str.charAt(i) == last) {
				if(last == 'O') {
					for(; i < n; ++i) {
						if(str.charAt(i) == 'I') {
							cnt = 1;
							last = 'I';
							break;
						}
					}
				}
				else {
					cnt = 1;
				}
				continue;
			}
			cnt++;
			last = str.charAt(i);
			if(cnt == d) {
				ans++;
				cnt -= 2;
			}
		}
		System.out.println(ans);
	}
}