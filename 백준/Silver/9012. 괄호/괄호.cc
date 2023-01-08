#include <iostream>
using namespace std;

int main()
{
	char arr[50];
	int top = -1;

	int n; 
	cin >> n;

	for (int i = 0; i < n; ++i)
	{
		bool check = true;
		string str;
		cin >> str;

		for (int j = 0; j < str.size(); ++j)
		{
			char tmp = str[j];
			if (tmp == '(')
			{
				arr[++top] = '(';
			}
			else
			{
				if (-1 < top && arr[top] == '(')
				{
					top--;
				}
				else
				{
					check = false;
					break;
				}
			}
		}

		if (!check || top != -1)
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