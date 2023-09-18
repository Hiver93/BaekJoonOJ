import java.util.Scanner;

public class Main {
	static int[][] arr = new int[128][128];
	static int[] ans = new int[2];
	static void func(int s1, int e1, int s2, int e2)
	{
	    int current = arr[s1][s2];
	    for(int i = s1; i < e1; ++i)
	    {
	        for(int j = s2; j < e2; ++j)
	        {
	            if(arr[i][j] != current){
	                func(s1, (s1+e1)/2, s2,(s2+e2)/2);
	                func(s1, (s1+e1)/2,(s2+e2)/2,e2);
	                func((s1+e1)/2, e1, s2, (s2+e2)/2);
	                func((s1+e1)/2, e1, (s2+e2)/2, e2);
	                return;
	            }
	        }
	    }
	    ans[arr[s1][s2]]++;
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();	    
	    for(int i = 0; i < n; ++i)
	    {
	        for(int j = 0; j < n; ++j)
	        {
	            arr[i][j] = sc.nextInt();
	        }
	     }
	    func(0,n,0,n);
	    System.out.printf("%d\n%d\n",ans[0],ans[1]);	    
	    
	}
}
