#include <iostream>
using namespace std;

int Func(int n)
{
	int result = 1;
	for (int i = n; i > 1; i--)
	{
		result *= i;
	}

	return result;
}
int main()
{
	int n, k;
	cin >> n >> k;

	if (k == 0)
		cout << 1;
	else
		cout << (Func(n)) / (Func(k) * Func(n - k));
}