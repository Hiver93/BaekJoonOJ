import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		int[] arr = new int[50001];
		arr[1] = 1;
		for(int i = 2; i <= n; ++i) {
			int min = 4;
			for(int j = 1; j * j <= i; ++j) {
				if(arr[i - (j * j)] < min) {
					min = arr[i - (j * j)];
				}
			}
			arr[i] = min + 1;
		}
		System.out.println(arr[n]);
	}
}