#include <iostream>
using namespace std;

int Func(int a, int b)
{
	if (a % b == 0)
	{
		return b;
	}
	return Func(b, a % b);
}

int main()
{
	int n;
	int a, b;
	cin >> n;
	while (n--)
	{
		cin >> a >> b;
		if (a < b)
		{
			int temp = a;
			a = b;
			b = temp;
		}
		cout << (a / Func(a, b)) * b << endl;
	}
}