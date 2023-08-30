#include <iostream>
#include <queue>
#include <vector>
using namespace std;


int main()
{
    ios::sync_with_stdio(0);
	cin.tie(0);
    
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	int n, m;
	cin >> n >> m;
	for (int i = 1; i <= n; ++i)
	{
		int tmp;
		cin >> tmp;
		pq.push({ tmp,i });
		while (i - m >= pq.top().second)
		{
			pq.pop();
		}
		printf("%d ", pq.top().first);
	}
}