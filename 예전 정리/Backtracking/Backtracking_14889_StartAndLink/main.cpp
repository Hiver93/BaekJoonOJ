#include <iostream>
using namespace std;

void Func(int arr[20][20], int n, int now, int* arr1, int* arr2, bool* check, int *result, int i)
{
	if (n == now)
	{
		int team1 = 0;
		int team2 = 0;
		for (int i = 0; i < n / 2; i++)
		{
			for (int j = 0; j < n / 2; j++)
			{
				if (j == i)
					continue;
				team1 += arr[arr1[i]][arr1[j]];
			}
		}
		for (int i = 0; i < n / 2; i++)
		{
			for (int j = 0; j < n / 2; j++)
			{
				if (j == i)
					continue;
				team2 += arr[arr2[i]][arr2[j]];
			}
		}

		int a = team1 - team2;
		if (a < 0)
		{
			a *= -1;
		}
		if (a < *result)
		{
			*result = a;
		}
		return;
	}
	if (n / 2 == now)
		i = 0;
	if (n / 2 <= now)
	{
		for (i; i < n; i++)
		{
			if (check[i])
				continue;
			arr2[now - n/2] = i;
			check[i] = 1;
			Func(arr, n, now + 1, arr1, arr2, check, result, i+1);
			check[i] = 0;
		}
	}
	else
	{
		for (i; i < n; i++)
		{
			if (check[i])
				continue;
			arr1[now] = i;
			check[i] = 1;
			Func(arr, n, now + 1, arr1, arr2, check, result,i+1);
			check[i] = 0;
		}
	}


}

int main()
{
	int n;
	int arr[20][20];
	int result = 2100000000;
	int count = 0;
	int arr1[10];
	int arr2[10];
	bool check[20]{0};
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			cin >> arr[i][j];
		}
	}

	Func(arr, n, 0, arr1, arr2, check, &result,0);

	cout << result;
}