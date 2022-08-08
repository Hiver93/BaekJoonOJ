#include <iostream>
#include <vector>
using namespace std;

int arr[31][31];
void Func(int m, int current)
{
	if (m + 1 == current)
	{
		return;
	}
	arr[current][0] = 1;
	arr[current][1] = 1;
	for (int i = 1; i < current; ++i)
	{
		arr[current][i] = arr[current - 1][i - 1] + arr[current - 1][i];
	}
	Func(m, current + 1);
}

int Func2(int a, int b, int start, vector<pair<int,string>> vec)
{
	int r = 0;
	for (int i = 0; i < b; ++i)
	{

	}
}

int main()
{
	arr[0][0] = 1;
	arr[1][0] = 1;
	arr[1][1] = 1;
	Func(30, 2);
	int t;
	cin >> t;
	for (int i = 0; i < t; ++i)
	{
		vector<pair<int, string>> vec;
		int n;
		int ans = 0;
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
		
		for (int j = 0; j < vec.size(); ++j)
		{
			int tmp = 1;
			for (int k = 0; k < j + 1; ++k)
			{
				
			}
		}
		cout << ans << endl;
	}
}