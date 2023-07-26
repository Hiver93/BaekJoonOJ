#include <iostream>
using namespace std;

int Func(int a, int b)
{
	return a % b ? Func(b, a % b) : b;
}

int main()
{
	int n;
	int rings[100];
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		cin >> rings[i];
	}

	for (int i = 1; i < n; i++)
	{
		if (rings[0] < rings[i])
			cout << rings[0] / Func(rings[i], rings[0]) << '/' << rings[i] / Func(rings[i], rings[0]) << ' ';
		else
			cout << rings[0] / Func(rings[0], rings[i]) << '/' << rings[i] / Func(rings[0], rings[i]) << ' ';

	}


}