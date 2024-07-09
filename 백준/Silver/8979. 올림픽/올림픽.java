import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), k = sc.nextInt();
		Integer[][] arr = new Integer[n][4];
		for(int i = 0; i < n; ++i) {
			arr[i][3] = sc.nextInt();
			for(int j = 0; j < 3; ++j) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		Arrays.sort(arr,new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				if(o1[0] < o2[0]) {
					return 1;
				}
				else if(o1[0] > o2[0]){
					return -1;
				}
				if(o1[1] < o2[1]) {
					return 1;
				}
				else if(o1[1] > o2[1]) {
					return -1;
				}
				if(o1[2] < o2[2]) {
					return 1;
				}
				else if(o1[2] > o2[2]) {
					return -1;
				}
				return 0;
			}
		});
		
		for(int i = 0; i < n; ++i) {
			if(arr[i][3] == k) {
				int cnt = 0;
				for(int j = i; j >= 0; --j) {
					if(arr[i].equals(arr[j])) {
						cnt++;
					}
				}
				System.out.println(i-cnt+1);
				return;
			}
		}
	}
	
}