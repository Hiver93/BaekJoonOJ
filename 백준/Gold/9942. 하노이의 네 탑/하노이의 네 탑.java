import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 1;
		while(sc.hasNext()) {
			int n = sc.nextInt();
			long ans = 1;
			int current = 1;
			out:for(int i = 1; i < n; ++i) {
				for(int j = 0; j < i+1; ++j) {
					if(current == n)
						break out;
					current++;
					ans += ((long)1 << i);
				}
			}
			System.out.printf("Case %d: %d\n",tc++,ans);
		}
	}
}
