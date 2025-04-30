import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] dr = {0,1,1,0,1,0,-1,0};
	static int[] dc = {1,0,1,0,0,1,0,-1};
	static int[][] arr;
	static int[][] r;
	static int[][] d;
	static int[][] rd;
	
	static boolean boundOk(int y, int x) {
		return 0 <= y && 0 <= x && y < n && x < n && arr[y][x] == 0;
	}
	
	static boolean rOk(int y , int x) {
		return boundOk(y,x - 1) && boundOk(y,x); 
	}
	
	static boolean dOk(int y, int x) {
		return boundOk(y,x) && boundOk(y-1,x);
	}
	
	static boolean rdOk(int y, int x) {
		return boundOk(y,x) && boundOk(y-1,x-1) && boundOk(y-1,x) && boundOk(y, x-1);
	}
	
	static int rdSum(int y, int x) {
		return r[y-1][x-1] + d[y-1][x-1] + rd[y-1][x-1]; 
	}
	
	static int rSum(int y, int x) {
		return r[y][x-1] + rd[y][x-1];
	}
	
	static int dSum(int y, int x) {
		return d[y-1][x] + rd[y-1][x];
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.valueOf(br.readLine());
		arr = new int[n][n];
		int ans = 0;
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; ++j) {
				arr[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		
		r = new int[n][n];
		d = new int[n][n];
		rd = new int[n][n];
		r[0][1] = 1;
		int j = 2;
		for(int i = 0; i < n; ++i) {
			for(; j < n; ++j) {
				if(rOk(i,j)) {
					r[i][j] = rSum(i,j);
				}
				if(dOk(i,j)) {
					d[i][j] = dSum(i,j);
				}
				if(rdOk(i,j)) {
					rd[i][j] = rdSum(i,j);
				}
			}
			j = 0;
		}
		System.out.println(r[n-1][n-1] + d[n-1][n-1] + rd[n-1][n-1]);
	}
}