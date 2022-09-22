class Solution {
    public String intToBinary(int n, int val){
			char[] str = new char[n];
			int idx = n-1;
			for (int i = 0; i < n; ++i)
			{
				if ((val & 1) == 1) {
					str[idx--] = '#';
				}
				else 
				{
					str[idx--] = ' ';
				}
				val >>= 1;
			}
			return new String(str);
	}
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; ++i)
			{		
				answer[i] = intToBinary(n, arr1[i] | arr2[i]);
			}
        return answer;
    }
}