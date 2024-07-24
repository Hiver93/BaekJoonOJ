import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static Map<Character,Integer> m = Map.of('+',1,'-',1,'*',2,'/',2,'(',0,')',0);
	public static String fix(String str) {
		StringBuilder sb = new StringBuilder();
		Deque<Character> s = new LinkedList<>();
		for(int i = 0; i < str.length(); ++i) {
			char c = str.charAt(i);
			if(c <= 'Z' && 'A' <= c) {
				sb.append(c);
			}
			else {
				if(c == ')') {
					while(s.peekLast() != '(') {
						sb.append(s.removeLast());
					}
					s.removeLast();
				}
				else if(c == '(') {
					s.addLast(c);
				}
				else {
					while(!s.isEmpty() &&m.get(c) <= m.get(s.peekLast())) {
						sb.append(s.removeLast());
					}
					s.addLast(c);
				}
			}
			
		}
		while(!s.isEmpty()) {
			sb.append(s.removeLast());
		}
		return sb.toString();		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		
		System.out.println(fix(str));
	}
}