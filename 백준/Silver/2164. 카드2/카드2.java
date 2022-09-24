import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] q = new int[500001];
		int n = sc.nextInt();
		int front = 0;
		int rear = n;
		for(int i = 0; i < n; ++i) {
			q[i] = i+1;
		}
		boolean state = false;
		int i = 1;		
		while(rear - front != 1&&rear - front != -500000) {
			if(!state) {
				front = (front+1)%500001;
			}
			else {
				q[rear++] = q[front++];
				rear %= 500001;
				front %= 500001;
			}
			state ^= true;
		}
		System.out.println(q[front]);
		
	}
}
