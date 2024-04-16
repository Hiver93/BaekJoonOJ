import java.util.Scanner;

public class Main {
	
	public static int[] makeLps(String str) {
		int[] lps = new int[str.length()];
		int i = 1;
		int len = 0;
		while(i < str.length()) {
			if(str.charAt(len) == str.charAt(i)) {
				len++;
				lps[i] = len;
				i++;
			}
			else {
				if(len == 0) {
					lps[i] = 0;
					i++;
				}
				else {
					len = lps[len - 1];
				}
			}
		}
		return lps;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		String str = sc.nextLine();
		int[] lps = makeLps(str);
		System.out.println(lps.length - lps[lps.length-1]);
	}
}
