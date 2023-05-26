#include <iostream>
#include <set>
#include <vector>
using namespace std;


int main()
{
	set<string> s;
	int n;
	cin >> n;
	vector<string> v(n);
	for (int i = 0; i < n; ++i)
	{
		string name, act; 
		cin >> name >> act;
		if (act[0] == 'e')
			s.insert(name);
		else
			s.erase(name);
	}
	int idx = 0;
	for (auto i = s.begin(); i != s.end(); ++i)
	{
		v[idx++] = *i;
	}
	for (int i = idx - 1; i >= 0; --i)
		printf("%s\n",v[i].c_str());
}