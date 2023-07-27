#include <iostream>
using namespace std;

int main()
{
	int arr[1001]{ 1,1 };
	int n;

	for (int i = 2; i <= 1000; ++i)
	{
		arr[i] = (arr[i - 1] + arr[i - 2]) % 10007;
	}
	cin >> n;
	cout << arr[n];

}