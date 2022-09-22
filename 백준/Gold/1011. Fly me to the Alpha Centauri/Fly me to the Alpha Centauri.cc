#include <iostream>
using namespace std;

int main()
{
	unsigned int T, x, y;
	unsigned int z;
	unsigned int d;
	unsigned int speed;
	unsigned int turn;
	cin >> T;
	for (int i = 0; i < T; ++i)
	{
		d = 0;
		speed = 0;
		turn = 0;
		cin >> x >> y;
		z = y - x;

		if (z == 1)
		{
			cout << 1 << endl;
			continue;
		}

		if (z % 2 == 1)
		{
			while (z / 2 + z % 2 > d)
			{
				speed++;
				d = d + speed;
				turn++;
			}

			if (d >= z-(d-speed))
			{
				cout << turn * 2 - 1 << endl;
			}
			else
				cout << turn * 2 << endl;
		}

		else if (z % 2 == 0)
		{
			while (z / 2 > d)
			{
				speed++;
				d = d + speed;
				turn++;
			}
		    if (z / 2 == d)
		    {
		    	cout << turn * 2 << endl;
		    }
			else if (d >= z - (d - speed))
			{
				cout << turn * 2 - 1 << endl;
			}
			else if (d < z - (d - speed))
			{
				cout << turn * 2 << endl;
			}
		}

	}

}