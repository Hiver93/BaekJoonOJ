#include <iostream>
using namespace std;

bool Check(int* arr, int x, int y)
{
	if (arr[0] * x + arr[1] * y == arr[2] && arr[3] * x + arr[4] * y == arr[5])
		return 1;
	return 0;
}

int main()
{
	int arr[6];
	int x, y;
	for (int i = 0; i < 6; ++i)
		cin >> arr[i];
	for (int i = -999; i < 1000; ++i)
	{
		for (int j = -999; j < 1000; ++j)
			if (Check(arr, i, j))
			{
				cout << i << " " << j; 
				return 0;
			}
	}
}