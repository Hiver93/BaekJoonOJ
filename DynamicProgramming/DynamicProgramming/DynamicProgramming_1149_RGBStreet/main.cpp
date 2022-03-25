#include <iostream>
using namespace std;

int arr[1000][3];
int ans = 1000000;

void Func(int current, int n, int val, int lastColor)
{
	if (current == n)
	{
		if (ans > val)
			ans = val;
		return;
	}
	for (int i = 0; i < 3; i++)
	{
		if (i == lastColor)
			continue;
		val += arr[current][i];
		Func(current + 1, n, val,i);
		val -= arr[current][i];
	}
	
}

int main()
{
	int n;
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		cin >> arr[i][0] >> arr[i][1] >> arr[i][2];
	}

	Func(0, n, 0,3);

	cout << ans;

}