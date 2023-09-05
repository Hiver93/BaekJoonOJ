#include <iostream>
#include <map>
#include <vector>
using namespace std;

int main()
{
	int n;
	map<string, int> m;
	cin >> n;

	for (int i = 0; i < n; ++i) {
		string str;
		int tmp;
		cin >> str >> tmp;

		auto tmpMap = m.find(str);
		if (tmpMap == m.end()) {
			m.insert({ str,tmp });
		}
		else {
			tmpMap->second += tmp;
		}
	}

	for (auto i = m.begin(); i != m.end(); ++i) {
		for (auto j = m.begin(); j != m.end(); ++j) {
			if (i == j)
				continue;
			if ((int)(i->second * 1.618) == j->second) {
				cout << "Delicious!";
				return 0;
			}
		}
	}

	cout << "Not Delicious...";
}