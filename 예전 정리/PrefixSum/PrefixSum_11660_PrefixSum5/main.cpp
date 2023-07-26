#include <iostream>
using namespace std;

int arr[1026][1026]{ 0 };
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n, m, x1, y1, x2, y2, temp;
	cin >> n >> m;
	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= n; j++)
		{
			cin >> arr[i][j];
			arr[i][j] += arr[i][j - 1];
		}
		for (int j = 1; j <= n; j++)
		{
			arr[i][j] += arr[i - 1][j];
		}
	}

	for (int i = 0; i < m; i++)
	{
		cin >> y1 >> x1 >> y2 >> x2;
		printf("%d\n", arr[y2][x2] - arr[y2][x1 - 1] - arr[y1 - 1][x2] + arr[y1 - 1][x1 - 1]);
	}
}