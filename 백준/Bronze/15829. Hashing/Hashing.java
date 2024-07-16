import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.next();
		String str = sc.next();
		long sum = 0;
		long n = 1;
		
		for(int i = 0; i < str.length(); ++i) {
			sum += ((str.charAt(i)-'a'+1)*n);
			n *= 31;
		}
		
		System.out.println(sum % 1234567891);
	}
}