#include <iostream>
using namespace std;

int main()
{
	int a, b;
	int ans;
	cin >> a >> b;
	ans = b;
	int factors[10000]{1,0};

	int i = 2;
	int idx = 1;
	while (i <= a && i <= b)
	{
		if (a % i == 0&&b % i == 0)
		{
			factors[idx++] = i;
			a /= i;
			b /= i;
		}
		else
		{
			i++;
		}
	}

	for (i = 1; i < idx; i++)
	{
		factors[i] *= factors[i - 1];
	}
	cout << factors[i-1] << endl;
	cout << ans * a << endl;

	return 0;
}