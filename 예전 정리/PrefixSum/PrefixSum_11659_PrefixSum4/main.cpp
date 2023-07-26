#include <iostream>
using namespace std;

int main()
{
	int m, n;
	int arr[100001]{ 0 };
	int temp;
	cin >> m >> n;
	for (int i = 1; i <= m; i++)
	{
		scanf_s("%d", &temp);
		arr[i] = arr[i - 1] + temp;
	}

	for (int i = 0; i < n; i++)
	{
		int min, max;
		scanf_s("%d %d",&min,&max);

		printf("%d\n",arr[max] - arr[min - 1]);
	}
}