#include <iostream>
#include <vector>
using namespace std;

int main()
{
	vector<string> board;
	int a, b;
	int result = 3000;
	int count = 0;
	cin >> a >> b;
	board.resize(a);
	for (int i = 0; i < a; i++)
	{
		cin >> board[i];
	}
	for (int i = 0; i < a-7; i++)
	{
		for (int j = 0; j < b - 7; j++)
		{			
			for (int k = i; k < 8+i; k++)
			{
				for (int l = j; l < 8 + j; l++)
				{
					if (k % 2 == 0)
					{
						if (l % 2 == 0)
						{
							if (board[k][l] == 'W')
								count++;
						}
						else
						{
							if (board[k][l] == 'B')
								count++;
						}
					}
					else
					{
						if (l % 2 == 0)
						{
							if (board[k][l] == 'B')
								count++;
						}
						else
						{
							if (board[k][l] == 'W')
								count++;
						}
					}
				}
			}

			if (count < result)
				result = count;
			count = 0;

			for (int k = i; k < 8 + i; k++)
			{
				for (int l = j; l < 8 + j; l++)
				{
					if (k % 2 == 0)
					{
						if (l % 2 == 0)
						{
							if (board[k][l] == 'B')
								count++;
						}
						else
						{
							if (board[k][l] == 'W')
								count++;
						}
					}
					else
					{
						if (l % 2 == 0)
						{
							if (board[k][l] == 'W')
								count++;
						}
						else
						{
							if (board[k][l] == 'B')
								count++;
						}
					}
				}
			}

			if (count < result)
				result = count;
			count = 0;
		}
	}
	cout << result;
}