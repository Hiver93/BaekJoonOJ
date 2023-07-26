#include <iostream>
using namespace std;
long long dis[100000]{ 0 };
long long cost[100000]{ 0 };
int main()
{
	int n;
	long long ans = 0;
	cin >> n;
	for (int i = 0; i < n - 1; i++)
	{
		cin >> dis[i];
	}
	for (int i = 0; i < n; i++)
	{
		cin >> cost[i];
	}
	n--;
	for (int i = 0; i < n; i++)
	{
		ans += (cost[i] * dis[i]);
		int j = i + 1;
		while (j < n && cost[i] < cost[j])
		{
			ans += (cost[i] * dis[j]);
			j++;
		}
		i = j - 1;
	}

	cout << ans;
}