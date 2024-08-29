import java.util.Scanner;

public class Main {
	
	static int[] arr;
	static int[] l;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		if(n == 1) {
			System.out.println(0);
			System.out.println(1);
			return;
		}
		arr = new int[n+1];
		l = new int[n+1];
		for(int i = 2; i < n+1; ++i) {
			int tmp = arr[i-1] + 1;
			int last = i-1;
			if(i % 3 == 0 && arr[i/3] + 1 < tmp) {
				tmp = arr[i/3]+1;
				last = i/3;
			}
			if(i % 2 == 0 && arr[i/2] + 1 < tmp) {
				tmp = arr[i/2]+1;
				last = i/2;
			}
			arr[i] = tmp;
			l[i] = last;
		}
		
		int tmp = l[n];
		sb.append(arr[n]).append('\n');
		sb.append(n).append(' ');
		while(tmp != 1) {
			sb.append(tmp).append(' ');
			tmp = l[tmp];
		}
		sb.append(tmp);
		System.out.println(sb);
	}
}