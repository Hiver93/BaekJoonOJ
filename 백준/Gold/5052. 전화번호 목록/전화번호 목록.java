import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class Node{
	public String data;
	public int cCount = 0;
	public Node[] nums = new Node[10];
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; ++tc) {
			int n = Integer.parseInt(br.readLine());
			boolean ans = true;
			Node root = new Node();
			String[] sArr = new String[n];
			for(int i = 0; i < n; ++i) {
				sArr[i] = br.readLine();
			}
			for(int i = 0; i < n; ++i) {				
				String str = sArr[i];
				Node node = root;
				for(int j = 0; j < str.length(); ++j) {					
					if(node.nums[str.charAt(j)-'0'] == null) {
						node.nums[str.charAt(j)-'0'] = new Node();		
						node.cCount++;
						node = node.nums[str.charAt(j)-'0'];
					}
					else {						
						node = node.nums[str.charAt(j)-'0'];
						node.cCount++;
					}
					if(node.data != null) {
						ans = false;
						break;
					}
				}
				if(node.cCount != 0) {
					ans = false;
				}
				if(!ans)
					break;
				node.data = str;
			}
			
			if(ans)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
