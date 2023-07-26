#include <iostream>
using namespace std;

int main()
{
	int arr[1001]{ 0 };
	int check[1001]{ 0 };
	int n;
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}

	int ans = 0;
	check[0] = 1;
	for (int i = 0; i < n; i++)
	{
		int temp = arr[i];
		for (int j = i-1; j >= 0; j--)
		{
			if (arr[j] < arr[i]&&check[i] < check[j] + 1)
				check[i] = check[j] + 1;
			if (!j && !check[i])
				check[i] = 1;			
		}
		if (ans < check[i])
			ans = check[i];
	}

	cout << ans;
}