#include <iostream>
using namespace std;

int arr[1000][3];
int check[1000][3];
int ans = 1000000;

void Func(int current, int n)
{
	if (current == n)
	{
		return;
	}
	for (int i = 0; i < 3; i++)
	{		
		int temp = 0;
		for (int j = 0; j < 3; j++)
		{
			if (j == i)
				continue;
			if (!temp)
				temp = arr[current][i] + check[current - 1][j];
			else
				if (temp > arr[current][i] + check[current - 1][j])
					check[current][i] = arr[current][i] + check[current - 1][j];
				else
					check[current][i] = temp;
		}		
	}
	Func(current + 1, n);
	
}

int main()
{
	int n;
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		cin >> arr[i][0] >> arr[i][1] >> arr[i][2];
	}
	check[0][0] = arr[0][0];
	check[0][1] = arr[0][1];
	check[0][2] = arr[0][2];

	Func(1, n);
	if (check[n-1][0] <= check[n - 1][1] && check[n - 1][0] <= check[n - 1][2])
		cout << check[n - 1][0];
	else if (check[n - 1][1] <= check[n - 1][0] && check[n - 1][1] <= check[n - 1][2])
		cout << check[n-1][1];
	else
		cout << check[n-1][2];
}