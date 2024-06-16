import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] token = sc.nextLine().split(" ");
		int n = Integer.valueOf(token[0]), m = Integer.valueOf(token[1]);
		int ans = 0;
		for(int i = 0 ;i < m; ++i) {
			String str = sc.nextLine();
			int v = 0;
			for(int j = 0; j < str.length(); ++j) {
				if('A' <= str.charAt(j) && str.charAt(j) <= 'Z') {
					v+=4;
				}
				else if(str.charAt(j) == ' ') {
					v+=1;
				}
				else {
					v+=2;
				}
			}
			if(v <= n)
				ans++;
		}
		System.out.println(ans);
	}
}