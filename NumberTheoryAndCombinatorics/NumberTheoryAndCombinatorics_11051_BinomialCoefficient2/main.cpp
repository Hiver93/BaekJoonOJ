#include <iostream>
using namespace std;

unsigned long long arr[1001]{ 1, 1, 2 };
unsigned long long Factorial(int n)
{
	if (arr[n])
	{
		return arr[n];
	}
	if (!arr[n - 1])
	{
		Factorial(n - 1);
	}
	arr[n] = (arr[n - 1] * n)%10007;

	return arr[n];
}

int main()
{
	int n, k;
	cin >> n >> k;
	for (int i = 1; i < n+1; i++)
	{
		arr[i] = (arr[i - 1] * i)%10007;
	}
	if (k == 0)
		cout << 1;
	else
		cout << ((arr[n]*10007) / (arr[k] * arr[n - k]))%10007;
}