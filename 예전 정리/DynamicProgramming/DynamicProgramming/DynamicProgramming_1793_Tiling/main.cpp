#include <iostream>
using namespace std;

string sum(string str1, string str2)
{	
	bool up = 0;
	int idx1 = str1.size() - 1;
	int idx2 = str2.size() - 1;
	char result[1001];
	int idx = 999;
	result[1000] = '\0';
	while (idx1 >= 0 && idx2 >= 0)
	{
		if (9 < str1[idx1] - '0' + str2[idx2] - '0' + up)
		{
			result[idx--] = ((str1[idx1] - '0' + str2[idx2] - '0' + up) % 10)+'0';
			up = 1;
		}
		else
		{
			result[idx--] = ((str1[idx1] - '0' + str2[idx2] - '0' + up) % 10)+'0';
			up = 0;
		}
		idx1--;
		idx2--;
	}
	if (idx2 < 0)
	{
		while (idx1 >= 0)
		{
			if (9 < up + str1[idx1] - '0')
			{
				result[idx--] = '0';
				up = 1;
			}
			else
			{
				result[idx--] = str1[idx1];
				up = 0;
			}
			idx1--;
		}
	}
	else
	{
		while (idx2 >= 0)
		{
			if (9 < up + str2[idx2] - '0')
			{
				result[idx--] = '0';
				up = 1;
			}
			else
			{
				result[idx--] = str2[idx2] + 1;
				up = 0;
			}
			idx2--;
		}
	}
	if (up)
	{
		result[idx] = '1';
		return &result[idx];
	}
	else
		return &result[idx + 1];
}

int main()
{
	string str1, str2;
	cin >> str1 >> str2;
	cout << sum(str1, str2);
}