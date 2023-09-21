#include <iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	long long n;
	cin >> n;
	if (n == 1) {
		cout << 1;
		return 0;
	}

	long long i;
	for (i = 0; i * i < n; ++i) {
	}
	i--;
	cout << i;
}