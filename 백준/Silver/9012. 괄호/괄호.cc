#include <iostream>
using namespace std;

int main()
{
	int stack[50];
	int top = -1;
	int n;
	cin >> n;
	for (int i = 0; i < n; ++i)
	{
		string str;
		bool check = true;
		cin >> str;
		for (int j = 0; j < str.size(); ++j)
		{
			char tmp = str[j];
			if (tmp == '(')
			{
				top++;
				stack[top] = '(';
			}
			else
			{
				if (-1 < top && stack[top] == '(')
				{
					top--;
				}
				else
				{
					check = false;
				}
			}
		}
		if (top != -1 || !check) 
		{
			cout << "NO" << endl;
		}
		else
		{
			cout << "YES" << endl;
		}
		top = -1;
	}
}