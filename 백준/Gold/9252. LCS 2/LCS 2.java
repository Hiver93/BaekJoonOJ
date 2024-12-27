import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	static int[] memo1;
	static int[] memo2;
	static Map[] idxMemo;
	static char[] ansArr;
	static String str1;
	static String str2;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		str1 = sc.next();
		str2 = sc.next();
		Deque<Character> stack = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		memo1 = new int[str1.length()];
		memo2 = new int[str2.length()];
		idxMemo = new Map[str2.length()];
		
		for(int i = 0; i < str2.length(); ++i) {
			idxMemo[i] = new HashMap<Integer,Integer>();
		}
		
		for(int i = 0; i < str2.length(); ++i) {
			char ch = str2.charAt(i);
			int max = 0;
			for(int j = 0; j < str1.length(); ++j) {
				int tmp = memo1[j];
				if(memo1[j] <= max && str1.charAt(j) == str2.charAt(i)) {
					memo1[j] = max + 1;
					if(memo2[i] < max +1) {
						memo2[i] = max + 1;
						if(!idxMemo[i].containsKey(max+1))
							idxMemo[i].put(max+1, j);
					}
				}
				if(max < tmp) {
					max = tmp;
				}
			}
		}
		int ans = 0;
		int idx2 = -1;
		int idx1 = -1;
		for(int i = 0; i < str2.length(); ++i) {
			if(ans < memo2[i]) {
				ans = memo2[i];
				idx2 = i;
			}
		}
		int cnt = ans;
		if(ans == 0) {
			System.out.println(0);
			return;
		}
		for(int i = str1.length()-1; i >= 0; --i) {
			if(str2.charAt(idx2) == str1.charAt(i)) {
				idx1 = i;
				break;
			}
		}
		
		stack.addLast(str2.charAt(idx2));
		cnt--;
		for(int i = idx2-1; i >= 0; --i) {
			if(idxMemo[i].containsKey(cnt)) {
				if((Integer)idxMemo[i].get(cnt) < idx1) {
					idx1 = (Integer)idxMemo[i].get(cnt);
					cnt--;
					stack.addLast(str2.charAt(i));
				}
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.removeLast());
		}
        System.out.println(ans);
		System.out.println(sb);
	}
}