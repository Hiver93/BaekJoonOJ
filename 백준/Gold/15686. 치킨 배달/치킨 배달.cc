#include <iostream>
using namespace std;
int chiken[13][2];
int home[100][2];
int result[13];
int n;
int m;
int cIdx = 0;
int hIdx = 0;
int ans = 2147480000;

void func(int current, int idx)
{
	if (current == m)
		return;
	if (idx == cIdx)
		return;
	result[current] = idx;
	int sum = 0;
	for (int i = 0; i < hIdx; ++i) 
	{
		int tmp = 2140000000;
		for (int j = 0; j <= current; ++j)
		{
			int y = home[i][0] - chiken[result[j]][0];
			int x = home[i][1] - chiken[result[j]][1];
			if (y < 0) y = (~y) + 1;
			if (x < 0) x = (~x) + 1;
			if (x + y < tmp)
				tmp = x + y;
		}
		sum += tmp;
	}
	if (sum < ans)
		ans = sum;
	func(current + 1, idx + 1);
	func(current, idx + 1);
}

int main()
{
	cin >> n;
	cin >> m;
	for (int i = 0; i < n; ++i)
	{
		for (int j = 0; j < n; ++j)
		{
			int tmp;
			cin >> tmp;
			if (tmp == 1)
			{
				home[hIdx][0] = i;
				home[hIdx][1] = j;
				hIdx++;
			}
			if (tmp == 2)
			{
				chiken[cIdx][0] = i;
				chiken[cIdx][1] = j;
				cIdx++;
			}
		}
	}
	func(0, 0);
	printf("%d", ans);

}