#include <iostream>
using namespace std;

void Func(int* arr, int* oper, int m, int n, int* min, int* max,int* opCount)
{
	if (n == 0)
	{
		int result = arr[0];
		for (int i = 0; i < m; i++)
		{
			if (opCount[i] == 0)
			{
				result += arr[i + 1];
			}
			else if (opCount[i] == 1)
			{
				result -= arr[i + 1];
			}
			else if (opCount[i] == 2)
			{
				result *= arr[i + 1];
			}
			else
			{
				result /= arr[i + 1];
			}
		}

		if (result < *min)
			*min = result;
		if (*max < result)
			*max = result;
		return;
	}
	for (int i = 0; i < 4; i++)
	{
		if (oper[i] != 0)
		{
			opCount[m - n] = i;
			oper[i]--;
			Func(arr, oper, m, n - 1, min, max, opCount);
			oper[i]++;
		}
	}
}


int main()
{
	int arr[11];
	int oper[4];
	int opCount[10]{0};
	int n;
	int min = 1000000000;
	int max = -1000000000;


	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> arr[i];
	for (int i = 0; i < 4; i++)
		cin >> oper[i];

	Func(arr, oper, n - 1, n - 1, &min, &max, opCount);

	cout << max << '\n' << min << endl;
}