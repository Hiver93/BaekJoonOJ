#include <iostream>
#include <vector>
using namespace std;
int main()
{
	int n;
	cin >> n;
	vector<int> xVec(n);
	vector<int> yVec(n);
	for (int i = 0; i < n; i++)
	{
		cin >> xVec[i];
		cin >> yVec[i];
	}

	for (int i = 0; i < n; i++)
	{
		int count = 1;
		for (int j = 0; j < n; j++)
		{
			if (i == j)
				continue;
			if (xVec[i] < xVec[j])
			{
				if (yVec[i] < yVec[j])
				{
					count++;
				}
			}
		}
		printf("%d ", count);
	}

}