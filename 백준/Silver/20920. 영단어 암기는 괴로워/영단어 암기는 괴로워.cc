#include <iostream>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;

bool cmp(const pair<string, int>& p1, const pair<string, int>& p2)
{
	if (p1.second == p2.second)
	{
		if (p1.first.size() > p2.first.size())
			return true;
	}
	else if (p1.second > p2.second)
		return true;
	return false;
}

int main()
{
	map<string, int> m;
	int n, s;
	cin >> n >> s;
	for (int i = 0; i < n; ++i)
	{
		string str;
		cin >> str;
		if (str.size() < s)
			continue;
		auto f = m.find(str);
		if (f == m.end())
			m.insert({ str,1 });
		else
			f->second++;
	}
	vector<pair<string, int>> v(m.begin(), m.end());
	stable_sort(v.begin(), v.end(),cmp);
	for (int i = 0; i < v.size(); ++i)
		printf("%s\n", v[i].first.c_str());
}