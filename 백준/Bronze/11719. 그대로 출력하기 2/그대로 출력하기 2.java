import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String str;
		while(sc.hasNextLine()) {
			sb.append(sc.nextLine());
            sb.append('\n');
		}
		System.out.println(sb);
	}
}