import java.util.Scanner;

public class Main {
	static int r;
	static int c;
	static char[][] arr;
	static int ans = 0;
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	static boolean[] alph = new boolean[26];
	
	public static void func(int dis, int row, int col) {
		if(ans < dis)
			ans = dis;		
		
		alph[arr[row][col]-'A'] = true;
		for(int i = 0; i < 4; ++i) {
			if(row + dr[i] < 0||r <= row + dr[i]||col+dc[i] < 0||c <= col+dc[i])
				continue;
			if(alph[arr[row+dr[i]][col+dc[i]]-'A'])
				continue;
			func(dis+1,row+dr[i],col+dc[i]);
		}
		alph[arr[row][col]-'A'] = false;
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		arr = new char[r][c];
		
		for(int i = 0; i < r; ++i) {
			String str = sc.next();
			for(int j = 0; j < c; ++j) {
				arr[i][j] = str.charAt(j);
			}
		}
		func(1,0,0);
		
		System.out.println(ans);			
	}
}
