import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int[] q = new int[2000000];
		int front = 0;
		int rear = 0;
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		for(int i = 0; i < n; ++i) {
			String str = sc.next();
			if(str.equals("push")) {
				q[rear++] = sc.nextInt();
			}
			else if(str.equals("pop")) {
				if(front == rear) {
					sb.append("-1\n");
				}
				else {
					sb.append(q[front++]);
					sb.append("\n");
				}
			}
			else if(str.equals("size")) {
				sb.append(rear - front);
				sb.append("\n");
			}
			else if(str.equals("empty")) {
				if(front == rear) {					
					sb.append("1\n");					
				}
				else
					sb.append("0\n");					
			}
			else if(str.equals("front")) {
				if(front == rear) {
					sb.append("-1\n");
				}
				else {
					sb.append(q[front]);
					sb.append("\n");
				}
			}
			else {
				if(front == rear) {
					sb.append("-1\n");
				}
				else {
					sb.append(q[rear - 1]);
					sb.append("\n");				
				}
			}
		}
		System.out.println(sb);
	}
}
