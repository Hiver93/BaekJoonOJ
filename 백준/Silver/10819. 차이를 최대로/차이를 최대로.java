import java.util.Scanner;

public class Main {
	static int n;
	static int[] arr;
	static int[] result; 
	static int ans = 0;
	
	public static void func(int current, int check) {		
		if(current == n) {
			int sum = 0;
			for(int i = 1; i < n; ++i) {
				sum += Math.abs(arr[result[i-1]] - arr[result[i]]);
			}
			if(ans < sum)
				ans = sum;
			return;
		}
		for(int i = 0; i < n; ++i) {
			if((check & (1 << i)) != 0)
				continue;
			result[current] = i;
			func(current+1,check | (1<<i));
		}		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];		
		result = new int[n];
		for(int i = 0; i < n; ++i) {
			arr[i] = sc.nextInt();
		}			
		
		func(0,0);
		System.out.println(ans);				
	}
}