import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		for(int i = 0; i < 3; ++i) {
			String str = sc.next();
			if(str.charAt(0) <= '9' && '0' <= str.charAt(0)) {
				num = Integer.valueOf(str);
			}
			num++;
		}
		if(num % 3 != 0 && num % 5 != 0) {
			System.out.println(num);
		}
		else {
			if(num % 3 == 0) {
				System.out.print("Fizz");
			}
			if(num % 5 == 0) {
				System.out.print("Buzz");
			}
		}
	}
}