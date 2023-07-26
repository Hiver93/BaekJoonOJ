#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
	int n;
	int arr[500][2];
	int check[500]{1,0};
	int result = 1;
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		cin >> arr[i][0] >> arr[i][1];
	}

	for (int i = 0; i < n-1; i++)
	{
		for (int j = i; j < n - 1; j++)
		{
			if (arr[j][0] > arr[j + 1][0])
			{
				int temp = arr[j][0];
				arr[j][0] = arr[j + 1][0];
				arr[j + 1][0] = temp;
				
				temp = arr[j][1];
				arr[j][1] = arr[j + 1][1];
				arr[j + 1][1] = temp;
			}
		}
	}

	for (int i = 0; i < n - 1; i++)
	{
		for (int j = 0; j < n - 1 - i; j++)
		{
			if (arr[j][0] > arr[j + 1][0])
			{
				int temp = arr[j][0];
				arr[j][0] = arr[j + 1][0];
				arr[j + 1][0] = temp;

				temp = arr[j][1];
				arr[j][1] = arr[j + 1][1];
				arr[j + 1][1] = temp;
			}
		}
	}

	for (int i = 1; i < n; i++)
	{
		check[i] = 1;
		for (int j = i; j >= 0; j--)
		{
			if (arr[i][0] > arr[j][0] && arr[i][1] > arr[j][1])
			{
				if (check[i] < check[j] + 1)
					check[i] = check[j] + 1;
			}
		}
		if (result < check[i])
			result = check[i];
	}

	cout << n - result;


}