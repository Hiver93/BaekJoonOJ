import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static boolean[] memo = new boolean[200001];
	static int[] idxs = new int[200001];
	static boolean boundOk(int num) {
		return 0 <= num && num <= 200000;
	}
	
	static class E{
		int idx;
		int dis;
		E(int idx, int dis) {
			this.idx = idx;
			this.dis = dis;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 200001; ++i) {
			idxs[i] = -1;
		}
		int st = sc.nextInt();
		int ed = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		PriorityQueue<E> pq = new PriorityQueue<>((a,b)->{return a.dis > b.dis ? 1 : -1;});
		pq.add(new E(st,0));
		while(true) {
			E e = pq.remove();
			if(e.idx == ed) {
				sb.append(e.dis).append('\n');
				break;
			}
			int cur = e.idx;
			int dis = e.dis;
			
			int next = e.idx+1;
			if(boundOk(next) && !memo[next]) {
				memo[next] = true;
				idxs[next] = cur;
				pq.add(new E(next,dis+1));
			}
			next = cur - 1;
			if(boundOk(next) && !memo[next]) {
				memo[next] = true;
				idxs[next] = cur;
				pq.add(new E(next,dis+1));
			}
			next = cur * 2;
			if(boundOk(next) && !memo[next]) {
				memo[next] = true;
				idxs[next] = cur;
				pq.add(new E(next,dis+1));
			}
		}
		int idx = ed;
		Deque<Integer> stack = new LinkedList<>();
		stack.addLast(ed);
		while(idx != st) {
			stack.addLast(idxs[idx]);
			idx = idxs[idx];
		}
		while(!stack.isEmpty()) {
			sb.append(stack.removeLast()).append(' ');			
		}
		System.out.println(sb);
	}

}