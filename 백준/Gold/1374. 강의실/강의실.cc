#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

bool comp(vector<int> a, vector<int> b)
{
	return a[1] < b[1];
}

int main()
{
	int n;
	int trash;
	int ans = 0;
	scanf("%d",&n);
	vector<vector<int>> vecEnd(n);
	vector<vector<int>> vecStart(n);
	for (int i = 0; i < n; ++i)
	{
		vecEnd[i].resize(2);
		scanf("%d", &trash);
		scanf("%d", &vecEnd[i][0]);
		scanf("%d", &vecEnd[i][1]);
		vecStart[i] = vecEnd[i];

	}
	
	sort(vecEnd.begin(), vecEnd.end(), comp);
	sort(vecStart.begin(), vecStart.end());
	int idx = 0;
	for (int i = 0; i < n; ++i)
	{
		if (vecEnd[idx][1] <= vecStart[i][0])
		{
			idx++;
			continue;
		}
		ans++;
	}
	
	
	printf("%d",ans);
}