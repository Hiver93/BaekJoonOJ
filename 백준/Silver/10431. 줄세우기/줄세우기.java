import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc = 1; tc <= t; ++tc) {
			int[] arr = new int[20];
			int ans = 0;
			sc.nextInt();
			for(int i = 0; i < 20; ++i) {
				arr[i] = sc.nextInt();
			}
			
			for(int i = 18; i >= 0; --i) {
				int j = i;
				int v = arr[i];
				for(; j < 19; ++j) {
					if(arr[j+1] < v) {
						arr[j] = arr[j+1];
						ans++;
					}
					else
						break;
				}
				arr[j] = v;
			}
			System.out.println(tc + " " + ans);
		}
		
	}
}