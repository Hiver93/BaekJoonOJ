#include <iostream>
using namespace std;

int comp(int a, int b)
{
	if (a < b)
		return b;
	return a;
}

int main()
{

	int arr1[10001]{ 0 };
	int arr2[10001]{ 0 };
	int arr[10001]{ 0 };
	int n;
	cin >> n;
	for (int i = 1; i <= n; i++)
	{
		cin >> arr[i];
	}
	arr1[1] = arr[1];
	arr2[1] = arr[1];
	arr1[2] = arr[2];
	arr2[2] = arr[1] + arr[2];

	for (int i = 3; i <= n; i++)
	{
		arr1[i] = arr[i] + comp(comp(arr1[i - 2], arr2[i - 2]), arr2[i-3]);
		arr2[i] = arr[i] + arr1[i - 1];
	}

	int ans = 0;
	for (int i = 0; i < 3; i++)
	{
		if (n <= i)
			break;
		if (ans < arr1[n - i])
			ans = arr1[n - i];
		if (ans < arr2[n - i])
			ans = arr2[n - i];
	}

	cout << ans<<endl;


	return 0;
}
