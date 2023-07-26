#include <iostream>
#include <set>
#include <vector>
using namespace std;


int main()
{
	int n;
	int ans = 0;
	cin >> n;
	for (int i = 0; i < n; ++i)
	{
		set<string> s;
		while (i < n)
		{
			string str;
			cin >> str;
			if (!str.compare("ENTER"))
				break;
			if (s.find(str) == s.end())
			{
				ans++;
				s.insert(str);
			}
			i++;
		}
	}
	cout << ans;
}