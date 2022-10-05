#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
	int n, m;
	int cArr[50];
	int bArr[10000];
	int result[51]{ 0 };
	bool check = 0;
	int ans = 0;
	cin >> n;
	result[n] = 2147483647;
	for (int i = 0; i < n; ++i)
	{
		cin >> cArr[i];
	}
	cin >> m;
	for (int i = 0; i < m; ++i)
	{
		cin >> bArr[i];
	}
	sort(cArr, cArr+n, greater<int>());
	sort(bArr, bArr + m, greater<int>());

	for (int i = 0; i < m; ++i)
	{
		if (cArr[0] < bArr[i])
		{
			check = 1;
			break;
		}
		for (int j = 0; j < n; ++j)
		{
			if (bArr[i] <= cArr[j + 1] && result[j + 1] <= result[j])
				continue;
			result[j]++;
			break;
		}
	}
	for (int i = 0; i < n; ++i) {
		if (ans < result[i])
			ans = result[i];
	}
	if (check)
		cout << -1;
	else
		cout << ans;
}