#include <iostream>
using namespace std;

int fun(int a, int b) {

	if (a % b == 0)
		return b;

	return fun(b, a % b);
}

int main()
{
	long long a, b, c, d;
	cin >> a >> b >> c >> d;
	long long r1 = a * d + b * c, r2 = b * d;
	long long num = (r1 < r2) ? fun(r2, r1) : fun(r1, r2);
	
	cout << r1 / num << " " << r2 / num;
}