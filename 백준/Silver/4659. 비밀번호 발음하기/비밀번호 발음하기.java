import java.util.Scanner;

public class Main {
	
	static char[] mos = {'a','e','i','o','u'}; 
	
	static boolean isMo(char c) {
		for(int i = 0; i < 5; ++i) {
			if(mos[i] == c) {
				return true;
			}
		}
		return false;
	}
	
	static boolean isEnd(String str) {
		return str.equals("end");
	}
	
	static boolean haveMo(String str) {
		for(int i = 0; i< str.length(); ++i) {
			for(int j = 0; j < 5; ++j) {
				if(str.charAt(i) == mos[j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	static boolean noThree(String str) {
		for(int i = 0; i< str.length(); ++i) {
			char c = str.charAt(i);
			boolean mo = isMo(c);
			int cnt = 0;
			int j = i;
			while(j < str.length() && isMo(str.charAt(j)) == mo) {
				cnt++;
				if(cnt == 3)
					return false;
				j++;
			}
		}
		return true;
	}
	
	static boolean noTwo(String str) {
		for(int i = 0; i< str.length(); ++i) {
			char c = str.charAt(i);
			int cnt = 0;
			int j = i;
			while(j < str.length() && str.charAt(j) == c) {
				cnt++;
				if(cnt == 2) {
					if(c != 'e' && c != 'o')
						return false;
				}
				if(cnt == 3)
					return false;
				j++;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String OK = " is acceptable.";
		String NOT_OK = " is not acceptable.";
		StringBuilder sb = new StringBuilder();
		while(true) {
			String str = sc.next();
			if(isEnd(str)) {
				break;
			}
			sb.append('<').append(str).append('>');
			if(!haveMo(str)) {
				sb.append(NOT_OK).append('\n');
				continue;
			}
			if(!noThree(str)) {
				sb.append(NOT_OK).append('\n');
				continue;
			}
			if(!noTwo(str)) {
				sb.append(NOT_OK).append('\n');
				continue;
			}
			sb.append(OK).append('\n');
		}
		System.out.println(sb);
	}
}