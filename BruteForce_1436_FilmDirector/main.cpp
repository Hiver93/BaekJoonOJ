#include <iostream>
using namespace std;
int main()
{
	int a;
	cin >> a;
	int count = 0;
	for (int i = 666; i < 200000000; i++)
	{
		int temp = i;
		int count6 = 0;
		int j = 10;
		while(temp != 0)
		{
			if (count6 == 3)
			{
				break;
			}
			if (temp % 10 == 6)
				count6++;
			else
				count6 = 0;
			temp /= 10;
		}
		if (count6 == 3)
		{
			count++;
			if (count == a)
			{
				cout << i;
				break;
			}
		}
	}
}