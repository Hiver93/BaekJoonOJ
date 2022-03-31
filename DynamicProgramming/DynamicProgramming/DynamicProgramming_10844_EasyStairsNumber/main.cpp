#include <iostream>
using namespace std;

int arr[101][10]{1,1,1,1,1,1,1,1,1,1};

int main()
{
	int n;
	cin >> n;
	for (int i = 1; i < n; i++)
	{
		arr[i][0] = arr[i - 1][1];
		arr[i][0] %= 1000000000;
		for (int j = 1; j < 10; j++)
		{
			arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j + 1];
			arr[i][j] %= 1000000000;
		}
		arr[i][9] = arr[i - 1][8];
		arr[i][9] %= 1000000000;
	}

	int ans = 0;
	for (int i = 1; i < 10; i++)
	{
		ans += arr[n - 1][i];
		ans %= 1000000000;
	}

	cout << ans;
}