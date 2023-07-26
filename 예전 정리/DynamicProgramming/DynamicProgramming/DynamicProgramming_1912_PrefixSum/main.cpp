#include <iostream>
using namespace std;

int main()
{
	int arr[100000];
	int n;
	int ans;
	cin >> n;
	
	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}
	ans = arr[0];
	for (int i = 1; i < n; i++)
	{
		if (0 < arr[i-1])
		{
			arr[i] = arr[i - 1] + arr[i];
		}
		if (ans < arr[i])
			ans = arr[i];
	}

	cout << ans << endl;
}