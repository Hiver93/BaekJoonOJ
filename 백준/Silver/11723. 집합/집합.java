import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int check = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; ++i) {
			String str = sc.next();
			switch (str) {
			case "add":
				check |= (1 << sc.nextInt());
				break;
			case "remove":
				check &= ~(1 << sc.nextInt());				
				break;
			case "check":
				if((check &(1 << sc.nextInt())) != 0) {
					sb.append(1);
					sb.append("\n");					
				}
				else {
					sb.append(0);
					sb.append("\n");
				}
				break;
			case "toggle":
				check ^= (1 << sc.nextInt());
				break;
			case "all":
				check |= 2147483647;
				break;
			case "empty":
				check = 0;
				break;
			}			
		}
		System.out.println(sb);
	}
}
