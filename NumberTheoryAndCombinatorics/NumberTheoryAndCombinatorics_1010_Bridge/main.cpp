#include <iostream>
using namespace std;

int arr[1001][1001]{ 0 };
void Func(int n, int current)
{
	if (n + 1 == current)
	{
		return;
	}
	arr[current][0] = 1;
	arr[current][current] = 1;
	for (int i = 1; i < n; ++i)
	{
		arr[current][i] = (arr[current - 1][i - 1] + arr[current - 1][i]);
	}
	Func(n, current + 1);
}

int main()
{
	int t;
	cin >> t;
	arr[0][0] = 1;
	arr[1][0] = 1;
	arr[1][1] = 1;
	for (int i = 0; i < t; ++i)
	{
		int n, m;
		cin >> n >> m;
		Func(m, 2);
		cout << arr[m][n] << endl;
	}
}