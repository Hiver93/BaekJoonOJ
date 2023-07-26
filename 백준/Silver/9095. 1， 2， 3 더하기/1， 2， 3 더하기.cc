#include <iostream>
using namespace std;

int main()
{
	int n;
	int arr[12]{ 0,1,2,4 };
	for (int i = 4; i < 12; ++i)
	{
		arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
	}

	cin >> n;
	while (n--) 
	{
		int num;
		cin >> num;
		cout << arr[num] << endl;
	}
}