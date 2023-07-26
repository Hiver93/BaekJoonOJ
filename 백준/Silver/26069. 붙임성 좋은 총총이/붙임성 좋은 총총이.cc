#include <iostream>
#include <set>
using namespace std;


int main()
{
	set<string> s;
	s.insert("ChongChong");
	int n;
	cin >> n;
	for (int i = 0; i < n; ++i)
	{
		string str1, str2;
		cin >> str1 >> str2;
		if (s.find(str1) != s.end() || s.find(str2) != s.end())
		{
			s.insert(str1);
			s.insert(str2);
		}
	}
	cout << s.size();
}