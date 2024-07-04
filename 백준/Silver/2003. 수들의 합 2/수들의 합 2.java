import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt(), d = sc.nextInt();
		int arr[] = new int[n+1];
		int ans = 0;
		
		for(int i = 1; i < n+1; ++i) {
			arr[i] = arr[i-1] + sc.nextInt();
		}
		
		int st= 0, ed = 1;
		while(ed < n + 1) {
			if(arr[ed] - arr[st] == d) {
				ans++;
			}
			if(arr[ed] - arr[st] <= d)
				ed++;
			else
				st++;
			if(st == ed)
				ed++;
		}
		System.out.println(ans);
	}
}