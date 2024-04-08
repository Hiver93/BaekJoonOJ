import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	static int arr[] = new int[26];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		for(int i = 0; i < str.length(); ++i) {
			arr[str.charAt(i)-'a']++;
		}
		System.out.println(Arrays.stream(arr).mapToObj(Integer::toString).collect(Collectors.joining(" ")));
	}
}
