import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	// 값과 지워져야할 객체인지 체크하는 변수 b
	public static class V{
		int i;
		boolean b = true;
		V(int i){
			this.i = i;
		}
	}
	
	// 우선순위 큐 두개
	static PriorityQueue<V> asc; 
	static PriorityQueue<V> desc;
	// 정답 최대값, 최소값
	static int ans1;
	static int ans2;
	
	// 큐에 넣을 값을 객체 하나로 만들어 두 큐에 집어넣는다.
	public static void insert(int i) {
		V v = new V(i);
		asc.add(v);
		desc.add(v);
	}
	
	// 최소값을 제거한다. 반약 b가 거짓이어서 이미 지워진 값이라면 그냥 제거하고 무시한다.
	public static boolean popLow() {
		while(!asc.isEmpty()) {
			V v = asc.poll();
			if(v.b) {
				v.b = false;
				ans2 = v.i;
				return true;
			}
		}
		return false;
	}
	
	// 위와 동일
	public static boolean popHigh() {
		while(!desc.isEmpty()) {
			V v = desc.poll();
			if(v.b) {
				v.b = false;
				ans1 = v.i;
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		while(t-- != 0) {
			asc = new PriorityQueue<V>((v1,v2)->{return v1.i < v2.i ? -1 : 1;});
			desc = new PriorityQueue<V>((v1,v2)->{return v2.i <= v1.i ? -1 : 1;});
			int n = sc.nextInt();
			
			// 입력받으며 명령어 처리
			for(int i = 0; i < n; ++i) {
				char c = sc.next().charAt(0);
				int v = sc.nextInt();
				if(c == 'I') {
					insert(v);
				}
				else {
					if(v < 0) {
						popLow();
					}
					else {
						popHigh();
					}
				}
			}
			
			// 제거했는데 값이 있다면 정답을 버퍼에 저장
			if(popHigh()) {
				sb.append(ans1).append(" ");				
				if(popLow())
					sb.append(ans2).append("\n");
				else	
					sb.append(ans1).append("\n");
			}
			else {
				sb.append("EMPTY\n");
			}
			
		}
		System.out.println(sb);
	}
}
