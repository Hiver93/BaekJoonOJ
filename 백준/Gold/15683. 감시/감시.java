import java.util.Scanner;

public class Main {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	// 카메라 번호별 감시가능 방향
	static int[][] a = {{0},{1},{2},{3}};
	static int[][] b = {{0,1},{2,3}};
	static int[][] c = {{0,3},{3,1},{1,2},{2,0}};
	static int[][] d = {{0,3,1},{3,1,2},{1,2,0},{2,0,3}};
	static int[][] e = {{0,1,2,3}};
	
	// 카메라 모음
	static int[][][] cam = {null,a,b,c,d,e}; 
	
	static int n,m;
	
	// 카메라 위치를 담을 배열과 최대 인덱스
	static int[][] pos = new int[8][8];
	static int idx = 0;
	
	// 정답을 담을 변수
	static int ans = 2147483647;
	
	// 범위확인
	public static boolean boundOk(int y, int x) {
		return 0 <= y && 0 <= x && y < n && x < m;
	}
	
	// 사각지대를 파악해서 리턴
	public static int count(int[][] result) {
		int cnt = 0;
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < m; ++j) {
				if(result[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}
	
	// 감시 구역은 칠해놓는다.
	public static void paint(int[][] arr, int y, int x, int d) {
		if(!boundOk(y,x) || arr[y][x] == 6)
			return;
		if(arr[y][x] == 0)
			arr[y][x] = 7;
		paint(arr,y+dr[d],x+dc[d],d);
		
	}
	
	// 배열 복사
	public static int[][] copy(int[][] arr) {
		int[][] dest = new int[n][m];
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < m; ++j) {
				dest[i][j] = arr[i][j];
			}
		}
		return dest;
	}
	
	// dfs
	public static void dfs(int depth, int[][] arr) {
		
		// 마지막 카메라까지 끝냈다면 비교후 정답 변경
		if(depth == idx) {
			int cnt = count(arr);
			if(cnt < ans)
				ans = cnt;
			return;
		}
		
		// 카메라 종류 받아오기
		int camNum = arr[pos[depth][0]][pos[depth][1]];
		
		// 현재 카메라가 감시가능한 경우의 수만큼 반복
		for(int i = 0; i < cam[camNum].length; ++i) {
			
			// 배열 새로 만들어 복사
			int[][] newArr = copy(arr);
			
			// 카메라가 감시가능 구역 모두 칠하기
			for(int j = 0; j < cam[camNum][i].length; ++j) {
				paint(newArr, pos[depth][0], pos[depth][1], cam[camNum][i][j]);
			}
			
			// 다음으로
			dfs(depth+1, newArr);
		}
		
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); m = sc.nextInt();
		int[][] arr = new int[n][m];
		
		// 입력받으며 카메라 위치 저장
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < m; ++j) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j] < 6 && arr[i][j] > 0) {
					pos[idx][0] = i;
					pos[idx++][1] = j;
				}
			}
		}
		
		// dfs
		dfs(0, arr);
		
		// 출력
		System.out.println(ans);
	}
}