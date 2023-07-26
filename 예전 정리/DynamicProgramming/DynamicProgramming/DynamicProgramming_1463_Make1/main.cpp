#include <iostream>
using namespace std;

int arr[1000001] = { 0,0,1,1,2,3,0 };
void Func(int n)
{
	if (n == 1)
		return;
	if (arr[n])
		return;
	if (!arr[n - 1])
		Func(n - 1);
	if (n%2==0&&!arr[n / 2])
		Func(n / 2);
	if (n%3==0&&!arr[n / 3])
		Func(n / 3);
	if (n % 3 == 0)
	{
		if (n % 2 == 0)
		{
			if (arr[n - 1] <= arr[n / 2] && arr[n - 1] <= arr[n / 3])
				arr[n] = arr[n - 1] + 1;
			else if (arr[n / 2] <= arr[n - 1] && arr[n / 2] <= arr[n / 3])
				arr[n] = arr[n / 2] + 1;
			else
				arr[n] = arr[n / 3] + 1;
		}
		else
		{
			if (arr[n - 1] <= arr[n / 3])
				arr[n] = arr[n - 1] + 1;
			else
				arr[n] = arr[n / 3] + 1;
		}
	}
	else if (n % 2 == 0)
	{
		
		if (arr[n - 1] <= arr[n / 2])
			arr[n] = arr[n - 1] + 1;
		else
			arr[n] = arr[n / 2] + 1;
		
	}
	else
	{
		arr[n] = arr[n - 1]+1;
	}
}

int main()
{
	int n;
	cin >> n;
	Func(n);
	cout << arr[n];
}