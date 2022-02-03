#include <iostream>

bool arr[2187][2187] = { 0 };

void Func(int n, int x, int y)
{	
	if (n == 3)
	{
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				if (i == 1 && j == 1)
				{
					arr[x+i][y+j] = 0;
				}
				else
				{
					arr[x+i][y+j] = 1;
				}
			}
		}
		return;
	}
	for (int i = 0; i < 3; i++)
	{
		for (int j = 0; j < 3; j++)
		{
			if (i != 1 || j != 1)
			{
				Func(n / 3, x+i * (n / 3), y+j * (n / 3));
			}
		}
	}
}

int main()
{
	int n;
	std::cin >> n;
	Func(n,0,0);
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			if (arr[i][j] == 1)
			{
				std::cout << '*';
			}
			else
				std::cout << ' ';
		}
		std::cout << std::endl;
	}
}