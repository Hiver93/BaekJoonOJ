#include <iostream>
#include <stack>
using namespace std;

int* result;
void func(int* arr, int size, int m, int n)
{
	if (size == 0)
	{
		for (int i = 0; i < m; i++)
		{
			cout << result[i] << ' ';
		}
		cout << '\n';
		return;
	}
	for (int i = 0; i < n; i++)
	{
		int* temp = new int[n - 1];
		bool check = 0;
		for (int j = 0; j < n; j++)
		{
			if (i == j)
			{
				check = 1;
				continue;
			}
			temp[j - check] = arr[j];
		}
		result[m - size] = arr[i];
		func(temp, size - 1, m, n - 1);
		delete[] temp;
	}
}

int main()
{
	int n, m;
	cin >> n >> m;
	result = new int[m];
	int* arr = new int[n];
	int i = 1;
	int size = m;
	for (int i = 1; i <= n; i++)
	{
		arr[i - 1] = i;
	}
	func(arr, size, m, n);
	delete[] arr;
	delete[] result;
}