#include <iostream>
using namespace std;
int main()
{
	int arr[9][9];
	int ans = -1, r, c;
	for (int i = 0; i < 9; ++i)
	{
		for (int j = 0; j < 9; ++j)
		{
			int tmp;
			scanf("%d", &tmp);
			if (ans < tmp)
			{
				ans = tmp;
				r = i;
				c = j;
			}
		}
	}

	printf("%d\n%d %d", ans, r+1, c+1);
}