#include <iostream>
using namespace std;

int arr1[301]{0};
int arr2[301]{0};
int arr[301];

void Func(int n)
{
	if (arr1[n]&&arr2[n])
		return;

	if (arr1[n - 1] == 0)
		Func(n - 1);
	if(arr2[n - 2] == 0|| arr1[n - 2] == 0)
		Func(n - 2);
	if(arr2[n - 2]< arr1[n - 2])
		arr1[n] = arr1[n - 2] + arr[n];
	else
		arr1[n] = arr2[n - 2] + arr[n];
	arr2[n] = arr1[n - 1] + arr[n];
}

int main()
{
	int n;
	cin >> n;
	for (int i = 1; i <= n; i++)
	{
		cin >> arr[i];
	}
	arr1[1] = arr[1];
	arr2[1] = arr[1];
	arr1[2] = arr[2];
	arr2[2] = arr[1]+arr[2];
	
	Func(n);
	if (arr1[n] < arr2[n])
		cout << arr2[n];
	else
		cout << arr1[n];

	return 0;
}
