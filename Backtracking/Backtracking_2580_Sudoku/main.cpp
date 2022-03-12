#include <iostream>
#include <vector>
using namespace std;

bool Check(int arr[9][9], int num, int row, int col)
{
	for (int i = 0; i < 9; i++)
	{
		if (arr[i][row] == num)
			return false;
		if (arr[col][i] == num)
			return false;		
	}
	for (int i = 0; i < 3; i++)
	{
		for (int j = 0; j < 3; j++)
		{
			if (arr[(col / 3) * 3 + i][(row / 3) * 3 + j] == num)
				return false;
		}
	}
	return true;
}

bool Func(int arr[9][9], int count, int i, int j)
{
	if (!count)
		return true;
	j++;
	for (i; i < 9; i++)
	{
		for (j; j < 9; j++)
		{
			if (arr[i][j] == 0)
			{
				for (int k = 1; k < 10; k++)
				{
					if (Check(arr, k, j, i))
					{
						arr[i][j] = k;
						if (Func(arr, count - 1, i, j))
							return true;
						arr[i][j] = 0;
					}
				}
				return false;
			}
		}
		j = 0;
	}
}

int main()
{
	int arr[9][9];
	int count = 0;	

	for (int i = 0; i < 9; i++)
	{
		for (int j = 0; j < 9; j++)
		{
			cin >> arr[i][j];
			if (arr[i][j] == 0)
			{
				count++;
			}
		}
	}

	Func(arr,count,0,-1);

	for (int i = 0; i < 9; i++)
	{
		for (int j = 0; j < 9; j++)
		{
			cout << arr[i][j] << ' ';
		}
		cout << '\n';
	}
}