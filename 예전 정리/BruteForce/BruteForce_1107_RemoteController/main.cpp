#include <iostream>
using namespace std;

int main()
{
	int target, n;
	bool arr[10]{ 0 };
	cin >> target;
	cin >> n;
	if (n == 10)
	{
		int ans = target - n;
		if (ans < 0)
			ans = ~ans + 1;
		cout << ans;
		return;
	}
	for (int i = 0; i < n; ++i)
	{		
		int tmp;
		cin >> tmp;
		arr[tmp] = 1;
	}

	for (int i = 0; i < target / 2 + 1; ++i)
	{
		int num = target + i;

	}
}