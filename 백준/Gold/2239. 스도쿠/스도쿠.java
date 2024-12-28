import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int[][] arr = new int[9][9];
	static List<int[]> list = new ArrayList<>();
	
	static boolean check(int num, int y, int x) {
		for(int i = 0; i < 9; ++i) {
			if(arr[y][i] == num)
				return false;
			if(arr[i][x] == num)
				return false;
		}
		
		int r = y % 3;
		int c = x % 3;
		for(int i = y - r; i < y - r + 3; ++i) {
			for(int j = x - c; j < x - c + 3; ++j) {
				if(arr[i][j] == num)
					return false;
			}
		}
		
		return true;
	}
	
	static boolean func(int idx) {
		if(idx == list.size())
			return true;
		int y = list.get(idx)[0];
		int x = list.get(idx)[1];
		for(int i = 1; i < 10; ++i) {
			if(check(i,y,x)) {
				arr[y][x] = i;
				if(func(idx+1)) {
					return true;
				}
				arr[y][x] = 0;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 9; ++i) {
			String str = sc.next();
			for(int j = 0; j < 9; ++j) {
				arr[i][j] = str.charAt(j) - '0';
				if(arr[i][j] == 0)
					list.add(new int[] {i,j});
			}
		}
		func(0);
		for(int i = 0; i < 9; ++i) {
			for(int j = 0; j < 9; ++j) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}