import java.util.Scanner;

class Node{
	public int cCount = 0;
	public Node[] nums = new Node[10];
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 0; tc < T; ++tc) {
			int n = sc.nextInt();
			boolean ans = true;
			Node root = new Node();
			String[] sArr = new String[n];
			for(int i = 0; i < n; ++i) {				
				String str = sc.next(); 
				sArr[i] = str;
				Node node = root;
				for(int j = 0; j < str.length(); ++j) {					
					if(node.nums[str.charAt(j)-'0'] == null) {
						node.nums[str.charAt(j)-'0'] = new Node();
						node.cCount++;
						node = node.nums[str.charAt(j)-'0'];
					}
					else {
						node.cCount++;
						node = node.nums[str.charAt(j)-'0'];
					}
				}
			}
			
			for(int i= 0; i< n; ++i) {
				Node node = root;
				for(int j = 0; j < sArr[i].length(); ++j) {
					node = node.nums[sArr[i].charAt(j)-'0'];
				}
				if(node.cCount != 0)
					ans = false;
			}
			
			if(ans)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
