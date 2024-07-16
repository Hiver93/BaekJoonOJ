import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int ans = 0;
		for(int i = 0; i < n; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		double d = ((double)n) * 0.15;
		d = Math.round(d);
		for(int i = (int)d; i < n -(int)d; ++i) {
			ans += arr[i];
		}
		System.out.println(Math.round(((double)ans) / (n-d*2)));
	}
}