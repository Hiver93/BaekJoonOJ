import java.util.Scanner;

public class Main {
	static int[] q = new int[10001];
	static int front = 0;
	static int back = 0;
	
	static void push(int i) {
		q[back++] = i;
	}
	
	static int pop() {
		if(empty() == 1) {
			return -1;
		}
		int res = q[front++];
		return res;
	}
	
	static int size() {
		return back - front;
	}
	
	static int empty() {
		return back == front ? 1 : 0;
	}
	
	static int front() {
		if(empty() == 1) {
			return -1;
		}
		return q[front];
	}
	
	static int back() {
		if(empty() == 1) {
			return -1;
		}
		return q[back-1];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		while(n-- != 0) {
			String cmd = sc.next();
			switch(cmd) {
			case "push":
				push(sc.nextInt());
				break;
			case "pop":
				sb.append(pop()).append('\n');
				break;
			case "size":
				sb.append(size()).append('\n');
				break;
			case "empty":
				sb.append(empty()).append('\n');
				break;
			case "front":
				sb.append(front()).append('\n');
				break;
			default:
				sb.append(back()).append('\n');
			}
		}
		System.out.println(sb);
	}
}
