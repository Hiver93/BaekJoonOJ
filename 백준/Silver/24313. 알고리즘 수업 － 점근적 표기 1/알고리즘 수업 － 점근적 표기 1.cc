#include <iostream>
using namespace std;


int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int a, b, c, d;

	cin >> a >> b >> c >> d;

	for (int i = d; i <= 100; ++i) {
		if (!(a * i + b <= c * i)) {
			cout << 0 << endl;
			return 0;
		}
	}
	cout << 1;
}