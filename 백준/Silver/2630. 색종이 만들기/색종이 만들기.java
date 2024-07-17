import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int ans = 0;
	static int blue = 0;
	public static int func(int y, int x, int w) {
		if(w == 1) {
			return arr[y][x]; 
		}
		
		int[] tmp = new int[4];
		tmp[0] = func(y,x,w/2);
		tmp[1] = func(y,x + w/2, w/2);
		tmp[2] = func(y+w/2,x, w/2);
		tmp[3] = func(y+w/2,x+w/2,w/2);
		boolean isOk = true;
		int cnt = 0;
		for(int i = 0; i < 4; ++i) {
			if(tmp[i] == -1) {
				isOk = false;
				continue;
			}
			if(tmp[i] != tmp[0]){
				isOk = false;
			}
			cnt++;
		}
		if(!isOk) {
			for(int i = 0; i < 4; ++i) {
				if(tmp[i] == 1)
					blue++;
			}
			ans += cnt;
			return -1;
		}
		return tmp[0];
	
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		arr = new int[n][n];
		for(int i = 0; i < n; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; ++j) {
				arr[i][j] = st.nextToken().charAt(0)-'0';
			}
		}
		int num = func(0,0,n); 
		if(num != -1) {;
			ans++;
			if(num == 1)
				blue++;
		}
		System.out.println(ans - blue);
		System.out.println(blue);
		
	}
}