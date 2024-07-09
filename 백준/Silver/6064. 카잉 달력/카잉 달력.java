import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- != 0){		
			int n = sc.nextInt(), m = sc.nextInt(), x = sc.nextInt()-1, y = sc.nextInt()-1;
			if(n < m) {
				int tmp = n;
				n = m;
				m = tmp;
				tmp = x;
				x = y;
				y = tmp;
			}
			if(n < x || m < y) {
				System.out.println(-1);
				break;
			}	
			int cnt = x;
			int a= x, b = m == 0 ? 0 : x % m;
			int ans = -1;
			do {
				if(b == y) {
					ans = cnt+1;
					break;
				}
				cnt += n;
				b += (n-m);
				b = b % m;
			}while(cnt <= n*m);
			System.out.println(ans);
		}
	}
}