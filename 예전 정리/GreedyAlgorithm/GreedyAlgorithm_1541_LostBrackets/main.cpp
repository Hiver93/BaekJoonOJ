#include <iostream>
#include <string>
#include <stack>
using namespace std;

int ToInt(int &i, string s)
{
	int a = 0;
	while (i<s.length() && s[i] <= '9' && s[i] >= '0')
	{
		a += (s[i] - '0');
		if (214748364 < a)
		{
			i++;
			return a;
		}
		a *= 10;
		i++;
	}

	return a / 10;
}

int main()
{
	string s;
	stack<int> n;
	cin >> s;

	for (int i = 0; i < s.length(); i++)
	{
		if (s[i] <= '9' && s[i] >= '0')
		{
			n.push(ToInt(i, s));
			i--;
		}
		else if (s[i] == '+')
		{
			int temp = n.top();
			n.pop();
			n.push(temp + ToInt(++i, s));
			i--;
		}
		else
		{
			n.push(ToInt(++i, s));
			i--;
		}
	}
	stack<int> result;
	int ans = 0;
	while (!(n.empty()))
	{
		result.push(n.top());
		n.pop();
	}
	ans = result.top();
	result.pop();
	while(!(result.empty()))
	{
		ans -= result.top();
		result.pop();
	}

	cout << ans;
}