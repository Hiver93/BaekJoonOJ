#include <string>
#include <vector>
using namespace std;

string IntToBinary(int n, int val)
{
	char str[16];
	int idx = n-1;
	str[n] = '\0';
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
	return str;
}

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    vector<string> answer(n);
	for (int i = 0; i < n; ++i)
	{		
		answer[i] = IntToBinary(n, arr1[i] | arr2[i]);
	}
    return answer;
}