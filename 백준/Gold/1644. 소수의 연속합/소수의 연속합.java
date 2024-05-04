import java.util.Scanner;

public class Main {
	static boolean[] p = new boolean[4000001];
	
	static void findP() {
		for(int i = 2; i * i <= 4000000; ++i) {
			if(p[i] == true)
				continue;
			for(int j = 2; i * j <= 4000000; ++j) {
				p[i*j] = true;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int target = sc.nextInt();
		findP();
		int st = 2;
		int sum = 0;
		int ans = 0;
		for(int i = 2; i <= target; ++i) {
			if(p[i])
				continue;
			sum += i;
			while(st <= i && target <= sum) {
				if(target == sum)	
					ans++;
				sum -= st;
				do {
					st++;
				}
				while(p[st] && st < i);
			}
		}		
		System.out.println(ans);
	}
}