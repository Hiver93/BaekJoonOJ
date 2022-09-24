import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] arr = new char[100];
		int top = 0;
		String str = sc.nextLine();
		while(!str.equals(".")) {
			boolean b = true;
			for(int i = 0; i < str.length(); ++i) {
				if(str.charAt(i) == '('||str.charAt(i) == '[') {
					arr[top++] = str.charAt(i);
				}
				else if(str.charAt(i) == ')') {
					if(top == 0||arr[top-1] == '[') {
						b = false;
						break;
					}
					top--;
				}
				else if(str.charAt(i) == ']') {
					if(top == 0||arr[top-1] == '(') {
						b = false;
						break;
					}
					top--;
				}
			}
			if(b&&top == 0)
				System.out.println("yes");
			else
				System.out.println("no");
			str = sc.nextLine();
			top = 0;
		}
	}
}