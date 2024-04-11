import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<>();
		
		// 해당칸에 도착했을 떄의 턴을 기록할 배열(방문 배열 역할 포함)
		int[] arr = new int[101];
		// 해당칸에 도착했을 때 이동할 칸을 기록해둘 배열
		int[] d = new int[107];
		
		// d배열을 자신의 인덱스로 초기화
		for(int i = 0; i < 107; ++i) {
			d[i] = i;
		}
		int r = sc.nextInt(), s = sc.nextInt();
		
		// 해당 칸 도착시 이동할 칸 입력
		for(int i = 0; i < r; ++i) {
			d[sc.nextInt()] = sc.nextInt();
		}
		for(int i = 0; i < s; ++i) {
			d[sc.nextInt()] = sc.nextInt();
		}
		
		
		// 1을 시작으로 bfs
		q.add(1);
		while(!q.isEmpty()) {
			int c = q.remove();
			
			// 주사위 1~6
			for(int i = 1; i < 7; ++i) {
				
				// 주사위 눈에 따른 다음 칸 
				int next = d[c + i];
				
				// 다음칸이 100이면 출력하고 종료
				if(next == 100) {
					System.out.println(arr[c]+1); 
					return;
				}
				
				// 다음 칸을 큐에 집어넣는다.
				if(next < 101 && arr[next] == 0) {
					q.add(next);
					arr[next] = arr[c]+1;
				}
			}
		}
		
	}
}