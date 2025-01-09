import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		int num = 1;
		String numStr = "1";
		int idx = 0;
		int i = 0;
		while(i < str.length()) {
			if(numStr.length() == idx) {
				idx = 0;
				num++;
				numStr = String.valueOf(num);
			}
			if(numStr.charAt(idx) == str.charAt(i)) {
				i++;
			}
			idx++;
		}
		System.out.println(num);
	}
}