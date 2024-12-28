import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Team{
	private int cnt = 0;
	private int pop = 0;
	Team(int cnt, int pop){
		this.cnt = cnt;
		this.pop = pop;
	}
	Team(){};
	
	void plusCnt() {
		cnt++;
	}
	void addPop(int pop) {
		this.pop += pop;
	}
	int getPop() {
		return pop;
	}
	void div() {
		this.pop /= cnt;
	}
}
public class Main {
	
	
	static int n;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static boolean boundOk(int y, int x) {
		return 0 <= y && 0 <= x && y < n && x < n;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		int l = Integer.valueOf(st.nextToken());
		int r = Integer.valueOf(st.nextToken());
		
		Team[][] arr = new Team[n][n];
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; ++j) {
				arr[i][j] = new Team(1, Integer.valueOf(st.nextToken()));
			}
		}
		
		boolean ok = true;
		int ans = -1;
		while(ok){
			ans++;
			ok = false;
			boolean visit[][] = new boolean[n][n];
			Team[][] nextArr = new Team[n][n];
			for(int i = 0; i < n; ++i) {
				for(int j = 0; j < n; ++j) {
					if(visit[i][j])
						continue;
					Team newTeam = new Team();
					Queue<int[]> q = new LinkedList<>();
					q.add(new int[]{i,j});
					visit[i][j] = true;
					while(!q.isEmpty()) {
						int[] pos = q.remove();
						int curY = pos[0];
						int curX = pos[1];
						nextArr[curY][curX] = newTeam;
						newTeam.plusCnt();
						newTeam.addPop(arr[curY][curX].getPop());
						for(int k = 0; k < 4; ++k) {
							int nY = curY+dr[k];
							int nX = curX+dc[k];
							if(!boundOk(nY,nX) || visit[nY][nX])
								continue;
							int ab = Math.abs(arr[curY][curX].getPop() - arr[nY][nX].getPop());
							if(ab <= r && l <= ab) {
								ok = true;
								visit[nY][nX] = true;
								q.add(new int[] {nY,nX});
							}
						}
					}
					newTeam.div();
				}
			}
			arr = nextArr;
		}
		
		System.out.println(ans);
	}
}