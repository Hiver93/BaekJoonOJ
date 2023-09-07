#include <iostream>
using namespace std;

int fun(int a, int b) {

	if (a % b == 0)
		return b;

	return fun(b, a % b);
}

int main()
{
	long long a, b;
	cin >> a >> b;
	long long num = (a < b) ? fun(b, a) : fun(a, b);
	
	cout << a * b / num;
}