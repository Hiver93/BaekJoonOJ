#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
	int n;
	int arr[1000];
	int check[1001];
	int ans = 0;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	sort(arr, arr + n);
	check[0] = 0;
	check[1] = arr[0];
	for (int i = 2; i <= n; i++)
	{
		check[i] = check[i - 1] + arr[i-1];
	}
	for (int i = 1; i <= n; i++)
	{
		ans += check[i];
	}

	cout << ans;

}