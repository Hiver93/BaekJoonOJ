import java.util.Scanner;

public class Main {
	static int n;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	public static void func(int current, int check) {
		if(current == n) {
			for(int i = 0; i < n; ++i) {
				sb.append(result[i]+1);
				sb.append(" ");
			}
			sb.append("\n");				
		}
		for(int i = 0; i < n; ++i) {
			if((check & (1 << i)) != 0)
				continue;
			result[current] = i;
			func(current+1, check | (1<<i));
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n= sc.nextInt();
		result = new int[n];
		func(0,0);
		System.out.println(sb);
	}
}
