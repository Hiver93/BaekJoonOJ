#include <iostream>
using namespace std;

int arr[500][500];
int check[500][500];
int main()
{
	int n;
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j <= i; j++)
		{
			cin >> arr[i][j];
		}
	}
	check[0][0] = arr[0][0];
	for (int i = 1; i < n; i++)
	{
		check[i][0] = check[i - 1][0] + arr[i][0];
		for (int j = 1; j <= i; j++)
		{
			if (check[i - 1][j - 1] < check[i - 1][j])
				check[i][j] = check[i - 1][j] + arr[i][j];
			else
				check[i][j] = check[i - 1][j - 1] + arr[i][j];
			
		}
		check[i][i] = check[i-1][i-1] + arr[i][i];
	}

	int ans = 0;
	for (int i = 0; i < n; i++)
	{
		if (ans < check[n - 1][i])
			ans = check[n - 1][i];
	}
	cout << ans;
}