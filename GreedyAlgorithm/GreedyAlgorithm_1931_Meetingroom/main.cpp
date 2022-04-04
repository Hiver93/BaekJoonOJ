#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	vector<pair<unsigned int, unsigned int>> vec;
	int n;
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		unsigned int a, b;
		cin >> a >> b;
		vec.push_back(pair<unsigned int, unsigned int>(a, b));
	}

	sort(vec.begin(), vec.end());

	int idx = 0;
	int ans = 1;
	unsigned int max = 0;
	
	for (int i = 1; i < n; i++)
	{
		if (vec[idx].second <= vec[i].first)
		{
			if (vec[idx].first == vec[i].first)
			{
				if (vec[idx].first != vec[i].second)
				{
					if (!max)
					{
						max = vec[i].second;
						ans++;
					}
				}
				else
				{
					ans++;
				}
			}
			else
			{
				if (max)
				{
					if (vec[i].second < max)
					{
						ans--;
					}
					max = 0;
				}
				ans++;
				idx = i;
			}
		}
		else if (vec[idx].second > vec[i].second)
		{
			
			idx = i;
		}
	}

	cout << ans;
}