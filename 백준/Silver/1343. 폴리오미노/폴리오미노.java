import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String A = "AAAA";
		String B = "BB";
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		for(int i = 0; i < str.length(); ++i) {
			if(str.charAt(i) == '.') {
				if(cnt % 2 != 0) {
					System.out.println(-1);
					return;
				}
				for(int j = 0; j < cnt / 4; ++j) {
					sb.append(A);
				}
				for(int j = 0; j < cnt % 4 / 2; ++j) {
					sb.append(B);
				}
				cnt = 0;
				sb.append('.');
			}
			else {
				cnt++;
			}
		}
		if(cnt % 2 != 0) {
			System.out.println(-1);
			return;
		}
		for(int j = 0; j < cnt / 4; ++j) {
			sb.append(A);
		}
		for(int j = 0; j < cnt % 4 / 2; ++j) {
			sb.append(B);
		}
		System.out.println(sb);
	}
}