#include <iostream>
using namespace std;

int main()
{
	int n = 0;
	int c = 2;
	int ans = 4;
	cin >> n;
	for (int i = 0; i < n; ++i)
	{
		ans = (ans * 4) - (c * 4) + 1;
		c = c * 2 - 1;
	}
	cout << ans << endl;
}