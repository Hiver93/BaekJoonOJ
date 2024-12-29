import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Trie{
		Trie[] arr = new Trie[26];
	}
	static Trie trie = new Trie();
	
	static void insert(String str) {
		Trie cur = trie;
		for(int i = 0; i < str.length(); ++i) {
			char c = str.charAt(i);
			if(cur.arr[c-'a'] == null) {
				cur.arr[c-'a'] = new Trie();
			}
			cur = cur.arr[c-'a'];
		}
	}
	
	static boolean check(String str) {
		Trie cur = trie;
		for(int i = 0; i < str.length(); ++i) {
			char c = str.charAt(i);
			if(cur.arr[c-'a'] == null) {
				return false;
			}
			cur = cur.arr[c-'a'];
		}
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		int ans = 0;
		for(int i = 0; i < n; ++i) {
			insert(br.readLine());
		}
		for(int i = 0; i < m; ++i) {
			if(check(br.readLine())) {
				ans++;
			}
		}
		System.out.println(ans);
	}
}