import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(), m = sc.nextInt();
		int sum = 0, min = 2147483647;
		for(int i = m ; i >= n; --i) {
			for(int j = 100; i <= j*j; --j) {
				if(i == j * j) {
					sum += i;
					if(i < min)
						min = i;
				}
			}
		}
		System.out.println(sum == 0 ? -1 : sum+ "\n"+min);
		
	}
}