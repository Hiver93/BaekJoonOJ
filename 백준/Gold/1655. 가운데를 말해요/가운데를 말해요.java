import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
		PriorityQueue<Integer> right = new PriorityQueue<>();
		
		left.add(sc.nextInt());
		sb.append(left.peek()).append('\n');
		for(int i = 1; i < n; ++i) {
			int in = sc.nextInt();
			if(left.peek() <= in ) {
				right.add(in);
			}
			else {
				left.add(in);
			}
			if(right.size() < left.size()) {
				right.add(left.remove());
			}
			if(left.size() < right.size()) {
				left.add(right.remove());
			}
			sb.append(left.peek()).append('\n');
		}
		System.out.println(sb);
	}
}