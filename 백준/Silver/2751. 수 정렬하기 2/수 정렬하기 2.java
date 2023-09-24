import java.util.Scanner;

public class Main {
	static boolean comp(int a, int b) {
		return a < b;
	}
	static void heapSort(int[] arr) {
		int len = arr.length;
		int[] heap = new int[len + 1];
		for(int i = 0; i <len; ++i) {
			int idx = i + 1;
			while(idx > 1) {
				if(comp(heap[idx/2], arr[i]))
					break;
				heap[idx] = heap[idx / 2];
				idx /= 2;
			}
			heap[idx] = arr[i];
		}
		
		for(int i = 0; i < len; ++i) {
			arr[i] = heap[1];
			int temp = heap[len-i];
			int idx = 1;
			while(true){
				if (idx * 2 < len - i - 1)
				{
					if (comp(heap[idx * 2], heap[idx * 2 + 1]))
					{
						if (comp(heap[idx * 2], temp))
						{
							heap[idx] = heap[idx * 2];
							idx *= 2;
						}
						else
							break;
					}
					else
					{
						if (comp(heap[idx * 2+1], temp))
						{
							heap[idx] = heap[idx * 2+1];
							idx = idx * 2 + 1;
						}
						else
							break;
					}
				}
				else if (idx * 2 == len - i - 1)
				{
					if (comp(heap[idx * 2], temp))
					{
						heap[idx] = heap[idx * 2];
						idx *= 2;
					}
					else
						break;
				}
				else
					break;
			}
			heap[idx] = temp;
		}
	}
	public static void main(String[] args) {
//		int arr[] = { 2,5,8,6,3,1,77,12,7,10 };
//
//		heapSort(arr);
//
//		System.out.println(Arrays.toString(arr));
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; ++i) {
			arr[i] = sc.nextInt();
		}
		heapSort(arr);
		for(int i = 0; i < n; ++i) {
			sb.append(arr[i]);
			sb.append("\n");
		}
		System.out.print(sb);
	}
}
