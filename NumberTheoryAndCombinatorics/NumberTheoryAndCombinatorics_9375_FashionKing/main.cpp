#include <iostream>
#include <vector>
using namespace std;

int arr[31]{ 0 };
vector<pair<int, string>> vec;
int ans = 0;

void Func2(int n, int current, int last, int val) 
{
	if (n == current)
	{
		ans += val;
		return;
	}
	for (int i = last + 1; i < vec.size(); ++i)
	{
		Func2(n, current + 1, i, val/vec[i].first);
	}
}

int main()
{
	int t;
	cin >> t;
	for (int i = 0; i < t; ++i)
	{
		vec.clear();
		ans = 0;
		int n;
		cin >> n;
		for (int j = 0; j < n; ++j)
		{
			string tmp;
			string type;
			bool check = 0;
			cin >> tmp >> type;
			for (int k = 0; k < vec.size(); ++k)
			{
				if (!(vec[k].second.compare(type)))
				{
					vec[k].first++;
					check = 1;
					break;
				}
			}
			if(!check)
			{
				vec.push_back(make_pair(1, type));
			}
		}
		n = 1;
		for (int j = 0; j < vec.size(); ++j)
		{
			n *= vec[j].first;
		}
		
		for (int j = 0; j < vec.size(); ++j)
		{
			Func2(j, 0, -1, n);
		}
		cout << ans << endl;

	}
}