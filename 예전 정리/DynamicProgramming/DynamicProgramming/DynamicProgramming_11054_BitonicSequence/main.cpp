#include <iostream>
using namespace std;

int main()
{
	int arr[1000];
	int up[1000]{ 1,0 };
	int down[1000]{ 1,0 };
	int check[1000]{0};
	int n;
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}

	int ans = 0;
	for (int i = 0; i < n; i++)
	{
		up[i] = 1;
		for (int j = i - 1; j >= 0; j--)
		{
			if (arr[j] < arr[i] && up[i] < up[j] + 1)
				up[i] = up[j] + 1;
		}
	}
	for (int i = n-1; i >=0; i--)
	{
		down[i] = 1;
		check[i] = up[i];
		for (int j = i; j < n; j++)
		{
			if (arr[j] < arr[i] && down[i] < down[j] + 1)
			{
				down[i] = down[j] + 1;
				if(check[i] < up[i] + down[i] - 1)
					check[i] = up[i] + down[i] - 1;
			}
		}
		if (ans < check[i])
			ans = check[i];
	}

	cout << ans;
}