#include <iostream>
using namespace std;

int main()
{
	int T;
	cin >> T;

	int arr[17][17] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};

	int k, n;

	for (int q = 0; q < T; ++q)
	{
		cin >> k >> n;
		n--;

		for (int i = 1; i <= k; ++i)
		{
			arr[i][0] = 1;
			for (int j = 1; j <= n; ++j)
			{				
				arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
			}
		}

		cout << arr[k][n] << endl;

	}
}