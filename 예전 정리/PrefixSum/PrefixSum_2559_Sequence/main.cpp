#include <iostream>
using namespace std;

int main()
{
	int arr[100000]{ 0 };
	int ans = 0;
	int last = 0;
	int m, n;
	cin >> m >> n;
	for (int i = 0; i < n; i++)
	{
		scanf_s("%d", &arr[i]);
		ans += arr[i];
	}
	last = ans;
	for (int i = n; i < m; i++)
	{
		scanf_s("%d", &arr[i]);
		if (ans < last + arr[i] - arr[i - n])
			ans = last + arr[i] - arr[i - n];
		last = last + arr[i] - arr[i - n];
	}
	cout << ans << endl;
}