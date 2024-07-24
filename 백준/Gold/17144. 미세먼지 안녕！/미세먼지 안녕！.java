import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m, t;
	static int[][] arr;
	static List<Integer> cy = new ArrayList<>();
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static boolean boundOk(int y, int x) {
		return 0 <= y && 0 <= x && y < n && x < m;
	}
	
	static int[][] clean(int[][] last){
		int y = cy.get(0);
		for(int i = y; i > 0; --i) {
			last[i][0] = last[i-1][0];
		}
		for(int i = 0; i < m-1; ++i) {
			last[0][i] = last[0][i+1];
		}
		for(int i = 0; i < y; ++i) {
			last[i][m-1] = last[i+1][m-1];
		}
		for(int i = m-1; i > 1; --i) {
			last[y][i] = last[y][i-1];
		}
		last[y][1] = 0;
		
		y = cy.get(1);
		
		for(int i = y; i < n -1; ++i) {
			last[i][0] = last[i+1][0]; 
		}
		for(int i = 0; i < m-1; ++i) {
			last[n-1][i] = last[n-1][i+1];
		}
		for(int i = n-1; i > y; --i) {
			last[i][m-1] = last[i-1][m-1];
		}
		for(int i = m-1; i > 1; --i) {
			last[y][i] = last[y][i-1];
		}
		last[y][1] = 0;
		return last;
	}
	
	static int[][] next(int[][] last){
		int[][] res = new int[n][m];
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < m; ++j) {
				if(arr[i][j] == -1)
					continue;
				int tmp = 0;
				for(int k = 0; k < 4; ++k) {
					int ny = i + dr[k];
					int nx = j + dc[k];
					if(boundOk(ny,nx) && arr[ny][nx] != -1) {
						tmp += arr[i][j] / 5;
						res[ny][nx] += arr[i][j] / 5;
					}
				}
				res[i][j] += arr[i][j] - tmp;
			}
		}		
		res = clean(res);
		res[cy.get(0)][0] = -1;
		res[cy.get(1)][0] = -1;
		
		return res;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		t = Integer.valueOf(st.nextToken());
		arr = new int[n][m];
		int ans = 0;
		
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; ++j) {
				arr[i][j] = Integer.valueOf(st.nextToken());
				if(arr[i][j] == -1) {
					cy.add(i);
				}
			}
		}
		
		for(int i = 0; i < t; ++i) {
			arr = next(arr);
		}
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < m; ++j) {
				if(arr[i][j] != -1) {
					ans += arr[i][j];
				}
					
			}
		}
		System.out.println(ans);
	}
}