import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static char[] cArr;
	static char[] result;
	static int n;
	static int m;
	static int checkA = 0;
	static int checkB = 0;
	static StringBuilder sb = new StringBuilder();
	public static void func(int rIdx, int aIdx) {
		if(rIdx == n) {
			if(checkA < 1||checkB<2)
				return;
			for(int i = 0; i < n; ++i) {
				sb.append(result[i]);
			}
			sb.append("\n");
			return;
		}
		if(aIdx == m)
			return;
		
		result[rIdx] = cArr[aIdx];
		if(result[rIdx] == 'a'||result[rIdx] == 'e'||result[rIdx] == 'i'||result[rIdx] == 'o'||result[rIdx] == 'u') {
			checkA++;
			func(rIdx+1,aIdx+1);
			checkA--;
			func(rIdx,aIdx+1);
		}
		else {
			checkB++;
			func(rIdx+1,aIdx+1);
			checkB--;
			func(rIdx,aIdx+1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		cArr = new char[m];
		result = new char[n];
		for(int i = 0; i < m; ++i) {
			cArr[i] = sc.next().charAt(0);
		}		
		Arrays.sort(cArr);
		func(0,0);
		System.out.println(sb);
	}
}
