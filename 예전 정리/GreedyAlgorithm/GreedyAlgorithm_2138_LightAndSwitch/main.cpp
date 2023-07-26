#include <iostream>
using namespace std;
char result[1000001]{ 0 };
char arr[1000001]{ 0 };
int main()
{
	int n;
	int ans = 0;
	cin >> n;
	for (int i = 0; i < n; ++i)
	{
		cin >> arr[i];
	}
	for (int i = 0; i < n; ++i)
	{
		cin >> result[i];
	}
	for (int i = 1; i < n; ++i)
	{
		if (arr[i - 1] != result[i - 1])
		{
			arr[i - 1] ^= 1;
			arr[i] ^= 1;
			arr[i + 1] ^= 1;
			ans++;
		}
	}
	if (arr[n - 1] != result[n - 1])
	{
		for (int i = n-2; i > 0; --i)
		{
			if (arr[i + 1] != result[i + 1])
			{
			
				arr[i + 1] ^= 1;				
				arr[i] ^= 1;
				arr[i - 1] ^= 1;
				ans++;
			}
		}
		if (arr[1] != result[1])
		{
			arr[1] ^= 1;
			arr[0] ^= 1;
			ans++;
		}
	}
	if (arr[0] != result[0])
	{
		cout << -1 << endl;
	}
	cout << ans << endl;
}