import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h, m;
		h = sc.nextInt();
		m = sc.nextInt();
		
		if(m < 45) {			
			m = 60 + (m - 45);
			if(h == 0) {
				h = 23;
			}
			else {
				h -= 1;
			}
		}
		else {
			m = m - 45;
		}
		
		System.out.printf("%d %d",h,m);		
	}
}
