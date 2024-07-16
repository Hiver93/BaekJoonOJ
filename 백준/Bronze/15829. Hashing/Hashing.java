import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.next();
		String str = sc.next();
		long sum = 0;
		long n = 1;
		
		for(int i = 0; i < str.length(); ++i) {
			long tmp = str.charAt(i)-'a'+1;
			sum += (long)(tmp * n) % 1234567891;
			sum %= 1234567891;
			n *= ((long)31);
			n %= 1234567891l;
		}
		System.out.println(sum % 1234567891l);
	}
}