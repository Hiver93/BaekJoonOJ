import java.util.Scanner;

public class Main {
	static int targetR;
	static int targetC;
	public static int func(int len, int r, int c, int num) {
		if(len == 2) {
			if(r < targetR && c < targetC)
				return num + 3;
			else if(r < targetR)
				return num + 2;
			else if(c < targetC)
				return num + 1;
			else
				return num;
		}
		
		if(r + len/2 <= targetR && c + len/2 <= targetC)
			return func(len / 2,r+len/2,c+len/2, num + len/2 * len/2 * 3);
		else if(r + len/2 <= targetR)
			return func(len / 2, r + len/2 , c, num + len/2 * len/2 * 2);
		else if(c + len/2 <= targetC)
			return func(len / 2, r, c + len/2, num + len/2 * len/2);
		else
			return func(len / 2, r, c, num);
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		targetR = sc.nextInt();
		targetC = sc.nextInt();
		int len = 2;
		for(int i = 1; i < n; ++i) {
			len*=2;
		}
		System.out.println(func(len,0,0,0));
	}
}
